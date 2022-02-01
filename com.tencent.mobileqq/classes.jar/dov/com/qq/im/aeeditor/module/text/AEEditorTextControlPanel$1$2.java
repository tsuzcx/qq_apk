package dov.com.qq.im.aeeditor.module.text;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.PagTransformManager.PagTransformListener;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.ae.util.AEQLog;
import mqq.os.MqqHandler;

class AEEditorTextControlPanel$1$2
  implements PagTransformManager.PagTransformListener
{
  AEEditorTextControlPanel$1$2(AEEditorTextControlPanel.1 param1, String paramString, int paramInt) {}
  
  public void onBitmapSaveDone(@Nullable Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      BitmapUtils.saveBitmap2PNG(paramBitmap, this.jdField_a_of_type_JavaLangString);
      ThreadManager.getUIHandler().post(new AEEditorTextControlPanel.1.2.1(this));
      return;
    }
    AEQLog.d("AEEditorTextControlPanel", "[createImageAndUpdate] bimap is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.1.2
 * JD-Core Version:    0.7.0.1
 */