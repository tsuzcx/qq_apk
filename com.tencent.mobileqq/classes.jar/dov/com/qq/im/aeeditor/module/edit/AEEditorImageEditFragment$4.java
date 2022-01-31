package dov.com.qq.im.aeeditor.module.edit;

import android.graphics.Bitmap;
import bljn;
import blki;
import java.util.List;

class AEEditorImageEditFragment$4
  implements Runnable
{
  AEEditorImageEditFragment$4(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt) {}
  
  public void run()
  {
    Bitmap localBitmap = AEEditorImageEditFragment.a(this.this$0, (String)AEEditorImageEditFragment.a(this.this$0).get(this.a), ((blki)AEEditorImageEditFragment.b(this.this$0).get(this.a)).a);
    if (localBitmap == null)
    {
      bljn.d(AEEditorImageEditFragment.e(), "bitmap null error.");
      return;
    }
    AEEditorImageEditFragment.a(this.this$0, localBitmap, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.4
 * JD-Core Version:    0.7.0.1
 */