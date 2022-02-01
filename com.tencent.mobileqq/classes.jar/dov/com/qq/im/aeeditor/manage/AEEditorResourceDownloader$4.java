package dov.com.qq.im.aeeditor.manage;

import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.Map;

class AEEditorResourceDownloader$4
  implements Runnable
{
  AEEditorResourceDownloader$4(AEEditorResourceDownloader paramAEEditorResourceDownloader, String paramString, AEEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener) {}
  
  public void run()
  {
    AEQLog.b(this.this$0.c, "downLoadResource--by user--BEGIN id: " + this.jdField_a_of_type_JavaLangString);
    this.this$0.c();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.this$0.a.get(this.jdField_a_of_type_JavaLangString);
    if (localAEEditorDownloadResBean != null) {
      this.this$0.a(localAEEditorDownloadResBean, this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$ResDownLoadListener);
    }
    do
    {
      return;
      AEQLog.d(this.this$0.c, "downLoadResource--by user--FAIL, no download config for id: " + this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$ResDownLoadListener == null);
    this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorResourceDownloader$ResDownLoadListener.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */