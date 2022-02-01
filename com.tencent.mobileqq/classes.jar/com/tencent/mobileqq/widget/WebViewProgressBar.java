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
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private WebViewProgressBarController jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
  private boolean jdField_a_of_type_Boolean = true;
  private Drawable b;
  private Drawable c = null;
  
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.c = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
    if ((localObject != null) && (((WebViewProgressBarController)localObject).a() != 6))
    {
      int i;
      if ((this.c != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        j = (int)this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a();
        if (j < this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth())
        {
          i = j - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
          j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        }
        else
        {
          i = 0;
        }
        j += i;
        if (j > 0)
        {
          this.c.setBounds(0, 0, getWidth(), getHeight());
          this.c.draw(paramCanvas);
          localObject = this.b;
          if (localObject != null)
          {
            ((Drawable)localObject).setBounds(0, 0, getWidth(), getHeight());
            this.b.draw(paramCanvas);
          }
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, 0, j, getHeight());
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        return;
      }
      if (this.b == null) {
        this.b = getContext().getResources().getDrawable(2130850411);
      }
      this.b.setBounds(0, 0, getWidth(), getHeight());
      this.b.draw(paramCanvas);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130850412);
      }
      int j = (int)this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a());
      }
      if (j < this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth())
      {
        i = j - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      }
      else
      {
        i = 0;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, 0, j + i, getHeight());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    WebViewProgressBarController localWebViewProgressBarController = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
    if (localWebViewProgressBarController != null) {
      localWebViewProgressBarController.a(getWidth());
    }
  }
  
  public void setController(WebViewProgressBarController paramWebViewProgressBarController)
  {
    WebViewProgressBarController localWebViewProgressBarController = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
    if (localWebViewProgressBarController == paramWebViewProgressBarController) {
      return;
    }
    if (localWebViewProgressBarController != null) {
      localWebViewProgressBarController.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = paramWebViewProgressBarController;
    paramWebViewProgressBarController = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
    if (paramWebViewProgressBarController != null)
    {
      paramWebViewProgressBarController.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(getWidth());
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
    this.c = new ColorDrawable(-1);
    paramInt &= 0x7FFFFFFF;
    this.b = new ColorDrawable(paramInt);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBar
 * JD-Core Version:    0.7.0.1
 */