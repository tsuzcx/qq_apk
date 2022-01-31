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
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;", "", "()V", "QAPM_ROOT", "", "SDPath", "TAG", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "setApp", "(Landroid/app/Application;)V", "createFile", "", "filePath", "path", "fileName", "deleteAllFilesOfDir", "", "Ljava/io/File;", "getExternalStorageDirectory", "getFiles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reg", "getRootPath", "loadLibrary", "soPath", "readOutputFromFile", "pathToFile", "readStream", "inputStream", "Ljava/io/InputStream;", "bufferSize", "", "inputStreamReader", "Ljava/io/InputStreamReader;", "writeFile", "fileStr", "text", "isAppend", "zipFiles", "dir", "outputPath", "allFiles", "", "common_release"}, k=1, mv={1, 1, 15})
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
  @Nullable
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
  
  public final void setApp(@Nullable Application paramApplication)
  {
    FileUtil.access$setApp$cp(paramApplication);
  }
  
  @JvmStatic
  public final boolean writeFile(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramString1 == null)
    {
      paramBoolean = bool;
      return paramBoolean;
    }
    for (;;)
    {
      try
      {
        localObject1 = new File(paramString1);
        localObject2 = ((File)localObject1).getParentFile();
        if (!((File)localObject2).exists()) {
          if (((File)localObject2).mkdirs())
          {
            break label287;
            if ((i != 0) && (((File)localObject1).exists())) {
              break label293;
            }
            if (!((File)localObject1).createNewFile()) {
              continue;
            }
            break label293;
            if (i == 0) {
              continue;
            }
            localCloseable = (Closeable)new BufferedOutputStream((OutputStream)new FileOutputStream(paramString1, paramBoolean), 8192);
            localObject2 = (Throwable)null;
            localObject1 = localObject2;
            try
            {
              localBufferedOutputStream = (BufferedOutputStream)localCloseable;
              if (paramString2 != null)
              {
                localObject1 = localObject2;
                localCharset = Charsets.UTF_8;
                if (paramString2 == null)
                {
                  localObject1 = localObject2;
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
              }
            }
            catch (Throwable paramString2)
            {
              localObject1 = paramString2;
              throw paramString2;
            }
            finally
            {
              CloseableKt.closeFinally(localCloseable, (Throwable)localObject1);
            }
          }
        }
      }
      catch (IOException paramString2)
      {
        Object localObject2;
        Closeable localCloseable;
        BufferedOutputStream localBufferedOutputStream;
        Charset localCharset;
        Logger.INSTANCE.exception(FileUtil.access$getTAG$cp(), "write file " + paramString1 + " error. ", (Throwable)paramString2);
        paramBoolean = false;
        break;
        i = 0;
        continue;
        i = 0;
        continue;
        Object localObject1 = localObject2;
        paramString2 = paramString2.getBytes(localCharset);
        localObject1 = localObject2;
        Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).getBytes(charset)");
        localObject1 = localObject2;
        localBufferedOutputStream.write(paramString2);
        localObject1 = localObject2;
        paramString2 = Unit.INSTANCE;
        CloseableKt.closeFinally(localCloseable, (Throwable)localObject2);
        paramBoolean = true;
        continue;
      }
      finally {}
      label287:
      int i = 1;
      continue;
      label293:
      i = 1;
    }
  }
  
  @JvmStatic
  public final boolean zipFiles(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "dir");
    Intrinsics.checkParameterIsNotNull(paramString2, "outputPath");
    paramString1 = new File(paramString1).listFiles();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "listFiles");
    paramString1 = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(SequencesKt.filter(ArraysKt.asSequence(paramString1), (Function1)FileUtil.Companion.zipFiles.allFiles.1.INSTANCE), (Function1)FileUtil.Companion.zipFiles.allFiles.2.INSTANCE), (Function1)FileUtil.Companion.zipFiles.allFiles.3.INSTANCE));
    return ((Companion)this).zipFiles(paramString1, paramString2);
  }
  
  /* Error */
  @JvmStatic
  public final boolean zipFiles(@NotNull java.util.List<String> paramList, @NotNull String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 446
    //   4: invokestatic 242	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_2
    //   8: ldc_w 405
    //   11: invokestatic 242	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: new 448	java/util/zip/ZipOutputStream
    //   17: dup
    //   18: new 352	java/io/BufferedOutputStream
    //   21: dup
    //   22: new 354	java/io/FileOutputStream
    //   25: dup
    //   26: new 98	java/io/File
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: invokespecial 449	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: checkcast 359	java/io/OutputStream
    //   40: invokespecial 452	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: checkcast 359	java/io/OutputStream
    //   46: invokespecial 453	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore_3
    //   50: aload_3
    //   51: checkcast 364	java/io/Closeable
    //   54: astore 6
    //   56: aconst_null
    //   57: checkcast 67	java/lang/Throwable
    //   60: astore 5
    //   62: aload 5
    //   64: astore_3
    //   65: aload 6
    //   67: checkcast 448	java/util/zip/ZipOutputStream
    //   70: astore 8
    //   72: aload 5
    //   74: astore_3
    //   75: aload_1
    //   76: checkcast 325	java/lang/Iterable
    //   79: astore 4
    //   81: aload 5
    //   83: astore_3
    //   84: new 183	java/util/ArrayList
    //   87: dup
    //   88: invokespecial 184	java/util/ArrayList:<init>	()V
    //   91: checkcast 186	java/util/Collection
    //   94: astore_1
    //   95: aload 5
    //   97: astore_3
    //   98: aload 4
    //   100: invokeinterface 329 1 0
    //   105: astore 4
    //   107: aload 5
    //   109: astore_3
    //   110: aload 4
    //   112: invokeinterface 334 1 0
    //   117: ifeq +101 -> 218
    //   120: aload 5
    //   122: astore_3
    //   123: aload 4
    //   125: invokeinterface 338 1 0
    //   130: astore 7
    //   132: aload 5
    //   134: astore_3
    //   135: new 98	java/io/File
    //   138: dup
    //   139: aload 7
    //   141: checkcast 279	java/lang/String
    //   144: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: invokevirtual 145	java/io/File:exists	()Z
    //   150: ifeq -43 -> 107
    //   153: aload 5
    //   155: astore_3
    //   156: aload_1
    //   157: aload 7
    //   159: invokeinterface 454 2 0
    //   164: pop
    //   165: goto -58 -> 107
    //   168: astore_1
    //   169: aload_1
    //   170: astore_3
    //   171: aload_1
    //   172: athrow
    //   173: astore_1
    //   174: aload 6
    //   176: aload_3
    //   177: invokestatic 381	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: getstatic 118	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   186: invokestatic 121	com/tencent/qapmsdk/common/util/FileUtil:access$getTAG$cp	()Ljava/lang/String;
    //   189: new 281	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 456
    //   199: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_2
    //   203: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: aload_1
    //   210: checkcast 67	java/lang/Throwable
    //   213: invokevirtual 388	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: iconst_0
    //   217: ireturn
    //   218: aload 5
    //   220: astore_3
    //   221: aload_1
    //   222: checkcast 458	java/util/List
    //   225: checkcast 325	java/lang/Iterable
    //   228: invokeinterface 329 1 0
    //   233: astore_1
    //   234: aload 5
    //   236: astore_3
    //   237: aload_1
    //   238: invokeinterface 334 1 0
    //   243: ifeq +150 -> 393
    //   246: aload 5
    //   248: astore_3
    //   249: new 98	java/io/File
    //   252: dup
    //   253: aload_1
    //   254: invokeinterface 338 1 0
    //   259: checkcast 279	java/lang/String
    //   262: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   265: astore 4
    //   267: aload 5
    //   269: astore_3
    //   270: aload 8
    //   272: new 460	java/util/zip/ZipEntry
    //   275: dup
    //   276: aload 4
    //   278: invokevirtual 213	java/io/File:getName	()Ljava/lang/String;
    //   281: invokespecial 461	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   284: invokevirtual 465	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   287: aload 5
    //   289: astore_3
    //   290: aload 8
    //   292: bipush 9
    //   294: invokevirtual 468	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   297: aload 5
    //   299: astore_3
    //   300: new 470	java/io/FileInputStream
    //   303: dup
    //   304: aload 4
    //   306: invokespecial 471	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   309: checkcast 364	java/io/Closeable
    //   312: astore 7
    //   314: aload 5
    //   316: astore_3
    //   317: aconst_null
    //   318: checkcast 67	java/lang/Throwable
    //   321: astore 4
    //   323: aload 7
    //   325: checkcast 470	java/io/FileInputStream
    //   328: checkcast 473	java/io/InputStream
    //   331: aload 8
    //   333: checkcast 359	java/io/OutputStream
    //   336: sipush 20480
    //   339: invokestatic 479	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   342: pop2
    //   343: aload 5
    //   345: astore_3
    //   346: aload 7
    //   348: aload 4
    //   350: invokestatic 381	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   353: aload 5
    //   355: astore_3
    //   356: aload 8
    //   358: invokevirtual 482	java/util/zip/ZipOutputStream:flush	()V
    //   361: aload 5
    //   363: astore_3
    //   364: aload 8
    //   366: invokevirtual 485	java/util/zip/ZipOutputStream:closeEntry	()V
    //   369: goto -135 -> 234
    //   372: astore 4
    //   374: aload 4
    //   376: athrow
    //   377: astore_1
    //   378: aload 5
    //   380: astore_3
    //   381: aload 7
    //   383: aload 4
    //   385: invokestatic 381	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   388: aload 5
    //   390: astore_3
    //   391: aload_1
    //   392: athrow
    //   393: aload 5
    //   395: astore_3
    //   396: getstatic 403	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   399: astore_1
    //   400: aload 6
    //   402: aload 5
    //   404: invokestatic 381	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   407: iconst_1
    //   408: ireturn
    //   409: astore_1
    //   410: goto -32 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	Companion
    //   0	413	1	paramList	java.util.List<String>
    //   0	413	2	paramString	String
    //   49	347	3	localObject1	Object
    //   79	270	4	localObject2	Object
    //   372	12	4	localThrowable1	Throwable
    //   60	343	5	localThrowable2	Throwable
    //   54	347	6	localCloseable	Closeable
    //   130	252	7	localObject3	Object
    //   70	295	8	localZipOutputStream	java.util.zip.ZipOutputStream
    // Exception table:
    //   from	to	target	type
    //   65	72	168	java/lang/Throwable
    //   75	81	168	java/lang/Throwable
    //   84	95	168	java/lang/Throwable
    //   98	107	168	java/lang/Throwable
    //   110	120	168	java/lang/Throwable
    //   123	132	168	java/lang/Throwable
    //   135	153	168	java/lang/Throwable
    //   156	165	168	java/lang/Throwable
    //   221	234	168	java/lang/Throwable
    //   237	246	168	java/lang/Throwable
    //   249	267	168	java/lang/Throwable
    //   270	287	168	java/lang/Throwable
    //   290	297	168	java/lang/Throwable
    //   300	314	168	java/lang/Throwable
    //   317	323	168	java/lang/Throwable
    //   346	353	168	java/lang/Throwable
    //   356	361	168	java/lang/Throwable
    //   364	369	168	java/lang/Throwable
    //   381	388	168	java/lang/Throwable
    //   391	393	168	java/lang/Throwable
    //   396	400	168	java/lang/Throwable
    //   65	72	173	finally
    //   75	81	173	finally
    //   84	95	173	finally
    //   98	107	173	finally
    //   110	120	173	finally
    //   123	132	173	finally
    //   135	153	173	finally
    //   156	165	173	finally
    //   171	173	173	finally
    //   221	234	173	finally
    //   237	246	173	finally
    //   249	267	173	finally
    //   270	287	173	finally
    //   290	297	173	finally
    //   300	314	173	finally
    //   317	323	173	finally
    //   346	353	173	finally
    //   356	361	173	finally
    //   364	369	173	finally
    //   381	388	173	finally
    //   391	393	173	finally
    //   396	400	173	finally
    //   50	62	182	java/io/IOException
    //   174	182	182	java/io/IOException
    //   400	407	182	java/io/IOException
    //   323	343	372	java/lang/Throwable
    //   374	377	377	finally
    //   323	343	409	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.FileUtil.Companion
 * JD-Core Version:    0.7.0.1
 */