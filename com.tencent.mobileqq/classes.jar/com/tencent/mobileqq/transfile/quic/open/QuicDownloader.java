package com.tencent.mobileqq.transfile.quic.open;

import com.tencent.mobileqq.transfile.quic.QuicNetResMgr;
import com.tencent.mobileqq.transfile.quic.internal.QuicNative;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport.Stats;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class QuicDownloader
  extends Downloader
{
  private static volatile boolean cannotLoadLib = true;
  public static QuicNetReport.Stats sLastStats;
  protected QuicDownloader.Builder mBuilder;
  
  static
  {
    loadSoSupport();
  }
  
  public static boolean initError()
  {
    return cannotLoadLib;
  }
  
  public static void loadSoSupport()
  {
    if (!initError()) {}
    while ((!FileUtils.fileExists(QuicNetResMgr.getAndromedaSoPath())) || (!FileUtils.fileExists(QuicNetResMgr.getQuicEngineSoPath()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, " loadSoSupport ");
    }
    try
    {
      System.load(QuicNetResMgr.getAndromedaSoPath());
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        System.load(QuicNetResMgr.getQuicEngineSoPath());
        for (;;)
        {
          for (;;)
          {
            try
            {
              QuicNative.init();
              QuicNative.setDebugLog(false);
              cannotLoadLib = false;
              return;
            }
            catch (Throwable localThrowable1)
            {
              QLog.e("quic", 4, localThrowable1, new Object[0]);
              return;
            }
            localThrowable2 = localThrowable2;
            try
            {
              System.load(QuicNetResMgr.getAndromedaSoPath());
            }
            catch (Throwable localThrowable3)
            {
              QLog.e("quic", 4, "cannot load library quic_engine", localThrowable3);
            }
          }
        }
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          System.load(QuicNetResMgr.getQuicEngineSoPath());
        }
      }
    }
  }
  
  public static QuicNetReport.Stats saveNetStats(QuicNetReport paramQuicNetReport)
  {
    QuicNetReport.Stats localStats = QuicNetReport.convertJsontoStats(paramQuicNetReport.extra);
    if (localStats != null)
    {
      if ((paramQuicNetReport.srvMessage != null) && (paramQuicNetReport.srvMessage.length > 0))
      {
        int i = paramQuicNetReport.srvMessage.length;
        localStats.mSrvMessage = new byte[i];
        System.arraycopy(paramQuicNetReport.srvMessage, 0, localStats.mSrvMessage, 0, i);
      }
      if (localStats.isValid()) {
        try
        {
          sLastStats = localStats;
          if (QLog.isColorLevel()) {
            QLog.d("quic", 4, localStats.toString());
          }
          return localStats;
        }
        finally {}
      }
    }
    return null;
  }
  
  public QuicDownloader.Builder build(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return new QuicDownloader.Builder(this, paramString1, paramInt, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.QuicDownloader
 * JD-Core Version:    0.7.0.1
 */