package com.tencent.qphone.base.util.log;

import android.os.Build.VERSION;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class QLogWriter
  extends QWriter
{
  static boolean mCanRecycle = true;
  static Field sBackingArrayField;
  static Field sCapacityField;
  static Class sCharBufferClass;
  private ByteBuffer bytes = ByteBuffer.allocate(8192);
  private CharsetEncoder encoder;
  boolean mInited = false;
  CharBuffer mRecycleBuffer;
  private final OutputStream out;
  
  public QLogWriter(File paramFile, boolean paramBoolean)
  {
    this(new BufferedOutputStream(new FileOutputStream(paramFile, paramBoolean)));
  }
  
  public QLogWriter(OutputStream paramOutputStream)
  {
    this(paramOutputStream, Charset.defaultCharset());
  }
  
  public QLogWriter(OutputStream paramOutputStream, String paramString)
  {
    super(paramOutputStream);
    if (paramString != null) {
      this.out = paramOutputStream;
    }
    try
    {
      this.encoder = Charset.forName(paramString).newEncoder();
      this.encoder.onMalformedInput(CodingErrorAction.REPLACE);
      this.encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
      return;
    }
    catch (Exception paramOutputStream)
    {
      label63:
      break label63;
    }
    throw new UnsupportedEncodingException(paramString);
    throw new NullPointerException();
  }
  
  public QLogWriter(OutputStream paramOutputStream, Charset paramCharset)
  {
    super(paramOutputStream);
    this.out = paramOutputStream;
    this.encoder = paramCharset.newEncoder();
    this.encoder.onMalformedInput(CodingErrorAction.REPLACE);
    this.encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
  }
  
  public QLogWriter(OutputStream paramOutputStream, CharsetEncoder paramCharsetEncoder)
  {
    super(paramOutputStream);
    paramCharsetEncoder.charset();
    this.out = paramOutputStream;
    this.encoder = paramCharsetEncoder;
  }
  
  public static void checkOffsetAndCount(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) >= 0) && (paramInt2 <= paramInt1) && (paramInt1 - paramInt2 >= paramInt3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("length=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; regionStart=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("; regionLength=");
    localStringBuilder.append(paramInt3);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  private void checkStatus()
  {
    if (this.encoder != null) {
      return;
    }
    throw new IOException("OutputStreamWriter is closed");
  }
  
  private void convert(CharBuffer paramCharBuffer)
  {
    CoderResult localCoderResult;
    for (;;)
    {
      localCoderResult = this.encoder.encode(paramCharBuffer, this.bytes, false);
      if (!localCoderResult.isOverflow()) {
        break;
      }
      flushBytes(false);
    }
    if (localCoderResult.isError()) {
      localCoderResult.throwException();
    }
  }
  
  private void drainEncoder()
  {
    Object localObject = CharBuffer.allocate(0);
    for (;;)
    {
      CoderResult localCoderResult = this.encoder.encode((CharBuffer)localObject, this.bytes, true);
      if (localCoderResult.isError())
      {
        localCoderResult.throwException();
        break;
      }
      if (!localCoderResult.isOverflow()) {
        break;
      }
      flushBytes(false);
    }
    localObject = this.encoder.flush(this.bytes);
    while (!((CoderResult)localObject).isUnderflow()) {
      if (((CoderResult)localObject).isOverflow())
      {
        flushBytes(false);
        localObject = this.encoder.flush(this.bytes);
      }
      else
      {
        ((CoderResult)localObject).throwException();
      }
    }
  }
  
  private void flushBytes(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      checkStatus();
      int i = this.bytes.position();
      if (i > 0)
      {
        this.bytes.flip();
        this.out.write(this.bytes.array(), this.bytes.arrayOffset(), i);
        this.bytes.clear();
      }
      if (paramBoolean) {
        this.out.flush();
      }
      return;
    }
  }
  
  private CharBuffer wrap(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (!this.mInited)
    {
      this.mRecycleBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
      this.mInited = true;
      return this.mRecycleBuffer;
    }
    if (mCanRecycle)
    {
      this.mRecycleBuffer.clear();
      try
      {
        if ((sCharBufferClass == null) || (sBackingArrayField == null) || (sCapacityField == null))
        {
          int i = Build.VERSION.SDK_INT;
          if ((i >= 8) && (Build.VERSION.SDK_INT <= 17))
          {
            sCharBufferClass = Class.forName("java.nio.ReadWriteCharArrayBuffer");
            sBackingArrayField = sCharBufferClass.getSuperclass().getDeclaredField("backingArray");
            sCapacityField = sCharBufferClass.getSuperclass().getSuperclass().getSuperclass().getDeclaredField("capacity");
          }
          else if (Build.VERSION.SDK_INT >= 18)
          {
            sCharBufferClass = Class.forName("java.nio.CharArrayBuffer");
            sBackingArrayField = sCharBufferClass.getDeclaredField("backingArray");
            sCapacityField = sCharBufferClass.getSuperclass().getSuperclass().getDeclaredField("capacity");
          }
          if (sBackingArrayField != null) {
            sBackingArrayField.setAccessible(true);
          }
          if (sCapacityField != null) {
            sCapacityField.setAccessible(true);
          }
        }
        if ((sCapacityField != null) && (sBackingArrayField != null) && (sCharBufferClass != null) && (sCharBufferClass.isInstance(this.mRecycleBuffer)))
        {
          sBackingArrayField.set(this.mRecycleBuffer, paramArrayOfChar);
          sCapacityField.set(this.mRecycleBuffer, LargerInteger.valueOf(paramArrayOfChar.length));
          this.mRecycleBuffer.position(paramInt1);
          this.mRecycleBuffer.limit(paramInt1 + paramInt2);
          CharBuffer localCharBuffer = this.mRecycleBuffer;
          return localCharBuffer;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
      }
      mCanRecycle = false;
      this.mRecycleBuffer = null;
    }
    return CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void close()
  {
    synchronized (this.lock)
    {
      if (this.encoder != null)
      {
        drainEncoder();
        flushBytes(false);
        this.out.close();
        this.encoder = null;
        this.bytes = null;
      }
      return;
    }
  }
  
  public void flush()
  {
    flushBytes(true);
  }
  
  public void write(int paramInt)
  {
    synchronized (this.lock)
    {
      checkStatus();
      convert(CharBuffer.wrap(new char[] { (char)paramInt }));
      return;
    }
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    localObject = this.lock;
    if ((paramInt2 < 0) || ((paramString == null) || ((paramInt1 | paramInt2) >= 0))) {}
    try
    {
      if (paramInt1 <= paramString.length() - paramInt2)
      {
        checkStatus();
        convert(CharBuffer.wrap(paramString, paramInt1, paramInt2 + paramInt1));
        return;
      }
      localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("length=");
      localStringBuilder.append(paramString.length());
      localStringBuilder.append("; regionStart=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("; regionLength=");
      localStringBuilder.append(paramInt2);
      throw new StringIndexOutOfBoundsException(localStringBuilder.toString());
    }
    finally {}
    throw new NullPointerException("str == null");
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("length=");
    localStringBuilder.append(paramString.length());
    localStringBuilder.append("; regionStart=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; regionLength=");
    localStringBuilder.append(paramInt2);
    throw new StringIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      if (this.bytes.capacity() - this.bytes.limit() < paramInt2) {
        flushBytes(false);
      }
      this.bytes.put(paramArrayOfByte, paramInt1, paramInt2);
      if (this.bytes.limit() == this.bytes.capacity()) {
        flushBytes(false);
      }
      return;
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      checkStatus();
      checkOffsetAndCount(paramArrayOfChar.length, paramInt1, paramInt2);
      convert(wrap(paramArrayOfChar, paramInt1, paramInt2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.QLogWriter
 * JD-Core Version:    0.7.0.1
 */