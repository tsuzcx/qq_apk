package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager.CommentEventListener;
import com.tencent.viola.core.ViolaInstance;

class BridgeModule$13
  implements ViolaCommentManager.CommentEventListener
{
  private String b;
  private boolean c;
  
  BridgeModule$13(BridgeModule paramBridgeModule) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    if ((this.a.getViolaInstance() != null) && ((this.a.getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)this.a.getViolaInstance().getFragment();
      if (paramBoolean)
      {
        this.b = localViolaFragment.getStatusBarColor();
        this.c = localViolaFragment.getStatusBarFontColorWhite().booleanValue();
        localViolaFragment.setStatusBarColor("#FF000000");
        localViolaFragment.initStatusBarColor("#FF000000");
        localViolaFragment.setStatusBarFontColor(Boolean.valueOf(true), true);
        return;
      }
      localViolaFragment.setStatusBarColor(this.b);
      localViolaFragment.initStatusBarColor(this.b);
      localViolaFragment.setStatusBarFontColor(Boolean.valueOf(this.c), true);
      if ((localViolaFragment.isSuspension()) && (localViolaFragment.getCommonSuspensionGestureLayout() != null) && ((localViolaFragment.getCommonSuspensionGestureLayout() instanceof CommonSuspensionGestureLayout))) {
        ((CommonSuspensionGestureLayout)localViolaFragment.getCommonSuspensionGestureLayout()).j();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.13
 * JD-Core Version:    0.7.0.1
 */