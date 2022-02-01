package com.tencent.mobileqq.guild.channel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.InputMethodUtil;
import java.util.Iterator;
import java.util.List;

public class QQGuildChannelCreateCategoryFragment
  extends QQGuildNameBaseFragment
{
  private String r;
  
  public static Intent b(String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_guild_id", paramString);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void m()
  {
    this.r = getActivity().getIntent().getStringExtra("extra_guild_id");
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.p = 10;
    this.o = 1;
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    ((TextView)this.l.findViewById(2131446620)).setVisibility(8);
    ((LinearLayout.LayoutParams)this.l.findViewById(2131432363).getLayoutParams()).topMargin = ViewUtils.dip2px(12.0F);
    m();
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    InputMethodUtil.b(this.q);
    Object localObject = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getChannelCategoryList(this.r);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((ICategoryInfo)((Iterator)localObject).next()).a()))
        {
          QQGuildUtil.c(BaseApplication.getContext().getString(2131890280));
          return;
        }
      }
    }
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).createChannelCategory(this.r, paramString, new QQGuildChannelCreateCategoryFragment.1(this));
  }
  
  protected String i()
  {
    return getString(2131890308);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772133, 2130772007);
  }
  
  protected String j()
  {
    return null;
  }
  
  protected String k()
  {
    return null;
  }
  
  public void onFinish()
  {
    super.onFinish();
    getQBaseActivity().overridePendingTransition(2130772007, 2130772135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelCreateCategoryFragment
 * JD-Core Version:    0.7.0.1
 */