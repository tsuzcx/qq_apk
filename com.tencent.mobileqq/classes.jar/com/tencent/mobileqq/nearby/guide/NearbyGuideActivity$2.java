package com.tencent.mobileqq.nearby.guide;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.qroute.QRoute;

class NearbyGuideActivity$2
  extends NearbyCardObserver
{
  NearbyGuideActivity$2(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void a(boolean paramBoolean1, Object paramObject, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      this.a.app.deleteStrangerFace(this.a.app.getCurrentAccountUin(), 200);
      long l = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.app.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
      if (l != 0L) {
        this.a.app.deleteStrangerFace(String.valueOf(l), 200);
      }
    }
    this.a.runOnUiThread(new NearbyGuideActivity.2.1(this, paramBoolean1, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2
 * JD-Core Version:    0.7.0.1
 */