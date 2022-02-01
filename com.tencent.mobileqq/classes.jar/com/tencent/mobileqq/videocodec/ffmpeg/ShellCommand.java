package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.IOException;

class ShellCommand
{
  Process run(String[] paramArrayOfString)
  {
    try
    {
      Process localProcess = Runtime.getRuntime().exec(paramArrayOfString);
      return localProcess;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception while trying to run: ");
      localStringBuilder.append(paramArrayOfString);
      SLog.c("FFmpegCmd", localStringBuilder.toString(), localIOException);
    }
    return null;
  }
  
  /* Error */
  CommandResult runWaitFor(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 52	com/tencent/mobileqq/videocodec/ffmpeg/ShellCommand:run	([Ljava/lang/String;)Ljava/lang/Process;
    //   5: astore 4
    //   7: aconst_null
    //   8: astore_3
    //   9: aload 4
    //   11: ifnull +74 -> 85
    //   14: aload 4
    //   16: invokevirtual 58	java/lang/Process:waitFor	()I
    //   19: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: astore_1
    //   23: aload_1
    //   24: invokestatic 70	com/tencent/mobileqq/videocodec/ffmpeg/CommandResult:success	(Ljava/lang/Integer;)Z
    //   27: ifeq +15 -> 42
    //   30: aload 4
    //   32: invokevirtual 74	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   35: invokestatic 80	com/tencent/mobileqq/videocodec/ffmpeg/Util:convertInputStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   38: astore_2
    //   39: goto +50 -> 89
    //   42: aload 4
    //   44: invokevirtual 83	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   47: invokestatic 80	com/tencent/mobileqq/videocodec/ffmpeg/Util:convertInputStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   50: astore_2
    //   51: goto +38 -> 89
    //   54: astore_2
    //   55: goto +10 -> 65
    //   58: astore_1
    //   59: goto +19 -> 78
    //   62: astore_2
    //   63: aconst_null
    //   64: astore_1
    //   65: ldc 36
    //   67: ldc 85
    //   69: aload_2
    //   70: invokestatic 46	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_3
    //   74: astore_2
    //   75: goto +14 -> 89
    //   78: aload 4
    //   80: invokestatic 89	com/tencent/mobileqq/videocodec/ffmpeg/Util:destroyProcess	(Ljava/lang/Process;)V
    //   83: aload_1
    //   84: athrow
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_3
    //   88: astore_2
    //   89: aload 4
    //   91: invokestatic 89	com/tencent/mobileqq/videocodec/ffmpeg/Util:destroyProcess	(Ljava/lang/Process;)V
    //   94: new 66	com/tencent/mobileqq/videocodec/ffmpeg/CommandResult
    //   97: dup
    //   98: aload_1
    //   99: invokestatic 70	com/tencent/mobileqq/videocodec/ffmpeg/CommandResult:success	(Ljava/lang/Integer;)Z
    //   102: aload_2
    //   103: invokespecial 92	com/tencent/mobileqq/videocodec/ffmpeg/CommandResult:<init>	(ZLjava/lang/String;)V
    //   106: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	ShellCommand
    //   0	107	1	paramArrayOfString	String[]
    //   38	13	2	str	String
    //   54	1	2	localInterruptedException1	java.lang.InterruptedException
    //   62	8	2	localInterruptedException2	java.lang.InterruptedException
    //   74	29	2	localObject1	Object
    //   8	80	3	localObject2	Object
    //   5	85	4	localProcess	Process
    // Exception table:
    //   from	to	target	type
    //   23	39	54	java/lang/InterruptedException
    //   42	51	54	java/lang/InterruptedException
    //   14	23	58	finally
    //   23	39	58	finally
    //   42	51	58	finally
    //   65	73	58	finally
    //   14	23	62	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.ShellCommand
 * JD-Core Version:    0.7.0.1
 */