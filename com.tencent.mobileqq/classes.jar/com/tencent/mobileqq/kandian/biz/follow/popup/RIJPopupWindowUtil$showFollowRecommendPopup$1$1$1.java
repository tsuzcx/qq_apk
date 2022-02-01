package com.tencent.mobileqq.kandian.biz.follow.popup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"}, k=3, mv={1, 1, 16})
final class RIJPopupWindowUtil$showFollowRecommendPopup$1$1$1
  implements DialogInterface.OnShowListener
{
  public static final 1 a = new 1();
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new RIJFollowRecommendPopupEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJPopupWindowUtil.showFollowRecommendPopup.1.1.1
 * JD-Core Version:    0.7.0.1
 */