package com.tencent.mobileqq.qrscan.earlydown;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanTempApi;
import com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager;
import com.tencent.mobileqq.qrscan.minicode.MiniScanReport;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MiniScanDecodeSoDownloadHandler
  extends EarlyHandler
{
  private int a;
  private boolean d = false;
  
  public MiniScanDecodeSoDownloadHandler(AppRuntime paramAppRuntime)
  {
    super("qq.android.minidecode.so_v8.2.0", paramAppRuntime);
  }
  
  public int a()
  {
    return ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).getEarlyDownBusId(1);
  }
  
  public Class<? extends XmlData> a()
  {
    return MiniScanDecodeSoData.class;
  }
  
  public String a()
  {
    return "MiniScanDecodeSoData";
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.a = ((int)(paramLong1 * 100L / paramLong2));
    QRScanResDownloadManager.a(0, this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download progress: ");
      localStringBuilder.append(this.a);
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      g();
      f();
      QRScanResDownloadManager.a(0, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel())
    {
      paramXmlData = new StringBuilder();
      paramXmlData.append("download finish: ");
      paramXmlData.append(paramBoolean);
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, paramXmlData.toString());
    }
  }
  
  public void a(String paramString)
  {
    int i = MiniScanDecodeSoLoader.a(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnDownloadSuccess ret=");
      localStringBuilder.append(i);
      localStringBuilder.append(", filePath=");
      localStringBuilder.append(paramString);
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, localStringBuilder.toString());
    }
    if (i != 0)
    {
      g();
      f();
      QRScanResDownloadManager.a(0, false);
    }
    else
    {
      QRScanResDownloadManager.a(0, true);
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
        QLog.i("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, String.format("restartDownload block_user_download=%b", new Object[] { Boolean.valueOf(((MiniScanDecodeSoData)localObject).block_user_download) }));
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
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, ((StringBuilder)localObject).toString());
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
    boolean bool = FileUtil.a(new File(MiniScanDecodeSoLoader.a()));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteUnZipFile ret: ");
      localStringBuilder.append(bool);
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download begin");
    }
  }
  
  public boolean c()
  {
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.c();
  }
  
  public void e(boolean paramBoolean)
  {
    long l1 = MiniScanReport.a("report_tag_so_cover", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      XmlData localXmlData = a();
      boolean bool = false;
      int i;
      String str1;
      if ((localXmlData != null) && ((localXmlData instanceof MiniScanDecodeSoData)))
      {
        int j = ((MiniScanDecodeSoData)localXmlData).Version;
        String str2 = MiniScanDecodeSoLoader.c("minicode");
        paramBoolean = bool;
        i = j;
        str1 = str2;
        if (localXmlData.loadState == 1)
        {
          paramBoolean = bool;
          i = j;
          str1 = str2;
          if (j > 0)
          {
            paramBoolean = bool;
            i = j;
            str1 = str2;
            if (!TextUtils.isEmpty(str2))
            {
              paramBoolean = true;
              i = j;
              str1 = str2;
            }
          }
        }
      }
      else
      {
        str1 = "";
        i = 0;
        paramBoolean = bool;
      }
      MiniScanReport.a(paramBoolean, i, str1);
      MiniScanReport.a("report_tag_so_cover", l2);
    }
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
        QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, localStringBuilder.toString());
      }
      if (bool) {
        return false;
      }
    }
    return super.e();
  }
  
  public void f()
  {
    MobileQQ.sMobileQQ.getSharedPreferences("mini_scan_sp", 4).edit().putInt("minidecode_so_version", b()).apply();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "restoreState");
    }
    a().loadState = 0;
    a().Version = 0;
    EarlyDataFactory.a(a(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.MiniScanDecodeSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */