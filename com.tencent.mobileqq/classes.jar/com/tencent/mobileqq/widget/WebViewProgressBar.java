package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class WebViewProgressBar
  extends View
{
  private Drawable a;
  private Drawable b;
  private boolean c = true;
  private WebViewProgressBarController d;
  private Drawable e = null;
  
  public WebViewProgressBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebViewProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WebViewProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    this.b = null;
    this.a = null;
    this.e = null;
    this.c = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.d;
    if ((localObject != null) && (((WebViewProgressBarController)localObject).a() != 6))
    {
      int i;
      if ((this.e != null) && (this.a != null))
      {
        j = (int)this.d.b();
        if (j < this.a.getIntrinsicWidth())
        {
          i = j - this.a.getIntrinsicWidth();
          j = this.a.getIntrinsicWidth();
        }
        else
        {
          i = 0;
        }
        j += i;
        if (j > 0)
        {
          this.e.setBounds(0, 0, getWidth(), getHeight());
          this.e.draw(paramCanvas);
          localObject = this.b;
          if (localObject != null)
          {
            ((Drawable)localObject).setBounds(0, 0, getWidth(), getHeight());
            this.b.draw(paramCanvas);
          }
        }
        this.a.setBounds(i, 0, j, getHeight());
        this.a.draw(paramCanvas);
        return;
      }
      if (this.b == null) {
        this.b = getContext().getResources().getDrawable(2130852202);
      }
      this.b.setBounds(0, 0, getWidth(), getHeight());
      this.b.draw(paramCanvas);
      if (this.a == null) {
        this.a = getContext().getResources().getDrawable(2130852203);
      }
      int j = (int)this.d.b();
      if (this.c) {
        this.a.setAlpha(this.d.c());
      }
      if (j < this.a.getIntrinsicWidth())
      {
        i = j - this.a.getIntrinsicWidth();
        j = this.a.getIntrinsicWidth();
      }
      else
      {
        i = 0;
      }
      this.a.setBounds(i, 0, j + i, getHeight());
      this.a.draw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    WebViewProgressBarController localWebViewProgressBarController = this.d;
    if (localWebViewProgressBarController != null) {
      localWebViewProgressBarController.a(getWidth());
    }
  }
  
  public void setController(WebViewProgressBarController paramWebViewProgressBarController)
  {
    WebViewProgressBarController localWebViewProgressBarController = this.d;
    if (localWebViewProgressBarController == paramWebViewProgressBarController) {
      return;
    }
    if (localWebViewProgressBarController != null) {
      localWebViewProgressBarController.a(null);
    }
    this.d = paramWebViewProgressBarController;
    paramWebViewProgressBarController = this.d;
    if (paramWebViewProgressBarController != null)
    {
      paramWebViewProgressBarController.a(this);
      this.d.a(getWidth());
    }
    invalidate();
  }
  
  public void setCustomColor(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCustomColor color=");
      localStringBuilder.append(Integer.toHexString(paramInt));
      QLog.d("WebViewProgressBar", 2, localStringBuilder.toString());
    }
    this.e = new ColorDrawable(-1);
    paramInt &= 0x7FFFFFFF;
    this.b = new ColorDrawable(paramInt);
    this.a = new ColorDrawable(paramInt);
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBar
 * JD-Core Version:    0.7.0.1
 */