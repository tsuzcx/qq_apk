package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.profile.like.PraiseAnimation;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;

public class VoteView
  extends RelativeLayout
  implements PraiseManager.OnPraiseLoadListener
{
  public RelativeLayout a;
  public ImageView b;
  public SingleLineTextView c;
  public FrameLayout d;
  public TextView e;
  public int f;
  public int g;
  public boolean h;
  HeartLayout i;
  FloatViewBuilder j;
  public QQAppInterface k;
  PraiseAnimation l = new PraiseAnimation();
  private double m;
  private boolean n;
  private boolean o;
  private boolean p = false;
  
  public VoteView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.n = false;
    this.o = false;
    this.f = 0;
    this.g = 0;
    Object localObject1 = getResources();
    this.m = ((Resources)localObject1).getDisplayMetrics().density;
    this.a = new RelativeLayout(getContext());
    this.a.setId(2131436660);
    this.a.setBackgroundResource(2130847551);
    RelativeLayout localRelativeLayout = this.a;
    double d1 = this.m;
    localRelativeLayout.setPadding((int)(d1 * 8.0D), (int)(d1 * 3.0D), (int)(8.0D * d1), (int)(d1 * 3.0D));
    Object localObject2 = new RelativeLayout.LayoutParams(-2, (int)(this.m * 24.0D));
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(this.m * 6.0D));
    localRelativeLayout = new RelativeLayout(getContext());
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131627747, null);
    localViewGroup.setId(2131436857);
    addView(localViewGroup, new RelativeLayout.LayoutParams(-2, -2));
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-2, -2));
    localRelativeLayout.addView(this.a, (ViewGroup.LayoutParams)localObject2);
    VoteRotateAnimation.a();
    this.b = new ImageView(getContext());
    this.b.setId(2131440579);
    localObject2 = ((Resources)localObject1).getDrawable(2130852158);
    this.b.setImageDrawable((Drawable)localObject2);
    int i1;
    if (localObject2 == null) {
      i1 = (int)(this.m * 18.0D);
    } else {
      i1 = ((Drawable)localObject2).getIntrinsicWidth();
    }
    int i2;
    if (localObject2 == null) {
      i2 = (int)(this.m * 18.0D);
    } else {
      i2 = ((Drawable)localObject2).getIntrinsicHeight();
    }
    localObject2 = new RelativeLayout.LayoutParams(i1, i2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(this.m * 3.0D));
    this.a.addView(this.b, (ViewGroup.LayoutParams)localObject2);
    this.c = new SingleLineTextView(getContext());
    this.c.setId(2131437182);
    this.c.setTextColor(-1);
    this.c.setTextSize(13.0F);
    localObject2 = new RelativeLayout.LayoutParams(-2, (int)(this.m * 24.0D));
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131440579);
    this.a.addView(this.c, (ViewGroup.LayoutParams)localObject2);
    this.d = new FrameLayout(getContext());
    this.d.setId(2131436549);
    this.d.setBackgroundResource(2130852599);
    this.d.setMinimumHeight((int)(this.m * 6.0D));
    this.d.setMinimumWidth((int)(this.m * 6.0D));
    this.d.setContentDescription(((Resources)localObject1).getString(2131888097));
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131436660);
    localRelativeLayout.addView(this.d, (ViewGroup.LayoutParams)localObject1);
    this.e = new TextView(getContext());
    this.e.setId(2131439266);
    this.e.setTextSize(1, 11.0F);
    this.e.setTextColor(-1);
    this.d.addView(this.e, -2, -2);
  }
  
  public void a()
  {
    if (SimpleUIUtil.e())
    {
      QLog.i("PraiseManager", 1, "showPatternVote, SimpleUIMode is open now");
      return;
    }
    this.l.f = false;
    if (!this.p)
    {
      VoteRotateAnimation.a();
      VasWebviewUtil.a(null, "thumbup", "others_pageview", null, 1, 0, 0, null, "1", null);
    }
    this.p = true;
    postDelayed(new VoteView.1(this), 3000L);
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      return;
    }
    if ((paramInt1 == PraiseManager.a(this.k)) && (paramPraiseInfo != null) && (!this.o))
    {
      a(paramPraiseInfo);
      paramPraiseInfo = (Pair)this.l.h.get(paramInt1);
      if (paramPraiseInfo != null)
      {
        this.l.a(this.k, this.i, this.j.b(), this, paramInt1, false, 0, ((Point)paramPraiseInfo.first).x, ((Point)paramPraiseInfo.first).y);
        this.l.h.remove(paramInt1);
      }
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo)
  {
    if (SimpleUIUtil.e())
    {
      QLog.i("PraiseManager", 1, "startPraiseAnim, SimpleUIMode is open now");
      return;
    }
    if ((!this.o) && (paramPraiseInfo != null) && (!this.l.f))
    {
      PraiseAnimation localPraiseAnimation = this.l;
      localPraiseAnimation.c = this.b;
      localPraiseAnimation.e = new BitmapDrawable(getResources(), paramPraiseInfo.f);
      this.l.a(this.n, false, this.b.getDrawable(), getResources());
      this.b.startAnimation(PraiseAnimation.a(this.l, 1.0F, 0.3F));
      this.l.f = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() == 0) {
        return;
      }
      int i1 = 0;
      if (paramBoolean)
      {
        localObject = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
        if (localObject != null) {
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        }
        localObject = localLayoutParams;
        if (localLayoutParams == null) {
          localObject = new RelativeLayout.LayoutParams(this.d.getContext(), null);
        }
        double d1 = this.m;
        ((RelativeLayout.LayoutParams)localObject).width = ((int)(d1 * 6.0D + 0.5D));
        ((RelativeLayout.LayoutParams)localObject).height = ((int)(6.0D * d1 + 0.5D));
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(3.0D % d1 + 0.5D));
        this.d.setBackgroundResource(2130852589);
        this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.d;
      if (!paramBoolean) {
        i1 = 4;
      }
      ((FrameLayout)localObject).setVisibility(i1);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    boolean bool = this.o;
    int i2 = 4;
    Object localObject2;
    Object localObject1;
    if ((bool) && (this.g > 0))
    {
      Object localObject3 = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      int i3;
      int i1;
      if (paramBoolean)
      {
        i3 = 2130852589;
        if (localLayoutParams != null) {
          localLayoutParams.topMargin = 0;
        }
        localObject2 = String.valueOf(this.f);
        i1 = i3;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          double d1 = this.m;
          ((RelativeLayout.LayoutParams)localObject3).width = ((int)(d1 * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).height = ((int)(6.0D * d1 + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(3.0D % d1 + 0.5D));
          i1 = i3;
          localObject1 = localObject2;
        }
      }
      else
      {
        i3 = 2130852592;
        if (localLayoutParams != null) {
          localLayoutParams.topMargin = ((int)(this.m * 15.0D + 0.5D));
        }
        localObject2 = String.valueOf(this.f - this.g);
        i1 = i3;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          ((RelativeLayout.LayoutParams)localObject3).width = -2;
          ((RelativeLayout.LayoutParams)localObject3).height = -2;
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
          localObject1 = localObject2;
          i1 = i3;
        }
      }
      this.d.setBackgroundResource(i1);
      if (localObject3 != null) {
        this.d.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      this.d.setVisibility(paramInt);
      localObject3 = this.e;
      if (paramBoolean)
      {
        localObject2 = "";
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("+");
        ((StringBuilder)localObject2).append(this.g);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      ((TextView)localObject3).setText((CharSequence)localObject2);
      localObject2 = this.e;
      if (paramBoolean) {
        paramInt = i2;
      } else {
        paramInt = 0;
      }
      ((TextView)localObject2).setVisibility(paramInt);
    }
    else
    {
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      localObject2 = String.valueOf(this.f);
      if (this.o)
      {
        localObject1 = localObject2;
        if (this.h) {}
      }
      else
      {
        this.d.setVisibility(4);
        localObject1 = localObject2;
      }
    }
    this.c.setText(localObject1);
    this.a.setLayoutParams(localLayoutParams);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3)
  {
    this.o = paramBoolean1;
    this.n = paramBoolean2;
    if (paramInt1 <= 0) {
      paramInt1 = 0;
    }
    this.f = paramInt1;
    paramInt1 = this.f;
    if (paramInt2 > paramInt1) {
      this.g = (paramInt1 % 20);
    } else if (paramInt2 < 0) {
      this.g = 0;
    } else {
      this.g = paramInt2;
    }
    Object localObject;
    if ((!this.o) && (this.n)) {
      localObject = super.getResources().getDrawable(2130852161);
    } else {
      localObject = super.getResources().getDrawable(2130852158);
    }
    if (this.l.f) {
      this.l.a(this.n, false, (Drawable)localObject, getResources());
    } else {
      this.b.setImageDrawable((Drawable)localObject);
    }
    if ((!paramBoolean1) && (!this.l.f) && (!paramBoolean3) && (!this.p))
    {
      paramInt1 = PraiseManager.a(this.k);
      if (paramInt1 > 0)
      {
        localObject = (PraiseManager)this.k.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
        ((PraiseManager)localObject).a(this);
        a(((PraiseManager)localObject).a(paramInt1, true, "from_profile_card"));
      }
    }
    setContentDescription(String.format(getContext().getString(2131888113), new Object[] { String.valueOf(this.f) }));
    if (!this.o)
    {
      a(false, 4);
      if ((paramBoolean3) && (this.i != null))
      {
        paramNewVoteAnimHelper = new int[2];
        this.a.getLocationInWindow(paramNewVoteAnimHelper);
        if (this.j == null) {
          this.j = new FloatViewBuilder(getContext(), 2130847550);
        }
        double d1 = paramNewVoteAnimHelper[0];
        double d2 = this.b.getWidth() + this.a.getPaddingLeft();
        Double.isNaN(d2);
        Double.isNaN(d1);
        float f1 = (float)(d1 + d2 * 0.5D);
        float f2 = paramNewVoteAnimHelper[1];
        paramInt1 = PraiseManager.a(this.k);
        if (paramInt1 > 0)
        {
          this.l.a(this.k, this.i, this.j.b(), this, paramInt1, true, 0, f1, f2);
          return;
        }
        this.i.a(this.j.b(), f1, f2);
      }
    }
    else
    {
      if (paramNewVoteAnimHelper != null)
      {
        paramNewVoteAnimHelper.a(this.f, this.g, this.d, this.e, this.c, this.a, this.i);
        a(this.h);
        return;
      }
      a(true, 0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    HeartLayout localHeartLayout = this.i;
    if (localHeartLayout != null) {
      localHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    QQAppInterface localQQAppInterface = this.k;
    if (localQQAppInterface != null) {
      ((PraiseManager)localQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).b(this);
    }
    this.p = false;
    super.onDetachedFromWindow();
  }
  
  public void setHeartLayout(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout)
  {
    this.k = paramQQAppInterface;
    this.i = paramHeartLayout;
    FloatViewBuilder.a(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteView
 * JD-Core Version:    0.7.0.1
 */