package com.tencent.mobileqq.popanim.state;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.StickerBubbleAnimationCallback;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleSendCallback;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegate;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.popanim.PopOutAnimViewHolder;
import com.tencent.mobileqq.popanim.PopOutEmoticonGesture;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class PopAnimState
  extends BaseState
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback, StickerBubbleSendCallback
{
  protected PopOutAnimViewHolder d = PopOutAnimViewHolder.a();
  protected StickerBubbleTouchDelegate e = new StickerBubbleTouchDelegate(this, this.c.e, true, true);
  ObjectAnimator f;
  private int g = ImmersiveUtils.getStatusBarHeight(this.a);
  private FrameLayout h = (FrameLayout)this.b.findViewById(2131440496);
  private DiniFlyAnimationView i = (DiniFlyAnimationView)this.b.findViewById(2131433178);
  private DiniFlyAnimationView j = (DiniFlyAnimationView)this.b.findViewById(2131440505);
  private View k = this.b.findViewById(2131440506);
  private LottieDrawable l;
  private PopOutAnimConfig m = this.c.c;
  
  protected PopAnimState(ViewGroup paramViewGroup, StateContext paramStateContext)
  {
    super(paramViewGroup, paramStateContext);
    this.e.a(false);
    LottieHelper.a(this.a, "emoc/pop_anim_del.json", null, 50, 50, 0, new PopAnimState.1(this));
  }
  
  private void b()
  {
    if (this.k == null) {
      return;
    }
    if (this.f == null)
    {
      float f1 = ViewUtils.dpToPx(85.0F);
      this.f = ObjectAnimator.ofFloat(this.k, "translationY", new float[] { f1, 0.0F });
      this.f.setDuration(400L);
      this.f.addListener(new PopAnimState.2(this, f1));
    }
    this.f.start();
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return this.c.g.getCurrentPointViewIndex();
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (!(this.c.b instanceof SystemAndEmojiEmoticonInfo))
    {
      QLog.e("PopAnimState", 1, "mEmoticonInfo error");
      return;
    }
    Object localObject = (SystemAndEmojiEmoticonInfo)this.c.b;
    boolean bool = PopOutEmoticonUtil.a(paramInt2, this.m.itemCountShowAppear);
    localObject = PopOutEmoticonUtil.a(((SystemAndEmojiEmoticonInfo)localObject).code, this.m.apngSoLoaded);
    this.d.a(this.h, this.m.typeface).a(this.d.a(new Point((int)paramFloat1, (int)paramFloat2), (String)localObject, bool));
  }
  
  public void a(int paramInt)
  {
    this.c.a.d();
    this.d.b(this, true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2;
    if (paramInt2 == getMaxSendCount())
    {
      paramInt1 = paramInt2 - 1;
      this.c.j = true;
    }
    this.d.a(this.m.typeface).d();
    SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)this.c.b;
    if (!this.c.m)
    {
      this.m.sendPopEmoMsg(localSystemAndEmojiEmoticonInfo, paramInt1);
      PopOutAnimViewHelper.a("0X800BBA3", localSystemAndEmojiEmoticonInfo);
    }
  }
  
  public void a(BaseState paramBaseState)
  {
    if ((paramBaseState instanceof PopDeleteState)) {
      return;
    }
    this.d.a(this, true);
    paramBaseState = this.l;
    if (paramBaseState != null) {
      this.j.setImageDrawable(paramBaseState);
    }
    b();
    PopOutAnimViewHelper.a("0X800BBA1", this.c.b);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.c.i)
    {
      this.c.i = true;
      this.e.onShowPress(paramMotionEvent);
    }
    this.e.a(paramMotionEvent);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    localLayoutParams.leftMargin = ((int)paramMotionEvent.getRawX() - this.i.getWidth() / 2);
    localLayoutParams.topMargin = ((int)paramMotionEvent.getRawY() - this.g - this.i.getHeight() / 2);
    this.i.requestLayout();
    return true;
  }
  
  public void b(float paramFloat1, float paramFloat2) {}
  
  public void b(BaseState paramBaseState)
  {
    ObjectAnimator localObjectAnimator = this.f;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      this.f.end();
    }
    if ((paramBaseState instanceof PopDeleteState)) {
      return;
    }
    PopOutAnimViewHelper.a(4, new View[] { this.j, this.k, this.i });
    this.e.c();
  }
  
  public void c()
  {
    this.m.startShakeAnimation();
  }
  
  public boolean c(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void d()
  {
    this.m.stopShakeAnimation();
  }
  
  public void e() {}
  
  public int getMaxSendCount()
  {
    return this.m.maxSendCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.PopAnimState
 * JD-Core Version:    0.7.0.1
 */