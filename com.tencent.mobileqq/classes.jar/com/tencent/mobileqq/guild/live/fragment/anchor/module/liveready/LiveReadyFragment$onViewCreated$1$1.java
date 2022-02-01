package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "pushInfo", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPushInfo;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class LiveReadyFragment$onViewCreated$1$1<T>
  implements Observer<QQLiveAnchorDataPushInfo>
{
  LiveReadyFragment$onViewCreated$1$1(LiveReadyFragment.onViewCreated.1 param1) {}
  
  public final void a(QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo)
  {
    if ((paramQQLiveAnchorDataPushInfo != null) && (paramQQLiveAnchorDataPushInfo.isSuccess))
    {
      LiveReadyFragment.e(this.a.a).setText((CharSequence)paramQQLiveAnchorDataPushInfo.serverPart);
      LiveReadyFragment.f(this.a.a).setText((CharSequence)paramQQLiveAnchorDataPushInfo.streamParam);
      paramQQLiveAnchorDataPushInfo = QQGuildLiveAnchorRoomMgr.a().d();
      Intrinsics.checkExpressionValueIsNotNull(paramQQLiveAnchorDataPushInfo, "preView");
      if ((paramQQLiveAnchorDataPushInfo.getParent() != null) && ((paramQQLiveAnchorDataPushInfo.getParent() instanceof ViewGroup)))
      {
        QLog.d("QGL.LiveReadyFragment", 1, "preView.parent is ViewGroup remove");
        ViewParent localViewParent = paramQQLiveAnchorDataPushInfo.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(paramQQLiveAnchorDataPushInfo);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
      LiveReadyFragment.g(this.a.a).addView(paramQQLiveAnchorDataPushInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment.onViewCreated.1.1
 * JD-Core Version:    0.7.0.1
 */