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
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        do
        {
          return localEmoticonGuideConfBean;
          paramJSONObject = paramJSONObject.optJSONObject("emoticon_guide_config");
        } while (paramJSONObject == null);
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
      } while (!paramJSONObject.has("emoticon_guide_invalid_time"));
      paramJSONObject = paramJSONObject.optString("emoticon_guide_invalid_time", null);
    } while (TextUtils.isEmpty(paramJSONObject));
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
    return localEmoticonGuideConfBean;
  }
  
  boolean a()
  {
    try
    {
      String str1 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      if (TextUtils.isEmpty(str1)) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      String str2;
      for (;;)
      {
        QLog.e("QQSysAndEmojiConfProcessor", 1, "getAccount faild ！！！");
        str2 = null;
      }
      int i = ((Integer)BaseSharedPreUtil.a(BaseApplication.getContext(), str2, "key_emoticon_guide_version", Integer.valueOf(0))).intValue();
      if (this.jdField_b_of_type_Int > i)
      {
        BaseSharedPreUtil.a(BaseApplication.getContext(), str2, true, "key_emoticon_guide_version", Integer.valueOf(this.jdField_b_of_type_Int));
        BaseSharedPreUtil.a(BaseApplication.getContext(), str2, true, "key_show_emoticon_guide", Boolean.valueOf(true));
        return true;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQSysAndEmojiConfProcessor", 2, "currentTimeMillis: " + System.currentTimeMillis() + " mInvalidTime: " + this.jdField_a_of_type_Long);
    }
    return (this.jdField_a_of_type_Int == 1) && (System.currentTimeMillis() < this.jdField_a_of_type_Long);
  }
  
  public String toString()
  {
    return "{mOpen=" + this.jdField_a_of_type_Int + ", mDrawableUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mNightDrawableUrl=" + this.jdField_b_of_type_JavaLangString + ", mServerId=" + this.c + ", mEmoType=" + this.d + ", mInvalidTime=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.EmoticonGuideConfBean
 * JD-Core Version:    0.7.0.1
 */