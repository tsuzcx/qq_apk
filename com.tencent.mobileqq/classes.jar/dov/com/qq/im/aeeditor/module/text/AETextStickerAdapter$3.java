package dov.com.qq.im.aeeditor.module.text;

import bnzb;
import boik;
import boim;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class AETextStickerAdapter$3
  implements Runnable
{
  public AETextStickerAdapter$3(boik paramboik, AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.isDownloading = false;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.progress = 100;
      bnzb.d("AETextStickerAdapter", "[onPrepareCompleted] success");
      int i = boik.a(this.this$0).indexOf(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
      if (i == boik.c(this.this$0)) {
        if (boik.a(this.this$0) != null) {
          boik.a(this.this$0).a(i, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
        }
      }
    }
    for (;;)
    {
      this.this$0.notifyDataSetChanged();
      return;
      bnzb.a("AETextStickerAdapter", "[onPrepareCompleted] not last selected item");
      continue;
      QQToast.a(BaseApplicationImpl.getContext(), 2131691658, 1).a();
      bnzb.d("AETextStickerAdapter", "[onPrepareCompleted] failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.3
 * JD-Core Version:    0.7.0.1
 */