package com.tencent.qapmsdk.common.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
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
    Object localObject;
    if (!TextUtils.isEmpty((CharSequence)FileUtil.access$getSDPath$cp()))
    {
      localObject = FileUtil.access$getSDPath$cp();
      return localObject;
    }
    for (;;)
    {
      try
      {
        localObject = ((Companion)this).getApp();
        if (localObject == null) {
          continue;
        }
        localObject = ((Application)localObject).getApplicationContext();
        if (localObject == null) {
          continue;
        }
        localObject = ((Context)localObject).getExternalFilesDir("/Tencent/QAPM");
        if (localObject == null) {
          continue;
        }
        localObject = ((File)localObject).getAbsolutePath();
        FileUtil.access$setSDPath$cp((String)localObject);
        if (FileUtil.access$getSDPath$cp() == null)
        {
          localObject = ((Companion)this).getApp();
          if (localObject == null) {
            continue;
          }
          localObject = ((Application)localObject).getApplicationContext();
          if (localObject == null) {
            continue;
          }
          localObject = ((Context)localObject).getDir("Tencent_QAPM", 0);
          if (localObject == null) {
            continue;
          }
          localObject = ((File)localObject).getAbsolutePath();
          FileUtil.access$setSDPath$cp((String)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        String str;
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), localThrowable);
        continue;
      }
      str = FileUtil.access$getSDPath$cp();
      localObject = str;
      if (str != null) {
        break;
      }
      return "";
      localObject = null;
      continue;
      localObject = null;
      continue;
      localObject = null;
      continue;
      localObject = null;
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
    boolean bool1 = true;
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      return true;
    }
    label92:
    for (;;)
    {
      try
      {
        if (!paramString.getParentFile().exists())
        {
          if (paramString.getParentFile().mkdirs())
          {
            break label92;
            if (i != 0)
            {
              boolean bool2 = paramString.createNewFile();
              if (bool2) {
                return bool1;
              }
            }
          }
          else
          {
            i = 0;
            continue;
          }
          bool1 = false;
          continue;
        }
        int i = 1;
      }
      catch (IOException paramString)
      {
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), (Throwable)paramString);
        return false;
      }
    }
  }
  
  @JvmStatic
  public final boolean createFile(@Nullable String paramString1, @Nullable String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return ((Companion)this).createFile(new File(paramString1, paramString2).getAbsolutePath());
  }
  
  @JvmStatic
  public final void deleteAllFilesOfDir(@Nullable File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    File[] arrayOfFile;
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      arrayOfFile = paramFile.listFiles();
    } while (arrayOfFile == null);
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      ((Companion)this).deleteAllFilesOfDir(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  @Nullable
  public final Application getApp()
  {
    return FileUtil.access$getApp$cp();
  }
  
  @JvmStatic
  @Nullable
  public final BufferedOutputStream getFileBufferStream(@Nullable String paramString, boolean paramBoolean)
  {
    int j = 1;
    BufferedOutputStream localBufferedOutputStream1 = null;
    if (paramString == null) {
      return localBufferedOutputStream1;
    }
    for (;;)
    {
      try
      {
        File localFile1 = new File(paramString);
        File localFile2 = localFile1.getParentFile();
        if (!localFile2.exists())
        {
          if (localFile2.mkdirs())
          {
            break label174;
            if (i != 0)
            {
              i = j;
              if (localFile1.exists()) {}
            }
            else
            {
              if (!localFile1.createNewFile()) {
                continue;
              }
              i = j;
            }
            if (i == 0) {
              break;
            }
            localBufferedOutputStream1 = new BufferedOutputStream((OutputStream)new FileOutputStream(paramString, paramBoolean), 8192);
            break;
          }
          i = 0;
          continue;
          i = 0;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), "write file " + paramString + " error. ", (Throwable)localIOException);
        BufferedOutputStream localBufferedOutputStream2 = (BufferedOutputStream)null;
        break;
      }
      finally {}
      label174:
      int i = 1;
    }
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
        paramString1 = arrayOfFile;
      }
    }
    else {
      return paramString1;
    }
    arrayOfFile = ((File)localObject).listFiles();
    localObject = new ArrayList();
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      Collections.addAll((Collection)localObject, (File[])Arrays.copyOf(arrayOfFile, arrayOfFile.length));
      return localObject;
    }
    Intrinsics.checkExpressionValueIsNotNull(arrayOfFile, "files");
    int j = arrayOfFile.length;
    int i = 0;
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
    String str;
    if (((CharSequence)FileUtil.access$getQAPM_ROOT$cp()).length() == 0)
    {
      i = 1;
      if (i != 0)
      {
        str = ((Companion)this).getExternalStorageDirectory();
        if (str == null) {
          break label45;
        }
      }
    }
    for (;;)
    {
      FileUtil.access$setQAPM_ROOT$cp(str);
      return FileUtil.access$getQAPM_ROOT$cp();
      i = 0;
      break;
      label45:
      str = "";
    }
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
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new File(paramString);
        Object localObject2 = ((File)localObject1).getParentFile();
        if (((File)localObject2).exists()) {
          break label198;
        }
        if (((File)localObject2).mkdirs())
        {
          break label198;
          if (i != 0)
          {
            i = j;
            if (((File)localObject1).exists()) {}
          }
          else
          {
            if (!((File)localObject1).createNewFile()) {
              continue;
            }
            i = j;
          }
          if (i == 0) {
            break label191;
          }
          localObject1 = new RandomAccessFile(paramString, "rw");
          localObject2 = ((RandomAccessFile)localObject1).getChannel();
          localObject2 = ((FileChannel)localObject2).map(FileChannel.MapMode.READ_WRITE, ((FileChannel)localObject2).size(), paramLong);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "buffer");
          localObject1 = new FileUtil.MmapFile(paramString, (RandomAccessFile)localObject1, (MappedByteBuffer)localObject2);
          return localObject1;
        }
        else
        {
          i = 0;
          continue;
        }
        i = 0;
        continue;
        return (FileUtil.MmapFile)null;
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), "mmap file " + paramString + " error. ", (Throwable)localException);
      }
      label191:
      return null;
      label198:
      int i = 1;
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
    if ((!((File)localObject).exists()) || (!((File)localObject).canRead())) {
      return "";
    }
    try
    {
      localObject = StringsKt.trim(readStream$default((Companion)this, (InputStreamReader)new FileReader((File)localObject), 0, 2, null), new char[] { '\n' });
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Logger.INSTANCE.w(new String[] { FileUtil.access$getTAG$cp(), localFileNotFoundException.getMessage() + ": file " + paramString + " can not read, because FileNotFoundException" });
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
      while (paramInputStreamReader.hasNext()) {
        localStringBuffer.append((String)paramInputStreamReader.next()).append("\n");
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
    if ((paramFile == null) || (paramIStreamListener == null) || (!paramFile.exists())) {
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
  
  public final void setApp(@Nullable Application paramApplication)
  {
    FileUtil.access$setApp$cp(paramApplication);
  }
  
  @JvmStatic
  public final boolean unmapFile(@Nullable FileUtil.MmapFile paramMmapFile)
  {
    boolean bool = true;
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
      return bool;
    }
    catch (Throwable paramMmapFile)
    {
      for (;;)
      {
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), "unmap file error.", paramMmapFile);
        bool = false;
      }
    }
  }
  
  @JvmStatic
  public final boolean writeFile(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    if (paramString2 != null)
    {
      Companion localCompanion = FileUtil.Companion;
      Charset localCharset = Charsets.UTF_8;
      if (paramString2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramString2 = paramString2.getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).getBytes(charset)");
      return localCompanion.writeFile(paramString1, paramString2, paramBoolean);
    }
    return false;
  }
  
  @JvmStatic
  public final boolean writeFile(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localObject = ((Companion)this).getFileBufferStream(paramString, paramBoolean);
        if (localObject != null)
        {
          localCloseable = (Closeable)localObject;
          localThrowable = (Throwable)null;
          localObject = localThrowable;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        Object localObject;
        Closeable localCloseable;
        Throwable localThrowable;
        BufferedOutputStream localBufferedOutputStream;
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), "write file " + paramString + " error. ", (Throwable)paramArrayOfByte);
        paramBoolean = false;
        continue;
      }
      finally {}
      try
      {
        localBufferedOutputStream = (BufferedOutputStream)localCloseable;
        if (paramArrayOfByte != null)
        {
          localObject = localThrowable;
          localBufferedOutputStream.write(paramArrayOfByte);
          localObject = localThrowable;
          paramArrayOfByte = Unit.INSTANCE;
        }
        CloseableKt.closeFinally(localCloseable, localThrowable);
        paramBoolean = true;
        return paramBoolean;
      }
      catch (Throwable paramArrayOfByte)
      {
        localObject = paramArrayOfByte;
        throw paramArrayOfByte;
      }
      finally
      {
        CloseableKt.closeFinally(localCloseable, (Throwable)localObject);
      }
    }
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
    //   32: ifeq +209 -> 241
    //   35: new 579	java/util/zip/GZIPOutputStream
    //   38: dup
    //   39: new 225	java/io/BufferedOutputStream
    //   42: dup
    //   43: aload 4
    //   45: checkcast 232	java/io/OutputStream
    //   48: invokespecial 582	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: checkcast 232	java/io/OutputStream
    //   54: invokespecial 583	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: checkcast 585	java/util/zip/DeflaterOutputStream
    //   60: astore 4
    //   62: aload 4
    //   64: checkcast 524	java/io/Closeable
    //   67: astore 8
    //   69: aconst_null
    //   70: checkcast 82	java/lang/Throwable
    //   73: astore 6
    //   75: aload 6
    //   77: astore 5
    //   79: aload 8
    //   81: checkcast 585	java/util/zip/DeflaterOutputStream
    //   84: astore 4
    //   86: aload 6
    //   88: astore 5
    //   90: aload_1
    //   91: checkcast 420	java/lang/Iterable
    //   94: astore 7
    //   96: aload 6
    //   98: astore 5
    //   100: new 255	java/util/ArrayList
    //   103: dup
    //   104: invokespecial 256	java/util/ArrayList:<init>	()V
    //   107: checkcast 258	java/util/Collection
    //   110: astore_1
    //   111: aload 6
    //   113: astore 5
    //   115: aload 7
    //   117: invokeinterface 424 1 0
    //   122: astore 7
    //   124: aload 6
    //   126: astore 5
    //   128: aload 7
    //   130: invokeinterface 429 1 0
    //   135: ifeq +136 -> 271
    //   138: aload 6
    //   140: astore 5
    //   142: aload 7
    //   144: invokeinterface 433 1 0
    //   149: astore 9
    //   151: aload 6
    //   153: astore 5
    //   155: new 113	java/io/File
    //   158: dup
    //   159: aload 9
    //   161: checkcast 384	java/lang/String
    //   164: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: invokevirtual 190	java/io/File:exists	()Z
    //   170: ifeq -46 -> 124
    //   173: aload 6
    //   175: astore 5
    //   177: aload_1
    //   178: aload 9
    //   180: invokeinterface 586 2 0
    //   185: pop
    //   186: goto -62 -> 124
    //   189: astore_1
    //   190: aload_1
    //   191: astore 5
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: aload 8
    //   198: aload 5
    //   200: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: getstatic 133	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   209: invokestatic 136	com/tencent/qapmsdk/common/util/FileUtil:access$getTAG$cp	()Ljava/lang/String;
    //   212: new 237	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 588
    //   222: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_2
    //   226: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: aload_1
    //   233: checkcast 82	java/lang/Throwable
    //   236: invokevirtual 252	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   239: iconst_0
    //   240: ireturn
    //   241: new 590	java/util/zip/ZipOutputStream
    //   244: dup
    //   245: new 225	java/io/BufferedOutputStream
    //   248: dup
    //   249: aload 4
    //   251: checkcast 232	java/io/OutputStream
    //   254: invokespecial 582	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   257: checkcast 232	java/io/OutputStream
    //   260: invokespecial 591	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   263: checkcast 585	java/util/zip/DeflaterOutputStream
    //   266: astore 4
    //   268: goto -206 -> 62
    //   271: aload 6
    //   273: astore 5
    //   275: aload_1
    //   276: checkcast 593	java/util/List
    //   279: checkcast 420	java/lang/Iterable
    //   282: invokeinterface 424 1 0
    //   287: astore 9
    //   289: aload 6
    //   291: astore 5
    //   293: aload 9
    //   295: invokeinterface 429 1 0
    //   300: ifeq +247 -> 547
    //   303: aload 6
    //   305: astore 5
    //   307: new 113	java/io/File
    //   310: dup
    //   311: aload 9
    //   313: invokeinterface 433 1 0
    //   318: checkcast 384	java/lang/String
    //   321: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   324: astore 7
    //   326: iload_3
    //   327: ifne +87 -> 414
    //   330: aload 6
    //   332: astore 5
    //   334: aload 4
    //   336: instanceof 590
    //   339: ifne +245 -> 584
    //   342: aconst_null
    //   343: astore_1
    //   344: aload 6
    //   346: astore 5
    //   348: aload_1
    //   349: checkcast 590	java/util/zip/ZipOutputStream
    //   352: astore_1
    //   353: aload_1
    //   354: ifnull +23 -> 377
    //   357: aload 6
    //   359: astore 5
    //   361: aload_1
    //   362: new 595	java/util/zip/ZipEntry
    //   365: dup
    //   366: aload 7
    //   368: invokevirtual 282	java/io/File:getName	()Ljava/lang/String;
    //   371: invokespecial 596	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   374: invokevirtual 600	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   377: aload 6
    //   379: astore 5
    //   381: aload 4
    //   383: instanceof 590
    //   386: ifne +192 -> 578
    //   389: aconst_null
    //   390: astore_1
    //   391: aload 6
    //   393: astore 5
    //   395: aload_1
    //   396: checkcast 590	java/util/zip/ZipOutputStream
    //   399: astore_1
    //   400: aload_1
    //   401: ifnull +13 -> 414
    //   404: aload 6
    //   406: astore 5
    //   408: aload_1
    //   409: bipush 9
    //   411: invokevirtual 603	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   414: aload 6
    //   416: astore 5
    //   418: new 605	java/io/FileInputStream
    //   421: dup
    //   422: aload 7
    //   424: invokespecial 606	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   427: checkcast 524	java/io/Closeable
    //   430: astore 10
    //   432: aload 6
    //   434: astore 5
    //   436: aconst_null
    //   437: checkcast 82	java/lang/Throwable
    //   440: astore 7
    //   442: aload 10
    //   444: checkcast 605	java/io/FileInputStream
    //   447: checkcast 608	java/io/InputStream
    //   450: aload 4
    //   452: checkcast 232	java/io/OutputStream
    //   455: sipush 20480
    //   458: invokestatic 614	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   461: pop2
    //   462: aload 6
    //   464: astore 5
    //   466: aload 10
    //   468: aload 7
    //   470: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   473: aload 6
    //   475: astore 5
    //   477: aload 4
    //   479: invokevirtual 617	java/util/zip/DeflaterOutputStream:flush	()V
    //   482: iload_3
    //   483: ifne +38 -> 521
    //   486: aload 6
    //   488: astore 5
    //   490: aload 4
    //   492: instanceof 590
    //   495: ifne +77 -> 572
    //   498: aconst_null
    //   499: astore_1
    //   500: aload 6
    //   502: astore 5
    //   504: aload_1
    //   505: checkcast 590	java/util/zip/ZipOutputStream
    //   508: astore_1
    //   509: aload_1
    //   510: ifnull +11 -> 521
    //   513: aload 6
    //   515: astore 5
    //   517: aload_1
    //   518: invokevirtual 620	java/util/zip/ZipOutputStream:closeEntry	()V
    //   521: goto -232 -> 289
    //   524: astore 4
    //   526: aload 4
    //   528: athrow
    //   529: astore_1
    //   530: aload 6
    //   532: astore 5
    //   534: aload 10
    //   536: aload 4
    //   538: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   541: aload 6
    //   543: astore 5
    //   545: aload_1
    //   546: athrow
    //   547: aload 6
    //   549: astore 5
    //   551: getstatic 533	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   554: astore_1
    //   555: aload 8
    //   557: aload 6
    //   559: invokestatic 539	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   562: iconst_1
    //   563: ireturn
    //   564: astore_1
    //   565: aload 7
    //   567: astore 4
    //   569: goto -39 -> 530
    //   572: aload 4
    //   574: astore_1
    //   575: goto -75 -> 500
    //   578: aload 4
    //   580: astore_1
    //   581: goto -190 -> 391
    //   584: aload 4
    //   586: astore_1
    //   587: goto -243 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	Companion
    //   0	590	1	paramList	java.util.List<String>
    //   0	590	2	paramString	String
    //   0	590	3	paramBoolean	boolean
    //   29	462	4	localObject1	Object
    //   524	13	4	localThrowable1	Throwable
    //   567	18	4	localObject2	Object
    //   77	473	5	localObject3	Object
    //   73	485	6	localThrowable2	Throwable
    //   94	472	7	localObject4	Object
    //   67	489	8	localCloseable1	Closeable
    //   149	163	9	localObject5	Object
    //   430	105	10	localCloseable2	Closeable
    // Exception table:
    //   from	to	target	type
    //   79	86	189	java/lang/Throwable
    //   90	96	189	java/lang/Throwable
    //   100	111	189	java/lang/Throwable
    //   115	124	189	java/lang/Throwable
    //   128	138	189	java/lang/Throwable
    //   142	151	189	java/lang/Throwable
    //   155	173	189	java/lang/Throwable
    //   177	186	189	java/lang/Throwable
    //   275	289	189	java/lang/Throwable
    //   293	303	189	java/lang/Throwable
    //   307	326	189	java/lang/Throwable
    //   334	342	189	java/lang/Throwable
    //   348	353	189	java/lang/Throwable
    //   361	377	189	java/lang/Throwable
    //   381	389	189	java/lang/Throwable
    //   395	400	189	java/lang/Throwable
    //   408	414	189	java/lang/Throwable
    //   418	432	189	java/lang/Throwable
    //   436	442	189	java/lang/Throwable
    //   466	473	189	java/lang/Throwable
    //   477	482	189	java/lang/Throwable
    //   490	498	189	java/lang/Throwable
    //   504	509	189	java/lang/Throwable
    //   517	521	189	java/lang/Throwable
    //   534	541	189	java/lang/Throwable
    //   545	547	189	java/lang/Throwable
    //   551	555	189	java/lang/Throwable
    //   79	86	195	finally
    //   90	96	195	finally
    //   100	111	195	finally
    //   115	124	195	finally
    //   128	138	195	finally
    //   142	151	195	finally
    //   155	173	195	finally
    //   177	186	195	finally
    //   193	195	195	finally
    //   275	289	195	finally
    //   293	303	195	finally
    //   307	326	195	finally
    //   334	342	195	finally
    //   348	353	195	finally
    //   361	377	195	finally
    //   381	389	195	finally
    //   395	400	195	finally
    //   408	414	195	finally
    //   418	432	195	finally
    //   436	442	195	finally
    //   466	473	195	finally
    //   477	482	195	finally
    //   490	498	195	finally
    //   504	509	195	finally
    //   517	521	195	finally
    //   534	541	195	finally
    //   545	547	195	finally
    //   551	555	195	finally
    //   62	75	205	java/io/IOException
    //   196	205	205	java/io/IOException
    //   555	562	205	java/io/IOException
    //   442	462	524	java/lang/Throwable
    //   526	529	529	finally
    //   442	462	564	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.FileUtil.Companion
 * JD-Core Version:    0.7.0.1
 */