package com.tencent.mobileqq.popanim.state;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

public class BlurMaskState
  extends BaseState
{
  private static int d = 100;
  private int e = ImmersiveUtils.getStatusBarHeight(this.a);
  private URLImageView f = (URLImageView)this.b.findViewById(2131440512);
  private QQBlurView g = (QQBlurView)this.b.findViewById(2131429598);
  private LinearLayout h = (LinearLayout)this.b.findViewById(2131447749);
  private DiniFlyAnimationView i = (DiniFlyAnimationView)this.h.findViewById(2131446324);
  private TextView j = (TextView)this.h.findViewById(2131445609);
  private boolean k;
  
  public BlurMaskState(ViewGroup paramViewGroup, StateContext paramStateContext)
  {
    super(paramViewGroup, paramStateContext);
  }
  
  public void a(BaseState paramBaseState)
  {
    QLog.d("BlurMaskState", 1, new Object[] { "mHasEverUpperAIO: ", Boolean.valueOf(this.c.h) });
    this.c.h = false;
    float f1 = this.a.getResources().getDisplayMetrics().density;
    paramBaseState = this.c.b.getBigDrawable(this.a, f1);
    if (paramBaseState == null) {
      return;
    }
    paramBaseState.setCallback(this.f);
    this.f.setImageDrawable(paramBaseState);
    int m = PopOutEmoticonUtil.a(this.c.f, this.e);
    PopOutAnimViewHelper.a(this.g, this.c.d, m);
    this.h.getLayoutParams().height = m;
    PopOutAnimViewHelper.a(0, new View[] { this.g, this.h });
    if (this.c.b())
    {
      this.j.setText(2131902136);
      PopOutAnimViewHelper.a(8, new View[] { this.i });
    }
    else
    {
      this.j.setText(2131902137);
      PopOutAnimViewHelper.a(0, new View[] { this.i });
    }
    if (this.b.getParent() == null)
    {
      this.b.setVisibility(0);
      paramBaseState = new RelativeLayout.LayoutParams(-1, -2);
      paramBaseState.topMargin = ImmersiveUtils.getStatusBarHeight(this.a);
      this.c.d.addView(this.b, paramBaseState);
    }
    paramBaseState = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.c.k = (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(paramBaseState) ^ true);
    if (this.c.k) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(paramBaseState, "StickerBubble", true);
    }
    PopOutAnimViewHelper.a("0X800BBA0", this.c.b);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.k)
    {
      this.k = true;
      this.c.g.hidePopupWindow();
      this.c.g.showStickerMaskOnPanel();
      this.f.setVisibility(0);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    localLayoutParams.leftMargin = ((int)paramMotionEvent.getRawX() - this.f.getWidth() / 2);
    localLayoutParams.topMargin = ((int)paramMotionEvent.getRawY() - this.e - this.f.getHeight() - d);
    this.f.requestLayout();
    return true;
  }
  
  public void b(BaseState paramBaseState)
  {
    this.k = false;
    PopOutAnimViewHelper.a(4, new View[] { this.i, this.f, this.g, this.h });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.BlurMaskState
 * JD-Core Version:    0.7.0.1
 */