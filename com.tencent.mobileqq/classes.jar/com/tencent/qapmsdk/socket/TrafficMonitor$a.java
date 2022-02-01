package com.tencent.qapmsdk.socket;

import android.content.Context;
import com.tencent.qapmsdk.common.logger.LogState;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.a.e;
import com.tencent.qapmsdk.socket.a.g;
import com.tencent.qapmsdk.socket.a.j;

public class TrafficMonitor$a
{
  private static a a = new a();
  private Context b;
  private boolean c = true;
  private boolean d = true;
  
  public a a(a.a parama)
  {
    a.a(parama);
    return this;
  }
  
  public a a(e parame)
  {
    j.a(parame);
    return this;
  }
  
  public a a(g paramg)
  {
    j.a(paramg);
    return this;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return Logger.INSTANCE.getLogLevel().getValue() >= LogState.DEBUG.getValue();
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public Context d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficMonitor.a
 * JD-Core Version:    0.7.0.1
 */