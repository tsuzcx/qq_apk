package com.tencent.mobileqq.qzoneplayer.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.tencent.oskplayer.util.PlayerUtils;

public class RotationSeekBar
  extends SeekBar
{
  private static boolean isRubbishPhoneModel = ;
  private static float sDensity = -1.0F;
  private int mCurRotate;
  private Paint mDebugPainter = null;
  private Paint mMarkPainter = null;
  private float[] mMarkPercent = null;
  private RotationSeekBar.OnRotationChangeListener mOnRotationChangeListener;
  
  public RotationSeekBar(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private int dpToPx(float paramFloat)
  {
    getDensity();
    return Math.round(paramFloat * sDensity);
  }
  
  private MotionEvent fixTouchMoveEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 2))
    {
      int[] arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[0];
      int i = arrayOfInt[1];
      int m = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      int n = this.mCurRotate;
      if (n != 90)
      {
        if (n != 180)
        {
          if (n != 270)
          {
            i = (int)paramMotionEvent.getX();
            j = (int)paramMotionEvent.getY();
          }
          else
          {
            i -= j;
            j = m - k;
          }
        }
        else
        {
          j = i - j;
          i = k - m;
        }
      }
      else
      {
        i = j - i;
        j = k - m;
      }
      paramMotionEvent.setLocation(i, j);
    }
    return paramMotionEvent;
  }
  
  private float getDensity()
  {
    if (sDensity == -1.0F) {
      sDensity = getContext().getResources().getDisplayMetrics().density;
    }
    return sDensity;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject;
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0))
    {
      localObject = this.mOnRotationChangeListener;
      if (localObject != null) {
        this.mCurRotate = ((RotationSeekBar.OnRotationChangeListener)localObject).getCurRotate();
      }
    }
    int i = this.mCurRotate;
    if (i == 0)
    {
      localObject = paramMotionEvent;
      if (i == 360) {}
    }
    else
    {
      localObject = fixTouchMoveEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent((MotionEvent)localObject);
  }
  
  void initUI() {}
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mMarkPercent != null)
    {
      int j = getMeasuredWidth();
      int i = getMeasuredHeight();
      if (this.mMarkPainter == null)
      {
        this.mMarkPainter = new Paint();
        this.mMarkPainter.setStyle(Paint.Style.FILL);
        this.mMarkPainter.setColor(-3355444);
      }
      int k = dpToPx(2.0F);
      int m = i / 2;
      float[] arrayOfFloat = this.mMarkPercent;
      int n = arrayOfFloat.length;
      i = 0;
      while (i < n)
      {
        float f = arrayOfFloat[i];
        if ((f > 0.0F) && (f < 1.0F))
        {
          paramCanvas.save();
          paramCanvas.translate(f * j, m);
          paramCanvas.drawCircle(0.0F, 0.0F, k, this.mMarkPainter);
          paramCanvas.restore();
        }
        i += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void placeMarkerAtPositions(float[] paramArrayOfFloat)
  {
    this.mMarkPercent = paramArrayOfFloat;
  }
  
  public void setOnRotationChangeListener(RotationSeekBar.OnRotationChangeListener paramOnRotationChangeListener)
  {
    this.mOnRotationChangeListener = paramOnRotationChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.RotationSeekBar
 * JD-Core Version:    0.7.0.1
 */