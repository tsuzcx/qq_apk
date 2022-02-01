package com.tencent.mobileqq.vashealth.api.impl;

import android.media.MediaPlayer.OnCompletionListener;
import java.util.ArrayList;

final class PathTraceManagerImpl$4
  implements MediaPlayer.OnCompletionListener
{
  PathTraceManagerImpl$4(ArrayList paramArrayList) {}
  
  /* Error */
  public void onCompletion(android.media.MediaPlayer paramMediaPlayer)
  {
    // Byte code:
    //   0: invokestatic 28	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:access$700	()I
    //   3: aload_0
    //   4: getfield 12	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl$4:a	Ljava/util/ArrayList;
    //   7: invokevirtual 33	java/util/ArrayList:size	()I
    //   10: iconst_1
    //   11: isub
    //   12: if_icmpge +147 -> 159
    //   15: invokestatic 28	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:access$700	()I
    //   18: iconst_1
    //   19: iadd
    //   20: invokestatic 37	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:access$702	(I)I
    //   23: pop
    //   24: getstatic 41	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   27: invokevirtual 46	android/media/MediaPlayer:reset	()V
    //   30: aconst_null
    //   31: astore_3
    //   32: aconst_null
    //   33: astore_1
    //   34: new 48	java/io/FileInputStream
    //   37: dup
    //   38: new 50	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: getfield 12	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl$4:a	Ljava/util/ArrayList;
    //   46: invokestatic 28	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:access$700	()I
    //   49: invokevirtual 54	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   52: checkcast 56	android/net/Uri
    //   55: invokevirtual 60	android/net/Uri:getPath	()Ljava/lang/String;
    //   58: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore_2
    //   65: getstatic 41	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   68: aload_2
    //   69: invokevirtual 70	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   72: invokevirtual 74	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   75: getstatic 41	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   78: invokevirtual 77	android/media/MediaPlayer:prepare	()V
    //   81: getstatic 41	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:mediaPalyer	Landroid/media/MediaPlayer;
    //   84: invokevirtual 80	android/media/MediaPlayer:start	()V
    //   87: aload_2
    //   88: invokevirtual 83	java/io/FileInputStream:close	()V
    //   91: return
    //   92: astore_1
    //   93: aload_2
    //   94: astore_3
    //   95: aload_1
    //   96: astore_2
    //   97: aload_3
    //   98: astore_1
    //   99: goto +42 -> 141
    //   102: astore_3
    //   103: goto +12 -> 115
    //   106: astore_2
    //   107: goto +34 -> 141
    //   110: astore_1
    //   111: aload_3
    //   112: astore_2
    //   113: aload_1
    //   114: astore_3
    //   115: aload_2
    //   116: astore_1
    //   117: ldc 85
    //   119: iconst_1
    //   120: ldc 87
    //   122: aload_3
    //   123: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload_2
    //   127: ifnull +44 -> 171
    //   130: aload_2
    //   131: invokevirtual 83	java/io/FileInputStream:close	()V
    //   134: return
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   140: return
    //   141: aload_1
    //   142: ifnull +15 -> 157
    //   145: aload_1
    //   146: invokevirtual 83	java/io/FileInputStream:close	()V
    //   149: goto +8 -> 157
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   157: aload_2
    //   158: athrow
    //   159: aload_0
    //   160: getfield 12	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl$4:a	Ljava/util/ArrayList;
    //   163: invokevirtual 99	java/util/ArrayList:clear	()V
    //   166: iconst_0
    //   167: invokestatic 37	com/tencent/mobileqq/vashealth/api/impl/PathTraceManagerImpl:access$702	(I)I
    //   170: pop
    //   171: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	4
    //   0	172	1	paramMediaPlayer	android.media.MediaPlayer
    //   64	33	2	localObject1	Object
    //   106	1	2	localObject2	Object
    //   112	46	2	localException1	java.lang.Exception
    //   31	67	3	localObject3	Object
    //   102	10	3	localException2	java.lang.Exception
    //   114	9	3	localMediaPlayer	android.media.MediaPlayer
    // Exception table:
    //   from	to	target	type
    //   65	87	92	finally
    //   65	87	102	java/lang/Exception
    //   34	65	106	finally
    //   117	126	106	finally
    //   34	65	110	java/lang/Exception
    //   87	91	135	java/io/IOException
    //   130	134	135	java/io/IOException
    //   145	149	152	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */