package com.tencent.plato.mqq.network;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import okio.ByteString;

public class RequestBodyUtil
{
  private static final String NAME = "RequestBodyUtil";
  private static final String TAG = "RequestBodyUtil";
  private static final String TEMP_FILE_SUFFIX = "temp";
  
  public static RequestBody create(MediaType paramMediaType, InputStream paramInputStream)
  {
    return new RequestBodyUtil.InputStreamRequestBody(paramMediaType, paramInputStream);
  }
  
  @Nullable
  public static RequestBody createGzip(MediaType paramMediaType, String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes());
      localGZIPOutputStream.close();
      return RequestBody.create(paramMediaType, localByteArrayOutputStream.toByteArray());
    }
    catch (IOException paramMediaType) {}
    return null;
  }
  
  public static ProgressRequestBody createProgressRequest(RequestBody paramRequestBody, ProgressListener paramProgressListener)
  {
    return new ProgressRequestBody(paramRequestBody, paramProgressListener);
  }
  
  /* Error */
  private static InputStream getDownloadFileInputStream(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 8
    //   2: ldc 12
    //   4: aload_0
    //   5: invokevirtual 76	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   8: invokevirtual 80	android/content/Context:getCacheDir	()Ljava/io/File;
    //   11: invokestatic 86	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 89	java/io/File:deleteOnExit	()V
    //   19: new 91	java/net/URL
    //   22: dup
    //   23: aload_1
    //   24: invokevirtual 97	android/net/Uri:toString	()Ljava/lang/String;
    //   27: invokespecial 100	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 104	java/net/URL:openStream	()Ljava/io/InputStream;
    //   33: astore_0
    //   34: aload_0
    //   35: invokestatic 110	java/nio/channels/Channels:newChannel	(Ljava/io/InputStream;)Ljava/nio/channels/ReadableByteChannel;
    //   38: astore_1
    //   39: new 112	java/io/FileOutputStream
    //   42: dup
    //   43: aload_3
    //   44: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 119	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   52: aload_1
    //   53: lconst_0
    //   54: ldc2_w 120
    //   57: invokevirtual 127	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   60: pop2
    //   61: new 129	java/io/FileInputStream
    //   64: dup
    //   65: aload_3
    //   66: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore_3
    //   70: aload_2
    //   71: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   74: aload_1
    //   75: invokeinterface 134 1 0
    //   80: aload_0
    //   81: invokevirtual 137	java/io/InputStream:close	()V
    //   84: aload_3
    //   85: areturn
    //   86: astore_3
    //   87: aload_2
    //   88: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   91: aload_3
    //   92: athrow
    //   93: astore_2
    //   94: aload_1
    //   95: invokeinterface 134 1 0
    //   100: aload_2
    //   101: athrow
    //   102: astore_1
    //   103: aload_0
    //   104: invokevirtual 137	java/io/InputStream:close	()V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramContext	Context
    //   0	109	1	paramUri	Uri
    //   47	41	2	localFileOutputStream	java.io.FileOutputStream
    //   93	8	2	localObject1	Object
    //   14	71	3	localObject2	Object
    //   86	6	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   48	70	86	finally
    //   39	48	93	finally
    //   70	74	93	finally
    //   87	93	93	finally
    //   34	39	102	finally
    //   74	80	102	finally
    //   94	102	102	finally
  }
  
  public static RequestBody getEmptyBody(String paramString)
  {
    RequestBody localRequestBody = null;
    if (("POST".equals(paramString)) || ("PUT".equals(paramString)) || ("PATCH".equals(paramString))) {
      localRequestBody = RequestBody.create(null, ByteString.EMPTY);
    }
    return localRequestBody;
  }
  
  @Nullable
  public static InputStream getFileInputStream(Context paramContext, String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri.getScheme().startsWith("http")) {
        return getDownloadFileInputStream(paramContext, localUri);
      }
      paramContext = paramContext.getContentResolver().openInputStream(localUri);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.e("RequestBodyUtil", 2, "Could not retrieve file for contentUri " + paramString, paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.mqq.network.RequestBodyUtil
 * JD-Core Version:    0.7.0.1
 */