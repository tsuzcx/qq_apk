package com.tencent.mtt.hippy.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.supportui.views.asyncimage.ContentDrawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class HippyContentDrawable
  extends ContentDrawable
{
  private NinePatchDrawable mNinePatchDrawable;
  private Rect mNinePatchRect;
  
  private byte[] createNinePatchTrunk(Bitmap paramBitmap, Rect paramRect)
  {
    int[] arrayOfInt1 = new int[2];
    int j = paramRect.left;
    int i = 0;
    arrayOfInt1[0] = j;
    arrayOfInt1[1] = (paramBitmap.getWidth() - paramRect.right);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = paramRect.top;
    arrayOfInt2[1] = (paramBitmap.getHeight() - paramRect.bottom);
    paramBitmap = ByteBuffer.allocate(arrayOfInt1.length * 4 + arrayOfInt2.length * 4 + 36 + 32).order(ByteOrder.nativeOrder());
    paramBitmap.put((byte)1);
    paramBitmap.put((byte)2);
    paramBitmap.put((byte)2);
    paramBitmap.put((byte)9);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(0);
    paramBitmap.putInt(arrayOfInt1[0]);
    paramBitmap.putInt(arrayOfInt1[1]);
    paramBitmap.putInt(arrayOfInt2[0]);
    paramBitmap.putInt(arrayOfInt2[1]);
    while (i < 9)
    {
      paramBitmap.putInt(1);
      i += 1;
    }
    return paramBitmap.array();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.mNinePatchRect != null) && (this.mContentBitmap != null))
    {
      if (this.mNinePatchDrawable == null) {
        this.mNinePatchDrawable = new NinePatchDrawable(ContextHolder.getAppContext().getResources(), this.mContentBitmap, createNinePatchTrunk(this.mContentBitmap, this.mNinePatchRect), null, null);
      }
      this.mNinePatchDrawable.setBounds(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.mNinePatchDrawable.setAlpha(this.mAlpha);
      if (this.mTintColor != 0) {
        this.mNinePatchDrawable.setColorFilter(new PorterDuffColorFilter(this.mTintColor, PorterDuff.Mode.SRC_ATOP));
      }
      this.mNinePatchDrawable.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  void setNinePatchCoordinate(Rect paramRect)
  {
    this.mNinePatchRect = paramRect;
    this.mNinePatchDrawable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.image.HippyContentDrawable
 * JD-Core Version:    0.7.0.1
 */