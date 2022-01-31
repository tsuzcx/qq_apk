package com.tencent.mobileqq.utils.confighandler;

import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class QAVFunCallConfig
  extends ConfigInfo
{
  public static final String TAG = "QAVConfig_382";
  final TreeMap<Integer, QAVFunCallConfig.FCItem> fcItems = new TreeMap();
  
  public int getActivityFCId()
  {
    Iterator localIterator = this.fcItems.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (ConfigUtil.isActivity(((QAVFunCallConfig.FCItem)localEntry.getValue()).begin, ((QAVFunCallConfig.FCItem)localEntry.getValue()).end)) {
        return ((QAVFunCallConfig.FCItem)localEntry.getValue()).fcid;
      }
    }
    return 0;
  }
  
  public QAVFunCallConfig.FCItem getFCItem(int paramInt)
  {
    Iterator localIterator = this.fcItems.values().iterator();
    while (localIterator.hasNext())
    {
      QAVFunCallConfig.FCItem localFCItem = (QAVFunCallConfig.FCItem)localIterator.next();
      if (localFCItem.fcid == paramInt) {
        return localFCItem;
      }
    }
    return null;
  }
  
  protected boolean parse(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    ConfigHandler.checkUin("QAVConfig_382", this.mUin);
    for (;;)
    {
      boolean bool1;
      int i;
      try
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        paramJSONObject = paramJSONObject.optJSONArray("list");
        bool1 = bool2;
        if (paramJSONObject != null)
        {
          bool1 = bool2;
          if (paramJSONObject.length() > 0)
          {
            i = 0;
            bool1 = bool2;
            if (i < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
              if ((!localJSONObject.has("fcid")) || (!localJSONObject.has("begin")) || (!localJSONObject.has("end")) || (!localJSONObject.has("media")))
              {
                QLog.w("QAVConfig_382", 1, "parse, 缺少字段，[" + localJSONObject.toString() + "]");
              }
              else
              {
                QAVFunCallConfig.FCItem localFCItem = new QAVFunCallConfig.FCItem();
                localFCItem.fcid = localJSONObject.optInt("fcid");
                localFCItem.begin = localSimpleDateFormat.parse(localJSONObject.optString("begin")).getTime();
                localFCItem.end = localSimpleDateFormat.parse(localJSONObject.optString("end")).getTime();
                localFCItem.media = localJSONObject.optString("media");
                this.fcItems.put(Integer.valueOf(localFCItem.fcid), localFCItem);
              }
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        this.fcItems.clear();
        QLog.w("QAVConfig_382", 1, "parseJson, Exception", paramJSONObject);
        bool1 = false;
      }
      return bool1;
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("Size[").append(this.fcItems.size()).append("]");
    Iterator localIterator = this.fcItems.values().iterator();
    while (localIterator.hasNext())
    {
      QAVFunCallConfig.FCItem localFCItem = (QAVFunCallConfig.FCItem)localIterator.next();
      localStringBuilder.append("\n").append(localFCItem);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig
 * JD-Core Version:    0.7.0.1
 */