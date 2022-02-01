package com.tencent.mobileqq.vas;

import android.graphics.Color;
import android.util.SparseArray;

public class VasPalette$OcNode
{
  public long a;
  public long b;
  public long c;
  public int d;
  public byte e;
  public int f;
  public SparseArray<OcNode> g;
  public boolean h = false;
  
  public static OcNode a()
  {
    return new OcNode();
  }
  
  public static OcNode a(int paramInt, byte paramByte)
  {
    OcNode localOcNode = new OcNode();
    localOcNode.f = paramInt;
    localOcNode.e = paramByte;
    return localOcNode;
  }
  
  public int b()
  {
    return Color.rgb((int)this.a, (int)this.b, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasPalette.OcNode
 * JD-Core Version:    0.7.0.1
 */