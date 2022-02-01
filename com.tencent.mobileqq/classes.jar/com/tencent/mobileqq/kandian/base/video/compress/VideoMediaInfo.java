package com.tencent.mobileqq.kandian.base.video.compress;

public class VideoMediaInfo
{
  public int a;
  public long a;
  public int b;
  public long b;
  public int c;
  public long c;
  public long d;
  
  /* Error */
  @android.support.annotation.RequiresApi(api=16)
  public static VideoMediaInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 31	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 38	java/io/File:exists	()Z
    //   24: ifeq +334 -> 358
    //   27: aload 4
    //   29: invokevirtual 41	java/io/File:isFile	()Z
    //   32: ifeq +326 -> 358
    //   35: aload 4
    //   37: invokevirtual 45	java/io/File:length	()J
    //   40: lconst_0
    //   41: lcmp
    //   42: ifne +6 -> 48
    //   45: goto +313 -> 358
    //   48: new 2	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo
    //   51: dup
    //   52: invokespecial 46	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:<init>	()V
    //   55: astore_3
    //   56: aload_3
    //   57: aload 4
    //   59: invokevirtual 45	java/io/File:length	()J
    //   62: putfield 48	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:d	J
    //   65: new 50	android/media/MediaMetadataRetriever
    //   68: dup
    //   69: invokespecial 51	android/media/MediaMetadataRetriever:<init>	()V
    //   72: astore 4
    //   74: aload 4
    //   76: aload_0
    //   77: invokevirtual 54	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   80: aload_3
    //   81: aload 4
    //   83: bipush 18
    //   85: invokevirtual 58	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   88: invokestatic 64	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   91: invokevirtual 68	java/lang/Integer:intValue	()I
    //   94: putfield 70	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_a_of_type_Int	I
    //   97: aload_3
    //   98: aload 4
    //   100: bipush 19
    //   102: invokevirtual 58	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   105: invokestatic 64	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   108: invokevirtual 68	java/lang/Integer:intValue	()I
    //   111: putfield 72	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_b_of_type_Int	I
    //   114: aload_3
    //   115: aload 4
    //   117: bipush 24
    //   119: invokevirtual 58	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   122: invokestatic 64	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   125: invokevirtual 68	java/lang/Integer:intValue	()I
    //   128: putfield 74	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_c_of_type_Int	I
    //   131: aload_3
    //   132: aload 4
    //   134: bipush 9
    //   136: invokevirtual 58	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   139: invokestatic 64	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   142: invokevirtual 68	java/lang/Integer:intValue	()I
    //   145: i2l
    //   146: putfield 76	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_c_of_type_Long	J
    //   149: aload_3
    //   150: aload 4
    //   152: bipush 20
    //   154: invokevirtual 58	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   157: invokestatic 64	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   160: invokevirtual 68	java/lang/Integer:intValue	()I
    //   163: i2l
    //   164: putfield 78	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_b_of_type_Long	J
    //   167: goto +19 -> 186
    //   170: astore_0
    //   171: goto +180 -> 351
    //   174: astore 5
    //   176: ldc 80
    //   178: iconst_1
    //   179: ldc 82
    //   181: aload 5
    //   183: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   186: aload 4
    //   188: invokevirtual 91	android/media/MediaMetadataRetriever:release	()V
    //   191: new 93	android/media/MediaExtractor
    //   194: dup
    //   195: invokespecial 94	android/media/MediaExtractor:<init>	()V
    //   198: astore 4
    //   200: aload 4
    //   202: aload_0
    //   203: invokevirtual 95	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   206: aload 4
    //   208: invokevirtual 98	android/media/MediaExtractor:getTrackCount	()I
    //   211: istore_2
    //   212: iconst_0
    //   213: istore_1
    //   214: iload_1
    //   215: iload_2
    //   216: if_icmpge +91 -> 307
    //   219: aload 4
    //   221: iload_1
    //   222: invokevirtual 102	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   225: astore_0
    //   226: aload_0
    //   227: ldc 104
    //   229: invokevirtual 110	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   232: ldc 112
    //   234: invokevirtual 118	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   237: ifeq +63 -> 300
    //   240: aload_0
    //   241: ldc 120
    //   243: invokevirtual 123	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   246: ifeq +14 -> 260
    //   249: aload_3
    //   250: aload_0
    //   251: ldc 120
    //   253: invokevirtual 127	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   256: i2l
    //   257: putfield 129	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_a_of_type_Long	J
    //   260: aload_3
    //   261: getfield 76	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_c_of_type_Long	J
    //   264: lconst_0
    //   265: lcmp
    //   266: ifne +14 -> 280
    //   269: aload_3
    //   270: aload_0
    //   271: ldc 131
    //   273: invokevirtual 127	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   276: i2l
    //   277: putfield 76	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_c_of_type_Long	J
    //   280: aload_3
    //   281: getfield 78	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_b_of_type_Long	J
    //   284: lconst_0
    //   285: lcmp
    //   286: ifne +14 -> 300
    //   289: aload_3
    //   290: aload_0
    //   291: ldc 133
    //   293: invokevirtual 127	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   296: i2l
    //   297: putfield 78	com/tencent/mobileqq/kandian/base/video/compress/VideoMediaInfo:jdField_b_of_type_Long	J
    //   300: iload_1
    //   301: iconst_1
    //   302: iadd
    //   303: istore_1
    //   304: goto -90 -> 214
    //   307: aload 4
    //   309: invokevirtual 134	android/media/MediaExtractor:release	()V
    //   312: aload_3
    //   313: areturn
    //   314: astore_0
    //   315: goto +29 -> 344
    //   318: astore_0
    //   319: ldc 80
    //   321: iconst_1
    //   322: ldc 82
    //   324: aload_0
    //   325: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   328: goto -21 -> 307
    //   331: astore_0
    //   332: ldc 80
    //   334: iconst_1
    //   335: ldc 82
    //   337: aload_0
    //   338: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   341: goto -34 -> 307
    //   344: aload 4
    //   346: invokevirtual 134	android/media/MediaExtractor:release	()V
    //   349: aload_0
    //   350: athrow
    //   351: aload 4
    //   353: invokevirtual 91	android/media/MediaMetadataRetriever:release	()V
    //   356: aload_0
    //   357: athrow
    //   358: new 136	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   365: astore_3
    //   366: aload_3
    //   367: ldc 139
    //   369: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_3
    //   374: aload_0
    //   375: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: ldc 80
    //   381: iconst_1
    //   382: aload_3
    //   383: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: aconst_null
    //   390: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString	String
    //   213	91	1	i	int
    //   211	6	2	j	int
    //   55	328	3	localObject1	Object
    //   17	335	4	localObject2	Object
    //   174	8	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   74	167	170	finally
    //   176	186	170	finally
    //   74	167	174	java/lang/Throwable
    //   200	212	314	finally
    //   219	260	314	finally
    //   260	280	314	finally
    //   280	300	314	finally
    //   319	328	314	finally
    //   332	341	314	finally
    //   200	212	318	java/lang/Throwable
    //   219	260	318	java/lang/Throwable
    //   260	280	318	java/lang/Throwable
    //   280	300	318	java/lang/Throwable
    //   200	212	331	java/io/IOException
    //   219	260	331	java/io/IOException
    //   260	280	331	java/io/IOException
    //   280	300	331	java/io/IOException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("VideoMediaInfo[ ");
    localStringBuilder.append("\n");
    localStringBuilder.append("width: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("height: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("frameRate: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("bitrate: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("rotate: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("duration: ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("fileSize: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n");
    localStringBuilder.append("] ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.compress.VideoMediaInfo
 * JD-Core Version:    0.7.0.1
 */