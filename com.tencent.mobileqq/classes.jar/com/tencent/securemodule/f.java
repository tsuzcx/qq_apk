package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class f
  extends JceStruct
{
  public long a = 0L;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public JceStruct newInit()
  {
    return new f();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    int i = this.c;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    i = this.d;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
    i = this.e;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.f
 * JD-Core Version:    0.7.0.1
 */