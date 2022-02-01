package com.tencent.mobileqq.wink.editor.sticker;

import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.ResDownLoadListener;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.Status;

final class WinkEditorTextPagUtils$3
  implements WinkEditorResourceDownloader.ResDownLoadListener
{
  WinkEditorTextPagUtils$3(ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void a(int paramInt)
  {
    ApplyMaterialTask.MaterialStatusCallback localMaterialStatusCallback = this.a;
    ApplyMaterialTask.Status localStatus = ApplyMaterialTask.Status.ONGOING;
    double d = paramInt;
    Double.isNaN(d);
    localMaterialStatusCallback.onStatusChanged(localStatus, (int)(d * 0.34D + 66.0D));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.WinkEditorTextPagUtils.3
 * JD-Core Version:    0.7.0.1
 */