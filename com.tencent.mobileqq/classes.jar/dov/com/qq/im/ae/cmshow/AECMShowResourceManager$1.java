package dov.com.qq.im.ae.cmshow;

import android.text.TextUtils;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class AECMShowResourceManager$1
  implements Runnable
{
  AECMShowResourceManager$1(AECMShowResourceManager paramAECMShowResourceManager, List paramList, AECMShowResourceManager.CMJoyEssentialDownloadCallback paramCMJoyEssentialDownloadCallback) {}
  
  public void run()
  {
    AECMShowResourceManager.a(this.this$0);
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = true;
    HashMap localHashMap = new HashMap();
    CountDownLatch localCountDownLatch = new CountDownLatch(this.jdField_a_of_type_JavaUtilList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (TextUtils.isEmpty(str))
      {
        AEQLog.a("AECMShowResourceManager", "[downloadEssentialResource], resId is null");
        arrayOfBoolean[0] = false;
        localCountDownLatch.countDown();
      }
      else
      {
        AEEditorDownloadResBean localAEEditorDownloadResBean = AECMShowResourceManager.a(this.this$0, str);
        if (localAEEditorDownloadResBean == null)
        {
          AEQLog.a("AECMShowResourceManager", "[downloadEssentialResource], resId=" + str + ", download bean is null");
          arrayOfBoolean[0] = false;
          localHashMap.put(str, null);
          localCountDownLatch.countDown();
        }
        else if (this.this$0.a(localAEEditorDownloadResBean))
        {
          AEQLog.a("AECMShowResourceManager", "[downloadEssentialResource], resId=" + str + ", res exists");
          localHashMap.put(str, this.this$0.a(localAEEditorDownloadResBean));
          localCountDownLatch.countDown();
        }
        else
        {
          this.this$0.a(localAEEditorDownloadResBean, new AECMShowResourceManager.1.1(this, str, localHashMap, localAEEditorDownloadResBean, arrayOfBoolean, localCountDownLatch));
        }
      }
    }
    try
    {
      localCountDownLatch.await();
      if (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowResourceManager$CMJoyEssentialDownloadCallback != null) {
        this.jdField_a_of_type_DovComQqImAeCmshowAECMShowResourceManager$CMJoyEssentialDownloadCallback.a(arrayOfBoolean[0], localHashMap);
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        AEQLog.a("AECMShowResourceManager", "[downloadEssentialResource], e=", localInterruptedException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowResourceManager.1
 * JD-Core Version:    0.7.0.1
 */