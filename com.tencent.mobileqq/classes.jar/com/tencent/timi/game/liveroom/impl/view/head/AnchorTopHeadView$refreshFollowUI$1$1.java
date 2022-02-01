package com.tencent.timi.game.liveroom.impl.view.head;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/head/AnchorTopHeadView$refreshFollowUI$1$1", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopHeadView$refreshFollowUI$1$1
  implements IQQLiveFollowCallback
{
  public void a()
  {
    AnchorTopHeadView.a(this.a.a, true, true, false);
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    QQToast.makeText(this.a.a.getContext(), (CharSequence)"关注失败，请稍后重试", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.refreshFollowUI.1.1
 * JD-Core Version:    0.7.0.1
 */