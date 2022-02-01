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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getContext().getCacheDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(UUID.randomUUID());
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    MiniappDownloadUtil.getInstance().download(this.mUrl, (String)localObject, true, new DefaultDownloader.1(this, (String)localObject), Downloader.DownloadMode.StrictMode, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] download ");
    localStringBuilder.append(this.mUrl);
    localStringBuilder.append(" start, saveTo=");
    localStringBuilder.append((String)localObject);
    QLog.i("DefaultDownloader", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.DefaultDownloader
 * JD-Core Version:    0.7.0.1
 */