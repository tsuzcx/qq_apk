package com.tencent.qapmsdk.socket.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.socket.c.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class i
{
  private Set<d> a = new HashSet();
  
  public i()
  {
    Iterator localIterator = j.a().iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      this.a.add(locale.a());
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a();
    }
  }
  
  public void a(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, a parama)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.i
 * JD-Core Version:    0.7.0.1
 */