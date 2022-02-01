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
  public static final void c(@Nullable String paramString)
  {
    if (!a.a(paramString)) {
      try
      {
        a.b(paramString);
        return;
      }
      catch (IOException paramString)
      {
        Log.i("FileUtils", "createFileIfNotExits", (Throwable)paramString);
      }
    }
  }
  
  @JvmStatic
  public static final long d(@Nullable String paramString)
  {
    long l = 0L;
    if (paramString != null)
    {
      paramString = MmrExtensionsKt.a(new MediaMetadataRetriever(), paramString);
      if (paramString != null)
      {
        String str = paramString.extractMetadata(9);
        if (str != null) {
          l = Long.parseLong(str);
        }
        paramString.release();
        return l;
      }
      paramString = (Void)null;
    }
    return 0L;
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getAbsoluteFile().toString());
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
        localObject = new File(localStringBuilder.toString());
        a.a((File)localObject, true);
        i += 1;
      }
      if (paramBoolean) {
        a(paramFile);
      }
    }
    else
    {
      a(paramFile);
    }
  }
  
  public final boolean a(@Nullable File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists() == true)) {
      return paramFile.delete();
    }
    return false;
  }
  
  public final boolean a(@Nullable String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  @Nullable
  public final File b(@Nullable String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.createNewFile();
          return paramString;
        }
      }
      else {
        paramString.createNewFile();
      }
    }
    return paramString;
  }
  
  @NotNull
  public final String e(@Nullable String paramString)
  {
    if (paramString != null)
    {
      int i = StringsKt.lastIndexOf$default((CharSequence)paramString, ".", 0, false, 6, null);
      if ((i >= 0) && (i < paramString.length() - 1))
      {
        int j = paramString.length();
        if (paramString != null)
        {
          paramString = paramString.substring(i + 1, j);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      else
      {
        paramString = "";
      }
    }
    else
    {
      paramString = null;
    }
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.FileUtils
 * JD-Core Version:    0.7.0.1
 */