package com.tencent.msf.service.protocol.QQWiFi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class a
  extends JceStruct
{
  static ArrayList e;
  public ArrayList a = null;
  public String b = "";
  public String c = "";
  public int d = 0;
  
  public a() {}
  
  public a(ArrayList paramArrayList, String paramString1, String paramString2, int paramInt)
  {
    this.a = paramArrayList;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (e == null)
    {
      e = new ArrayList();
      d locald = new d();
      e.add(locald);
    }
    this.a = ((ArrayList)paramJceInputStream.read(e, 1, false));
    this.b = paramJceInputStream.readString(2, false);
    this.c = paramJceInputStream.readString(3, false);
    this.d = paramJceInputStream.read(this.d, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.b;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.d, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.QQWiFi.a
 * JD-Core Version:    0.7.0.1
 */