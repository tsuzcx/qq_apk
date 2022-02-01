package com.tencent.mobileqq.colornote.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MusicDanceDrawable
  extends Drawable
  implements FloatingWindowDrawable, Runnable
{
  private static List<Double>[] jdField_a_of_type_ArrayOfJavaUtilList;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private List<MusicDanceDrawable.MusicBar> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f = 0;
  
  private static int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public void a(int paramInt)
  {
    if (jdField_a_of_type_ArrayOfJavaUtilList == null)
    {
      jdField_a_of_type_ArrayOfJavaUtilList = new ArrayList[3];
      paramInt = 0;
      while (paramInt < 3)
      {
        jdField_a_of_type_ArrayOfJavaUtilList[paramInt] = new ArrayList();
        paramInt += 1;
      }
      for (double d1 = 0.0D; d1 < 3.141592653589793D; d1 += 0.05D)
      {
        jdField_a_of_type_ArrayOfJavaUtilList[0].add(Double.valueOf(Math.abs(Math.sin(d1 + 0.0D))));
        jdField_a_of_type_ArrayOfJavaUtilList[1].add(Double.valueOf(Math.abs(Math.sin(1.0D + d1))));
        jdField_a_of_type_ArrayOfJavaUtilList[2].add(Double.valueOf(Math.abs(Math.sin(2.0D + d1))));
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      scheduleSelf(this, 0L);
      invalidateSelf();
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicDanceView", 2, "start music animation");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_JavaUtilList.add(new MusicDanceDrawable.MusicBar(this, paramInt1, paramInt2, paramInt3, paramInt4, null));
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, -16777216);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt3);
    this.b = paramInt2;
    this.c = a(2.0F, paramContext.getResources());
    paramContext = (IAppSettingApi)QRoute.api(IAppSettingApi.class);
    if ((this.c < 0) && (paramContext.isDebugVersion())) {
      throw new IllegalStateException("MusicDanceView#mBarPadding mast > 0");
    }
    paramInt3 = (paramInt1 - this.c * 2) / 3;
    paramInt1 = 0;
    while ((this.jdField_a_of_type_JavaUtilList.size() < 3) && (paramInt1 < 3))
    {
      a(0, paramInt2, paramInt3, -1);
      paramInt1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 0;
    this.jdField_a_of_type_Int = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      MusicDanceDrawable.MusicBar localMusicBar = (MusicDanceDrawable.MusicBar)this.jdField_a_of_type_JavaUtilList.get(i);
      paramCanvas.drawRect(this.jdField_a_of_type_Int, this.b - MusicDanceDrawable.MusicBar.a(localMusicBar), this.jdField_a_of_type_Int + MusicDanceDrawable.MusicBar.b(localMusicBar), this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_Int += MusicDanceDrawable.MusicBar.b(localMusicBar) + this.c;
      i += 1;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.d;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        double d1 = ((Double)jdField_a_of_type_ArrayOfJavaUtilList[i].get(this.f)).doubleValue();
        MusicDanceDrawable.MusicBar localMusicBar = (MusicDanceDrawable.MusicBar)this.jdField_a_of_type_JavaUtilList.get(i);
        double d2 = MusicDanceDrawable.MusicBar.c(localMusicBar);
        Double.isNaN(d2);
        localMusicBar.a((int)(d2 * d1));
        i += 1;
      }
      scheduleSelf(this, 50L);
      invalidateSelf();
      this.f += 1;
      if (this.f >= jdField_a_of_type_ArrayOfJavaUtilList[0].size()) {
        this.f = 0;
      }
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void stop()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.MusicDanceDrawable
 * JD-Core Version:    0.7.0.1
 */