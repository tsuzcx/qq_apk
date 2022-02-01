package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.core.common.ITPNativeLogCallback;
import com.tencent.thumbplayer.utils.TPLogUtil;

final class TPPlayerMgr$1
  implements ITPNativeLogCallback
{
  public void onPrintLog(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            TPLogUtil.e(paramString1, paramString2);
            return;
          }
          TPLogUtil.w(paramString1, paramString2);
          return;
        }
        TPLogUtil.i(paramString1, paramString2);
        return;
      }
      TPLogUtil.d(paramString1, paramString2);
      return;
    }
    TPLogUtil.v(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerMgr.1
 * JD-Core Version:    0.7.0.1
 */