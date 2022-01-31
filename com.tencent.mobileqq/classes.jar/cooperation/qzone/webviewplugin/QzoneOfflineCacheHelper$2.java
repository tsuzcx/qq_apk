package cooperation.qzone.webviewplugin;

import apvb;
import bhor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

final class QzoneOfflineCacheHelper$2
  implements Runnable
{
  QzoneOfflineCacheHelper$2(String paramString1, String paramString2, AppInterface paramAppInterface, String paramString3, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QzoneOfflineCacheHelper", 4, String.format("delay 10s,url:%s ,path:%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
      }
      ??? = new File(this.b);
      boolean bool = bhor.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, (File)???, this.c, this.jdField_a_of_type_Int);
      if (bool)
      {
        QzoneOfflineCacheHelper.updateLruFileInNewThread(this.b);
        if (QLog.isDevelopLevel()) {
          QLog.i("QzoneOfflineCacheHelper", 4, String.format("download succ,path:%s", new Object[] { this.b }));
        }
      }
      for (;;)
      {
        synchronized (QzoneOfflineCacheHelper.access$100())
        {
          if (QzoneOfflineCacheHelper.access$200() != null)
          {
            Object localObject2 = (ArrayList)QzoneOfflineCacheHelper.access$200().get(this.jdField_a_of_type_JavaLangString);
            if (localObject2 != null)
            {
              localObject2 = ((ArrayList)localObject2).iterator();
              if (((Iterator)localObject2).hasNext())
              {
                Object localObject4 = ((Iterator)localObject2).next();
                if (!(localObject4 instanceof QzoneOfflineCacheHelperCallBack)) {
                  continue;
                }
                ((QzoneOfflineCacheHelperCallBack)localObject4).onResultOfNativeRequest(bool, this.b);
              }
            }
          }
        }
        try
        {
          if (localException.exists()) {
            apvb.a(localException);
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("QzoneOfflineCacheHelper", 4, String.format("download fail,url:%s ,path:%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
          continue;
          QzoneOfflineCacheHelper.access$200().remove(this.jdField_a_of_type_JavaLangString);
          return;
        }
        catch (Throwable localThrowable)
        {
          break label213;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.w("QzoneOfflineCacheHelper", 1, "预下载offline资源发生异常", localException);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper.2
 * JD-Core Version:    0.7.0.1
 */