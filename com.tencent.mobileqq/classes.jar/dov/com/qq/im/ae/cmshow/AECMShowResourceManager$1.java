package dov.com.qq.im.ae.cmshow;

import android.text.TextUtils;
import bnjd;
import bnje;
import bnjf;
import bnrh;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AECMShowResourceManager$1
  implements Runnable
{
  public AECMShowResourceManager$1(bnjd parambnjd, List paramList, bnjf parambnjf) {}
  
  public void run()
  {
    bnjd.a(this.this$0);
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
        bnrh.a("AECMShowResourceManager", "[downloadEssentialResource], resId is null");
        arrayOfBoolean[0] = false;
        localCountDownLatch.countDown();
      }
      else
      {
        AEEditorDownloadResBean localAEEditorDownloadResBean = bnjd.a(this.this$0, str);
        if (localAEEditorDownloadResBean == null)
        {
          bnrh.a("AECMShowResourceManager", "[downloadEssentialResource], resId=" + str + ", download bean is null");
          arrayOfBoolean[0] = false;
          localHashMap.put(str, null);
          localCountDownLatch.countDown();
        }
        else if (this.this$0.a(localAEEditorDownloadResBean))
        {
          bnrh.a("AECMShowResourceManager", "[downloadEssentialResource], resId=" + str + ", res exists");
          localHashMap.put(str, bnjd.a(this.this$0, localAEEditorDownloadResBean));
          localCountDownLatch.countDown();
        }
        else
        {
          this.this$0.a(localAEEditorDownloadResBean, new bnje(this, str, localHashMap, localAEEditorDownloadResBean, arrayOfBoolean, localCountDownLatch));
        }
      }
    }
    try
    {
      localCountDownLatch.await();
      if (this.jdField_a_of_type_Bnjf != null) {
        this.jdField_a_of_type_Bnjf.a(arrayOfBoolean[0], localHashMap);
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        bnrh.a("AECMShowResourceManager", "[downloadEssentialResource], e=", localInterruptedException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowResourceManager.1
 * JD-Core Version:    0.7.0.1
 */