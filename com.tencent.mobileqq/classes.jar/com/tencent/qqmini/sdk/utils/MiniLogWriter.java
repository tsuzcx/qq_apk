package com.tencent.qqmini.sdk.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class MiniLogWriter
  extends Writer
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
  
  public MiniLogWriter(File paramFile, boolean paramBoolean)
  {
    this(new BufferedOutputStream(new FileOutputStream(paramFile, paramBoolean)));
  }
  
  public MiniLogWriter(OutputStream paramOutputStream)
  {
    this(paramOutputStream, Charset.defaultCharset());
  }
  
  public MiniLogWriter(OutputStream paramOutputStream, String paramString)
  {
    super(paramOutputStream);
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.out = paramOutputStream;
    try
    {
      this.encoder = Charset.forName(paramString).newEncoder();
      this.encoder.onMalformedInput(CodingErrorAction.REPLACE);
      this.encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
      return;
    }
    catch (Exception paramOutputStream)
    {
      throw new UnsupportedEncodingException(paramString);
    }
  }
  
  public MiniLogWriter(OutputStream paramOutputStream, Charset paramCharset)
  {
    super(paramOutputStream);
    this.out = paramOutputStream;
    this.encoder = paramCharset.newEncoder();
    this.encoder.onMalformedInput(CodingErrorAction.REPLACE);
    this.encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
  }
  
  public MiniLogWriter(OutputStream paramOutputStream, CharsetEncoder paramCharsetEncoder)
  {
    super(paramOutputStream);
    paramCharsetEncoder.charset();
    this.out = paramOutputStream;
    this.encoder = paramCharsetEncoder;
  }
  
  public static void checkOffsetAndCount(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3))
    {
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("length=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("; regionStart=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("; regionLength=");
      localStringBuilder.append(paramInt3);
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
  }
  
  private void checkStatus()
  {
    if (this.encoder == null) {
      throw new IOException("OutputStreamWriter is closed");
    }
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
    CoderResult localCoderResult = this.encoder.encode((CharBuffer)localObject, this.bytes, true);
    if (localCoderResult.isError())
    {
      localCoderResult.throwException();
      label30:
      localObject = this.encoder.flush(this.bytes);
    }
    for (;;)
    {
      if (((CoderResult)localObject).isUnderflow()) {
        return;
      }
      if (((CoderResult)localObject).isOverflow())
      {
        flushBytes(false);
        localObject = this.encoder.flush(this.bytes);
        continue;
        if (!localCoderResult.isOverflow()) {
          break label30;
        }
        flushBytes(false);
        break;
      }
      ((CoderResult)localObject).throwException();
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
  
  /* Error */
  private CharBuffer wrap(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/qqmini/sdk/utils/MiniLogWriter:mInited	Z
    //   4: ifne +23 -> 27
    //   7: aload_0
    //   8: aload_1
    //   9: iload_2
    //   10: iload_3
    //   11: invokestatic 216	java/nio/CharBuffer:wrap	([CII)Ljava/nio/CharBuffer;
    //   14: putfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 54	com/tencent/qqmini/sdk/utils/MiniLogWriter:mInited	Z
    //   22: aload_0
    //   23: getfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   26: areturn
    //   27: getstatic 24	com/tencent/qqmini/sdk/utils/MiniLogWriter:mCanRecycle	Z
    //   30: ifeq +259 -> 289
    //   33: aload_0
    //   34: getfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   37: invokevirtual 219	java/nio/CharBuffer:clear	()Ljava/nio/Buffer;
    //   40: pop
    //   41: getstatic 221	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCharBufferClass	Ljava/lang/Class;
    //   44: ifnull +15 -> 59
    //   47: getstatic 223	com/tencent/qqmini/sdk/utils/MiniLogWriter:sBackingArrayField	Ljava/lang/reflect/Field;
    //   50: ifnull +9 -> 59
    //   53: getstatic 225	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCapacityField	Ljava/lang/reflect/Field;
    //   56: ifnonnull +87 -> 143
    //   59: getstatic 231	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 8
    //   64: if_icmplt +161 -> 225
    //   67: getstatic 231	android/os/Build$VERSION:SDK_INT	I
    //   70: bipush 17
    //   72: if_icmpgt +153 -> 225
    //   75: ldc 233
    //   77: invokestatic 238	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   80: putstatic 221	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCharBufferClass	Ljava/lang/Class;
    //   83: getstatic 221	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCharBufferClass	Ljava/lang/Class;
    //   86: invokevirtual 242	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   89: ldc 244
    //   91: invokevirtual 248	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   94: putstatic 223	com/tencent/qqmini/sdk/utils/MiniLogWriter:sBackingArrayField	Ljava/lang/reflect/Field;
    //   97: getstatic 221	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCharBufferClass	Ljava/lang/Class;
    //   100: invokevirtual 242	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   103: invokevirtual 242	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   106: invokevirtual 242	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   109: ldc 250
    //   111: invokevirtual 248	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   114: putstatic 225	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCapacityField	Ljava/lang/reflect/Field;
    //   117: getstatic 223	com/tencent/qqmini/sdk/utils/MiniLogWriter:sBackingArrayField	Ljava/lang/reflect/Field;
    //   120: ifnull +10 -> 130
    //   123: getstatic 223	com/tencent/qqmini/sdk/utils/MiniLogWriter:sBackingArrayField	Ljava/lang/reflect/Field;
    //   126: iconst_1
    //   127: invokevirtual 255	java/lang/reflect/Field:setAccessible	(Z)V
    //   130: getstatic 225	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCapacityField	Ljava/lang/reflect/Field;
    //   133: ifnull +10 -> 143
    //   136: getstatic 225	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCapacityField	Ljava/lang/reflect/Field;
    //   139: iconst_1
    //   140: invokevirtual 255	java/lang/reflect/Field:setAccessible	(Z)V
    //   143: getstatic 225	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCapacityField	Ljava/lang/reflect/Field;
    //   146: ifnull +134 -> 280
    //   149: getstatic 223	com/tencent/qqmini/sdk/utils/MiniLogWriter:sBackingArrayField	Ljava/lang/reflect/Field;
    //   152: ifnull +128 -> 280
    //   155: getstatic 221	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCharBufferClass	Ljava/lang/Class;
    //   158: ifnull +122 -> 280
    //   161: getstatic 221	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCharBufferClass	Ljava/lang/Class;
    //   164: aload_0
    //   165: getfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   168: invokevirtual 259	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   171: ifeq +109 -> 280
    //   174: getstatic 223	com/tencent/qqmini/sdk/utils/MiniLogWriter:sBackingArrayField	Ljava/lang/reflect/Field;
    //   177: aload_0
    //   178: getfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   181: aload_1
    //   182: invokevirtual 263	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   185: getstatic 225	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCapacityField	Ljava/lang/reflect/Field;
    //   188: aload_0
    //   189: getfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   192: aload_1
    //   193: arraylength
    //   194: invokestatic 269	com/tencent/qqmini/sdk/utils/MiniLogWriter$LargerInteger:valueOf	(I)Ljava/lang/Integer;
    //   197: invokevirtual 263	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   200: aload_0
    //   201: getfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   204: iload_2
    //   205: invokevirtual 272	java/nio/CharBuffer:position	(I)Ljava/nio/Buffer;
    //   208: pop
    //   209: aload_0
    //   210: getfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   213: iload_2
    //   214: iload_3
    //   215: iadd
    //   216: invokevirtual 275	java/nio/CharBuffer:limit	(I)Ljava/nio/Buffer;
    //   219: pop
    //   220: aload_0
    //   221: getfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   224: areturn
    //   225: getstatic 231	android/os/Build$VERSION:SDK_INT	I
    //   228: bipush 18
    //   230: if_icmplt -113 -> 117
    //   233: ldc_w 277
    //   236: invokestatic 238	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   239: putstatic 221	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCharBufferClass	Ljava/lang/Class;
    //   242: getstatic 221	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCharBufferClass	Ljava/lang/Class;
    //   245: ldc 244
    //   247: invokevirtual 248	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   250: putstatic 223	com/tencent/qqmini/sdk/utils/MiniLogWriter:sBackingArrayField	Ljava/lang/reflect/Field;
    //   253: getstatic 221	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCharBufferClass	Ljava/lang/Class;
    //   256: invokevirtual 242	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   259: invokevirtual 242	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   262: ldc 250
    //   264: invokevirtual 248	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   267: putstatic 225	com/tencent/qqmini/sdk/utils/MiniLogWriter:sCapacityField	Ljava/lang/reflect/Field;
    //   270: goto -153 -> 117
    //   273: astore 4
    //   275: aload 4
    //   277: invokevirtual 280	java/lang/ClassNotFoundException:printStackTrace	()V
    //   280: iconst_0
    //   281: putstatic 24	com/tencent/qqmini/sdk/utils/MiniLogWriter:mCanRecycle	Z
    //   284: aload_0
    //   285: aconst_null
    //   286: putfield 218	com/tencent/qqmini/sdk/utils/MiniLogWriter:mRecycleBuffer	Ljava/nio/CharBuffer;
    //   289: aload_1
    //   290: iload_2
    //   291: iload_3
    //   292: invokestatic 216	java/nio/CharBuffer:wrap	([CII)Ljava/nio/CharBuffer;
    //   295: areturn
    //   296: astore 4
    //   298: aload 4
    //   300: invokevirtual 281	java/lang/NoSuchFieldException:printStackTrace	()V
    //   303: goto -23 -> 280
    //   306: astore 4
    //   308: aload 4
    //   310: invokevirtual 282	java/lang/IllegalArgumentException:printStackTrace	()V
    //   313: goto -33 -> 280
    //   316: astore 4
    //   318: aload 4
    //   320: invokevirtual 283	java/lang/IllegalAccessException:printStackTrace	()V
    //   323: goto -43 -> 280
    //   326: astore 4
    //   328: aload 4
    //   330: invokevirtual 284	java/lang/Throwable:printStackTrace	()V
    //   333: goto -53 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	MiniLogWriter
    //   0	336	1	paramArrayOfChar	char[]
    //   0	336	2	paramInt1	int
    //   0	336	3	paramInt2	int
    //   273	3	4	localClassNotFoundException	java.lang.ClassNotFoundException
    //   296	3	4	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   306	3	4	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   316	3	4	localIllegalAccessException	java.lang.IllegalAccessException
    //   326	3	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   41	59	273	java/lang/ClassNotFoundException
    //   59	117	273	java/lang/ClassNotFoundException
    //   117	130	273	java/lang/ClassNotFoundException
    //   130	143	273	java/lang/ClassNotFoundException
    //   143	225	273	java/lang/ClassNotFoundException
    //   225	270	273	java/lang/ClassNotFoundException
    //   41	59	296	java/lang/NoSuchFieldException
    //   59	117	296	java/lang/NoSuchFieldException
    //   117	130	296	java/lang/NoSuchFieldException
    //   130	143	296	java/lang/NoSuchFieldException
    //   143	225	296	java/lang/NoSuchFieldException
    //   225	270	296	java/lang/NoSuchFieldException
    //   41	59	306	java/lang/IllegalArgumentException
    //   59	117	306	java/lang/IllegalArgumentException
    //   117	130	306	java/lang/IllegalArgumentException
    //   130	143	306	java/lang/IllegalArgumentException
    //   143	225	306	java/lang/IllegalArgumentException
    //   225	270	306	java/lang/IllegalArgumentException
    //   41	59	316	java/lang/IllegalAccessException
    //   59	117	316	java/lang/IllegalAccessException
    //   117	130	316	java/lang/IllegalAccessException
    //   130	143	316	java/lang/IllegalAccessException
    //   143	225	316	java/lang/IllegalAccessException
    //   225	270	316	java/lang/IllegalAccessException
    //   41	59	326	java/lang/Throwable
    //   59	117	326	java/lang/Throwable
    //   117	130	326	java/lang/Throwable
    //   130	143	326	java/lang/Throwable
    //   143	225	326	java/lang/Throwable
    //   225	270	326	java/lang/Throwable
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
    Object localObject = this.lock;
    StringBuilder localStringBuilder;
    if (paramInt2 < 0) {
      try
      {
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
    }
    if (paramString == null) {
      throw new NullPointerException("str == null");
    }
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > paramString.length() - paramInt2))
    {
      localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("length=");
      localStringBuilder.append(paramString.length());
      localStringBuilder.append("; regionStart=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("; regionLength=");
      localStringBuilder.append(paramInt2);
      throw new StringIndexOutOfBoundsException(localStringBuilder.toString());
    }
    checkStatus();
    convert(CharBuffer.wrap(paramString, paramInt1, paramInt2 + paramInt1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniLogWriter
 * JD-Core Version:    0.7.0.1
 */