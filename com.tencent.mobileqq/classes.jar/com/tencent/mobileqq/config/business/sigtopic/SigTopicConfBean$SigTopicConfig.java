package com.tencent.mobileqq.config.business.sigtopic;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SigTopicConfBean$SigTopicConfig
  implements IQStorageSafable<String>
{
  public String a = "";
  public ArrayList<SigTopicConfBean.TopicInfo> b = new ArrayList();
  private String c = "place_holder";
  private String d = "data";
  private String e = "topic_id";
  private String f = "topic_name";
  
  public void a(String paramString)
  {
    this.b.clear();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("SigTopicConfig", 1, "SigTopic config content is empty");
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONArray(this.d);
        this.a = localJSONObject.optString(this.c, HardCodeUtil.a(2131911564));
        if (paramString == null) {
          break label192;
        }
        i = 0;
        if (i >= paramString.length()) {
          break label192;
        }
        localJSONObject = paramString.getJSONObject(i);
        localTopicInfo = new SigTopicConfBean.TopicInfo();
        localTopicInfo.a = localJSONObject.optInt(this.e);
        localTopicInfo.b = localJSONObject.optString(this.f);
        if (!TextUtils.isEmpty(localTopicInfo.b)) {
          break label198;
        }
        if (!QLog.isColorLevel()) {
          break label193;
        }
        QLog.e("SigTopicConfig", 2, new Object[] { "SigTopic config parse has invalid item,index=", Integer.valueOf(i) });
      }
      catch (JSONException paramString)
      {
        int i;
        SigTopicConfBean.TopicInfo localTopicInfo;
        QLog.e("SigTopicConfig", 1, "SigTopic config parse exception", paramString);
      }
      if (j != 0) {
        this.b.add(localTopicInfo);
      }
      i += 1;
      continue;
      label192:
      return;
      label193:
      int j = 0;
      continue;
      label198:
      j = 1;
    }
  }
  
  public String toString()
  {
    if (this.b.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recommend title is ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.b.toString());
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean.SigTopicConfig
 * JD-Core Version:    0.7.0.1
 */