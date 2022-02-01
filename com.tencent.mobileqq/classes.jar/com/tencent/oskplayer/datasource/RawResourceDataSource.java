package com.tencent.oskplayer.datasource;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.oskplayer.proxy.FileType;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class RawResourceDataSource
  implements UriDataSource
{
  public static final String RAW_RESOURCE_SCHEME = "android.resource";
  public static final String TAG = "RawResourceDataSource";
  private AssetFileDescriptor assetFileDescriptor;
  private long assetSize = -1L;
  private long bytesAvailable = -1L;
  private long bytesRemaining;
  private String extraLogTag = "";
  private InputStream inputStream;
  private final TransferListener listener;
  private String mimeType = null;
  private boolean opened;
  private final Resources resources;
  private Uri uri;
  
  public RawResourceDataSource(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RawResourceDataSource(Context paramContext, TransferListener paramTransferListener)
  {
    this.resources = paramContext.getResources();
    this.listener = paramTransferListener;
  }
  
  public static Uri buildRawResourceUri(Context paramContext, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android.resource:///");
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt);
    return Uri.parse(localStringBuilder.toString());
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
    //   2: putfield 98	com/tencent/oskplayer/datasource/RawResourceDataSource:uri	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 100	com/tencent/oskplayer/datasource/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 100	com/tencent/oskplayer/datasource/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   16: invokevirtual 104	java/io/InputStream:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 100	com/tencent/oskplayer/datasource/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   24: aload_0
    //   25: getfield 106	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   28: ifnull +10 -> 38
    //   31: aload_0
    //   32: getfield 106	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   35: invokevirtual 109	android/content/res/AssetFileDescriptor:close	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 106	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   43: aload_0
    //   44: getfield 111	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   47: ifeq +23 -> 70
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 111	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   55: aload_0
    //   56: getfield 62	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +9 -> 70
    //   64: aload_1
    //   65: invokeinterface 116 1 0
    //   70: return
    //   71: astore_1
    //   72: goto +13 -> 85
    //   75: astore_1
    //   76: new 118	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 121	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   84: athrow
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 106	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   90: aload_0
    //   91: getfield 111	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   94: ifeq +23 -> 117
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 111	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   102: aload_0
    //   103: getfield 62	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull +9 -> 117
    //   111: aload_2
    //   112: invokeinterface 116 1 0
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: goto +13 -> 133
    //   123: astore_1
    //   124: new 118	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException
    //   127: dup
    //   128: aload_1
    //   129: invokespecial 121	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   132: athrow
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 100	com/tencent/oskplayer/datasource/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   138: aload_0
    //   139: getfield 106	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   142: ifnull +10 -> 152
    //   145: aload_0
    //   146: getfield 106	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   149: invokevirtual 109	android/content/res/AssetFileDescriptor:close	()V
    //   152: aload_0
    //   153: aconst_null
    //   154: putfield 106	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   157: aload_0
    //   158: getfield 111	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   161: ifeq +23 -> 184
    //   164: aload_0
    //   165: iconst_0
    //   166: putfield 111	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   169: aload_0
    //   170: getfield 62	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   173: astore_2
    //   174: aload_2
    //   175: ifnull +9 -> 184
    //   178: aload_2
    //   179: invokeinterface 116 1 0
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: goto +13 -> 200
    //   190: astore_1
    //   191: new 118	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException
    //   194: dup
    //   195: aload_1
    //   196: invokespecial 121	com/tencent/oskplayer/datasource/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   199: athrow
    //   200: aload_0
    //   201: aconst_null
    //   202: putfield 106	com/tencent/oskplayer/datasource/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   205: aload_0
    //   206: getfield 111	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   209: ifeq +23 -> 232
    //   212: aload_0
    //   213: iconst_0
    //   214: putfield 111	com/tencent/oskplayer/datasource/RawResourceDataSource:opened	Z
    //   217: aload_0
    //   218: getfield 62	com/tencent/oskplayer/datasource/RawResourceDataSource:listener	Lcom/tencent/oskplayer/datasource/TransferListener;
    //   221: astore_2
    //   222: aload_2
    //   223: ifnull +9 -> 232
    //   226: aload_2
    //   227: invokeinterface 116 1 0
    //   232: aload_1
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	RawResourceDataSource
    //   59	6	1	localTransferListener1	TransferListener
    //   71	1	1	localObject1	Object
    //   75	43	1	localIOException1	IOException
    //   119	1	1	localObject2	Object
    //   123	62	1	localIOException2	IOException
    //   186	1	1	localObject3	Object
    //   190	43	1	localIOException3	IOException
    //   106	121	2	localTransferListener2	TransferListener
    // Exception table:
    //   from	to	target	type
    //   24	38	71	finally
    //   76	85	71	finally
    //   24	38	75	java/io/IOException
    //   5	19	119	finally
    //   124	133	119	finally
    //   5	19	123	java/io/IOException
    //   138	152	186	finally
    //   191	200	186	finally
    //   138	152	190	java/io/IOException
  }
  
  public FileType getFileType()
  {
    if (TextUtils.isEmpty(this.mimeType)) {
      return FileType.OCTET_STREAM;
    }
    return FileType.getFileType(this.mimeType);
  }
  
  public String getLogTag()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.extraLogTag);
    localStringBuilder.append("RawResourceDataSource");
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
      boolean bool = TextUtils.equals("android.resource", this.uri.getScheme());
      if (!bool) {}
    }
    catch (IOException paramDataSpec)
    {
      int i;
      label245:
      throw new RawResourceDataSource.RawResourceDataSourceException(paramDataSpec);
    }
    try
    {
      i = Integer.parseInt(this.uri.getLastPathSegment());
      this.assetFileDescriptor = this.resources.openRawResourceFd(i);
      this.assetSize = this.assetFileDescriptor.getLength();
      this.bytesAvailable = (this.assetSize - paramDataSpec.position);
      this.inputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
      if (this.inputStream.markSupported()) {
        this.mimeType = URLConnection.guessContentTypeFromStream(this.inputStream);
      }
      this.inputStream.skip(this.assetFileDescriptor.getStartOffset());
      if (this.inputStream.skip(paramDataSpec.position) >= paramDataSpec.position)
      {
        long l2 = paramDataSpec.length;
        long l1 = -1L;
        if (l2 != -1L)
        {
          this.bytesRemaining = paramDataSpec.length;
        }
        else
        {
          l2 = this.assetFileDescriptor.getLength();
          if (l2 != -1L) {
            l1 = l2 - paramDataSpec.position;
          }
          this.bytesRemaining = l1;
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
    catch (NumberFormatException paramDataSpec)
    {
      break label245;
    }
    throw new RawResourceDataSource.RawResourceDataSourceException("Resource identifier must be an integer.");
    throw new RawResourceDataSource.RawResourceDataSourceException("URI must use scheme android.resource");
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
        throw new RawResourceDataSource.RawResourceDataSourceException(new EOFException());
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
      throw new RawResourceDataSource.RawResourceDataSourceException(paramArrayOfByte);
    }
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.RawResourceDataSource
 * JD-Core Version:    0.7.0.1
 */