package com.tencent.mobileqq.guild.audio.dialog;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet.ActionSheetListener;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogTitleBar;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/audio/dialog/IAudioDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mApp", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "mAudioRoomObserver", "Lcom/tencent/mobileqq/guild/audio/AudioRoomObserver;", "mChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildTitle", "Landroid/widget/TextView;", "mInviteIcon", "Landroid/widget/ImageView;", "mLastClickMills", "", "mOnLineNum", "mRootView", "Landroid/view/View;", "mSetIcon", "mTitle", "create", "", "guildInfo", "channelInfo", "app", "destroy", "handleInvite", "handleSetting", "initView", "onClick", "v", "refreshUI", "localUserInfo", "Lcom/tencent/mobileqq/guild/audio/data/LocalUserInfo;", "userInfoList", "Lcom/tencent/mobileqq/guild/audio/data/UserInfoList;", "start", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildAudioDialogTitleBar
  extends FrameLayout
  implements View.OnClickListener, IAudioDialogView
{
  private View a;
  private TextView b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private IGProGuildInfo g;
  private IGProChannelInfo h;
  private BaseQQAppInterface i;
  private long j;
  private final AudioRoomObserver k = (AudioRoomObserver)new QQGuildAudioDialogTitleBar.mAudioRoomObserver.1(this);
  
  public QQGuildAudioDialogTitleBar(@NotNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public QQGuildAudioDialogTitleBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQGuildAudioDialogTitleBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    paramContext = FrameLayout.inflate(paramContext, 2131624993, (ViewGroup)this);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "inflate(context, R.layou…o_dialog_title_bar, this)");
    this.a = paramContext;
    paramContext = this.a;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428871);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_title_tv)");
    this.b = ((TextView)paramContext);
    paramContext = this.a;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428850);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_guild_title_tv)");
    this.d = ((TextView)paramContext);
    paramContext = this.a;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428870);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_title_bracket)");
    this.c = ((TextView)paramContext);
    paramContext = this.a;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428855);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_invite_iv)");
    this.e = ((ImageView)paramContext);
    paramContext = this.a;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428868);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_setting_iv)");
    this.f = ((ImageView)paramContext);
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitle");
    }
    paramContext = (View.OnClickListener)this;
    ((TextView)localObject).setOnClickListener(paramContext);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildTitle");
    }
    ((TextView)localObject).setOnClickListener(paramContext);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mInviteIcon");
    }
    ((ImageView)localObject).setOnClickListener(paramContext);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSetIcon");
    }
    ((ImageView)localObject).setOnClickListener(paramContext);
  }
  
  private final void d()
  {
    Object localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSetIcon");
    }
    VideoReport.reportEvent("clck", localObject1, null);
    localObject1 = (IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class);
    Context localContext = getContext();
    Object localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
    }
    localObject2 = ((IGProGuildInfo)localObject2).getGuildID();
    IGProChannelInfo localIGProChannelInfo1 = this.h;
    if (localIGProChannelInfo1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    IGProChannelInfo localIGProChannelInfo2 = this.h;
    if (localIGProChannelInfo2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    ((IQQGuildRouterApi)localObject1).openAudioChannelInfoSetting(localContext, (String)localObject2, localIGProChannelInfo1, localIGProChannelInfo2.getCategoryName(), 2);
  }
  
  public void a()
  {
    BaseQQAppInterface localBaseQQAppInterface = this.i;
    if (localBaseQQAppInterface == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    localBaseQQAppInterface.addObserver((BusinessObserver)this.k);
  }
  
  public final void a(@NotNull LocalUserInfo paramLocalUserInfo, @NotNull UserInfoList paramUserInfoList)
  {
    Intrinsics.checkParameterIsNotNull(paramLocalUserInfo, "localUserInfo");
    Intrinsics.checkParameterIsNotNull(paramUserInfoList, "userInfoList");
    Object localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    localObject = ((IGProChannelInfo)localObject).getChannelName();
    int m = paramUserInfoList.a.size();
    if (m != 0)
    {
      paramUserInfoList = this.c;
      if (paramUserInfoList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mOnLineNum");
      }
      paramUserInfoList.setVisibility(0);
      if (m > 99)
      {
        paramUserInfoList = this.c;
        if (paramUserInfoList == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mOnLineNum");
        }
        paramUserInfoList.setText((CharSequence)"(99+)");
      }
      else
      {
        paramUserInfoList = this.c;
        if (paramUserInfoList == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mOnLineNum");
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append('(');
        localStringBuilder.append(m);
        localStringBuilder.append(')');
        paramUserInfoList.setText((CharSequence)localStringBuilder.toString());
      }
    }
    else
    {
      paramUserInfoList = this.c;
      if (paramUserInfoList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mOnLineNum");
      }
      paramUserInfoList.setVisibility(8);
    }
    paramUserInfoList = this.b;
    if (paramUserInfoList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitle");
    }
    paramUserInfoList.setText((CharSequence)localObject);
    paramUserInfoList = this.d;
    if (paramUserInfoList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildTitle");
    }
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
    }
    paramUserInfoList.setText((CharSequence)((IGProGuildInfo)localObject).getGuildName());
    if (paramLocalUserInfo.k == 0)
    {
      paramLocalUserInfo = this.f;
      if (paramLocalUserInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSetIcon");
      }
      paramLocalUserInfo.setVisibility(8);
      return;
    }
    paramLocalUserInfo = this.f;
    if (paramLocalUserInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSetIcon");
    }
    paramLocalUserInfo.setVisibility(0);
  }
  
  public void a(@NotNull IGProGuildInfo paramIGProGuildInfo, @NotNull IGProChannelInfo paramIGProChannelInfo, @NotNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramIGProGuildInfo, "guildInfo");
    Intrinsics.checkParameterIsNotNull(paramIGProChannelInfo, "channelInfo");
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    this.g = paramIGProGuildInfo;
    this.h = paramIGProChannelInfo;
    paramIGProGuildInfo = this.b;
    if (paramIGProGuildInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitle");
    }
    paramIGProChannelInfo = this.h;
    if (paramIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    paramIGProGuildInfo.setText((CharSequence)paramIGProChannelInfo.getChannelName());
    paramIGProGuildInfo = this.d;
    if (paramIGProGuildInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildTitle");
    }
    paramIGProChannelInfo = this.g;
    if (paramIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
    }
    paramIGProGuildInfo.setText((CharSequence)paramIGProChannelInfo.getGuildName());
    this.i = paramBaseQQAppInterface;
  }
  
  public void b()
  {
    BaseQQAppInterface localBaseQQAppInterface = this.i;
    if (localBaseQQAppInterface == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    localBaseQQAppInterface.removeObserver((BusinessObserver)this.k);
  }
  
  public final void c()
  {
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mInviteIcon");
    }
    VideoReport.reportEvent("clck", localObject, null);
    localObject = getContext();
    if (localObject != null)
    {
      localObject = (Activity)localObject;
      IGProGuildInfo localIGProGuildInfo = this.g;
      if (localIGProGuildInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
      }
      IGProChannelInfo localIGProChannelInfo = this.h;
      if (localIGProChannelInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
      }
      if (new GuildShareActionSheet((Activity)localObject, localIGProGuildInfo, localIGProChannelInfo).a((GuildShareActionSheet.ActionSheetListener)new QQGuildAudioDialogTitleBar.handleInvite.canShow.1())) {
        AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.HIDE);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (System.currentTimeMillis() - this.j < 500)
    {
      this.j = System.currentTimeMillis();
    }
    else
    {
      this.j = System.currentTimeMillis();
      int m = paramView.getId();
      if (m == 2131428855) {
        c();
      } else if (m == 2131428868) {
        d();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogTitleBar
 * JD-Core Version:    0.7.0.1
 */