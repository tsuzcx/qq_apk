package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import bcsr;
import com.tencent.qphone.base.util.QLog;

public class WebViewProgressBar
  extends View
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private bcsr jdField_a_of_type_Bcsr;
  private boolean jdField_a_of_type_Boolean = true;
  private Drawable b;
  private Drawable c;
  
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
    int j;
    int i;
    if ((this.jdField_a_of_type_Bcsr != null) && (this.jdField_a_of_type_Bcsr.a() != 6))
    {
      if ((this.c == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
        break label164;
      }
      j = (int)this.jdField_a_of_type_Bcsr.a();
      if (j >= this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()) {
        break label324;
      }
      i = j - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    }
    for (;;)
    {
      if (i + j > 0)
      {
        this.c.setBounds(0, 0, getWidth(), getHeight());
        this.c.draw(paramCanvas);
        if (this.b != null)
        {
          this.b.setBounds(0, 0, getWidth(), getHeight());
          this.b.draw(paramCanvas);
        }
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, 0, j + i, getHeight());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      label164:
      if (this.b == null) {
        this.b = getContext().getResources().getDrawable(2130849009);
      }
      this.b.setBounds(0, 0, getWidth(), getHeight());
      this.b.draw(paramCanvas);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130849010);
      }
      j = (int)this.jdField_a_of_type_Bcsr.a();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_a_of_type_Bcsr.a());
      }
      if (j < this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth())
      {
        i = j - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, 0, j + i, getHeight());
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        return;
        i = 0;
      }
      label324:
      i = 0;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Bcsr != null) {
      this.jdField_a_of_type_Bcsr.a(getWidth());
    }
  }
  
  public void setController(bcsr parambcsr)
  {
    if (this.jdField_a_of_type_Bcsr == parambcsr) {
      return;
    }
    if (this.jdField_a_of_type_Bcsr != null) {
      this.jdField_a_of_type_Bcsr.a(null);
    }
    this.jdField_a_of_type_Bcsr = parambcsr;
    if (this.jdField_a_of_type_Bcsr != null)
    {
      this.jdField_a_of_type_Bcsr.a(this);
      this.jdField_a_of_type_Bcsr.a(getWidth());
    }
    invalidate();
  }
  
  public void setCustomColor(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewProgressBar", 2, "setCustomColor color=" + Integer.toHexString(paramInt));
    }
    this.c = new ColorDrawable(-1);
    this.b = new ColorDrawable(paramInt & 0x7FFFFFFF);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(paramInt & 0x7FFFFFFF);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBar
 * JD-Core Version:    0.7.0.1
 */