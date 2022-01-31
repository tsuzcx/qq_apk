package com.tencent.mobileqq.msf.core.c;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class i
  extends JceStruct
{
  static ArrayList b;
  public ArrayList a = null;
  
  public i() {}
  
  public i(ArrayList paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (b == null)
    {
      b = new ArrayList();
      j localj = new j();
      b.add(localj);
    }
    this.a = ((ArrayList)paramJceInputStream.read(b, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.i
 * JD-Core Version:    0.7.0.1
 */