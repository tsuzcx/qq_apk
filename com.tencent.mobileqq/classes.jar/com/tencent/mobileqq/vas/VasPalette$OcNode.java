package com.tencent.mobileqq.vas;

import android.graphics.Color;
import android.util.SparseArray;

public class VasPalette$OcNode
{
  public byte a;
  public int a;
  public long a;
  public SparseArray a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static OcNode a()
  {
    return new OcNode();
  }
  
  public static OcNode a(int paramInt, byte paramByte)
  {
    OcNode localOcNode = new OcNode();
    localOcNode.jdField_b_of_type_Int = paramInt;
    localOcNode.jdField_a_of_type_Byte = paramByte;
    return localOcNode;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasPalette.OcNode
 * JD-Core Version:    0.7.0.1
 */