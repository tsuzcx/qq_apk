package com.tencent.mobileqq.gamecenter.fragment;

import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.qphone.base.util.QLog;

class QQGamePadFaceFragment$2
  implements ArkViewImplement.LoadCallback
{
  QQGamePadFaceFragment$2(QQGamePadFaceFragment paramQQGamePadFaceFragment) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    if ((QLog.isColorLevel()) || (paramInt == -1)) {
      QLog.d("QQGamePadFaceFragment", 2, new Object[] { "onLoadFinish, ret=", Integer.valueOf(paramInt), ", ", QQGamePadFaceFragment.c(this.a) });
    }
    if (paramInt == 1)
    {
      QQGamePadFaceFragment.d(this.a).b(QQGamePadFaceFragment.c(this.a).padFaceId);
      return;
    }
    if (paramInt == -1)
    {
      QQGamePadFaceFragment.d(this.a).b(QQGamePadFaceFragment.c(this.a).padFaceId);
      QQGamePadFaceFragment.e(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment.2
 * JD-Core Version:    0.7.0.1
 */