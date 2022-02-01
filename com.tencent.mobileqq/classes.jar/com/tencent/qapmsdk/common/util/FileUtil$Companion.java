package com.tencent.qapmsdk.common.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;", "", "()V", "QAPM_ROOT", "", "SDPath", "TAG", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "setApp", "(Landroid/app/Application;)V", "copyFile", "Ljava/io/File;", "origin", "dist", "createFile", "", "filePath", "path", "fileName", "deleteAllFilesOfDir", "", "getExternalStorageDirectory", "getFileBufferStream", "Ljava/io/BufferedOutputStream;", "fileStr", "isAppend", "getFiles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reg", "getLastModifiedTime", "", "file", "getRootPath", "loadLibrary", "soPath", "mmapFile", "Lcom/tencent/qapmsdk/common/util/FileUtil$MmapFile;", "size", "readOutputFromFile", "pathToFile", "readStream", "inputStream", "Ljava/io/InputStream;", "bufferSize", "", "inputStreamReader", "Ljava/io/InputStreamReader;", "readStreamByLine", "listener", "Lcom/tencent/qapmsdk/common/util/IStreamListener;", "unmapFile", "writeFile", "text", "", "zipFiles", "dir", "outputPath", "isGzip", "allFiles", "", "common_release"}, k=1, mv={1, 1, 15})
public final class FileUtil$Companion
{
  private final String getExternalStorageDirectory()
  {
    if (!TextUtils.isEmpty((CharSequence)FileUtil.access$getSDPath$cp())) {
      return FileUtil.access$getSDPath$cp();
    }
    for (;;)
    {
      try
      {
        Object localObject = ((Companion)this).getApp();
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
        FileUtil.access$setSDPath$cp((String)localObject);
        if (FileUtil.access$getSDPath$cp() == null)
        {
          localObject = ((Companion)this).getApp();
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
          FileUtil.access$setSDPath$cp(str2);
        }
      }
      catch (Throwable localThrowable)
      {
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), localThrowable);
      }
      String str1 = FileUtil.access$getSDPath$cp();
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
  
  @JvmStatic
  @Nullable
  public final File copyFile(@NotNull File paramFile1, @NotNull File paramFile2)
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
      Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), (Throwable)paramFile1);
    }
    return null;
  }
  
  @JvmStatic
  public final boolean createFile(@Nullable String paramString)
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
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), (Throwable)paramString);
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
  public final boolean createFile(@Nullable String paramString1, @Nullable String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return ((Companion)this).createFile(new File(paramString1, paramString2).getAbsolutePath());
    }
    return false;
  }
  
  @JvmStatic
  public final void deleteAllFilesOfDir(@Nullable File paramFile)
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
          ((Companion)this).deleteAllFilesOfDir(arrayOfFile[i]);
          i += 1;
        }
        paramFile.delete();
      }
    }
  }
  
  @Nullable
  public final Application getApp()
  {
    return FileUtil.access$getApp$cp();
  }
  
  /* Error */
  @JvmStatic
  @Nullable
  public final java.io.BufferedOutputStream getFileBufferStream(@Nullable String paramString, boolean paramBoolean)
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
    //   13: new 113	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 7
    //   23: aload 7
    //   25: invokevirtual 194	java/io/File:getParentFile	()Ljava/io/File;
    //   28: astore 8
    //   30: aload 8
    //   32: invokevirtual 190	java/io/File:exists	()Z
    //   35: istore 5
    //   37: iconst_0
    //   38: istore 4
    //   40: iload 5
    //   42: ifne +156 -> 198
    //   45: aload 8
    //   47: invokevirtual 197	java/io/File:mkdirs	()Z
    //   50: ifeq +143 -> 193
    //   53: goto +145 -> 198
    //   56: iload_3
    //   57: ifeq +11 -> 68
    //   60: aload 7
    //   62: invokevirtual 190	java/io/File:exists	()Z
    //   65: ifne +138 -> 203
    //   68: iload 4
    //   70: istore_3
    //   71: aload 7
    //   73: invokevirtual 200	java/io/File:createNewFile	()Z
    //   76: ifeq +6 -> 82
    //   79: goto +124 -> 203
    //   82: iload_3
    //   83: ifeq +27 -> 110
    //   86: new 225	java/io/BufferedOutputStream
    //   89: dup
    //   90: new 227	java/io/FileOutputStream
    //   93: dup
    //   94: aload_1
    //   95: iload_2
    //   96: invokespecial 230	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   99: checkcast 232	java/io/OutputStream
    //   102: sipush 8192
    //   105: invokespecial 235	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   108: astore 6
    //   110: aload_0
    //   111: monitorexit
    //   112: aload 6
    //   114: areturn
    //   115: astore_1
    //   116: goto +73 -> 189
    //   119: astore 6
    //   121: getstatic 132	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   124: astore 7
    //   126: invokestatic 135	com/tencent/qapmsdk/common/util/FileUtil:access$getTAG$cp	()Ljava/lang/String;
    //   129: astore 8
    //   131: new 237	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   138: astore 9
    //   140: aload 9
    //   142: ldc 240
    //   144: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 9
    //   150: aload_1
    //   151: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 9
    //   157: ldc 246
    //   159: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 7
    //   165: aload 8
    //   167: aload 9
    //   169: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: aload 6
    //   174: checkcast 82	java/lang/Throwable
    //   177: invokevirtual 252	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   180: aconst_null
    //   181: checkcast 225	java/io/BufferedOutputStream
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
  public final ArrayList<File> getFiles(@Nullable String paramString1, @Nullable String paramString2)
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
      if (TextUtils.isEmpty((CharSequence)paramString2))
      {
        Collections.addAll((Collection)localObject, (File[])Arrays.copyOf(arrayOfFile, arrayOfFile.length));
        return localObject;
      }
      int i = 0;
      Intrinsics.checkExpressionValueIsNotNull(arrayOfFile, "files");
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
          Intrinsics.checkExpressionValueIsNotNull(paramString1, "files[i]");
          if (Pattern.matches(paramString2, (CharSequence)paramString1.getName())) {
            ((ArrayList)localObject).add(arrayOfFile[i]);
          }
        }
        i += 1;
      }
    }
    return paramString1;
  }
  
  @JvmStatic
  public final long getLastModifiedTime(@Nullable File paramFile)
  {
    if (paramFile != null) {
      return paramFile.lastModified();
    }
    return -1L;
  }
  
  @JvmStatic
  @NotNull
  public final String getRootPath()
  {
    int i;
    if (((CharSequence)FileUtil.access$getQAPM_ROOT$cp()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      String str = ((Companion)this).getExternalStorageDirectory();
      if (str == null) {
        str = "";
      }
      FileUtil.access$setQAPM_ROOT$cp(str);
    }
    return FileUtil.access$getQAPM_ROOT$cp();
  }
  
  @JvmStatic
  public final boolean loadLibrary(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "soPath");
    if (SystemProduct.Companion.isX86CPU()) {
      return false;
    }
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), paramString);
    }
    return false;
  }
  
  @JvmStatic
  @Nullable
  public final FileUtil.MmapFile mmapFile(@Nullable String paramString, long paramLong)
  {
    Object localObject1 = null;
    int i;
    if (paramString != null)
    {
      try
      {
        localObject1 = new File(paramString);
        localObject2 = ((File)localObject1).getParentFile();
        boolean bool = ((File)localObject2).exists();
        j = 0;
        if (bool) {
          break label221;
        }
        if (!((File)localObject2).mkdirs()) {
          break label215;
        }
      }
      catch (Exception localException)
      {
        int j;
        Object localObject2 = Logger.INSTANCE;
        str = FileUtil.access$getTAG$cp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mmap file ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" error. ");
        ((Logger)localObject2).exception(str, localStringBuilder.toString(), (Throwable)localException);
        localMmapFile = (FileUtil.MmapFile)null;
      }
      if ((i != 0) && (((File)localObject1).exists())) {
        break label227;
      }
      i = j;
      if (((File)localObject1).createNewFile()) {
        break label227;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = new RandomAccessFile(paramString, "rw");
        localObject2 = ((RandomAccessFile)localObject1).getChannel();
        localObject2 = ((FileChannel)localObject2).map(FileChannel.MapMode.READ_WRITE, ((FileChannel)localObject2).size(), paramLong);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "buffer");
        localObject1 = new FileUtil.MmapFile(paramString, (RandomAccessFile)localObject1, (MappedByteBuffer)localObject2);
        return localObject1;
      }
      String str;
      StringBuilder localStringBuilder;
      FileUtil.MmapFile localMmapFile;
      return localMmapFile;
      label215:
      i = 0;
      break;
      label221:
      i = 1;
      break;
      label227:
      i = 1;
    }
  }
  
  @JvmStatic
  @NotNull
  public final String readOutputFromFile(@Nullable String paramString)
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
        localObject = StringsKt.trim(readStream$default((Companion)this, (InputStreamReader)new FileReader((File)localObject), 0, 2, null), new char[] { '\n' });
        return localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Logger localLogger = Logger.INSTANCE;
        String str = FileUtil.access$getTAG$cp();
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
  @NotNull
  public final String readStream(@NotNull InputStream paramInputStream, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "inputStream");
    return ((Companion)this).readStream(new InputStreamReader(paramInputStream), paramInt);
  }
  
  @JvmStatic
  @NotNull
  public final String readStream(@NotNull InputStreamReader paramInputStreamReader, int paramInt)
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
      Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), paramInputStreamReader);
      paramInputStreamReader = localStringBuffer.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramInputStreamReader, "sb.toString()");
    }
  }
  
  @JvmStatic
  public final void readStreamByLine(@Nullable File paramFile, @Nullable IStreamListener paramIStreamListener)
  {
    if ((paramFile != null) && (paramIStreamListener != null))
    {
      if (!paramFile.exists()) {
        return;
      }
      try
      {
        FilesKt.forEachLine$default(paramFile, null, (Function1)new FileUtil.Companion.readStreamByLine.1(paramIStreamListener), 1, null);
        return;
      }
      catch (Throwable paramFile)
      {
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), paramFile);
      }
    }
  }
  
  public final void setApp(@Nullable Application paramApplication)
  {
    FileUtil.access$setApp$cp(paramApplication);
  }
  
  @JvmStatic
  public final boolean unmapFile(@Nullable FileUtil.MmapFile paramMmapFile)
  {
    if (paramMmapFile == null) {
      return false;
    }
    try
    {
      Method localMethod = Class.forName("sun.nio.ch.FileChannelImpl").getDeclaredMethod("unmap", new Class[] { MappedByteBuffer.class });
      Intrinsics.checkExpressionValueIsNotNull(localMethod, "clazz.getDeclaredMethod(…edByteBuffer::class.java)");
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramMmapFile.getBuffer() });
      paramMmapFile.getFile().close();
      return true;
    }
    catch (Throwable paramMmapFile)
    {
      Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), "unmap file error.", paramMmapFile);
    }
    return false;
  }
  
  @JvmStatic
  public final boolean writeFile(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    if (paramString2 != null)
    {
      Companion localCompanion = FileUtil.Companion;
      Charset localCharset = Charsets.UTF_8;
      if (paramString2 != null)
      {
        paramString2 = paramString2.getBytes(localCharset);
        Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).getBytes(charset)");
        return localCompanion.writeFile(paramString1, paramString2, paramBoolean);
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return false;
  }
  
  /* Error */
  @JvmStatic
  public final boolean writeFile(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: checkcast 2	com/tencent/qapmsdk/common/util/FileUtil$Companion
    //   6: aload_1
    //   7: iload_3
    //   8: invokevirtual 522	com/tencent/qapmsdk/common/util/FileUtil$Companion:getFileBufferStream	(Ljava/lang/String;Z)Ljava/io/BufferedOutputStream;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull +78 -> 93
    //   18: aload 4
    //   20: checkcast 524	java/io/Closeable
    //   23: astore 6
    //   25: aconst_null
    //   26: checkcast 82	java/lang/Throwable
    //   29: astore 5
    //   31: aload 5
    //   33: astore 4
    //   35: aload 6
    //   37: checkcast 225	java/io/BufferedOutputStream
    //   40: astore 7
    //   42: aload_2
    //   43: ifnull +21 -> 64
    //   46: aload 5
    //   48: astore 4
    //   50: aload 7
    //   52: aload_2
    //   53: invokevirtual 528	java/io/BufferedOutputStream:write	([B)V
    //   56: aload 5
    //   58: astore 4
    //   60: getstatic 533	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   63: astore_2
    //   64: aload 6
    //   66: aload 5
    //   68: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
    //   88: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   91: aload_2
    //   92: athrow
    //   93: iconst_1
    //   94: istore_3
    //   95: goto +68 -> 163
    //   98: astore_1
    //   99: goto +68 -> 167
    //   102: astore_2
    //   103: getstatic 132	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   106: astore 4
    //   108: invokestatic 135	com/tencent/qapmsdk/common/util/FileUtil:access$getTAG$cp	()Ljava/lang/String;
    //   111: astore 5
    //   113: new 237	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   120: astore 6
    //   122: aload 6
    //   124: ldc 240
    //   126: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 6
    //   132: aload_1
    //   133: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 6
    //   139: ldc 246
    //   141: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 4
    //   147: aload 5
    //   149: aload 6
    //   151: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload_2
    //   155: checkcast 82	java/lang/Throwable
    //   158: invokevirtual 252	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
  
  @JvmStatic
  public final boolean zipFiles(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "dir");
    Intrinsics.checkParameterIsNotNull(paramString2, "outputPath");
    paramString1 = new File(paramString1).listFiles();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "listFiles");
    paramString1 = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(SequencesKt.filter(ArraysKt.asSequence(paramString1), (Function1)FileUtil.Companion.zipFiles.allFiles.1.INSTANCE), (Function1)FileUtil.Companion.zipFiles.allFiles.2.INSTANCE), (Function1)FileUtil.Companion.zipFiles.allFiles.3.INSTANCE));
    return ((Companion)this).zipFiles(paramString1, paramString2, paramBoolean);
  }
  
  /* Error */
  @JvmStatic
  public final boolean zipFiles(@NotNull java.util.List<String> paramList, @NotNull String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 576
    //   4: invokestatic 171	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_2
    //   8: ldc_w 541
    //   11: invokestatic 171	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: new 227	java/io/FileOutputStream
    //   17: dup
    //   18: new 113	java/io/File
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 577	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: astore 4
    //   31: iload_3
    //   32: ifeq +30 -> 62
    //   35: new 579	java/util/zip/GZIPOutputStream
    //   38: dup
    //   39: new 225	java/io/BufferedOutputStream
    //   42: dup
    //   43: aload 4
    //   45: checkcast 232	java/io/OutputStream
    //   48: invokespecial 582	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: checkcast 232	java/io/OutputStream
    //   54: invokespecial 583	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: astore 4
    //   59: goto +27 -> 86
    //   62: new 585	java/util/zip/ZipOutputStream
    //   65: dup
    //   66: new 225	java/io/BufferedOutputStream
    //   69: dup
    //   70: aload 4
    //   72: checkcast 232	java/io/OutputStream
    //   75: invokespecial 582	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   78: checkcast 232	java/io/OutputStream
    //   81: invokespecial 586	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   84: astore 4
    //   86: aload 4
    //   88: checkcast 588	java/util/zip/DeflaterOutputStream
    //   91: astore 4
    //   93: aload 4
    //   95: checkcast 524	java/io/Closeable
    //   98: astore 8
    //   100: aconst_null
    //   101: checkcast 82	java/lang/Throwable
    //   104: astore 6
    //   106: aload 6
    //   108: astore 5
    //   110: aload 8
    //   112: checkcast 588	java/util/zip/DeflaterOutputStream
    //   115: astore 4
    //   117: aload 6
    //   119: astore 5
    //   121: aload_1
    //   122: checkcast 420	java/lang/Iterable
    //   125: astore 7
    //   127: aload 6
    //   129: astore 5
    //   131: new 255	java/util/ArrayList
    //   134: dup
    //   135: invokespecial 256	java/util/ArrayList:<init>	()V
    //   138: checkcast 258	java/util/Collection
    //   141: astore_1
    //   142: aload 6
    //   144: astore 5
    //   146: aload 7
    //   148: invokeinterface 424 1 0
    //   153: astore 7
    //   155: aload 6
    //   157: astore 5
    //   159: aload 7
    //   161: invokeinterface 429 1 0
    //   166: ifeq +54 -> 220
    //   169: aload 6
    //   171: astore 5
    //   173: aload 7
    //   175: invokeinterface 433 1 0
    //   180: astore 9
    //   182: aload 6
    //   184: astore 5
    //   186: new 113	java/io/File
    //   189: dup
    //   190: aload 9
    //   192: checkcast 391	java/lang/String
    //   195: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   198: invokevirtual 190	java/io/File:exists	()Z
    //   201: ifeq -46 -> 155
    //   204: aload 6
    //   206: astore 5
    //   208: aload_1
    //   209: aload 9
    //   211: invokeinterface 589 2 0
    //   216: pop
    //   217: goto -62 -> 155
    //   220: aload 6
    //   222: astore 5
    //   224: aload_1
    //   225: checkcast 591	java/util/List
    //   228: checkcast 420	java/lang/Iterable
    //   231: invokeinterface 424 1 0
    //   236: astore 9
    //   238: aload 6
    //   240: astore 5
    //   242: aload 9
    //   244: invokeinterface 429 1 0
    //   249: ifeq +266 -> 515
    //   252: aload 6
    //   254: astore 5
    //   256: new 113	java/io/File
    //   259: dup
    //   260: aload 9
    //   262: invokeinterface 433 1 0
    //   267: checkcast 391	java/lang/String
    //   270: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   273: astore 7
    //   275: iload_3
    //   276: ifne +93 -> 369
    //   279: aload 6
    //   281: astore 5
    //   283: aload 4
    //   285: instanceof 585
    //   288: ifne +317 -> 605
    //   291: aconst_null
    //   292: astore_1
    //   293: goto +3 -> 296
    //   296: aload 6
    //   298: astore 5
    //   300: aload_1
    //   301: checkcast 585	java/util/zip/ZipOutputStream
    //   304: astore_1
    //   305: aload_1
    //   306: ifnull +23 -> 329
    //   309: aload 6
    //   311: astore 5
    //   313: aload_1
    //   314: new 593	java/util/zip/ZipEntry
    //   317: dup
    //   318: aload 7
    //   320: invokevirtual 282	java/io/File:getName	()Ljava/lang/String;
    //   323: invokespecial 594	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   326: invokevirtual 598	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   329: aload 6
    //   331: astore 5
    //   333: aload 4
    //   335: instanceof 585
    //   338: ifne +273 -> 611
    //   341: aconst_null
    //   342: astore_1
    //   343: goto +3 -> 346
    //   346: aload 6
    //   348: astore 5
    //   350: aload_1
    //   351: checkcast 585	java/util/zip/ZipOutputStream
    //   354: astore_1
    //   355: aload_1
    //   356: ifnull +13 -> 369
    //   359: aload 6
    //   361: astore 5
    //   363: aload_1
    //   364: bipush 9
    //   366: invokevirtual 601	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   369: aload 6
    //   371: astore 5
    //   373: new 603	java/io/FileInputStream
    //   376: dup
    //   377: aload 7
    //   379: invokespecial 604	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   382: checkcast 524	java/io/Closeable
    //   385: astore 10
    //   387: aload 6
    //   389: astore 5
    //   391: aconst_null
    //   392: checkcast 82	java/lang/Throwable
    //   395: astore 7
    //   397: aload 7
    //   399: astore_1
    //   400: aload 10
    //   402: checkcast 603	java/io/FileInputStream
    //   405: checkcast 606	java/io/InputStream
    //   408: aload 4
    //   410: checkcast 232	java/io/OutputStream
    //   413: sipush 20480
    //   416: invokestatic 612	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   419: pop2
    //   420: aload 6
    //   422: astore 5
    //   424: aload 10
    //   426: aload 7
    //   428: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   431: aload 6
    //   433: astore 5
    //   435: aload 4
    //   437: invokevirtual 615	java/util/zip/DeflaterOutputStream:flush	()V
    //   440: iload_3
    //   441: ifne -203 -> 238
    //   444: aload 6
    //   446: astore 5
    //   448: aload 4
    //   450: instanceof 585
    //   453: ifne +164 -> 617
    //   456: aconst_null
    //   457: astore_1
    //   458: goto +3 -> 461
    //   461: aload 6
    //   463: astore 5
    //   465: aload_1
    //   466: checkcast 585	java/util/zip/ZipOutputStream
    //   469: astore_1
    //   470: aload_1
    //   471: ifnull -233 -> 238
    //   474: aload 6
    //   476: astore 5
    //   478: aload_1
    //   479: invokevirtual 618	java/util/zip/ZipOutputStream:closeEntry	()V
    //   482: goto -244 -> 238
    //   485: astore 4
    //   487: goto +11 -> 498
    //   490: astore 4
    //   492: aload 4
    //   494: astore_1
    //   495: aload 4
    //   497: athrow
    //   498: aload 6
    //   500: astore 5
    //   502: aload 10
    //   504: aload_1
    //   505: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   508: aload 6
    //   510: astore 5
    //   512: aload 4
    //   514: athrow
    //   515: aload 6
    //   517: astore 5
    //   519: getstatic 533	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   522: astore_1
    //   523: aload 8
    //   525: aload 6
    //   527: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   530: iconst_1
    //   531: ireturn
    //   532: astore_1
    //   533: goto +9 -> 542
    //   536: astore_1
    //   537: aload_1
    //   538: astore 5
    //   540: aload_1
    //   541: athrow
    //   542: aload 8
    //   544: aload 5
    //   546: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   549: aload_1
    //   550: athrow
    //   551: astore_1
    //   552: getstatic 132	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   555: astore 4
    //   557: invokestatic 135	com/tencent/qapmsdk/common/util/FileUtil:access$getTAG$cp	()Ljava/lang/String;
    //   560: astore 5
    //   562: new 237	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   569: astore 6
    //   571: aload 6
    //   573: ldc_w 620
    //   576: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 6
    //   582: aload_2
    //   583: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload 4
    //   589: aload 5
    //   591: aload 6
    //   593: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: aload_1
    //   597: checkcast 82	java/lang/Throwable
    //   600: invokevirtual 252	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   603: iconst_0
    //   604: ireturn
    //   605: aload 4
    //   607: astore_1
    //   608: goto -312 -> 296
    //   611: aload 4
    //   613: astore_1
    //   614: goto -268 -> 346
    //   617: aload 4
    //   619: astore_1
    //   620: goto -159 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	this	Companion
    //   0	623	1	paramList	java.util.List<String>
    //   0	623	2	paramString	String
    //   0	623	3	paramBoolean	boolean
    //   29	420	4	localObject1	Object
    //   485	1	4	localObject2	Object
    //   490	23	4	localThrowable	Throwable
    //   555	63	4	localLogger	Logger
    //   108	482	5	localObject3	Object
    //   104	488	6	localObject4	Object
    //   125	302	7	localObject5	Object
    //   98	445	8	localCloseable1	java.io.Closeable
    //   180	81	9	localObject6	Object
    //   385	118	10	localCloseable2	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   400	420	485	finally
    //   495	498	485	finally
    //   400	420	490	java/lang/Throwable
    //   110	117	532	finally
    //   121	127	532	finally
    //   131	142	532	finally
    //   146	155	532	finally
    //   159	169	532	finally
    //   173	182	532	finally
    //   186	204	532	finally
    //   208	217	532	finally
    //   224	238	532	finally
    //   242	252	532	finally
    //   256	275	532	finally
    //   283	291	532	finally
    //   300	305	532	finally
    //   313	329	532	finally
    //   333	341	532	finally
    //   350	355	532	finally
    //   363	369	532	finally
    //   373	387	532	finally
    //   391	397	532	finally
    //   424	431	532	finally
    //   435	440	532	finally
    //   448	456	532	finally
    //   465	470	532	finally
    //   478	482	532	finally
    //   502	508	532	finally
    //   512	515	532	finally
    //   519	523	532	finally
    //   540	542	532	finally
    //   110	117	536	java/lang/Throwable
    //   121	127	536	java/lang/Throwable
    //   131	142	536	java/lang/Throwable
    //   146	155	536	java/lang/Throwable
    //   159	169	536	java/lang/Throwable
    //   173	182	536	java/lang/Throwable
    //   186	204	536	java/lang/Throwable
    //   208	217	536	java/lang/Throwable
    //   224	238	536	java/lang/Throwable
    //   242	252	536	java/lang/Throwable
    //   256	275	536	java/lang/Throwable
    //   283	291	536	java/lang/Throwable
    //   300	305	536	java/lang/Throwable
    //   313	329	536	java/lang/Throwable
    //   333	341	536	java/lang/Throwable
    //   350	355	536	java/lang/Throwable
    //   363	369	536	java/lang/Throwable
    //   373	387	536	java/lang/Throwable
    //   391	397	536	java/lang/Throwable
    //   424	431	536	java/lang/Throwable
    //   435	440	536	java/lang/Throwable
    //   448	456	536	java/lang/Throwable
    //   465	470	536	java/lang/Throwable
    //   478	482	536	java/lang/Throwable
    //   502	508	536	java/lang/Throwable
    //   512	515	536	java/lang/Throwable
    //   519	523	536	java/lang/Throwable
    //   93	106	551	java/io/IOException
    //   523	530	551	java/io/IOException
    //   542	551	551	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.FileUtil.Companion
 * JD-Core Version:    0.7.0.1
 */