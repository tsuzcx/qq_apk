package com.tencent.mobileqq.qrscan.earlydown;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanTempApi;
import com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MiniScanDetectSoDownloadHandler
  extends EarlyHandler
{
  private int a;
  private boolean d = false;
  
  public MiniScanDetectSoDownloadHandler(AppRuntime paramAppRuntime)
  {
    super("qq.android.minidetect.so_v8.6.0", paramAppRuntime);
  }
  
  public int a()
  {
    return ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).getEarlyDownBusId(2);
  }
  
  public Class<? extends XmlData> a()
  {
    return MiniScanDetectSoData.class;
  }
  
  public String a()
  {
    return "MiniScanDetectSoData";
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.a = ((int)(paramLong1 * 100L / paramLong2));
    QRScanResDownloadManager.a(1, this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download progress: ");
      localStringBuilder.append(this.a);
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      g();
      f();
      QRScanResDownloadManager.a(1, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel())
    {
      paramXmlData = new StringBuilder();
      paramXmlData.append("download finish: ");
      paramXmlData.append(paramBoolean);
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, paramXmlData.toString());
    }
  }
  
  public void a(String paramString)
  {
    int i = MiniScanDetectSoLoader.a(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnDownloadSuccess ret=");
      localStringBuilder.append(i);
      localStringBuilder.append(", filePath=");
      localStringBuilder.append(paramString);
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, localStringBuilder.toString());
    }
    if (i != 0)
    {
      g();
      f();
      QRScanResDownloadManager.a(1, false);
    }
    else
    {
      QRScanResDownloadManager.a(1, true);
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = a();
    if ((paramBoolean) && ((localObject instanceof MiniScanDecodeSoData)))
    {
      localObject = (MiniScanDecodeSoData)localObject;
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDetectSoDownloadHandler", 2, String.format("restartDownload block_user_download=%b", new Object[] { Boolean.valueOf(((MiniScanDecodeSoData)localObject).block_user_download) }));
      }
      if (((MiniScanDecodeSoData)localObject).block_user_download) {
        return;
      }
    }
    if (!this.d) {
      this.d = paramBoolean;
    }
    super.a(paramBoolean);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("restartDownload userClick=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, ((StringBuilder)localObject).toString());
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
    boolean bool = FileUtil.a(new File(MiniScanDetectSoLoader.a()));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteUnZipFile ret: ");
      localStringBuilder.append(bool);
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download begin");
    }
  }
  
  public boolean c()
  {
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.c();
  }
  
  public boolean e()
  {
    if (!this.d)
    {
      boolean bool = QBaseActivity.mAppForground ^ true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadResource later ");
        localStringBuilder.append(bool);
        QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, localStringBuilder.toString());
      }
      if (bool) {
        return false;
      }
    }
    return super.e();
  }
  
  public void f()
  {
    MobileQQ.sMobileQQ.getSharedPreferences("mini_scan_sp", 4).edit().putInt("minidetect_so_version", b()).apply();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "restoreState");
    }
    a().loadState = 0;
    a().Version = 0;
    EarlyDataFactory.a(a(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */