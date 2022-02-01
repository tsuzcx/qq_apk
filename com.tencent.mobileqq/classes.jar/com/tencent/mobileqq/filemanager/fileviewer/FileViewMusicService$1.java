package com.tencent.mobileqq.filemanager.fileviewer;

class FileViewMusicService$1
  implements Runnable
{
  FileViewMusicService$1(FileViewMusicService paramFileViewMusicService, String paramString, FileViewMusicService.IGetTotalTime paramIGetTotalTime) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 30	android/media/MediaPlayer
    //   3: dup
    //   4: invokespecial 31	android/media/MediaPlayer:<init>	()V
    //   7: astore 4
    //   9: new 33	java/io/FileInputStream
    //   12: dup
    //   13: new 35	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: getfield 17	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload 4
    //   32: iconst_3
    //   33: invokevirtual 45	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   36: aload_2
    //   37: astore_1
    //   38: aload 4
    //   40: aload_2
    //   41: invokevirtual 49	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   44: invokevirtual 53	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   47: aload_2
    //   48: astore_1
    //   49: aload 4
    //   51: new 55	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService$1$1
    //   54: dup
    //   55: aload_0
    //   56: aload 4
    //   58: invokespecial 58	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService$1$1:<init>	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService$1;Landroid/media/MediaPlayer;)V
    //   61: invokevirtual 62	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   64: aload_2
    //   65: astore_1
    //   66: aload 4
    //   68: invokevirtual 65	android/media/MediaPlayer:prepareAsync	()V
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 68	java/io/FileInputStream:close	()V
    //   79: return
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   85: return
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: astore_1
    //   91: aload_3
    //   92: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   95: aload 4
    //   97: ifnull +17 -> 114
    //   100: aload_2
    //   101: astore_1
    //   102: aload 4
    //   104: invokevirtual 75	android/media/MediaPlayer:stop	()V
    //   107: aload_2
    //   108: astore_1
    //   109: aload 4
    //   111: invokevirtual 78	android/media/MediaPlayer:release	()V
    //   114: aload_2
    //   115: ifnull -36 -> 79
    //   118: aload_2
    //   119: invokevirtual 68	java/io/FileInputStream:close	()V
    //   122: return
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   128: return
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 68	java/io/FileInputStream:close	()V
    //   140: aload_2
    //   141: athrow
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   147: goto -7 -> 140
    //   150: astore_2
    //   151: goto -19 -> 132
    //   154: astore_3
    //   155: goto -66 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	1
    //   29	37	1	localFileInputStream1	java.io.FileInputStream
    //   80	2	1	localIOException1	java.io.IOException
    //   90	19	1	localFileInputStream2	java.io.FileInputStream
    //   123	2	1	localIOException2	java.io.IOException
    //   131	6	1	localObject1	Object
    //   142	2	1	localIOException3	java.io.IOException
    //   27	92	2	localFileInputStream3	java.io.FileInputStream
    //   129	12	2	localObject2	Object
    //   150	1	2	localObject3	Object
    //   86	6	3	localException1	java.lang.Exception
    //   154	1	3	localException2	java.lang.Exception
    //   7	103	4	localMediaPlayer	android.media.MediaPlayer
    // Exception table:
    //   from	to	target	type
    //   75	79	80	java/io/IOException
    //   9	28	86	java/lang/Exception
    //   118	122	123	java/io/IOException
    //   9	28	129	finally
    //   136	140	142	java/io/IOException
    //   30	36	150	finally
    //   38	47	150	finally
    //   49	64	150	finally
    //   66	71	150	finally
    //   91	95	150	finally
    //   102	107	150	finally
    //   109	114	150	finally
    //   30	36	154	java/lang/Exception
    //   38	47	154	java/lang/Exception
    //   49	64	154	java/lang/Exception
    //   66	71	154	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService.1
 * JD-Core Version:    0.7.0.1
 */