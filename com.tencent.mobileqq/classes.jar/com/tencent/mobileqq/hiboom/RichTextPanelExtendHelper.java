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
  protected int b;
  protected int c = 0;
  protected QQAppInterface d;
  protected BaseChatPie e;
  protected RichTextPanel f;
  private float g;
  private int h;
  
  public RichTextPanelExtendHelper(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, RichTextPanel paramRichTextPanel)
  {
    this.d = paramQQAppInterface;
    this.e = paramBaseChatPie;
    this.f = paramRichTextPanel;
    double d1 = this.d.getApp().getResources().getDisplayMetrics().heightPixels;
    Double.isNaN(d1);
    a = (int)(d1 * 0.6D);
    d();
  }
  
  public void a()
  {
    if (g())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onShow.");
      }
      this.c = 0;
      d();
      BaseChatPie localBaseChatPie = this.e;
      if ((localBaseChatPie != null) && (localBaseChatPie.W != null)) {
        this.e.W.setInterceptListener(this);
      }
    }
  }
  
  protected void a(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { XPanelContainer.a, paramInt });
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
    if (g())
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
        if (i != a) {
          XPanelContainer.a = i;
        }
      }
      else
      {
        i = this.c;
        if (i != 0) {
          XPanelContainer.a = i;
        }
      }
      this.c = 0;
      Object localObject = this.e;
      if ((localObject != null) && (((BaseChatPie)localObject).W != null)) {
        this.e.W.setInterceptListener(null);
      }
    }
  }
  
  public boolean b()
  {
    return XPanelContainer.a == this.b;
  }
  
  public void c()
  {
    if (g())
    {
      this.c = XPanelContainer.a;
      int i = this.b;
      if (i != a) {
        XPanelContainer.a = i;
      }
    }
  }
  
  public void d()
  {
    if (this.b > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("originPanelHeight has value is ");
      localStringBuilder.append(this.b);
      QLog.e("RichTextPanelExtendHelper", 2, localStringBuilder.toString());
      return;
    }
    this.b = XPanelContainer.a;
    this.f.post(new RichTextPanelExtendHelper.2(this));
  }
  
  protected void e()
  {
    if (this.b > XPanelContainer.a) {
      this.b = XPanelContainer.a;
    }
    boolean bool;
    if (a > this.b) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow ");
      localStringBuilder.append(AppSetting.i());
      localStringBuilder.append(" init panelH ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" needExtendPanel");
      localStringBuilder.append(bool);
      QLog.d("RichTextPanelExtendHelper", 2, localStringBuilder.toString());
    }
  }
  
  protected boolean f()
  {
    return (a > this.b) && (g());
  }
  
  boolean g()
  {
    BaseChatPie localBaseChatPie = this.e;
    return (localBaseChatPie != null) && (localBaseChatPie.Y != null);
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = f();
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
        j = (int)(paramMotionEvent.getY() - this.g + 0.5F);
        i = XPanelContainer.a;
        XPanelContainer.a -= j;
        j = XPanelContainer.a;
        k = a;
        if (j > k)
        {
          XPanelContainer.a = k;
        }
        else
        {
          j = XPanelContainer.a;
          k = this.b;
          if (j < k) {
            XPanelContainer.a = k;
          }
        }
        if (XPanelContainer.a == i) {
          break label280;
        }
        AbstractGifImage.pauseAll();
        if (!(this.f.getParent() instanceof XPanelContainer)) {
          break label280;
        }
        this.f.getParent().requestLayout();
        return true;
      }
    }
    int m = XPanelContainer.a;
    i = a;
    if (m != i)
    {
      k = this.b;
      if (m != k)
      {
        if (m <= this.h) {
          i = k;
        }
        if (Math.abs(m - this.h) > 100) {
          j = 1;
        }
        if (j == 0) {
          i = this.h;
        }
        if ((j != 0) && (i == this.b))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RichTextPanelExtendHelper", 2, "report panel close");
          }
        }
        else if ((j != 0) && (i == a) && (QLog.isColorLevel())) {
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
    if (!f()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 2)
      {
        if (this.f.getParent() != null)
        {
          this.f.getParent().requestDisallowInterceptTouchEvent(false);
          return false;
        }
      }
      else
      {
        float f1 = paramMotionEvent.getY();
        i = (int)(f1 - this.g + 0.5F);
        if (g())
        {
          paramMotionEvent = this.e;
          if ((paramMotionEvent != null) && (paramMotionEvent.W != null) && (Math.abs(i) > this.e.W.getHeight() * 0.6F))
          {
            this.g = f1;
            return true;
          }
        }
      }
    }
    else
    {
      this.g = paramMotionEvent.getY();
      this.h = XPanelContainer.a;
    }
    return false;
  }
  
  public boolean isPanelOpen()
  {
    return XPanelContainer.a == a;
  }
  
  public void onPullDown()
  {
    if (!f()) {
      return;
    }
    if (XPanelContainer.a == a)
    {
      a(250, XPanelContainer.a, this.b);
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onPullDown");
      }
    }
  }
  
  public void onPullUp()
  {
    if (!f()) {
      return;
    }
    if (XPanelContainer.a == this.b)
    {
      a(200, XPanelContainer.a, a);
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onPullUp");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper
 * JD-Core Version:    0.7.0.1
 */