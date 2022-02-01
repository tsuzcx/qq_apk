package dov.com.qq.im.aeeditor.manage;

import bmbx;
import bmfc;
import bmfg;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.Map;

public class AEEditorResourceDownloader$4
  implements Runnable
{
  public AEEditorResourceDownloader$4(bmfc parambmfc, String paramString, bmfg parambmfg) {}
  
  public void run()
  {
    bmbx.b(this.this$0.c, "downLoadResource--by user--BEGIN id: " + this.jdField_a_of_type_JavaLangString);
    this.this$0.b();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.this$0.a.get(this.jdField_a_of_type_JavaLangString);
    if (localAEEditorDownloadResBean != null) {
      this.this$0.a(localAEEditorDownloadResBean, this.jdField_a_of_type_Bmfg);
    }
    do
    {
      return;
      bmbx.d(this.this$0.c, "downLoadResource--by user--FAIL, no download config for id: " + this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_Bmfg == null);
    this.jdField_a_of_type_Bmfg.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */