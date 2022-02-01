package com.tencent.mobileqq.guild.chatpie;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.GuildScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.SelectToBottomHelper;
import com.tencent.mobileqq.activity.aio.helper.UnreadBackBottomHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.GuildOneClickJumpMsgFilter;
import com.tencent.mobileqq.activity.fling.ChatFragmentTopGestureLayout;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.notify.GuildClientAuthNotify;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.chatpie.clickprocessor.GuildPieClickProcessor;
import com.tencent.mobileqq.guild.chatpie.helper.GuildAIOMultiActionHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper;
import com.tencent.mobileqq.guild.chatpie.sender.GuildMessageSender;
import com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.message.BaseGuildMessageManager;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.eventflow.IGuildEventFlowHandler;
import com.tencent.mobileqq.guild.navigatebar.GuildAioAgent;
import com.tencent.mobileqq.guild.navigatebar.GuildAioTips;
import com.tencent.mobileqq.guild.vas.GuildGiftManager;
import com.tencent.mobileqq.guild.vas.IGuildGiftManager;
import com.tencent.mobileqq.jubao.JubaoHelper;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Observable;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class GuildChatPie
  extends BaseChatPie
{
  private static String bm = "GuildChatPie";
  protected GuildPieClickProcessor bi;
  protected GuildAioTips bj;
  protected LinkedHashMap<View, WeakReference<Animator>> bk = new LinkedHashMap();
  protected int bl = 1200;
  private final GuildChatPieNetModule bn = new GuildChatPieNetModule(paramQQAppInterface, (GuildChatContext)bv());
  private int bo = 0;
  private int bp = 0;
  private int bq = 0;
  private IGuildMsgSeqTimeService.MsgSeqTimeItem br;
  private GestureDetector bs;
  
  public GuildChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void b(Bundle paramBundle)
  {
    ((IGuildOpenApi)this.d.getRuntimeService(IGuildOpenApi.class, "")).handleBackToAppDialog(aX(), this.ah.c, paramBundle);
  }
  
  private boolean bJ()
  {
    if ((!TextUtils.isEmpty(this.ah.c)) && (!TextUtils.isEmpty(this.ah.b))) {
      return true;
    }
    String str = bm;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkDataLegal channelId:");
    localStringBuilder.append(this.ah.b);
    localStringBuilder.append(" guildId:");
    localStringBuilder.append(this.ah.c);
    localStringBuilder.append(" channelType:");
    localStringBuilder.append(((GuildChatContext)bv()).V());
    QLog.e(str, 1, localStringBuilder.toString());
    return false;
  }
  
  private void bK()
  {
    FrameLayout localFrameLayout = (FrameLayout)bv().d(2131433906);
    if ((GuildVasAvatar)localFrameLayout.findViewById(2131427972) == null)
    {
      GuildVasAvatar localGuildVasAvatar = new GuildVasAvatar(localFrameLayout.getContext());
      localGuildVasAvatar.setAppInterface(this.d);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(AIOUtils.b(28.0F, localGuildVasAvatar.getResources()), AIOUtils.b(28.0F, localGuildVasAvatar.getResources()));
      localLayoutParams.gravity = 83;
      localLayoutParams.leftMargin = AIOUtils.b(63.0F, localGuildVasAvatar.getResources());
      localLayoutParams.bottomMargin = AIOUtils.b(16.0F, localGuildVasAvatar.getResources());
      localFrameLayout.addView(localGuildVasAvatar, localLayoutParams);
      localGuildVasAvatar.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localGuildVasAvatar.setId(2131427972);
      localGuildVasAvatar.setContentDescription(localGuildVasAvatar.getResources().getString(2131894083));
      localGuildVasAvatar.setAvatarTinyId(((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getSelfTinyId());
    }
  }
  
  private void bL()
  {
    FrameLayout localFrameLayout = (FrameLayout)bv().d(2131433906);
    Object localObject2 = (ImageButton)localFrameLayout.findViewById(2131427968);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ImageButton(localFrameLayout.getContext());
      localObject2 = new FrameLayout.LayoutParams(AIOUtils.b(28.0F, ((ImageButton)localObject1).getResources()), AIOUtils.b(28.0F, ((ImageButton)localObject1).getResources()));
      ((FrameLayout.LayoutParams)localObject2).gravity = 83;
      ((FrameLayout.LayoutParams)localObject2).leftMargin = bv().b().getResources().getDimensionPixelSize(2131297594);
      ((FrameLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(16.0F, ((ImageButton)localObject1).getResources());
      localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ((ImageButton)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((ImageButton)localObject1).setId(2131427968);
      ((ImageButton)localObject1).setBackgroundResource(2130840811);
      ((ImageButton)localObject1).setContentDescription(((ImageButton)localObject1).getResources().getString(2131894081));
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams((View)localObject1, "em_aio_gifts", null);
    }
    ((ImageButton)localObject1).setOnClickListener(((GuildChatContext)bv()).R());
  }
  
  private void bM()
  {
    FrameLayout localFrameLayout = (FrameLayout)bv().d(2131433906);
    Object localObject2 = (ImageButton)localFrameLayout.findViewById(2131427967);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ImageButton(localFrameLayout.getContext());
      localObject2 = new FrameLayout.LayoutParams(AIOUtils.b(28.0F, ((ImageButton)localObject1).getResources()), AIOUtils.b(28.0F, ((ImageButton)localObject1).getResources()));
      ((FrameLayout.LayoutParams)localObject2).gravity = 85;
      ((FrameLayout.LayoutParams)localObject2).rightMargin = bv().b().getResources().getDimensionPixelSize(2131297593);
      ((FrameLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(16.0F, ((ImageButton)localObject1).getResources());
      localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ((ImageButton)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((ImageButton)localObject1).setId(2131427967);
      ((ImageButton)localObject1).setContentDescription(((ImageButton)localObject1).getResources().getString(2131894080));
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams((View)localObject1, "em_aio_stickers", null);
    }
    ((ImageButton)localObject1).setOnClickListener(((GuildChatContext)bv()).R());
  }
  
  private void bN()
  {
    Iterator localIterator = GuildClientAuthNotify.a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification(str, GuildClientAuthNotify.b());
    }
  }
  
  public void B()
  {
    QLog.d(this.c, 1, "openOptionActivity");
  }
  
  public void K()
  {
    this.j.d().j();
    this.j.d().a(false);
    this.bk.clear();
    bI();
    if (this.aY)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "hasDestory = true return");
      }
      return;
    }
    if (BaseChatItemLayout.ad) {
      a(false, null, false);
    }
    super.K();
    bF();
    GuildOneClickJumpMsgFilter.a();
    p(false);
  }
  
  public void P()
  {
    super.P();
    ((GuildChatContext)this.i).P().d();
    if ((!bC()) && (QQTheme.isNowThemeIsNight())) {
      ImmersiveUtils.setStatusTextColor(false, this.f.getWindow());
    }
  }
  
  protected void Q()
  {
    super.Q();
    this.Y.setBackgroundResource(2130840852);
    this.Y.setMinHeight(ViewUtils.dip2px(40.0F));
    this.Y.setMaxLines(4);
    this.Y.setPadding(ViewUtils.dpToPx(42.0F), ViewUtils.dpToPx(8.0F), ViewUtils.dip2px(12.0F), ViewUtils.dpToPx(8.0F));
  }
  
  public void S()
  {
    if (aX().getIntent() != null) {
      aX().getIntent().removeExtra("forceStartActivityTemp");
    }
    super.S();
    if (((this.i instanceof GuildChatContext)) && (((GuildChatContext)this.i).af()) && (!bC()))
    {
      ImmersiveUtils.setStatusTextColor(true, this.f.getWindow());
      a(this.f.getResources().getDrawable(2130840646));
    }
    GuildGiftManager.a().a("");
  }
  
  public boolean V()
  {
    if ((this.f instanceof SplashActivity)) {
      return f(0);
    }
    return super.V();
  }
  
  protected int[] W()
  {
    return new int[] { 2130772007, 2130772105 };
  }
  
  public void a()
  {
    Object localObject1 = this.f.getIntent();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Intent)localObject1).getBundleExtra("goto_guildtab_actionextra");
    if (localObject1 == null) {
      return;
    }
    boolean bool2 = ((Bundle)localObject1).getBoolean("keepOpenPos", false);
    boolean bool3 = ((Bundle)localObject1).getBoolean("openAioWithoutAnimation", false);
    boolean bool4 = ((Bundle)localObject1).getBoolean("openAioIn", false);
    Object localObject2 = this.i.b().getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if ((localObject2 instanceof MainFragment))
    {
      boolean bool1 = true;
      if (!bool2)
      {
        ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).guildAttachContainerInOrOut((MainFragment)localObject2, bool4, bool3 ^ true);
        return;
      }
      localObject1 = (IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class);
      localObject2 = (MainFragment)localObject2;
      int i = ((IGuildMainFrameApi)localObject1).getAttachContainerProgress((FrameFragment)localObject2);
      if ((i == 1000) || (i == 0))
      {
        localObject1 = (IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class);
        if (i != 1000) {
          bool1 = false;
        }
        ((IGuildMainFrameApi)localObject1).guildAttachContainerInOrOut((FrameFragment)localObject2, bool1, false);
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (TextUtils.isEmpty(this.ah.b))
    {
      QLog.e(bm, 1, "in updateSession_initIntentData, channelUin is null or empty");
    }
    else if (QLog.isColorLevel())
    {
      localObject = bm;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("channelUin is");
      localStringBuilder.append(this.ah.b);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.ah.c = paramIntent.getStringExtra("guild_id");
    this.bo = paramIntent.getIntExtra("channel_type", 0);
    Object localObject = ((GuildChatContext)this.i).U();
    if (localObject != null)
    {
      this.ah.c = ((IGProChannelInfo)localObject).getGuildId();
      if (TextUtils.isEmpty(paramIntent.getStringExtra("uinname"))) {
        paramIntent.putExtra("uinname", ((IGProChannelInfo)localObject).getChannelName());
      }
      if (TextUtils.isEmpty(paramIntent.getStringExtra("channel_name"))) {
        paramIntent.putExtra("channel_name", ((IGProChannelInfo)localObject).getChannelName());
      }
      if (this.bo == 0) {
        this.bo = ((IGProChannelInfo)localObject).getType();
      }
    }
    this.i.a().getMessageProxy(10014).e();
    if (!bJ()) {
      j().post(new GuildChatPie.1(this));
    }
    paramIntent = paramIntent.getBundleExtra("guild_extra");
    j().postDelayed(new GuildChatPie.2(this, paramIntent), 500L);
    ((IGuildEventFlowHandler)this.d.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName())).a(this.ah.c, this.ah.b);
  }
  
  protected void a(AIOLongShotHelper paramAIOLongShotHelper)
  {
    this.s.setBackgroundResource(2130853297);
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set left text from set checkbox: ");
      localStringBuilder.append(this.aB);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(this.aB))
    {
      this.s.setText("");
    }
    else
    {
      this.s.setText(this.aB);
      this.aB = "";
    }
    if (this.p != null) {
      this.p.e();
    }
    if (this.aL)
    {
      if (TextUtils.isEmpty(this.x.getText())) {
        this.x.setVisibility(8);
      } else {
        this.x.setVisibility(0);
      }
    }
    else {
      this.x.setVisibility(8);
    }
    MultiMsgManager.a().g();
    paramAIOLongShotHelper.b();
    this.V.g = Boolean.valueOf(true);
    ((GuildAIOMultiActionHelper)q(147)).e();
    this.u.setVisibility(0);
    this.v.setVisibility(8);
    if (this.d != null) {
      bf();
    }
    if (this.ak)
    {
      aC();
      this.ak = false;
    }
    this.aZ.findViewById(2131436236).setVisibility(0);
    this.q.setVisibility(4);
    this.r.setVisibility(0);
    this.U.getLayoutParams();
    if ((this.ad != null) && (!TextUtils.isEmpty(this.ad.getText().toString())) && (!"0".equals(this.ad.getText().toString())))
    {
      this.ad.setVisibility(0);
      ((UnreadBackBottomHelper)q(53)).b();
    }
  }
  
  public void a(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = MultiMsgManager.a().f();
    ((SelectToBottomHelper)q(40)).a(i);
  }
  
  public void a(GuildChatPieFoldStatusListener paramGuildChatPieFoldStatusListener)
  {
    ((GuildHelperProvider)this.g).a(paramGuildChatPieFoldStatusListener);
  }
  
  public void a(AbsGestureListener paramAbsGestureListener)
  {
    Fragment localFragment = aX().getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if ((localFragment instanceof MainFragment)) {
      ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).addGestureListener((MainFragment)localFragment, paramAbsGestureListener);
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
      if (paramObject.a == GuildAioAgent.A)
      {
        this.j.d().a(paramObject.e, paramObject.a(), paramObject.f);
        return;
      }
      int i = paramObject.a;
      i = GuildAioAgent.B;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, BaseChatPie paramBaseChatPie)
  {
    this.m.post(new GuildChatPie.3(this, paramString1, paramString3, paramString2));
  }
  
  protected boolean a(View paramView, int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramView == null) {
        return false;
      }
      e(paramView);
      Object localObject1 = (ChatMessage)this.V.getItem(paramInt);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((ChatMessage)localObject1).getExtInfoFromExtStr("guild_at_info_list");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = MessageForText.getTroopMemberInfoFromExtrJson((String)localObject1);
        localObject1 = ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)((Iterator)localObject2).next();
            if ((localAtTroopMemberInfo.flag == 1) || (localAtTroopMemberInfo.uin == Long.parseLong((String)localObject1)))
            {
              f(paramView);
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    p(true);
    a();
    bN();
    return paramBoolean;
  }
  
  public void aA()
  {
    if (this.p != null) {
      this.p.setRightToStr(HardCodeUtil.a(2131899217), new GuildChatPie.5(this));
    }
    TextView localTextView = (TextView)aW().findViewById(2131448237);
    if (localTextView != null) {
      localTextView.setTextColor(-16777216);
    }
    JubaoHelper.a(this.d, aX().getIntent());
    a(true, null, false, true);
  }
  
  public void aB()
  {
    this.X.setVisibility(8);
    this.bb.setVisibility(8);
  }
  
  public void aC()
  {
    this.X.setVisibility(0);
    this.bb.setVisibility(0);
  }
  
  public void aN()
  {
    if (((FrameLayout)bv().d(2131433906)).getVisibility() == 0) {
      super.aN();
    }
  }
  
  public boolean ab()
  {
    return true;
  }
  
  public void ai()
  {
    super.ai();
    bB();
  }
  
  protected void ap()
  {
    if (!(this.i.b() instanceof SplashActivity)) {
      bE();
    }
    ((GuildChatContext)this.i).P().b();
    super.ap();
    this.bk.clear();
  }
  
  protected void au()
  {
    super.au();
    this.bn.a();
  }
  
  protected void av()
  {
    super.av();
    this.bn.b();
  }
  
  protected HelperProvider b()
  {
    return new GuildHelperProvider(this.f);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    ((GuildInputBarHelper)q(145)).k();
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.U.setStackFromBottom(((GuildChatContext)this.i).W() ^ true);
  }
  
  public void b(GuildChatPieFoldStatusListener paramGuildChatPieFoldStatusListener)
  {
    ((GuildHelperProvider)this.g).b(paramGuildChatPieFoldStatusListener);
  }
  
  public void b(AbsGestureListener paramAbsGestureListener)
  {
    Fragment localFragment = aX().getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if ((localFragment instanceof MainFragment)) {
      ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).removeGestureListener((MainFragment)localFragment, paramAbsGestureListener);
    }
  }
  
  public int bA()
  {
    return this.bo;
  }
  
  protected void bB()
  {
    this.bd.setVisibility(8);
  }
  
  protected boolean bC()
  {
    return false;
  }
  
  public GuildPieClickProcessor bD()
  {
    if (this.bi == null)
    {
      this.bi = new GuildPieClickProcessor();
      this.bi.a((GuildChatContext)bv());
    }
    return this.bi;
  }
  
  public void bE()
  {
    bF();
    this.au = this.j.d().e;
    this.bj = ((GuildAioTips)this.au);
    this.j.d().a(this, this.o, this.V);
  }
  
  public void bF()
  {
    GuildAioTips localGuildAioTips = this.bj;
    if (localGuildAioTips != null) {
      localGuildAioTips.v();
    }
  }
  
  public void bG()
  {
    int j = this.U.getFirstVisiblePosition();
    int k = this.U.getLastVisiblePosition();
    if (k > j)
    {
      if (j < 0) {
        return;
      }
      int i = 0;
      while (i <= k - j)
      {
        a(this.U.getChildAt(i), j + i - 1);
        i += 1;
      }
    }
  }
  
  public void bH()
  {
    if (this.br != null) {
      return;
    }
    String str = this.ah.b;
    int i = this.ah.a;
    Object localObject = (IGuildMsgSeqTimeService)this.d.getRuntimeService(IGuildMsgSeqTimeService.class, "");
    this.br = ((IGuildMsgSeqTimeService)localObject).getReadedMsgSeq(str);
    localObject = ((IGuildMsgSeqTimeService)localObject).getLastSvrMsgSeq(str);
    if ((this.br != null) && (localObject != null) && (((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject).a != this.br.a))
    {
      localObject = this.d.getMessageFacade().s();
      ((BaseGuildMessageManager)localObject).a(i, str, this.br.a, ((BaseGuildMessageManager)localObject).a(str, i));
      j(131072);
    }
  }
  
  public void bI()
  {
    if (this.br == null) {
      return;
    }
    String str = this.ah.b;
    int i = this.ah.a;
    this.br = ((IGuildMsgSeqTimeService)this.d.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(str);
    BaseGuildMessageManager localBaseGuildMessageManager = this.d.getMessageFacade().s();
    localBaseGuildMessageManager.b(localBaseGuildMessageManager.a(str, i));
    j(131072);
    this.br = null;
  }
  
  protected void bz()
  {
    if (this.d != null) {
      this.j.e().h();
    }
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new GuildMessageSender(this.i)).a();
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.c, 2, "set left text from cancel");
    }
    this.aB = this.s.getText().toString();
    this.s.setText(2131887626);
    this.s.setBackgroundDrawable(null);
    if (this.p != null) {
      this.p.e();
    }
    ((GuildAIOMultiActionHelper)q(147)).a(paramChatMessage);
    this.u.setVisibility(4);
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)q(15);
    if (localAIOLongShotHelper.c())
    {
      localAIOLongShotHelper.g();
      this.q.setVisibility(4);
      this.r.setVisibility(4);
    }
    if (this.W != null) {
      this.W.setCustomHeight(0);
    }
    a(true, paramChatMessage, false);
  }
  
  protected AIOContext d()
  {
    return new GuildChatContext();
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new GuildScroller()).a(new GuildListUI(this.i)).a(new GuildMsgListRefresher(this.i)).a(new GuildUnreadTaskNone(this.i)).a(new GuildMsgLoader()).a();
  }
  
  protected void e(View paramView)
  {
    if (paramView == null) {
      return;
    }
    View localView = paramView.findViewById(2131434585);
    if (localView != null)
    {
      Object localObject = (WeakReference)this.bk.get(paramView);
      if (localObject != null)
      {
        localObject = (Animator)((WeakReference)localObject).get();
        this.bk.remove(paramView);
        if ((localObject != null) && (((Animator)localObject).isStarted()))
        {
          ((Animator)localObject).removeAllListeners();
          ((Animator)localObject).end();
          localView.setBackgroundColor(16773091);
        }
      }
    }
  }
  
  protected void f(View paramView)
  {
    Object localObject = paramView.findViewById(2131434585);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        String str = bm;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FlushMessageItem:");
        localStringBuilder.append(paramView.hashCode());
        localStringBuilder.append(",");
        localStringBuilder.append(paramView.getParent());
        QLog.i(str, 2, localStringBuilder.toString());
      }
      localObject = ObjectAnimator.ofInt(localObject, "backgroundColor", new int[] { 16773091, -4125, -4125, 16773091 });
      ((ValueAnimator)localObject).setDuration(this.bl);
      ((ValueAnimator)localObject).setEvaluator(new ArgbEvaluator());
      this.bk.put(paramView, new WeakReference(localObject));
      ((ValueAnimator)localObject).addListener(new GuildChatPie.4(this));
      ((ValueAnimator)localObject).start();
    }
  }
  
  public boolean f(int paramInt)
  {
    if (!(this.f instanceof SplashActivity))
    {
      bF();
      return super.f(paramInt);
    }
    if (t(paramInt)) {
      return true;
    }
    as();
    Fragment localFragment = this.i.b().getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if ((localFragment instanceof MainFragment)) {
      ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).guildAttachContainerInOrOut((MainFragment)localFragment, true, true);
    }
    bz();
    return true;
  }
  
  protected void h()
  {
    this.c = "GuildChatPies";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 60) && (this.ah.a == 10014))
    {
      ViewGroup localViewGroup = (ViewGroup)bv().s().findViewById(2131427887);
      if (localViewGroup != null)
      {
        localViewGroup.setBackgroundResource(2130840646);
        return true;
      }
    }
    else if ((paramMessage.what == 13) && (this.ah.a == 10014))
    {
      if (((GuildChatContext)bv()).W()) {
        return true;
      }
    }
    else if (paramMessage.what == 16711698)
    {
      ((GuildChatContext)this.i).P().e();
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void k(boolean paramBoolean)
  {
    if (!(this.f instanceof SplashActivity)) {
      super.k(paramBoolean);
    }
  }
  
  protected void l()
  {
    bK();
    bL();
    bM();
    super.l();
    this.j.d().a(true);
    this.X.setBackgroundResource(2130840647);
    this.X.setPadding(0, 0, 0, 0);
    this.X.setClickable(true);
    this.bs = new GestureDetector(this.e, new GuildChatPie.GuildOnGestureListener(this));
    bB();
  }
  
  protected ChatAdapter1 m()
  {
    return new GuildPieAdapter(this.d, this.f, this.ah, this.aU, this);
  }
  
  protected void o() {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.V != null)
    {
      if (this.aR < paramInt1) {
        e(this.aP);
      }
      int j = paramInt1 + paramInt2;
      int k = j - 1;
      if ((k < this.aS) && (k > 0)) {
        e(this.aQ);
      }
      super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      paramInt3 = this.bp;
      int i = 0;
      if (paramInt1 < paramInt3)
      {
        paramInt3 = 0;
        while (paramInt3 < this.bp - paramInt1)
        {
          a(paramAbsListView.getChildAt(paramInt3), this.U.getFirstVisiblePosition() + paramInt3 - 1);
          paramInt3 += 1;
        }
      }
      if (this.bq < k)
      {
        paramInt3 = i;
        while (paramInt3 < j - this.bq - 1)
        {
          a(paramAbsListView.getChildAt(paramInt2 - paramInt3 - 1), this.U.getLastVisiblePosition() - paramInt3 - 1);
          paramInt3 += 1;
        }
      }
      this.bp = paramInt1;
      this.bq = k;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131437281) {
      this.bs.onTouchEvent(paramMotionEvent);
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  protected void p(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (((GuildChatContext)this.i).af()) && ((this.aZ instanceof ChatFragmentTopGestureLayout)))
    {
      this.aZ.setFitsSystemWindows(paramBoolean);
      String str = bm;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFitsSystemWindows set:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" mAIORootView:");
      localStringBuilder.append(this.aZ);
      QLog.i(str, 1, localStringBuilder.toString());
    }
  }
  
  public void q(boolean paramBoolean)
  {
    this.P = paramBoolean;
  }
  
  protected boolean s(int paramInt)
  {
    return super.f(paramInt);
  }
  
  protected boolean t(int paramInt)
  {
    if (((GuildHelperProvider)this.g).f(paramInt)) {
      return true;
    }
    boolean bool = c(false);
    String str;
    StringBuilder localStringBuilder;
    if ((bool) && (paramInt == 0))
    {
      if (QLog.isColorLevel())
      {
        str = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("basechatpie_finish 1,type:");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return true;
    }
    g(paramInt);
    if ((a(paramInt, bool)) && (paramInt == 0))
    {
      if (QLog.isColorLevel())
      {
        str = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("basechatpie_finish 3,type:");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof AioAgent.Message))
    {
      a(paramObject);
      return;
    }
    if ((paramObject instanceof ChatMessage)) {
      ((GuildChatContext)this.i).P().a((ChatMessage)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildChatPie
 * JD-Core Version:    0.7.0.1
 */