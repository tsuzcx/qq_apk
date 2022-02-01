package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class ClickableToastView
  extends LinearLayout
{
  private int a;
  private View b;
  private Activity c;
  private WindowManager d;
  private Resources e;
  private Drawable f;
  private CharSequence g;
  private ClickableToastView.RightActionParams h;
  private Handler i;
  
  private void setToastText(CharSequence paramCharSequence)
  {
    this.g = paramCharSequence;
  }
  
  public void a()
  {
    this.i.removeMessages(0);
    Activity localActivity = this.c;
    if ((localActivity != null) && (!localActivity.isFinishing()) && (this.b.getParent() != null)) {
      try
      {
        this.d.removeView(this.b);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeView error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("ClickableToastView", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void setRightActionParams(ClickableToastView.RightActionParams paramRightActionParams)
  {
    this.h = paramRightActionParams;
  }
  
  public void setToastIcon(int paramInt)
  {
    setToastIcon(this.e.getDrawable(paramInt));
  }
  
  public void setToastIcon(Drawable paramDrawable)
  {
    if (this.a != -1) {
      this.f = paramDrawable;
    }
  }
  
  public void setType(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClickableToastView
 * JD-Core Version:    0.7.0.1
 */