package com.tencent.tavcut.utils;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/utils/FileUtils;", "", "()V", "TAG", "", "convertFileToByteArray", "", "filePath", "copyAssetFile", "", "context", "Landroid/content/Context;", "assetFile", "destFile", "copyFile", "inputStream", "Ljava/io/InputStream;", "os", "Ljava/io/OutputStream;", "createNewFile", "Ljava/io/File;", "createParentDir", "delete", "", "file", "path", "doZip", "zos", "Ljava/util/zip/ZipOutputStream;", "parentDirName", "buffer", "exist", "fileToBase64", "find", "", "dir", "fileName", "findFirstFileBySuffix", "suffix", "getCacheDirectory", "type", "getExternalCacheDirectory", "getFileSize", "", "getInternalCacheDirectory", "isDirectory", "directory", "isDirectoryWritable", "isExternalStorageAvailable", "isExternalStorageSpaceEnough", "fileSize", "loadAssetsString", "moveFile", "oldPath", "newPath", "readString", "saveFile", "data", "splitFile", "Lcom/tencent/tavcut/utils/FileUtils$FileInfo;", "partLength", "", "partFileDir", "fileSuffix", "unzip", "location", "zip", "srcFiles", "", "([Ljava/io/File;Ljava/io/File;)Z", "FileInfo", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class FileUtils
{
  public static final FileUtils a = new FileUtils();
  
  /* Error */
  @org.jetbrains.annotations.NotNull
  public final java.lang.String a(@org.jetbrains.annotations.NotNull android.content.Context paramContext, @org.jetbrains.annotations.Nullable java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 94
    //   3: invokestatic 100	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: new 102	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload_2
    //   16: ifnull +207 -> 223
    //   19: aload_1
    //   20: invokevirtual 109	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: aload_2
    //   24: invokevirtual 115	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: checkcast 117	java/io/Closeable
    //   30: astore 5
    //   32: aconst_null
    //   33: checkcast 93	java/lang/Throwable
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: new 119	java/io/BufferedReader
    //   42: dup
    //   43: new 121	java/io/InputStreamReader
    //   46: dup
    //   47: aload 5
    //   49: checkcast 123	java/io/InputStream
    //   52: ldc 125
    //   54: invokespecial 128	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   57: checkcast 130	java/io/Reader
    //   60: invokespecial 133	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: checkcast 117	java/io/Closeable
    //   66: astore 7
    //   68: aload_3
    //   69: astore_2
    //   70: aconst_null
    //   71: checkcast 93	java/lang/Throwable
    //   74: astore 4
    //   76: aload 4
    //   78: astore_1
    //   79: aload 7
    //   81: checkcast 119	java/io/BufferedReader
    //   84: astore_2
    //   85: aload 4
    //   87: astore_1
    //   88: new 135	kotlin/jvm/internal/Ref$ObjectRef
    //   91: dup
    //   92: invokespecial 136	kotlin/jvm/internal/Ref$ObjectRef:<init>	()V
    //   95: astore 8
    //   97: aload 4
    //   99: astore_1
    //   100: aload_2
    //   101: invokevirtual 140	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   104: astore 9
    //   106: aload 4
    //   108: astore_1
    //   109: aload 8
    //   111: aload 9
    //   113: putfield 144	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   116: aload 9
    //   118: ifnull +34 -> 152
    //   121: aload 4
    //   123: astore_1
    //   124: aload 6
    //   126: aload 8
    //   128: getfield 144	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   131: checkcast 146	java/lang/String
    //   134: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 4
    //   140: astore_1
    //   141: aload 6
    //   143: ldc 152
    //   145: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: goto -52 -> 97
    //   152: aload 4
    //   154: astore_1
    //   155: getstatic 158	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   158: astore_2
    //   159: aload_3
    //   160: astore_2
    //   161: aload 7
    //   163: aload 4
    //   165: invokestatic 164	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   168: aload_3
    //   169: astore_2
    //   170: getstatic 158	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   173: astore_1
    //   174: aload 5
    //   176: aload_3
    //   177: invokestatic 164	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   180: goto +43 -> 223
    //   183: astore 4
    //   185: goto +8 -> 193
    //   188: astore_2
    //   189: aload_2
    //   190: astore_1
    //   191: aload_2
    //   192: athrow
    //   193: aload_3
    //   194: astore_2
    //   195: aload 7
    //   197: aload_1
    //   198: invokestatic 164	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   201: aload_3
    //   202: astore_2
    //   203: aload 4
    //   205: athrow
    //   206: astore_1
    //   207: goto +8 -> 215
    //   210: astore_1
    //   211: aload_1
    //   212: astore_2
    //   213: aload_1
    //   214: athrow
    //   215: aload 5
    //   217: aload_2
    //   218: invokestatic 164	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   221: aload_1
    //   222: athrow
    //   223: aload 6
    //   225: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore_1
    //   229: aload_1
    //   230: ldc 169
    //   232: invokestatic 172	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   235: aload_1
    //   236: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	FileUtils
    //   0	237	1	paramContext	android.content.Context
    //   0	237	2	paramString	java.lang.String
    //   36	166	3	localThrowable1	java.lang.Throwable
    //   74	90	4	localThrowable2	java.lang.Throwable
    //   183	21	4	localObject	Object
    //   30	186	5	localCloseable1	java.io.Closeable
    //   13	211	6	localStringBuilder	java.lang.StringBuilder
    //   66	130	7	localCloseable2	java.io.Closeable
    //   95	32	8	localObjectRef	kotlin.jvm.internal.Ref.ObjectRef
    //   104	13	9	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   79	85	183	finally
    //   88	97	183	finally
    //   100	106	183	finally
    //   109	116	183	finally
    //   124	138	183	finally
    //   141	149	183	finally
    //   155	159	183	finally
    //   191	193	183	finally
    //   79	85	188	java/lang/Throwable
    //   88	97	188	java/lang/Throwable
    //   100	106	188	java/lang/Throwable
    //   109	116	188	java/lang/Throwable
    //   124	138	188	java/lang/Throwable
    //   141	149	188	java/lang/Throwable
    //   155	159	188	java/lang/Throwable
    //   39	68	206	finally
    //   70	76	206	finally
    //   161	168	206	finally
    //   170	174	206	finally
    //   195	201	206	finally
    //   203	206	206	finally
    //   213	215	206	finally
    //   39	68	210	java/lang/Throwable
    //   70	76	210	java/lang/Throwable
    //   161	168	210	java/lang/Throwable
    //   170	174	210	java/lang/Throwable
    //   195	201	210	java/lang/Throwable
    //   203	206	210	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */