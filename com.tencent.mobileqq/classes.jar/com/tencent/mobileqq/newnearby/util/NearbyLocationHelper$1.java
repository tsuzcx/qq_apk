package com.tencent.mobileqq.newnearby.util;

import com.tencent.mtt.hippy.modules.Promise;
import mqq.app.QQPermissionCallback;

final class NearbyLocationHelper$1
  implements QQPermissionCallback
{
  NearbyLocationHelper$1(Promise paramPromise) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.reject("user deny location permission");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    NearbyLocationHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.NearbyLocationHelper.1
 * JD-Core Version:    0.7.0.1
 */