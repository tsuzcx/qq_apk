package com.tencent.mobileqq.guild.mainframe.joinchannel;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.Map;

public class JoinChannelDialogFragment
  extends BottomSheetDialogFragment
{
  private JoinChannelViewBinder a;
  private JoinChannelViewModel b;
  private IResultWithSecurityCallback c;
  private String d = "";
  
  private void a()
  {
    this.b.a().observe((QBaseActivity)getActivity(), new JoinChannelDialogFragment.1(this));
    this.b.c().observe(this, new JoinChannelDialogFragment.2(this));
  }
  
  public static void a(QBaseActivity paramQBaseActivity, @NonNull JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, @NonNull AddGuildOption paramAddGuildOption, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    QLog.d("GuildJoinChannelDialogFragment", 1, new Object[] { "showJoinChannelDialogFragment params:", paramJoinChannelParams, "|option:", paramAddGuildOption });
    if (TextUtils.isEmpty(paramJoinChannelParams.a)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("guildId", paramJoinChannelParams.a);
    localBundle.putString("joinSig", paramJoinChannelParams.b);
    localBundle.putInt("from", paramJoinChannelParams.c);
    localBundle.putInt("optionType", paramAddGuildOption.a);
    localBundle.putString("question", paramAddGuildOption.b);
    localBundle.putString("answer", paramAddGuildOption.c);
    paramJoinChannelParams = new JoinChannelDialogFragment();
    paramJoinChannelParams.c = paramIResultWithSecurityCallback;
    paramJoinChannelParams.setArguments(localBundle);
    paramJoinChannelParams.show(paramQBaseActivity.getSupportFragmentManager(), "GuildJoinChannelDialogFragment");
  }
  
  private void a(String paramString)
  {
    VideoReport.addToDetectionWhitelist((QBaseActivity)getActivity());
    VideoReport.setPageId(this.a.a(), "pg_sgrp_auditcheck");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0S200MNJT807V3GE");
    localHashMap.put("sgrp_channel_id", paramString);
    VideoReport.setPageParams(this.a.a(), new PageParams(localHashMap));
  }
  
  private void b()
  {
    JoinChannelViewModel.JoinChannelParams localJoinChannelParams = new JoinChannelViewModel.JoinChannelParams();
    localJoinChannelParams.a = getArguments().getString("guildId");
    localJoinChannelParams.b = getArguments().getString("joinSig");
    localJoinChannelParams.c = getArguments().getInt("from");
    AddGuildOption localAddGuildOption = new AddGuildOption();
    localAddGuildOption.a = getArguments().getInt("optionType");
    localAddGuildOption.b = getArguments().getString("question");
    localAddGuildOption.c = getArguments().getString("answer");
    this.b.a(localJoinChannelParams, localAddGuildOption);
    this.d = localJoinChannelParams.a;
  }
  
  private void c()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.a.a().findViewById(2131428386), "em_sgrp_auditcheck_input", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.a.a().findViewById(2131446561), "em_sgrp_auditcheck_acess", null);
  }
  
  public Dialog onCreateDialog(@android.support.annotation.Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (BottomSheetDialog)super.onCreateDialog(paramBundle);
    paramBundle.getWindow().getAttributes().windowAnimations = 2131952042;
    paramBundle.a().d(3);
    paramBundle.a().c(true);
    return paramBundle;
  }
  
  @SuppressLint({"NewApi"})
  @androidx.annotation.Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @androidx.annotation.Nullable ViewGroup paramViewGroup, @androidx.annotation.Nullable Bundle paramBundle)
  {
    this.b = ((JoinChannelViewModel)ViewModelProviderHelper.a(this).get(JoinChannelViewModel.class));
    this.b.a(this.c);
    this.a = new JoinChannelViewBinder((QBaseActivity)getActivity(), this.b);
    a();
    b();
    paramLayoutInflater = this.a.a();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.b();
  }
  
  public void onResume()
  {
    super.onResume();
    ((ViewGroup)this.a.a().getParent()).setBackgroundColor(0);
  }
  
  public void onStart()
  {
    super.onStart();
    a(this.d);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelDialogFragment
 * JD-Core Version:    0.7.0.1
 */