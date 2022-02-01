package com.tencent.mtt.hippy.dom;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

public class b
{
  private final SparseArray<com.tencent.mtt.hippy.dom.node.b> a = new SparseArray();
  private SparseBooleanArray b = new SparseBooleanArray();
  
  public int a()
  {
    try
    {
      int i = this.b.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.a.remove(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    try
    {
      int i = paramb.getId();
      this.a.put(i, paramb);
      this.b.put(i, true);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public void b()
  {
    try
    {
      this.a.clear();
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.a.remove(paramInt);
      this.b.delete(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    try
    {
      this.a.put(paramb.getId(), paramb);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public com.tencent.mtt.hippy.dom.node.b c(int paramInt)
  {
    try
    {
      com.tencent.mtt.hippy.dom.node.b localb = (com.tencent.mtt.hippy.dom.node.b)this.a.get(paramInt);
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int d(int paramInt)
  {
    try
    {
      paramInt = this.b.keyAt(paramInt);
      return paramInt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.b
 * JD-Core Version:    0.7.0.1
 */