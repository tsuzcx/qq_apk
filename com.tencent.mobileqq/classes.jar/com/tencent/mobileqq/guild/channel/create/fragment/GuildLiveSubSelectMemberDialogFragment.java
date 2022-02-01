package com.tencent.mobileqq.guild.channel.create.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.dialog.GuildLiveAnchorSelectMemberFragment;
import com.tencent.mobileqq.guild.privatechannel.dialog.GuildLiveAnchorSelectMemberFragment.Companion;
import com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateAppSubSelectMemberDialogFragment;
import com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/channel/create/fragment/GuildLiveSubSelectMemberDialogFragment;", "Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildPrivateAppSubSelectMemberDialogFragment;", "()V", "finishSelectFlag", "", "getFinishSelectFlag", "()Z", "setFinishSelectFlag", "(Z)V", "selectCallback", "Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildPrivateAppSubSelectMemberDialogFragment$OnMemberSelectCallback;", "getSelectCallback", "()Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildPrivateAppSubSelectMemberDialogFragment$OnMemberSelectCallback;", "setSelectCallback", "(Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildPrivateAppSubSelectMemberDialogFragment$OnMemberSelectCallback;)V", "closeAndBackLastPage", "", "getContentFragment", "Landroidx/fragment/app/Fragment;", "createSubChannelInfo", "Lcom/tencent/mobileqq/guild/channel/create/CreateSubChannelInfo;", "setLiveSelectCallback", "cb", "setVisibleMembers", "visibleType", "", "visibleMembers", "", "", "(I[Ljava/lang/String;)V", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildLiveSubSelectMemberDialogFragment
  extends GuildPrivateAppSubSelectMemberDialogFragment
{
  public static final GuildLiveSubSelectMemberDialogFragment.Companion g = new GuildLiveSubSelectMemberDialogFragment.Companion(null);
  @Nullable
  private GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback l;
  private boolean m;
  private HashMap n;
  
  @NotNull
  protected Fragment a(@NotNull CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramCreateSubChannelInfo, "createSubChannelInfo");
    Object localObject = GuildLiveAnchorSelectMemberFragment.d;
    IGProGuildInfo localIGProGuildInfo = this.h;
    Intrinsics.checkExpressionValueIsNotNull(localIGProGuildInfo, "mGuildInfo");
    String[] arrayOfString = this.j;
    GuildPrivateMemberListAdapter.UserInfoUIData[] arrayOfUserInfoUIData = this.i;
    GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback localOnMemberSelectCallback = this.k;
    Intrinsics.checkExpressionValueIsNotNull(localOnMemberSelectCallback, "mSelectCB");
    paramCreateSubChannelInfo = ((GuildLiveAnchorSelectMemberFragment.Companion)localObject).a(paramCreateSubChannelInfo, localIGProGuildInfo, arrayOfString, arrayOfUserInfoUIData, localOnMemberSelectCallback);
    localObject = paramCreateSubChannelInfo.getArguments();
    if (localObject != null) {
      ((Bundle)localObject).putAll(getArguments());
    }
    paramCreateSubChannelInfo.a((BaseDialogFragment)this);
    return (Fragment)paramCreateSubChannelInfo;
  }
  
  public final void a(int paramInt, @NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "visibleMembers");
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      localBundle.putInt("visible_type", paramInt);
    }
    localBundle = getArguments();
    if (localBundle != null) {
      localBundle.putStringArray("visible_members", paramArrayOfString);
    }
  }
  
  public final void a(@Nullable GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback paramOnMemberSelectCallback)
  {
    this.l = paramOnMemberSelectCallback;
    b((GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback)new GuildLiveSubSelectMemberDialogFragment.setLiveSelectCallback.1(this));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void c()
  {
    if (!this.m) {
      super.c();
    }
  }
  
  @Nullable
  public final GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback g()
  {
    return this.l;
  }
  
  public void h()
  {
    HashMap localHashMap = this.n;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.GuildLiveSubSelectMemberDialogFragment
 * JD-Core Version:    0.7.0.1
 */