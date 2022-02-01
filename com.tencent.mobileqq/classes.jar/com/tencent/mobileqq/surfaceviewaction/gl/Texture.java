package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Texture
{
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private SpriteGLView jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public boolean b = false;
  
  public Texture(Context paramContext, SpriteGLView paramSpriteGLView, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_ArrayOfByte = a(paramString);
      return;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Texture", 2, QLog.getStackTraceString(paramContext));
      }
    }
  }
  
  public Texture(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = true;
    paramSpriteGLView.b(new Texture.1(this));
  }
  
  private byte[] a(String paramString)
  {
    paramString = new File(paramString);
    long l = paramString.length();
    if (l > 2147483647L) {
      return null;
    }
    Object localObject = new FileInputStream(paramString);
    int i = (int)l;
    for (;;)
    {
      try
      {
        arrayOfByte = new byte[i];
        i = 0;
      }
      catch (OutOfMemoryError paramString)
      {
        byte[] arrayOfByte;
        continue;
      }
      try
      {
        if (i < arrayOfByte.length)
        {
          int j = ((FileInputStream)localObject).read(arrayOfByte, i, arrayOfByte.length - i);
          if (j >= 0)
          {
            i += j;
            continue;
          }
        }
        if (i == arrayOfByte.length)
        {
          ((FileInputStream)localObject).close();
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("getContent: filePath = ");
            paramString.append(this.jdField_a_of_type_JavaLangString);
            QLog.d("Texture", 2, paramString.toString());
          }
          return arrayOfByte;
        }
        ((FileInputStream)localObject).close();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Could not completely read file ");
        ((StringBuilder)localObject).append(paramString.getName());
        throw new IOException(((StringBuilder)localObject).toString());
      }
      catch (IOException localIOException) {}
    }
    ((FileInputStream)localObject).close();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Could not completely read file ");
    ((StringBuilder)localObject).append(paramString.getName());
    throw new IOException(((StringBuilder)localObject).toString());
    ((FileInputStream)localObject).close();
    paramString = new StringBuilder();
    paramString.append("No enought memory to new bytes: ");
    paramString.append(l);
    paramString = new IOException(paramString.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      try
      {
        long l = System.currentTimeMillis();
        Object localObject = new BitmapFactory.Options();
        if (Build.VERSION.SDK_INT > 19) {
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
        } else {
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_4444;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeByteArray(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length, (BitmapFactory.Options)localObject);
        int i = (int)(System.currentTimeMillis() - l);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("new Texture: decode time = ");
          ((StringBuilder)localObject).append(i);
          QLog.d("Texture", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new Texture.2(this));
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Texture: cannot decode (");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("): ");
          localStringBuilder.append(QLog.getStackTraceString(localOutOfMemoryError));
          QLog.d("Texture", 2, localStringBuilder.toString());
        }
      }
      this.jdField_a_of_type_ArrayOfByte = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Texture.3 local3 = new Texture.3(this);
    if (paramBoolean)
    {
      local3.run();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(local3);
  }
  
  void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      if (this.b) {
        return;
      }
      localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = localObject[0];
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(this.jdField_a_of_type_Int);
      GLES20.glBindTexture(3553, this.jdField_a_of_type_Int);
      GLUtils.texImage2D(3553, 0, this.jdField_a_of_type_AndroidGraphicsBitmap, 0);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glBindTexture(3553, 0);
      if (!this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.c) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.b = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Texture->load: textureId = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(", filePath = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("Texture", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void c()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Texture
 * JD-Core Version:    0.7.0.1
 */