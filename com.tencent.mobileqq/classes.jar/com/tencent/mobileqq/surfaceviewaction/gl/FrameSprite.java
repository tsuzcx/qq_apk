package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class FrameSprite
  extends Sprite
{
  private long jdField_a_of_type_Long;
  public FrameSprite.OnFrameEndListener a;
  private LinkedList<Texture> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Texture[] jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public boolean b = false;
  private boolean c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  public int g = 0;
  private int h = 10;
  private int i = -1;
  
  public FrameSprite(SpriteGLView paramSpriteGLView, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture = new Texture[paramArrayOfString.length];
    e(10);
  }
  
  private Texture a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt]);
        Texture localTexture = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt];
        return localTexture;
      }
      return null;
    }
    finally {}
  }
  
  private void a(int paramInt, Texture paramTexture)
  {
    Texture[] arrayOfTexture = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture;
    if ((arrayOfTexture != null) && (arrayOfTexture.length > paramInt)) {
      arrayOfTexture[paramInt] = paramTexture;
    }
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        int j = 0;
        while (j < this.jdField_a_of_type_JavaUtilLinkedList.size())
        {
          ((Texture)this.jdField_a_of_type_JavaUtilLinkedList.get(j)).c();
          j += 1;
        }
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void f(int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length > paramInt) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt] != null))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt]);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt].a();
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null)
    {
      int j = 0;
      for (;;)
      {
        Texture[] arrayOfTexture = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture;
        if (j >= arrayOfTexture.length) {
          break;
        }
        if (arrayOfTexture[j] != null)
        {
          arrayOfTexture[j].c();
          this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[j] = null;
        }
        j += 1;
      }
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
      }
      this.jdField_a_of_type_JavaUtilLinkedList = null;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture = null;
      this.e = true;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
      super.a();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if ((this.c) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null))
    {
      int j = (int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / (1000.0F / this.h));
      int k = this.i;
      if (j > k)
      {
        if (j > k + 1) {
          this.i = (k + 1);
        } else {
          this.i = j;
        }
        j = this.i;
        Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture;
        if (j < localObject.length)
        {
          if ((localObject[j] != null) && (localObject[j].a))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
              this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
            }
            this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = a(this.i);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("FrameSprite: mTexture = ");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture);
              QLog.d("FrameSprite", 2, ((StringBuilder)localObject).toString());
            }
            g();
            super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
            if (QLog.isColorLevel())
            {
              paramArrayOfFloat = new StringBuilder();
              paramArrayOfFloat.append("FrameSprite: draw1:");
              paramArrayOfFloat.append(this.i);
              QLog.d("FrameSprite", 2, paramArrayOfFloat.toString());
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              paramArrayOfFloat = new StringBuilder();
              paramArrayOfFloat.append("FrameSprite: mTexture = null:");
              paramArrayOfFloat.append(this.i);
              QLog.d("FrameSprite", 2, paramArrayOfFloat.toString());
            }
            e();
          }
        }
        else
        {
          if (this.d)
          {
            super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
            if (QLog.isColorLevel())
            {
              paramArrayOfFloat = new StringBuilder();
              paramArrayOfFloat.append("FrameSprite: draw3:");
              paramArrayOfFloat.append(this.i);
              QLog.d("FrameSprite", 2, paramArrayOfFloat.toString());
            }
          }
          else
          {
            this.c = false;
            if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
              this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
            }
          }
          paramArrayOfFloat = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener;
          if (paramArrayOfFloat != null)
          {
            paramArrayOfFloat.a();
            this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
          }
        }
      }
      else
      {
        super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
        if (QLog.isColorLevel())
        {
          paramArrayOfFloat = new StringBuilder();
          paramArrayOfFloat.append("FrameSprite: draw2:");
          paramArrayOfFloat.append(this.i);
          QLog.d("FrameSprite", 2, paramArrayOfFloat.toString());
        }
      }
    }
  }
  
  public void a(Context paramContext, SpriteGLView paramSpriteGLView)
  {
    ThreadManager.post(new FrameSprite.1(this, paramContext, paramSpriteGLView), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void aO_()
  {
    this.c = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.c)
    {
      int j = (int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / (1000.0F / this.h));
      Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture;
      if (j < localObject.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = localObject[j];
      }
      else if (this.b)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[0];
      }
      else if (this.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = localObject[(localObject.length - 1)];
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = null;
        localObject = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener;
        if (localObject != null)
        {
          ((FrameSprite.OnFrameEndListener)localObject).a();
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
        }
      }
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      return;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null) {
      b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    }
  }
  
  public void e(int paramInt)
  {
    this.h = paramInt;
    double d1 = this.h;
    Double.isNaN(d1);
    this.g = ((int)(d1 * 0.8D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite
 * JD-Core Version:    0.7.0.1
 */