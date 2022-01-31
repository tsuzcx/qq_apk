package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.FaceScanNativeSoLoader;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.FaceScanNativeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class FaceScanNativeSoDownloadHandler
  extends EarlyHandler
{
  private int a;
  private boolean d;
  
  public FaceScanNativeSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.face.so_v7.2.0", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10061;
  }
  
  public Class a()
  {
    return FaceScanNativeSoData.class;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("face_scan_sp", 4).edit().putInt("face_scan_native_so_version", b()).apply();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.jdField_a_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    FaceScanDownloadManager.a(1, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download progress: " + this.jdField_a_of_type_Int);
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      FaceScanDownloadManager.a(1, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download finish: " + paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download success: " + paramString);
    }
    if (FaceScanNativeSoLoader.a(paramString) != 0)
    {
      f();
      a();
      FaceScanDownloadManager.a(1, false);
    }
    for (;;)
    {
      super.a(paramString);
      return;
      FaceScanDownloadManager.a(1, true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008358", "0X8008358", 0, 0, "", "", "so", "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("res_type", "so");
      StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "FaceResDownloadSuccess", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.d) {
      this.d = paramBoolean;
    }
    super.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download restart userClick" + paramBoolean);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return "prd";
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download begin");
    }
  }
  
  public boolean e_()
  {
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.e_();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "restoreState");
    }
    a().loadState = 0;
    a().Version = 0;
    EarlyDataFactory.a(a(), new String[0]);
  }
  
  public boolean f()
  {
    if (!this.d)
    {
      if (!FaceScanDownloadManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceScanNativeSoDownloadHandler", 2, "pre download config disable ");
        }
        return false;
      }
      if (BaseActivity.sTopActivity == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoDownloadHandler", 2, "downloadResource later " + bool);
      }
      if (bool) {
        break;
      }
      return super.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.FaceScanNativeSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */