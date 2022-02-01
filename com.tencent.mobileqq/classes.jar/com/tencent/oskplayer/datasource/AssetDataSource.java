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
    String str = MimeTypeMap.getFileExtensionFromUrl(this.path);
    if (str != null) {
      return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }
    return null;
  }
  
  /* Error */
  private void initAssetSize()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 39
    //   4: putfield 42	com/tencent/oskplayer/datasource/AssetDataSource:assetSize	J
    //   7: aconst_null
    //   8: astore_1
    //   9: aconst_null
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 56	com/tencent/oskplayer/datasource/AssetDataSource:assetManager	Landroid/content/res/AssetManager;
    //   15: aload_0
    //   16: getfield 62	com/tencent/oskplayer/datasource/AssetDataSource:path	Ljava/lang/String;
    //   19: invokevirtual 84	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_2
    //   25: aload_3
    //   26: astore_1
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 90	android/content/res/AssetFileDescriptor:getLength	()J
    //   32: putfield 42	com/tencent/oskplayer/datasource/AssetDataSource:assetSize	J
    //   35: aload_3
    //   36: ifnull +33 -> 69
    //   39: aload_3
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 93	android/content/res/AssetFileDescriptor:close	()V
    //   45: goto +24 -> 69
    //   48: goto +21 -> 69
    //   51: astore_1
    //   52: goto +36 -> 88
    //   55: astore_3
    //   56: aload_1
    //   57: astore_2
    //   58: aload_3
    //   59: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   62: aload_1
    //   63: ifnull +6 -> 69
    //   66: goto -25 -> 41
    //   69: aload_0
    //   70: getfield 42	com/tencent/oskplayer/datasource/AssetDataSource:assetSize	J
    //   73: ldc2_w 39
    //   76: lcmp
    //   77: ifne +10 -> 87
    //   80: aload_0
    //   81: ldc2_w 39
    //   84: putfield 42	com/tencent/oskplayer/datasource/AssetDataSource:assetSize	J
    //   87: return
    //   88: aload_2
    //   89: ifnull +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 93	android/content/res/AssetFileDescriptor:close	()V
    //   96: goto +5 -> 101
    //   99: aload_1
    //   100: athrow
    //   101: goto -2 -> 99
    //   104: astore_1
    //   105: goto -57 -> 48
    //   108: astore_2
    //   109: goto -13 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	AssetDataSource
    //   8	34	1	localObject1	Object
    //   51	49	1	localObject2	Object
    //   104	1	1	localIOException1	IOException
    //   10	83	2	localObject3	Object
    //   108	1	2	localIOException2	IOException
    //   22	18	3	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   55	4	3	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   11	23	51	finally
    //   27	35	51	finally
    //   58	62	51	finally
    //   11	23	55	java/io/IOException
    //   27	35	55	java/io/IOException
    //   41	45	104	java/io/IOException
    //   92	96	108	java/io/IOException
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
    //   2: putfield 99	com/tencent/oskplayer/datasource/AssetDataSource:uri	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 101	com/tencent/oskplayer/datasource/AssetDataSource:inputStream	Ljava/io/InputStream;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 101	com/tencent/oskplayer/datasource/AssetDataSource:inputStream	Ljava/io/InputStream;
    //   16: invokevirtual 104	java/io/InputStream:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 101	com/tencent/oskplayer/datasource/AssetDataSource:inputStream	Ljava/io/InputStream;
    //   24: aload_0
    //   25: getfield 106	com/tencent/oskplayer/datasource/AssetDataSource:opened	Z
    //   28: ifeq +23 -> 51
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 106	com/tencent/oskplayer/datasource/AssetDataSource:opened	Z
    //   36: aload_0
    //   37: getfield 58	com/tencent/oskplayer/datasource/AssetDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +9 -> 51
    //   45: aload_1
    //   46: invokeinterface 111 1 0
    //   51: return
    //   52: astore_1
    //   53: goto +13 -> 66
    //   56: astore_1
    //   57: new 113	com/tencent/oskplayer/datasource/AssetDataSource$AssetDataSourceException
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 116	com/tencent/oskplayer/datasource/AssetDataSource$AssetDataSourceException:<init>	(Ljava/io/IOException;)V
    //   65: athrow
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 101	com/tencent/oskplayer/datasource/AssetDataSource:inputStream	Ljava/io/InputStream;
    //   71: aload_0
    //   72: getfield 106	com/tencent/oskplayer/datasource/AssetDataSource:opened	Z
    //   75: ifeq +23 -> 98
    //   78: aload_0
    //   79: iconst_0
    //   80: putfield 106	com/tencent/oskplayer/datasource/AssetDataSource:opened	Z
    //   83: aload_0
    //   84: getfield 58	com/tencent/oskplayer/datasource/AssetDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   87: astore_2
    //   88: aload_2
    //   89: ifnull +9 -> 98
    //   92: aload_2
    //   93: invokeinterface 111 1 0
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	AssetDataSource
    //   40	6	1	localTransferListener1	TransferListener
    //   52	1	1	localObject	Object
    //   56	43	1	localIOException	IOException
    //   87	6	2	localTransferListener2	TransferListener
    // Exception table:
    //   from	to	target	type
    //   5	19	52	finally
    //   57	66	52	finally
    //   5	19	56	java/io/IOException
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.extraLogTag);
    localStringBuilder.append("AssetDataSource");
    return localStringBuilder.toString();
  }
  
  public long getTotalLength()
  {
    return this.assetSize;
  }
  
  public String getUri()
  {
    Uri localUri = this.uri;
    if (localUri != null) {
      return localUri.toString();
    }
    return null;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    try
    {
      this.uri = paramDataSpec.uri;
      this.path = this.uri.getPath();
      if (this.path.startsWith("/android_asset/")) {
        this.path = this.path.substring(15);
      } else if (this.path.startsWith("/")) {
        this.path = this.path.substring(1);
      }
      this.inputStream = this.assetManager.open(this.path, 1);
      initAssetSize();
      this.bytesAvailable = (this.assetSize - paramDataSpec.position);
      if (this.inputStream.skip(paramDataSpec.position) >= paramDataSpec.position)
      {
        if (paramDataSpec.length != -1L)
        {
          this.bytesRemaining = paramDataSpec.length;
        }
        else
        {
          this.bytesRemaining = this.inputStream.available();
          if (this.bytesRemaining == 2147483647L) {
            this.bytesRemaining = -1L;
          }
        }
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
      throw new AssetDataSource.AssetDataSourceException(paramDataSpec);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l1 = this.bytesRemaining;
    if (l1 == 0L) {
      return -1;
    }
    long l2;
    if (l1 != -1L) {
      l2 = paramInt2;
    }
    try
    {
      paramInt2 = (int)Math.min(l1, l2);
      paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        if (this.bytesRemaining == -1L) {
          return -1;
        }
        throw new AssetDataSource.AssetDataSourceException(new EOFException());
      }
      l1 = this.bytesRemaining;
      if (l1 != -1L) {
        this.bytesRemaining = (l1 - paramInt1);
      }
      paramArrayOfByte = this.listener;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.onBytesTransferred(paramInt1);
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new AssetDataSource.AssetDataSourceException(paramArrayOfByte);
    }
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.AssetDataSource
 * JD-Core Version:    0.7.0.1
 */