package com.tencent.qphone.base.util.log.utils;

import com.tencent.qphone.base.util.log.processor.ProcessByteData;

public class JavaStringCoder
{
  ProcessByteData data = new ProcessByteData();
  JavaStringCoder.JavaStringCoderCallback javaStringCoderCallback;
  
  public JavaStringCoder(JavaStringCoder.JavaStringCoderCallback paramJavaStringCoderCallback)
  {
    this.javaStringCoderCallback = paramJavaStringCoderCallback;
  }
  
  public void feedIn(int paramInt)
  {
    int i = (char)paramInt;
    Object localObject;
    ProcessByteData localProcessByteData;
    if (i < 128)
    {
      localObject = this.data.bytes;
      localProcessByteData = this.data;
      paramInt = localProcessByteData.offset;
      localProcessByteData.offset = (paramInt + 1);
      localObject[paramInt] = ((byte)i);
      localObject = this.data;
      ((ProcessByteData)localObject).length += 1;
    }
    else if (i < 2048)
    {
      localObject = this.data.bytes;
      localProcessByteData = this.data;
      paramInt = localProcessByteData.offset;
      localProcessByteData.offset = (paramInt + 1);
      localObject[paramInt] = ((byte)(i >>> 6 | 0xC0));
      localObject = this.data.bytes;
      localProcessByteData = this.data;
      paramInt = localProcessByteData.offset;
      localProcessByteData.offset = (paramInt + 1);
      localObject[paramInt] = ((byte)(i & 0x3F | 0x80));
      localObject = this.data;
      ((ProcessByteData)localObject).length += 2;
    }
    else
    {
      if ((i >= 55296) && (i <= 57343))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("not supported char ");
        ((StringBuilder)localObject).append(paramInt);
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      localObject = this.data.bytes;
      localProcessByteData = this.data;
      paramInt = localProcessByteData.offset;
      localProcessByteData.offset = (paramInt + 1);
      localObject[paramInt] = ((byte)(i >>> 12 | 0xE0));
      localObject = this.data.bytes;
      localProcessByteData = this.data;
      paramInt = localProcessByteData.offset;
      localProcessByteData.offset = (paramInt + 1);
      localObject[paramInt] = ((byte)(i >>> 6 & 0x3F | 0x80));
      localObject = this.data.bytes;
      localProcessByteData = this.data;
      paramInt = localProcessByteData.offset;
      localProcessByteData.offset = (paramInt + 1);
      localObject[paramInt] = ((byte)(i & 0x3F | 0x80));
      localObject = this.data;
      ((ProcessByteData)localObject).length += 3;
    }
    if (this.data.offset >= this.data.capacity - 4) {
      flush();
    }
  }
  
  public void feedIn(String paramString)
  {
    int m = paramString.length();
    int j = 0;
    while (j < m)
    {
      int i = paramString.charAt(j);
      Object localObject;
      ProcessByteData localProcessByteData;
      int k;
      if (i < 128)
      {
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        k = localProcessByteData.offset;
        localProcessByteData.offset = (k + 1);
        localObject[k] = ((byte)i);
        localObject = this.data;
        ((ProcessByteData)localObject).length += 1;
      }
      else if (i < 2048)
      {
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        k = localProcessByteData.offset;
        localProcessByteData.offset = (k + 1);
        localObject[k] = ((byte)(i >>> 6 | 0xC0));
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        k = localProcessByteData.offset;
        localProcessByteData.offset = (k + 1);
        localObject[k] = ((byte)(i & 0x3F | 0x80));
        localObject = this.data;
        ((ProcessByteData)localObject).length += 2;
      }
      else if ((i >= 55296) && (i <= 57343))
      {
        k = j + 1;
        if (k < m) {
          j = Character.toCodePoint(i, paramString.charAt(k));
        } else {
          j = 0;
        }
        if ((j >= 65536) && (j < 2097152))
        {
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          int n = localProcessByteData.offset;
          localProcessByteData.offset = (n + 1);
          localObject[n] = ((byte)(j >>> 18 | 0xF0));
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          n = localProcessByteData.offset;
          localProcessByteData.offset = (n + 1);
          localObject[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          n = localProcessByteData.offset;
          localProcessByteData.offset = (n + 1);
          localObject[n] = ((byte)(0x3F & j >>> 6 | 0x80));
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          n = localProcessByteData.offset;
          localProcessByteData.offset = (n + 1);
          localObject[n] = ((byte)(j & 0x3F | 0x80));
          localObject = this.data;
          ((ProcessByteData)localObject).length += 4;
          j = k;
        }
        else
        {
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          j = localProcessByteData.offset;
          localProcessByteData.offset = (j + 1);
          localObject[j] = 63;
          localObject = this.data;
          ((ProcessByteData)localObject).length += 1;
          j = k;
        }
      }
      else
      {
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        k = localProcessByteData.offset;
        localProcessByteData.offset = (k + 1);
        localObject[k] = ((byte)(i >>> 12 | 0xE0));
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        k = localProcessByteData.offset;
        localProcessByteData.offset = (k + 1);
        localObject[k] = ((byte)(0x3F & i >>> 6 | 0x80));
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        k = localProcessByteData.offset;
        localProcessByteData.offset = (k + 1);
        localObject[k] = ((byte)(i & 0x3F | 0x80));
        localObject = this.data;
        ((ProcessByteData)localObject).length += 3;
      }
      if (this.data.offset >= this.data.capacity - 4) {
        flush();
      }
      j += 1;
    }
  }
  
  public void feedIn(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= this.data.capacity)
    {
      if (this.data.capacity - this.data.length < paramInt2) {
        flush();
      }
      this.data.append(paramArrayOfByte, paramInt1, paramInt2);
      if (this.data.offset >= this.data.capacity - 4) {
        flush();
      }
      return;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public void feedIn(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int k = paramInt2 + paramInt1;
    while (paramInt1 < k)
    {
      int i = paramArrayOfChar[paramInt1];
      Object localObject;
      ProcessByteData localProcessByteData;
      if (i < 128)
      {
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        paramInt2 = localProcessByteData.offset;
        localProcessByteData.offset = (paramInt2 + 1);
        localObject[paramInt2] = ((byte)i);
        localObject = this.data;
        ((ProcessByteData)localObject).length += 1;
      }
      else if (i < 2048)
      {
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        paramInt2 = localProcessByteData.offset;
        localProcessByteData.offset = (paramInt2 + 1);
        localObject[paramInt2] = ((byte)(i >>> 6 | 0xC0));
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        paramInt2 = localProcessByteData.offset;
        localProcessByteData.offset = (paramInt2 + 1);
        localObject[paramInt2] = ((byte)(i & 0x3F | 0x80));
        localObject = this.data;
        ((ProcessByteData)localObject).length += 2;
      }
      else if ((i >= 55296) && (i <= 57343))
      {
        int j = 0;
        paramInt2 = paramInt1 + 1;
        paramInt1 = j;
        if (paramInt2 < k) {
          paramInt1 = Character.toCodePoint(i, paramArrayOfChar[paramInt2]);
        }
        if ((paramInt1 >= 65536) && (paramInt1 < 2097152))
        {
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          j = localProcessByteData.offset;
          localProcessByteData.offset = (j + 1);
          localObject[j] = ((byte)(paramInt1 >>> 18 | 0xF0));
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          j = localProcessByteData.offset;
          localProcessByteData.offset = (j + 1);
          localObject[j] = ((byte)(paramInt1 >>> 12 & 0x3F | 0x80));
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          j = localProcessByteData.offset;
          localProcessByteData.offset = (j + 1);
          localObject[j] = ((byte)(0x3F & paramInt1 >>> 6 | 0x80));
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          j = localProcessByteData.offset;
          localProcessByteData.offset = (j + 1);
          localObject[j] = ((byte)(0x80 | paramInt1 & 0x3F));
          localObject = this.data;
          ((ProcessByteData)localObject).length += 4;
          paramInt1 = paramInt2;
        }
        else
        {
          localObject = this.data.bytes;
          localProcessByteData = this.data;
          paramInt1 = localProcessByteData.offset;
          localProcessByteData.offset = (paramInt1 + 1);
          localObject[paramInt1] = 63;
          localObject = this.data;
          ((ProcessByteData)localObject).length += 1;
          paramInt1 = paramInt2;
        }
      }
      else
      {
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        paramInt2 = localProcessByteData.offset;
        localProcessByteData.offset = (paramInt2 + 1);
        localObject[paramInt2] = ((byte)(i >>> 12 | 0xE0));
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        paramInt2 = localProcessByteData.offset;
        localProcessByteData.offset = (paramInt2 + 1);
        localObject[paramInt2] = ((byte)(0x3F & i >>> 6 | 0x80));
        localObject = this.data.bytes;
        localProcessByteData = this.data;
        paramInt2 = localProcessByteData.offset;
        localProcessByteData.offset = (paramInt2 + 1);
        localObject[paramInt2] = ((byte)(i & 0x3F | 0x80));
        localObject = this.data;
        ((ProcessByteData)localObject).length += 3;
      }
      if (this.data.offset >= this.data.capacity - 4) {
        flush();
      }
      paramInt1 += 1;
    }
  }
  
  public void flush()
  {
    ProcessByteData localProcessByteData = this.data;
    localProcessByteData.offset = 0;
    this.javaStringCoderCallback.onBufferFull(localProcessByteData);
    this.data.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.utils.JavaStringCoder
 * JD-Core Version:    0.7.0.1
 */