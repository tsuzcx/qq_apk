package com.tencent.plato.sdk.utils;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import java.util.ArrayList;

public class DrawableUtils
{
  private static final int STD_VALUE = 100;
  
  public static Drawable createDrawable(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 0)
    {
      if ((paramArrayOfInt1[0] == paramArrayOfInt1[1]) && (paramArrayOfInt1[1] == paramArrayOfInt1[2]) && (paramArrayOfInt1[2] == paramArrayOfInt1[3]) && (paramArrayOfInt2[0] == paramArrayOfInt2[1]) && (paramArrayOfInt2[1] == paramArrayOfInt2[2]) && (paramArrayOfInt2[2] == paramArrayOfInt2[3]))
      {
        localObject = new ShapeDrawable();
        ((ShapeDrawable)localObject).setShape(new RectShape());
        ((ShapeDrawable)localObject).getPaint().setStyle(Paint.Style.STROKE);
        ((ShapeDrawable)localObject).getPaint().setColor(paramArrayOfInt2[0]);
        ((ShapeDrawable)localObject).getPaint().setStrokeWidth(paramArrayOfInt1[0]);
        if (paramInt1 == 0) {
          return localObject;
        }
        paramArrayOfInt1 = new ShapeDrawable();
        paramArrayOfInt1.setShape(new RectShape());
        paramArrayOfInt1.getPaint().setStyle(Paint.Style.FILL);
        paramArrayOfInt1.getPaint().setColor(paramInt1);
        return new LayerDrawable(new ShapeDrawable[] { paramArrayOfInt1, localObject });
      }
      Object localObject = new ArrayList();
      ShapeDrawable localShapeDrawable = new ShapeDrawable();
      localShapeDrawable.setShape(new RectShape());
      localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
      localShapeDrawable.getPaint().setColor(paramInt1);
      ((ArrayList)localObject).add(localShapeDrawable);
      paramInt1 = 0;
      while (paramInt1 < 4) {
        if (paramArrayOfInt1[paramInt1] <= 0)
        {
          paramInt1 += 1;
        }
        else
        {
          localShapeDrawable = new ShapeDrawable();
          Path localPath = new Path();
          switch (paramInt1)
          {
          }
          for (;;)
          {
            localPath.close();
            localShapeDrawable.setShape(new PathShape(localPath, paramInt3, paramInt4));
            localShapeDrawable.getPaint().setStrokeWidth(paramArrayOfInt1[paramInt1]);
            localShapeDrawable.getPaint().setAntiAlias(false);
            localShapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
            localShapeDrawable.getPaint().setColor(paramArrayOfInt2[paramInt1]);
            ((ArrayList)localObject).add(localShapeDrawable);
            break;
            localPath.lineTo(paramInt3, 0.0F);
            continue;
            localPath.moveTo(paramInt3, 0.0F);
            localPath.lineTo(paramInt3, paramInt4);
            continue;
            localPath.moveTo(0.0F, paramInt4);
            localPath.lineTo(paramInt3, paramInt4);
            continue;
            localPath.lineTo(0.0F, paramInt4);
          }
        }
      }
      paramArrayOfInt1 = new ShapeDrawable[((ArrayList)localObject).size()];
      ((ArrayList)localObject).toArray(paramArrayOfInt1);
      return new LayerDrawable(paramArrayOfInt1);
    }
    return null;
  }
  
  public static GradientDrawable createDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt3);
    localGradientDrawable.setCornerRadius(paramInt4);
    localGradientDrawable.setStroke(paramInt1, paramInt2);
    return localGradientDrawable;
  }
  
  public static GradientDrawable createDrawables(int paramInt1, int paramInt2, int[] paramArrayOfInt, GradientDrawable.Orientation paramOrientation, int paramInt3)
  {
    paramArrayOfInt = new GradientDrawable(paramOrientation, paramArrayOfInt);
    paramArrayOfInt.setCornerRadius(paramInt3);
    paramArrayOfInt.setStroke(paramInt1, paramInt2);
    return paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.DrawableUtils
 * JD-Core Version:    0.7.0.1
 */