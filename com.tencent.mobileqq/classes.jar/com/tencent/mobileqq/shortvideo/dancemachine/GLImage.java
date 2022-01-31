package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class GLImage
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  
  public GLImage()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public GLImage(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public GLImage(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  private boolean a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == this.jdField_a_of_type_Int)
    {
      bool1 = bool2;
      if (paramInt2 == this.jdField_b_of_type_Int)
      {
        GLES20.glBindTexture(3553, this.c);
        if (paramBitmap != null) {
          GLUtils.texImage2D(3553, 0, paramBitmap, 0);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    if (this.c != 0)
    {
      GLES20.glDeleteTextures(1, new int[] { this.c }, 0);
      this.c = 0;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(Bitmap paramBitmap)
  {
    a(paramBitmap, true);
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap != null)
    {
      if (this.c == 0) {
        break label40;
      }
      if (!a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap)) {
        break label36;
      }
      if (paramBoolean) {
        paramBitmap.recycle();
      }
    }
    label36:
    label40:
    do
    {
      return;
      a();
      this.jdField_a_of_type_Int = paramBitmap.getWidth();
      this.jdField_b_of_type_Int = paramBitmap.getHeight();
      this.c = GlUtil.a(3553, paramBitmap);
    } while (!paramBoolean);
    paramBitmap.recycle();
  }
  
  public void a(String paramString)
  {
    a(FileUtils.a(paramString, false));
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLImage
 * JD-Core Version:    0.7.0.1
 */