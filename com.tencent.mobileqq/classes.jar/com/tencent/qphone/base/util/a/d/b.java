package com.tencent.qphone.base.util.a.d;

import com.tencent.qphone.base.util.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  implements a
{
  ArrayList a = new ArrayList();
  
  public void a(a parama)
  {
    this.a.add(parama);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void close()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).close();
    }
  }
  
  public void flush()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).flush();
    }
  }
  
  public void write(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).write(paramInt);
    }
  }
  
  public void write(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).write(paramString);
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).write(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.d.b
 * JD-Core Version:    0.7.0.1
 */