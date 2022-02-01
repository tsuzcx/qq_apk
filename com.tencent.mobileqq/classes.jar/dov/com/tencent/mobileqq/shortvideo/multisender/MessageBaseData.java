package dov.com.tencent.mobileqq.shortvideo.multisender;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageBaseData
{
  public int a;
  public long a;
  public String a;
  
  public static String a(List<MessageBaseData> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((MessageBaseData)paramList.next()).a()).append(";");
    }
    return localStringBuilder.toString();
  }
  
  public static List<MessageBaseData> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split(";");
    if ((paramString == null) || (paramString.length == 0)) {
      return localArrayList;
    }
    int j = paramString.length;
    int i = 0;
    label31:
    CharSequence localCharSequence;
    if (i < j)
    {
      localCharSequence = paramString[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        break label56;
      }
    }
    for (;;)
    {
      i += 1;
      break label31;
      break;
      label56:
      MessageBaseData localMessageBaseData = new MessageBaseData();
      localMessageBaseData.a(localCharSequence);
      localArrayList.add(localMessageBaseData);
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append("_").append(this.jdField_a_of_type_Int).append("_").append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
  
  public void a(String paramString)
  {
    String[] arrayOfString = paramString.split("_");
    if (arrayOfString.length != 3) {
      throw new IllegalArgumentException(paramString + " illegal MessageBaseData!");
    }
    this.jdField_a_of_type_JavaLangString = arrayOfString[0];
    this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[1]).intValue();
    this.jdField_a_of_type_Long = Long.valueOf(arrayOfString[2]).longValue();
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    return (this.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.jdField_a_of_type_Int == paramInt) && (this.jdField_a_of_type_Long == paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.multisender.MessageBaseData
 * JD-Core Version:    0.7.0.1
 */