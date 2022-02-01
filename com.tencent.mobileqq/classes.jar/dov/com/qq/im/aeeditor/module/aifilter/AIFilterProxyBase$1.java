package dov.com.qq.im.aeeditor.module.aifilter;

import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import java.util.concurrent.CountDownLatch;

final class AIFilterProxyBase$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AIFilterProxyBase$1(boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfBoolean[0] = paramBoolean;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AIFilterProxyBase.1
 * JD-Core Version:    0.7.0.1
 */