package com.tencent.mobileqq.msf.core.net.utils;

import android.util.Pair;
import java.util.Iterator;
import java.util.List;

abstract class MsfCmdConfig$a
{
  protected String a;
  protected List b;
  protected boolean c;
  
  final void a(int paramInt)
  {
    if (a())
    {
      int j = 1;
      Iterator localIterator = this.b.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (a((Pair)localIterator.next()));
      int i = 0;
      if (i != 0) {
        a(paramInt, this.b);
      }
    }
  }
  
  protected abstract void a(int paramInt, List paramList);
  
  protected abstract boolean a();
  
  protected abstract boolean a(Pair paramPair);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.a
 * JD-Core Version:    0.7.0.1
 */