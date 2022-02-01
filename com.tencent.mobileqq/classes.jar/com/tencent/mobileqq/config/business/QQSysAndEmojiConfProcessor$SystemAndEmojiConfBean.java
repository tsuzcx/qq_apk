package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSysAndEmojiConfProcessor$SystemAndEmojiConfBean
{
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
  }
  
  public static SystemAndEmojiConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    SystemAndEmojiConfBean localSystemAndEmojiConfBean = new SystemAndEmojiConfBean();
    int j;
    int i;
    try
    {
      j = paramArrayOfQConfItem.length;
      i = 0;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      boolean bool;
      QLog.d("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfQConfItem);
      return localSystemAndEmojiConfBean;
    }
    Object localObject = ((QConfItem)localObject).jdField_a_of_type_JavaLangString;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("config_url")) {
          localSystemAndEmojiConfBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("config_url");
        }
        if (localJSONObject.has("config_md5")) {
          localSystemAndEmojiConfBean.b = localJSONObject.optString("config_md5");
        }
        if (localJSONObject.has("sysface_res_url")) {
          localSystemAndEmojiConfBean.c = localJSONObject.optString("sysface_res_url");
        }
        if (localJSONObject.has("sysface_res_md5")) {
          localSystemAndEmojiConfBean.d = localJSONObject.optString("sysface_res_md5");
        }
        if (localJSONObject.has("emoji_res_url")) {
          localSystemAndEmojiConfBean.e = localJSONObject.optString("emoji_res_url");
        }
        if (localJSONObject.has("emoji_res_md5")) {
          localSystemAndEmojiConfBean.f = localJSONObject.optString("emoji_res_md5");
        }
        localSystemAndEmojiConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$EmoticonGuideConfBean = QQSysAndEmojiConfProcessor.EmoticonGuideConfBean.a(localJSONObject);
        localSystemAndEmojiConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$AnimEmoCountConfBean = QQSysAndEmojiConfProcessor.AnimEmoCountConfBean.a(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean: " + (String)localObject);
      }
    }
    label283:
    for (;;)
    {
      localSystemAndEmojiConfBean.a();
      return localSystemAndEmojiConfBean;
      for (;;)
      {
        if (i >= j) {
          break label283;
        }
        localObject = paramArrayOfQConfItem[i];
        if (localObject != null) {
          break;
        }
        i += 1;
      }
    }
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
    new StringBuilder().append(", mConfigUrl:").append(this.jdField_a_of_type_JavaLangString).append(", mConfigMD5:").append(this.b).append(", mSysFaceUrl").append(this.c).append(", mSysFaceMD5").append(this.d).append(", mEmojiUrl").append(this.e).append(", mEmojiMD5").append(this.f).append(", mEmoticonGuideConfBean").append(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQSysAndEmojiConfProcessor$EmoticonGuideConfBean.toString());
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean
 * JD-Core Version:    0.7.0.1
 */