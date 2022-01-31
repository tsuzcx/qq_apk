package dov.com.qq.im.aeeditor.module.filter;

import bljn;
import blnt;
import blny;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.Map;

public class AEEditorFiltersManager$5
  implements Runnable
{
  public AEEditorFiltersManager$5(blnt paramblnt, String paramString, blny paramblny) {}
  
  public void run()
  {
    bljn.b("AEEditorFiltersManager", "downLoadResource--by user--BEGIN id: " + this.jdField_a_of_type_JavaLangString);
    blnt.a(this.this$0);
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)blnt.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
    if (localAEEditorDownloadResBean != null) {
      blnt.a(this.this$0, localAEEditorDownloadResBean, this.jdField_a_of_type_Blny);
    }
    do
    {
      return;
      bljn.d("AEEditorFiltersManager", "downLoadResource--by user--FAIL, no download config for id: " + this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_Blny == null);
    this.jdField_a_of_type_Blny.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.5
 * JD-Core Version:    0.7.0.1
 */