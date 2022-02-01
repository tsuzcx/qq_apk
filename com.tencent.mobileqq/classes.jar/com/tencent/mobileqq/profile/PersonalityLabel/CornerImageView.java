package com.tencent.mobileqq.profile.PersonalityLabel;

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
  
  public void drawableStateChanged()
  {
    int k = 0;
    super.drawableStateChanged();
    if (!this.jdField_a_of_type_Boolean) {}
    Object localObject;
    label83:
    do
    {
      return;
      localObject = getDrawableState();
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < localObject.length)
        {
          if (localObject[i] == 16842919) {
            j = 1;
          }
        }
        else
        {
          if (!(isPressed() | j)) {
            break label83;
          }
          localObject = getDrawable();
          if (localObject == null) {
            break;
          }
          ((Drawable)localObject).setColorFilter(jdField_a_of_type_AndroidGraphicsColorFilter);
          ((Drawable)localObject).invalidateSelf();
          return;
        }
        i += 1;
      }
      localObject = getDrawable();
    } while (localObject == null);
    ((Drawable)localObject).setColorFilter(null);
    ((Drawable)localObject).invalidateSelf();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    int i = paramCanvas.save();
    try
    {
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      localRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      localPath.reset();
      localPath.addRoundRect(localRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      b(paramCanvas);
      super.onDraw(paramCanvas);
      a(paramCanvas);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      super.onDraw(paramCanvas);
      return;
    }
    finally
    {
      paramCanvas.restoreToCount(i);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView
 * JD-Core Version:    0.7.0.1
 */