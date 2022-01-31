package com.tencent.mobileqq.msf.core.c;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class h
  extends JceStruct
{
  static ArrayList b;
  public ArrayList a;
  
  public h() {}
  
  public h(ArrayList paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (b == null)
    {
      b = new ArrayList();
      i locali = new i();
      b.add(locali);
    }
    this.a = ((ArrayList)paramJceInputStream.read(b, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.h
 * JD-Core Version:    0.7.0.1
 */