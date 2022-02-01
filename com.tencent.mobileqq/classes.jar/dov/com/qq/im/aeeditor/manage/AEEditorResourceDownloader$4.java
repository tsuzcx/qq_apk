package dov.com.qq.im.aeeditor.manage;

import bpam;
import bpds;
import bpdw;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.Map;

public class AEEditorResourceDownloader$4
  implements Runnable
{
  public AEEditorResourceDownloader$4(bpds parambpds, String paramString, bpdw parambpdw) {}
  
  public void run()
  {
    bpam.b(this.this$0.c, "downLoadResource--by user--BEGIN id: " + this.jdField_a_of_type_JavaLangString);
    this.this$0.b();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.this$0.a.get(this.jdField_a_of_type_JavaLangString);
    if (localAEEditorDownloadResBean != null) {
      this.this$0.a(localAEEditorDownloadResBean, this.jdField_a_of_type_Bpdw);
    }
    do
    {
      return;
      bpam.d(this.this$0.c, "downLoadResource--by user--FAIL, no download config for id: " + this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_Bpdw == null);
    this.jdField_a_of_type_Bpdw.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */