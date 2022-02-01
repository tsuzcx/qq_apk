package com.tencent.videocut.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/VideoUtils;", "", "()V", "AUDIO_MIME_PREFIX", "", "DEFAULT_VIDEO_BITRATE", "", "DIR_CAMERA", "RATION_270", "RATION_90", "TAG", "UNIT_MS_TO_US", "UNIT_US_To_MS", "addVideoToAlbum", "", "context", "Landroid/content/Context;", "path", "getAudioChannelCount", "getDurationUs", "", "getRotation", "getVideoBitRate", "getWidthAndHeight", "Lkotlin/Pair;", "SingleMediaFileScanner", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class VideoUtils
{
  @NotNull
  public static final VideoUtils a = new VideoUtils();
  
  /* Error */
  @androidx.annotation.WorkerThread
  @NotNull
  public final kotlin.Pair<java.lang.Integer, java.lang.Integer> a(@org.jetbrains.annotations.Nullable java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 56	java/lang/CharSequence
    //   4: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +211 -> 218
    //   10: aconst_null
    //   11: checkcast 64	android/media/MediaMetadataRetriever
    //   14: astore 7
    //   16: aload 7
    //   18: astore 5
    //   20: new 64	android/media/MediaMetadataRetriever
    //   23: dup
    //   24: invokespecial 65	android/media/MediaMetadataRetriever:<init>	()V
    //   27: astore 6
    //   29: aload 6
    //   31: aload_1
    //   32: invokevirtual 69	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   35: aload 6
    //   37: bipush 24
    //   39: invokevirtual 73	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   42: astore_1
    //   43: aload_1
    //   44: ldc 75
    //   46: invokestatic 81	kotlin/jvm/internal/Intrinsics:checkNotNullExpressionValue	(Ljava/lang/Object;Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokestatic 87	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   53: istore_2
    //   54: aload 6
    //   56: bipush 19
    //   58: invokevirtual 73	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 89
    //   65: invokestatic 81	kotlin/jvm/internal/Intrinsics:checkNotNullExpressionValue	(Ljava/lang/Object;Ljava/lang/String;)V
    //   68: aload_1
    //   69: invokestatic 87	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   72: istore_3
    //   73: aload 6
    //   75: bipush 18
    //   77: invokevirtual 73	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   80: astore_1
    //   81: aload_1
    //   82: ldc 91
    //   84: invokestatic 81	kotlin/jvm/internal/Intrinsics:checkNotNullExpressionValue	(Ljava/lang/Object;Ljava/lang/String;)V
    //   87: aload_1
    //   88: invokestatic 87	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   91: istore 4
    //   93: iload_2
    //   94: bipush 90
    //   96: if_icmpeq +33 -> 129
    //   99: iload_2
    //   100: sipush 270
    //   103: if_icmpne +6 -> 109
    //   106: goto +23 -> 129
    //   109: new 93	kotlin/Pair
    //   112: dup
    //   113: iload 4
    //   115: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: iload_3
    //   119: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: invokespecial 100	kotlin/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   125: astore_1
    //   126: goto +20 -> 146
    //   129: new 93	kotlin/Pair
    //   132: dup
    //   133: iload_3
    //   134: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: iload 4
    //   139: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: invokespecial 100	kotlin/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   145: astore_1
    //   146: aload 6
    //   148: invokevirtual 103	android/media/MediaMetadataRetriever:release	()V
    //   151: aload_1
    //   152: areturn
    //   153: astore_1
    //   154: goto +52 -> 206
    //   157: astore 5
    //   159: aload 6
    //   161: astore_1
    //   162: aload 5
    //   164: astore 6
    //   166: goto +16 -> 182
    //   169: astore_1
    //   170: aload 5
    //   172: astore 6
    //   174: goto +32 -> 206
    //   177: astore 6
    //   179: aload 7
    //   181: astore_1
    //   182: aload_1
    //   183: astore 5
    //   185: ldc 105
    //   187: aload 6
    //   189: invokevirtual 109	java/lang/Exception:toString	()Ljava/lang/String;
    //   192: invokestatic 114	com/tencent/videocut/utils/log/Logger:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload_1
    //   196: ifnull +22 -> 218
    //   199: aload_1
    //   200: invokevirtual 103	android/media/MediaMetadataRetriever:release	()V
    //   203: goto +15 -> 218
    //   206: aload 6
    //   208: ifnull +8 -> 216
    //   211: aload 6
    //   213: invokevirtual 103	android/media/MediaMetadataRetriever:release	()V
    //   216: aload_1
    //   217: athrow
    //   218: new 93	kotlin/Pair
    //   221: dup
    //   222: iconst_0
    //   223: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   226: iconst_0
    //   227: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: invokespecial 100	kotlin/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   233: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	VideoUtils
    //   0	234	1	paramString	java.lang.String
    //   53	51	2	i	int
    //   72	62	3	j	int
    //   91	47	4	k	int
    //   18	1	5	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   157	14	5	localException1	java.lang.Exception
    //   183	1	5	str	java.lang.String
    //   27	146	6	localObject	Object
    //   177	35	6	localException2	java.lang.Exception
    //   14	166	7	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   29	93	153	finally
    //   109	126	153	finally
    //   129	146	153	finally
    //   29	93	157	java/lang/Exception
    //   109	126	157	java/lang/Exception
    //   129	146	157	java/lang/Exception
    //   20	29	169	finally
    //   185	195	169	finally
    //   20	29	177	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.VideoUtils
 * JD-Core Version:    0.7.0.1
 */