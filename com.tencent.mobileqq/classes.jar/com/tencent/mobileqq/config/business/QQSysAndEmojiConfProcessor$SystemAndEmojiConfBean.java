package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSysAndEmojiConfProcessor$SystemAndEmojiConfBean
{
  public int a;
  public QQSysAndEmojiConfProcessor.AnimEmoCountConfBean a;
  public QQSysAndEmojiConfProcessor.EmoticonGuideConfBean a;
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public QQSysAndEmojiConfProcessor$SystemAndEmojiConfBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$EmoticonGuideConfBean = new QQSysAndEmojiConfProcessor.EmoticonGuideConfBean();
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$AnimEmoCountConfBean = new QQSysAndEmojiConfProcessor.AnimEmoCountConfBean();
    this.jdField_a_of_type_Int = 3;
  }
  
  public static SystemAndEmojiConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    SystemAndEmojiConfBean localSystemAndEmojiConfBean = new SystemAndEmojiConfBean();
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length < 1) {
        return localSystemAndEmojiConfBean;
      }
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramArrayOfQConfItem)) {
        return localSystemAndEmojiConfBean;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.i("QQSysAndEmojiConfProcessor", 2, localStringBuilder.toString());
      }
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
        if (paramArrayOfQConfItem.has("config_url"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ConfigUrl=");
          localStringBuilder.append(paramArrayOfQConfItem.optString("config_url"));
          ABTestUtil.a("QQSysAndEmojiConfProcessor", localStringBuilder.toString());
          localSystemAndEmojiConfBean.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.optString("config_url");
        }
        if (paramArrayOfQConfItem.has("config_md5")) {
          localSystemAndEmojiConfBean.b = paramArrayOfQConfItem.optString("config_md5");
        }
        if (paramArrayOfQConfItem.has("sysface_apng_res_url")) {
          localSystemAndEmojiConfBean.c = paramArrayOfQConfItem.optString("sysface_apng_res_url");
        } else if (paramArrayOfQConfItem.has("sysface_res_url")) {
          localSystemAndEmojiConfBean.c = paramArrayOfQConfItem.optString("sysface_res_url");
        }
        if (paramArrayOfQConfItem.has("sysface_apng_res_md5")) {
          localSystemAndEmojiConfBean.d = paramArrayOfQConfItem.optString("sysface_apng_res_md5");
        } else if (paramArrayOfQConfItem.has("sysface_res_md5")) {
          localSystemAndEmojiConfBean.d = paramArrayOfQConfItem.optString("sysface_res_md5");
        }
        if (paramArrayOfQConfItem.has("emoji_res_url")) {
          localSystemAndEmojiConfBean.e = paramArrayOfQConfItem.optString("emoji_res_url");
        }
        if (paramArrayOfQConfItem.has("emoji_res_md5")) {
          localSystemAndEmojiConfBean.f = paramArrayOfQConfItem.optString("emoji_res_md5");
        }
        if (paramArrayOfQConfItem.has("sysface_recent_line_cnt"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sysFaceLineCnt=");
          localStringBuilder.append(paramArrayOfQConfItem.optInt("sysface_recent_line_cnt", 0));
          ABTestUtil.a("QQSysAndEmojiConfProcessor", localStringBuilder.toString());
          localSystemAndEmojiConfBean.jdField_a_of_type_Int = paramArrayOfQConfItem.optInt("sysface_recent_line_cnt", 3);
        }
        localSystemAndEmojiConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$EmoticonGuideConfBean = QQSysAndEmojiConfProcessor.EmoticonGuideConfBean.a(paramArrayOfQConfItem);
        localSystemAndEmojiConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$AnimEmoCountConfBean = QQSysAndEmojiConfProcessor.AnimEmoCountConfBean.a(paramArrayOfQConfItem);
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
      localSystemAndEmojiConfBean.a();
    }
    return localSystemAndEmojiConfBean;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$EmoticonGuideConfBean.a())
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$EmoticonGuideConfBean.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
      str = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$EmoticonGuideConfBean.b;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", mConfigUrl:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mConfigMD5:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mSysFaceUrl");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mSysFaceMD5");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mEmojiUrl");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mEmojiMD5");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mEmoticonGuideConfBean");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$EmoticonGuideConfBean.toString());
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean
 * JD-Core Version:    0.7.0.1
 */