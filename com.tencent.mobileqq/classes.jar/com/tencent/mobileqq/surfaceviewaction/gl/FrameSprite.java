package com.tencent.mobileqq.surfaceviewaction.gl;

import aipx;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class FrameSprite
  extends Sprite
{
  public int a;
  private long jdField_a_of_type_Long;
  public FrameSprite.OnFrameEndListener a;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public boolean a;
  private Texture[] jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int = 10;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  public FrameSprite(SpriteGLView paramSpriteGLView, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture = new Texture[paramArrayOfString.length];
    a(10);
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
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length > paramInt)) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt] = paramTexture;
    }
  }
  
  private void b(int paramInt)
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
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
        {
          ((Texture)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).c();
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = ((int)(this.jdField_c_of_type_Int * 0.8D));
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    int i;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null))
    {
      i = (int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / (1000.0F / this.jdField_c_of_type_Int));
      if (i <= this.jdField_d_of_type_Int) {
        break label370;
      }
      if (i <= this.jdField_d_of_type_Int + 1) {
        break label220;
      }
      this.jdField_d_of_type_Int += 1;
      if (this.jdField_d_of_type_Int >= this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length) {
        break label268;
      }
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[this.jdField_d_of_type_Int] == null) || (!this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[this.jdField_d_of_type_Int].jdField_a_of_type_Boolean)) {
        break label229;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = a(this.jdField_d_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("FrameSprite", 2, "FrameSprite: mTexture = " + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture);
      }
      g();
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      if (QLog.isColorLevel()) {
        QLog.d("FrameSprite", 2, "FrameSprite: draw1:" + this.jdField_d_of_type_Int);
      }
    }
    label220:
    label229:
    label370:
    do
    {
      for (;;)
      {
        return;
        this.jdField_d_of_type_Int = i;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: mTexture = null:" + this.jdField_d_of_type_Int);
        }
        c();
        return;
        if (this.jdField_d_of_type_Boolean)
        {
          super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
          if (QLog.isColorLevel()) {
            QLog.d("FrameSprite", 2, "FrameSprite: draw3:" + this.jdField_d_of_type_Int);
          }
        }
        while (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
          return;
          this.jdField_c_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
            this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
          }
        }
      }
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    } while (!QLog.isColorLevel());
    label268:
    QLog.d("FrameSprite", 2, "FrameSprite: draw2:" + this.jdField_d_of_type_Int);
  }
  
  public void a(Context paramContext, SpriteGLView paramSpriteGLView)
  {
    ThreadManager.post(new aipx(this, paramContext, paramSpriteGLView), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[i] != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[i].c();
          this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[i] = null;
        }
        i += 1;
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
      super.b();
      return;
    }
    finally {}
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      int i = (int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / (1000.0F / this.jdField_c_of_type_Int));
      if (i >= this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length) {
        break label67;
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[i];
    }
    for (;;)
    {
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      return;
      label67:
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[0];
      }
      else if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length - 1)];
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = null;
        if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
        }
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null) {
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    }
    while (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture == null) {
      return;
    }
    b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite
 * JD-Core Version:    0.7.0.1
 */