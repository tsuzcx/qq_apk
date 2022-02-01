package com.tencent.mobileqq.msf.core.net.d.b;

import com.tencent.mobileqq.msf.core.d;
import java.net.DatagramSocket;

public class j
  extends DatagramSocket
{
  private static final String a = "MsfUdpSocket";
  private d b;
  
  public j(int paramInt)
  {
    super(paramInt);
  }
  
  public j(d paramd)
  {
    this.b = paramd;
  }
  
  public boolean a(j paramj)
  {
    return (paramj != null) && (paramj.b.equals(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.b.j
 * JD-Core Version:    0.7.0.1
 */