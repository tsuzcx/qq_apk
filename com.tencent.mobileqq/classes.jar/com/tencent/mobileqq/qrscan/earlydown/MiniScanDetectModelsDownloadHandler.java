package com.tencent.mobileqq.qrscan.earlydown;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class MiniScanDetectModelsDownloadHandler
  extends EarlyHandler
{
  private int h;
  private boolean i = false;
  
  public MiniScanDetectModelsDownloadHandler(AppRuntime paramAppRuntime)
  {
    super("qq.android.minidetect.model_v8.6.0", paramAppRuntime);
  }
  
  public Class<? extends XmlData> a()
  {
    return MiniScanDetectModeData.class;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.h = ((int)(paramLong1 * 100L / paramLong2));
    QRScanResDownloadManager.a(2, this.h);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download progress: ");
      localStringBuilder.append(this.h);
      QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      w();
      QRScanResDownloadManager.a(2, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel())
    {
      paramXmlData = new StringBuilder();
      paramXmlData.append("download finish: ");
      paramXmlData.append(paramBoolean);
      QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, paramXmlData.toString());
    }
  }
  
  public void a(String paramString)
  {
    int j = MiniScanDetectModelLoader.c(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnDownloadSuccess ret=");
      localStringBuilder.append(j);
      localStringBuilder.append(", filePath=");
      localStringBuilder.append(paramString);
      QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, localStringBuilder.toString());
    }
    if (j != 0)
    {
      w();
      QRScanResDownloadManager.a(2, false);
    }
    else
    {
      QRScanResDownloadManager.a(2, true);
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = h();
    if ((paramBoolean) && ((localObject instanceof MiniScanDecodeSoData)))
    {
      localObject = (MiniScanDecodeSoData)localObject;
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, String.format("restartDownload block_user_download=%b", new Object[] { Boolean.valueOf(((MiniScanDecodeSoData)localObject).block_user_download) }));
      }
      if (((MiniScanDecodeSoData)localObject).block_user_download) {
        return;
      }
    }
    if (!this.i) {
      this.i = paramBoolean;
    }
    super.a(paramBoolean);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("restartDownload userClick=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public String b()
  {
    return "MiniScanDetectModeData";
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, "download begin");
    }
  }
  
  public int c()
  {
    return ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).getEarlyDownBusId(3);
  }
  
  public String d()
  {
    return "prd";
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void j()
  {
    boolean bool = FileUtil.a(new File(MiniScanDetectModelLoader.a()));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteUnZipFile ret: ");
      localStringBuilder.append(bool);
      QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public boolean m()
  {
    if (this.i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.m();
  }
  
  public boolean o()
  {
    if (!this.i)
    {
      boolean bool = QBaseActivity.mAppForground ^ true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadResource later ");
        localStringBuilder.append(bool);
        QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, localStringBuilder.toString());
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
      QLog.d("MiniRecog.MiniScanDetectModelsDownloadHandler", 2, "restoreState");
    }
    h().loadState = 0;
    h().Version = 0;
    EarlyDataFactory.a(h(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectModelsDownloadHandler
 * JD-Core Version:    0.7.0.1
 */