package cooperation.qzone.webviewplugin;

import auog;
import bmxj;
import bnkn;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
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
      QLog.i("QzoneZipCacheHelper", 2, String.format("delay 10s,url:%s,path:%s ,  zipUrl = %s ", new Object[] { this.jdField_a_of_type_JavaLangString, this.b, this.c }));
    }
    ??? = new File(this.b);
    if ((((File)???).exists()) && (((File)???).isDirectory()))
    {
      ??? = ((File)???).listFiles();
      if ((??? == null) || ((this.jdField_a_of_type_Int != -1) && (???.length != this.jdField_a_of_type_Int)) || (???.length <= 0)) {}
    }
    boolean bool2;
    for (boolean bool3 = true;; bool3 = false)
    {
      bool2 = bool3;
      for (;;)
      {
        try
        {
          ??? = new File(this.b + System.currentTimeMillis() + ".zip");
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
            localObject2 = bnkn.b(this.c);
            bool2 = bool3;
            bool3 = bnkn.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject2, (File)???);
            if (!bool3) {
              continue;
            }
            bool2 = bool3;
            localObject2 = new File(this.b);
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
                  if (this.jdField_a_of_type_Int != -1)
                  {
                    bool4 = bool5;
                    bool2 = bool3;
                    if (localObject2.length != this.jdField_a_of_type_Int) {}
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
              QzoneZipCacheHelper.unzipFile(((File)???).getAbsolutePath(), this.b);
            }
            bool2 = bool3;
            QzoneZipCacheHelper.access$100().a(this.b, true);
            bool1 = bool3;
            bool2 = bool3;
            if (QLog.isColorLevel())
            {
              bool2 = bool3;
              QLog.i("QzoneZipCacheHelper", 2, String.format("download succ,path:%s ， fileExist: %s ", new Object[] { this.b, Boolean.valueOf(bool4) }));
              bool1 = bool3;
            }
          }
          bool2 = bool1;
          if (((File)???).exists())
          {
            bool2 = bool1;
            auog.a((File)???);
          }
        }
        catch (Throwable localThrowable)
        {
          Object localObject2;
          Object localObject4;
          boolean bool1 = bool2;
          continue;
          QzoneZipCacheHelper.access$300().remove(this.c);
          return;
        }
        synchronized (QzoneZipCacheHelper.access$200())
        {
          if (QzoneZipCacheHelper.access$300() == null) {
            continue;
          }
          localObject2 = (CopyOnWriteArrayList)QzoneZipCacheHelper.access$300().get(this.c);
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
          ((QzoneZipCacheHelperCallBack)localObject4).onResultOfNativeRequest(true, this.b, this.c);
        }
        bool1 = bool3;
        bool2 = bool3;
        if (QLog.isColorLevel())
        {
          bool2 = bool3;
          QLog.i("QzoneZipCacheHelper", 2, String.format("download fail,url:%s,path:%s", new Object[] { localObject3, this.b }));
          bool1 = bool3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneZipCacheHelper.2
 * JD-Core Version:    0.7.0.1
 */