package dov.com.qq.im.ae.cmshow;

import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

class AECMShowResourceManager$1$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AECMShowResourceManager$1$1(AECMShowResourceManager.1 param1, String paramString, HashMap paramHashMap, AEEditorDownloadResBean paramAEEditorDownloadResBean, boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AEQLog.a("AECMShowResourceManager", "[downloadEssentialResource], resId=" + this.jdField_a_of_type_JavaLangString + ", download succeeded");
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeCmshowAECMShowResourceManager$1.this$0.a(this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
      AEQLog.a("AECMShowResourceManager", "[downloadEssentialResource], resId=" + this.jdField_a_of_type_JavaLangString + ", download failed");
      this.jdField_a_of_type_ArrayOfBoolean[0] = false;
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowResourceManager.1.1
 * JD-Core Version:    0.7.0.1
 */