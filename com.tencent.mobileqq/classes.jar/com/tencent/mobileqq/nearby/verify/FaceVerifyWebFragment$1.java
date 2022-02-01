package com.tencent.mobileqq.nearby.verify;

import mqq.app.QQPermissionCallback;

class FaceVerifyWebFragment$1
  implements QQPermissionCallback
{
  FaceVerifyWebFragment$1(FaceVerifyWebFragment paramFaceVerifyWebFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 111) {
      FaceVerifyWebFragment.a(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.verify.FaceVerifyWebFragment.1
 * JD-Core Version:    0.7.0.1
 */