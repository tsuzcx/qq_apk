package dov.com.qq.im.aeeditor.module.text;

import bpjw;
import com.tencent.tavcut.bean.TextEditorData;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class AEEditorTextEditDialog$3
  implements Runnable
{
  public AEEditorTextEditDialog$3(bpjw parambpjw, PAGFile paramPAGFile, TextEditorData paramTextEditorData, PAGText paramPAGText) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_OrgLibpagPAGFile != bpjw.a(this.this$0).getFile()) {
      bpjw.a(this.this$0).setFile(this.jdField_a_of_type_OrgLibpagPAGFile);
    }
    PAGFont localPAGFont = bpjw.a(this.this$0, this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    if (localPAGFont != null)
    {
      this.jdField_a_of_type_OrgLibpagPAGText.fontStyle = localPAGFont.fontStyle;
      this.jdField_a_of_type_OrgLibpagPAGText.fontFamily = localPAGFont.fontFamily;
    }
    bpjw.a(this.this$0).setTextData(0, this.jdField_a_of_type_OrgLibpagPAGText);
    bpjw.a(bpjw.a(this.this$0).getColorList(), bpjw.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog.3
 * JD-Core Version:    0.7.0.1
 */