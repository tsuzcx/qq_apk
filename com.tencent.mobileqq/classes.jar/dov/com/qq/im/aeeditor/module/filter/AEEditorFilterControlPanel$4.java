package dov.com.qq.im.aeeditor.module.filter;

import bhmi;
import java.io.File;

class AEEditorFilterControlPanel$4
  implements Runnable
{
  AEEditorFilterControlPanel$4(AEEditorFilterControlPanel paramAEEditorFilterControlPanel, String paramString, AEEditorFilterBean paramAEEditorFilterBean, int paramInt) {}
  
  public void run()
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      localObject = bhmi.a((File)localObject);
      localObject = AEEditorFilterControlPanel.a(this.this$0, (String)localObject);
      if (localObject != null)
      {
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.setEffectExtendBean((AEFilterExtendBean)localObject);
        AEEditorFilterControlPanel.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.4
 * JD-Core Version:    0.7.0.1
 */