package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObservableInputStream
  extends ProxyInputStream
{
  private final List<ObservableInputStream.Observer> observers = new ArrayList();
  
  public ObservableInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public void add(ObservableInputStream.Observer paramObserver)
  {
    this.observers.add(paramObserver);
  }
  
  public void close()
  {
    try
    {
      super.close();
      Object localObject = null;
    }
    catch (IOException localIOException) {}
    if (localIOException == null)
    {
      noteClosed();
      return;
    }
    noteError(localIOException);
  }
  
  public void consume()
  {
    byte[] arrayOfByte = new byte[8192];
    while (read(arrayOfByte) != -1) {}
  }
  
  protected List<ObservableInputStream.Observer> getObservers()
  {
    return this.observers;
  }
  
  protected void noteClosed()
  {
    Iterator localIterator = getObservers().iterator();
    while (localIterator.hasNext()) {
      ((ObservableInputStream.Observer)localIterator.next()).closed();
    }
  }
  
  protected void noteDataByte(int paramInt)
  {
    Iterator localIterator = getObservers().iterator();
    while (localIterator.hasNext()) {
      ((ObservableInputStream.Observer)localIterator.next()).data(paramInt);
    }
  }
  
  protected void noteDataBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Iterator localIterator = getObservers().iterator();
    while (localIterator.hasNext()) {
      ((ObservableInputStream.Observer)localIterator.next()).data(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  protected void noteError(IOException paramIOException)
  {
    Iterator localIterator = getObservers().iterator();
    while (localIterator.hasNext()) {
      ((ObservableInputStream.Observer)localIterator.next()).error(paramIOException);
    }
  }
  
  protected void noteFinished()
  {
    Iterator localIterator = getObservers().iterator();
    while (localIterator.hasNext()) {
      ((ObservableInputStream.Observer)localIterator.next()).finished();
    }
  }
  
  public int read()
  {
    int i;
    try
    {
      i = super.read();
      Object localObject = null;
    }
    catch (IOException localIOException)
    {
      i = 0;
    }
    if (localIOException != null)
    {
      noteError(localIOException);
      return i;
    }
    if (i == -1)
    {
      noteFinished();
      return i;
    }
    noteDataByte(i);
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    int i;
    try
    {
      i = super.read(paramArrayOfByte);
      Object localObject = null;
    }
    catch (IOException localIOException)
    {
      i = 0;
    }
    if (localIOException != null)
    {
      noteError(localIOException);
      return i;
    }
    if (i == -1)
    {
      noteFinished();
      return i;
    }
    if (i > 0) {
      noteDataBytes(paramArrayOfByte, 0, i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      Object localObject = null;
    }
    catch (IOException localIOException)
    {
      paramInt2 = 0;
    }
    if (localIOException != null)
    {
      noteError(localIOException);
      return paramInt2;
    }
    if (paramInt2 == -1)
    {
      noteFinished();
      return paramInt2;
    }
    if (paramInt2 > 0) {
      noteDataBytes(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public void remove(ObservableInputStream.Observer paramObserver)
  {
    this.observers.remove(paramObserver);
  }
  
  public void removeAllObservers()
  {
    this.observers.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.ObservableInputStream
 * JD-Core Version:    0.7.0.1
 */