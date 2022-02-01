package com.tencent.qphone.base.util.log.wrapper;

import com.tencent.qphone.base.util.log.ILogWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class CompositeWrapper
  implements ILogWriter
{
  ArrayList<ILogWriter> list = new ArrayList();
  
  public void add(ILogWriter paramILogWriter)
  {
    this.list.add(paramILogWriter);
  }
  
  public void close()
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      ((ILogWriter)localIterator.next()).close();
    }
  }
  
  public void flush()
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      ((ILogWriter)localIterator.next()).flush();
    }
  }
  
  public void write(int paramInt)
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      ((ILogWriter)localIterator.next()).write(paramInt);
    }
  }
  
  public void write(String paramString)
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      ((ILogWriter)localIterator.next()).write(paramString);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      ((ILogWriter)localIterator.next()).write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      ((ILogWriter)localIterator.next()).write(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.wrapper.CompositeWrapper
 * JD-Core Version:    0.7.0.1
 */