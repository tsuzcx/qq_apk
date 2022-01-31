package com.tencent.msf.service.protocol.QQWiFi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static ArrayList e;
  public int a = 0;
  public ArrayList b = null;
  public int c = 0;
  public int d = 0;
  
  public b() {}
  
  public b(int paramInt1, ArrayList paramArrayList, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramArrayList;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    if (e == null)
    {
      e = new ArrayList();
      WiFiService localWiFiService = new WiFiService();
      e.add(localWiFiService);
    }
    this.b = ((ArrayList)paramJceInputStream.read(e, 1, false));
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.read(this.d, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.QQWiFi.b
 * JD-Core Version:    0.7.0.1
 */