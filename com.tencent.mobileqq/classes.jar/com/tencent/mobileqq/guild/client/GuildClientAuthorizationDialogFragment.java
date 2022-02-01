package com.tencent.mobileqq.guild.client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class GuildClientAuthorizationDialogFragment
  extends GuildClientAuthorizationAbstractDialogFragment
{
  public static void a(QBaseActivity paramQBaseActivity, Fragment paramFragment, GuildClientAuthDialogParams paramGuildClientAuthDialogParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showGuildClientAuthorizationDialogFragment params：");
    ((StringBuilder)localObject).append(paramGuildClientAuthDialogParams.toString());
    QLog.d("GuildClientAuthorizationDialogFragment", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("GuildClientAuthorizationParam", paramGuildClientAuthDialogParams);
    paramGuildClientAuthDialogParams = new GuildClientAuthorizationDialogFragment();
    paramGuildClientAuthDialogParams.setArguments((Bundle)localObject);
    if (paramFragment != null) {
      paramGuildClientAuthDialogParams.setTargetFragment(paramFragment, 1);
    }
    paramGuildClientAuthDialogParams.show(paramQBaseActivity.getSupportFragmentManager(), "GuildClientAuthorizationDialogFragment");
  }
  
  private void b()
  {
    String str1 = this.d.a();
    String str2 = this.d.b();
    if (QLog.isColorLevel()) {
      QLog.d("GuildClientAuthorizationDialogFragment", 2, String.format("open GuildClientAuthorizationDialogFragment agreement:%s, tips:%s", new Object[] { str1, str2 }));
    }
    ((TextView)this.b.findViewById(2131427916)).setText(str1);
    ((TextView)this.b.findViewById(2131447419)).setText(str2);
  }
  
  private void c()
  {
    VideoReport.setElementId(this.a, d());
    VideoReport.setElementClickPolicy(this.a, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(this.a, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementEndExposePolicy(this.a, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementParam(this.a, "sgrp_otherapp_id", this.c.a());
  }
  
  private String d()
  {
    if ((this.c.c() != 4) && (this.c.c() != 5))
    {
      if (this.c.c() == 1) {
        return "em_sgrp_otherapp_role_selection_panel";
      }
      if (this.c.c() == 3) {
        return "em_sgrp_channel_otherapp_role_selection_panel";
      }
      return "";
    }
    return "em_sgrp_aio_otherapp_role_selection_panel";
  }
  
  protected View a()
  {
    return LayoutInflater.from(getContext()).inflate(2131625023, null);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onStart()
  {
    super.onStart();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthorizationDialogFragment
 * JD-Core Version:    0.7.0.1
 */