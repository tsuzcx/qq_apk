package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataPrepare;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class LiveReadyFragment$onViewCreated$1<T>
  implements Observer<QQLiveAnchorDataPrepare>
{
  LiveReadyFragment$onViewCreated$1(LiveReadyFragment paramLiveReadyFragment) {}
  
  public final void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    if ((paramQQLiveAnchorDataPrepare != null) && (paramQQLiveAnchorDataPrepare.isSuccess))
    {
      QLog.d("QGL.LiveReadyFragment", 2, "anchorPrepareRoom suc");
      Object localObject = this.a;
      QQLiveAnchorDataRoomAttr localQQLiveAnchorDataRoomAttr = paramQQLiveAnchorDataPrepare.roomAttr;
      Intrinsics.checkExpressionValueIsNotNull(localQQLiveAnchorDataRoomAttr, "it.roomAttr");
      LiveReadyFragment.a((LiveReadyFragment)localObject, localQQLiveAnchorDataRoomAttr);
      if (paramQQLiveAnchorDataPrepare.roomInfo != null)
      {
        paramQQLiveAnchorDataPrepare = paramQQLiveAnchorDataPrepare.roomInfo;
        localObject = paramQQLiveAnchorDataPrepare.poster;
        LiveReadyFragment.a(this.a, paramQQLiveAnchorDataPrepare.id);
        LiveReadyFragment.a(this.a).setText((CharSequence)paramQQLiveAnchorDataPrepare.name);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          LiveReadyFragment.b(this.a).setImageDrawable(LiveReadyFragment.c(this.a));
        }
        else
        {
          paramQQLiveAnchorDataPrepare = ((IQQGuildAvatarApi)this.a.i().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable((String)localObject, 0, false);
          Intrinsics.checkExpressionValueIsNotNull(paramQQLiveAnchorDataPrepare, "appRuntime.getRuntimeSer…VATAR_SIZE_NOMAL, false )");
          LiveReadyFragment.b(this.a).setImageDrawable(paramQQLiveAnchorDataPrepare);
        }
        LiveReadyFragment.b(this.a).setCorner(ViewUtils.dpToPx(4.0F));
      }
      LiveReadyFragment.d(this.a).c().observe(this.a.getViewLifecycleOwner(), (Observer)new LiveReadyFragment.onViewCreated.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment.onViewCreated.1
 * JD-Core Version:    0.7.0.1
 */