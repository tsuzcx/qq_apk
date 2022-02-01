package cooperation.qzone.webviewplugin;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.util.QZoneHttpDownloadUtil;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class QzoneZipCacheHelper$2
  implements Runnable
{
  QzoneZipCacheHelper$2(String paramString1, String paramString2, String paramString3, int paramInt, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneZipCacheHelper", 2, String.format("delay 10s,url:%s,path:%s ,  zipUrl = %s ", new Object[] { this.val$business, this.val$zipFolderPath, this.val$zipUrl }));
    }
    ??? = new File(this.val$zipFolderPath);
    if ((((File)???).exists()) && (((File)???).isDirectory()))
    {
      ??? = ((File)???).listFiles();
      if (??? != null)
      {
        int i = this.val$count;
        if (((i == -1) || (???.length == i)) && (???.length > 0))
        {
          bool3 = true;
          break label115;
        }
      }
    }
    bool3 = false;
    label115:
    bool2 = bool3;
    try
    {
      ??? = new StringBuilder();
      bool2 = bool3;
      ((StringBuilder)???).append(this.val$zipFolderPath);
      bool2 = bool3;
      ((StringBuilder)???).append(System.currentTimeMillis());
      bool2 = bool3;
      ((StringBuilder)???).append(".zip");
      bool2 = bool3;
      ??? = new File(((StringBuilder)???).toString());
      bool2 = bool3;
      if (QLog.isColorLevel())
      {
        bool2 = bool3;
        QLog.i("QzoneZipCacheHelper", 2, String.format("check isDownloaded %s , file Exist = %s ", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(((File)???).exists()) }));
      }
      bool1 = bool3;
      if (bool3) {
        break label489;
      }
      bool2 = bool3;
      localObject2 = QZoneHttpDownloadUtil.getFilterUrl(this.val$zipUrl);
      bool2 = bool3;
      bool3 = QZoneHttpDownloadUtil.download(this.val$appInterface, (String)localObject2, (File)???);
      if (!bool3) {
        break label444;
      }
      bool2 = bool3;
      localObject2 = new File(this.val$zipFolderPath);
      bool2 = bool3;
      if (!((File)localObject2).exists()) {
        break label652;
      }
      bool2 = bool3;
      if (!((File)localObject2).isDirectory()) {
        break label652;
      }
      bool2 = bool3;
      localObject2 = ((File)localObject2).listFiles();
      if (localObject2 == null) {
        break label652;
      }
      bool2 = bool3;
      if (this.val$count != -1)
      {
        bool2 = bool3;
        if (localObject2.length != this.val$count) {
          break label652;
        }
      }
      bool2 = bool3;
      if (localObject2.length <= 0) {
        break label652;
      }
      bool4 = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool1;
        Object localObject2;
        bool3 = bool2;
        continue;
        boolean bool4 = false;
      }
    }
    if (!bool4)
    {
      bool2 = bool3;
      QzoneZipCacheHelper.unzipFile(((File)???).getAbsolutePath(), this.val$zipFolderPath);
    }
    bool2 = bool3;
    QzoneZipCacheHelper.access$100().updateLruFile(this.val$zipFolderPath, true);
    bool1 = bool3;
    bool2 = bool3;
    if (QLog.isColorLevel())
    {
      bool2 = bool3;
      QLog.i("QzoneZipCacheHelper", 2, String.format("download succ,path:%s ， fileExist: %s ", new Object[] { this.val$zipFolderPath, Boolean.valueOf(bool4) }));
      bool1 = bool3;
      break label489;
      label444:
      bool1 = bool3;
      bool2 = bool3;
      if (QLog.isColorLevel())
      {
        bool2 = bool3;
        QLog.i("QzoneZipCacheHelper", 2, String.format("download fail,url:%s,path:%s", new Object[] { localObject2, this.val$zipFolderPath }));
        bool1 = bool3;
      }
    }
    label489:
    bool3 = bool1;
    bool2 = bool1;
    if (((File)???).exists())
    {
      bool2 = bool1;
      FileUtil.a((File)???);
      bool3 = bool1;
    }
    synchronized (QzoneZipCacheHelper.access$200())
    {
      if (QzoneZipCacheHelper.access$300() != null)
      {
        localObject2 = (CopyOnWriteArrayList)QzoneZipCacheHelper.access$300().get(this.val$zipUrl);
        if (localObject2 != null)
        {
          localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject4 = ((Iterator)localObject2).next();
            if ((localObject4 instanceof QzoneZipCacheHelperCallBack))
            {
              ((QzoneZipCacheHelperCallBack)localObject4).onResult(bool3);
              ((QzoneZipCacheHelperCallBack)localObject4).onResultOfNativeRequest(true, this.val$zipFolderPath, this.val$zipUrl);
            }
          }
        }
        QzoneZipCacheHelper.access$300().remove(this.val$zipUrl);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneZipCacheHelper.2
 * JD-Core Version:    0.7.0.1
 */