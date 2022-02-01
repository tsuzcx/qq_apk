package org.apache.commons.io.input;

import java.io.RandomAccessFile;

class ReversedLinesFileReader$FilePart
{
  private int currentLastBytePos;
  private final byte[] data;
  private byte[] leftOver;
  private final long no;
  
  private ReversedLinesFileReader$FilePart(ReversedLinesFileReader paramReversedLinesFileReader, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.no = paramLong;
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length;; i = 0)
    {
      this.data = new byte[i + paramInt];
      long l = ReversedLinesFileReader.access$300(paramReversedLinesFileReader);
      if (paramLong <= 0L) {
        break;
      }
      ReversedLinesFileReader.access$400(paramReversedLinesFileReader).seek((paramLong - 1L) * l);
      if (ReversedLinesFileReader.access$400(paramReversedLinesFileReader).read(this.data, 0, paramInt) == paramInt) {
        break;
      }
      throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
    }
    if (paramArrayOfByte != null) {
      System.arraycopy(paramArrayOfByte, 0, this.data, paramInt, paramArrayOfByte.length);
    }
    this.currentLastBytePos = (this.data.length - 1);
    this.leftOver = null;
  }
  
  private void createLeftOver()
  {
    int i = this.currentLastBytePos + 1;
    if (i > 0)
    {
      this.leftOver = new byte[i];
      System.arraycopy(this.data, 0, this.leftOver, 0, i);
    }
    for (;;)
    {
      this.currentLastBytePos = -1;
      return;
      this.leftOver = null;
    }
  }
  
  private int getNewLineMatchByteCount(byte[] paramArrayOfByte, int paramInt)
  {
    int n = 0;
    byte[][] arrayOfByte = ReversedLinesFileReader.access$800(this.this$0);
    int i1 = arrayOfByte.length;
    int i = 0;
    for (;;)
    {
      int j = n;
      if (i < i1)
      {
        byte[] arrayOfByte1 = arrayOfByte[i];
        j = arrayOfByte1.length - 1;
        int k = 1;
        if (j >= 0)
        {
          int m = paramInt + j - (arrayOfByte1.length - 1);
          if ((m >= 0) && (paramArrayOfByte[m] == arrayOfByte1[j])) {}
          for (m = 1;; m = 0)
          {
            k &= m;
            j -= 1;
            break;
          }
        }
        if (k != 0) {
          j = arrayOfByte1.length;
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  private String readLine()
  {
    int i;
    int j;
    label16:
    Object localObject;
    if (this.no == 1L)
    {
      i = 1;
      j = this.currentLastBytePos;
      if (j <= -1) {
        break label227;
      }
      if ((i != 0) || (j >= ReversedLinesFileReader.access$600(this.this$0))) {
        break label87;
      }
      createLeftOver();
      localObject = null;
    }
    for (;;)
    {
      if ((i != 0) && (this.leftOver != null))
      {
        localObject = new String(this.leftOver, ReversedLinesFileReader.access$500(this.this$0));
        this.leftOver = null;
        return localObject;
        i = 0;
        break;
        label87:
        int k = getNewLineMatchByteCount(this.data, j);
        if (k > 0)
        {
          int m = j + 1;
          int n = this.currentLastBytePos - m + 1;
          if (n < 0) {
            throw new IllegalStateException("Unexpected negative line length=" + n);
          }
          localObject = new byte[n];
          System.arraycopy(this.data, m, localObject, 0, n);
          localObject = new String((byte[])localObject, ReversedLinesFileReader.access$500(this.this$0));
          this.currentLastBytePos = (j - k);
          continue;
        }
        k = j - ReversedLinesFileReader.access$700(this.this$0);
        j = k;
        if (k >= 0) {
          break label16;
        }
        createLeftOver();
        localObject = null;
        continue;
      }
      return localObject;
      label227:
      localObject = null;
    }
  }
  
  private FilePart rollOver()
  {
    if (this.currentLastBytePos > -1) {
      throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
    }
    if (this.no > 1L) {
      return new FilePart(this.this$0, this.no - 1L, ReversedLinesFileReader.access$300(this.this$0), this.leftOver);
    }
    if (this.leftOver != null) {
      throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.access$500(this.this$0)));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.ReversedLinesFileReader.FilePart
 * JD-Core Version:    0.7.0.1
 */