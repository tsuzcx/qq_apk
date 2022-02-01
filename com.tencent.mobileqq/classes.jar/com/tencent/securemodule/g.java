package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class g
  extends JceStruct
{
  public String a = "";
  public String b = "";
  public int c = 0;
  public String d = "";
  public int e = 0;
  public String f = "";
  public boolean g = false;
  public String h = "";
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public JceStruct newInit()
  {
    return new g();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = paramJceInputStream.readString(1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = paramJceInputStream.readString(3, true);
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.read(this.g, 6, false);
    this.h = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    int i = this.e;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    String str = this.f;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    boolean bool = this.g;
    if (bool) {
      paramJceOutputStream.write(bool, 6);
    }
    str = this.h;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.g
 * JD-Core Version:    0.7.0.1
 */