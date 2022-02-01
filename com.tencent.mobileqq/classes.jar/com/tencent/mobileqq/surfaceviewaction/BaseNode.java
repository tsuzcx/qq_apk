package com.tencent.mobileqq.surfaceviewaction;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseNode
{
  public String a;
  public float b;
  public float c;
  public float d;
  public float e;
  public float f = 1.0F;
  public float g = 1.0F;
  public float h = 0.0F;
  public int i = 255;
  public int j = 0;
  public int k = 1;
  public boolean l = false;
  public ILayer m;
  public Frame n;
  public int o;
  protected List<Action> p = new ArrayList();
  protected int q;
  protected int r;
  
  public void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void a(Frame paramFrame)
  {
    this.n = paramFrame;
  }
  
  public void a(Point paramPoint)
  {
    float f1 = this.d;
    float f2 = this.e;
    int i1 = this.j;
    if (i1 != 1)
    {
      if (i1 == 2) {
        f1 += this.q / this.g / 2.0F;
      }
    }
    else {
      f1 = this.q / this.g - f1;
    }
    i1 = this.k;
    if (i1 != 0)
    {
      if (i1 == 2) {
        f2 += this.r / this.g / 2.0F;
      }
    }
    else {
      f2 = this.r / this.g - f2;
    }
    for (BaseNode localBaseNode = (BaseNode)this.m; localBaseNode != null; localBaseNode = (BaseNode)localBaseNode.m)
    {
      f1 += localBaseNode.d;
      f2 += localBaseNode.e;
    }
    paramPoint.a = f1;
    paramPoint.b = f2;
  }
  
  public void a(Action... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Action localAction = paramVarArgs[i1];
      localAction.b();
      this.p.add(localAction);
      i1 += 1;
    }
  }
  
  public float b()
  {
    return this.f;
  }
  
  public void b(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void c(int paramInt)
  {
    this.j = paramInt;
  }
  
  public float d()
  {
    BaseNode localBaseNode = (BaseNode)this.m;
    float f1 = 1.0F;
    while (localBaseNode != null)
    {
      f1 *= localBaseNode.f;
      localBaseNode = (BaseNode)localBaseNode.m;
    }
    return f1;
  }
  
  public void d(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void d(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int dq_()
  {
    return this.o;
  }
  
  public boolean ds_()
  {
    return this.l;
  }
  
  public int e()
  {
    BaseNode localBaseNode = (BaseNode)this.m;
    float f1 = 1.0F;
    while (localBaseNode != null)
    {
      f1 *= localBaseNode.i / 255.0F;
      localBaseNode = (BaseNode)localBaseNode.m;
    }
    return (int)(f1 * 255.0F);
  }
  
  public void e(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void f()
  {
    this.p.clear();
  }
  
  public void g()
  {
    int i1 = 0;
    while (i1 < this.p.size())
    {
      ((Action)this.p.get(i1)).d();
      i1 += 1;
    }
  }
  
  public void h()
  {
    int i1 = 0;
    while (i1 < this.p.size())
    {
      ((Action)this.p.get(i1)).e();
      i1 += 1;
    }
  }
  
  protected boolean i()
  {
    int i1 = 0;
    boolean bool1 = false;
    int i2;
    while (i1 < this.p.size())
    {
      Action localAction = (Action)this.p.get(i1);
      if (localAction.a())
      {
        if ((localAction.g & 0x1) != 0)
        {
          this.d = localAction.a;
          this.e = localAction.b;
        }
        if ((localAction.g & 0x2) != 0) {
          this.f = localAction.c;
        }
        if ((localAction.g & 0x4) != 0) {
          this.i = localAction.d;
        }
        if ((localAction.g & 0x8) != 0) {
          this.h = localAction.e;
        }
        bool1 = true;
      }
      i2 = i1;
      if (localAction.j) {
        if (localAction.i)
        {
          localAction.b();
          i2 = i1;
        }
        else
        {
          this.p.remove(i1);
          i2 = i1 - 1;
        }
      }
      i1 = i2 + 1;
    }
    boolean bool2 = bool1;
    if (this.n != null)
    {
      bool2 = bool1;
      if (j() != null)
      {
        i2 = j().getCurrentVideoTime() * this.n.a / 1000;
        i1 = i2;
        if (i2 > 0) {
          i1 = i2 - 1;
        }
        bool2 = bool1;
        if (i1 < this.n.b.length)
        {
          this.d = this.n.b[i1].a;
          this.e = this.n.b[i1].b;
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public abstract ISpriteView j();
  
  public void p_(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.BaseNode
 * JD-Core Version:    0.7.0.1
 */