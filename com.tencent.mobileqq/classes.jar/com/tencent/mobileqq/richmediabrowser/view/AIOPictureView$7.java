package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class AIOPictureView$7
  implements EIPCResultCallback
{
  AIOPictureView$7(AIOPictureView paramAIOPictureView) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      this.a.mContext.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.7
 * JD-Core Version:    0.7.0.1
 */