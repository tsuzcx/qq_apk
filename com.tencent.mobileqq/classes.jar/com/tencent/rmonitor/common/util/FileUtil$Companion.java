package com.tencent.rmonitor.common.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/FileUtil$Companion;", "", "()V", "QAPM_ROOT", "", "SDPath", "TAG", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "setApp", "(Landroid/app/Application;)V", "copyFile", "Ljava/io/File;", "origin", "dist", "createFile", "", "filePath", "path", "fileName", "deleteAllFilesOfDir", "", "getExternalStorageDirectory", "getFileBufferStream", "Ljava/io/BufferedOutputStream;", "fileStr", "isAppend", "getFiles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reg", "getLastModifiedTime", "", "file", "getRootPath", "loadLibrary", "soPath", "mmapFile", "Lcom/tencent/rmonitor/common/util/FileUtil$MmapFile;", "size", "readOutputFromFile", "pathToFile", "readStream", "inputStream", "Ljava/io/InputStream;", "bufferSize", "", "inputStreamReader", "Ljava/io/InputStreamReader;", "readStreamByLine", "listener", "Lcom/tencent/rmonitor/common/util/FileUtil$IStreamListener;", "stream", "unmapFile", "writeFile", "text", "", "zipFiles", "dir", "outputPath", "isGzip", "allFiles", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class FileUtil$Companion
{
  private final String c()
  {
    if (!TextUtils.isEmpty((CharSequence)FileUtil.b())) {
      return FileUtil.b();
    }
    for (;;)
    {
      try
      {
        Object localObject = ((Companion)this).a();
        String str2 = null;
        if (localObject == null) {
          break label143;
        }
        localObject = ((Application)localObject).getApplicationContext();
        if (localObject == null) {
          break label143;
        }
        localObject = ((Context)localObject).getExternalFilesDir("/Tencent/QAPM");
        if (localObject == null) {
          break label148;
        }
        localObject = ((File)localObject).getAbsolutePath();
        FileUtil.a((String)localObject);
        if (FileUtil.b() == null)
        {
          localObject = ((Companion)this).a();
          if (localObject == null) {
            break label153;
          }
          localObject = ((Application)localObject).getApplicationContext();
          if (localObject == null) {
            break label153;
          }
          localObject = ((Context)localObject).getDir("Tencent_QAPM", 0);
          if (localObject != null) {
            str2 = ((File)localObject).getAbsolutePath();
          }
          FileUtil.a(str2);
        }
      }
      catch (Throwable localThrowable)
      {
        Logger.b.a(FileUtil.c(), localThrowable);
      }
      String str1 = FileUtil.b();
      if (str1 != null) {
        return str1;
      }
      return "";
      label143:
      str1 = null;
      continue;
      label148:
      str1 = null;
      continue;
      label153:
      str1 = null;
    }
  }
  
  @Nullable
  public final Application a()
  {
    return FileUtil.a();
  }
  
  /* Error */
  @JvmStatic
  @Nullable
  public final java.io.BufferedOutputStream a(@Nullable String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_1
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: aconst_null
    //   12: areturn
    //   13: new 124	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 7
    //   23: aload 7
    //   25: invokevirtual 160	java/io/File:getParentFile	()Ljava/io/File;
    //   28: astore 8
    //   30: aload 8
    //   32: invokevirtual 164	java/io/File:exists	()Z
    //   35: istore 5
    //   37: iconst_0
    //   38: istore 4
    //   40: iload 5
    //   42: ifne +156 -> 198
    //   45: aload 8
    //   47: invokevirtual 167	java/io/File:mkdirs	()Z
    //   50: ifeq +143 -> 193
    //   53: goto +145 -> 198
    //   56: iload_3
    //   57: ifeq +11 -> 68
    //   60: aload 7
    //   62: invokevirtual 164	java/io/File:exists	()Z
    //   65: ifne +138 -> 203
    //   68: iload 4
    //   70: istore_3
    //   71: aload 7
    //   73: invokevirtual 170	java/io/File:createNewFile	()Z
    //   76: ifeq +6 -> 82
    //   79: goto +124 -> 203
    //   82: iload_3
    //   83: ifeq +27 -> 110
    //   86: new 172	java/io/BufferedOutputStream
    //   89: dup
    //   90: new 174	java/io/FileOutputStream
    //   93: dup
    //   94: aload_1
    //   95: iload_2
    //   96: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   99: checkcast 179	java/io/OutputStream
    //   102: sipush 8192
    //   105: invokespecial 182	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   108: astore 6
    //   110: aload_0
    //   111: monitorexit
    //   112: aload 6
    //   114: areturn
    //   115: astore_1
    //   116: goto +73 -> 189
    //   119: astore 6
    //   121: getstatic 141	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   124: astore 7
    //   126: invokestatic 143	com/tencent/rmonitor/common/util/FileUtil:c	()Ljava/lang/String;
    //   129: astore 8
    //   131: new 184	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   138: astore 9
    //   140: aload 9
    //   142: ldc 187
    //   144: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 9
    //   150: aload_1
    //   151: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 9
    //   157: ldc 193
    //   159: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 7
    //   165: aload 8
    //   167: aload 9
    //   169: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: aload 6
    //   174: checkcast 94	java/lang/Throwable
    //   177: invokevirtual 199	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   180: aconst_null
    //   181: checkcast 172	java/io/BufferedOutputStream
    //   184: astore_1
    //   185: aload_0
    //   186: monitorexit
    //   187: aload_1
    //   188: areturn
    //   189: aload_0
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    //   193: iconst_0
    //   194: istore_3
    //   195: goto -139 -> 56
    //   198: iconst_1
    //   199: istore_3
    //   200: goto -144 -> 56
    //   203: iconst_1
    //   204: istore_3
    //   205: goto -123 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	Companion
    //   0	208	1	paramString	String
    //   0	208	2	paramBoolean	boolean
    //   56	149	3	i	int
    //   38	31	4	j	int
    //   35	6	5	bool	boolean
    //   3	110	6	localBufferedOutputStream	java.io.BufferedOutputStream
    //   119	54	6	localIOException	IOException
    //   21	143	7	localObject1	Object
    //   28	138	8	localObject2	Object
    //   138	30	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	37	115	finally
    //   45	53	115	finally
    //   60	68	115	finally
    //   71	79	115	finally
    //   86	110	115	finally
    //   121	185	115	finally
    //   13	37	119	java/io/IOException
    //   45	53	119	java/io/IOException
    //   60	68	119	java/io/IOException
    //   71	79	119	java/io/IOException
    //   86	110	119	java/io/IOException
  }
  
  @JvmStatic
  @Nullable
  public final File a(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "origin");
    Intrinsics.checkParameterIsNotNull(paramFile2, "dist");
    try
    {
      paramFile1 = FilesKt.copyTo$default(paramFile1, paramFile2, true, 0, 4, null);
      return paramFile1;
    }
    catch (Exception paramFile1)
    {
      Logger.b.a(FileUtil.c(), (Throwable)paramFile1);
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull InputStream paramInputStream, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "inputStream");
    return ((Companion)this).a(new InputStreamReader(paramInputStream), paramInt);
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull InputStreamReader paramInputStreamReader, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStreamReader, "inputStreamReader");
    StringBuffer localStringBuffer = new StringBuffer(1024);
    paramInputStreamReader = new BufferedReader((Reader)paramInputStreamReader, paramInt);
    try
    {
      paramInputStreamReader = ((Iterable)TextStreamsKt.readLines((Reader)paramInputStreamReader)).iterator();
      while (paramInputStreamReader.hasNext())
      {
        localStringBuffer.append((String)paramInputStreamReader.next());
        localStringBuffer.append("\n");
      }
      return paramInputStreamReader;
    }
    catch (Throwable paramInputStreamReader)
    {
      Logger.b.a(FileUtil.c(), paramInputStreamReader);
      paramInputStreamReader = localStringBuffer.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramInputStreamReader, "sb.toString()");
    }
  }
  
  @JvmStatic
  @Nullable
  public final ArrayList<File> a(@Nullable String paramString1, @Nullable String paramString2)
  {
    File[] arrayOfFile = null;
    Object localObject = (File)null;
    if (paramString1 != null) {
      localObject = new File(paramString1);
    }
    paramString1 = arrayOfFile;
    if (localObject != null)
    {
      if (!((File)localObject).exists()) {
        return null;
      }
      arrayOfFile = ((File)localObject).listFiles();
      localObject = new ArrayList();
      paramString1 = (String)localObject;
      if (arrayOfFile != null)
      {
        if (TextUtils.isEmpty((CharSequence)paramString2))
        {
          Collections.addAll((Collection)localObject, (File[])Arrays.copyOf(arrayOfFile, arrayOfFile.length));
          return localObject;
        }
        int i = 0;
        int j = arrayOfFile.length;
        for (;;)
        {
          paramString1 = (String)localObject;
          if (i >= j) {
            break;
          }
          if (paramString2 != null)
          {
            paramString1 = arrayOfFile[i];
            Intrinsics.checkExpressionValueIsNotNull(paramString1, "this[i]");
            if (Pattern.matches(paramString2, (CharSequence)paramString1.getName())) {
              ((ArrayList)localObject).add(arrayOfFile[i]);
            }
          }
          i += 1;
        }
      }
    }
    return paramString1;
  }
  
  public final void a(@Nullable Application paramApplication)
  {
    FileUtil.a(paramApplication);
  }
  
  @JvmStatic
  public final void a(@Nullable File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        int j = arrayOfFile.length;
        while (i < j)
        {
          ((Companion)this).a(arrayOfFile[i]);
          i += 1;
        }
        paramFile.delete();
      }
    }
  }
  
  @JvmStatic
  public final boolean a(@Nullable String paramString)
  {
    boolean bool2 = false;
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (paramString.getParentFile().exists()) {
          break label96;
        }
        if (!paramString.getParentFile().mkdirs()) {
          break label91;
        }
      }
      catch (IOException paramString)
      {
        boolean bool1;
        boolean bool3;
        Logger.b.a(FileUtil.c(), (Throwable)paramString);
        return false;
      }
      bool1 = bool2;
      if (i != 0)
      {
        bool3 = paramString.createNewFile();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
      label91:
      int i = 0;
      continue;
      label96:
      i = 1;
    }
  }
  
  @JvmStatic
  public final boolean a(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    if (paramString2 != null)
    {
      Companion localCompanion = FileUtil.a;
      Charset localCharset = Charsets.UTF_8;
      if (paramString2 != null)
      {
        paramString2 = paramString2.getBytes(localCharset);
        Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).getBytes(charset)");
        return localCompanion.a(paramString1, paramString2, paramBoolean);
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return false;
  }
  
  /* Error */
  @JvmStatic
  public final boolean a(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: checkcast 2	com/tencent/rmonitor/common/util/FileUtil$Companion
    //   6: aload_1
    //   7: iload_3
    //   8: invokevirtual 350	com/tencent/rmonitor/common/util/FileUtil$Companion:a	(Ljava/lang/String;Z)Ljava/io/BufferedOutputStream;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull +78 -> 93
    //   18: aload 4
    //   20: checkcast 352	java/io/Closeable
    //   23: astore 6
    //   25: aconst_null
    //   26: checkcast 94	java/lang/Throwable
    //   29: astore 5
    //   31: aload 5
    //   33: astore 4
    //   35: aload 6
    //   37: checkcast 172	java/io/BufferedOutputStream
    //   40: astore 7
    //   42: aload_2
    //   43: ifnull +21 -> 64
    //   46: aload 5
    //   48: astore 4
    //   50: aload 7
    //   52: aload_2
    //   53: invokevirtual 356	java/io/BufferedOutputStream:write	([B)V
    //   56: aload 5
    //   58: astore 4
    //   60: getstatic 362	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   63: astore_2
    //   64: aload 6
    //   66: aload 5
    //   68: invokestatic 368	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   71: goto +22 -> 93
    //   74: astore_2
    //   75: goto +9 -> 84
    //   78: astore_2
    //   79: aload_2
    //   80: astore 4
    //   82: aload_2
    //   83: athrow
    //   84: aload 6
    //   86: aload 4
    //   88: invokestatic 368	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   91: aload_2
    //   92: athrow
    //   93: iconst_1
    //   94: istore_3
    //   95: goto +68 -> 163
    //   98: astore_1
    //   99: goto +68 -> 167
    //   102: astore_2
    //   103: getstatic 141	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   106: astore 4
    //   108: invokestatic 143	com/tencent/rmonitor/common/util/FileUtil:c	()Ljava/lang/String;
    //   111: astore 5
    //   113: new 184	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   120: astore 6
    //   122: aload 6
    //   124: ldc 187
    //   126: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 6
    //   132: aload_1
    //   133: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 6
    //   139: ldc 193
    //   141: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 4
    //   147: aload 5
    //   149: aload 6
    //   151: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload_2
    //   155: checkcast 94	java/lang/Throwable
    //   158: invokevirtual 199	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: iconst_0
    //   162: istore_3
    //   163: aload_0
    //   164: monitorexit
    //   165: iload_3
    //   166: ireturn
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	Companion
    //   0	171	1	paramString	String
    //   0	171	2	paramArrayOfByte	byte[]
    //   0	171	3	paramBoolean	boolean
    //   11	135	4	localObject1	Object
    //   29	119	5	localObject2	Object
    //   23	127	6	localObject3	Object
    //   40	11	7	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   35	42	74	finally
    //   50	56	74	finally
    //   60	64	74	finally
    //   82	84	74	finally
    //   35	42	78	java/lang/Throwable
    //   50	56	78	java/lang/Throwable
    //   60	64	78	java/lang/Throwable
    //   2	13	98	finally
    //   18	31	98	finally
    //   64	71	98	finally
    //   84	93	98	finally
    //   103	161	98	finally
    //   2	13	102	java/io/IOException
    //   18	31	102	java/io/IOException
    //   64	71	102	java/io/IOException
    //   84	93	102	java/io/IOException
  }
  
  /* Error */
  @JvmStatic
  public final boolean a(@Nullable java.util.List<String> paramList, @NotNull String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 370
    //   4: invokestatic 212	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: new 124	java/io/File
    //   10: dup
    //   11: aload_2
    //   12: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: getstatic 328	com/tencent/rmonitor/common/util/FileUtil:a	Lcom/tencent/rmonitor/common/util/FileUtil$Companion;
    //   20: aload 4
    //   22: invokevirtual 127	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   25: invokevirtual 372	com/tencent/rmonitor/common/util/FileUtil$Companion:a	(Ljava/lang/String;)Z
    //   28: pop
    //   29: new 174	java/io/FileOutputStream
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 374	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   38: astore 4
    //   40: iload_3
    //   41: ifeq +37 -> 78
    //   44: new 376	java/util/zip/GZIPOutputStream
    //   47: dup
    //   48: new 172	java/io/BufferedOutputStream
    //   51: dup
    //   52: aload 4
    //   54: checkcast 179	java/io/OutputStream
    //   57: invokespecial 379	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: checkcast 179	java/io/OutputStream
    //   63: invokespecial 380	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore 4
    //   68: aload 4
    //   70: checkcast 382	java/util/zip/DeflaterOutputStream
    //   73: astore 4
    //   75: goto +30 -> 105
    //   78: new 384	java/util/zip/ZipOutputStream
    //   81: dup
    //   82: new 172	java/io/BufferedOutputStream
    //   85: dup
    //   86: aload 4
    //   88: checkcast 179	java/io/OutputStream
    //   91: invokespecial 379	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   94: checkcast 179	java/io/OutputStream
    //   97: invokespecial 385	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   100: astore 4
    //   102: goto -34 -> 68
    //   105: aload 4
    //   107: checkcast 352	java/io/Closeable
    //   110: astore 9
    //   112: aconst_null
    //   113: checkcast 94	java/lang/Throwable
    //   116: astore 7
    //   118: aload 7
    //   120: astore 5
    //   122: aload 9
    //   124: checkcast 382	java/util/zip/DeflaterOutputStream
    //   127: astore 4
    //   129: aload_1
    //   130: ifnull +430 -> 560
    //   133: aload 7
    //   135: astore 5
    //   137: aload_1
    //   138: checkcast 247	java/lang/Iterable
    //   141: astore 8
    //   143: aload 7
    //   145: astore 5
    //   147: new 280	java/util/ArrayList
    //   150: dup
    //   151: invokespecial 281	java/util/ArrayList:<init>	()V
    //   154: checkcast 283	java/util/Collection
    //   157: astore 6
    //   159: aload 7
    //   161: astore 5
    //   163: aload 8
    //   165: invokeinterface 251 1 0
    //   170: astore 8
    //   172: aload 7
    //   174: astore 5
    //   176: aload 8
    //   178: invokeinterface 256 1 0
    //   183: ifeq +55 -> 238
    //   186: aload 7
    //   188: astore 5
    //   190: aload 8
    //   192: invokeinterface 260 1 0
    //   197: astore 10
    //   199: aload 7
    //   201: astore 5
    //   203: new 124	java/io/File
    //   206: dup
    //   207: aload 10
    //   209: checkcast 262	java/lang/String
    //   212: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   215: invokevirtual 164	java/io/File:exists	()Z
    //   218: ifeq -46 -> 172
    //   221: aload 7
    //   223: astore 5
    //   225: aload 6
    //   227: aload 10
    //   229: invokeinterface 386 2 0
    //   234: pop
    //   235: goto -63 -> 172
    //   238: aload 7
    //   240: astore 5
    //   242: aload 6
    //   244: checkcast 388	java/util/List
    //   247: checkcast 247	java/lang/Iterable
    //   250: invokeinterface 251 1 0
    //   255: astore 10
    //   257: aload 7
    //   259: astore 5
    //   261: aload 10
    //   263: invokeinterface 256 1 0
    //   268: ifeq +279 -> 547
    //   271: aload 7
    //   273: astore 5
    //   275: new 124	java/io/File
    //   278: dup
    //   279: aload 10
    //   281: invokeinterface 260 1 0
    //   286: checkcast 262	java/lang/String
    //   289: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   292: astore 8
    //   294: iload_3
    //   295: ifne +103 -> 398
    //   298: aload 7
    //   300: astore 5
    //   302: aload 4
    //   304: instanceof 384
    //   307: ifne +335 -> 642
    //   310: aconst_null
    //   311: astore 6
    //   313: goto +3 -> 316
    //   316: aload 7
    //   318: astore 5
    //   320: aload 6
    //   322: checkcast 384	java/util/zip/ZipOutputStream
    //   325: astore 6
    //   327: aload 6
    //   329: ifnull +24 -> 353
    //   332: aload 7
    //   334: astore 5
    //   336: aload 6
    //   338: new 390	java/util/zip/ZipEntry
    //   341: dup
    //   342: aload 8
    //   344: invokevirtual 302	java/io/File:getName	()Ljava/lang/String;
    //   347: invokespecial 391	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   350: invokevirtual 395	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   353: aload 7
    //   355: astore 5
    //   357: aload 4
    //   359: instanceof 384
    //   362: ifne +287 -> 649
    //   365: aconst_null
    //   366: astore 6
    //   368: goto +3 -> 371
    //   371: aload 7
    //   373: astore 5
    //   375: aload 6
    //   377: checkcast 384	java/util/zip/ZipOutputStream
    //   380: astore 6
    //   382: aload 6
    //   384: ifnull +14 -> 398
    //   387: aload 7
    //   389: astore 5
    //   391: aload 6
    //   393: bipush 9
    //   395: invokevirtual 398	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   398: aload 7
    //   400: astore 5
    //   402: new 400	java/io/FileInputStream
    //   405: dup
    //   406: aload 8
    //   408: invokespecial 401	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   411: checkcast 352	java/io/Closeable
    //   414: astore 11
    //   416: aload 7
    //   418: astore 5
    //   420: aconst_null
    //   421: checkcast 94	java/lang/Throwable
    //   424: astore 8
    //   426: aload 8
    //   428: astore 6
    //   430: aload 11
    //   432: checkcast 400	java/io/FileInputStream
    //   435: checkcast 403	java/io/InputStream
    //   438: aload 4
    //   440: checkcast 179	java/io/OutputStream
    //   443: sipush 20480
    //   446: invokestatic 409	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   449: pop2
    //   450: aload 7
    //   452: astore 5
    //   454: aload 11
    //   456: aload 8
    //   458: invokestatic 368	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   461: aload 7
    //   463: astore 5
    //   465: aload 4
    //   467: invokevirtual 412	java/util/zip/DeflaterOutputStream:flush	()V
    //   470: iload_3
    //   471: ifne -214 -> 257
    //   474: aload 7
    //   476: astore 5
    //   478: aload 4
    //   480: instanceof 384
    //   483: ifne +173 -> 656
    //   486: aconst_null
    //   487: astore 6
    //   489: goto +3 -> 492
    //   492: aload 7
    //   494: astore 5
    //   496: aload 6
    //   498: checkcast 384	java/util/zip/ZipOutputStream
    //   501: astore 6
    //   503: aload 6
    //   505: ifnull -248 -> 257
    //   508: aload 7
    //   510: astore 5
    //   512: aload 6
    //   514: invokevirtual 415	java/util/zip/ZipOutputStream:closeEntry	()V
    //   517: goto -260 -> 257
    //   520: astore_1
    //   521: goto +9 -> 530
    //   524: astore_1
    //   525: aload_1
    //   526: astore 6
    //   528: aload_1
    //   529: athrow
    //   530: aload 7
    //   532: astore 5
    //   534: aload 11
    //   536: aload 6
    //   538: invokestatic 368	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   541: aload 7
    //   543: astore 5
    //   545: aload_1
    //   546: athrow
    //   547: aload_1
    //   548: ifnull +12 -> 560
    //   551: aload 9
    //   553: aload 7
    //   555: invokestatic 368	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   558: iconst_1
    //   559: ireturn
    //   560: aload 9
    //   562: aload 7
    //   564: invokestatic 368	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   567: iconst_0
    //   568: ireturn
    //   569: astore_1
    //   570: goto +9 -> 579
    //   573: astore_1
    //   574: aload_1
    //   575: astore 5
    //   577: aload_1
    //   578: athrow
    //   579: aload 9
    //   581: aload 5
    //   583: invokestatic 368	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   586: aload_1
    //   587: athrow
    //   588: astore_1
    //   589: getstatic 141	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   592: astore 4
    //   594: invokestatic 143	com/tencent/rmonitor/common/util/FileUtil:c	()Ljava/lang/String;
    //   597: astore 5
    //   599: new 184	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   606: astore 6
    //   608: aload 6
    //   610: ldc_w 417
    //   613: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 6
    //   619: aload_2
    //   620: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload 4
    //   626: aload 5
    //   628: aload 6
    //   630: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: aload_1
    //   634: checkcast 94	java/lang/Throwable
    //   637: invokevirtual 199	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   640: iconst_0
    //   641: ireturn
    //   642: aload 4
    //   644: astore 6
    //   646: goto -330 -> 316
    //   649: aload 4
    //   651: astore 6
    //   653: goto -282 -> 371
    //   656: aload 4
    //   658: astore 6
    //   660: goto -168 -> 492
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	this	Companion
    //   0	663	1	paramList	java.util.List<String>
    //   0	663	2	paramString	String
    //   0	663	3	paramBoolean	boolean
    //   15	642	4	localObject1	Object
    //   120	507	5	localObject2	Object
    //   157	502	6	localObject3	Object
    //   116	447	7	localThrowable	Throwable
    //   141	316	8	localObject4	Object
    //   110	470	9	localCloseable1	java.io.Closeable
    //   197	83	10	localObject5	Object
    //   414	121	11	localCloseable2	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   430	450	520	finally
    //   528	530	520	finally
    //   430	450	524	java/lang/Throwable
    //   122	129	569	finally
    //   137	143	569	finally
    //   147	159	569	finally
    //   163	172	569	finally
    //   176	186	569	finally
    //   190	199	569	finally
    //   203	221	569	finally
    //   225	235	569	finally
    //   242	257	569	finally
    //   261	271	569	finally
    //   275	294	569	finally
    //   302	310	569	finally
    //   320	327	569	finally
    //   336	353	569	finally
    //   357	365	569	finally
    //   375	382	569	finally
    //   391	398	569	finally
    //   402	416	569	finally
    //   420	426	569	finally
    //   454	461	569	finally
    //   465	470	569	finally
    //   478	486	569	finally
    //   496	503	569	finally
    //   512	517	569	finally
    //   534	541	569	finally
    //   545	547	569	finally
    //   577	579	569	finally
    //   122	129	573	java/lang/Throwable
    //   137	143	573	java/lang/Throwable
    //   147	159	573	java/lang/Throwable
    //   163	172	573	java/lang/Throwable
    //   176	186	573	java/lang/Throwable
    //   190	199	573	java/lang/Throwable
    //   203	221	573	java/lang/Throwable
    //   225	235	573	java/lang/Throwable
    //   242	257	573	java/lang/Throwable
    //   261	271	573	java/lang/Throwable
    //   275	294	573	java/lang/Throwable
    //   302	310	573	java/lang/Throwable
    //   320	327	573	java/lang/Throwable
    //   336	353	573	java/lang/Throwable
    //   357	365	573	java/lang/Throwable
    //   375	382	573	java/lang/Throwable
    //   391	398	573	java/lang/Throwable
    //   402	416	573	java/lang/Throwable
    //   420	426	573	java/lang/Throwable
    //   454	461	573	java/lang/Throwable
    //   465	470	573	java/lang/Throwable
    //   478	486	573	java/lang/Throwable
    //   496	503	573	java/lang/Throwable
    //   512	517	573	java/lang/Throwable
    //   534	541	573	java/lang/Throwable
    //   545	547	573	java/lang/Throwable
    //   7	40	588	java/io/IOException
    //   44	68	588	java/io/IOException
    //   68	75	588	java/io/IOException
    //   78	102	588	java/io/IOException
    //   105	118	588	java/io/IOException
    //   551	558	588	java/io/IOException
    //   560	567	588	java/io/IOException
    //   579	588	588	java/io/IOException
  }
  
  @JvmStatic
  @NotNull
  public final String b()
  {
    int i;
    if (((CharSequence)FileUtil.d()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      String str = ((Companion)this).c();
      if (str == null) {
        str = "";
      }
      FileUtil.b(str);
    }
    return FileUtil.d();
  }
  
  @JvmStatic
  @NotNull
  public final String b(@Nullable String paramString)
  {
    if (paramString == null) {
      return "";
    }
    Object localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      if (!((File)localObject).canRead()) {
        return "";
      }
      try
      {
        localObject = StringsKt.trim(a((Companion)this, (InputStreamReader)new FileReader((File)localObject), 0, 2, null), new char[] { '\n' });
        return localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Logger localLogger = Logger.b;
        String str = FileUtil.c();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localFileNotFoundException.getMessage());
        localStringBuilder.append(": file ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" can not read, because FileNotFoundException");
        localLogger.w(new String[] { str, localStringBuilder.toString() });
      }
    }
    return "";
  }
  
  @JvmStatic
  public final boolean b(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "dir");
    Intrinsics.checkParameterIsNotNull(paramString2, "outputPath");
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 != null)
    {
      paramString1 = ArraysKt.asSequence(paramString1);
      if (paramString1 != null)
      {
        paramString1 = SequencesKt.filter(paramString1, (Function1)FileUtil.Companion.zipFiles.allFiles.1.INSTANCE);
        if (paramString1 != null)
        {
          paramString1 = SequencesKt.filter(paramString1, (Function1)FileUtil.Companion.zipFiles.allFiles.2.INSTANCE);
          if (paramString1 != null)
          {
            paramString1 = SequencesKt.map(paramString1, (Function1)FileUtil.Companion.zipFiles.allFiles.3.INSTANCE);
            if (paramString1 != null)
            {
              paramString1 = SequencesKt.toList(paramString1);
              break label94;
            }
          }
        }
      }
    }
    paramString1 = null;
    label94:
    return ((Companion)this).a(paramString1, paramString2, paramBoolean);
  }
  
  @JvmStatic
  public final boolean c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "soPath");
    if (SystemProduct.a.a()) {
      return false;
    }
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      Logger.b.a(FileUtil.c(), paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.FileUtil.Companion
 * JD-Core Version:    0.7.0.1
 */