package com.tencent.qapmsdk.socket.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.socket.c.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class k
{
  private Set<f> a = new HashSet();
  
  public k()
  {
    Iterator localIterator = j.b().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      this.a.add(localg.a());
    }
  }
  
  public void a(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, a parama)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(paramArrayOfByte, paramInt1, paramInt2, parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.k
 * JD-Core Version:    0.7.0.1
 */