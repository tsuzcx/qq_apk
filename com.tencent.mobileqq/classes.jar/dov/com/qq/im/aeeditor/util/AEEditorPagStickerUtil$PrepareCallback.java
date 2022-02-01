package dov.com.qq.im.aeeditor.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

public abstract interface AEEditorPagStickerUtil$PrepareCallback
{
  public abstract void a(AEEditorTextBean paramAEEditorTextBean, int paramInt);
  
  public abstract void a(AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean, @Nullable AEEditorPagStickerConfig paramAEEditorPagStickerConfig);
  
  public abstract void a(AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean, @NonNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.PrepareCallback
 * JD-Core Version:    0.7.0.1
 */