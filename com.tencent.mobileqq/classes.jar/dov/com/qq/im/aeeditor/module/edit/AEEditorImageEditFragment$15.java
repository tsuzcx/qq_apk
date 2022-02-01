package dov.com.qq.im.aeeditor.module.edit;

import android.graphics.Bitmap;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import java.util.List;

class AEEditorImageEditFragment$15
  implements Runnable
{
  AEEditorImageEditFragment$15(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, int paramInt2, AEEditorFilterBean paramAEEditorFilterBean) {}
  
  public void run()
  {
    Bitmap localBitmap = AEEditorImageEditFragment.a(this.this$0, (String)AEEditorImageEditFragment.b(this.this$0).get(this.jdField_a_of_type_Int), ((AEEditorImageInfo)AEEditorImageEditFragment.a(this.this$0).get(this.jdField_a_of_type_Int)).a);
    if (localBitmap == null)
    {
      AEQLog.d("AEEditorImageEditFragment", "bitmap null error.");
      return;
    }
    AEEditorImageEditFragment.a(this.this$0, localBitmap, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.15
 * JD-Core Version:    0.7.0.1
 */