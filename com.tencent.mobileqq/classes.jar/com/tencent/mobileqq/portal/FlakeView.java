package com.tencent.mobileqq.portal;

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
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  ArrayList<Flake> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = { 2130845435, 2130845436, 2130845433, 2130845434 };
  Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = { null, null, null, null };
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  boolean jdField_c_of_type_Boolean = true;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = 0L;
  boolean jdField_d_of_type_Boolean = true;
  int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 1200L;
  boolean jdField_e_of_type_Boolean = false;
  boolean f = true;
  
  public FlakeView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
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
  
  public void a(int paramInt, Bitmap... paramVarArgs)
  {
    ThreadManager.post(new FlakeView.2(this, paramInt, paramVarArgs), 5, null, false);
  }
  
  public void a(int paramInt, String... paramVarArgs)
  {
    ThreadManager.post(new FlakeView.1(this, paramVarArgs, paramInt), 5, null, false);
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
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - (this.jdField_a_of_type_Float * 1000.0F));
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = (int)(Math.random() * 4.0D);
      Bitmap[] arrayOfBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
      j %= arrayOfBitmap.length;
      if (arrayOfBitmap[j] == null) {
        try
        {
          arrayOfBitmap[j] = BitmapFactory.decodeResource(getResources(), this.jdField_a_of_type_ArrayOfInt[j]);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] = null;
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Flake.a(getWidth(), this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], 1, getResources()));
        this.jdField_b_of_type_Int += 1;
      }
      i += 1;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    super.onDraw(paramCanvas);
    long l = System.currentTimeMillis();
    boolean bool = this.jdField_e_of_type_Boolean;
    int k = 0;
    if ((bool) && (l - this.jdField_d_of_type_Long > this.jdField_c_of_type_Long)) {
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
    int j;
    Flake localFlake;
    float f1;
    float f2;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      localFlake = (Flake)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localFlake.jdField_c_of_type_Int == 3)
      {
        localFlake.jdField_a_of_type_Float += localFlake.e * this.jdField_a_of_type_Float;
        if ((localFlake.jdField_a_of_type_Float >= -localFlake.jdField_a_of_type_Int) && (localFlake.jdField_a_of_type_Float <= localFlake.jdField_a_of_type_Int + n))
        {
          f1 = localFlake.jdField_b_of_type_Float;
          f2 = localFlake.f;
          float f3 = this.jdField_a_of_type_Float;
          float f4 = localFlake.g;
          float f5 = this.jdField_a_of_type_Float;
          localFlake.jdField_b_of_type_Float = (f1 + (f2 * f3 + f4 * f5 * f5 / 2.0F));
          localFlake.f += localFlake.g * this.jdField_a_of_type_Float;
        }
        else
        {
          this.jdField_e_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          break label572;
        }
      }
      else
      {
        localFlake.jdField_b_of_type_Float += localFlake.f * this.jdField_a_of_type_Float;
      }
      localFlake.jdField_c_of_type_Float += localFlake.d * this.jdField_a_of_type_Float;
      if (localFlake.jdField_b_of_type_Float > localFlake.jdField_b_of_type_Int + m)
      {
        localFlake.jdField_a_of_type_Float = ((float)Math.random() * (n - localFlake.jdField_a_of_type_Int));
        if (localFlake.jdField_c_of_type_Int == 1)
        {
          localFlake.jdField_b_of_type_Float = (0 - localFlake.jdField_b_of_type_Int);
          localFlake.jdField_a_of_type_Float = ((float)Math.random() * (getWidth() - localFlake.jdField_a_of_type_Int));
        }
        else if (localFlake.jdField_c_of_type_Int == 2)
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
      label572:
      i += 1;
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localFlake = (Flake)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      f1 = localFlake.jdField_a_of_type_Int * 1.0F / localFlake.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      f2 = localFlake.jdField_b_of_type_Int * 1.0F / localFlake.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
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
      if (localFlake != null)
      {
        if ((localFlake.jdField_c_of_type_Int != 0) && (localFlake.jdField_c_of_type_Int != 2))
        {
          if (localFlake.jdField_c_of_type_Int == 1) {
            if (paramInt != 1)
            {
              if (paramInt != 2)
              {
                if (paramInt != 3) {
                  localFlake.f = (AIOUtils.b(230.0F, getResources()) + (float)Math.random() * AIOUtils.b(130.0F, getResources()));
                } else {
                  localFlake.f = (AIOUtils.b(295.0F, getResources()) + (float)Math.random() * AIOUtils.b(130.0F, getResources()));
                }
              }
              else {
                localFlake.f = (AIOUtils.b(280.0F, getResources()) + (float)Math.random() * AIOUtils.b(130.0F, getResources()));
              }
            }
            else {
              localFlake.f = (AIOUtils.b(230.0F, getResources()) + (float)Math.random() * AIOUtils.b(130.0F, getResources()));
            }
          }
        }
        else if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              localFlake.f = (AIOUtils.b(240.0F, getResources()) + (float)Math.random() * AIOUtils.b(100.0F, getResources()));
            } else {
              localFlake.f = (AIOUtils.b(340.0F, getResources()) + (float)Math.random() * AIOUtils.b(100.0F, getResources()));
            }
          }
          else {
            localFlake.f = (AIOUtils.b(290.0F, getResources()) + (float)Math.random() * AIOUtils.b(100.0F, getResources()));
          }
        }
        else {
          localFlake.f = (AIOUtils.b(240.0F, getResources()) + (float)Math.random() * AIOUtils.b(100.0F, getResources()));
        }
        this.jdField_e_of_type_Long = (1200 - (paramInt - 1) * 200);
      }
      i += 1;
    }
  }
  
  public void setImagePath(String paramString, long paramLong)
  {
    ThreadManager.post(new FlakeView.3(this, paramString), 5, null, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FlakeView
 * JD-Core Version:    0.7.0.1
 */