package com.tencent.mobileqq.guild.channel.create.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildAppSubChannelCreateDialogFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class QQGuildAppPreviewFragment
  extends BaseCreateSubChannelFragment
  implements View.OnClickListener, ViewPager.OnPageChangeListener
{
  private static int d = 20;
  private static float e = 0.6095617F;
  private TextView f;
  private ViewPager g;
  private LinearLayout h;
  private Button i;
  private int j = 0;
  private int k;
  private int l;
  private List<String> m;
  
  public static QQGuildAppPreviewFragment a(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    QQGuildAppPreviewFragment localQQGuildAppPreviewFragment = new QQGuildAppPreviewFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra_key_subchannel_info", paramCreateSubChannelInfo);
    localQQGuildAppPreviewFragment.setArguments(localBundle);
    return localQQGuildAppPreviewFragment;
  }
  
  private void e()
  {
    this.f = ((TextView)this.a.findViewById(2131429230));
    this.g = ((ViewPager)this.a.findViewById(2131440617));
    this.h = ((LinearLayout)this.a.findViewById(2131435680));
    this.i = ((Button)this.a.findViewById(2131431497));
    this.g.setPageMargin(ViewUtils.dip2px(d));
    this.g.getViewTreeObserver().addOnGlobalLayoutListener(new QQGuildAppPreviewFragment.1(this));
    this.f.setOnClickListener(this);
    this.i.setOnClickListener(this);
    Object localObject = this.m;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      int n = 0;
      while (n < this.m.size())
      {
        localObject = new View(getContext());
        ((View)localObject).setBackgroundResource(2130840673);
        ((View)localObject).setSelected(false);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(6.0F), ViewUtils.dip2px(6.0F));
        localLayoutParams.leftMargin = ViewUtils.dip2px(4.0F);
        localLayoutParams.rightMargin = ViewUtils.dip2px(4.0F);
        this.h.addView((View)localObject, localLayoutParams);
        n += 1;
      }
      this.h.getChildAt(0).setSelected(true);
      return;
    }
    QLog.e("QQGuildAppPreviewFragment", 1, "initView previewUrls is null");
  }
  
  private void f()
  {
    this.m = this.b.e.getStringArrayList("previewUrls");
  }
  
  protected int b()
  {
    return 2131624987;
  }
  
  protected void c()
  {
    f();
    e();
  }
  
  public void onClick(View paramView)
  {
    if (!QQGuildUIUtil.a())
    {
      int n = paramView.getId();
      if (n == 2131429230)
      {
        if (this.c != null) {
          this.c.c();
        }
      }
      else if ((n == 2131431497) && (this.c != null))
      {
        QQGuildAppSubChannelCreateDialogFragment localQQGuildAppSubChannelCreateDialogFragment = QQGuildAppSubChannelCreateDialogFragment.b(this.b);
        localQQGuildAppSubChannelCreateDialogFragment.a(this.c.c);
        this.c.b();
        localQQGuildAppSubChannelCreateDialogFragment.show(QBaseActivity.sTopActivity.getSupportFragmentManager(), "QQGuildAppSubChannelCreateDialogFragment");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.h.getChildAt(this.j).setSelected(false);
    this.h.getChildAt(paramInt).setSelected(true);
    this.j = paramInt;
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildAppPreviewFragment
 * JD-Core Version:    0.7.0.1
 */