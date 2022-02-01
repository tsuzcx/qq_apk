package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/mainframe/helper/jump/JoinGuildVoiceChannelFrag;", "Lcom/tencent/mobileqq/guild/channel/create/fragment/BaseCreateSubChannelFragment;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mAudioChannelName", "Landroid/widget/TextView;", "mAudioGuildAvatar", "Lcom/tencent/image/URLImageView;", "mAudioGuildName", "mAudioJoinBtn", "Landroid/widget/Button;", "mChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mIntercept", "Landroid/view/View;", "mIsNeedJoinGuild", "", "mJoinGuildParam", "Lcom/tencent/mobileqq/guild/mainframe/helper/JoinGuildParam;", "getContentLayoutId", "", "init", "", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setDtElement", "setDtPage", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class JoinGuildVoiceChannelFrag
  extends BaseCreateSubChannelFragment
  implements View.OnClickListener
{
  public static final JoinGuildVoiceChannelFrag.Companion d = new JoinGuildVoiceChannelFrag.Companion(null);
  @NotNull
  private final String e = "JoinGuildVoiceChannelFrag";
  private URLImageView f;
  private TextView g;
  private TextView h;
  private Button i;
  private View j;
  private IGProGuildInfo k;
  private IGProChannelInfo l;
  private boolean m;
  private JoinGuildParam n;
  private HashMap o;
  
  private final void e()
  {
    VideoReport.setPageId(this.a, "pg_sgrp_voicechannel_invitation");
    Map localMap = (Map)new HashMap();
    localMap.put("pgid", "pg_sgrp_voicechannel_invitation");
    Object localObject = this.l;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((IGProChannelInfo)localObject).getGuildId();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mChannelInfo!!.guildId");
      localMap.put("sgrp_channel_id", localObject);
      localObject = this.l;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((IGProChannelInfo)localObject).getChannelUin();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mChannelInfo!!.channelUin");
      localMap.put("sgrp_voicechannel_profile_uin", localObject);
    }
    VideoReport.setPageParams(this.a, new PageParams(localMap));
    VideoReport.reportEvent("pgin", this.a, localMap);
  }
  
  private final void f()
  {
    Object localObject = (IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class);
    Button localButton = this.i;
    if (localButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAudioJoinBtn");
    }
    ((IGuildDTReportApi)localObject).setElementClickParams((View)localButton, "em_sgrp_voicechannel_join", null);
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAudioJoinBtn");
    }
    VideoReport.reportEvent("imp", localObject, null);
  }
  
  protected int b()
  {
    return 2131625046;
  }
  
  protected void c()
  {
    Object localObject1 = this.a.findViewById(2131434544);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView.findViewById(R.id.guild_avatar_image)");
    this.f = ((URLImageView)localObject1);
    localObject1 = this.a.findViewById(2131448937);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView.findViewById(R.id.txt_guild_name)");
    this.g = ((TextView)localObject1);
    localObject1 = this.a.findViewById(2131448921);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView.findViewById(R.id.txt_channel_name)");
    this.h = ((TextView)localObject1);
    localObject1 = this.a.findViewById(2131429916);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView.findViewById(R.id.btn_join)");
    this.i = ((Button)localObject1);
    localObject1 = this.a.findViewById(2131430777);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView.findViewById(R.id.click_intercept_bg)");
    this.j = ((View)localObject1);
    Object localObject2 = this.i;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAudioJoinBtn");
    }
    localObject1 = (View.OnClickListener)this;
    ((Button)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    localObject2 = this.j;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIntercept");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    if (this.k != null)
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
      localObject2 = this.k;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = URLDrawable.getDrawable(((IGProGuildInfo)localObject2).getAvatarUrl(0), (URLDrawable.URLDrawableOptions)localObject1);
      int i1 = ViewUtils.dpToPx(56.0F);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "urlDrawable");
      ((URLDrawable)localObject1).setTag(new int[] { i1, i1 });
      ((URLDrawable)localObject1).setDecodeHandler(QQGuildUtil.d);
      localObject2 = this.f;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAudioGuildAvatar");
      }
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
      localObject1 = this.g;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAudioGuildName");
      }
      localObject2 = this.k;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((TextView)localObject1).setText((CharSequence)((IGProGuildInfo)localObject2).getGuildName());
    }
    if (this.l != null)
    {
      localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAudioChannelName");
      }
      localObject2 = this.l;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((TextView)localObject1).setText((CharSequence)((IGProChannelInfo)localObject2).getChannelName());
    }
    e();
    f();
  }
  
  public void d()
  {
    HashMap localHashMap = this.o;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (paramView.getId() == 2131429916)
    {
      Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      if (localObject != null) {
        if ((this.m) && (this.n != null))
        {
          QQGuildJumpSource.a(3);
          JoinGuildParam localJoinGuildParam = this.n;
          if (localJoinGuildParam == null) {
            Intrinsics.throwNpe();
          }
          localObject = ((AppRuntime)localObject).getRuntimeService(IQQGuildService.class, "");
          Intrinsics.checkExpressionValueIsNotNull(localObject, "appRuntime.getRuntimeSer…va, ProcessConstant.MAIN)");
          ((IQQGuildService)localObject).addGuildAndJump2AIO(getContext(), localJoinGuildParam.guildId, localJoinGuildParam.joinSignature, localJoinGuildParam.from, localJoinGuildParam.channelId, localJoinGuildParam.extras);
        }
        else
        {
          ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchAudioChatPie((Context)BaseApplication.getContext(), this.k, this.l, true);
        }
      }
    }
    this.c.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.k = ((IGProGuildInfo)paramBundle.get("extra_guild_guild_info"));
      this.l = ((IGProChannelInfo)paramBundle.get("extra_guild_channel_info"));
      this.n = ((JoinGuildParam)paramBundle.get("extra_key_join_guild_params"));
      paramBundle = paramBundle.get("extra_key_is_need_join_guild");
      if (paramBundle != null)
      {
        this.m = ((Boolean)paramBundle).booleanValue();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildVoiceChannelFrag
 * JD-Core Version:    0.7.0.1
 */