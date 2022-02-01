package dov.com.qq.im.aeeditor.module.text;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;

class AETextStickerAdapter$3
  implements Runnable
{
  AETextStickerAdapter$3(AETextStickerAdapter paramAETextStickerAdapter, AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.isDownloading = false;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.progress = 100;
      AEQLog.d("AETextStickerAdapter", "[onPrepareCompleted] success");
      int i = AETextStickerAdapter.a(this.this$0).indexOf(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
      if (i == AETextStickerAdapter.d(this.this$0)) {
        if (AETextStickerAdapter.a(this.this$0) != null) {
          AETextStickerAdapter.a(this.this$0).a(i, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
        }
      }
    }
    for (;;)
    {
      this.this$0.notifyDataSetChanged();
      return;
      AEQLog.a("AETextStickerAdapter", "[onPrepareCompleted] not last selected item");
      continue;
      QQToast.a(BaseApplicationImpl.getContext(), 2131691908, 1).a();
      AEQLog.d("AETextStickerAdapter", "[onPrepareCompleted] failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.3
 * JD-Core Version:    0.7.0.1
 */