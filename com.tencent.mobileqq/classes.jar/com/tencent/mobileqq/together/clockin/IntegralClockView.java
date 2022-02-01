package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Observable;
import java.util.Observer;

public class IntegralClockView
  extends ClockView
  implements Observer
{
  private Context a;
  private RelativeLayout b;
  private DiniFlyAnimationView c;
  private ClockInData d;
  
  public IntegralClockView(DiniFlyAnimationView paramDiniFlyAnimationView, RelativeLayout paramRelativeLayout, Context paramContext, ClockAnimController paramClockAnimController, ClockInData paramClockInData)
  {
    super(paramClockAnimController);
    if (paramClockAnimController != null) {
      paramClockAnimController.addObserver(this);
    }
    this.a = paramContext;
    this.b = paramRelativeLayout;
    this.d = paramClockInData;
    this.c = paramDiniFlyAnimationView;
    paramDiniFlyAnimationView = this.c;
    if (paramDiniFlyAnimationView != null)
    {
      paramDiniFlyAnimationView.setVisibility(8);
      this.c.addAnimatorListener(new IntegralClockView.1(this));
      paramDiniFlyAnimationView = this.d;
      if ((paramDiniFlyAnimationView != null) && (!TextUtils.isEmpty(paramDiniFlyAnimationView.p))) {
        this.c.setAnimationFromUrl(this.d.p);
      }
    }
  }
  
  private void b()
  {
    if ((this.b != null) && (this.c != null) && (this.a != null))
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((ClockInData)localObject).p)) {
          return;
        }
        int i = ScreenUtil.getInstantScreenHeight(this.a);
        localObject = new int[2];
        this.b.getLocationOnScreen((int[])localObject);
        int j = localObject[1];
        int k = this.b.getHeight();
        localObject = (FrameLayout.LayoutParams)this.c.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = (i - j - k - ViewUtils.dpToPx(30.0F));
        if (((FrameLayout.LayoutParams)localObject).bottomMargin + ViewUtils.dpToPx(170.0F) > i) {
          ((FrameLayout.LayoutParams)localObject).bottomMargin = (i - ViewUtils.dpToPx(170.0F) + ViewUtils.dpToPx(30.0F));
        }
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.c.setVisibility(0);
        this.c.setAnimationFromUrl(this.d.p);
        this.c.loop(false);
        this.c.playAnimation();
      }
    }
  }
  
  public void a()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.c;
    if (localDiniFlyAnimationView != null)
    {
      localDiniFlyAnimationView.removeAllAnimatorListener();
      if (this.c.isAnimating()) {
        this.c.endAnimation();
      }
      this.c = null;
    }
  }
  
  public void b(int paramInt)
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.c;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.setVisibility(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return;
    }
    if (((Integer)paramObject).intValue() == 4) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.IntegralClockView
 * JD-Core Version:    0.7.0.1
 */