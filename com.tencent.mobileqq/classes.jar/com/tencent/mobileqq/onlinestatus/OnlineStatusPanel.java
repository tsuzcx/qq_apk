package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class OnlineStatusPanel
  extends RelativeLayout
{
  QQViewPager a;
  OnlineStatusPagerAdapter b;
  EmoticonPagerRadioGroup c;
  private OnlineStatusPanel.OnlineStatusPanelListener d;
  private OnlineStatusPanelParams e;
  private OnlineStatusItem f;
  
  public OnlineStatusPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public OnlineStatusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OnlineStatusPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(OnlineStatusPanelParams paramOnlineStatusPanelParams, int paramInt)
  {
    int i = ViewUtils.dpToPx(paramOnlineStatusPanelParams.e);
    int j = ViewUtils.dpToPx(paramOnlineStatusPanelParams.f);
    return paramInt * paramOnlineStatusPanelParams.c + ViewUtils.dpToPx(paramOnlineStatusPanelParams.g) * (paramOnlineStatusPanelParams.c - 1) + i + j;
  }
  
  private void a()
  {
    if (this.b.getCount() > 1)
    {
      try
      {
        this.c.synButton(this.b.getCount());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e=");
        localStringBuilder.append(localException);
        QLog.e("OnlineStatusPanel", 1, localStringBuilder.toString());
      }
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
  }
  
  private int b(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    return (paramOnlineStatusPanelParams.i - ViewUtils.dip2px(paramOnlineStatusPanelParams.h) * 2 - ViewUtils.dpToPx(paramOnlineStatusPanelParams.g) * (paramOnlineStatusPanelParams.d - 1)) / paramOnlineStatusPanelParams.d;
  }
  
  public void a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    this.a = ((QQViewPager)findViewById(2131439581));
    this.b = new OnlineStatusPagerAdapter(MobileQQ.getContext(), paramOnlineStatusPanelParams, this.a);
    this.a.addOnPageChangeListener(this.b);
    this.a.setAdapter(this.b);
    this.c = ((EmoticonPagerRadioGroup)findViewById(2131435243));
    this.c.setViewPager(this.a);
    this.e = paramOnlineStatusPanelParams;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(paramOnlineStatusPanelParams.l);
    this.c.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    int i = b(paramOnlineStatusPanelParams);
    localLayoutParams.height = a(paramOnlineStatusPanelParams, i);
    this.a.setLayoutParams(localLayoutParams);
    this.b.a(i);
    getOnlineStatusItemAndAppear();
  }
  
  void a(boolean paramBoolean)
  {
    ThreadManager.getFileThreadHandler().post(new OnlineStatusPanel.2(this, paramBoolean));
  }
  
  void getOnlineStatusItemAndAppear()
  {
    ThreadManager.getFileThreadHandler().post(new OnlineStatusPanel.1(this));
  }
  
  public void setCurrentItem()
  {
    int i = this.b.b();
    if (i == this.a.getCurrentItem()) {
      this.b.onPageSelected(i);
    }
    this.a.setCurrentItem(i, false);
  }
  
  public void setFriendItem(OnlineStatusItem paramOnlineStatusItem)
  {
    this.f = paramOnlineStatusItem;
  }
  
  public void setListener(OnlineStatusPanel.OnlineStatusPanelListener paramOnlineStatusPanelListener)
  {
    this.d = paramOnlineStatusPanelListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel
 * JD-Core Version:    0.7.0.1
 */