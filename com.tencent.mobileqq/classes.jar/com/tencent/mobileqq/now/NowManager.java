package com.tencent.mobileqq.now;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class NowManager
  implements Manager
{
  public static String a;
  static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private final int jdField_a_of_type_Int = 86400;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaLangString = NowAppHelper.jdField_a_of_type_JavaLangString;
  }
  
  public NowManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("key_now_conf", 0);
  }
  
  public ChannelResponse a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if ((!this.jdField_a_of_type_AndroidContentSharedPreferences.contains("key_isDownload")) || (!this.jdField_a_of_type_AndroidContentSharedPreferences.contains("key_downloadTime")) || (!this.jdField_a_of_type_AndroidContentSharedPreferences.contains("key_updateInternal")) || (!this.jdField_a_of_type_AndroidContentSharedPreferences.contains("key_apkUrl")) || (!this.jdField_a_of_type_AndroidContentSharedPreferences.contains("key_client_action"))) {
        return null;
      }
      ChannelResponse localChannelResponse = new ChannelResponse();
      localChannelResponse.error_code = 0;
      localChannelResponse.downloadLink = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_apkUrl", "");
      localChannelResponse.isDownload = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_isDownload", 0);
      localChannelResponse.downloadTime = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_downloadTime", 0L);
      localChannelResponse.updateInternal = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_updateInternal", 86400);
      localChannelResponse.md5sum = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_md5", "");
      localChannelResponse.client_action = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_client_action", 0);
      localChannelResponse.h5_url = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_h5Url", "");
      return localChannelResponse;
    }
  }
  
  public void a(ChannelResponse paramChannelResponse)
  {
    if (paramChannelResponse != null) {}
    for (;;)
    {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putInt("key_isDownload", paramChannelResponse.isDownload);
        localEditor.putInt("key_updateInternal", paramChannelResponse.updateInternal);
        localEditor.putLong("key_downloadTime", paramChannelResponse.downloadTime);
        localEditor.putString("key_apkUrl", paramChannelResponse.downloadLink);
        localEditor.putString("key_md5", paramChannelResponse.md5sum);
        localEditor.putInt("key_client_action", paramChannelResponse.client_action);
        localEditor.putLong("key_lastTime", System.currentTimeMillis() / 1000L);
        if (TextUtils.isEmpty(paramChannelResponse.h5_url)) {
          break label155;
        }
        paramChannelResponse = paramChannelResponse.h5_url;
        localEditor.putString("key_h5Url", paramChannelResponse);
        localEditor.commit();
        return;
      }
      return;
      label155:
      paramChannelResponse = "";
    }
  }
  
  public boolean a(ChannelResponse paramChannelResponse)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_lastTime", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkChannelConf, resp=" + paramChannelResponse + ", lastTime=" + l2 + ", currTime=" + l1);
    }
    if ((paramChannelResponse == null) || (TextUtils.isEmpty(paramChannelResponse.downloadLink))) {}
    while (l1 > l2 + paramChannelResponse.updateInternal) {
      return true;
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowManager
 * JD-Core Version:    0.7.0.1
 */