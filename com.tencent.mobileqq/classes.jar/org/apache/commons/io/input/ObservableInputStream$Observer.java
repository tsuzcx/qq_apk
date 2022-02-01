package org.apache.commons.io.input;

import java.io.IOException;

public abstract class ObservableInputStream$Observer
{
  void closed() {}
  
  void data(int paramInt) {}
  
  void data(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  void error(IOException paramIOException)
  {
    throw paramIOException;
  }
  
  void finished() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.ObservableInputStream.Observer
 * JD-Core Version:    0.7.0.1
 */