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
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager;
import com.tencent.mobileqq.qrscan.minicode.MiniScanReport;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MiniScanDecodeSoDownloadHandler
  extends EarlyHandler
{
  private int h;
  private boolean i = false;
  
  public MiniScanDecodeSoDownloadHandler(AppRuntime paramAppRuntime)
  {
    super("qq.android.minidecode.so_v8.8.5", paramAppRuntime);
  }
  
  public Class<? extends XmlData> a()
  {
    return MiniScanDecodeSoData.class;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.h = ((int)(paramLong1 * 100L / paramLong2));
    QRScanResDownloadManager.a(0, this.h);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download progress: ");
      localStringBuilder.append(this.h);
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      x();
      w();
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
    int j = MiniScanDecodeSoLoader.d(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnDownloadSuccess ret=");
      localStringBuilder.append(j);
      localStringBuilder.append(", filePath=");
      localStringBuilder.append(paramString);
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, localStringBuilder.toString());
    }
    if (j != 0)
    {
      x();
      w();
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
    Object localObject = h();
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
    if (!this.i) {
      this.i = paramBoolean;
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
  
  public String b()
  {
    return "MiniScanDecodeSoData";
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download begin");
    }
  }
  
  public int c()
  {
    return ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).getEarlyDownBusId(1);
  }
  
  public String d()
  {
    return "prd";
  }
  
  public void e(boolean paramBoolean)
  {
    long l1 = MiniScanReport.a("report_tag_so_cover", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      XmlData localXmlData = h();
      boolean bool = false;
      int j;
      String str1;
      if ((localXmlData != null) && ((localXmlData instanceof MiniScanDecodeSoData)))
      {
        int k = ((MiniScanDecodeSoData)localXmlData).Version;
        String str2 = MiniScanDecodeSoLoader.c("minicode");
        paramBoolean = bool;
        j = k;
        str1 = str2;
        if (localXmlData.loadState == 1)
        {
          paramBoolean = bool;
          j = k;
          str1 = str2;
          if (k > 0)
          {
            paramBoolean = bool;
            j = k;
            str1 = str2;
            if (!TextUtils.isEmpty(str2))
            {
              paramBoolean = true;
              j = k;
              str1 = str2;
            }
          }
        }
      }
      else
      {
        str1 = "";
        j = 0;
        paramBoolean = bool;
      }
      MiniScanReport.a(paramBoolean, j, str1);
      MiniScanReport.b("report_tag_so_cover", l2);
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void j()
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
  
  public boolean m()
  {
    if (this.i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by startup ");
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
        QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, localStringBuilder.toString());
      }
      if (bool) {
        return false;
      }
    }
    return super.o();
  }
  
  public void w()
  {
    MobileQQ.sMobileQQ.getSharedPreferences("mini_scan_sp", 4).edit().putInt("minidecode_so_version", f()).apply();
  }
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "restoreState");
    }
    h().loadState = 0;
    h().Version = 0;
    EarlyDataFactory.a(h(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.MiniScanDecodeSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */