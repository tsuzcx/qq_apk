package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.nearby.FaceScoreCallBack;

class NearbyProfileFragment$8
  extends FaceScoreCallBack
{
  NearbyProfileFragment$8(NearbyProfileFragment paramNearbyProfileFragment, long paramLong) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.a == paramLong1) && (paramLong2 > 0L))
    {
      this.b.e.tinyId = paramLong2;
      if (!NearbyProfileCardUtils.a(this.b.c.from)) {
        this.b.c.mTinyId = paramLong2;
      }
      this.b.a(paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.8
 * JD-Core Version:    0.7.0.1
 */