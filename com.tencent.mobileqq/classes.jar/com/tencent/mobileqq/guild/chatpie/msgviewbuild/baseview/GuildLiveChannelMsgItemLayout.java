package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GuildLiveChannelMsgItemLayout
  extends GuildMsgItemLayout
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    a = localBaseApplication.getResources().getDimensionPixelSize(2131297602);
    b = localBaseApplication.getResources().getDimensionPixelSize(2131297604);
    c = localBaseApplication.getResources().getDimensionPixelSize(2131297603);
    d = localBaseApplication.getResources().getDimensionPixelSize(2131297600);
    e = localBaseApplication.getResources().getDimensionPixelSize(2131297598);
    f = localBaseApplication.getResources().getDimensionPixelSize(2131297599);
    g = localBaseApplication.getResources().getDimensionPixelSize(2131297605);
    h = localBaseApplication.getResources().getDimensionPixelSize(2131297597);
  }
  
  public GuildLiveChannelMsgItemLayout(AppRuntime paramAppRuntime, Context paramContext)
  {
    this(paramAppRuntime, paramContext, null);
  }
  
  public GuildLiveChannelMsgItemLayout(AppRuntime paramAppRuntime, Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramAppRuntime, paramContext, paramAttributeSet, 0);
  }
  
  public GuildLiveChannelMsgItemLayout(AppRuntime paramAppRuntime, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramAppRuntime, paramContext, paramAttributeSet, paramInt);
    this.C = new GuildLiveMsgItemLayoutWrapper();
    this.C.a(this);
    this.D = new GuildLiveChannelMsgItemLayoutViewFactory(paramAppRuntime, this, paramContext);
  }
  
  private int a(View paramView)
  {
    int j = paramView.getMeasuredWidth();
    int i = j;
    if ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      i = j + (paramView.rightMargin + paramView.leftMargin);
    }
    return i;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private int b(View paramView)
  {
    int j = paramView.getMeasuredHeight();
    int i = j;
    if ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      i = j + (paramView.topMargin + paramView.bottomMargin);
    }
    return i;
  }
  
  private void g()
  {
    int j = Math.max(a(this.y), a(this.B) + g);
    int k = a(this.A);
    int i;
    if (c()) {
      i = c;
    } else {
      i = b;
    }
    i += b;
    int m = getShowContentHeight();
    j = Math.min(k + j + i, getMeasuredWidth());
    a(this.u, j - i, m);
    setMeasuredDimension(j, m + a * 2);
  }
  
  private int getShowContentHeight()
  {
    return Math.max(b(this.A), b(this.B) + b(this.y) + d);
  }
  
  private void h()
  {
    if (this.x == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.x.getLayoutParams();
    localLayoutParams.topMargin = 0;
    this.x.setLayoutParams(localLayoutParams);
    this.x.setVisibility(8);
  }
  
  private void i()
  {
    if (!c()) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.z.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localLayoutParams.leftMargin = (-h);
    localLayoutParams.addRule(10, 0);
    localLayoutParams.addRule(15);
    this.z.setLayoutParams(localLayoutParams);
  }
  
  private void j()
  {
    if (this.u == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
    localLayoutParams.addRule(13, 0);
    localLayoutParams.addRule(15);
    this.u.setLayoutParams(localLayoutParams);
  }
  
  private void k()
  {
    if (this.A == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.A.getLayoutParams();
    if (localLayoutParams != null)
    {
      int i = d;
      localLayoutParams.bottomMargin = i;
      localLayoutParams.topMargin = i;
      if (d()) {
        localLayoutParams.leftMargin = f;
      } else {
        localLayoutParams.leftMargin = e;
      }
      this.A.setLayoutParams(localLayoutParams);
    }
  }
  
  private void l()
  {
    if (this.y == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.y.getLayoutParams();
    int i = g;
    localLayoutParams.rightMargin = i;
    localLayoutParams.leftMargin = i;
    this.y.setLayoutParams(localLayoutParams);
  }
  
  private void m()
  {
    int i;
    if (d())
    {
      i = 2130840910;
      setClipToPadding(false);
    }
    else
    {
      i = 2130840907;
      setClipToPadding(true);
    }
    setBackground(getResources().getDrawable(i));
  }
  
  public void a()
  {
    h();
    i();
    j();
    k();
    l();
    m();
  }
  
  protected void a(RelativeLayout.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    super.a(paramLayoutParams, paramBoolean);
    paramLayoutParams.rightMargin = g;
  }
  
  public void b()
  {
    if (this.z != null) {
      this.z.setVisibility(8);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    g();
  }
  
  public void setAtView(Context paramContext, ChatMessage paramChatMessage)
  {
    QLog.d("GuildLiveChannelMsgItem", 4, "filter setAtView");
  }
  
  public void setFlushView(ChatMessage paramChatMessage)
  {
    super.setFlushView(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
    paramChatMessage.addRule(13, 0);
    paramChatMessage.addRule(6, 0);
    paramChatMessage.addRule(8, 0);
    this.u.setLayoutParams(paramChatMessage);
  }
  
  public void setSelCheckBox(ChatMessage paramChatMessage, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    super.setSelCheckBox(paramChatMessage, paramOnCheckedChangeListener);
    if (this.z != null) {
      this.z.setButtonDrawable(2130840921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildLiveChannelMsgItemLayout
 * JD-Core Version:    0.7.0.1
 */