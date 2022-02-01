package com.tencent.qapmsdk.dns.network;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dns.a.a;

class a$a$1
  implements Runnable
{
  a$a$1(a.a parama) {}
  
  public void run()
  {
    b.a locala = b.a();
    String str = b.c();
    int i;
    int j;
    if (locala != b.a.a)
    {
      i = 1;
      if ((this.a.b == null) || (locala == this.a.b)) {
        break label270;
      }
      j = 1;
      label44:
      if ((locala != this.a.b) || (locala != b.a.c) || ((b.a(str)) && (b.a(this.a.c)) && (str.equals(this.a.c)))) {
        break label275;
      }
    }
    label270:
    label275:
    for (int k = 1;; k = 0)
    {
      if ((i != 0) && (j != 0))
      {
        Logger.INSTANCE.i(new String[] { "QAPM_DNS_NetworkHandler", "Network type changed, clear dns cache, curNetwork: ", String.valueOf(locala), ", lastNetwork: ", String.valueOf(this.a.a), ", lastValidNetwork: ", String.valueOf(this.a.b), ", curSsid: ", str, ", lastSsid: ", this.a.c });
        a.a().c();
      }
      if ((i != 0) && (k != 0)) {
        a.a().b();
      }
      this.a.a = locala;
      if (i != 0) {
        this.a.b = locala;
      }
      if (locala == b.a.c) {
        this.a.c = str;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.a.a.1
 * JD-Core Version:    0.7.0.1
 */