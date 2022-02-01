package com.tencent.mobileqq.cmshow.engine.resource.downloader;

import com.tencent.mobileqq.vip.DownloadListener;
import java.io.File;

class AbsApolloResDownloader$3
  extends DownloadListener
{
  AbsApolloResDownloader$3(AbsApolloResDownloader paramAbsApolloResDownloader, File paramFile) {}
  
  /* Error */
  public void onDone(com.tencent.mobileqq.vip.DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 26	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   5: iconst_3
    //   6: aload_1
    //   7: invokevirtual 32	com/tencent/mobileqq/vip/DownloadTask:e	()I
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 14	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:a	Ljava/io/File;
    //   18: invokestatic 37	com/tencent/mobileqq/cmshow/engine/util/CMResUtil:b	(Ljava/io/File;)Z
    //   21: ifne +17 -> 38
    //   24: aload_0
    //   25: getfield 12	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:b	Lcom/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader;
    //   28: invokevirtual 42	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader:b	()Ljava/lang/String;
    //   31: iconst_1
    //   32: ldc 44
    //   34: invokestatic 50	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: aload_0
    //   39: getfield 14	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:a	Ljava/io/File;
    //   42: astore_1
    //   43: new 52	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 14	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:a	Ljava/io/File;
    //   56: invokevirtual 58	java/io/File:getParent	()Ljava/lang/String;
    //   59: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_2
    //   64: getstatic 66	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: aload_2
    //   73: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 75	com/tencent/biz/common/util/ZipUtils:unZipFile	(Ljava/io/File;Ljava/lang/String;)V
    //   79: aload_0
    //   80: getfield 14	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:a	Ljava/io/File;
    //   83: invokevirtual 79	java/io/File:delete	()Z
    //   86: pop
    //   87: return
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 12	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:b	Lcom/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader;
    //   93: invokevirtual 42	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader:b	()Ljava/lang/String;
    //   96: iconst_1
    //   97: ldc 81
    //   99: aload_1
    //   100: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: return
    //   104: astore_1
    //   105: goto +51 -> 156
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 12	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:b	Lcom/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader;
    //   113: invokevirtual 42	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader:b	()Ljava/lang/String;
    //   116: astore_2
    //   117: new 52	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   124: astore_3
    //   125: aload_3
    //   126: ldc 86
    //   128: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_3
    //   133: aload_1
    //   134: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_2
    //   139: iconst_1
    //   140: aload_3
    //   141: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 91	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_0
    //   148: getfield 14	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:a	Ljava/io/File;
    //   151: invokevirtual 79	java/io/File:delete	()Z
    //   154: pop
    //   155: return
    //   156: aload_0
    //   157: getfield 14	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:a	Ljava/io/File;
    //   160: invokevirtual 79	java/io/File:delete	()Z
    //   163: pop
    //   164: goto +18 -> 182
    //   167: astore_2
    //   168: aload_0
    //   169: getfield 12	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader$3:b	Lcom/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader;
    //   172: invokevirtual 42	com/tencent/mobileqq/cmshow/engine/resource/downloader/AbsApolloResDownloader:b	()Ljava/lang/String;
    //   175: iconst_1
    //   176: ldc 81
    //   178: aload_2
    //   179: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	3
    //   0	184	1	paramDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    //   50	89	2	localObject	java.lang.Object
    //   167	12	2	localException	java.lang.Exception
    //   124	17	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   79	87	88	java/lang/Exception
    //   147	155	88	java/lang/Exception
    //   38	79	104	finally
    //   109	147	104	finally
    //   38	79	108	java/lang/Throwable
    //   156	164	167	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.downloader.AbsApolloResDownloader.3
 * JD-Core Version:    0.7.0.1
 */