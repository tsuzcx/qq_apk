package com.tencent.tmediacodec.codec;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/CodecMaxValues;", "", "width", "", "height", "inputSize", "(III)V", "getHeight", "()I", "setHeight", "(I)V", "getInputSize", "setInputSize", "getWidth", "setWidth", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class CodecMaxValues
{
  private int height;
  private int inputSize;
  private int width;
  
  public CodecMaxValues(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.inputSize = paramInt3;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  public final int getInputSize()
  {
    return this.inputSize;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public final void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final void setInputSize(int paramInt)
  {
    this.inputSize = paramInt;
  }
  
  public final void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.CodecMaxValues
 * JD-Core Version:    0.7.0.1
 */