package com.tencent.mobileqq.guild.message.chatpie;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.XListView;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class GuildMenuDialogFragment
  extends BottomSheetDialogFragment
{
  private AppRuntime a;
  private QQCustomMenu b;
  private ChatMessage c;
  private View d;
  private GuildChatpieMenuAdapter e;
  private XListView f;
  private IGuildMenuEventCallBack g;
  
  public GuildMenuDialogFragment(AppRuntime paramAppRuntime, QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    this.a = paramAppRuntime;
    this.b = paramQQCustomMenu;
    this.c = paramChatMessage;
  }
  
  private void a()
  {
    this.e = new GuildChatpieMenuAdapter(this);
    this.e.a(this.b);
    this.e.b(this.c.msgtype);
    this.f = ((XListView)this.d.findViewById(2131438148));
    this.f.setOverScrollMode(2);
    this.f.setAdapter(this.e);
    b();
  }
  
  private void b()
  {
    GuildChatpieMenuAdapter localGuildChatpieMenuAdapter = this.e;
    if (localGuildChatpieMenuAdapter != null) {
      localGuildChatpieMenuAdapter.notifyDataSetChanged();
    }
  }
  
  private void c()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this, "pg_sgrp_aio_menu");
    HashMap localHashMap = new HashMap();
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(this.c.frienduin, localHashMap);
  }
  
  public void a(IGuildMenuEventCallBack paramIGuildMenuEventCallBack)
  {
    this.g = paramIGuildMenuEventCallBack;
  }
  
  public void a(QQCustomMenuItem paramQQCustomMenuItem)
  {
    if (paramQQCustomMenuItem == null) {
      return;
    }
    IGuildMenuEventCallBack localIGuildMenuEventCallBack = this.g;
    if (localIGuildMenuEventCallBack != null) {
      localIGuildMenuEventCallBack.a(paramQQCustomMenuItem, this.c);
    }
    dismiss();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.d = paramLayoutInflater.inflate(2131624979, paramViewGroup);
    a();
    c();
    paramLayoutInflater = this.d;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    paramDialogInterface = this.g;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.c);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ((ViewGroup)this.d.getParent()).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.chatpie.GuildMenuDialogFragment
 * JD-Core Version:    0.7.0.1
 */