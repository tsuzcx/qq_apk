package com.tencent.mobileqq.guild.privatechannel.dialog;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.QQGuildDTConstant;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.ISelectMemberCallback;
import com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel;
import com.tencent.mobileqq.guild.setting.QQGuildVisibleMemberListViewModel;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildLiveAnchorSelectMemberFragment;", "Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildPrivateSubSelectMemberFragment;", "()V", "initSelectLayoutSubmitView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setDataModel", "setDtElement", "setDtPage", "setIsFrom", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildLiveAnchorSelectMemberFragment
  extends GuildPrivateSubSelectMemberFragment
{
  public static final GuildLiveAnchorSelectMemberFragment.Companion d = new GuildLiveAnchorSelectMemberFragment.Companion(null);
  private HashMap i;
  
  private final void h()
  {
    Object localObject = getArguments();
    if (localObject != null) {
      localObject = ((Bundle)localObject).getSerializable("extra_guild_guild_info");
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = (IGProGuildInfo)localObject;
      if (localObject == null) {
        return;
      }
      Map localMap = (Map)new HashMap();
      localMap.put("sgrp_pg_source_anchor", Integer.valueOf(1));
      String str = ((IGProGuildInfo)localObject).getGuildID();
      Intrinsics.checkExpressionValueIsNotNull(str, "guildInfo.guildID");
      localMap.put("sgrp_channel_id", str);
      localMap.put("sgrp_user_type", Integer.valueOf(QQGuildDTConstant.a(((IGProGuildInfo)localObject).getUserType())));
      VideoReport.setPageId(this.a, "pg_sgrp_access_anchor");
      VideoReport.setPageParams(this.a, new PageParams(localMap));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo");
  }
  
  private final void i()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.a.findViewById(2131446561), "em_sgrp_access_member", null);
  }
  
  public void d()
  {
    this.e.setIsFrom(5);
  }
  
  protected void e()
  {
    Object localObject1 = ViewModelProviderHelper.a((ViewModelStoreOwner)this, QQGuildVisibleMemberListViewModel.v).get(QQGuildVisibleMemberListViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ViewModelProviderHelper.…istViewModel::class.java)");
    QQGuildVisibleMemberListViewModel localQQGuildVisibleMemberListViewModel = (QQGuildVisibleMemberListViewModel)localObject1;
    localObject1 = getArguments();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("visible_type"));
    } else {
      localObject1 = null;
    }
    Object localObject3 = getArguments();
    if (localObject3 != null) {
      localObject2 = ((Bundle)localObject3).getStringArray("visible_members");
    }
    localObject3 = a();
    IGProGuildInfo localIGProGuildInfo = this.g;
    int j;
    if (localObject1 != null) {
      j = ((Integer)localObject1).intValue();
    } else {
      j = 0;
    }
    localQQGuildVisibleMemberListViewModel.a((AppInterface)localObject3, localIGProGuildInfo, j, (String[])localObject2);
    localObject1 = this.e;
    localObject2 = (QQGuildMemberListViewModel)localQQGuildVisibleMemberListViewModel;
    ((GuildSelectGuildMemberLayout)localObject1).setDataModel((QQGuildMemberListViewModel)localObject2, (Fragment)this, localQQGuildVisibleMemberListViewModel.l());
    this.f = ((QQGuildMemberListViewModel)localObject2);
  }
  
  public void f()
  {
    this.h = getString(2131890428);
    a(true);
    a(this.h, -16777216);
    this.e.setSelectMemberCallback((GuildSelectMemberLayout.ISelectMemberCallback)new GuildLiveAnchorSelectMemberFragment.initSelectLayoutSubmitView.1(this));
  }
  
  public void g()
  {
    HashMap localHashMap = this.i;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    ((TextView)paramView.findViewById(2131434723)).setText(2131890467);
    h();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.dialog.GuildLiveAnchorSelectMemberFragment
 * JD-Core Version:    0.7.0.1
 */