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
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c = -1;
  public int d = -1;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  
  public QQSysAndEmojiConfProcessor$EmoticonGuideConfBean()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
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
      localEmoticonGuideConfBean.jdField_a_of_type_JavaLangString = paramJSONObject.optString("emoticon_guide_url");
    }
    if (paramJSONObject.has("emoticon_guide_night_url")) {
      localEmoticonGuideConfBean.jdField_b_of_type_JavaLangString = paramJSONObject.optString("emoticon_guide_night_url");
    }
    if (paramJSONObject.has("emoticon_guide_serverid")) {
      localEmoticonGuideConfBean.c = paramJSONObject.optInt("emoticon_guide_serverid", -1);
    }
    if (paramJSONObject.has("emoticon_guide_serverid_type")) {
      localEmoticonGuideConfBean.d = paramJSONObject.optInt("emoticon_guide_serverid_type", -1);
    }
    if (paramJSONObject.has("emoticon_guide_width")) {
      localEmoticonGuideConfBean.e = paramJSONObject.optInt("emoticon_guide_width", 0);
    }
    if (paramJSONObject.has("emoticon_guide_height")) {
      localEmoticonGuideConfBean.f = paramJSONObject.optInt("emoticon_guide_height", 0);
    }
    if (paramJSONObject.has("emoticon_guide_open")) {
      localEmoticonGuideConfBean.jdField_a_of_type_Int = paramJSONObject.optInt("emoticon_guide_open", 0);
    }
    if (paramJSONObject.has("emoticon_guide_version")) {
      localEmoticonGuideConfBean.jdField_b_of_type_Int = paramJSONObject.optInt("emoticon_guide_version", 0);
    }
    if (paramJSONObject.has("emoticon_guide_time")) {
      localEmoticonGuideConfBean.g = paramJSONObject.optInt("emoticon_guide_time", 0);
    }
    if (paramJSONObject.has("emoticon_guide_invalid_time"))
    {
      paramJSONObject = paramJSONObject.optString("emoticon_guide_invalid_time", null);
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        try
        {
          localEmoticonGuideConfBean.jdField_a_of_type_Long = localSimpleDateFormat.parse(paramJSONObject).getTime();
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
      int i;
      break label18;
    }
    QLog.e("QQSysAndEmojiConfProcessor", 1, "getAccount faild ！！！");
    if (TextUtils.isEmpty(localObject)) {
      return false;
    }
    i = ((Integer)BaseSharedPreUtil.a(BaseApplication.getContext(), localObject, "key_emoticon_guide_version", Integer.valueOf(0))).intValue();
    if (this.jdField_b_of_type_Int > i)
    {
      BaseSharedPreUtil.a(BaseApplication.getContext(), localObject, true, "key_emoticon_guide_version", Integer.valueOf(this.jdField_b_of_type_Int));
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
      localStringBuilder.append(this.jdField_a_of_type_Long);
      QLog.i("QQSysAndEmojiConfProcessor", 2, localStringBuilder.toString());
    }
    return (this.jdField_a_of_type_Int == 1) && (System.currentTimeMillis() < this.jdField_a_of_type_Long);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{mOpen=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mDrawableUrl='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mNightDrawableUrl=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mServerId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mEmoType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mInvalidTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.EmoticonGuideConfBean
 * JD-Core Version:    0.7.0.1
 */