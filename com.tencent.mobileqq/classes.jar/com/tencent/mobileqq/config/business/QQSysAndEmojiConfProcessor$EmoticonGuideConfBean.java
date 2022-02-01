package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QQSysAndEmojiConfProcessor$EmoticonGuideConfBean
{
  public int a = 0;
  public int b = 0;
  public String c = "";
  public String d = "";
  public int e = -1;
  public int f = -1;
  public long g;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  
  public static EmoticonGuideConfBean a(JSONObject paramJSONObject)
  {
    EmoticonGuideConfBean localEmoticonGuideConfBean = new EmoticonGuideConfBean();
    if (paramJSONObject == null) {
      return localEmoticonGuideConfBean;
    }
    paramJSONObject = paramJSONObject.optJSONObject("emoticon_guide_config");
    if (paramJSONObject == null) {
      return localEmoticonGuideConfBean;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQSysAndEmojiConfProcessor", 2, "parse GuideConfBean: ");
    }
    if (paramJSONObject.has("emoticon_guide_url")) {
      localEmoticonGuideConfBean.c = paramJSONObject.optString("emoticon_guide_url");
    }
    if (paramJSONObject.has("emoticon_guide_night_url")) {
      localEmoticonGuideConfBean.d = paramJSONObject.optString("emoticon_guide_night_url");
    }
    if (paramJSONObject.has("emoticon_guide_serverid")) {
      localEmoticonGuideConfBean.e = paramJSONObject.optInt("emoticon_guide_serverid", -1);
    }
    if (paramJSONObject.has("emoticon_guide_serverid_type")) {
      localEmoticonGuideConfBean.f = paramJSONObject.optInt("emoticon_guide_serverid_type", -1);
    }
    if (paramJSONObject.has("emoticon_guide_width")) {
      localEmoticonGuideConfBean.h = paramJSONObject.optInt("emoticon_guide_width", 0);
    }
    if (paramJSONObject.has("emoticon_guide_height")) {
      localEmoticonGuideConfBean.i = paramJSONObject.optInt("emoticon_guide_height", 0);
    }
    if (paramJSONObject.has("emoticon_guide_open")) {
      localEmoticonGuideConfBean.a = paramJSONObject.optInt("emoticon_guide_open", 0);
    }
    if (paramJSONObject.has("emoticon_guide_version")) {
      localEmoticonGuideConfBean.b = paramJSONObject.optInt("emoticon_guide_version", 0);
    }
    if (paramJSONObject.has("emoticon_guide_time")) {
      localEmoticonGuideConfBean.j = paramJSONObject.optInt("emoticon_guide_time", 0);
    }
    if (paramJSONObject.has("emoticon_guide_invalid_time"))
    {
      paramJSONObject = paramJSONObject.optString("emoticon_guide_invalid_time", null);
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        try
        {
          localEmoticonGuideConfBean.g = localSimpleDateFormat.parse(paramJSONObject).getTime();
          return localEmoticonGuideConfBean;
        }
        catch (Exception paramJSONObject)
        {
          QLog.d("QQSysAndEmojiConfProcessor", 2, "parse invalidTime failed!", paramJSONObject);
        }
      }
    }
    return localEmoticonGuideConfBean;
  }
  
  boolean a()
  {
    Object localObject = null;
    try
    {
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      label18:
      int k;
      break label18;
    }
    QLog.e("QQSysAndEmojiConfProcessor", 1, "getAccount faild ！！！");
    if (TextUtils.isEmpty(localObject)) {
      return false;
    }
    k = ((Integer)BaseSharedPreUtil.a(BaseApplication.getContext(), localObject, "key_emoticon_guide_version", Integer.valueOf(0))).intValue();
    if (this.b > k)
    {
      BaseSharedPreUtil.a(BaseApplication.getContext(), localObject, true, "key_emoticon_guide_version", Integer.valueOf(this.b));
      BaseSharedPreUtil.a(BaseApplication.getContext(), localObject, true, "key_show_emoticon_guide", Boolean.valueOf(true));
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("currentTimeMillis: ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(" mInvalidTime: ");
      localStringBuilder.append(this.g);
      QLog.i("QQSysAndEmojiConfProcessor", 2, localStringBuilder.toString());
    }
    return (this.a == 1) && (System.currentTimeMillis() < this.g);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{mOpen=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mDrawableUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mNightDrawableUrl=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mServerId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mEmoType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mInvalidTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.EmoticonGuideConfBean
 * JD-Core Version:    0.7.0.1
 */