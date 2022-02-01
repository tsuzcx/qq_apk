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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class FaceScanNativeSoDownloadHandler
  extends EarlyHandler
{
  private int a;
  private boolean d = false;
  
  public FaceScanNativeSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.face.so_v8.5.2_32", paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "FaceScanNativeSoDownloadHandler construct,STR_RES_NAME = qq.android.ar.face.so_v8.5.2_32,AppSetting.IS_CPU_64_BIT = false");
    }
  }
  
  public int a()
  {
    return 10061;
  }
  
  public Class<? extends XmlData> a()
  {
    return FaceScanNativeSoData.class;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.jdField_a_of_type_Int = ((int)(paramLong1 * 100L / paramLong2));
    FaceScanDownloadManager.a(1, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download progress: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("FaceScanNativeSoDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      FaceScanDownloadManager.a(1, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel())
    {
      paramXmlData = new StringBuilder();
      paramXmlData.append("download finish: ");
      paramXmlData.append(paramBoolean);
      QLog.d("FaceScanNativeSoDownloadHandler", 2, paramXmlData.toString());
    }
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download success: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FaceScanNativeSoDownloadHandler", 2, ((StringBuilder)localObject).toString());
    }
    int i = FaceScanNativeSoLoader.a(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download success: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",ret = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("FaceScanNativeSoDownloadHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 0)
    {
      g();
      f();
      FaceScanDownloadManager.a(1, false);
    }
    else
    {
      FaceScanDownloadManager.a(1, true);
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8008358", "0X8008358", 0, 0, "", "", "so", "");
      localObject = new HashMap();
      ((HashMap)localObject).put("res_type", "so");
      StatisticCollector.getInstance(this.jdField_a_of_type_MqqAppAppRuntime.getApp()).collectPerformance(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), "FaceResDownloadSuccess", true, 0L, 0L, (HashMap)localObject, "", true);
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.d) {
      this.d = paramBoolean;
    }
    super.a(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download restart userClick");
      localStringBuilder.append(paramBoolean);
      QLog.d("FaceScanNativeSoDownloadHandler", 2, localStringBuilder.toString());
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
  
  public void b()
  {
    boolean bool = FileUtil.a(new File(FaceScanNativeSoLoader.a()));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteUnZipFile ret: ");
      localStringBuilder.append(bool);
      QLog.d("FaceScanNativeSoDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download begin");
    }
  }
  
  public boolean c()
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
    return super.c();
  }
  
  public boolean e()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadResource,isDownloadReqedByUser = ");
      localStringBuilder.append(this.d);
      QLog.d("FaceScanNativeSoDownloadHandler", 2, localStringBuilder.toString());
    }
    if (!this.d)
    {
      if (!FaceScanDownloadManager.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceScanNativeSoDownloadHandler", 2, "pre download config disable ");
        }
        return false;
      }
      boolean bool;
      if (BaseActivity.sTopActivity != null) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadResource later ");
        localStringBuilder.append(bool);
        QLog.d("FaceScanNativeSoDownloadHandler", 2, localStringBuilder.toString());
      }
      if (bool) {
        return false;
      }
    }
    return super.e();
  }
  
  public void f()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("face_scan_sp", 4).edit().putInt("face_scan_native_so_version", b()).apply();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "restoreState");
    }
    a().loadState = 0;
    a().Version = 0;
    EarlyDataFactory.a(a(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.FaceScanNativeSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */