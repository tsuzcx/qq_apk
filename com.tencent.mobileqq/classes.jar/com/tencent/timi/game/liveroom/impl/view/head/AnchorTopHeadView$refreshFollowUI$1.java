package com.tencent.timi.game.liveroom.impl.view.head;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorTopHeadView$refreshFollowUI$1
  implements View.OnClickListener
{
  AnchorTopHeadView$refreshFollowUI$1(AnchorTopHeadView paramAnchorTopHeadView) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = AnchorTopHeadView.e(this.a);
    if (localObject1 == null)
    {
      Logger.c("AnchorTopHeadView_", 1, "followTxv#onclick liveRoom is null");
      QQToast.makeText(this.a.getContext(), (CharSequence)"房间数据异常，请重新进入直播间后再试试", 0).show();
    }
    else
    {
      localObject1 = ((ILiveRoom)localObject1).getAnchorInfo();
      if (localObject1 == null)
      {
        Logger.c("AnchorTopHeadView_", 1, "followTxv#onclick anchorInfo is null");
      }
      else
      {
        Object localObject2 = ServiceCenter.a(ITgLiveRoomService.class);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "ServiceCenter.getService…eRoomService::class.java)");
        localObject2 = ((ITgLiveRoomService)localObject2).d();
        if (localObject2 == null)
        {
          Logger.c("AnchorTopHeadView_", 1, "followTxv#onclick qqLiveSdk is null");
        }
        else
        {
          localObject2 = ((IQQLiveSDK)localObject2).getFollowMsgService();
          if (localObject2 == null) {
            Logger.c("AnchorTopHeadView_", 1, "followTxv#onclick followService is null");
          } else {
            ((IQQLiveFollowMsgService)localObject2).followAnchor(((BaseAnchorInfo)localObject1).getAnchorUid(), AnchorTopHeadView.a(this.a), (IQQLiveFollowCallback)new AnchorTopHeadView.refreshFollowUI.1.1(this));
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.refreshFollowUI.1
 * JD-Core Version:    0.7.0.1
 */