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
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.i("QzoneZipCacheHelper", 2, String.format("delay 10s,url:%s,path:%s ,  zipUrl = %s ", new Object[] { this.val$business, this.val$zipFolderPath, this.val$zipUrl }));
    }
    ??? = new File(this.val$zipFolderPath);
    if ((((File)???).exists()) && (((File)???).isDirectory()))
    {
      ??? = ((File)???).listFiles();
      if ((??? == null) || ((this.val$count != -1) && (???.length != this.val$count)) || (???.length <= 0)) {}
    }
    boolean bool2;
    for (boolean bool3 = true;; bool3 = false)
    {
      bool2 = bool3;
      for (;;)
      {
        try
        {
          ??? = new File(this.val$zipFolderPath + System.currentTimeMillis() + ".zip");
          bool2 = bool3;
          if (QLog.isColorLevel())
          {
            bool2 = bool3;
            QLog.i("QzoneZipCacheHelper", 2, String.format("check isDownloaded %s , file Exist = %s ", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(((File)???).exists()) }));
          }
          bool1 = bool3;
          if (!bool3)
          {
            bool2 = bool3;
            localObject2 = QZoneHttpDownloadUtil.getFilterUrl(this.val$zipUrl);
            bool2 = bool3;
            bool3 = QZoneHttpDownloadUtil.download(this.val$appInterface, (String)localObject2, (File)???);
            if (!bool3) {
              continue;
            }
            bool2 = bool3;
            localObject2 = new File(this.val$zipFolderPath);
            boolean bool4 = bool5;
            bool2 = bool3;
            if (((File)localObject2).exists())
            {
              bool4 = bool5;
              bool2 = bool3;
              if (((File)localObject2).isDirectory())
              {
                bool2 = bool3;
                localObject2 = ((File)localObject2).listFiles();
                bool4 = bool5;
                if (localObject2 != null)
                {
                  bool2 = bool3;
                  if (this.val$count != -1)
                  {
                    bool4 = bool5;
                    bool2 = bool3;
                    if (localObject2.length != this.val$count) {}
                  }
                  else
                  {
                    bool4 = bool5;
                    bool2 = bool3;
                    if (localObject2.length > 0) {
                      bool4 = true;
                    }
                  }
                }
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
            }
          }
          bool2 = bool1;
          if (((File)???).exists())
          {
            bool2 = bool1;
            FileUtil.a((File)???);
          }
        }
        catch (Throwable localThrowable)
        {
          Object localObject2;
          Object localObject4;
          boolean bool1 = bool2;
          continue;
          QzoneZipCacheHelper.access$300().remove(this.val$zipUrl);
          return;
        }
        synchronized (QzoneZipCacheHelper.access$200())
        {
          if (QzoneZipCacheHelper.access$300() == null) {
            continue;
          }
          localObject2 = (CopyOnWriteArrayList)QzoneZipCacheHelper.access$300().get(this.val$zipUrl);
          if (localObject2 == null) {
            continue;
          }
          localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject4 = ((Iterator)localObject2).next();
          if (!(localObject4 instanceof QzoneZipCacheHelperCallBack)) {
            continue;
          }
          ((QzoneZipCacheHelperCallBack)localObject4).onResult(bool1);
          ((QzoneZipCacheHelperCallBack)localObject4).onResultOfNativeRequest(true, this.val$zipFolderPath, this.val$zipUrl);
        }
        bool1 = bool3;
        bool2 = bool3;
        if (QLog.isColorLevel())
        {
          bool2 = bool3;
          QLog.i("QzoneZipCacheHelper", 2, String.format("download fail,url:%s,path:%s", new Object[] { localObject3, this.val$zipFolderPath }));
          bool1 = bool3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneZipCacheHelper.2
 * JD-Core Version:    0.7.0.1
 */