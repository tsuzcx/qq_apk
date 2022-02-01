package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.core.common.ITPNativeLogCallback;
import com.tencent.thumbplayer.utils.TPLogUtil;

final class TPPlayerMgr$1
  implements ITPNativeLogCallback
{
  public void onPrintLog(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TPLogUtil.v(paramString1, paramString2);
      return;
    case 1: 
      TPLogUtil.d(paramString1, paramString2);
      return;
    case 2: 
      TPLogUtil.i(paramString1, paramString2);
      return;
    case 3: 
      TPLogUtil.w(paramString1, paramString2);
      return;
    }
    TPLogUtil.e(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerMgr.1
 * JD-Core Version:    0.7.0.1
 */