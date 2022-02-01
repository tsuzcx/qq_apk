package dov.com.qq.im.aeeditor.module.text;

import com.tencent.tavcut.bean.TextEditorData;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGText;
import org.libpag.PAGView;

class AEEditorTextEditDialog$3
  implements Runnable
{
  AEEditorTextEditDialog$3(AEEditorTextEditDialog paramAEEditorTextEditDialog, PAGFile paramPAGFile, TextEditorData paramTextEditorData, PAGText paramPAGText) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_OrgLibpagPAGFile != AEEditorTextEditDialog.a(this.this$0).getFile()) {
      AEEditorTextEditDialog.a(this.this$0).setFile(this.jdField_a_of_type_OrgLibpagPAGFile);
    }
    PAGFont localPAGFont = AEEditorTextEditDialog.a(this.this$0, this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    if (localPAGFont != null)
    {
      this.jdField_a_of_type_OrgLibpagPAGText.fontStyle = localPAGFont.fontStyle;
      this.jdField_a_of_type_OrgLibpagPAGText.fontFamily = localPAGFont.fontFamily;
    }
    AEEditorTextEditDialog.a(this.this$0).setTextData(0, this.jdField_a_of_type_OrgLibpagPAGText);
    AEEditorTextEditDialog.a(AEEditorTextEditDialog.a(this.this$0).getColorList(), AEEditorTextEditDialog.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog.3
 * JD-Core Version:    0.7.0.1
 */