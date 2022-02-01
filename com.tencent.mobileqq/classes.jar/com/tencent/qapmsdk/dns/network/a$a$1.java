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
    if (locala != b.a.a) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((this.a.b != null) && (locala != this.a.b)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((locala == this.a.b) && (locala == b.a.c) && ((!b.a(str)) || (!b.a(this.a.c)) || (!str.equals(this.a.c)))) {
      k = 1;
    } else {
      k = 0;
    }
    if ((i != 0) && (j != 0))
    {
      Logger.INSTANCE.i(new String[] { "QAPM_DNS_NetworkHandler", "Network type changed, clear dns cache, curNetwork: ", String.valueOf(locala), ", lastNetwork: ", String.valueOf(this.a.a), ", lastValidNetwork: ", String.valueOf(this.a.b), ", curSsid: ", str, ", lastSsid: ", this.a.c });
      a.a().c();
    }
    if ((i != 0) && (k != 0)) {
      a.a().b();
    }
    a.a locala1 = this.a;
    locala1.a = locala;
    if (i != 0) {
      locala1.b = locala;
    }
    if (locala == b.a.c) {
      this.a.c = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.a.a.1
 * JD-Core Version:    0.7.0.1
 */