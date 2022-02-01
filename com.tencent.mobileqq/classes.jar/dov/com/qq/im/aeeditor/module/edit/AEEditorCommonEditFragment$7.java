package dov.com.qq.im.aeeditor.module.edit;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.PrepareCallback;
import mqq.os.MqqHandler;

class AEEditorCommonEditFragment$7
  implements AEEditorPagStickerUtil.PrepareCallback
{
  AEEditorCommonEditFragment$7(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void a(AEEditorTextBean paramAEEditorTextBean, int paramInt) {}
  
  public void a(AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean, @Nullable AEEditorPagStickerConfig paramAEEditorPagStickerConfig) {}
  
  public void a(AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean, @NonNull String paramString)
  {
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.7.1(this));
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.7.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.7
 * JD-Core Version:    0.7.0.1
 */