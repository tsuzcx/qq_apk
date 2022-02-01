package com.tencent.qapmsdk.dns;

import com.tencent.qapmsdk.dns.b.b;
import java.net.InetAddress;

final class a$1
  implements a.a
{
  boolean a = false;
  
  public void a(a.b paramb, String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    if (this.a) {
      b.a(paramString, paramArrayOfInetAddress, paramLong);
    }
  }
  
  public void a(boolean paramBoolean, Throwable paramThrowable)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.a.1
 * JD-Core Version:    0.7.0.1
 */