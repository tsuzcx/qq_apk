package com.tencent.mobileqq.minigame.manager;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;

public class DefaultDownloader
  extends AbstractDownloader
{
  public static final String LOG_TAG = "DefaultDownloader";
  
  public void download()
  {
    String str = BaseApplicationImpl.getContext().getCacheDir() + File.separator + UUID.randomUUID() + ".zip";
    MiniappDownloadUtil.getInstance().download(this.mUrl, str, true, new DefaultDownloader.1(this, str), Downloader.DownloadMode.StrictMode, null);
    QLog.i("DefaultDownloader", 1, "[MiniEng] download " + this.mUrl + " start, saveTo=" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.DefaultDownloader
 * JD-Core Version:    0.7.0.1
 */