package com.tencent.mobileqq.guild.channel;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils.CharacterCountInfo;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText.ITextEditEventListener;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.InputMethodUtil;
import java.util.Iterator;
import java.util.List;

public class QQGuildChannelModidyCategoryFragment
  extends QQGuildTitleBarFragment
  implements CharacterCountEditText.ITextEditEventListener
{
  private int o = 1;
  private int p = 10;
  private CharacterCountEditText q;
  private TextView r;
  private ImageView s;
  private String t;
  private String u;
  private long v;
  
  public static Intent a(String paramString1, String paramString2, long paramLong)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_guild_id", paramString1);
    localBundle.putString("extra_channel_category", paramString2);
    localBundle.putLong("extra_channel_category_id", paramLong);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.equals(this.u))
    {
      if (getActivity() != null) {
        getActivity().finish();
      }
      return;
    }
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    InputMethodUtil.b(this.q);
    Object localObject = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getChannelCategoryList(this.t);
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
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).changeChannelCategoryName(this.t, this.v, paramString, new QQGuildChannelModidyCategoryFragment.3(this));
  }
  
  private void i()
  {
    Intent localIntent = getActivity().getIntent();
    this.t = localIntent.getStringExtra("extra_guild_id");
    this.u = localIntent.getStringExtra("extra_channel_category");
    this.v = localIntent.getLongExtra("extra_channel_category_id", 0L);
    if (this.u == null) {
      this.u = "";
    }
  }
  
  private void j()
  {
    this.q = ((CharacterCountEditText)this.l.findViewById(2131434699));
    this.r = ((TextView)this.l.findViewById(2131434698));
    this.s = ((ImageView)this.l.findViewById(2131434734));
    this.q.setLimitCount(this.p);
    this.q.setCountChangeListener(this);
    this.q.setText(this.u);
    this.q.setSelection(this.u.length());
    this.s.setContentDescription(getResources().getString(2131888434));
    this.s.setOnClickListener(new QQGuildChannelModidyCategoryFragment.1(this));
    a(getString(2131890312));
    b(2131888784, new QQGuildChannelModidyCategoryFragment.2(this));
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    i();
    j();
  }
  
  public void a(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo)
  {
    if (this.o > 0)
    {
      int i = paramCharacterCountInfo.a();
      paramCharacterCountInfo = this.r;
      int j = this.p;
      boolean bool = false;
      paramCharacterCountInfo.setText(String.format("%s/%s", new Object[] { Integer.valueOf(j - i), Integer.valueOf(this.p) }));
      if (i >= this.o) {
        bool = true;
      }
      a(bool);
    }
  }
  
  protected int b()
  {
    return 2131625011;
  }
  
  public void b(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo) {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772133, 2130772007);
  }
  
  public void onFinish()
  {
    super.onFinish();
    getQBaseActivity().overridePendingTransition(2130772007, 2130772135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelModidyCategoryFragment
 * JD-Core Version:    0.7.0.1
 */