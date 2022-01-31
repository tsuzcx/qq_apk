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
    if (paramFile == null) {}
    for (paramFile = OskFile.ensureFilesDir("oskfile");; paramFile = paramFile.getAbsolutePath())
    {
      paramString = new File(paramFile + File.separator + PlayerUtils.parseVideoKey(paramString) + "." + PlayerUtils.guessExtension(paramString));
      if ((!paramString.exists()) || (!paramString.isFile())) {
        break;
      }
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  protected void commitFile()
  {
    if (!this.file.exists()) {
      this.dstFile = null;
    }
    long l;
    label199:
    do
    {
      do
      {
        return;
        if (this.dstFile.exists()) {
          this.dstFile.delete();
        }
        l = this.file.length();
        if (this.totalLength <= 0L) {
          break label199;
        }
        if (this.totalLength != this.file.length()) {
          break;
        }
      } while (this.file.renameTo(this.dstFile));
      this.dstFile = null;
      Logger.g().e("FileDataSink", "failed rename file " + this.file);
      throw new IOException("rename failed");
      this.file.delete();
      this.dstFile = null;
      Logger.g().w("FileDataSink", "commitFile failed totalLength=" + this.totalLength + ",current total=" + this.file.length());
      throw new IOException("length not match");
    } while (l != 0L);
    this.file.delete();
    this.dstFile = null;
    Logger.g().w("FileDataSink", "commitFile failed file_length=" + this.file.length());
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
    if (this.sinkDir == null) {}
    for (String str1 = OskFile.ensureFilesDir("oskfile");; str1 = this.sinkDir.getAbsolutePath())
    {
      String str2 = this.dataSpec.key + ".temp";
      this.file = new File(str1 + File.separator + str2);
      this.dstFile = new File(str1 + File.separator + this.dataSpec.key + "." + this.extensionName);
      if ((this.file.exists()) && (this.file.isFile())) {
        this.file.delete();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.cache.FileDataSink
 * JD-Core Version:    0.7.0.1
 */