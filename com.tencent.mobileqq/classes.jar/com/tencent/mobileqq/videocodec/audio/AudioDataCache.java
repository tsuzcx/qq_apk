package com.tencent.mobileqq.videocodec.audio;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class AudioDataCache
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE);
  private String b;
  private String c;
  private FileOutputStream d;
  
  public AudioDataCache(String paramString)
  {
    this.b = paramString;
    paramString = new StringBuilder();
    paramString.append(this.b);
    paramString.append(File.separator);
    paramString.append("audio_data_cache");
    paramString.append(File.separator);
    this.b = paramString.toString();
    paramString = new File(this.b);
    boolean bool1 = paramString.mkdirs();
    boolean bool2 = paramString.isDirectory();
    if ((!bool1) && (!bool2))
    {
      paramString = new StringBuilder();
      paramString.append("AudioDataCache: mkd=");
      paramString.append(bool1);
      paramString.append(" isdir=");
      paramString.append(bool2);
      QLog.e("AudioDataCache", 2, new RuntimeException(paramString.toString()), new Object[0]);
    }
  }
  
  public static String b()
  {
    synchronized (a)
    {
      int i = new Random().nextInt(10000);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a.format(new Date()));
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
  }
  
  public void a()
  {
    Object localObject1;
    label129:
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initCache: oldpath=");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(" mOutStream=");
        ((StringBuilder)localObject1).append(this.d);
        QLog.d("AudioDataCache", 2, ((StringBuilder)localObject1).toString());
      }
      this.c = b();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(this.c);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = new File((String)localObject1);
      boolean bool = ((File)localObject3).exists();
      if (bool) {}
    }
    finally {}
    try
    {
      this.d = new FileOutputStream((File)localObject3);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label129;
    }
    this.d = null;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initCache: newPath=");
      ((StringBuilder)localObject1).append(this.c);
      QLog.d("AudioDataCache", 2, ((StringBuilder)localObject1).toString());
    }
    return;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("AudioDataCache: file exists| ");
    ((StringBuilder)localObject3).append((String)localObject1);
    throw new RuntimeException(((StringBuilder)localObject3).toString());
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    try
    {
      FileOutputStream localFileOutputStream = this.d;
      boolean bool1 = bool2;
      if (localFileOutputStream != null) {
        try
        {
          this.d.write(paramArrayOfByte, paramInt1, paramInt2);
          bool1 = true;
        }
        catch (IOException paramArrayOfByte)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("AudioDataCache", 2, "writeData: exception", paramArrayOfByte);
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  /* Error */
  public String c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +37 -> 42
    //   8: new 37	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   15: astore_1
    //   16: aload_1
    //   17: ldc 146
    //   19: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 108	com/tencent/mobileqq/videocodec/audio/AudioDataCache:c	Ljava/lang/String;
    //   28: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: ldc 71
    //   34: iconst_2
    //   35: aload_1
    //   36: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: new 37	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   49: astore_1
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 35	com/tencent/mobileqq/videocodec/audio/AudioDataCache:b	Ljava/lang/String;
    //   55: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_1
    //   60: aload_0
    //   61: getfield 108	com/tencent/mobileqq/videocodec/audio/AudioDataCache:c	Ljava/lang/String;
    //   64: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 112	com/tencent/mobileqq/videocodec/audio/AudioDataCache:d	Ljava/io/FileOutputStream;
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +10 -> 89
    //   82: aload_0
    //   83: getfield 112	com/tencent/mobileqq/videocodec/audio/AudioDataCache:d	Ljava/io/FileOutputStream;
    //   86: invokevirtual 149	java/io/FileOutputStream:close	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: areturn
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    //   98: astore_2
    //   99: goto -10 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	AudioDataCache
    //   15	77	1	localObject1	Object
    //   93	4	1	localObject2	Object
    //   77	2	2	localFileOutputStream	FileOutputStream
    //   98	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	42	93	finally
    //   42	78	93	finally
    //   82	89	93	finally
    //   82	89	98	java/io/IOException
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioDataCache
 * JD-Core Version:    0.7.0.1
 */