package com.tencent.xaction.drawable.partical;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/StormPartical;", "", "duration", "", "(I)V", "TAG", "", "bitmap", "Landroid/graphics/Bitmap;", "data", "Lcom/tencent/xaction/drawable/partical/StormPartical$ParticalData;", "getData", "()Lcom/tencent/xaction/drawable/partical/StormPartical$ParticalData;", "isInit", "", "paint", "Landroid/graphics/Paint;", "size", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "vars", "drawRect", "color", "alpha", "x", "y", "width", "height", "elevation", "z", "frame", "process", "project3D", "Lcom/tencent/xaction/drawable/partical/StormPartical$Point;", "_x", "_y", "_z", "spawnParticle", "i", "storm", "ParticalData", "Point", "Point3D", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class StormPartical
{
  private final String a = "StormPartical";
  @NotNull
  private final StormPartical.ParticalData b = new StormPartical.ParticalData();
  private double c;
  private Paint d = new Paint();
  private boolean e;
  private Bitmap f;
  
  public StormPartical(int paramInt)
  {
    StormPartical.ParticalData localParticalData = this.b;
    double d1 = paramInt;
    Double.isNaN(d1);
    localParticalData.e((int)(d1 / 16.600000000000001D) - 27);
  }
  
  private final void a(StormPartical.ParticalData paramParticalData, Canvas paramCanvas)
  {
    int j = paramParticalData.h().size();
    int i = 0;
    while (i < j)
    {
      double d1 = ((StormPartical.Point3D)paramParticalData.h().get(i)).a();
      double d2 = ((StormPartical.Point3D)paramParticalData.h().get(i)).b();
      double d3 = ((StormPartical.Point3D)paramParticalData.h().get(i)).c();
      double d4 = 35;
      Double.isNaN(d4);
      StormPartical.Point localPoint = a(d1, d2 - d4, d3, paramParticalData);
      if (localPoint.c() != -1.0D)
      {
        ((StormPartical.Point3D)paramParticalData.h().get(i)).a(localPoint.c());
        d1 = 20;
        d2 = ((StormPartical.Point3D)paramParticalData.h().get(i)).d();
        Double.isNaN(d1);
        d3 = 1;
        d4 = localPoint.c();
        Double.isNaN(d3);
        d1 = d1 * d2 / (d4 + d3);
        d2 = 10;
        Double.isNaN(d2);
        this.c = (d1 + d2);
        d4 = Math.abs(((StormPartical.Point3D)paramParticalData.h().get(i)).b());
        d1 = 0.8F;
        double d5 = paramParticalData.l();
        d2 = 2;
        Double.isNaN(d2);
        d4 = Math.pow(d4 / (d5 / d2), 1000.0D);
        Double.isNaN(d1);
        Double.isNaN(d1);
        d1 -= d4 * d1;
        if (paramParticalData.m() > paramParticalData.p())
        {
          d1 = paramParticalData.m() - paramParticalData.p();
          Double.isNaN(d1);
          d1 /= 25.0D;
          Double.isNaN(d3);
          d1 = d3 - d1;
        }
        if (d1 >= 0)
        {
          if ((d1 < 0.0D) || (d1 > 1.0D)) {
            d1 = 0.0D;
          }
          d3 = localPoint.a();
          d4 = -1;
          if ((d3 > d4) && (localPoint.a() < paramCanvas.getWidth()) && (localPoint.b() > d4) && (localPoint.b() < paramCanvas.getHeight()))
          {
            d3 = localPoint.a();
            d4 = this.c;
            Double.isNaN(d2);
            d4 /= d2;
            d5 = localPoint.b();
            double d6 = this.c;
            Double.isNaN(d2);
            a(paramCanvas, 0, d1, d3 - d4, d5 - d6 / d2, d6, d6);
          }
        }
      }
      i += 1;
    }
    CollectionsKt.sortWith((List)paramParticalData.h(), (Comparator)StormPartical.storm.1.a);
  }
  
  public final double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    paramDouble1 = Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2 + paramDouble3 * paramDouble3);
    if (paramDouble1 != 0.0D)
    {
      paramDouble1 = paramDouble3 / paramDouble1;
      if ((paramDouble1 >= -1) && (paramDouble1 <= 1)) {
        return Math.acos(paramDouble1);
      }
    }
    return 1.0E-008D;
  }
  
  @NotNull
  public final StormPartical.ParticalData a()
  {
    return this.b;
  }
  
  @NotNull
  public final StormPartical.Point a(double paramDouble1, double paramDouble2, double paramDouble3, @NotNull StormPartical.ParticalData paramParticalData)
  {
    Intrinsics.checkParameterIsNotNull(paramParticalData, "vars");
    paramDouble1 -= paramParticalData.a();
    paramDouble2 -= paramParticalData.b();
    double d1 = paramDouble3 - paramParticalData.c();
    paramDouble3 = Math.atan2(paramDouble1, d1);
    d1 = Math.sqrt(paramDouble1 * paramDouble1 + d1 * d1);
    paramDouble1 = Math.sin(paramDouble3 - paramParticalData.d()) * d1;
    d1 = Math.cos(paramDouble3 - paramParticalData.d()) * d1;
    paramDouble3 = Math.atan2(paramDouble2, d1);
    d1 = Math.sqrt(paramDouble2 * paramDouble2 + d1 * d1);
    paramDouble2 = Math.sin(paramDouble3 - paramParticalData.n()) * d1;
    paramDouble3 = Math.cos(paramDouble3 - paramParticalData.n()) * d1;
    double d3 = 0;
    Double.isNaN(d3);
    double d2 = paramDouble3 - d3;
    d1 = 2000;
    Double.isNaN(d1);
    Double.isNaN(d3);
    double d5 = paramDouble1 - d3;
    double d4 = 0;
    Double.isNaN(d4);
    d4 = d2 * d1 - d4 * d5;
    double d6 = 1;
    Double.isNaN(d6);
    double d7 = -1000;
    Double.isNaN(d7);
    d2 = (d5 * d6 - d2 * d7) / d4;
    d5 = 2000;
    Double.isNaN(d5);
    d4 = d5 / d4;
    if (d2 > d3)
    {
      d5 = 1;
      if ((d2 < d5) && (d4 > d3) && (d4 < d5))
      {
        d3 = paramParticalData.e();
        d4 = -1000;
        Double.isNaN(d1);
        Double.isNaN(d4);
        d5 = paramParticalData.g();
        Double.isNaN(d5);
        Double.isNaN(d3);
        d6 = paramParticalData.f();
        d7 = paramDouble2 / paramDouble3;
        double d8 = paramParticalData.g();
        Double.isNaN(d8);
        Double.isNaN(d6);
        return new StormPartical.Point(d3 + (d4 + d2 * d1) * d5, d6 + d7 * d8, paramDouble3 * paramDouble3 + (paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2));
      }
    }
    return new StormPartical.Point(0.0D, 0.0D, -1.0D);
  }
  
  public final void a(@NotNull Canvas paramCanvas, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Object localObject = this.d;
    double d1 = 'ÿ';
    Double.isNaN(d1);
    ((Paint)localObject).setAlpha((int)(paramDouble1 * d1));
    localObject = new Rect((int)paramDouble2, (int)paramDouble3, (int)(paramDouble2 + paramDouble4), (int)(paramDouble3 + paramDouble5));
    paramCanvas.drawBitmap(this.f, null, (Rect)localObject, this.d);
  }
  
  public final void a(@NotNull Canvas paramCanvas, @Nullable Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (paramBitmap == null) {
      return;
    }
    this.f = paramBitmap;
    paramBitmap = this.b;
    paramBitmap.d(paramBitmap.m() + 1);
    if (!this.e)
    {
      this.e = true;
      paramBitmap = this.b;
      paramBitmap.f(a(paramBitmap.a(), this.b.c(), this.b.b()) - 1.570796326794897D);
      this.b.a(paramCanvas.getWidth() / 2);
      paramBitmap = this.b;
      double d1 = paramCanvas.getHeight();
      Double.isNaN(d1);
      paramBitmap.b((int)(d1 / 1.5D));
      this.b.f(paramCanvas.getHeight());
      this.b.e(100.0D);
    }
    a(this.b);
    a(paramCanvas, this.b);
  }
  
  public final void a(@NotNull Canvas paramCanvas, @NotNull StormPartical.ParticalData paramParticalData)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramParticalData, "vars");
    a(paramParticalData, paramCanvas);
  }
  
  public final void a(@NotNull StormPartical.ParticalData paramParticalData)
  {
    Intrinsics.checkParameterIsNotNull(paramParticalData, "vars");
    if (paramParticalData.h().size() < paramParticalData.i())
    {
      int i = 0;
      int j = paramParticalData.i();
      if (j >= 0) {
        for (;;)
        {
          a(paramParticalData, i);
          if (i == j) {
            break;
          }
          i += 1;
        }
      }
    }
    double d1 = Math.atan2(paramParticalData.a(), paramParticalData.c());
    double d2 = Math.sqrt(paramParticalData.a() * paramParticalData.a() + paramParticalData.c() * paramParticalData.c()) - 0.008D;
    double d3 = d1 - 0.03333333333333333D;
    paramParticalData.a(Math.sin(d3) * d2);
    paramParticalData.c(Math.cos(d3) * d2);
    paramParticalData.b(0.0D);
    paramParticalData.d(d1 + 3.141592653589793D - 0.03333333333333333D);
    paramParticalData.f(a(paramParticalData.a(), paramParticalData.c(), paramParticalData.b()) - 1.570796326794897D);
  }
  
  public final void a(@NotNull StormPartical.ParticalData paramParticalData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParticalData, "vars");
    double d3 = Math.random() * 6.283185307179586D;
    double d1 = Math.random();
    double d2 = paramParticalData.k();
    Double.isNaN(d2);
    d1 = Math.sqrt(d1 * d2);
    d2 = Math.sin(d3);
    double d4 = paramInt;
    Double.isNaN(d4);
    double d5 = paramParticalData.i();
    Double.isNaN(d5);
    d4 = d4 * 1.0D / d5;
    d5 = paramParticalData.l();
    double d6 = paramParticalData.j() / 120;
    double d7 = Math.random();
    double d8 = paramParticalData.j();
    Double.isNaN(d8);
    Double.isNaN(d6);
    d3 = Math.cos(d3);
    double d9 = 100;
    double d10 = 800;
    double d11 = Math.random();
    Double.isNaN(d10);
    Double.isNaN(d9);
    paramParticalData.h().add(new StormPartical.Point3D(d2 * d1, d5 * d4, d7 * d8 + d6, d3 * d1, d9 + d10 * d11, 0.0D, 0.0D));
  }
  
  public final void b()
  {
    Bitmap localBitmap = this.f;
    if (localBitmap != null)
    {
      if (localBitmap == null) {
        Intrinsics.throwNpe();
      }
      if (localBitmap.isRecycled())
      {
        localBitmap = this.f;
        if (localBitmap == null) {
          Intrinsics.throwNpe();
        }
        localBitmap.recycle();
        this.f = ((Bitmap)null);
      }
    }
    this.b.h().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.StormPartical
 * JD-Core Version:    0.7.0.1
 */