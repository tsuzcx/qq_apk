package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import anyb;
import anyc;
import anyd;
import anye;
import anyf;
import anzm;
import aobk;
import axqw;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class EmoticonLinearLayout
  extends LinearLayout
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  float jdField_a_of_type_Float;
  public int a;
  public Context a;
  View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  anyb jdField_a_of_type_Anyb;
  private anyc jdField_a_of_type_Anyc;
  anye jdField_a_of_type_Anye = new anyd(this);
  public anyf a;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private EmoticonLinearLayout.CheckForLongPress jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress;
  Runnable jdField_a_of_type_JavaLangRunnable = new EmoticonLinearLayout.2(this);
  public List<RelativeLayout> a;
  boolean jdField_a_of_type_Boolean;
  public int b;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private boolean jdField_b_of_type_Boolean;
  
  public EmoticonLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = super.getResources().getColor(2131166377);
    setOrientation(1);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    super.setClickable(true);
    super.setLongClickable(true);
  }
  
  private View a(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localLinearLayout.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localLinearLayout.getTop();
      if ((f1 >= 0.0F) && (f1 <= localLinearLayout.getWidth()) && (f2 >= 0.0F) && (f2 < localLinearLayout.getHeight()))
      {
        int j = localLinearLayout.getChildCount() - 1;
        while (j >= 0)
        {
          View localView = localLinearLayout.getChildAt(j);
          float f3 = localLinearLayout.getScrollX() + f1 - localView.getLeft();
          float f4 = localLinearLayout.getScrollY() + f2 - localView.getTop();
          if ((f3 >= 0.0F) && (f3 <= localView.getWidth()) && (f4 >= 0.0F) && (f4 < localView.getHeight())) {
            return localView;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    return null;
  }
  
  private void a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof anyc)))
    {
      paramView = (anyc)paramView.getTag();
      if (paramView != null)
      {
        super.sendAccessibilityEvent(1);
        super.playSoundEffect(0);
        this.jdField_a_of_type_Anyb.a(paramView);
      }
    }
  }
  
  private boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    paramView = (ViewGroup)localViewGroup.getParent();
    paramRect.offset(localViewGroup.getLeft() - paramView.getScrollX(), localViewGroup.getTop() - paramView.getScrollY());
    return true;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_b_of_type_Boolean))
    {
      ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.jdField_b_of_type_AndroidWidgetFrameLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      if (this.jdField_a_of_type_Anyb != null) {
        this.jdField_a_of_type_Anyb.b(this.jdField_a_of_type_Anyc);
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  void a(View paramView, anyc paramanyc)
  {
    Drawable localDrawable = paramanyc.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
    if (localDrawable == null) {
      return;
    }
    paramView.getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
    int i = paramanyc.c;
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    float f = getContext().getResources().getDisplayMetrics().density;
    int k = (int)(5.0F * f);
    paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int j;
    if ((i == 1) || (i == 2) || (i == 7) || (i == 10))
    {
      j = (int)(64.0F * f);
      i = (int)(71.0F * f);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837716);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(k, k, k, k);
      paramView.width = ((int)(28.0F * f));
      paramView.height = ((int)(28.0F * f));
      paramView.bottomMargin = ((int)(6.0F * f));
      paramView.gravity = 17;
      label267:
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      paramView.gravity = 51;
      paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (j - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
      paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - i - (int)(15.0F * f));
      paramView.width = j;
      paramView.height = i;
      if (!this.jdField_b_of_type_Boolean) {
        break label681;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_Anyc;
      this.jdField_a_of_type_Anyc = paramanyc;
      if ((paramView != null) && (paramView.c == 6) && ((paramView instanceof aobk)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      if ((paramanyc.c == 6) && ((paramanyc instanceof aobk)) && ((localDrawable instanceof URLDrawable)))
      {
        localObject = (aobk)paramanyc;
        if (((aobk)localObject).b())
        {
          String str = anzm.o.replace("[epId]", ((aobk)localObject).a.epId).replace("[eId]", ((aobk)localObject).a.eId);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(getContext(), null);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(str);
          aobk.a((URLDrawable)localDrawable);
        }
        if (2 == ((aobk)localObject).a.jobType) {
          axqw.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, ((aobk)localObject).a.epId, "", "", "");
        }
      }
      if (this.jdField_a_of_type_Anyb == null) {
        break;
      }
      this.jdField_a_of_type_Anyb.a(paramView, paramanyc, localDrawable);
      return;
      j = (int)(110.0F * f);
      i = (int)(110.0F * f);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837715);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f));
      paramView.height = ((int)(100.0F * f));
      axqw.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label267;
      label681:
      paramView = (WindowManager)getContext().getSystemService("window");
      i = 24;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i = 67108888;
      }
      Object localObject = new WindowManager.LayoutParams(-1, -1, 2, i, -3);
      paramView.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress != null)) {
        removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_Boolean)) {
        a(this.jdField_a_of_type_AndroidViewView);
      }
      a();
      this.jdField_a_of_type_AndroidViewView = null;
      super.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      continue;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress == null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress = new EmoticonLinearLayout.CheckForLongPress(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress.a();
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
        paramMotionEvent = (anyc)this.jdField_a_of_type_AndroidViewView.getTag();
        if ((paramMotionEvent != null) && (this.jdField_a_of_type_Anyb != null) && ("delete".equals(paramMotionEvent.h)))
        {
          this.jdField_a_of_type_Anyb.b();
          continue;
          setPressed(false);
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress != null) {
            removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress);
          }
          removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          a();
          this.jdField_a_of_type_AndroidViewView = null;
          continue;
          if ((this.jdField_a_of_type_Boolean) && ((!a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) || (!jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
            if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getTag() != null))
            {
              paramMotionEvent = (anyc)this.jdField_a_of_type_AndroidViewView.getTag();
              if ((paramMotionEvent != null) && (!"delete".equals(paramMotionEvent.h)) && (!"add".equals(paramMotionEvent.h)) && (!"setting".equals(paramMotionEvent.h))) {
                a(this.jdField_a_of_type_AndroidViewView, (anyc)this.jdField_a_of_type_AndroidViewView.getTag());
              }
            }
            else
            {
              a();
            }
          }
          else if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null) && ((!a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) || (!jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.jdField_a_of_type_AndroidViewView = null;
          }
        }
      }
    }
  }
  
  public void setAdapter(anyf paramanyf)
  {
    this.jdField_a_of_type_Anyf = paramanyf;
    this.jdField_a_of_type_Anyf.a(this.jdField_a_of_type_Anye);
  }
  
  public void setCallBack(anyb paramanyb)
  {
    this.jdField_a_of_type_Anyb = paramanyb;
  }
  
  public void setPanelViewType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout
 * JD-Core Version:    0.7.0.1
 */