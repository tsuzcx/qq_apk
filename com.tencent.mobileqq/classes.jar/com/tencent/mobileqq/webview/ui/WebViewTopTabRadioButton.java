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
  Bitmap a;
  int b = 0;
  int c = DisplayUtil.a(super.getContext(), 2.0F);
  public volatile boolean d = false;
  Bitmap e;
  
  public WebViewTopTabRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  Bitmap a(Context paramContext)
  {
    Bitmap localBitmap = this.a;
    if ((localBitmap == null) || (localBitmap.isRecycled())) {
      try
      {
        this.a = BitmapFactory.decodeResource(paramContext.getResources(), 2130852588);
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.d)
    {
      this.e = a(super.getContext());
      Bitmap localBitmap = this.e;
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        paramCanvas.drawBitmap(this.e, this.b, this.c, null);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = a(super.getContext());
    Bitmap localBitmap = this.e;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramInt2 = this.e.getWidth();
    } else {
      paramInt2 = DisplayUtil.a(super.getContext(), 9.0F);
    }
    this.b = (paramInt1 - paramInt2 - DisplayUtil.a(super.getContext(), 3.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTopTabRadioButton
 * JD-Core Version:    0.7.0.1
 */