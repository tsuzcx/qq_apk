package com.tencent.mobileqq.qqguildsdk.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GProSdkConfigBean
  implements IQStorageSafable<String>
{
  public String a = "";
  public String b = "";
  
  private void a()
  {
    this.a = "groupprohead-76292.picgzc.qpic.cn";
    this.b = "groupprocover-76483.picgzc.qpic.cn";
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("configID:748 onParse GProSdkConfig:");
    localStringBuilder.append(paramString);
    QLog.i("【gpro_sdk】GProSdkConfigBean", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.toLowerCase();
    } else {
      paramString = "";
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("【gpro_sdk】GProSdkConfigBean", 1, "GProSdkConfigContent is empty, configID:748 use default value");
      a();
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("head_domain")) {
        this.a = paramString.getString("head_domain");
      } else {
        this.a = "groupprohead-76292.picgzc.qpic.cn";
      }
      if (paramString.has("cover_domain"))
      {
        this.b = paramString.getString("cover_domain");
        return;
      }
      this.b = "groupprocover-76483.picgzc.qpic.cn";
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("【gpro_sdk】GProSdkConfigBean", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.config.GProSdkConfigBean
 * JD-Core Version:    0.7.0.1
 */