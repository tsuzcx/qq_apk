package com.tencent.mobileqq.intervideo.yiqikan;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class TogetherWatchFloatingUtil$5
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "ACTION_QUIT_WATCH_FLOATING_WINDOWS result=", Integer.valueOf(paramEIPCResult.code) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil.5
 * JD-Core Version:    0.7.0.1
 */