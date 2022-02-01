package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.qqgift.utils.PagLoader;
import com.tencent.qphone.base.util.QLog;
import org.libpag.PAGView;

public class HitNumberView
  extends FrameLayout
{
  protected BannerResManager a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private View f;
  private PAGView g;
  private int h = 0;
  private int i = 0;
  private boolean j = false;
  private NumberScaleAnimation k;
  private HitNumberListener l;
  private int m = -1;
  private int n = 0;
  
  public HitNumberView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HitNumberView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HitNumberView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131627977, this, true);
    d();
  }
  
  private int[] b(int paramInt)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = -1;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = -1;
    int[] tmp13_9 = tmp9_5;
    tmp13_9[2] = -1;
    tmp13_9;
    int i1 = paramInt / 100;
    if (i1 > 0)
    {
      arrayOfInt[0] = i1;
      arrayOfInt[1] = (paramInt % 100 / 10);
      arrayOfInt[2] = (paramInt % 10);
      return arrayOfInt;
    }
    i1 = paramInt / 10;
    if (i1 > 0)
    {
      arrayOfInt[0] = i1;
      arrayOfInt[1] = (paramInt % 10);
      return arrayOfInt;
    }
    arrayOfInt[0] = paramInt;
    return arrayOfInt;
  }
  
  private int c(int paramInt)
  {
    if (paramInt < 10) {
      return 1;
    }
    if (paramInt < 50) {
      return 2;
    }
    if (paramInt < 100) {
      return 3;
    }
    return 4;
  }
  
  private void c()
  {
    if ((this.g == null) && (QQGiftPAGAnimationViewImpl.a.a()))
    {
      this.g = new PAGView(getContext());
      Object localObject = this.f.getParent();
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        ((ViewGroup)localObject).addView(this.g, ((ViewGroup)localObject).indexOfChild(this.f), this.f.getLayoutParams());
        ((ViewGroup)localObject).removeView(this.f);
      }
    }
  }
  
  private void d()
  {
    this.b = ((ImageView)findViewById(2131446693));
    this.c = ((ImageView)findViewById(2131439496));
    this.d = ((ImageView)findViewById(2131439497));
    this.e = ((ImageView)findViewById(2131439498));
    this.f = findViewById(2131429607);
    this.k = new NumberScaleAnimation(this, 1.0F, 0.77F);
    this.k.a(new HitNumberView.1(this));
    c();
  }
  
  private void e()
  {
    if (!QQGiftPAGAnimationViewImpl.a.a())
    {
      QLog.e("Gift_Banner_HitNumberView", 1, "playBoom but pag is not load");
      return;
    }
    c();
    this.g.setProgress(0.1400000005960465D);
    this.g.play();
  }
  
  private void f()
  {
    if (!QQGiftPAGAnimationViewImpl.a.a())
    {
      QLog.e("Gift_Banner_HitNumberView", 1, "updateBoomFile but pag is not load");
      return;
    }
    c();
    this.g.setComposition(this.a.e(this.m));
  }
  
  private void g()
  {
    if (!QQGiftPAGAnimationViewImpl.a.a())
    {
      QLog.e("Gift_Banner_HitNumberView", 1, "stopBoom but pag is not load");
      return;
    }
    c();
    if (this.g.isPlaying()) {
      this.g.stop();
    }
  }
  
  public void a()
  {
    this.n = 0;
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toNum ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" isPlaying is ");
    ((StringBuilder)localObject).append(this.j);
    QLog.i("Gift_Banner_HitNumberView", 1, ((StringBuilder)localObject).toString());
    int i1 = this.h;
    if (i1 > paramInt) {
      return;
    }
    this.i = paramInt;
    if (!this.j)
    {
      this.j = true;
      if (i1 == this.n) {
        setNum(i1 + 1);
      }
      this.k.a();
      e();
      localObject = this.l;
      if (localObject != null) {
        ((HitNumberListener)localObject).d();
      }
    }
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop curNum ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" isPlaying is ");
    localStringBuilder.append(this.j);
    QLog.i("Gift_Banner_HitNumberView", 1, localStringBuilder.toString());
    this.m = -1;
    this.j = false;
    this.k.b();
    g();
    a();
  }
  
  public int getNum()
  {
    return this.h;
  }
  
  public void setListener(HitNumberListener paramHitNumberListener)
  {
    this.l = paramHitNumberListener;
  }
  
  public void setNum(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNum ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Gift_Banner_HitNumberView", 1, ((StringBuilder)localObject).toString());
    }
    this.h = paramInt;
    int i1 = c(paramInt);
    if (this.m != i1)
    {
      this.m = i1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("level change ");
      ((StringBuilder)localObject).append(i1);
      QLog.i("Gift_Banner_HitNumberView", 1, ((StringBuilder)localObject).toString());
      localObject = this.l;
      if (localObject != null) {
        ((HitNumberListener)localObject).c(i1);
      }
      f();
    }
    Object localObject = b(paramInt);
    this.b.setImageBitmap(this.a.c(i1));
    this.c.setImageBitmap(this.a.a(i1, localObject[0]));
    if (localObject[1] >= 0)
    {
      this.d.setVisibility(0);
      this.d.setImageBitmap(this.a.a(i1, localObject[1]));
    }
    else
    {
      this.d.setVisibility(8);
    }
    if (localObject[2] >= 0)
    {
      this.e.setVisibility(0);
      this.e.setImageBitmap(this.a.a(i1, localObject[2]));
      return;
    }
    this.e.setVisibility(8);
  }
  
  public void setResManager(BannerResManager paramBannerResManager)
  {
    this.a = paramBannerResManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.HitNumberView
 * JD-Core Version:    0.7.0.1
 */