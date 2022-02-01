package cooperation.qzone.statistic.access;

import cooperation.qzone.statistic.access.concept.Assembler;
import cooperation.qzone.statistic.access.concept.Key;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.QZLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class HttpAssembler
  extends Assembler
{
  protected Statistic publicField = null;
  
  public static String utf8encode(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    try
    {
      String str = URLEncoder.encode(paramObject.toString(), "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramObject.toString();
  }
  
  public String assemble(List<Statistic> paramList)
  {
    int i = paramList.size();
    String str = format(null, this.publicField);
    if (i == 0) {
      return str;
    }
    if (i == 1) {
      return format(str, (Statistic)paramList.get(0));
    }
    return format(str, paramList);
  }
  
  public String format(String paramString, Statistic paramStatistic)
  {
    Key[] arrayOfKey = paramStatistic.getKeys();
    paramStatistic = paramStatistic.getValues();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null) {
      localStringBuilder.append(paramString);
    }
    int i = 0;
    while (i < arrayOfKey.length)
    {
      if (paramStatistic[i] != null)
      {
        Object localObject = paramStatistic[i];
        paramString = "";
        if (!localObject.equals(""))
        {
          if (localStringBuilder.length() != 0) {
            paramString = "&";
          }
          localStringBuilder.append(paramString);
          localStringBuilder.append(arrayOfKey[i]);
          localStringBuilder.append("=");
          localStringBuilder.append(utf8encode(paramStatistic[i]));
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String format(String paramString, List<Statistic> paramList)
  {
    StringBuilder localStringBuilder;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      localStringBuilder = new StringBuilder();
      if (paramString == null) {}
    }
    for (;;)
    {
      try
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append("&");
        paramString = ((Statistic)paramList.get(0)).getKeys();
        localStringBuilder.append("key=");
        i = 0;
        if (i >= paramString.length) {
          break label243;
        }
        Object localObject = paramString[i].getName();
        if (i != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append((String)localObject);
        i += 1;
        continue;
        if (i < paramString.length)
        {
          int j = 0;
          if (j >= paramList.size()) {
            break label248;
          }
          localObject = (Statistic)paramList.get(j);
          localStringBuilder.append("&");
          j += 1;
          localStringBuilder.append(j);
          localStringBuilder.append("_");
          localStringBuilder.append(i + 1);
          localStringBuilder.append("=");
          localStringBuilder.append(utf8encode(((Statistic)localObject).getValue(i)));
          continue;
        }
        localStringBuilder.append("&count=");
        localStringBuilder.append(paramList.size());
        return localStringBuilder.toString();
      }
      catch (OutOfMemoryError paramString)
      {
        QZLog.e("HttpAssembler", "", paramString);
      }
      return null;
      label243:
      int i = 0;
      continue;
      label248:
      i += 1;
    }
  }
  
  public Statistic getPublicField()
  {
    return this.publicField;
  }
  
  public void setPublicField(Statistic paramStatistic)
  {
    this.publicField = paramStatistic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.statistic.access.HttpAssembler
 * JD-Core Version:    0.7.0.1
 */