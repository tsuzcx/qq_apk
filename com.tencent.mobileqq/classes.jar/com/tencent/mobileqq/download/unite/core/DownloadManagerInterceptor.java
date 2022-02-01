package com.tencent.mobileqq.download.unite.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.download.unite.config.DownloadConfigBean;
import com.tencent.mobileqq.download.unite.config.DownloadConfigProcessor;
import com.tencent.mobileqq.download.unite.util.UniteDownloadUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import java.util.List;

public class DownloadManagerInterceptor
{
  public static DownloadManagerInterceptor a()
  {
    return DownloadManagerInterceptor.SingletonHolder.a();
  }
  
  public static boolean a(DownloadInfo paramDownloadInfo)
  {
    return paramDownloadInfo.i == TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
  }
  
  public static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] businessInSilentWhiteList: invoked. ", " businessName: ", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = DownloadConfigProcessor.a().b.contains(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] businessInSilentWhiteList: invoked. ", " inWhite: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  private void b(DownloadInfo paramDownloadInfo, Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] uniteUniversalDownload: invoked. in silent white list.", " downloadInfo: ", paramDownloadInfo });
    }
    if (!a(paramDownloadInfo)) {
      paramDownloadInfo.i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
    }
    d(paramDownloadInfo, paramRunnable);
  }
  
  private boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] businessInBlackList: invoked. ", " businessName: ", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = DownloadConfigProcessor.a().jdField_a_of_type_JavaUtilList.contains(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] businessInBlackList: invoked. ", " inBlack: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  private void c(DownloadInfo paramDownloadInfo, Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] uniteSilentDownload: invoked. in silent white list.", " downloadInfo: ", paramDownloadInfo });
    }
    ThreadManager.excute(paramRunnable, 16, null, true);
  }
  
  private void d(DownloadInfo paramDownloadInfo, Runnable paramRunnable)
  {
    UniteDownloadUtil.a(paramDownloadInfo, new DownloadManagerInterceptor.1(this, paramRunnable));
  }
  
  public void a(DownloadInfo paramDownloadInfo, Runnable paramRunnable)
  {
    String str = paramDownloadInfo.m;
    if (b(str))
    {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 1, new Object[] { "[check] uniteDownload: invoked. in black list.", " sourceBusinessName: ", str });
      return;
    }
    if (paramDownloadInfo.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] uniteDownload: invoked. pause continue");
      }
      ThreadManager.excute(paramRunnable, 16, null, true);
      return;
    }
    boolean bool1 = a(str);
    boolean bool2 = paramDownloadInfo.f;
    boolean bool3 = paramDownloadInfo.g ^ true;
    boolean bool4 = DownloadConfigProcessor.a().jdField_a_of_type_Boolean ^ true;
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] uniteDownload: invoked. ", " inWhite: ", Boolean.valueOf(bool1), " isFromRockDownloader: ", Boolean.valueOf(bool2), " notUniteDownload: ", Boolean.valueOf(bool3), " disableUniteDownloadDialog: ", Boolean.valueOf(bool4) });
    }
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4))
    {
      b(paramDownloadInfo, paramRunnable);
      return;
    }
    c(paramDownloadInfo, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.core.DownloadManagerInterceptor
 * JD-Core Version:    0.7.0.1
 */