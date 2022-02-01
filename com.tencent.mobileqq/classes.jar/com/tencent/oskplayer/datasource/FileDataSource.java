package com.tencent.oskplayer.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.proxy.FileType;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDataSource
  implements UriDataSource
{
  public static final String TAG = "FileDataSource";
  private long bytesAvailable = -1L;
  private long bytesRemaining;
  private String extraLogTag = "";
  private RandomAccessFile file;
  private final TransferListener listener;
  private boolean opened;
  private Uri uri;
  private String uriString;
  
  public FileDataSource()
  {
    this(null);
  }
  
  public FileDataSource(TransferListener paramTransferListener)
  {
    this.listener = paramTransferListener;
  }
  
  public long available()
  {
    return this.bytesAvailable;
  }
  
  public void close()
  {
    this.uriString = null;
    if (this.file != null) {}
    try
    {
      this.file.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new FileDataSource.FileDataSourceException(localIOException);
    }
    finally
    {
      this.file = null;
      if (this.opened)
      {
        this.opened = false;
        if (this.listener != null) {
          this.listener.onTransferEnd();
        }
      }
    }
  }
  
  public FileType getFileType()
  {
    String str = PlayerConfig.g().getAppContext().getContentResolver().getType(this.uri);
    if (str == null) {
      return FileType.VIDEO_MP4;
    }
    return FileType.getFileType(str);
  }
  
  public String getLogTag()
  {
    return this.extraLogTag + "FileDataSource";
  }
  
  public long getTotalLength()
  {
    try
    {
      long l = this.file.length();
      return l;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return 0L;
  }
  
  public String getUri()
  {
    if ((TextUtils.isEmpty(this.uriString)) && (this.uri != null)) {
      this.uriString = this.uri.toString();
    }
    return this.uriString;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    for (;;)
    {
      try
      {
        this.uri = paramDataSpec.uri;
        this.file = new RandomAccessFile(paramDataSpec.uri.getPath(), "r");
        this.file.seek(paramDataSpec.position);
        if (paramDataSpec.length == -1L)
        {
          l = this.file.length() - paramDataSpec.position;
          this.bytesRemaining = l;
          this.bytesAvailable = (this.file.length() - paramDataSpec.position);
          if (this.bytesRemaining >= 0L) {
            break;
          }
          throw new EOFException();
        }
      }
      catch (IOException paramDataSpec)
      {
        throw new FileDataSource.FileDataSourceException(paramDataSpec);
      }
      long l = paramDataSpec.length;
    }
    this.opened = true;
    if (this.listener != null) {
      this.listener.onTransferStart();
    }
    return this.bytesRemaining;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.bytesRemaining == 0L) {
      paramInt1 = -1;
    }
    for (;;)
    {
      return paramInt1;
      try
      {
        paramInt2 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.bytesRemaining, paramInt2));
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          continue;
        }
        this.bytesRemaining -= paramInt2;
        paramInt1 = paramInt2;
        if (this.listener == null) {
          continue;
        }
        this.listener.onBytesTransferred(paramInt2);
        return paramInt2;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new FileDataSource.FileDataSourceException(paramArrayOfByte);
      }
    }
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.FileDataSource
 * JD-Core Version:    0.7.0.1
 */