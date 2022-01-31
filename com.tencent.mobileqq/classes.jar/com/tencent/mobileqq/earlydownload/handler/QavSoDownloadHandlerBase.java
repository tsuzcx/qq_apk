package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoDataBase;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class QavSoDownloadHandlerBase
  extends EarlyHandler
{
  public QavSoDownloadHandlerBase(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
  }
  
  public int a()
  {
    return 10048;
  }
  
  public String a()
  {
    return "qavDownloadSoDuration";
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp begins, respData" + paramXmlData);
    }
    if ((paramXmlData == null) || (!(paramXmlData instanceof QavSoDataBase)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp ends. respData is not QavSoDataBase");
      }
      super.a(paramXmlData);
      return;
    }
    QavSoDataBase localQavSoDataBase = (QavSoDataBase)paramXmlData;
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "doOnServerResp url:" + paramXmlData.strResURL_big + ", md5:" + paramXmlData.MD5 + ", m_TcHevcDec =" + localQavSoDataBase.m_TcHevcDec);
    }
    super.a(paramXmlData);
  }
  
  public void a(String paramString)
  {
    XmlData localXmlData = a();
    String str1;
    SharedPreferences localSharedPreferences;
    if (localXmlData != null)
    {
      str1 = "QAVSOMD5__" + localXmlData.getSharedPreferencesName();
      localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
      String str2 = localSharedPreferences.getString(str1, null);
      if (QLog.isColorLevel()) {
        QLog.d("QavSoDownloadHandlerBase", 2, "download success: " + paramString + "|" + str2 + "|" + localXmlData.MD5 + "|" + localXmlData);
      }
      if (((TextUtils.isEmpty(localXmlData.MD5)) || (localXmlData.MD5.equals(str2))) && (UpdateAvSo.a(this.a.getApp().getApplicationContext()))) {}
    }
    try
    {
      FileUtils.a(paramString, UpdateAvSo.a(), false);
      localSharedPreferences.edit().putString(str1, localXmlData.MD5).commit();
      super.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandlerBase
 * JD-Core Version:    0.7.0.1
 */