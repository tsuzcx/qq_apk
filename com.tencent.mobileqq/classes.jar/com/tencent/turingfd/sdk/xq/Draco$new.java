package com.tencent.turingfd.sdk.xq;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.Set;

public class Draco$new
  extends Handler
{
  public Draco$new(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    paramMessage = paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    if (!(paramMessage instanceof Equuleus)) {
      return;
    }
    paramMessage = (Equuleus)paramMessage;
    ??? = Draco.c.iterator();
    while (((Iterator)???).hasNext()) {
      ((Eridanus)((Iterator)???).next()).a(paramMessage);
    }
    if (!paramMessage.e) {
      synchronized (Equuleus.c)
      {
        paramMessage.f = 0;
        paramMessage.g = 0;
        paramMessage.h = 0;
        paramMessage.i = 0.0F;
        paramMessage.j = 0.0F;
        paramMessage.k = 0.0F;
        paramMessage.l = 0.0F;
        paramMessage.m = "";
        int i = Equuleus.b;
        if (i < 20)
        {
          paramMessage.d = Equuleus.a;
          paramMessage.e = true;
          Equuleus.a = paramMessage;
          Equuleus.b = i + 1;
        }
        return;
      }
    }
    paramMessage = new IllegalStateException("Already recycled.");
    for (;;)
    {
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Draco.new
 * JD-Core Version:    0.7.0.1
 */