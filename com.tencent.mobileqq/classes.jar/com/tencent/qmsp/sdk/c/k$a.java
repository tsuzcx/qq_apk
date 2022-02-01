package com.tencent.qmsp.sdk.c;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.util.List;

class k$a
  implements g.c
{
  k$a(k paramk) {}
  
  public void a(List<Pair<Integer, Integer>> paramList)
  {
    Message localMessage = k.e(this.a).obtainMessage(2);
    localMessage.obj = paramList;
    k.e(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.k.a
 * JD-Core Version:    0.7.0.1
 */