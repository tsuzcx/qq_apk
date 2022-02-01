package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.util.VersionUtils;

public class CornerImageView
  extends URLImageView
{
  public static ColorFilter a;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  static
  {
    jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
  }
  
  public CornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (!VersionUtils.i()) {
      setLayerType(1, null);
    }
  }
  
  protected void a(Canvas paramCanvas) {}
  
  protected void b(Canvas paramCanvas) {}
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = getDrawableState();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i] == 16842919)
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if ((isPressed() | j))
    {
      localObject = getDrawable();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(jdField_a_of_type_AndroidGraphicsColorFilter);
        ((Drawable)localObject).invalidateSelf();
      }
    }
    else
    {
      localObject = getDrawable();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(null);
        ((Drawable)localObject).invalidateSelf();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    int i = paramCanvas.save();
    try
    {
      try
      {
        Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        localRectF.set(0.0F, 0.0F, getWidth(), getHeight());
        localPath.reset();
        localPath.addRoundRect(localRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
        a(paramCanvas);
        super.onDraw(paramCanvas);
        b(paramCanvas);
      }
      finally
      {
        break label107;
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      label96:
      break label96;
    }
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
    return;
    label107:
    paramCanvas.restoreToCount(i);
    throw localObject;
  }
  
  public void setPressMask(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRadius(float paramFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat };
    a();
  }
  
  public void setRadius(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.CornerImageView
 * JD-Core Version:    0.7.0.1
 */