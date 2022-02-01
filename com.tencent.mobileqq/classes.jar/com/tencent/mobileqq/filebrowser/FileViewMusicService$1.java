package com.tencent.mobileqq.filebrowser;

class FileViewMusicService$1
  implements Runnable
{
  FileViewMusicService$1(FileViewMusicService paramFileViewMusicService, String paramString, FileViewMusicService.IGetTotalTime paramIGetTotalTime) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 30	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   3: dup
    //   4: invokespecial 31	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   7: astore 4
    //   9: new 33	java/io/FileInputStream
    //   12: dup
    //   13: new 35	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: getfield 17	com/tencent/mobileqq/filebrowser/FileViewMusicService$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload 4
    //   32: iconst_3
    //   33: invokevirtual 47	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   36: aload_2
    //   37: astore_1
    //   38: aload 4
    //   40: aload_2
    //   41: invokevirtual 51	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   44: invokevirtual 55	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   47: aload_2
    //   48: astore_1
    //   49: aload 4
    //   51: new 57	com/tencent/mobileqq/filebrowser/FileViewMusicService$1$1
    //   54: dup
    //   55: aload_0
    //   56: aload 4
    //   58: invokespecial 60	com/tencent/mobileqq/filebrowser/FileViewMusicService$1$1:<init>	(Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$1;Landroid/media/MediaPlayer;)V
    //   61: invokevirtual 64	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   64: aload_2
    //   65: astore_1
    //   66: aload 4
    //   68: invokevirtual 67	android/media/MediaPlayer:prepareAsync	()V
    //   71: aload_2
    //   72: invokevirtual 70	java/io/FileInputStream:close	()V
    //   75: return
    //   76: astore_3
    //   77: goto +12 -> 89
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_2
    //   83: goto +46 -> 129
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: astore_1
    //   91: aload_3
    //   92: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   95: aload_2
    //   96: astore_1
    //   97: aload 4
    //   99: invokevirtual 76	android/media/MediaPlayer:stop	()V
    //   102: aload_2
    //   103: astore_1
    //   104: aload 4
    //   106: invokevirtual 79	android/media/MediaPlayer:release	()V
    //   109: aload_2
    //   110: ifnull +13 -> 123
    //   113: aload_2
    //   114: invokevirtual 70	java/io/FileInputStream:close	()V
    //   117: return
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   123: return
    //   124: astore_3
    //   125: aload_1
    //   126: astore_2
    //   127: aload_3
    //   128: astore_1
    //   129: aload_2
    //   130: ifnull +15 -> 145
    //   133: aload_2
    //   134: invokevirtual 70	java/io/FileInputStream:close	()V
    //   137: goto +8 -> 145
    //   140: astore_2
    //   141: aload_2
    //   142: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	1
    //   29	37	1	localObject1	Object
    //   80	1	1	localObject2	Object
    //   90	14	1	localObject3	Object
    //   118	8	1	localIOException1	java.io.IOException
    //   128	18	1	localObject4	Object
    //   27	107	2	localObject5	Object
    //   140	2	2	localIOException2	java.io.IOException
    //   76	1	3	localException1	java.lang.Exception
    //   86	6	3	localException2	java.lang.Exception
    //   124	4	3	localObject6	Object
    //   7	98	4	localReportMediaPlayer	com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer
    // Exception table:
    //   from	to	target	type
    //   30	36	76	java/lang/Exception
    //   38	47	76	java/lang/Exception
    //   49	64	76	java/lang/Exception
    //   66	71	76	java/lang/Exception
    //   9	28	80	finally
    //   9	28	86	java/lang/Exception
    //   71	75	118	java/io/IOException
    //   113	117	118	java/io/IOException
    //   30	36	124	finally
    //   38	47	124	finally
    //   49	64	124	finally
    //   66	71	124	finally
    //   91	95	124	finally
    //   97	102	124	finally
    //   104	109	124	finally
    //   133	137	140	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileViewMusicService.1
 * JD-Core Version:    0.7.0.1
 */