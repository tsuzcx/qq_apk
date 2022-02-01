package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class FrameSprite
  extends Sprite
{
  private int E = 10;
  private Texture[] F;
  private String[] G;
  private boolean H;
  private long I;
  private int J = -1;
  private LinkedList<Texture> K = new LinkedList();
  private boolean L = false;
  private boolean M = false;
  private boolean N = false;
  public int s = 0;
  public boolean t = false;
  public FrameSprite.OnFrameEndListener u;
  
  public FrameSprite(SpriteGLView paramSpriteGLView, String[] paramArrayOfString)
  {
    this.v = paramSpriteGLView;
    this.G = paramArrayOfString;
    this.F = new Texture[paramArrayOfString.length];
    e(10);
  }
  
  private void a(int paramInt, Texture paramTexture)
  {
    Texture[] arrayOfTexture = this.F;
    if ((arrayOfTexture != null) && (arrayOfTexture.length > paramInt)) {
      arrayOfTexture[paramInt] = paramTexture;
    }
  }
  
  private void f(int paramInt)
  {
    try
    {
      if ((this.K != null) && (this.F != null) && (this.F.length > paramInt) && (this.F[paramInt] != null))
      {
        this.K.add(this.F[paramInt]);
        this.F[paramInt].a();
      }
      return;
    }
    finally {}
  }
  
  private Texture g(int paramInt)
  {
    try
    {
      if (this.K != null)
      {
        this.K.remove(this.F[paramInt]);
        Texture localTexture = this.F[paramInt];
        return localTexture;
      }
      return null;
    }
    finally {}
  }
  
  private void r()
  {
    try
    {
      if (this.K != null)
      {
        int i = 0;
        while (i < this.K.size())
        {
          ((Texture)this.K.get(i)).c();
          i += 1;
        }
        this.K.clear();
      }
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
    if ((this.H) && (this.F != null))
    {
      int i = (int)((float)(System.currentTimeMillis() - this.I) / (1000.0F / this.E));
      int j = this.J;
      if (i > j)
      {
        if (i > j + 1) {
          this.J = (j + 1);
        } else {
          this.J = i;
        }
        i = this.J;
        Object localObject = this.F;
        if (i < localObject.length)
        {
          if ((localObject[i] != null) && (localObject[i].c))
          {
            if (this.w != null) {
              this.w.c();
            }
            this.w = g(this.J);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("FrameSprite: mTexture = ");
              ((StringBuilder)localObject).append(this.w);
              QLog.d("FrameSprite", 2, ((StringBuilder)localObject).toString());
            }
            m();
            super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
            if (QLog.isColorLevel())
            {
              paramArrayOfFloat = new StringBuilder();
              paramArrayOfFloat.append("FrameSprite: draw1:");
              paramArrayOfFloat.append(this.J);
              QLog.d("FrameSprite", 2, paramArrayOfFloat.toString());
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              paramArrayOfFloat = new StringBuilder();
              paramArrayOfFloat.append("FrameSprite: mTexture = null:");
              paramArrayOfFloat.append(this.J);
              QLog.d("FrameSprite", 2, paramArrayOfFloat.toString());
            }
            r();
          }
        }
        else
        {
          if (this.L)
          {
            super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
            if (QLog.isColorLevel())
            {
              paramArrayOfFloat = new StringBuilder();
              paramArrayOfFloat.append("FrameSprite: draw3:");
              paramArrayOfFloat.append(this.J);
              QLog.d("FrameSprite", 2, paramArrayOfFloat.toString());
            }
          }
          else
          {
            this.H = false;
            if (this.w != null) {
              this.w.c();
            }
          }
          paramArrayOfFloat = this.u;
          if (paramArrayOfFloat != null)
          {
            paramArrayOfFloat.a();
            this.u = null;
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
          paramArrayOfFloat.append(this.J);
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
    this.L = paramBoolean;
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.H)
    {
      int i = (int)((float)(System.currentTimeMillis() - this.I) / (1000.0F / this.E));
      Object localObject = this.F;
      if (i < localObject.length)
      {
        this.w = localObject[i];
      }
      else if (this.t)
      {
        this.I = System.currentTimeMillis();
        this.w = this.F[0];
      }
      else if (this.L)
      {
        this.w = localObject[(localObject.length - 1)];
      }
      else
      {
        this.w = null;
        localObject = this.u;
        if (localObject != null)
        {
          ((FrameSprite.OnFrameEndListener)localObject).a();
          this.u = null;
        }
      }
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.G != null)
    {
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      return;
    }
    if (this.F != null) {
      b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    }
  }
  
  public void dp_()
  {
    this.H = true;
    this.I = System.currentTimeMillis();
  }
  
  public void e(int paramInt)
  {
    this.E = paramInt;
    double d = this.E;
    Double.isNaN(d);
    this.s = ((int)(d * 0.8D));
  }
  
  public void f()
  {
    if (this.F != null)
    {
      int i = 0;
      for (;;)
      {
        Texture[] arrayOfTexture = this.F;
        if (i >= arrayOfTexture.length) {
          break;
        }
        if (arrayOfTexture[i] != null)
        {
          arrayOfTexture[i].c();
          this.F[i] = null;
        }
        i += 1;
      }
    }
    try
    {
      if (this.K != null) {
        this.K.clear();
      }
      this.K = null;
      this.F = null;
      this.M = true;
      this.u = null;
      super.f();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite
 * JD-Core Version:    0.7.0.1
 */