package com.tencent.util;

import java.io.DataInput;
import java.io.DataOutput;

public class NinePatchCodec$NinePatch
{
  public int[] colors;
  private byte numColors;
  private byte numXDivs;
  private byte numYDivs;
  public int padBottom;
  public int padLeft;
  public int padRight;
  public int padTop;
  private byte wasDeserialized;
  public int[] xDivs;
  public int[] yDivs;
  
  public void decode(DataInput paramDataInput)
  {
    int j = 0;
    this.wasDeserialized = paramDataInput.readByte();
    this.numXDivs = paramDataInput.readByte();
    this.numYDivs = paramDataInput.readByte();
    this.numColors = paramDataInput.readByte();
    paramDataInput.skipBytes(8);
    this.padLeft = paramDataInput.readInt();
    this.padRight = paramDataInput.readInt();
    this.padTop = paramDataInput.readInt();
    this.padBottom = paramDataInput.readInt();
    paramDataInput.skipBytes(4);
    this.xDivs = new int[this.numXDivs];
    int i = 0;
    while (i < this.numXDivs)
    {
      this.xDivs[i] = paramDataInput.readInt();
      i += 1;
    }
    this.yDivs = new int[this.numYDivs];
    i = 0;
    while (i < this.numYDivs)
    {
      this.yDivs[i] = paramDataInput.readInt();
      i += 1;
    }
    this.colors = new int[this.numColors];
    i = j;
    while (i < this.numColors)
    {
      this.colors[i] = paramDataInput.readInt();
      i += 1;
    }
  }
  
  public void encode(DataOutput paramDataOutput)
  {
    int k = 0;
    paramDataOutput.writeByte(this.wasDeserialized);
    paramDataOutput.writeByte(this.numXDivs);
    paramDataOutput.writeByte(this.numYDivs);
    paramDataOutput.writeByte(this.numColors);
    paramDataOutput.writeInt(0);
    paramDataOutput.writeInt(0);
    paramDataOutput.writeInt(this.padLeft);
    paramDataOutput.writeInt(this.padRight);
    paramDataOutput.writeInt(this.padTop);
    paramDataOutput.writeInt(this.padBottom);
    paramDataOutput.writeInt(0);
    int i = 0;
    while (i < this.numXDivs)
    {
      paramDataOutput.writeInt(this.xDivs[i]);
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.numYDivs) {
        break;
      }
      paramDataOutput.writeInt(this.yDivs[i]);
      i += 1;
    }
    while (j < this.numColors)
    {
      paramDataOutput.writeInt(this.colors[j]);
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.NinePatchCodec.NinePatch
 * JD-Core Version:    0.7.0.1
 */