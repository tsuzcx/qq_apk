package com.tencent.mobileqq.hiboom;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.InterceptListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class RichTextPanelExtendHelper
  implements PanelIconLinearLayout.InterceptListener, EmotionPanelListView.PullAndFastScrollListener, IRichTextPanelExtendHelper
{
  public static int a;
  private float a;
  protected BaseChatPie a;
  protected QQAppInterface a;
  protected RichTextPanel a;
  protected int b;
  protected int c = 0;
  private int d;
  
  public RichTextPanelExtendHelper(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, RichTextPanel paramRichTextPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel = paramRichTextPanel;
    double d1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics().heightPixels;
    Double.isNaN(d1);
    jdField_a_of_type_Int = (int)(d1 * 0.6D);
    c();
  }
  
  public void a()
  {
    if (c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onShow.");
      }
      this.c = 0;
      c();
      BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
    }
  }
  
  protected void a(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { XPanelContainer.jdField_a_of_type_Int, paramInt });
    localValueAnimator.setDuration(150L);
    localValueAnimator.addUpdateListener(new RichTextPanelExtendHelper.3(this, paramInt));
    localValueAnimator.start();
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new RichTextPanelExtendHelper.1(this));
    localValueAnimator.start();
  }
  
  public void a(boolean paramBoolean)
  {
    if (c())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onHide. openSoftInput: ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" mOriginPanelHeight: ");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(" mOldPanelHeight: ");
        ((StringBuilder)localObject).append(this.c);
        QLog.d("RichTextPanelExtendHelper", 2, ((StringBuilder)localObject).toString());
      }
      int i;
      if (!paramBoolean)
      {
        i = this.b;
        if (i != jdField_a_of_type_Int) {
          XPanelContainer.jdField_a_of_type_Int = i;
        }
      }
      else
      {
        i = this.c;
        if (i != 0) {
          XPanelContainer.jdField_a_of_type_Int = i;
        }
      }
      this.c = 0;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(null);
      }
    }
  }
  
  public boolean a()
  {
    return XPanelContainer.jdField_a_of_type_Int == this.b;
  }
  
  public void b()
  {
    if (c())
    {
      this.c = XPanelContainer.jdField_a_of_type_Int;
      int i = this.b;
      if (i != jdField_a_of_type_Int) {
        XPanelContainer.jdField_a_of_type_Int = i;
      }
    }
  }
  
  protected boolean b()
  {
    return (jdField_a_of_type_Int > this.b) && (c());
  }
  
  public void c()
  {
    if (this.b > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("originPanelHeight has value is ");
      localStringBuilder.append(this.b);
      QLog.e("RichTextPanelExtendHelper", 2, localStringBuilder.toString());
      return;
    }
    this.b = XPanelContainer.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.post(new RichTextPanelExtendHelper.2(this));
  }
  
  boolean c()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    return (localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null);
  }
  
  protected void d()
  {
    if (this.b > XPanelContainer.jdField_a_of_type_Int) {
      this.b = XPanelContainer.jdField_a_of_type_Int;
    }
    boolean bool;
    if (jdField_a_of_type_Int > this.b) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow ");
      localStringBuilder.append(AppSetting.g());
      localStringBuilder.append(" init panelH ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" needExtendPanel");
      localStringBuilder.append(bool);
      QLog.d("RichTextPanelExtendHelper", 2, localStringBuilder.toString());
    }
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = b();
    int j = 0;
    if (!bool) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    int k;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
      }
      else
      {
        j = (int)(paramMotionEvent.getY() - this.jdField_a_of_type_Float + 0.5F);
        i = XPanelContainer.jdField_a_of_type_Int;
        XPanelContainer.jdField_a_of_type_Int -= j;
        j = XPanelContainer.jdField_a_of_type_Int;
        k = jdField_a_of_type_Int;
        if (j > k)
        {
          XPanelContainer.jdField_a_of_type_Int = k;
        }
        else
        {
          j = XPanelContainer.jdField_a_of_type_Int;
          k = this.b;
          if (j < k) {
            XPanelContainer.jdField_a_of_type_Int = k;
          }
        }
        if (XPanelContainer.jdField_a_of_type_Int == i) {
          break label280;
        }
        AbstractGifImage.pauseAll();
        if (!(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.getParent() instanceof XPanelContainer)) {
          break label280;
        }
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.getParent().requestLayout();
        return true;
      }
    }
    int m = XPanelContainer.jdField_a_of_type_Int;
    i = jdField_a_of_type_Int;
    if (m != i)
    {
      k = this.b;
      if (m != k)
      {
        if (m <= this.d) {
          i = k;
        }
        if (Math.abs(m - this.d) > 100) {
          j = 1;
        }
        if (j == 0) {
          i = this.d;
        }
        if ((j != 0) && (i == this.b))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RichTextPanelExtendHelper", 2, "report panel close");
          }
        }
        else if ((j != 0) && (i == jdField_a_of_type_Int) && (QLog.isColorLevel())) {
          QLog.i("RichTextPanelExtendHelper", 2, "report panel open");
        }
        a(i);
        return true;
      }
    }
    AbstractGifImage.resumeAll();
    label280:
    return true;
  }
  
  public boolean interceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.getParent() != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.getParent().requestDisallowInterceptTouchEvent(false);
          return false;
        }
      }
      else
      {
        float f = paramMotionEvent.getY();
        i = (int)(f - this.jdField_a_of_type_Float + 0.5F);
        if (c())
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          if ((paramMotionEvent != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (Math.abs(i) > this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() * 0.6F))
          {
            this.jdField_a_of_type_Float = f;
            return true;
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.d = XPanelContainer.jdField_a_of_type_Int;
    }
    return false;
  }
  
  public boolean isPanelOpen()
  {
    return XPanelContainer.jdField_a_of_type_Int == jdField_a_of_type_Int;
  }
  
  public void onPullDown()
  {
    if (!b()) {
      return;
    }
    if (XPanelContainer.jdField_a_of_type_Int == jdField_a_of_type_Int)
    {
      a(250, XPanelContainer.jdField_a_of_type_Int, this.b);
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onPullDown");
      }
    }
  }
  
  public void onPullUp()
  {
    if (!b()) {
      return;
    }
    if (XPanelContainer.jdField_a_of_type_Int == this.b)
    {
      a(200, XPanelContainer.jdField_a_of_type_Int, jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onPullUp");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper
 * JD-Core Version:    0.7.0.1
 */