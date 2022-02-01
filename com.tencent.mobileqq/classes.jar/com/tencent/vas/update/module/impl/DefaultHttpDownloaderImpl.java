package com.tencent.vas.update.module.impl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.DownloadInfoParams;
import com.tencent.vas.update.module.thread.ThreadManager;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public class DefaultHttpDownloaderImpl
  implements IHttpDownloader
{
  private static final String TAG = "VasUpdate_HttpDownload";
  private OkHttpClient mOkHttpClient = new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
  
  /* Error */
  private void writeFile(DownloadInfoParams paramDownloadInfoParams, IDownloadListener paramIDownloadListener, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 65	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   4: invokevirtual 71	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   7: astore 12
    //   9: new 73	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: getfield 78	com/tencent/vas/update/entity/DownloadInfoParams:mSavePath	Ljava/lang/String;
    //   17: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 13
    //   22: aconst_null
    //   23: astore 11
    //   25: aconst_null
    //   26: astore 10
    //   28: aload 10
    //   30: astore 9
    //   32: aload 13
    //   34: invokevirtual 85	java/io/File:exists	()Z
    //   37: ifne +13 -> 50
    //   40: aload 10
    //   42: astore 9
    //   44: aload 13
    //   46: invokevirtual 88	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aload 10
    //   52: astore 9
    //   54: new 90	java/io/FileOutputStream
    //   57: dup
    //   58: aload 13
    //   60: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: astore 10
    //   65: sipush 1024
    //   68: newarray byte
    //   70: astore 9
    //   72: aload_3
    //   73: invokevirtual 65	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   76: invokevirtual 97	okhttp3/ResponseBody:contentLength	()J
    //   79: lstore 7
    //   81: lconst_0
    //   82: lstore 5
    //   84: aload 12
    //   86: aload 9
    //   88: invokevirtual 103	java/io/InputStream:read	([B)I
    //   91: istore 4
    //   93: iload 4
    //   95: iconst_m1
    //   96: if_icmpeq +59 -> 155
    //   99: aload 10
    //   101: aload 9
    //   103: iconst_0
    //   104: iload 4
    //   106: invokevirtual 107	java/io/FileOutputStream:write	([BII)V
    //   109: lload 5
    //   111: iload 4
    //   113: i2l
    //   114: ladd
    //   115: lstore 5
    //   117: lload 5
    //   119: l2f
    //   120: fconst_1
    //   121: fmul
    //   122: lload 7
    //   124: l2f
    //   125: fdiv
    //   126: ldc 108
    //   128: fmul
    //   129: f2i
    //   130: istore 4
    //   132: aload_2
    //   133: ifnull +183 -> 316
    //   136: aload_2
    //   137: aload_1
    //   138: getfield 111	com/tencent/vas/update/entity/DownloadInfoParams:mItemId	Ljava/lang/String;
    //   141: lload 5
    //   143: lload 7
    //   145: iload 4
    //   147: invokeinterface 117 7 0
    //   152: goto +164 -> 316
    //   155: aload_2
    //   156: aload_1
    //   157: getfield 111	com/tencent/vas/update/entity/DownloadInfoParams:mItemId	Ljava/lang/String;
    //   160: iconst_0
    //   161: aload_3
    //   162: invokevirtual 121	okhttp3/Response:code	()I
    //   165: ldc 123
    //   167: invokeinterface 127 5 0
    //   172: aload 12
    //   174: ifnull +8 -> 182
    //   177: aload 12
    //   179: invokevirtual 130	java/io/InputStream:close	()V
    //   182: aload 10
    //   184: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   187: return
    //   188: astore_1
    //   189: aload 10
    //   191: astore 9
    //   193: goto +85 -> 278
    //   196: astore 11
    //   198: goto +17 -> 215
    //   201: astore_1
    //   202: goto +76 -> 278
    //   205: astore 9
    //   207: aload 11
    //   209: astore 10
    //   211: aload 9
    //   213: astore 11
    //   215: aload 10
    //   217: astore 9
    //   219: aload 11
    //   221: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   224: aload 10
    //   226: astore 9
    //   228: aload_2
    //   229: aload_1
    //   230: getfield 111	com/tencent/vas/update/entity/DownloadInfoParams:mItemId	Ljava/lang/String;
    //   233: bipush 23
    //   235: aload_3
    //   236: invokevirtual 121	okhttp3/Response:code	()I
    //   239: aload 11
    //   241: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   244: invokeinterface 127 5 0
    //   249: aload 12
    //   251: ifnull +11 -> 262
    //   254: aload 12
    //   256: invokevirtual 130	java/io/InputStream:close	()V
    //   259: goto +3 -> 262
    //   262: aload 10
    //   264: ifnull +13 -> 277
    //   267: aload 10
    //   269: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   272: return
    //   273: aload_1
    //   274: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   277: return
    //   278: aload 12
    //   280: ifnull +11 -> 291
    //   283: aload 12
    //   285: invokevirtual 130	java/io/InputStream:close	()V
    //   288: goto +3 -> 291
    //   291: aload 9
    //   293: ifnull +15 -> 308
    //   296: aload 9
    //   298: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   301: goto +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   308: goto +5 -> 313
    //   311: aload_1
    //   312: athrow
    //   313: goto -2 -> 311
    //   316: goto -232 -> 84
    //   319: astore_1
    //   320: goto -47 -> 273
    //   323: astore_2
    //   324: goto -20 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	DefaultHttpDownloaderImpl
    //   0	327	1	paramDownloadInfoParams	DownloadInfoParams
    //   0	327	2	paramIDownloadListener	IDownloadListener
    //   0	327	3	paramResponse	okhttp3.Response
    //   91	55	4	i	int
    //   82	60	5	l1	long
    //   79	65	7	l2	long
    //   30	162	9	localObject1	Object
    //   205	7	9	localException1	java.lang.Exception
    //   217	80	9	localObject2	Object
    //   26	242	10	localObject3	Object
    //   23	1	11	localObject4	Object
    //   196	12	11	localException2	java.lang.Exception
    //   213	27	11	localObject5	Object
    //   7	277	12	localInputStream	java.io.InputStream
    //   20	39	13	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   65	81	188	finally
    //   84	93	188	finally
    //   99	109	188	finally
    //   117	132	188	finally
    //   136	152	188	finally
    //   155	172	188	finally
    //   65	81	196	java/lang/Exception
    //   84	93	196	java/lang/Exception
    //   99	109	196	java/lang/Exception
    //   117	132	196	java/lang/Exception
    //   136	152	196	java/lang/Exception
    //   155	172	196	java/lang/Exception
    //   32	40	201	finally
    //   44	50	201	finally
    //   54	65	201	finally
    //   219	224	201	finally
    //   228	249	201	finally
    //   32	40	205	java/lang/Exception
    //   44	50	205	java/lang/Exception
    //   54	65	205	java/lang/Exception
    //   177	182	319	java/io/IOException
    //   182	187	319	java/io/IOException
    //   254	259	319	java/io/IOException
    //   267	272	319	java/io/IOException
    //   283	288	323	java/io/IOException
    //   296	301	323	java/io/IOException
  }
  
  public void cancelDownload(String paramString) {}
  
  public void startDownload(@NonNull DownloadInfoParams paramDownloadInfoParams, @NonNull IDownloadListener paramIDownloadListener, Bundle paramBundle)
  {
    ThreadManager.getInstance().post(new DefaultHttpDownloaderImpl.1(this, paramDownloadInfoParams, paramIDownloadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DefaultHttpDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */