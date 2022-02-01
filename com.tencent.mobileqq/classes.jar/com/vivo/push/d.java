package com.vivo.push;

import android.content.Intent;
import com.vivo.push.b.i;
import com.vivo.push.b.j;
import com.vivo.push.b.k;
import com.vivo.push.b.m;
import com.vivo.push.b.n;
import com.vivo.push.b.p;
import com.vivo.push.b.q;
import com.vivo.push.b.r;
import com.vivo.push.b.t;
import com.vivo.push.b.u;
import com.vivo.push.c.af;
import com.vivo.push.c.y;

public final class d
  implements IPushClientFactory
{
  private af a = new af();
  
  public final y createReceiveTask(o paramo)
  {
    return af.b(paramo);
  }
  
  public final o createReceiverCommand(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("command", -1);
    int i = j;
    if (j < 0) {
      i = paramIntent.getIntExtra("method", -1);
    }
    Object localObject;
    if (i != 20)
    {
      if (i != 2016) {
        switch (i)
        {
        default: 
          localObject = null;
          break;
        case 12: 
          localObject = new j();
          break;
        case 10: 
        case 11: 
          localObject = new i(i);
          break;
        case 9: 
          localObject = new k();
          break;
        case 8: 
          localObject = new m();
          break;
        case 7: 
          localObject = new n();
          break;
        case 6: 
          localObject = new r();
          break;
        case 5: 
          localObject = new p();
          break;
        case 4: 
          localObject = new q();
          break;
        case 3: 
          localObject = new com.vivo.push.b.o();
          break;
        case 1: 
        case 2: 
          localObject = new t(i);
          break;
        }
      } else {
        localObject = new com.vivo.push.b.l();
      }
    }
    else {
      localObject = new u();
    }
    if (localObject != null)
    {
      paramIntent = a.a(paramIntent);
      if (paramIntent == null)
      {
        com.vivo.push.util.o.b("PushCommand", "bundleWapper is null");
        return localObject;
      }
      ((o)localObject).b(paramIntent);
    }
    return localObject;
  }
  
  public final l createTask(o paramo)
  {
    return af.a(paramo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.d
 * JD-Core Version:    0.7.0.1
 */