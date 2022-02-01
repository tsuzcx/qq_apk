package com.tencent.mobileqq.newnearby.hippy.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.newnearby.hippy.NearbyHippyCallback;
import com.tencent.mtt.hippy.modules.Promise;

class NearbyHippyBridgeImpl$13
  implements View.OnClickListener
{
  NearbyHippyBridgeImpl$13(NearbyHippyBridgeImpl paramNearbyHippyBridgeImpl, Promise paramPromise, int paramInt1, NearbyActivity paramNearbyActivity, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    NearbyHippyCallback.a(this.a, 1, this.b);
    NearbyHippyBridgeImpl.access$100(this.e, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.impl.NearbyHippyBridgeImpl.13
 * JD-Core Version:    0.7.0.1
 */