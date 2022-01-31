package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HalleyConfig
  extends JceStruct
{
  public int halleySwitch = 0;
  
  public HalleyConfig() {}
  
  public HalleyConfig(int paramInt)
  {
    this.halleySwitch = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.halleySwitch = paramJceInputStream.read(this.halleySwitch, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.halleySwitch, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.HalleyConfig
 * JD-Core Version:    0.7.0.1
 */