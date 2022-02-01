package com.tencent.mobileqq.guild.chatpie.helper;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.FakeInputUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IGuildTextUtil;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.clickprocessor.GuildPieClickProcessor;
import com.tencent.mobileqq.guild.gift.config.api.IGuildAIOGiftEntryApi;
import com.tencent.mobileqq.guild.vas.GuildGiftManager;
import com.tencent.mobileqq.guild.vas.IGuildGiftManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.MobileQQ;

public class GuildInputBarHelper
  implements ILifeCycleHelper
{
  protected final GuildChatContext a;
  protected final Resources b;
  protected ImageButton c;
  protected ImageButton d;
  protected Button e;
  protected XEditTextEx f;
  protected XListView g;
  protected int h = -1;
  private final QQAppInterface i;
  private IGProChannelInfo j = null;
  private boolean k;
  private final GPServiceObserver l = new GuildInputBarHelper.1(this);
  private TextView m;
  private LinearLayout n;
  private Animator o;
  private Animator p;
  private final Interpolator q = new LinearInterpolator();
  
  public GuildInputBarHelper(GuildChatContext paramGuildChatContext)
  {
    this.a = paramGuildChatContext;
    this.i = paramGuildChatContext.a();
    this.b = paramGuildChatContext.a().getApplication().getResources();
  }
  
  private void E()
  {
    L();
  }
  
  private void F()
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).addObserver(this.l);
  }
  
  private void G()
  {
    Q();
  }
  
  private void H()
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).deleteObserver(this.l);
  }
  
  private void I()
  {
    if (this.m != null) {
      return;
    }
    Object localObject = (FullScreenInputHelper)this.a.a(24);
    this.m = new TextView(this.a.b());
    this.m.setTextSize(b());
    this.m.setTextColor(this.b.getColor(a()));
    this.m.setGravity(17);
    this.m.setText(this.b.getString(2131896464));
    this.m.setVisibility(8);
    this.m.setClickable(true);
    this.m.setIncludeFontPadding(false);
    int i1 = ((ViewGroup)((FullScreenInputHelper)localObject).b.getParent()).indexOfChild(((FullScreenInputHelper)localObject).b);
    localObject = new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(64.0F));
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    this.a.p().d().e().a(this.m, i1, (ViewGroup.LayoutParams)localObject);
  }
  
  private void J()
  {
    if (this.n != null) {
      return;
    }
    FullScreenInputHelper localFullScreenInputHelper = (FullScreenInputHelper)this.a.a(24);
    Button localButton = new Button(this.a.b());
    localButton.setTextColor(c(this.b));
    localButton.setText(d());
    localButton.setBackgroundResource(e());
    localButton.setTextSize(2, 16.0F);
    localButton.setOnClickListener(new -..Lambda.GuildInputBarHelper.iSD-rFiqUBlDAaGLD4MqeADpgUQ(this));
    localButton.setHeight(AIOUtils.b(40.0F, this.b));
    localButton.setPadding(0, 0, 0, 0);
    TextView localTextView = new TextView(this.a.b());
    localTextView.setText(2131890223);
    localTextView.setIncludeFontPadding(false);
    localTextView.setTextColor(a(this.b));
    localTextView.setId(2131427969);
    localTextView.setGravity(17);
    localTextView.setPadding(0, ViewUtils.dip2px(10.0F), 0, ViewUtils.dip2px(10.0F));
    localTextView.setTextSize(2, 16.0F);
    this.n = new LinearLayout(this.a.b());
    this.n.setOrientation(1);
    this.n.addView(localTextView);
    this.n.addView(localButton);
    this.n.setGravity(1);
    this.n.setBackgroundDrawable(b(this.b));
    this.n.setClickable(true);
    int i1 = ((ViewGroup)localFullScreenInputHelper.b.getParent()).indexOfChild(localFullScreenInputHelper.b);
    this.a.p().d().e().a(this.n, i1, c());
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(localButton, "em_stream_aio_tourist", null);
  }
  
  private void K()
  {
    Object localObject2 = this.a.b().getIntent().getExtras().getBundle("guild_extra");
    int i1;
    Object localObject1;
    if (localObject2 != null)
    {
      i1 = ((Bundle)localObject2).getInt("guild_extra_join_from");
      localObject1 = ((Bundle)localObject2).getString("guild_extra_join_sig");
      localObject2 = ((Bundle)localObject2).getString("guild_id");
    }
    else
    {
      localObject2 = null;
      localObject1 = localObject2;
      i1 = -1;
    }
    if ((i1 != -1) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(this.a.S())))
    {
      localObject2 = (IQQGuildService)this.a.a().getRuntimeService(IQQGuildService.class, "");
      ((IQQGuildService)localObject2).globalSetJumpEntrance(this.j.getType());
      ((IQQGuildService)localObject2).addGuild(this.a.b(), this.a.S(), (String)localObject1, i1, new GuildInputBarHelper.2(this));
      return;
    }
    QLog.e("GuildInputBarHelper", 1, new Object[] { "join Guild arg error! guildId = ", this.a.S() });
  }
  
  private void L()
  {
    ((LinearLayout)this.a.d(2131433921)).setVisibility(8);
    this.c = ((ImageButton)this.a.d(2131427967));
    this.d = ((ImageButton)this.a.d(2131427968));
    this.f = this.a.Q();
    this.g = ((XListView)this.a.d(2131437281));
    j();
    O();
    N();
    P();
    M();
  }
  
  private void M()
  {
    ((RelativeLayout.LayoutParams)this.g.getLayoutParams()).addRule(2, 2131435809);
  }
  
  private void N()
  {
    GuildInputBarHelper.3 local3 = new GuildInputBarHelper.3(this);
    this.f.setCustomSelectionActionModeCallback(local3);
    if (Build.VERSION.SDK_INT >= 23) {
      this.f.setCustomInsertionActionModeCallback(local3);
    }
  }
  
  private void O()
  {
    this.f.setTextSize(16.666666F);
    this.f.setHintTextColor(this.b.getColor(i()));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.f, "em_aio_input_box", null);
    View localView = new View(this.a.b());
    localView.setBackgroundColor(h());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(0.25F, this.b));
    localLayoutParams.addRule(2, 2131435809);
    ViewGroup localViewGroup = (ViewGroup)this.a.d(2131430542);
    if (localViewGroup != null) {
      localViewGroup.addView(localView, localLayoutParams);
    }
  }
  
  private void P()
  {
    ImageButton localImageButton = this.d;
    if (localImageButton == null) {
      return;
    }
    localImageButton.setBackgroundResource(m());
    this.d.setContentDescription(this.b.getString(2131894081));
    this.d.setOnClickListener(new -..Lambda.GuildInputBarHelper.43D5-iUTjNgvVT3nnS2uNHc6exM(this));
    D();
  }
  
  private void Q()
  {
    k();
    R();
    x();
    w();
  }
  
  private void R()
  {
    if (BaseChatItemLayout.ad) {
      return;
    }
    J();
    I();
    Object localObject1 = (SessionInfo)this.a.O();
    Object localObject2 = (FullScreenInputHelper)this.a.a(24);
    boolean bool1 = this.a.Y();
    boolean bool2 = ((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).canTalkinChannel(this.a.a(), this.a.S(), ((SessionInfo)localObject1).b);
    localObject1 = getTag();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateTalkPermission canTalk = ");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append(", mSelfBannedSpeak = ");
    ((StringBuilder)localObject2).append(this.k);
    QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
    int i1;
    if ((bool2) && (!this.k)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (bool1)
    {
      this.n.setVisibility(0);
      e(false);
      this.m.setVisibility(8);
      return;
    }
    if (i1 == 0)
    {
      this.n.setVisibility(8);
      e(false);
      if (this.k) {
        this.m.setText(2131890416);
      } else {
        this.m.setText(2131896464);
      }
      this.m.setVisibility(0);
      this.f.setText("");
      return;
    }
    this.n.setVisibility(8);
    this.m.setVisibility(8);
    e(true);
  }
  
  private void S()
  {
    Object localObject = this.e;
    ((Button)localObject).setPivotX(((Button)localObject).getWidth() / 2.0F);
    localObject = this.e;
    ((Button)localObject).setPivotY(((Button)localObject).getHeight() / 2.0F);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).setDuration(200L);
    ((AnimatorSet)localObject).playTogether(b(true));
    ((AnimatorSet)localObject).start();
  }
  
  private void T()
  {
    Object localObject = this.e;
    ((Button)localObject).setPivotX(((Button)localObject).getWidth() / 2.0F);
    localObject = this.e;
    ((Button)localObject).setPivotY(((Button)localObject).getHeight() / 2.0F);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).setDuration(200L);
    ((AnimatorSet)localObject).addListener(new GuildInputBarHelper.6(this));
    ((AnimatorSet)localObject).playTogether(b(false));
    ((AnimatorSet)localObject).start();
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    String str;
    switch (paramInt)
    {
    default: 
      str = HardCodeUtil.a(2131890217);
      break;
    case 22009: 
    case 22010: 
      str = HardCodeUtil.a(2131890390);
      break;
    case 22008: 
      str = HardCodeUtil.a(2131890389);
      break;
    case 22007: 
      str = HardCodeUtil.a(2131890391);
      break;
    case 22006: 
      str = HardCodeUtil.a(2131890393);
    }
    QQToast.makeText(BaseApplication.getContext(), str, 0).show();
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    Button localButton = this.e;
    localButton.setPivotX(localButton.getWidth() / 2.0F);
    localButton = this.e;
    localButton.setPivotY(localButton.getHeight() / 2.0F);
    if (paramInt2 == 1)
    {
      if (this.o == null)
      {
        this.o = ObjectAnimator.ofFloat(this.e, "rotation", new float[] { 0.0F, 45.0F });
        this.o.setInterpolator(this.q);
        this.o.setDuration(300L);
      }
      this.o.start();
      return;
    }
    if (this.p == null)
    {
      this.p = ObjectAnimator.ofFloat(this.e, "rotation", new float[] { 45.0F, 0.0F });
      this.p.setInterpolator(this.q);
      this.p.setDuration(300L);
    }
    if (this.e.getRotation() > 0.0F) {
      this.p.start();
    }
  }
  
  private void e(boolean paramBoolean)
  {
    FullScreenInputHelper localFullScreenInputHelper = (FullScreenInputHelper)this.a.a(24);
    if (paramBoolean)
    {
      localFullScreenInputHelper.b.setVisibility(0);
      this.a.p().d().b().a();
      return;
    }
    localFullScreenInputHelper.b.setVisibility(8);
    this.a.p().d().b().b();
  }
  
  protected int A()
  {
    return 2131166191;
  }
  
  protected int B()
  {
    return 0;
  }
  
  protected int C()
  {
    return 2130840976;
  }
  
  protected void D()
  {
    GuildGiftManager.a().a(new GuildInputBarHelper.7(this));
  }
  
  protected int a()
  {
    return 2131166190;
  }
  
  protected int a(Resources paramResources)
  {
    return Color.parseColor("#999999");
  }
  
  protected SpannableStringBuilder a(Resources paramResources, String paramString)
  {
    return new SpannableStringBuilder(paramString);
  }
  
  protected String a(IGProChannelInfo paramIGProChannelInfo)
  {
    return paramIGProChannelInfo.getChannelName();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    Button localButton = this.e;
    Object localObject;
    if (paramInt2 == 0) {
      localObject = "em_aio_send";
    } else {
      localObject = "em_aio_plus";
    }
    VideoReport.setElementId(localButton, (String)localObject);
    VideoReport.resetElementParams(this.e);
    if (paramInt2 != 0)
    {
      localObject = this.e;
      if (paramInt2 == 2) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      VideoReport.setElementParam(localObject, "sgrp_channel_plus", Integer.valueOf(paramInt1));
    }
    if ((this.e.getVisibility() == 0) && (!this.a.Y())) {
      VideoReport.reportEvent("imp", this.e, null);
    }
  }
  
  public void a(AIOContext paramAIOContext, Editable paramEditable)
  {
    t();
  }
  
  protected void a(boolean paramBoolean)
  {
    String str = getTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSelfBannedSpeakChange banned = ");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 4, localStringBuilder.toString());
    this.k = paramBoolean;
    R();
  }
  
  protected float b()
  {
    return 17.0F;
  }
  
  protected Drawable b(Resources paramResources)
  {
    return null;
  }
  
  protected Collection<Animator> b(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    float f2 = 0.0F;
    float f1;
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    if (paramBoolean) {
      f2 = 1.0F;
    }
    localArrayList.add(ObjectAnimator.ofFloat(this.e, "scaleX", new float[] { f1, f2 }));
    localArrayList.add(ObjectAnimator.ofFloat(this.e, "scaleY", new float[] { f1, f2 }));
    localArrayList.add(ObjectAnimator.ofFloat(this.e, "alpha", new float[] { f1, f2 }));
    localArrayList.add(ObjectAnimator.ofInt(new GuildInputBarHelper.ViewRightMarginWrapper(this.c), "trueRightMargin", new int[] { c(paramBoolean ^ true), c(paramBoolean) }));
    localArrayList.add(ObjectAnimator.ofInt(new GuildInputBarHelper.ViewRightMarginWrapper(this.f), "trueRightMargin", new int[] { d(paramBoolean ^ true), d(paramBoolean) }));
    return localArrayList;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    if (paramInt1 == 0)
    {
      T();
      return;
    }
    c(paramInt1, paramInt2);
  }
  
  protected int c(Resources paramResources)
  {
    return -1;
  }
  
  protected int c(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 60;
    } else {
      i1 = 54;
    }
    return ViewUtils.dpToPx(i1);
  }
  
  protected LinearLayout.LayoutParams c()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.leftMargin = AIOUtils.b(12.0F, this.b);
    localLayoutParams.rightMargin = AIOUtils.b(12.0F, this.b);
    localLayoutParams.bottomMargin = AIOUtils.b(10.0F, this.b);
    localLayoutParams.gravity = 80;
    return localLayoutParams;
  }
  
  protected int d()
  {
    return 2131890222;
  }
  
  protected int d(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 99;
    } else {
      i1 = 96;
    }
    return ViewUtils.dpToPx(i1);
  }
  
  protected String d(Resources paramResources)
  {
    return paramResources.getString(2131896463);
  }
  
  protected int e()
  {
    return 2130840653;
  }
  
  protected void f()
  {
    this.a.R().onClick(this.d);
  }
  
  public int g()
  {
    return ViewUtils.dip2px(14.0F);
  }
  
  public String getTag()
  {
    return "GuildInputBarHelper";
  }
  
  protected int h()
  {
    return Color.parseColor("#D8D8D8");
  }
  
  protected int i()
  {
    return 2131167239;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 4, 7, 15 };
  }
  
  public void j()
  {
    this.e = ((Button)this.a.d(2131433905));
    this.e.setGravity(17);
    this.e.setOnClickListener(new -..Lambda.GuildInputBarHelper.x3KYl17sSKvjt08Z2LRN_kO6HiU(this));
    this.e.setVisibility(0);
    this.e.setClickable(true);
    this.e.setBackgroundResource(C());
    GuildInputBarHelper.4 local4 = new GuildInputBarHelper.4(this);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.e, "em_aio_plus", local4);
  }
  
  public void k()
  {
    s();
    t();
    n();
  }
  
  protected int l()
  {
    return 2130840811;
  }
  
  protected int m()
  {
    return 2130840811;
  }
  
  public void n()
  {
    if (this.d == null) {
      return;
    }
    if (this.a.k() == 3) {
      this.d.setBackgroundResource(l());
    } else {
      this.d.setBackgroundResource(m());
    }
    int i1 = o();
    if (i1 != 0) {
      this.d.setContentDescription(this.b.getString(i1));
    }
    ImageButton localImageButton = this.d;
    if (localImageButton != null)
    {
      if (p()) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localImageButton.setVisibility(i1);
    }
  }
  
  protected int o()
  {
    return 2131894081;
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt != 7)
        {
          if (paramInt != 15) {
            return;
          }
          H();
          return;
        }
        G();
        return;
      }
      F();
      return;
    }
    E();
  }
  
  protected boolean p()
  {
    return ((IGuildAIOGiftEntryApi)QRoute.api(IGuildAIOGiftEntryApi.class)).isShowEntry(this.a.T());
  }
  
  protected int q()
  {
    return 2130840803;
  }
  
  protected int r()
  {
    return 2130840802;
  }
  
  protected void s()
  {
    if (this.c == null) {
      return;
    }
    if (this.a.k() == 3)
    {
      this.c.setBackgroundResource(q());
      this.c.setContentDescription(this.b.getString(2131896460));
      return;
    }
    this.c.setBackgroundResource(r());
    this.c.setContentDescription(this.b.getString(2131896459));
  }
  
  public void t()
  {
    Object localObject1 = this.e;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (FrameLayout.LayoutParams)((Button)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject1).gravity = 85;
    int i1 = AIOUtils.b(28.0F, this.b);
    ((FrameLayout.LayoutParams)localObject1).height = i1;
    ((FrameLayout.LayoutParams)localObject1).width = i1;
    ((FrameLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(14.0F, this.b);
    ((FrameLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(16.0F, this.b);
    i1 = this.h;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mFunBtnState = ");
    ((StringBuilder)localObject2).append(this.h);
    QLog.d("GuildInputBarHelper", 1, ((StringBuilder)localObject2).toString());
    if (((IGuildTextUtil)QRoute.api(IGuildTextUtil.class)).filterTailSpace(this.f.getText()).length() > 0)
    {
      this.h = 0;
      localObject2 = this.e;
      ((Button)localObject2).setPivotX(((Button)localObject2).getWidth() / 2.0F);
      localObject2 = this.e;
      ((Button)localObject2).setPivotY(((Button)localObject2).getHeight() / 2.0F);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mFunBtn.getRotation() = ");
      ((StringBuilder)localObject2).append(this.e.getRotation());
      QLog.d("GuildInputBarHelper", 1, ((StringBuilder)localObject2).toString());
      this.e.setRotation(0.0F);
      this.e.setBackgroundResource(B());
      this.e.setText(HardCodeUtil.a(2131899195));
      this.e.setTextColor(u());
      this.e.setTextSize(17.0F);
      ((FrameLayout.LayoutParams)localObject1).width = -2;
      this.e.setContentDescription(HardCodeUtil.a(2131899195));
      if (i1 != this.h) {
        S();
      }
      a(i1, this.h);
    }
    else if (this.a.k() == 8)
    {
      this.h = 1;
      b(i1, this.h);
      a(i1, this.h);
      this.e.setText("");
      this.e.setContentDescription(HardCodeUtil.a(2131911578));
    }
    else
    {
      this.h = 2;
      b(i1, this.h);
      a(i1, this.h);
      this.e.setText("");
      this.e.setContentDescription(HardCodeUtil.a(2131911578));
    }
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  protected int u()
  {
    return -16777216;
  }
  
  public void v()
  {
    if (this.a.k() == 8)
    {
      this.a.a(1, true);
      return;
    }
    this.a.a(8, true);
  }
  
  public void w()
  {
    Object localObject1 = getTag();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkUserBannedSpeakInChannel currChannelInfo = ");
    ((StringBuilder)localObject2).append(this.j);
    QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
    if (this.j == null) {
      return;
    }
    localObject1 = (IGPSService)this.i.getRuntimeService(IGPSService.class, "");
    localObject2 = ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    ((IGPSService)localObject1).checkUserBannedSpeakInChannel(this.j.getGuildId(), this.j.getChannelUin(), (String)localObject2, new GuildInputBarHelper.5(this));
  }
  
  protected void x()
  {
    this.j = this.a.U();
    Object localObject1 = this.j;
    if (localObject1 != null) {
      localObject1 = a((IGProChannelInfo)localObject1);
    } else {
      localObject1 = this.a.b().getIntent().getStringExtra("channel_name");
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    String str = d(this.b);
    this.f.setTextColor(this.b.getColorStateList(A()));
    Object localObject2 = (ViewGroup.MarginLayoutParams)this.f.getLayoutParams();
    float f1;
    if (p()) {
      f1 = 56.0F;
    } else {
      f1 = 14.0F;
    }
    ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = ViewUtils.dip2px(f1);
    ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = ViewUtils.dip2px(z());
    ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ViewUtils.dip2px(10.0F);
    ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = ViewUtils.dip2px(10.0F);
    localObject2 = this.a.d(2131427972);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
      if (p()) {
        f1 = 63.0F;
      } else {
        f1 = 21.0F;
      }
      ((ViewGroup.MarginLayoutParams)localObject3).leftMargin = ViewUtils.dip2px(f1);
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    }
    int i1 = 1;
    for (;;)
    {
      localObject2 = localObject1;
      if (i1 >= ((String)localObject1).length()) {
        break;
      }
      localObject2 = this.f.getPaint();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(String.format(str, new Object[] { ((String)localObject1).substring(0, i1) }));
      ((StringBuilder)localObject3).append("...");
      if (((TextPaint)localObject2).measureText(((StringBuilder)localObject3).toString()) > y())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((String)localObject1).substring(0, i1 - 1));
        ((StringBuilder)localObject2).append("...");
        localObject2 = ((StringBuilder)localObject2).toString();
        break;
      }
      i1 += 1;
    }
    localObject1 = String.format(str, new Object[] { localObject2 });
    this.f.setHint(a(this.b, (String)localObject1));
  }
  
  protected int y()
  {
    ImageButton localImageButton = this.d;
    int i1;
    if ((localImageButton != null) && (localImageButton.getVisibility() == 0)) {
      i1 = 215;
    } else {
      i1 = 180;
    }
    return ViewUtils.getScreenWidth() - ViewUtils.dip2px(i1);
  }
  
  protected int z()
  {
    return 99;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper
 * JD-Core Version:    0.7.0.1
 */