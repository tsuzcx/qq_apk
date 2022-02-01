package com.tencent.mobileqq.guild.chatpie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.input.LiveChannelAIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.GuildLiveChannelScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.tips.GuildLiveTipsManager;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.chatpie.clickprocessor.GuildLiveChannelPieClickProcessor;
import com.tencent.mobileqq.guild.chatpie.clickprocessor.GuildPieClickProcessor;
import com.tencent.mobileqq.guild.chatpie.clickprocessor.LiveChannelInputBarBtnClickCallback;
import com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildLiveChannelInputBarHelper;
import com.tencent.mobileqq.guild.chatpie.sender.GuildMessageSender;
import com.tencent.mobileqq.guild.live.IQQGuildLiveAIOListener;
import com.tencent.mobileqq.guild.navigatebar.GuildAioAgent;
import com.tencent.mobileqq.guild.widget.EdgeTransparentRelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.LinkedHashMap;
import mqq.util.WeakReference;

public class GuildLiveChannelChatPie
  extends GuildChatPie
{
  private WeakReference<IQQGuildLiveAIOListener> bm;
  
  public GuildLiveChannelChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.k.a(true);
  }
  
  private Drawable a(Context paramContext)
  {
    return paramContext.getResources().getDrawable(2130840920);
  }
  
  private void a(EdgeTransparentRelativeLayout paramEdgeTransparentRelativeLayout)
  {
    paramEdgeTransparentRelativeLayout.setPositionAndDrawSize(1, ViewUtils.dip2px(56.0F));
  }
  
  private void bJ()
  {
    this.p.setVisibility(8);
    this.aZ.findViewById(2131447582).setVisibility(8);
    this.aZ.findViewById(2131440610).setVisibility(8);
    this.aU.setVisibility(8);
    this.aZ.findViewById(2131442214).setVisibility(8);
    this.X.findViewById(2131446058).setVisibility(8);
    this.X.setBackgroundColor(this.e.getResources().getColor(2131166242));
    a((EdgeTransparentRelativeLayout)this.o);
    this.Y.addOnLayoutChangeListener(new GuildLiveChannelChatPie.1(this));
    this.Y.post(new GuildLiveChannelChatPie.2(this));
  }
  
  private void bK()
  {
    ViewGroup localViewGroup = (ViewGroup)this.ba.getParent();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ba.getLayoutParams();
    localLayoutParams.topMargin = (-localViewGroup.getPaddingTop());
    this.ba.setLayoutParams(localLayoutParams);
    localViewGroup.setClipToPadding(false);
  }
  
  private void bL()
  {
    ((IGuildLiveChannelApi)QRoute.api(IGuildLiveChannelApi.class)).cleanLiveChannelAIOBg(this.U);
  }
  
  private boolean bM()
  {
    WeakReference localWeakReference = this.bm;
    return (localWeakReference != null) && (localWeakReference.get() != null);
  }
  
  private ValueAnimator.AnimatorUpdateListener g(View paramView)
  {
    return new GuildLiveChannelChatPie.3(this, paramView);
  }
  
  protected void Q()
  {
    super.Q();
    this.Y.setBackgroundResource(2130840916);
  }
  
  public void R()
  {
    QLog.d("GuildLiveChannelChatPie", 4, "filter in live channel, [loadBackgroundAsync]");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPanelChanged oldPanel = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", newPanel = ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("GuildLiveChannelChatPie", 4, ((StringBuilder)localObject).toString());
    if (bM())
    {
      localObject = (IQQGuildLiveAIOListener)this.bm.get();
      boolean bool;
      if (paramInt2 == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((IQQGuildLiveAIOListener)localObject).a(bool);
    }
  }
  
  protected void a(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("filter in live channel, [udpateAIOBackgrourd] msg = ");
    localStringBuilder.append(paramMessage);
    QLog.d("GuildLiveChannelChatPie", 4, localStringBuilder.toString());
  }
  
  public void a(IQQGuildLiveAIOListener paramIQQGuildLiveAIOListener)
  {
    QLog.d("GuildLiveChannelChatPie", 4, "setGuildLiveAIOListener");
    this.bm = new WeakReference(paramIQQGuildLiveAIOListener);
    paramIQQGuildLiveAIOListener = bD().a();
    if ((paramIQQGuildLiveAIOListener instanceof LiveChannelInputBarBtnClickCallback)) {
      ((LiveChannelInputBarBtnClickCallback)paramIQQGuildLiveAIOListener).a(this.bm);
    }
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (AioAgent.Message)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, String.format("handleUpdateGuildAioAgentMessage type=%d shmsgseq=%d uniseq=%d", new Object[] { Integer.valueOf(paramObject.a), Long.valueOf(paramObject.c), Long.valueOf(paramObject.d) }));
      }
      if (paramObject.a == GuildAioAgent.A) {
        this.j.d().a(paramObject.e, paramObject.a(), paramObject.f);
      }
    }
  }
  
  protected void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("filter in live channel, [updateAIOBackgrourdErr] errMsg = ");
    localStringBuilder.append(paramString);
    QLog.d("GuildLiveChannelChatPie", 4, localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, BaseChatPie paramBaseChatPie) {}
  
  protected boolean a(View paramView, int paramInt)
  {
    if (paramView != null) {
      e(paramView.findViewById(2131434586));
    }
    return super.a(paramView, paramInt);
  }
  
  public void ai()
  {
    bB();
    QLog.d("GuildLiveChannelChatPie", 4, "filter in live channel, [onPostThemeChanged]");
  }
  
  protected HelperProvider b()
  {
    return new GuildLiveHelperProvider(this.f);
  }
  
  protected boolean bC()
  {
    return true;
  }
  
  public GuildPieClickProcessor bD()
  {
    if (this.bi == null)
    {
      this.bi = new GuildLiveChannelPieClickProcessor();
      this.bi.a((GuildChatContext)bv());
    }
    return this.bi;
  }
  
  protected AIOInput c()
  {
    return new LiveChannelAIOInputBuilder().a(this.i).a(new GuildMessageSender(this.i)).a();
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new GuildLiveChannelScroller()).a(new GuildLiveListUI(this.i)).a(new GuildLiveMsgListRefresher(this.i)).a(new GuildUnreadTaskNone(this.i)).a();
  }
  
  protected void e(View paramView)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = (WeakReference)this.bk.get(paramView);
    if (localObject == null) {
      return;
    }
    localObject = (Animator)((WeakReference)localObject).get();
    this.bk.remove(paramView);
    if (localObject != null)
    {
      if (!((Animator)localObject).isStarted()) {
        return;
      }
      ((Animator)localObject).removeAllListeners();
      ((Animator)localObject).end();
      if (paramView.getBackground() == null) {
        return;
      }
      paramView.getBackground().setAlpha(0);
    }
  }
  
  public void e(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateInputHintTheme themeName = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("GuildLiveChannelChatPie", 4, ((StringBuilder)localObject).toString());
    localObject = (GuildInputBarHelper)q(145);
    if ((localObject instanceof GuildLiveChannelInputBarHelper)) {
      ((GuildLiveChannelInputBarHelper)localObject).a(paramString);
    }
  }
  
  protected void f(View paramView)
  {
    View localView = paramView.findViewById(2131434586);
    if (localView == null) {
      return;
    }
    localView.setBackground(a(localView.getContext()));
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 255, 255, 0 });
    localValueAnimator.setDuration(this.bl);
    if (this.bk != null) {
      this.bk.put(paramView, new WeakReference(localValueAnimator));
    }
    localValueAnimator.addUpdateListener(g(localView));
    localValueAnimator.start();
  }
  
  public boolean f(int paramInt)
  {
    if (t(paramInt)) {
      return true;
    }
    as();
    bz();
    return s(paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 60)
    {
      ViewGroup localViewGroup = (ViewGroup)bv().s().findViewById(2131427887);
      if (localViewGroup != null)
      {
        localViewGroup.setBackground(null);
        return true;
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  protected void l()
  {
    super.l();
    bJ();
  }
  
  protected ChatAdapter1 m()
  {
    return new GuildLiveChannelPieAdapter(this.d, this.f, this.ah, this.aU, this);
  }
  
  public void n(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("filter in live channel, [enableMosaicEffect] enable = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("GuildLiveChannelChatPie", 4, localStringBuilder.toString());
  }
  
  protected TipsManager r()
  {
    return new GuildLiveTipsManager(this.i, this.d, this.ah, this.k.d().d(), this.n);
  }
  
  public void t()
  {
    QLog.d("GuildLiveChannelChatPie", 4, "filter in live channel, [updateInputBarBg]");
  }
  
  public void v()
  {
    super.v();
    QLog.d("GuildLiveChannelChatPie", 4, "onHideAllPanel");
    if (bM()) {
      ((IQQGuildLiveAIOListener)this.bm.get()).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildLiveChannelChatPie
 * JD-Core Version:    0.7.0.1
 */