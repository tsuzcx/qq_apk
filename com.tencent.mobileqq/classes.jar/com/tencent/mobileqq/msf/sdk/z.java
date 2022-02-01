package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class z
  extends JceStruct
{
  static NotifyRegisterInfo f;
  static CommandCallbackerInfo g;
  public int a = 0;
  public String b = "";
  public String c = "";
  public NotifyRegisterInfo d = null;
  public CommandCallbackerInfo e = null;
  
  public z() {}
  
  public z(int paramInt, String paramString1, String paramString2, NotifyRegisterInfo paramNotifyRegisterInfo, CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramNotifyRegisterInfo;
    this.e = paramCommandCallbackerInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    this.b = paramJceInputStream.readString(2, true);
    this.c = paramJceInputStream.readString(3, true);
    if (f == null) {
      f = new NotifyRegisterInfo();
    }
    this.d = ((NotifyRegisterInfo)paramJceInputStream.read(f, 4, true));
    if (g == null) {
      g = new CommandCallbackerInfo();
    }
    this.e = ((CommandCallbackerInfo)paramJceInputStream.read(g, 5, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.z
 * JD-Core Version:    0.7.0.1
 */