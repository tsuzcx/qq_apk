package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.FaceScanModelsLoader;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.FaceModelsData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class FaceModelsDownloadHandler
  extends EarlyHandler
{
  private int h;
  private boolean i = false;
  
  public FaceModelsDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.face.models_v8.2.0", paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "FaceModelsDownloadHandler construct,STR_RES_NAME = qq.android.ar.face.models_v8.2.0");
    }
  }
  
  public Class<? extends XmlData> a()
  {
    return FaceModelsData.class;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.h = ((int)(paramLong1 * 100L / paramLong2));
    FaceScanDownloadManager.a(0, this.h);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download progress: ");
      localStringBuilder.append(this.h);
      QLog.d("FaceModelsDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      FaceScanDownloadManager.a(0, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel())
    {
      paramXmlData = new StringBuilder();
      paramXmlData.append("download finish: ");
      paramXmlData.append(paramBoolean);
      QLog.d("FaceModelsDownloadHandler", 2, paramXmlData.toString());
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
      QLog.d("FaceModelsDownloadHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (FaceScanModelsLoader.b(paramString) != 0)
    {
      w();
      FaceScanDownloadManager.a(0, false);
    }
    else
    {
      FaceScanDownloadManager.a(0, true);
      ReportController.b(this.c, "dc00898", "", "", "0X8008358", "0X8008358", 0, 0, "", "", "model", "");
      localObject = new HashMap();
      ((HashMap)localObject).put("res_type", "model");
      StatisticCollector.getInstance(this.c.getApp()).collectPerformance(this.c.getCurrentAccountUin(), "FaceResDownloadSuccess", true, 0L, 0L, (HashMap)localObject, "", true);
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.i) {
      this.i = paramBoolean;
    }
    super.a(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download restart userClick = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("FaceModelsDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public String b()
  {
    return null;
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "download begin");
    }
  }
  
  public int c()
  {
    return 10061;
  }
  
  public String d()
  {
    return "prd";
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean m()
  {
    if (this.i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceModelsDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.m();
  }
  
  public boolean o()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadResource,isDownloadReqedByUser = ");
      localStringBuilder.append(this.i);
      QLog.d("FaceModelsDownloadHandler", 2, localStringBuilder.toString());
    }
    if (!this.i)
    {
      if (!FaceScanDownloadManager.d((QQAppInterface)this.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceModelsDownloadHandler", 2, "pre download config disable ");
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
        QLog.d("FaceModelsDownloadHandler", 2, localStringBuilder.toString());
      }
      if (bool) {
        return false;
      }
    }
    return super.o();
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "restoreState");
    }
    h().loadState = 0;
    h().Version = 0;
    EarlyDataFactory.a(h(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.FaceModelsDownloadHandler
 * JD-Core Version:    0.7.0.1
 */