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
    ConfigHandler.checkUin("QAVConfig_382", this.mUin);
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      paramJSONObject = paramJSONObject.optJSONArray("list");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          Object localObject;
          if ((localJSONObject.has("fcid")) && (localJSONObject.has("begin")) && (localJSONObject.has("end")) && (localJSONObject.has("media")))
          {
            localObject = new QAVFunCallConfig.FCItem();
            ((QAVFunCallConfig.FCItem)localObject).fcid = localJSONObject.optInt("fcid");
            ((QAVFunCallConfig.FCItem)localObject).begin = localSimpleDateFormat.parse(localJSONObject.optString("begin")).getTime();
            ((QAVFunCallConfig.FCItem)localObject).end = localSimpleDateFormat.parse(localJSONObject.optString("end")).getTime();
            ((QAVFunCallConfig.FCItem)localObject).media = localJSONObject.optString("media");
            this.fcItems.put(Integer.valueOf(((QAVFunCallConfig.FCItem)localObject).fcid), localObject);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("parse, 缺少字段，[");
            ((StringBuilder)localObject).append(localJSONObject.toString());
            ((StringBuilder)localObject).append("]");
            QLog.w("QAVConfig_382", 1, ((StringBuilder)localObject).toString());
          }
          i += 1;
        }
      }
      return true;
    }
    catch (Exception paramJSONObject)
    {
      this.fcItems.clear();
      QLog.w("QAVConfig_382", 1, "parseJson, Exception", paramJSONObject);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("Size[");
    localStringBuilder.append(this.fcItems.size());
    localStringBuilder.append("]");
    Iterator localIterator = this.fcItems.values().iterator();
    while (localIterator.hasNext())
    {
      QAVFunCallConfig.FCItem localFCItem = (QAVFunCallConfig.FCItem)localIterator.next();
      localStringBuilder.append("\n");
      localStringBuilder.append(localFCItem);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig
 * JD-Core Version:    0.7.0.1
 */