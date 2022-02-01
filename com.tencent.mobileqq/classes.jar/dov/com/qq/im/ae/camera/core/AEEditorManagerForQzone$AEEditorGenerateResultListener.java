package dov.com.qq.im.ae.camera.core;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public abstract interface AEEditorManagerForQzone$AEEditorGenerateResultListener
{
  public abstract void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo);
  
  public abstract void onAETavSessionExportError(String paramString, int paramInt);
  
  public abstract void onAETavSessionExporting(String paramString, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone.AEEditorGenerateResultListener
 * JD-Core Version:    0.7.0.1
 */