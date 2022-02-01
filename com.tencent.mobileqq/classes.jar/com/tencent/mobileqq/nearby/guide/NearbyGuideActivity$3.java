package com.tencent.mobileqq.nearby.guide;

import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import java.util.ArrayList;

class NearbyGuideActivity$3
  extends NearbyCardObserver
{
  NearbyGuideActivity$3(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void a(boolean paramBoolean, ArrayList<Object> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new NearbyGuideActivity.3.1(this, paramBoolean, paramInt1, paramArrayList));
  }
  
  public void b(boolean paramBoolean, ArrayList<Object> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new NearbyGuideActivity.3.2(this, paramBoolean, paramInt1, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.3
 * JD-Core Version:    0.7.0.1
 */