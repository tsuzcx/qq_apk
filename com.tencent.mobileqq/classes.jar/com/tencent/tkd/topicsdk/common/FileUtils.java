package com.tencent.tkd.topicsdk.common;

import android.media.MediaMetadataRetriever;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/FileUtils;", "", "()V", "TAG", "", "clearDir", "", "file", "Ljava/io/File;", "includeDir", "", "createFile", "path", "createFileIfNotExits", "filePath", "deleteFile", "fileExists", "getDurationOfVideo", "", "getFileFormat", "getFileSize", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class FileUtils
{
  public static final FileUtils a = new FileUtils();
  
  @JvmStatic
  public static final void a(@Nullable String paramString)
  {
    if (!a.a(paramString)) {}
    try
    {
      a.a(paramString);
      return;
    }
    catch (IOException paramString)
    {
      Log.i("FileUtils", "createFileIfNotExits", (Throwable)paramString);
    }
  }
  
  @JvmStatic
  public static final long b(@Nullable String paramString)
  {
    if (paramString != null)
    {
      paramString = MmrExtensionsKt.a(new MediaMetadataRetriever(), paramString);
      if (paramString != null)
      {
        String str = paramString.extractMetadata(9);
        if (str != null) {}
        for (long l = Long.parseLong(str);; l = 0L)
        {
          paramString.release();
          return l;
        }
      }
      paramString = (Void)null;
    }
    for (;;)
    {
      return 0L;
    }
  }
  
  public final long a(@Nullable String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
    try
    {
      long l = new File(paramString).length();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  @Nullable
  public final File a(@Nullable String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  @NotNull
  public final String a(@Nullable String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = StringsKt.lastIndexOf$default((CharSequence)paramString, ".", 0, false, 6, null);
      if ((i < 0) || (i >= paramString.length() - 1)) {
        paramString = "";
      }
    }
    while (paramString != null)
    {
      return paramString;
      int j = paramString.length();
      if (paramString == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramString = paramString.substring(i + 1, j);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      continue;
      paramString = null;
    }
    return "";
  }
  
  public final void a(@NotNull File paramFile, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      Intrinsics.checkExpressionValueIsNotNull(arrayOfString, "childFileList");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        localObject = new File(paramFile.getAbsoluteFile().toString() + "/" + (String)localObject);
        a.a((File)localObject, true);
        i += 1;
      }
      if (paramBoolean) {
        a(paramFile);
      }
      return;
    }
    a(paramFile);
  }
  
  public final boolean a(@Nullable File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.exists() == true) {
        bool1 = paramFile.delete();
      }
    }
    return bool1;
  }
  
  public final boolean a(@Nullable String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public final boolean b(@Nullable String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.FileUtils
 * JD-Core Version:    0.7.0.1
 */