package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragCallBack;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Iterator;

class SwipeUpAndDragListener$DragHandler
  extends SwipeUpAndDragListener.GestureHandler
{
  private DiniFlyAnimationView H;
  private LottieDrawable I;
  private ImageView J;
  private TextView K;
  private RelativeLayout.LayoutParams L;
  RelativeLayout.LayoutParams a;
  TextView b;
  RelativeLayout.LayoutParams c;
  int[] d;
  int e;
  RelativeLayout f;
  RelativeLayout.LayoutParams g;
  QQBlurView h;
  int i = 0;
  int j;
  int k;
  int l;
  int m;
  ColorDrawable n;
  
  public SwipeUpAndDragListener$DragHandler(SwipeUpAndDragListener paramSwipeUpAndDragListener, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramSwipeUpAndDragListener, paramContext, paramViewGroup);
    a(0);
    this.A = new RelativeLayout(paramContext);
    this.a = new RelativeLayout.LayoutParams(-2, -2);
    if (Build.VERSION.SDK_INT >= 21) {
      this.A.setElevation(50.0F);
    }
    this.d = new int[2];
    this.n = new ColorDrawable();
  }
  
  private void e()
  {
    if (this.h == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.h = new QQBlurView(this.p);
      this.h.a(this.o.z.r());
      QQBlurView localQQBlurView = this.h;
      localQQBlurView.b(localQQBlurView);
      this.h.b(0);
      this.h.a(8.0F);
      this.h.a(8);
      this.f.addView(this.h, localLayoutParams);
      this.h.d();
    }
  }
  
  private void f()
  {
    if (this.I == null)
    {
      LottieComposition.Factory.fromAssetFileName(this.p, "lottie/photo_list_panel_drag.json", new SwipeUpAndDragListener.DragHandler.2(this));
      return;
    }
    g();
  }
  
  private void g()
  {
    Object localObject = this.K;
    if (localObject != null)
    {
      ((TextView)localObject).setAlpha(1.0F);
      this.K.setText(2131892566);
    }
    localObject = this.H;
    if (localObject != null) {
      ((DiniFlyAnimationView)localObject).setVisibility(0);
    }
    localObject = this.I;
    if (localObject != null) {
      ((LottieDrawable)localObject).start();
    }
  }
  
  private void h()
  {
    LottieDrawable localLottieDrawable = this.I;
    if (localLottieDrawable != null)
    {
      localLottieDrawable.stop();
      this.H.setVisibility(4);
    }
  }
  
  private void i()
  {
    ImageView localImageView = this.J;
    if (localImageView != null)
    {
      localImageView.setScaleX(this.o.y);
      this.J.setScaleY(this.o.y);
      this.J.setAlpha(this.o.y);
      this.J.setVisibility(0);
      this.K.setAlpha(this.o.y);
      this.K.setText(2131892565);
      this.J.setVisibility(0);
    }
  }
  
  private void j()
  {
    ImageView localImageView = this.J;
    if (localImageView != null) {
      localImageView.setVisibility(4);
    }
  }
  
  public void a()
  {
    this.f = new RelativeLayout(this.p);
    this.f.setBackgroundColor(this.p.getResources().getColor(2131168376));
    e();
    this.H = new DiniFlyAnimationView(this.p);
    this.J = new ImageView(this.p);
    this.J.setId(View.generateViewId());
    this.J.setImageResource(2130842446);
    this.K = new TextView(this.p);
    this.K.setTextSize(17.0F);
    this.K.setTextColor(-1);
    this.K.setTypeface(Typeface.defaultFromStyle(1));
    this.L = new RelativeLayout.LayoutParams(-2, -2);
    this.L.topMargin = ((int)(this.o.u * 9.0F));
    this.L.addRule(3, this.J.getId());
    this.L.addRule(15);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(60.0F, this.p.getResources()), AIOUtils.b(60.0F, this.p.getResources()));
    localLayoutParams.addRule(13);
    this.H.setTranslationY(AIOUtils.b(1.0F, this.p.getResources()));
    this.f.addView(this.H, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(44.0F, this.p.getResources()), AIOUtils.b(44.0F, this.p.getResources()));
    localLayoutParams.addRule(13);
    this.f.addView(this.J, localLayoutParams);
    this.L = new RelativeLayout.LayoutParams(-2, -2);
    this.L.topMargin = ((int)(this.o.u * 18.0F));
    this.L.addRule(3, this.J.getId());
    this.L.addRule(14);
    this.f.addView(this.K, this.L);
    this.j = 3;
    this.k = 8;
    this.l = 26;
    this.m = 0;
  }
  
  public void a(int paramInt)
  {
    if (SwipeUpAndDragListener.a == 1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt == 4)
              {
                this.h.b();
                this.f.setVisibility(8);
                a(true);
                h();
                j();
                this.q.removeView(this.f);
              }
            }
            else
            {
              this.n.setColor(Color.rgb(30, 186, 252));
              this.n.setAlpha(128);
              this.h.a(this.n);
              if (this.i != 3)
              {
                f();
                j();
              }
              this.f.setVisibility(0);
              this.h.a();
            }
          }
          else
          {
            if (this.o.y < 0.8F)
            {
              this.m = ((int)(this.o.y * 128.0F / 0.8F));
              this.j = 3;
              this.k = 8;
              this.l = 26;
            }
            else
            {
              this.m = 128;
              float f1 = (this.o.y - 0.8F) / 0.2F;
              this.j = ((int)(27.0F * f1 + 3.0F));
              this.k = ((int)(178.0F * f1 + 8.0F));
              this.l = ((int)(f1 * 226.0F + 26.0F));
            }
            this.n.setColor(Color.rgb(this.j, this.k, this.l));
            this.n.setAlpha(this.m);
            this.h.a(this.n);
            i();
            if (this.i == 3)
            {
              h();
              this.J.setVisibility(0);
            }
            this.f.setVisibility(0);
            this.h.a();
          }
        }
        else
        {
          int[] arrayOfInt = new int[2];
          this.o.z.r().getLocationOnScreen(arrayOfInt);
          int i1 = arrayOfInt[1];
          this.o.z.p().d().e().a().getLocationOnScreen(arrayOfInt);
          int i2 = this.o.z.v();
          this.g = new RelativeLayout.LayoutParams(-1, arrayOfInt[1] - i1 - this.o.z.v());
          this.g.topMargin = i2;
          this.f.setVisibility(8);
          if (this.f.getParent() != null) {
            this.q.removeView(this.f);
          }
          this.q.addView(this.f, this.g);
          a(false);
        }
      }
      else {
        a();
      }
    }
    else if (SwipeUpAndDragListener.a == 0) {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt == 4) {
                this.b.setVisibility(4);
              }
            }
            else {
              this.b.setVisibility(0);
            }
          }
          else {
            this.b.setVisibility(4);
          }
        }
        else
        {
          if (this.b.getParent() != null) {
            return;
          }
          this.A.addView(this.b, this.c);
          this.b.setVisibility(4);
        }
      }
      else
      {
        this.b = new TextView(this.p);
        this.b.setText(HardCodeUtil.a(2131905928));
        if (Build.VERSION.SDK_INT >= 21) {
          this.b.setElevation(10.0F);
        }
        this.b.setTextSize(10.0F);
        this.b.setTextColor(-1);
        this.b.setBackgroundResource(2130838194);
        this.b.setTypeface(Typeface.defaultFromStyle(1));
        this.c = new RelativeLayout.LayoutParams(-2, -2);
        this.c.topMargin = ((int)(this.o.u * 6.0F));
        this.c.addRule(14);
      }
    }
    this.i = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    IApolloAIOHelper localIApolloAIOHelper = (IApolloAIOHelper)this.o.z.a(8);
    if (localIApolloAIOHelper != null) {
      localIApolloAIOHelper.showApolloView(paramBoolean);
    }
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    float f2 = this.o.m;
    paramMotionEvent = (RelativeLayout.LayoutParams)this.A.getLayoutParams();
    paramMotionEvent.topMargin = ((int)(paramMotionEvent.topMargin + (f1 - f2)));
    this.e = (this.r[1] + this.o.h + paramMotionEvent.topMargin);
    this.A.setLayoutParams(paramMotionEvent);
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("drag hanldeMove, contentParent = ");
    paramMotionEvent.append(this.A.getParent());
    Logger.a("PhotoListPanel", "DragHandler", paramMotionEvent.toString());
    paramMotionEvent = this.o;
    paramMotionEvent.m = f1;
    f1 -= paramMotionEvent.k;
    paramMotionEvent = this.o;
    paramMotionEvent.y = (-f1 / paramMotionEvent.x);
    if (this.o.y > 1.0F) {
      this.o.y = 1.0F;
    } else if (this.o.y < 0.0F) {
      this.o.y = 0.0F;
    }
    if (-(int)f1 > (int)this.o.x) {
      a(3);
    } else {
      a(2);
    }
    this.A.invalidate();
    return true;
  }
  
  boolean a(PhotoListPanel.PhotoPanelAdapter.RecyclerHolder paramRecyclerHolder, int paramInt)
  {
    super.a(paramRecyclerHolder, paramInt);
    a(1);
    paramInt = paramRecyclerHolder.itemView.getWidth() - (int)(this.o.u * 2.0F + 0.5F);
    int i1 = paramRecyclerHolder.itemView.getHeight() - (int)(this.o.u * 2.0F + 0.5F) * 2;
    this.a.leftMargin = (this.x[0] + (int)(this.o.u * 2.0F + 0.5F));
    this.a.topMargin = (this.x[1] - this.r[1] - this.o.h + (int)(this.o.u * 2.0F + 0.5F));
    this.o.x = (i1 * 3 / 5);
    paramRecyclerHolder = (ViewGroup)this.B.getParent();
    if (paramRecyclerHolder != null)
    {
      this.B.clearAnimation();
      paramRecyclerHolder.removeView(this.B);
    }
    this.A.addView(this.B, new RelativeLayout.LayoutParams(paramInt, i1));
    this.v = new RelativeLayout.LayoutParams(paramInt, i1);
    this.v.leftMargin = this.a.leftMargin;
    this.v.topMargin = this.a.topMargin;
    if (this.s.getParent() != null)
    {
      this.s.removeAllViews();
      ((ViewGroup)this.s.getParent()).removeView(this.s);
    }
    this.q.addView(this.s, this.t);
    this.w.itemView.startAnimation(this.z);
    this.s.addView(this.u, this.v);
    this.s.addView(this.A, this.a);
    this.A.invalidate();
    paramRecyclerHolder = new StringBuilder();
    paramRecyclerHolder.append("drag prepare, contentParent = ");
    paramRecyclerHolder.append(this.A.getParent());
    Logger.a("PhotoListPanel", "DragHandler", paramRecyclerHolder.toString());
    return true;
  }
  
  AnimationSet b()
  {
    float f1 = this.o.a(this.y, this.A.getWidth(), this.A.getHeight());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("d scale = ");
    ((StringBuilder)localObject1).append(f1);
    Logger.a("PhotoListPanel", "createDragReleaseSendAnim", ((StringBuilder)localObject1).toString());
    this.A.getLocationInWindow(this.d);
    int i3 = this.o.g[0];
    int i4 = (int)(this.o.u * 65.0F + 0.5F + this.A.getWidth() * f1 + 0.5F);
    int i5 = this.d[0];
    int i2 = this.q.getHeight() + this.o.g[1] - this.o.i.getHeight() - (int)(this.o.u * 13.0F + 0.5F + this.A.getHeight() * f1 + 0.5F) - this.e;
    int i1 = i2;
    if (this.o.i.f.getItemViewType(this.y) == 1) {
      i1 = i2 - (int)(this.o.u * 70.0F + 0.5F);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" deltY = ");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append(", flyStartLocation[1] = ");
    ((StringBuilder)localObject1).append(this.d[1]);
    ((StringBuilder)localObject1).append(",inputBarRightTopCorner[1] = ");
    ((StringBuilder)localObject1).append(this.o.g[1]);
    ((StringBuilder)localObject1).append(",top = ");
    ((StringBuilder)localObject1).append(this.A.getTop());
    Logger.a("PhotoListPanel", "createDragReleaseSendAnim", ((StringBuilder)localObject1).toString());
    localObject1 = new AnimationSet(false);
    Object localObject2 = new ScaleAnimation(1.0F, f1, 1.0F, f1);
    ((ScaleAnimation)localObject2).setStartOffset(0L);
    ((ScaleAnimation)localObject2).setDuration(500L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new AnimationSet(false);
    ((AnimationSet)localObject2).setStartOffset(0L);
    ((AnimationSet)localObject2).setDuration(500L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, i3 - i4 - i5, 0.0F, 0.0F);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
    localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i1);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject2).setStartOffset(400L);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).setFillAfter(false);
    return localObject1;
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handler = ");
    ((StringBuilder)localObject1).append(this);
    Logger.a("PhotoListPanel", "handleUp", ((StringBuilder)localObject1).toString());
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = this.i;
    boolean bool = false;
    if (i1 != 3)
    {
      a(4);
      if ((SystemClock.elapsedRealtime() - this.o.p < 200L) && (Math.abs(f2 - this.o.k) < this.o.q) && (Math.abs(f1 - this.o.j) < this.o.q))
      {
        c();
        return false;
      }
      this.A.getLocationInWindow(this.d);
      this.w.itemView.getLocationInWindow(this.x);
      paramMotionEvent = new TranslateAnimation(0.0F, 0.0F, 0.0F, (int)(this.o.u * 2.0F + 0.5F) + this.x[1] - this.d[1]);
      paramMotionEvent.setFillAfter(true);
      paramMotionEvent.setDuration(200L);
      this.o.i.e = true;
      this.A.startAnimation(paramMotionEvent);
      paramMotionEvent.setAnimationListener(this.C);
      return true;
    }
    a(4);
    Logger.a("PhotoListPanel", "DragHandler", "@#handleUp, createFlyAnimation ");
    paramMotionEvent = b();
    this.o.i.e = true;
    Logger.a("PhotoListPanel", "DragHandler", "@#handleUp, startFlyAnimation ");
    this.A.startAnimation(paramMotionEvent);
    i1 = this.o.i.f.getItemViewType(this.y);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(this.o.i.f.a(this.y).path);
    ReportController.b(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", this.y + 1, 0, "1", "", "", "");
    int i2 = PhotoUtils.getTypeforReport2(this.o.i.l);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.y + 1);
    ReportController.b(null, "dc00898", "", "", "0X800A914", "0X800A914", i2, 0, ((StringBuilder)localObject2).toString(), "", "", "");
    if (this.o.w != null)
    {
      localObject1 = this.o.w;
      localObject2 = this.o.i.f.a(this.y).path;
      if (this.o.i.c == 2) {
        bool = true;
      }
      ((PhotoListPanel.SwipeUpAndDragCallBack)localObject1).a((String)localObject2, bool);
    }
    else
    {
      localObject2 = this.o.i.l;
      if (QFileAssistantUtils.a(((SessionInfo)localObject2).b))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.o.i.i.getFileManagerEngine().a((String)localObject3, ((SessionInfo)localObject2).b, ((SessionInfo)localObject2).b, ((SessionInfo)localObject2).a, true);
        }
      }
      localObject2 = this.o.i;
      i2 = this.y;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append("");
      ((PhotoListPanel)localObject2).a(i2, (ArrayList)localObject1, false, true, "0X8005E0D", "0", ((StringBuilder)localObject3).toString(), false);
    }
    paramMotionEvent.setAnimationListener(new SwipeUpAndDragListener.DragHandler.1(this, f2));
    return true;
  }
  
  boolean c(MotionEvent paramMotionEvent)
  {
    a(4);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.DragHandler
 * JD-Core Version:    0.7.0.1
 */