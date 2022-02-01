package dov.com.qq.im.aeeditor.manage;

import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.concurrent.CountDownLatch;

class AEEditorResourceDownloader$3$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorResourceDownloader$3$1(AEEditorResourceDownloader.3 param3, int paramInt, AEEditorDownloadResBean paramAEEditorDownloadResBean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    AEQLog.b(this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$3.this$0.c, "preDownloadAllRes---[finish] " + this.jdField_a_of_type_Int + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.3.1
 * JD-Core Version:    0.7.0.1
 */