package com.tencent.mobileqq.portal;

import agmd;
import agme;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class FlakeView
  extends View
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfInt.length;
  long jdField_a_of_type_Long;
  public Bitmap a;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  public ArrayList a;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[0];
  Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = { null, null, null, null };
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  boolean jdField_c_of_type_Boolean = true;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = 0L;
  public boolean d;
  public int e;
  private long e;
  public boolean e;
  boolean f = true;
  
  public FlakeView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Long = 1200L;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Long = 1000L;
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        Flake localFlake = Flake.a(getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap, 2, getResources());
        this.jdField_a_of_type_JavaUtilArrayList.add(localFlake);
        this.jdField_d_of_type_Int += 1;
        if (!this.f)
        {
          localFlake.jdField_c_of_type_Float = 0.0F;
          localFlake.d = 0.0F;
        }
      }
      i += 1;
    }
  }
  
  public void a(int paramInt, String... paramVarArgs)
  {
    ThreadManager.post(new agmd(this, paramVarArgs, paramInt), 5, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Long = l;
      this.jdField_b_of_type_Long = l;
      invalidate();
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - (1000.0F * this.jdField_a_of_type_Float));
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramInt)
      {
        int j = (int)(4.0D * Math.random()) % this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length;
        if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] == null) {}
        try
        {
          this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] = BitmapFactory.decodeResource(getResources(), this.jdField_a_of_type_ArrayOfInt[j]);
          if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] != null)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(Flake.a(getWidth(), this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], 1, getResources()));
            this.jdField_b_of_type_Int += 1;
          }
          i += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] = null;
            localOutOfMemoryError.printStackTrace();
          }
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    super.onDraw(paramCanvas);
    long l = System.currentTimeMillis();
    if ((this.jdField_e_of_type_Boolean) && (l - this.jdField_d_of_type_Long > this.jdField_c_of_type_Long)) {
      this.jdField_e_of_type_Boolean = false;
    }
    if (l - this.jdField_b_of_type_Long > this.jdField_e_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_Int < 10)) {
        a(4);
      }
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int < 13)) {
        b(3);
      }
    }
    int m = getHeight();
    int n = getWidth();
    this.jdField_a_of_type_Float = ((float)(l - this.jdField_a_of_type_Long) / 1000.0F);
    this.jdField_a_of_type_Long = l;
    int i = 0;
    int j = k;
    Flake localFlake;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localFlake = (Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localFlake.jdField_c_of_type_Int == 3)
      {
        localFlake.jdField_a_of_type_Float += localFlake.e * this.jdField_a_of_type_Float;
        if ((localFlake.jdField_a_of_type_Float < -localFlake.jdField_a_of_type_Int) || (localFlake.jdField_a_of_type_Float > localFlake.jdField_a_of_type_Int + n))
        {
          this.jdField_e_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localFlake.jdField_b_of_type_Float += localFlake.f * this.jdField_a_of_type_Float + localFlake.g * this.jdField_a_of_type_Float * this.jdField_a_of_type_Float / 2.0F;
        localFlake.f += localFlake.g * this.jdField_a_of_type_Float;
        for (;;)
        {
          localFlake.jdField_c_of_type_Float += localFlake.d * this.jdField_a_of_type_Float;
          if (localFlake.jdField_b_of_type_Float <= localFlake.jdField_b_of_type_Int + m) {
            break;
          }
          localFlake.jdField_a_of_type_Float = ((float)Math.random() * (n - localFlake.jdField_a_of_type_Int));
          if (localFlake.jdField_c_of_type_Int != 1) {
            break label465;
          }
          localFlake.jdField_b_of_type_Float = (0 - localFlake.jdField_b_of_type_Int);
          localFlake.jdField_a_of_type_Float = ((float)Math.random() * (getWidth() - localFlake.jdField_a_of_type_Int));
          break;
          localFlake.jdField_b_of_type_Float += localFlake.f * this.jdField_a_of_type_Float;
        }
        label465:
        if (localFlake.jdField_c_of_type_Int == 2)
        {
          this.jdField_d_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
        else if (localFlake.jdField_c_of_type_Int == 3)
        {
          this.jdField_e_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
        else if (localFlake.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          this.jdField_c_of_type_Int -= 1;
        }
      }
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localFlake = (Flake)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      float f1 = localFlake.jdField_a_of_type_Int * 1.0F / localFlake.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      float f2 = localFlake.jdField_b_of_type_Int * 1.0F / localFlake.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localFlake.jdField_a_of_type_Int / 2 / f1, -localFlake.jdField_b_of_type_Int / 2 / f2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localFlake.jdField_c_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((localFlake.jdField_a_of_type_Int / 2 + localFlake.jdField_a_of_type_Float) / f1, (localFlake.jdField_b_of_type_Int / 2 + localFlake.jdField_b_of_type_Float) / f2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f2);
      paramCanvas.drawBitmap(localFlake.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
      j += 1;
    }
    if (this.jdField_e_of_type_Int <= 0) {
      this.jdField_d_of_type_Boolean = true;
    }
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  public void setHonhBaoSpeed(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Flake localFlake = (Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localFlake == null)
      {
        i += 1;
      }
      else
      {
        if ((localFlake.jdField_c_of_type_Int == 0) || (localFlake.jdField_c_of_type_Int == 2)) {
          switch (paramInt)
          {
          default: 
            localFlake.f = (AIOUtils.a(240.0F, getResources()) + (float)Math.random() * AIOUtils.a(100.0F, getResources()));
          }
        }
        for (;;)
        {
          this.jdField_e_of_type_Long = (1200 - (paramInt - 1) * 200);
          break;
          localFlake.f = (AIOUtils.a(240.0F, getResources()) + (float)Math.random() * AIOUtils.a(100.0F, getResources()));
          continue;
          localFlake.f = (AIOUtils.a(290.0F, getResources()) + (float)Math.random() * AIOUtils.a(100.0F, getResources()));
          continue;
          localFlake.f = (AIOUtils.a(340.0F, getResources()) + (float)Math.random() * AIOUtils.a(100.0F, getResources()));
          continue;
          if (localFlake.jdField_c_of_type_Int == 1) {
            switch (paramInt)
            {
            default: 
              localFlake.f = (AIOUtils.a(230.0F, getResources()) + (float)Math.random() * AIOUtils.a(130.0F, getResources()));
              break;
            case 1: 
              localFlake.f = (AIOUtils.a(230.0F, getResources()) + (float)Math.random() * AIOUtils.a(130.0F, getResources()));
              break;
            case 2: 
              localFlake.f = (AIOUtils.a(280.0F, getResources()) + (float)Math.random() * AIOUtils.a(130.0F, getResources()));
              break;
            case 3: 
              localFlake.f = (AIOUtils.a(295.0F, getResources()) + (float)Math.random() * AIOUtils.a(130.0F, getResources()));
            }
          }
        }
      }
    }
  }
  
  public void setImagePath(String paramString, long paramLong)
  {
    ThreadManager.post(new agme(this, paramString), 5, null, false);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void setRotateCaiDan(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setShowBgHbAnim(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setShowCaiDan(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setShowFullScreenCaidan(long paramLong1, long paramLong2)
  {
    this.jdField_d_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_e_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FlakeView
 * JD-Core Version:    0.7.0.1
 */