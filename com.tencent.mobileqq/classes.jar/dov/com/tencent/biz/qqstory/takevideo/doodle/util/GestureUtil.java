package dov.com.tencent.biz.qqstory.takevideo.doodle.util;

import android.view.MotionEvent;

public class GestureUtil
{
  public static float a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    if (!Float.isNaN(paramFloat1)) {
      return paramFloat1;
    }
    return 1.0F;
  }
  
  public static float a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1) {
      return a(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
    }
    return 1.0F;
  }
  
  public static float[] a(MotionEvent paramMotionEvent)
  {
    float[] arrayOfFloat = new float[2];
    if (paramMotionEvent.getPointerCount() > 1)
    {
      arrayOfFloat[0] = ((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F);
      arrayOfFloat[1] = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
    }
    return arrayOfFloat;
  }
  
  public static float b(float paramFloat1, float paramFloat2)
  {
    float f = (float)Math.toDegrees(Math.asin(paramFloat2 / a(paramFloat1, paramFloat2)));
    if (!Float.isNaN(f))
    {
      if ((paramFloat2 >= 0.0F) && (paramFloat1 >= 0.0F)) {}
      do
      {
        return f;
        if ((paramFloat2 >= 0.0F) && (paramFloat1 <= 0.0F)) {
          return 180.0F - f;
        }
      } while ((paramFloat2 <= 0.0F) && (paramFloat1 >= 0.0F));
      if ((paramFloat2 <= 0.0F) && (paramFloat1 <= 0.0F)) {
        return -180.0F - f;
      }
    }
    return 0.0F;
  }
  
  public static float b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1) {
      return b(paramMotionEvent.getX(1) - paramMotionEvent.getX(0), paramMotionEvent.getY(1) - paramMotionEvent.getY(0));
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureUtil
 * JD-Core Version:    0.7.0.1
 */