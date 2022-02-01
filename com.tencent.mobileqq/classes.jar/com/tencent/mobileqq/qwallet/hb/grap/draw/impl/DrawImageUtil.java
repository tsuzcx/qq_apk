package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.doodle.DoodleItem;
import com.tencent.mobileqq.activity.aio.doodle.DoodleParam;
import com.tencent.mobileqq.activity.aio.doodle.PathData;
import com.tencent.mobileqq.activity.aio.doodle.PathData.PointData;
import java.util.ArrayList;
import java.util.Iterator;

public class DrawImageUtil
{
  public static Bitmap a(DoodleItem paramDoodleItem, int paramInt1, int paramInt2, float paramFloat)
  {
    if ((paramDoodleItem != null) && (paramDoodleItem.c() != null) && (paramDoodleItem.c().size() > 0)) {}
    for (;;)
    {
      float f6;
      float f2;
      float f7;
      float f4;
      try
      {
        int i = paramDoodleItem.a().a().width();
        int j = paramDoodleItem.a().a().height();
        Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawColor(-1);
        Paint localPaint = new Paint(7);
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setColor(-16777216);
        localPaint.setStrokeWidth(paramFloat);
        localPaint.setStrokeCap(Paint.Cap.ROUND);
        localPaint.setStrokeJoin(Paint.Join.ROUND);
        f6 = i;
        f2 = j;
        Object localObject1 = paramDoodleItem.c().iterator();
        f7 = 0.0F;
        f4 = 0.0F;
        if (!((Iterator)localObject1).hasNext()) {
          break label581;
        }
        Object localObject2 = ((PathData)((Iterator)localObject1).next()).e().iterator();
        float f1 = f4;
        float f3 = f7;
        paramFloat = f2;
        float f5 = f6;
        f6 = f5;
        f2 = paramFloat;
        f7 = f3;
        f4 = f1;
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        Object localObject3 = (PathData.PointData)((Iterator)localObject2).next();
        f2 = f5;
        if (((PathData.PointData)localObject3).a() < f5) {
          f2 = ((PathData.PointData)localObject3).a();
        }
        f4 = f3;
        if (((PathData.PointData)localObject3).a() > f3) {
          f4 = ((PathData.PointData)localObject3).a();
        }
        f6 = paramFloat;
        if (((PathData.PointData)localObject3).b() < paramFloat) {
          f6 = ((PathData.PointData)localObject3).b();
        }
        f5 = f2;
        paramFloat = f6;
        f3 = f4;
        if (((PathData.PointData)localObject3).b() <= f1) {
          continue;
        }
        f1 = ((PathData.PointData)localObject3).b();
        f5 = f2;
        paramFloat = f6;
        f3 = f4;
        continue;
        paramFloat = f7 - f6;
        f4 -= f2;
        f1 = Math.max(paramFloat, f4);
        f3 = f6 - (f1 - paramFloat) / 2.0F;
        f2 -= (f1 - f4) / 2.0F;
        localObject2 = new Path();
        paramFloat = paramInt1 / f1;
        f4 = paramInt2 / f1;
        localObject3 = paramDoodleItem.c().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          PathData localPathData = (PathData)((Iterator)localObject3).next();
          paramDoodleItem = localPathData.g();
          if (paramDoodleItem == null) {
            continue;
          }
          ((Path)localObject2).moveTo((paramDoodleItem.a() - f3) * paramFloat, (paramDoodleItem.b() - f2) * f4);
          ArrayList localArrayList = localPathData.e();
          paramInt1 = 1;
          f1 = paramFloat;
          paramFloat = f1;
          if (paramInt1 >= localPathData.d()) {
            continue;
          }
          localObject1 = (PathData.PointData)localArrayList.get(paramInt1);
          ((Path)localObject2).quadTo((paramDoodleItem.a() - f3) * f1, (paramDoodleItem.b() - f2) * f4, (((PathData.PointData)localObject1).a() - f3) * f1, (((PathData.PointData)localObject1).b() - f2) * f4);
          paramInt1 += 1;
          paramDoodleItem = (DoodleItem)localObject1;
          continue;
        }
        localCanvas.drawPath((Path)localObject2, localPaint);
        return localBitmap;
      }
      catch (Throwable paramDoodleItem)
      {
        paramDoodleItem.printStackTrace();
        return null;
      }
      return null;
      return null;
      label581:
      if (f6 <= f7) {
        if (f2 <= f4) {}
      }
    }
  }
  
  public static void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawImageUtil
 * JD-Core Version:    0.7.0.1
 */