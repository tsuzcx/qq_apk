package com.tencent.mobileqq.dinifly;

import android.graphics.ColorFilter;
import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.value.ScaleXY;

public abstract interface LottieProperty
{
  public static final Integer COLOR = Integer.valueOf(1);
  public static final ColorFilter COLOR_FILTER = new ColorFilter();
  public static final Float CORNER_RADIUS;
  public static final PointF ELLIPSE_SIZE;
  public static final Integer[] GRADIENT_COLOR = new Integer[0];
  public static final Integer OPACITY;
  public static final Float POLYSTAR_INNER_RADIUS;
  public static final Float POLYSTAR_INNER_ROUNDEDNESS;
  public static final Float POLYSTAR_OUTER_RADIUS;
  public static final Float POLYSTAR_OUTER_ROUNDEDNESS;
  public static final Float POLYSTAR_POINTS;
  public static final Float POLYSTAR_ROTATION;
  public static final PointF POSITION;
  public static final PointF RECTANGLE_SIZE;
  public static final Float REPEATER_COPIES;
  public static final Float REPEATER_OFFSET;
  public static final Integer STROKE_COLOR = Integer.valueOf(2);
  public static final Float STROKE_WIDTH;
  public static final Float TEXT_TRACKING;
  public static final Float TIME_REMAP;
  public static final PointF TRANSFORM_ANCHOR_POINT;
  public static final Float TRANSFORM_END_OPACITY;
  public static final Integer TRANSFORM_OPACITY = Integer.valueOf(3);
  public static final PointF TRANSFORM_POSITION;
  public static final Float TRANSFORM_ROTATION;
  public static final ScaleXY TRANSFORM_SCALE;
  public static final Float TRANSFORM_SKEW;
  public static final Float TRANSFORM_SKEW_ANGLE;
  public static final Float TRANSFORM_START_OPACITY;
  
  static
  {
    OPACITY = Integer.valueOf(4);
    TRANSFORM_ANCHOR_POINT = new PointF();
    TRANSFORM_POSITION = new PointF();
    ELLIPSE_SIZE = new PointF();
    RECTANGLE_SIZE = new PointF();
    CORNER_RADIUS = Float.valueOf(0.0F);
    POSITION = new PointF();
    TRANSFORM_SCALE = new ScaleXY();
    TRANSFORM_ROTATION = Float.valueOf(1.0F);
    TRANSFORM_SKEW = Float.valueOf(0.0F);
    TRANSFORM_SKEW_ANGLE = Float.valueOf(0.0F);
    STROKE_WIDTH = Float.valueOf(2.0F);
    TEXT_TRACKING = Float.valueOf(3.0F);
    REPEATER_COPIES = Float.valueOf(4.0F);
    REPEATER_OFFSET = Float.valueOf(5.0F);
    POLYSTAR_POINTS = Float.valueOf(6.0F);
    POLYSTAR_ROTATION = Float.valueOf(7.0F);
    POLYSTAR_INNER_RADIUS = Float.valueOf(8.0F);
    POLYSTAR_OUTER_RADIUS = Float.valueOf(9.0F);
    POLYSTAR_INNER_ROUNDEDNESS = Float.valueOf(10.0F);
    POLYSTAR_OUTER_ROUNDEDNESS = Float.valueOf(11.0F);
    TRANSFORM_START_OPACITY = Float.valueOf(12.0F);
    TRANSFORM_END_OPACITY = Float.valueOf(12.0F);
    TIME_REMAP = Float.valueOf(13.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieProperty
 * JD-Core Version:    0.7.0.1
 */