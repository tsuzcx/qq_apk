package com.tencent.oskplayer.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.oskplayer.proxy.FileType;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class AssetDataSource
  implements UriDataSource
{
  public static final String ASSET_SCHEME = "android_asset";
  public static final String TAG = "AssetDataSource";
  private final AssetManager assetManager;
  private long assetSize = -1L;
  private long bytesAvailable = -1L;
  private long bytesRemaining;
  private String extraLogTag = "";
  private InputStream inputStream;
  private final TransferListener listener;
  private boolean opened;
  private String path;
  private Uri uri;
  
  public AssetDataSource(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AssetDataSource(Context paramContext, TransferListener paramTransferListener)
  {
    this.assetManager = paramContext.getAssets();
    this.listener = paramTransferListener;
  }
  
  private String getMime()
  {
    String str1 = null;
    String str2 = MimeTypeMap.getFileExtensionFromUrl(this.path);
    if (str2 != null) {
      str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
    }
    return str1;
  }
  
  /* Error */
  private void initAssetSize()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 39
    //   4: putfield 42	com/tencent/oskplayer/datasource/AssetDataSource:assetSize	J
    //   7: aconst_null
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 56	com/tencent/oskplayer/datasource/AssetDataSource:assetManager	Landroid/content/res/AssetManager;
    //   15: aload_0
    //   16: getfield 62	com/tencent/oskplayer/datasource/AssetDataSource:path	Ljava/lang/String;
    //   19: invokevirtual 84	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_1
    //   25: aload_3
    //   26: astore_2
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 90	android/content/res/AssetFileDescriptor:getLength	()J
    //   32: putfield 42	com/tencent/oskplayer/datasource/AssetDataSource:assetSize	J
    //   35: aload_3
    //   36: ifnull +7 -> 43
    //   39: aload_3
    //   40: invokevirtual 93	android/content/res/AssetFileDescriptor:close	()V
    //   43: aload_0
    //   44: getfield 42	com/tencent/oskplayer/datasource/AssetDataSource:assetSize	J
    //   47: ldc2_w 39
    //   50: lcmp
    //   51: ifne +10 -> 61
    //   54: aload_0
    //   55: ldc2_w 39
    //   58: putfield 42	com/tencent/oskplayer/datasource/AssetDataSource:assetSize	J
    //   61: return
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   69: aload_1
    //   70: ifnull -27 -> 43
    //   73: aload_1
    //   74: invokevirtual 93	android/content/res/AssetFileDescriptor:close	()V
    //   77: goto -34 -> 43
    //   80: astore_1
    //   81: goto -38 -> 43
    //   84: astore_1
    //   85: aload_2
    //   86: ifnull +7 -> 93
    //   89: aload_2
    //   90: invokevirtual 93	android/content/res/AssetFileDescriptor:close	()V
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: goto -53 -> 43
    //   99: astore_2
    //   100: goto -7 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	AssetDataSource
    //   10	64	1	localObject1	Object
    //   80	1	1	localIOException1	IOException
    //   84	10	1	localObject2	Object
    //   95	1	1	localIOException2	IOException
    //   8	82	2	localObject3	Object
    //   99	1	2	localIOException3	IOException
    //   22	18	3	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   62	4	3	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   11	23	62	java/io/IOException
    //   27	35	62	java/io/IOException
    //   73	77	80	java/io/IOException
    //   11	23	84	finally
    //   27	35	84	finally
    //   65	69	84	finally
    //   39	43	95	java/io/IOException
    //   89	93	99	java/io/IOException
  }
  
  public long available()
  {
    return this.bytesAvailable;
  }
  
  public void close()
  {
    this.uri = null;
    try
    {
      if (this.inputStream != null) {
        this.inputStream.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      throw new AssetDataSource.AssetDataSourceException(localIOException);
    }
    finally
    {
      this.inputStream = null;
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
    String str = getMime();
    if (TextUtils.isEmpty(str)) {
      return FileType.OCTET_STREAM;
    }
    return FileType.getFileType(str);
  }
  
  public String getLogTag()
  {
    return this.extraLogTag + "AssetDataSource";
  }
  
  public long getTotalLength()
  {
    return this.assetSize;
  }
  
  public String getUri()
  {
    if (this.uri != null) {
      return this.uri.toString();
    }
    return null;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    for (;;)
    {
      try
      {
        this.uri = paramDataSpec.uri;
        this.path = this.uri.getPath();
        if (this.path.startsWith("/android_asset/"))
        {
          this.path = this.path.substring(15);
          this.inputStream = this.assetManager.open(this.path, 1);
          initAssetSize();
          this.bytesAvailable = (this.assetSize - paramDataSpec.position);
          if (this.inputStream.skip(paramDataSpec.position) >= paramDataSpec.position) {
            break;
          }
          throw new EOFException();
        }
      }
      catch (IOException paramDataSpec)
      {
        throw new AssetDataSource.AssetDataSourceException(paramDataSpec);
      }
      if (this.path.startsWith("/")) {
        this.path = this.path.substring(1);
      }
    }
    if (paramDataSpec.length != -1L) {
      this.bytesRemaining = paramDataSpec.length;
    }
    for (;;)
    {
      this.opened = true;
      if (this.listener != null) {
        this.listener.onTransferStart();
      }
      return this.bytesRemaining;
      this.bytesRemaining = this.inputStream.available();
      if (this.bytesRemaining == 2147483647L) {
        this.bytesRemaining = -1L;
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = -1;
    int i;
    if (paramInt2 == 0) {
      i = 0;
    }
    for (;;)
    {
      return i;
      i = j;
      if (this.bytesRemaining != 0L) {
        try
        {
          if (this.bytesRemaining == -1L) {}
          for (;;)
          {
            paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
            if (paramInt1 != -1) {
              break label111;
            }
            i = j;
            if (this.bytesRemaining == -1L) {
              break;
            }
            throw new AssetDataSource.AssetDataSourceException(new EOFException());
            long l = Math.min(this.bytesRemaining, paramInt2);
            paramInt2 = (int)l;
          }
          if (this.bytesRemaining == -1L) {
            break label133;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          throw new AssetDataSource.AssetDataSourceException(paramArrayOfByte);
        }
      }
    }
    label111:
    this.bytesRemaining -= paramInt1;
    label133:
    if (this.listener != null) {
      this.listener.onBytesTransferred(paramInt1);
    }
    return paramInt1;
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.AssetDataSource
 * JD-Core Version:    0.7.0.1
 */