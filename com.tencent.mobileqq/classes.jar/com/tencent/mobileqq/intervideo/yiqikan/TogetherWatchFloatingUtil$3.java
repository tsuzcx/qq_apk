package com.tencent.mobileqq.intervideo.yiqikan;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class TogetherWatchFloatingUtil$3
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherWatchFloatingUtil", 1, new Object[] { Integer.valueOf(paramEIPCResult.code) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil.3
 * JD-Core Version:    0.7.0.1
 */