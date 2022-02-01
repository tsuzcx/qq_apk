package org.aspectj.runtime.reflect;

import java.util.Stack;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.runtime.internal.AroundClosure;

class JoinPointImpl
  implements ProceedingJoinPoint
{
  Object _this;
  private AroundClosure arc = null;
  private Stack<AroundClosure> arcs = null;
  Object[] args;
  JoinPoint.StaticPart staticPart;
  Object target;
  
  public JoinPointImpl(JoinPoint.StaticPart paramStaticPart, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    this.staticPart = paramStaticPart;
    this._this = paramObject1;
    this.target = paramObject2;
    this.args = paramArrayOfObject;
  }
  
  public Object[] getArgs()
  {
    if (this.args == null) {
      this.args = new Object[0];
    }
    Object[] arrayOfObject1 = this.args;
    Object[] arrayOfObject2 = new Object[arrayOfObject1.length];
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, arrayOfObject1.length);
    return arrayOfObject2;
  }
  
  public String getKind()
  {
    return this.staticPart.getKind();
  }
  
  public Signature getSignature()
  {
    return this.staticPart.getSignature();
  }
  
  public SourceLocation getSourceLocation()
  {
    return this.staticPart.getSourceLocation();
  }
  
  public JoinPoint.StaticPart getStaticPart()
  {
    return this.staticPart;
  }
  
  public Object getTarget()
  {
    return this.target;
  }
  
  public Object getThis()
  {
    return this._this;
  }
  
  public Object proceed()
  {
    Object localObject = this.arcs;
    if (localObject == null)
    {
      localObject = this.arc;
      if (localObject == null) {
        return null;
      }
      return ((AroundClosure)localObject).run(((AroundClosure)localObject).getState());
    }
    return ((AroundClosure)((Stack)localObject).peek()).run(((AroundClosure)this.arcs.peek()).getState());
  }
  
  public Object proceed(Object[] paramArrayOfObject)
  {
    Object localObject = this.arcs;
    if (localObject == null) {
      localObject = this.arc;
    } else {
      localObject = (AroundClosure)((Stack)localObject).peek();
    }
    if (localObject == null) {
      return null;
    }
    int i = ((AroundClosure)localObject).getFlags();
    int i4 = 1;
    int m;
    if ((0x10000 & i) != 0) {
      m = 1;
    } else {
      m = 0;
    }
    int k;
    if ((i & 0x1000) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    int i1;
    if ((i & 0x100) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((i & 0x10) != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i3;
    if ((i & 0x1) != 0) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    Object[] arrayOfObject = ((AroundClosure)localObject).getState();
    int n;
    if ((i2 != 0) && (m == 0)) {
      n = 1;
    } else {
      n = 0;
    }
    if ((k != 0) && (i1 != 0))
    {
      arrayOfObject[0] = paramArrayOfObject[0];
      j = 1;
    }
    else
    {
      j = 0;
    }
    i = j;
    if (i2 != 0)
    {
      i = j;
      if (i3 != 0) {
        if (m != 0)
        {
          i = i1 + 1;
          arrayOfObject[0] = paramArrayOfObject[i1];
        }
        else
        {
          if ((k != 0) && (i1 != 0)) {
            i = 1;
          } else {
            i = 0;
          }
          if ((k != 0) && (i1 != 0)) {
            j = 1;
          } else {
            j = 0;
          }
          if ((i2 != 0) && (i3 != 0) && (m == 0)) {
            m = i4;
          } else {
            m = 0;
          }
          arrayOfObject[k] = paramArrayOfObject[i];
          i = j + m;
        }
      }
    }
    int j = i;
    while (j < paramArrayOfObject.length)
    {
      arrayOfObject[(j - i + (k + 0 + n))] = paramArrayOfObject[j];
      j += 1;
    }
    return ((AroundClosure)localObject).run(arrayOfObject);
  }
  
  public void set$AroundClosure(AroundClosure paramAroundClosure)
  {
    this.arc = paramAroundClosure;
  }
  
  public void stack$AroundClosure(AroundClosure paramAroundClosure)
  {
    if (this.arcs == null) {
      this.arcs = new Stack();
    }
    if (paramAroundClosure == null)
    {
      this.arcs.pop();
      return;
    }
    this.arcs.push(paramAroundClosure);
  }
  
  public final String toLongString()
  {
    return this.staticPart.toLongString();
  }
  
  public final String toShortString()
  {
    return this.staticPart.toShortString();
  }
  
  public final String toString()
  {
    return this.staticPart.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.JoinPointImpl
 * JD-Core Version:    0.7.0.1
 */