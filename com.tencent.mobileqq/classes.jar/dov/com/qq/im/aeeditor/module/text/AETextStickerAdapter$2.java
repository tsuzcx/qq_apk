package dov.com.qq.im.aeeditor.module.text;

import bmnb;
import java.util.List;

public class AETextStickerAdapter$2
  implements Runnable
{
  public AETextStickerAdapter$2(bmnb parambmnb, AEEditorTextBean paramAEEditorTextBean, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.progress = this.jdField_a_of_type_Int;
    int i = bmnb.a(this.this$0).indexOf(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
    if (i >= 0) {
      this.this$0.notifyItemChanged(i, Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.2
 * JD-Core Version:    0.7.0.1
 */