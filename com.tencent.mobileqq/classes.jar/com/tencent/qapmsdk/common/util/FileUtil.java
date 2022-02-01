package com.tencent.qapmsdk.common.util;

import android.app.Application;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/FileUtil;", "", "()V", "Companion", "MmapFile", "common_release"}, k=1, mv={1, 1, 15})
public final class FileUtil
{
  public static final FileUtil.Companion Companion = new FileUtil.Companion(null);
  private static String QAPM_ROOT = "";
  private static String SDPath;
  private static final String TAG = "QAPM_common_FileUtil";
  @Nullable
  private static Application app;
  
  @JvmStatic
  @Nullable
  public static final File copyFile(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    return Companion.copyFile(paramFile1, paramFile2);
  }
  
  @JvmStatic
  public static final boolean createFile(@Nullable String paramString)
  {
    return Companion.createFile(paramString);
  }
  
  @JvmStatic
  public static final boolean createFile(@Nullable String paramString1, @Nullable String paramString2)
  {
    return Companion.createFile(paramString1, paramString2);
  }
  
  @JvmStatic
  public static final void deleteAllFilesOfDir(@Nullable File paramFile)
  {
    Companion.deleteAllFilesOfDir(paramFile);
  }
  
  @JvmStatic
  @Nullable
  public static final BufferedOutputStream getFileBufferStream(@Nullable String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = Companion.getFileBufferStream(paramString, paramBoolean);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @JvmStatic
  @Nullable
  public static final ArrayList<File> getFiles(@Nullable String paramString1, @Nullable String paramString2)
  {
    return Companion.getFiles(paramString1, paramString2);
  }
  
  @JvmStatic
  public static final long getLastModifiedTime(@Nullable File paramFile)
  {
    return Companion.getLastModifiedTime(paramFile);
  }
  
  @JvmStatic
  @NotNull
  public static final String getRootPath()
  {
    return Companion.getRootPath();
  }
  
  @JvmStatic
  public static final boolean loadLibrary(@NotNull String paramString)
  {
    return Companion.loadLibrary(paramString);
  }
  
  @JvmStatic
  @Nullable
  public static final FileUtil.MmapFile mmapFile(@Nullable String paramString, long paramLong)
  {
    return Companion.mmapFile(paramString, paramLong);
  }
  
  @JvmStatic
  @NotNull
  public static final String readOutputFromFile(@Nullable String paramString)
  {
    return Companion.readOutputFromFile(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final String readStream(@NotNull InputStream paramInputStream, int paramInt)
  {
    return Companion.readStream(paramInputStream, paramInt);
  }
  
  @JvmStatic
  @NotNull
  public static final String readStream(@NotNull InputStreamReader paramInputStreamReader, int paramInt)
  {
    return Companion.readStream(paramInputStreamReader, paramInt);
  }
  
  @JvmStatic
  public static final void readStreamByLine(@Nullable File paramFile, @Nullable IStreamListener paramIStreamListener)
  {
    Companion.readStreamByLine(paramFile, paramIStreamListener);
  }
  
  @JvmStatic
  public static final boolean unmapFile(@Nullable FileUtil.MmapFile paramMmapFile)
  {
    return Companion.unmapFile(paramMmapFile);
  }
  
  @JvmStatic
  public static final boolean writeFile(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    return Companion.writeFile(paramString1, paramString2, paramBoolean);
  }
  
  @JvmStatic
  public static final boolean writeFile(@Nullable String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      paramBoolean = Companion.writeFile(paramString, paramArrayOfByte, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @JvmStatic
  public static final boolean zipFiles(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    return Companion.zipFiles(paramString1, paramString2, paramBoolean);
  }
  
  @JvmStatic
  public static final boolean zipFiles(@NotNull List<String> paramList, @NotNull String paramString, boolean paramBoolean)
  {
    return Companion.zipFiles(paramList, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */