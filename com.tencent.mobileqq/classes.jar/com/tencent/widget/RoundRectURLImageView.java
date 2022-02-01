package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class RoundRectURLImageView
  extends URLImageView
{
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  public RoundRectURLImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundRectURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public RoundRectURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i;
    if (a())
    {
      if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      }
      i = paramCanvas.save();
    }
    try
    {
      try
      {
        Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
        localPath.reset();
        localPath.addRoundRect(localRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
        super.onDraw(paramCanvas);
      }
      finally
      {
        break label102;
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      label91:
      break label91;
    }
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
    return;
    label102:
    paramCanvas.restoreToCount(i);
    throw localObject;
    super.onDraw(paramCanvas);
  }
  
  public void setNeedRadius(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRadius(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      setRadius(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat });
      return;
    }
    setRadius(null);
  }
  
  public void setRadius(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
    boolean bool;
    if (paramArrayOfFloat != null) {
      bool = true;
    } else {
      bool = false;
    }
    setNeedRadius(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.RoundRectURLImageView
 * JD-Core Version:    0.7.0.1
 */