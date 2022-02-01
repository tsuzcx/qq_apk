package dov.com.qq.im.aeeditor.module.text;

import java.util.List;

class AETextStickerAdapter$2
  implements Runnable
{
  AETextStickerAdapter$2(AETextStickerAdapter paramAETextStickerAdapter, AEEditorTextBean paramAEEditorTextBean, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.progress = this.jdField_a_of_type_Int;
    int i = AETextStickerAdapter.a(this.this$0).indexOf(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
    if (i >= 0) {
      this.this$0.notifyItemChanged(i, Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.2
 * JD-Core Version:    0.7.0.1
 */