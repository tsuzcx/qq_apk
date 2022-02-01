package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.datasource.DataSink;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.oskplayer.support.util.OskFile;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.File;
import java.io.IOException;

public class FileDataSink
  extends CacheDataSink
{
  public static final String DEFAULT_SINK_DIR = "oskfile";
  public static final String LOG_TAG = "FileDataSink";
  public static final String TEMP_FILE = ".temp";
  private File dstFile = null;
  private String extensionName = "";
  private File sinkDir = null;
  
  public FileDataSink(String paramString, File paramFile)
  {
    super(null, 9223372036854775807L);
    this.sinkDir = paramFile;
    this.extensionName = PlayerUtils.guessExtension(paramString);
  }
  
  public static String getLocalFile(String paramString, File paramFile)
  {
    if (paramFile == null) {
      paramFile = OskFile.ensureFilesDir("oskfile");
    } else {
      paramFile = paramFile.getAbsolutePath();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(PlayerUtils.parseVideoKey(paramString));
    localStringBuilder.append(".");
    localStringBuilder.append(PlayerUtils.guessExtension(paramString));
    paramString = new File(localStringBuilder.toString());
    if ((paramString.exists()) && (paramString.isFile())) {
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  protected void commitFile()
  {
    if (!this.file.exists())
    {
      this.dstFile = null;
      return;
    }
    if (this.dstFile.exists()) {
      this.dstFile.delete();
    }
    long l = this.file.length();
    if (this.totalLength > 0L)
    {
      if (this.totalLength == this.file.length())
      {
        if (this.file.renameTo(this.dstFile)) {
          return;
        }
        this.dstFile = null;
        localILogger = Logger.g();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("failed rename file ");
        localStringBuilder.append(this.file);
        localILogger.e("FileDataSink", localStringBuilder.toString());
        throw new IOException("rename failed");
      }
      this.file.delete();
      this.dstFile = null;
      localILogger = Logger.g();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("commitFile failed totalLength=");
      localStringBuilder.append(this.totalLength);
      localStringBuilder.append(",current total=");
      localStringBuilder.append(this.file.length());
      localILogger.w("FileDataSink", localStringBuilder.toString());
      throw new IOException("length not match");
    }
    if (l != 0L) {
      return;
    }
    this.file.delete();
    this.dstFile = null;
    ILogger localILogger = Logger.g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commitFile failed file_length=");
    localStringBuilder.append(this.file.length());
    localILogger.w("FileDataSink", localStringBuilder.toString());
    throw new IOException("length is zero");
  }
  
  public long getBytesTotal()
  {
    return this.totalLength;
  }
  
  public long getBytesWritten()
  {
    return this.outputStreamBytesWritten;
  }
  
  public File getFile()
  {
    if ((this.dstFile.isFile()) && (this.dstFile.exists()) && (this.dstFile.length() > 0L)) {
      return this.dstFile;
    }
    return null;
  }
  
  public DataSink open(DataSpec paramDataSpec, long paramLong, FileType paramFileType)
  {
    this.totalLength = paramLong;
    this.fileType = paramFileType;
    try
    {
      this.dataSpec = paramDataSpec;
      this.dataSpecBytesWritten = 0L;
      openNextOutputStream();
      return this;
    }
    catch (IOException paramDataSpec)
    {
      throw new CacheDataSink.CacheDataSinkException(paramDataSpec);
    }
  }
  
  protected void startFile()
  {
    Object localObject1 = this.sinkDir;
    if (localObject1 == null) {
      localObject1 = OskFile.ensureFilesDir("oskfile");
    } else {
      localObject1 = ((File)localObject1).getAbsolutePath();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.dataSpec.key);
    ((StringBuilder)localObject2).append(".temp");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject2);
    this.file = new File(localStringBuilder.toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(this.dataSpec.key);
    ((StringBuilder)localObject2).append(".");
    ((StringBuilder)localObject2).append(this.extensionName);
    this.dstFile = new File(((StringBuilder)localObject2).toString());
    if ((this.file.exists()) && (this.file.isFile())) {
      this.file.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.cache.FileDataSink
 * JD-Core Version:    0.7.0.1
 */