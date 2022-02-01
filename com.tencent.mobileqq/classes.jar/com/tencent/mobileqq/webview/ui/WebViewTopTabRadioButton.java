package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.tencent.mobileqq.util.DisplayUtil;

public class WebViewTopTabRadioButton
  extends RadioButton
{
  int jdField_a_of_type_Int = 0;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public volatile boolean a;
  int jdField_b_of_type_Int = DisplayUtil.a(super.getContext(), 2.0F);
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  
  public WebViewTopTabRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  Bitmap a(Context paramContext)
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap == null) || (localBitmap.isRecycled())) {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130850766);
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(super.getContext());
      Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, null);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_AndroidGraphicsBitmap = a(super.getContext());
    Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramInt2 = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
    } else {
      paramInt2 = DisplayUtil.a(super.getContext(), 9.0F);
    }
    this.jdField_a_of_type_Int = (paramInt1 - paramInt2 - DisplayUtil.a(super.getContext(), 3.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTopTabRadioButton
 * JD-Core Version:    0.7.0.1
 */