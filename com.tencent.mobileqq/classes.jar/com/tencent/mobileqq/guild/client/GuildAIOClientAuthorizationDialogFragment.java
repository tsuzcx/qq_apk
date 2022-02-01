package com.tencent.mobileqq.guild.client;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.util.QQGuildSPUtils;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class GuildAIOClientAuthorizationDialogFragment
  extends GuildClientAuthorizationAbstractDialogFragment
{
  private TextView e;
  private RoundRectUrlImageView f;
  private TextView g;
  
  public static void a(QBaseActivity paramQBaseActivity, GuildClientAuthDialogParams paramGuildClientAuthDialogParams)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("GuildClientAuthorizationParam", paramGuildClientAuthDialogParams);
    paramGuildClientAuthDialogParams = new GuildAIOClientAuthorizationDialogFragment();
    paramGuildClientAuthDialogParams.setArguments(localBundle);
    paramGuildClientAuthDialogParams.show(paramQBaseActivity.getSupportFragmentManager(), "GuildAIOClientAuthorizationDialogFragment");
  }
  
  private void c()
  {
    VideoReport.setElementId(this.a, "em_sgrp_aio_otherapp_authorization");
    VideoReport.setElementClickPolicy(this.a, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(this.a, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementEndExposePolicy(this.a, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementParam(this.a, "sgrp_otherapp_id", this.c.a());
  }
  
  protected View a()
  {
    return LayoutInflater.from(getContext()).inflate(2131625021, null);
  }
  
  public void b()
  {
    Object localObject = this.d.a();
    String str1 = this.d.b();
    String str2 = this.d.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open GuildAIOClientAuthorizationDialogFragment guildId=");
      localStringBuilder.append(this.c.b());
      localStringBuilder.append(" clientId=");
      localStringBuilder.append(this.c.a());
      localStringBuilder.append(" title=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" imageUrl=");
      localStringBuilder.append(str2);
      QLog.d("GuildAIOClientAuthorizationDialogFragment", 2, localStringBuilder.toString());
    }
    this.e.setText((CharSequence)localObject);
    this.g.setText(str1);
    if (!TextUtils.isEmpty(str2))
    {
      localObject = URLDrawable.getDrawable(str2, URLDrawable.URLDrawableOptions.obtain());
      this.f.setImageDrawable((Drawable)localObject);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.e = ((TextView)paramLayoutInflater.findViewById(2131447576));
    this.f = ((RoundRectUrlImageView)paramLayoutInflater.findViewById(2131435357));
    this.f.setAllRadius(DisplayUtil.a(getContext(), 6.0F));
    int i = DisplayUtil.a(getContext()).a;
    int j = DisplayUtil.a(getContext(), 16.0F);
    paramViewGroup = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    paramViewGroup.height = ((int)((i - j * 2) * 291.0F / 792.0F));
    this.f.setLayoutParams(paramViewGroup);
    this.g = ((TextView)paramLayoutInflater.findViewById(2131429703));
    b();
    QQGuildSPUtils.b(this.c.a());
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
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildAIOClientAuthorizationDialogFragment
 * JD-Core Version:    0.7.0.1
 */