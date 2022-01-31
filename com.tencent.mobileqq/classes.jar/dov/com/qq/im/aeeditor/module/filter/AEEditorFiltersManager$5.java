package dov.com.qq.im.aeeditor.module.filter;

import blfg;
import bljh;
import bljm;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.Map;

public class AEEditorFiltersManager$5
  implements Runnable
{
  public AEEditorFiltersManager$5(bljh parambljh, String paramString, bljm parambljm) {}
  
  public void run()
  {
    blfg.b("AEEditorFiltersManager", "downLoadResource--by user--BEGIN id: " + this.jdField_a_of_type_JavaLangString);
    bljh.a(this.this$0);
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)bljh.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
    if (localAEEditorDownloadResBean != null) {
      bljh.a(this.this$0, localAEEditorDownloadResBean, this.jdField_a_of_type_Bljm);
    }
    do
    {
      return;
      blfg.d("AEEditorFiltersManager", "downLoadResource--by user--FAIL, no download config for id: " + this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_Bljm == null);
    this.jdField_a_of_type_Bljm.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.5
 * JD-Core Version:    0.7.0.1
 */