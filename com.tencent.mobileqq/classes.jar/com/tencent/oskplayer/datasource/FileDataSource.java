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
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 48	com/tencent/oskplayer/datasource/FileDataSource:uriString	Ljava/lang/String;
    //   5: aload_0
    //   6: getfield 50	com/tencent/oskplayer/datasource/FileDataSource:file	Ljava/io/RandomAccessFile;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +88 -> 99
    //   14: aload_1
    //   15: invokevirtual 54	java/io/RandomAccessFile:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 50	com/tencent/oskplayer/datasource/FileDataSource:file	Ljava/io/RandomAccessFile;
    //   23: aload_0
    //   24: getfield 56	com/tencent/oskplayer/datasource/FileDataSource:opened	Z
    //   27: ifeq +72 -> 99
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 56	com/tencent/oskplayer/datasource/FileDataSource:opened	Z
    //   35: aload_0
    //   36: getfield 41	com/tencent/oskplayer/datasource/FileDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +58 -> 99
    //   44: aload_1
    //   45: invokeinterface 61 1 0
    //   50: return
    //   51: astore_1
    //   52: goto +13 -> 65
    //   55: astore_1
    //   56: new 63	com/tencent/oskplayer/datasource/FileDataSource$FileDataSourceException
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 66	com/tencent/oskplayer/datasource/FileDataSource$FileDataSourceException:<init>	(Ljava/io/IOException;)V
    //   64: athrow
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 50	com/tencent/oskplayer/datasource/FileDataSource:file	Ljava/io/RandomAccessFile;
    //   70: aload_0
    //   71: getfield 56	com/tencent/oskplayer/datasource/FileDataSource:opened	Z
    //   74: ifeq +23 -> 97
    //   77: aload_0
    //   78: iconst_0
    //   79: putfield 56	com/tencent/oskplayer/datasource/FileDataSource:opened	Z
    //   82: aload_0
    //   83: getfield 41	com/tencent/oskplayer/datasource/FileDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull +9 -> 97
    //   91: aload_2
    //   92: invokeinterface 61 1 0
    //   97: aload_1
    //   98: athrow
    //   99: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	FileDataSource
    //   9	36	1	localObject1	Object
    //   51	1	1	localObject2	Object
    //   55	43	1	localIOException	IOException
    //   86	6	2	localTransferListener	TransferListener
    // Exception table:
    //   from	to	target	type
    //   14	18	51	finally
    //   56	65	51	finally
    //   14	18	55	java/io/IOException
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.extraLogTag);
    localStringBuilder.append("FileDataSource");
    return localStringBuilder.toString();
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
    if (TextUtils.isEmpty(this.uriString))
    {
      Uri localUri = this.uri;
      if (localUri != null) {
        this.uriString = localUri.toString();
      }
    }
    return this.uriString;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    try
    {
      this.uri = paramDataSpec.uri;
      this.file = new RandomAccessFile(paramDataSpec.uri.getPath(), "r");
      this.file.seek(paramDataSpec.position);
      if (paramDataSpec.length == -1L) {
        l = this.file.length() - paramDataSpec.position;
      } else {
        l = paramDataSpec.length;
      }
      this.bytesRemaining = l;
      this.bytesAvailable = (this.file.length() - paramDataSpec.position);
      long l = this.bytesRemaining;
      if (l >= 0L)
      {
        this.opened = true;
        paramDataSpec = this.listener;
        if (paramDataSpec != null) {
          paramDataSpec.onTransferStart();
        }
        return this.bytesRemaining;
      }
      throw new EOFException();
    }
    catch (IOException paramDataSpec)
    {
      throw new FileDataSource.FileDataSourceException(paramDataSpec);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = this.bytesRemaining;
    if (l == 0L) {
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(l, paramInt2));
      if (paramInt1 > 0)
      {
        this.bytesRemaining -= paramInt1;
        paramArrayOfByte = this.listener;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.onBytesTransferred(paramInt1);
        }
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new FileDataSource.FileDataSourceException(paramArrayOfByte);
    }
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.FileDataSource
 * JD-Core Version:    0.7.0.1
 */