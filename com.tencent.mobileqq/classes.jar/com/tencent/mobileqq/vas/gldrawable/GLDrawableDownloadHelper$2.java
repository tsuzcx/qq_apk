package com.tencent.mobileqq.vas.gldrawable;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class GLDrawableDownloadHelper$2
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLDrawableDownloadHelper", 2, "requestDownloadDepends success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper.2
 * JD-Core Version:    0.7.0.1
 */