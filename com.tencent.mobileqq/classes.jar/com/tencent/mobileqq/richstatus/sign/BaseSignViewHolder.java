package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.OnTextOrFontChangeListener;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.topic.StateColorMovementMethod;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.RefreshListener;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.util.WeakReference;

public class BaseSignViewHolder
  implements View.OnClickListener, ViewTreeObserver.OnPreDrawListener, ETTextView.OnTextOrFontChangeListener, ISignViewHolder, ITopic.OnTopicClickListener
{
  static int[] N;
  public String A;
  int B;
  VasRes C;
  VasResDrawable D;
  protected int E;
  protected int F;
  long G;
  boolean H;
  boolean I = false;
  boolean J;
  boolean K;
  WeakReference<ISignViewHolder.OnClickListener> L;
  WeakReference<ITopic.OnTopicClickListener> M;
  public Observer O = new BaseSignViewHolder.2(this);
  Runnable P = new BaseSignViewHolder.3(this);
  private VasResDrawable.RefreshListener a = new BaseSignViewHolder.1(this);
  BoxShadowLayout i;
  LinearLayout j;
  View k;
  SingleLineTextView l;
  SingleLineTextView m;
  ImageView n;
  ImageView o;
  public ETTextView p;
  View q;
  View r;
  View s;
  View t;
  int u;
  Context v;
  RichStatus w;
  SignatureTemplateInfo x;
  public int y;
  AppInterface z;
  
  public BaseSignViewHolder(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    this.v = paramContext;
    this.i = ((BoxShadowLayout)paramView);
    this.z = paramAppInterface;
    this.A = paramString;
    this.E = AIOUtils.b(12.0F, paramContext.getResources());
    this.F = 2130847784;
    x();
    a();
    SignatureManagerForTool.a().addObserver(this.O);
  }
  
  private void x()
  {
    if (N == null)
    {
      N = new int[17];
      N[0] = this.v.getResources().getColor(2131167335);
      N[1] = this.v.getResources().getColor(2131167336);
      N[2] = this.v.getResources().getColor(2131167337);
      N[3] = this.v.getResources().getColor(2131167339);
      N[4] = this.v.getResources().getDimensionPixelSize(2131299246);
      N[5] = this.v.getResources().getDimensionPixelSize(2131299244);
      N[6] = this.v.getResources().getDimensionPixelSize(2131299245);
      N[7] = this.v.getResources().getDimensionPixelSize(2131299247);
      N[8] = AIOUtils.b(12.0F, this.v.getResources());
      N[9] = AIOUtils.b(17.0F, this.v.getResources());
      N[10] = AIOUtils.b(20.0F, this.v.getResources());
      N[11] = AIOUtils.b(8.0F, this.v.getResources());
      N[12] = AIOUtils.b(12.0F, this.v.getResources());
      N[13] = this.v.getResources().getColor(2131167338);
      N[14] = this.v.getResources().getColor(2131167335);
      N[15] = this.v.getResources().getColor(2131168485);
      N[16] = this.v.getResources().getColor(2131168464);
    }
  }
  
  private void y()
  {
    boolean bool4 = m();
    boolean bool5 = n();
    boolean bool6 = o();
    boolean bool7 = p();
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1;
    if (bool4)
    {
      localObject = TimeFormatterUtils.d(this.v, this.w.time * 1000L);
      this.l.setText((CharSequence)localObject);
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    Object localObject = this.l;
    int i2;
    if (bool4) {
      i2 = 0;
    } else {
      i2 = 8;
    }
    ((SingleLineTextView)localObject).setVisibility(i2);
    if (bool5)
    {
      if (!TextUtils.isEmpty(this.w.locationText))
      {
        this.m.setText(this.w.locationText);
        this.m.setVisibility(0);
        bool1 = bool3;
      }
      else
      {
        this.m.setText("");
        this.m.setVisibility(8);
      }
    }
    else {
      this.m.setVisibility(8);
    }
    localObject = this.k;
    if ((bool1) && (bool7)) {
      i2 = 0;
    } else {
      i2 = 8;
    }
    ((View)localObject).setVisibility(i2);
    localObject = this.o;
    if (bool6) {
      i2 = 0;
    } else {
      i2 = 8;
    }
    ((ImageView)localObject).setVisibility(i2);
    localObject = this.n;
    if (bool6) {
      i2 = 0;
    } else {
      i2 = 8;
    }
    ((ImageView)localObject).setVisibility(i2);
    t();
    localObject = (ViewGroup.MarginLayoutParams)this.s.getLayoutParams();
    if (bool6) {
      i2 = N[7];
    } else {
      i2 = 0;
    }
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i2;
    localObject = this.q;
    int i1;
    if ((bool1 | bool6)) {
      bool1 = bool2;
    } else {
      i1 = 8;
    }
    ((View)localObject).setVisibility(i1);
  }
  
  private void z()
  {
    int i1;
    if (this.x.D != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject;
    if (i1 != 0) {
      localObject = this.x.s;
    } else {
      localObject = a(this.w, this, this.B);
    }
    if (!this.p.getText().equals(localObject)) {
      this.G = System.currentTimeMillis();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((!this.x.a.get()) && (!TextUtils.isEmpty(this.x.s))) {
        localObject = this.x.s;
      } else {
        localObject = "";
      }
      if (this.w.plainText == null)
      {
        this.w.plainText = new ArrayList(2);
        this.w.plainText.add("");
        this.w.plainText.add("");
      }
      if (this.w.tplId != 0) {
        this.w.plainText.set(0, ((CharSequence)localObject).toString());
      }
      this.p.setHint(2131897237);
      this.p.setHintTextColor(this.v.getResources().getColor(2131167336));
    }
    else
    {
      this.p.setHint(null);
    }
    this.p.setTextMsg(new QQText((CharSequence)localObject, 1, 20));
    this.p.getViewTreeObserver().addOnPreDrawListener(this);
  }
  
  public View a(RichStatus paramRichStatus)
  {
    this.w = paramRichStatus;
    if (paramRichStatus == null) {
      return this.i;
    }
    this.x = g();
    paramRichStatus.signType = this.x.E;
    boolean bool;
    if (this.x.D != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.H = bool;
    this.I = this.x.a.get();
    if ((b()) && (!this.I) && (!this.H)) {
      d();
    } else {
      f();
    }
    e();
    return this.i;
  }
  
  protected CharSequence a(RichStatus paramRichStatus, ITopic.OnTopicClickListener paramOnTopicClickListener, int paramInt)
  {
    Object localObject = this.z;
    if (!(localObject instanceof QQAppInterface)) {
      return "";
    }
    if (paramRichStatus == null) {
      return new SpannableString("");
    }
    StatusManager localStatusManager = (StatusManager)((AppInterface)localObject).getManager(QQManagerFactory.STATUS_MANAGER);
    Resources localResources = this.v.getResources();
    SpannableString localSpannableString = new SpannableString(paramRichStatus.toSpannableStringWithoutAction(paramOnTopicClickListener));
    if ((paramRichStatus != null) && (localResources != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      localObject = paramRichStatus.actionText;
      paramOnTopicClickListener = (ITopic.OnTopicClickListener)localObject;
      if (!TextUtils.isEmpty(paramRichStatus.dataText))
      {
        paramOnTopicClickListener = new StringBuilder();
        paramOnTopicClickListener.append((String)localObject);
        paramOnTopicClickListener.append(paramRichStatus.dataText);
        paramOnTopicClickListener = paramOnTopicClickListener.toString();
      }
      Drawable localDrawable = localResources.getDrawable(2130851616);
      localObject = new SpannableStringBuilder(localSpannableString);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      if (localStatusManager != null) {
        paramRichStatus = localStatusManager.a(paramRichStatus.actionId, 200);
      } else {
        paramRichStatus = BitmapManager.a(localResources, 2130851609);
      }
      paramRichStatus = new StatableBitmapDrawable(localResources, paramRichStatus, false, false);
      paramRichStatus.setBounds(0, 0, paramInt, paramInt);
      int i1 = Color.parseColor("#ffa8a8a8");
      if ((Build.VERSION.SDK_INT >= 4) && (Build.VERSION.SDK_INT != 20)) {
        paramRichStatus = new SignatureActionSpan(paramRichStatus, 1, paramOnTopicClickListener, i1, localDrawable, paramInt);
      } else {
        paramRichStatus = new SignatureActionSpan(paramRichStatus, 0, paramOnTopicClickListener, i1, localDrawable, paramInt);
      }
      ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, 3, 17);
      return new QQText((CharSequence)localObject, 1);
    }
    return new QQText(localSpannableString, 1);
  }
  
  protected void a()
  {
    int i1 = q();
    int i2 = this.E;
    int[] arrayOfInt = N;
    this.B = arrayOfInt[9];
    int i3 = arrayOfInt[11];
    this.j = ((LinearLayout)LayoutInflater.from(this.v).inflate(2131627846, null, false));
    this.i.a(this.j, i1, i2, N[3]);
    this.q = this.i.findViewById(2131444968);
    this.t = this.i.findViewById(2131437431);
    this.r = this.i.findViewById(2131437577);
    this.s = this.i.findViewById(2131437578);
    this.k = this.i.findViewById(2131432003);
    this.l = ((SingleLineTextView)this.i.findViewById(2131448805));
    this.m = ((SingleLineTextView)this.i.findViewById(2131448571));
    this.o = ((ImageView)this.i.findViewById(2131436326));
    UIUtils.a(this.o, i3, i3, i3, i3);
    this.n = ((ImageView)this.i.findViewById(2131436660));
    UIUtils.a(this.n, i3, i3, i3, i3);
    this.p = ((ETTextView)this.i.findViewById(2131448752));
    this.p.setOnTextOrFontChangeListener(this);
    this.p.setMovementMethod(StateColorMovementMethod.a());
    this.p.setGravity(19);
    this.o.setOnTouchListener(UITools.a);
    this.n.setOnTouchListener(UITools.a);
    this.j.setOnTouchListener(UITools.a);
    this.p.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  public void a(ETTextView paramETTextView)
  {
    TopicUtil.a(paramETTextView, paramETTextView.getText(), 1);
  }
  
  public void a(ETTextView paramETTextView, CharSequence paramCharSequence)
  {
    TopicUtil.a(paramETTextView, paramCharSequence, 0);
  }
  
  public void a(ISignViewHolder.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.L = new WeakReference(paramOnClickListener);
      return;
    }
    this.L = null;
  }
  
  public void a(ITopic.OnTopicClickListener paramOnTopicClickListener)
  {
    if (paramOnTopicClickListener != null)
    {
      this.M = new WeakReference(paramOnTopicClickListener);
      return;
    }
    this.M = null;
  }
  
  protected void a(boolean paramBoolean) {}
  
  public boolean a(int paramInt)
  {
    double d1 = Color.red(paramInt);
    Double.isNaN(d1);
    double d2 = Color.green(paramInt);
    Double.isNaN(d2);
    double d3 = Color.blue(paramInt);
    Double.isNaN(d3);
    return 1.0D - (d1 * 0.299D + d2 * 0.587D + d3 * 0.114D) / 255.0D >= 0.5D;
  }
  
  public void b(boolean paramBoolean)
  {
    this.J = paramBoolean;
    BoxShadowLayout localBoxShadowLayout = this.i;
    if (localBoxShadowLayout != null) {
      localBoxShadowLayout.setScrolling(paramBoolean);
    }
    if ((this.j.getBackground() != null) && ((this.j.getBackground() instanceof VasResDrawable))) {
      ((VasResDrawable)this.j.getBackground()).a(paramBoolean);
    }
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected int c()
  {
    return -1;
  }
  
  protected void d()
  {
    j();
    k();
    l();
  }
  
  protected void e()
  {
    z();
    y();
  }
  
  protected void f()
  {
    int[] arrayOfInt = N;
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    int i3 = arrayOfInt[2];
    int i4 = arrayOfInt[3];
    this.i.setShadowColor(i4);
    this.j.setBackgroundResource(2130847784);
    this.j.setTag(2131446003, Integer.valueOf(-1));
    i();
    this.p.setTextColor(i1);
    this.p.setHintTextColor(i2);
    this.k.setBackgroundColor(i3);
    this.m.setTextColor(i3);
    this.l.setTextColor(i3);
    this.n.setImageResource(2130851756);
    this.o.setImageResource(2130847781);
    a(true);
  }
  
  protected SignatureTemplateInfo g()
  {
    if (this.w == null) {
      return null;
    }
    return SignatureManagerForTool.a().a(this.w.tplId);
  }
  
  public View h()
  {
    return this.i;
  }
  
  protected void i()
  {
    int[] arrayOfInt = N;
    int i1 = arrayOfInt[4];
    int i2 = arrayOfInt[5];
    int i3 = arrayOfInt[6];
    this.j.setPadding(i3, i1, i3, i2);
  }
  
  protected void j()
  {
    int i1 = this.w.tplId;
    boolean bool = true;
    if (i1 == 1)
    {
      this.j.setBackgroundResource(this.F);
      return;
    }
    if (this.D == null)
    {
      this.D = new VasResDrawable(this.z, this.w.tplId);
      SignatureAdapter localSignatureAdapter = new SignatureAdapter(this.D, this.z, this.F);
      this.D.a(localSignatureAdapter);
      if (c() != -1) {
        bool = false;
      }
      localSignatureAdapter.a(bool);
      this.D.a(this.a);
      this.D.a(N[8]);
    }
    this.j.setBackgroundDrawable(this.D);
    this.j.setTag(2131446003, Integer.valueOf(this.x.B));
    this.j.setTag(2131446006, Integer.valueOf(this.w.tplId));
    this.D.a(this.w.tplId);
    i();
  }
  
  protected void k()
  {
    int i1 = this.w.fontId;
    int i2 = this.w.fontType;
    if (i1 == 0)
    {
      this.p.setFont(i1, 0L);
      return;
    }
    Object localObject = this.C;
    if (localObject == null)
    {
      this.C = new VasRes(this.z, i1);
      localObject = new SignatureFontAdapter(this.C, this.z, i2);
      ((SignatureFontAdapter)localObject).a(this.p, this.B, TextUtils.isEmpty(this.w.toSpannableStringWithoutAction()) ^ true);
      this.C.a((VasResAdapter)localObject);
      ((SignatureFontAdapter)localObject).a(c());
    }
    else
    {
      ((SignatureFontAdapter)((VasRes)localObject).c()).a(this.p, this.B, TextUtils.isEmpty(this.w.toSpannableStringWithoutAction()) ^ true);
      ((SignatureFontAdapter)this.C.c()).a(i1, i2);
    }
    this.j.setTag(2131446004, Integer.valueOf(i1));
  }
  
  protected void l()
  {
    int[] arrayOfInt = N;
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    int i3 = arrayOfInt[2];
    int i4 = arrayOfInt[3];
    this.i.setShadowColor(i4);
    if (!TextUtils.isEmpty(this.x.j)) {
      i1 = Color.parseColor(this.x.j);
    }
    boolean bool = a(i1);
    this.p.setTextColor(i1);
    this.p.setHintTextColor(i2);
    if (bool)
    {
      this.m.setTextColor(i3);
      this.l.setTextColor(i3);
      this.k.setBackgroundColor(i3);
      this.n.setImageResource(2130851756);
      this.o.setImageResource(2130847781);
    }
    else
    {
      this.m.setTextColor(-1711276033);
      this.l.setTextColor(-1711276033);
      this.k.setBackgroundColor(-1711276033);
      this.n.setImageResource(2130851757);
      this.o.setImageResource(2130847782);
    }
    a(bool);
  }
  
  protected boolean m()
  {
    return true;
  }
  
  protected boolean n()
  {
    return true;
  }
  
  protected boolean o()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.L;
    if (localObject != null) {
      localObject = (ISignViewHolder.OnClickListener)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    int i1;
    switch (paramView.getId())
    {
    default: 
      i1 = 0;
      break;
    case 2131448752: 
      i1 = 2;
      break;
    case 2131446003: 
      i1 = 1;
      break;
    case 2131436660: 
      i1 = 4;
      break;
    case 2131436326: 
      i1 = 3;
    }
    QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick viewType=", Integer.valueOf(i1) });
    if ((i1 > 0) && (localObject != null)) {
      ((ISignViewHolder.OnClickListener)localObject).a(paramView, i1, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick topic=", paramITopic });
    Object localObject = this.M;
    if (localObject != null) {
      localObject = (ITopic.OnTopicClickListener)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((ITopic.OnTopicClickListener)localObject).onClick(paramITopic, paramView);
    }
  }
  
  public boolean onPreDraw()
  {
    s();
    this.p.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
  
  protected boolean p()
  {
    return false;
  }
  
  protected int q()
  {
    return N[10];
  }
  
  public View r()
  {
    return this.t;
  }
  
  protected void s()
  {
    if ((TextUtils.isEmpty(this.w.actionText)) && (this.w.actionId == 0))
    {
      if (this.w.fontId != 0) {
        return;
      }
      int i1 = this.p.getLineCount();
      int i2 = this.p.getGravity();
      if ((i1 <= 1) && ((i2 & 0x3) == 3)) {
        this.p.setGravity(17);
      }
      for (;;)
      {
        bool = true;
        break label102;
        if ((i1 <= 1) || ((i2 & 0x3) == 3)) {
          break;
        }
        this.p.setGravity(19);
      }
      boolean bool = false;
      label102:
      if (QLog.isColorLevel()) {
        QLog.i("BaseSignViewHolder", 2, String.format("resolveLineCountGravity line=%d set=%b", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool) }));
      }
    }
  }
  
  public void t()
  {
    Object localObject = this.n;
    boolean bool;
    if (this.y != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ImageView)localObject).setSelected(bool);
    if (AppSetting.e)
    {
      ImageView localImageView = this.n;
      if (this.y != 0) {
        localObject = this.v.getString(2131917979);
      } else {
        localObject = this.v.getString(2131917978);
      }
      localImageView.setContentDescription((CharSequence)localObject);
    }
  }
  
  public View u()
  {
    return this.j;
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseSignViewHolder", 2, "destroy");
    }
    this.K = true;
    ThreadManager.getUIHandlerV2().removeCallbacks(this.P);
    Object localObject = this.C;
    if ((localObject != null) && (((VasRes)localObject).c() != null)) {
      this.C.c().b();
    }
    localObject = this.D;
    if (localObject != null) {
      ((VasResDrawable)localObject).c();
    }
    SignatureManagerForTool.a().deleteObserver(this.O);
  }
  
  protected void w()
  {
    if (QLog.isColorLevel())
    {
      RichStatus localRichStatus = this.w;
      if (localRichStatus != null) {
        QLog.i("BaseSignViewHolder", 2, String.format("logRichStatus [tplId=%d fontId=%d fontType=%d] action[%d,%s] data[%d,%s] plainText=%s", new Object[] { Integer.valueOf(localRichStatus.tplId), Integer.valueOf(this.w.fontId), Integer.valueOf(this.w.fontType), Integer.valueOf(this.w.actionId), this.w.actionText, Integer.valueOf(this.w.dataId), this.w.dataText, this.w.getPlainText() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder
 * JD-Core Version:    0.7.0.1
 */