package com.tencent.tavcut.session;

import android.os.Handler.Callback;
import android.os.Message;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "msg", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"}, k=3, mv={1, 1, 16})
final class TavCutSession$1
  implements Handler.Callback
{
  TavCutSession$1(TavCutSession paramTavCutSession) {}
  
  public final boolean handleMessage(Message arg1)
  {
    if ((??? != null) && (???.what == 1)) {
      synchronized (TavCutSession.h(this.a))
      {
        if ((((Collection)TavCutSession.h(this.a)).isEmpty() ^ true))
        {
          ((Runnable)TavCutSession.h(this.a).peekLast()).run();
          TavCutSession.h(this.a).clear();
        }
        Unit localUnit = Unit.INSTANCE;
        return true;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.session.TavCutSession.1
 * JD-Core Version:    0.7.0.1
 */