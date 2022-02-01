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
  private int jdField_a_of_type_Int = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private View jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372942);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372933);
  protected StickerBubbleTouchDelegate a;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = (DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366851);
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private PopOutAnimConfig jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig = this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig;
  protected PopOutAnimViewHolder a;
  private DiniFlyAnimationView b = (DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372941);
  
  protected PopAnimState(ViewGroup paramViewGroup, StateContext paramStateContext)
  {
    super(paramViewGroup, paramStateContext);
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimViewHolder = PopOutAnimViewHolder.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate = new StickerBubbleTouchDelegate(this, this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_b_of_type_AndroidViewViewGroup, true, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.a(false);
    LottieHelper.a(this.jdField_a_of_type_AndroidContentContext, "emoc/pop_anim_del.json", null, 50, 50, 0, new PopAnimState.1(this));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      float f = ViewUtils.b(85.0F);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { f, 0.0F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(400L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new PopAnimState.2(this, f));
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.maxSendCount;
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewQQEmoticonPanelLinearLayoutHelper.getCurrentPointViewIndex();
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
    {
      QLog.e("PopAnimState", 1, "mEmoticonInfo error");
      return;
    }
    Object localObject = (SystemAndEmojiEmoticonInfo)this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
    boolean bool = PopOutEmoticonUtil.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.itemCountShowAppear);
    localObject = PopOutEmoticonUtil.a(((SystemAndEmojiEmoticonInfo)localObject).code, this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.apngSoLoaded);
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimViewHolder.a(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.typeface).a(this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimViewHolder.a(new Point((int)paramFloat1, (int)paramFloat2), (String)localObject, bool));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqPopanimPopOutEmoticonGesture.c();
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimViewHolder.b(this, true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2;
    if (paramInt2 == a())
    {
      paramInt1 = paramInt2 - 1;
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.c = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.typeface).d();
    SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
    if (!this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.f)
    {
      this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.sendPopEmoMsg(localSystemAndEmojiEmoticonInfo, paramInt1);
      PopOutAnimViewHelper.a("0X800BBA3", localSystemAndEmojiEmoticonInfo);
    }
  }
  
  public void a(BaseState paramBaseState)
  {
    if ((paramBaseState instanceof PopDeleteState)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimViewHolder.a(this, true);
    paramBaseState = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (paramBaseState != null) {
      this.b.setImageDrawable(paramBaseState);
    }
    b();
    PopOutAnimViewHelper.a("0X800BBA1", this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.onShowPress(paramMotionEvent);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.a(paramMotionEvent);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    localLayoutParams.leftMargin = ((int)paramMotionEvent.getRawX() - this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getWidth() / 2);
    localLayoutParams.topMargin = ((int)paramMotionEvent.getRawY() - this.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getHeight() / 2);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.requestLayout();
    return true;
  }
  
  public void b(BaseState paramBaseState)
  {
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.end();
    }
    if ((paramBaseState instanceof PopDeleteState)) {
      return;
    }
    PopOutAnimViewHelper.a(4, new View[] { this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView });
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.c();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.startShakeAnimation();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig.stopShakeAnimation();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.PopAnimState
 * JD-Core Version:    0.7.0.1
 */