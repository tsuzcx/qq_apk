package dov.com.qq.im.aeeditor.module.edit;

import android.graphics.Bitmap;
import bnzb;
import bnzz;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import java.util.List;

class AEEditorImageEditFragment$12
  implements Runnable
{
  AEEditorImageEditFragment$12(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, int paramInt2, AEEditorFilterBean paramAEEditorFilterBean) {}
  
  public void run()
  {
    Bitmap localBitmap = AEEditorImageEditFragment.a(this.this$0, (String)AEEditorImageEditFragment.b(this.this$0).get(this.jdField_a_of_type_Int), ((bnzz)AEEditorImageEditFragment.a(this.this$0).get(this.jdField_a_of_type_Int)).a);
    if (localBitmap == null)
    {
      bnzb.d(AEEditorImageEditFragment.e(), "bitmap null error.");
      return;
    }
    AEEditorImageEditFragment.a(this.this$0, localBitmap, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.12
 * JD-Core Version:    0.7.0.1
 */