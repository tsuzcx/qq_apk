package com.tencent.mobileqq.wink.flow;

import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.ResDownLoadListener;

final class ApplyMaterialTaskHelper$1
  implements WinkEditorResourceDownloader.ResDownLoadListener
{
  ApplyMaterialTaskHelper$1(ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void a(int paramInt)
  {
    this.a.onStatusChanged(ApplyMaterialTask.Status.ONGOING, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    this.a.onStatusChanged(ApplyMaterialTask.Status.FAILED, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.flow.ApplyMaterialTaskHelper.1
 * JD-Core Version:    0.7.0.1
 */