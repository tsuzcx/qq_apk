package com.tencent.mobileqq.video;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;

public class AioVideoTransFileController
{
  /* Error */
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 13	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   10: aload_1
    //   11: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: lload_2
    //   15: invokevirtual 21	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   18: invokevirtual 25	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: astore_1
    //   22: aload_0
    //   23: ldc 27
    //   25: invokevirtual 33	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   28: checkcast 27	com/tencent/mobileqq/transfile/api/ITransFileController
    //   31: aload_1
    //   32: invokeinterface 37 2 0
    //   37: astore_0
    //   38: aload_0
    //   39: ifnull +26 -> 65
    //   42: aload_0
    //   43: instanceof 39
    //   46: ifeq +19 -> 65
    //   49: aload_0
    //   50: checkcast 39	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor
    //   53: invokevirtual 42	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:pause	()V
    //   56: iconst_1
    //   57: istore 4
    //   59: ldc 2
    //   61: monitorexit
    //   62: iload 4
    //   64: ireturn
    //   65: iconst_0
    //   66: istore 4
    //   68: goto -9 -> 59
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramQQAppInterface	QQAppInterface
    //   0	77	1	paramString	String
    //   0	77	2	paramLong	long
    //   57	10	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	38	71	finally
    //   42	56	71	finally
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        String str = paramString + paramLong;
        paramQQAppInterface = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
        if (paramQQAppInterface.containsProcessor(paramString, paramLong))
        {
          paramQQAppInterface = paramQQAppInterface.findProcessor(str);
          if (paramQQAppInterface != null)
          {
            if ((paramQQAppInterface instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)paramQQAppInterface).pause();
            }
          }
          else
          {
            bool = true;
            return bool;
          }
          if (!(paramQQAppInterface instanceof ShortVideoForwardProcessor)) {
            continue;
          }
          ((ShortVideoForwardProcessor)paramQQAppInterface).pause();
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramQQAppInterface = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
        String str = paramString + paramLong;
        if (paramQQAppInterface.containsProcessor(paramString, paramLong))
        {
          paramQQAppInterface = paramQQAppInterface.findProcessor(str);
          if (((paramQQAppInterface instanceof ShortVideoUploadProcessor)) && (((ShortVideoUploadProcessor)paramQQAppInterface).isPause()))
          {
            ((ShortVideoUploadProcessor)paramQQAppInterface).resume();
            bool = true;
            return bool;
          }
        }
      }
      finally
      {
        paramQQAppInterface = finally;
        throw paramQQAppInterface;
      }
      boolean bool = false;
    }
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        String str = paramString + paramLong;
        paramQQAppInterface = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
        if (paramQQAppInterface.containsProcessor(paramString, paramLong))
        {
          paramString = paramQQAppInterface.findProcessor(str);
          if (paramString != null)
          {
            if ((paramString instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)paramString).pause();
            }
          }
          else
          {
            paramQQAppInterface.removeProcessor(str);
            bool = true;
            return bool;
          }
          if (!(paramString instanceof ShortVideoForwardProcessor)) {
            continue;
          }
          ((ShortVideoForwardProcessor)paramString).pause();
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.video.AioVideoTransFileController
 * JD-Core Version:    0.7.0.1
 */