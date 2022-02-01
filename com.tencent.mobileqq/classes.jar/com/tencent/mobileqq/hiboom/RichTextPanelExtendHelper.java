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
  implements PanelIconLinearLayout.InterceptListener, EmotionPanelListView.PullAndFastScrollListener
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
    jdField_a_of_type_Int = (int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics().heightPixels * 0.6D);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
    }
  }
  
  protected void a(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { XPanelContainer.jdField_a_of_type_Int, paramInt });
    localValueAnimator.setDuration(150L);
    localValueAnimator.addUpdateListener(new RichTextPanelExtendHelper.2(this, paramInt));
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
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onHide. openSoftInput: " + paramBoolean + " mOriginPanelHeight: " + this.b + " mOldPanelHeight: " + this.c);
      }
      if (paramBoolean) {
        break label107;
      }
      XPanelContainer.jdField_a_of_type_Int = this.b;
    }
    for (;;)
    {
      this.c = 0;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(null);
      }
      return;
      label107:
      if (this.c != 0) {
        XPanelContainer.jdField_a_of_type_Int = this.c;
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
      XPanelContainer.jdField_a_of_type_Int = this.b;
    }
  }
  
  protected boolean b()
  {
    return (jdField_a_of_type_Int > this.b) && (c());
  }
  
  public void c()
  {
    this.b = XPanelContainer.jdField_a_of_type_Int;
    if (jdField_a_of_type_Int > this.b) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onShow " + AppSetting.g() + " init panelH " + this.b + " needExtendPanel" + bool);
      }
      return;
    }
  }
  
  boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null);
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (!b()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      int i = (int)(paramMotionEvent.getY() - this.jdField_a_of_type_Float + 0.5F);
      j = XPanelContainer.jdField_a_of_type_Int;
      XPanelContainer.jdField_a_of_type_Int -= i;
      if (XPanelContainer.jdField_a_of_type_Int > jdField_a_of_type_Int) {
        XPanelContainer.jdField_a_of_type_Int = jdField_a_of_type_Int;
      }
      while (XPanelContainer.jdField_a_of_type_Int != j)
      {
        AbstractGifImage.pauseAll();
        if (!(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.getParent() instanceof XPanelContainer)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.getParent().requestLayout();
        break;
        if (XPanelContainer.jdField_a_of_type_Int < this.b) {
          XPanelContainer.jdField_a_of_type_Int = this.b;
        }
      }
      int k = XPanelContainer.jdField_a_of_type_Int;
      if ((k != jdField_a_of_type_Int) && (k != this.b))
      {
        if (k > this.d)
        {
          i = jdField_a_of_type_Int;
          label176:
          if (Math.abs(k - this.d) > 100) {
            j = 1;
          }
          if (j == 0) {
            break label239;
          }
          label197:
          if ((j == 0) || (i != this.b)) {
            break label247;
          }
          if (QLog.isColorLevel()) {
            QLog.i("RichTextPanelExtendHelper", 2, "report panel close");
          }
        }
        for (;;)
        {
          a(i);
          break;
          i = this.b;
          break label176;
          label239:
          i = this.d;
          break label197;
          label247:
          if ((j != 0) && (i == jdField_a_of_type_Int) && (QLog.isColorLevel())) {
            QLog.i("RichTextPanelExtendHelper", 2, "report panel open");
          }
        }
      }
      AbstractGifImage.resumeAll();
    }
  }
  
  public boolean interceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b()) {}
    float f;
    int i;
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.getParent() == null);
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.getParent().requestDisallowInterceptTouchEvent(false);
      return false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.d = XPanelContainer.jdField_a_of_type_Int;
      return false;
      f = paramMotionEvent.getY();
      i = (int)(f - this.jdField_a_of_type_Float + 0.5F);
    } while ((!c()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (Math.abs(i) <= this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() * 0.6F));
    this.jdField_a_of_type_Float = f;
    return true;
  }
  
  public boolean isPanelOpen()
  {
    return XPanelContainer.jdField_a_of_type_Int == jdField_a_of_type_Int;
  }
  
  public void onPullDown()
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != jdField_a_of_type_Int);
      a(250, XPanelContainer.jdField_a_of_type_Int, this.b);
    } while (!QLog.isColorLevel());
    QLog.d("RichTextPanelExtendHelper", 2, "onPullDown");
  }
  
  public void onPullUp()
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != this.b);
      a(200, XPanelContainer.jdField_a_of_type_Int, jdField_a_of_type_Int);
    } while (!QLog.isColorLevel());
    QLog.d("RichTextPanelExtendHelper", 2, "onPullUp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper
 * JD-Core Version:    0.7.0.1
 */