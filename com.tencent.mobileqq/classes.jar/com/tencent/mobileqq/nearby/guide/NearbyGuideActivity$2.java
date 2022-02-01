package com.tencent.mobileqq.nearby.guide;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;

class NearbyGuideActivity$2
  extends NearbyCardObserver
{
  NearbyGuideActivity$2(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      this.a.app.deleteStrangerFace(this.a.app.getCurrentAccountUin(), 200);
      long l = ((Long)NearbySPUtil.a(this.a.app.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
      if (l != 0L) {
        this.a.app.deleteStrangerFace(String.valueOf(l), 200);
      }
    }
    this.a.runOnUiThread(new NearbyGuideActivity.2.1(this, paramBoolean1, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2
 * JD-Core Version:    0.7.0.1
 */