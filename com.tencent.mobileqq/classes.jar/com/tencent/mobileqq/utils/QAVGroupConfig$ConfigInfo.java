package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class QAVGroupConfig$ConfigInfo
{
  int a = 0;
  HashMap<String, QAVGroupConfig.URLInfo> b = new HashMap();
  int c = 40;
  int d = 9;
  int e = 9;
  int f = 20;
  
  static ConfigInfo b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        ConfigInfo localConfigInfo = new ConfigInfo();
        localConfigInfo.a = paramString.optInt("task_id");
        if (paramString.has("max_gaudio_member")) {
          localConfigInfo.c = paramString.optInt("max_gaudio_member");
        }
        if (paramString.has("max_select_num")) {
          localConfigInfo.d = paramString.optInt("max_select_num");
        }
        if (paramString.has("show_invite_box")) {
          localConfigInfo.f = paramString.optInt("show_invite_box");
        }
        if (paramString.has("auto_select_num")) {
          localConfigInfo.e = paramString.optInt("auto_select_num");
        }
        return localConfigInfo;
      }
      catch (Exception paramString)
      {
        QLog.d("QAVGroupConfig", 1, "parseJson, Exception", paramString);
      }
    }
    return new ConfigInfo();
  }
  
  public QAVGroupConfig.URLInfo a(String paramString)
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.b.entrySet().iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (QAVGroupConfig.URLInfo)((Map.Entry)localObject2).getValue();
      if (l > ((QAVGroupConfig.URLInfo)localObject2).a) {
        localIterator.remove();
      } else if ((localObject1 == null) && (TextUtils.equals(paramString, str))) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      long l = 600000L;
      if (QQAudioHelper.b()) {
        l = 60000L;
      }
      QAVGroupConfig.URLInfo localURLInfo = new QAVGroupConfig.URLInfo();
      localURLInfo.a = (System.currentTimeMillis() + l);
      localURLInfo.b = paramString2;
      localURLInfo.c = paramString3;
      this.b.put(paramString1, localURLInfo);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task_id[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], max_gaudio_member[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], max_select_num[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], show_invite_box[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], auto_select_num[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVGroupConfig.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */