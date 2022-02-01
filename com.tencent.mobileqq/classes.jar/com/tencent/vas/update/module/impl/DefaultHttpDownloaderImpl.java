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
    //   0: aconst_null
    //   1: astore 13
    //   3: aload_3
    //   4: invokevirtual 65	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   7: invokevirtual 71	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   10: astore 14
    //   12: new 73	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: getfield 78	com/tencent/vas/update/entity/DownloadInfoParams:mSavePath	Ljava/lang/String;
    //   20: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore 11
    //   25: aload 11
    //   27: invokevirtual 85	java/io/File:exists	()Z
    //   30: ifne +9 -> 39
    //   33: aload 11
    //   35: invokevirtual 88	java/io/File:createNewFile	()Z
    //   38: pop
    //   39: new 90	java/io/FileOutputStream
    //   42: dup
    //   43: aload 11
    //   45: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore 11
    //   50: sipush 1024
    //   53: newarray byte
    //   55: astore 12
    //   57: aload_3
    //   58: invokevirtual 65	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   61: invokevirtual 97	okhttp3/ResponseBody:contentLength	()J
    //   64: lstore 9
    //   66: lconst_0
    //   67: lstore 5
    //   69: aload 14
    //   71: aload 12
    //   73: invokevirtual 103	java/io/InputStream:read	([B)I
    //   76: istore 4
    //   78: iload 4
    //   80: iconst_m1
    //   81: if_icmpeq +116 -> 197
    //   84: aload 11
    //   86: aload 12
    //   88: iconst_0
    //   89: iload 4
    //   91: invokevirtual 107	java/io/FileOutputStream:write	([BII)V
    //   94: lload 5
    //   96: iload 4
    //   98: i2l
    //   99: ladd
    //   100: lstore 7
    //   102: lload 7
    //   104: l2f
    //   105: fconst_1
    //   106: fmul
    //   107: lload 9
    //   109: l2f
    //   110: fdiv
    //   111: ldc 108
    //   113: fmul
    //   114: f2i
    //   115: istore 4
    //   117: lload 7
    //   119: lstore 5
    //   121: aload_2
    //   122: ifnull -53 -> 69
    //   125: aload_2
    //   126: aload_1
    //   127: getfield 111	com/tencent/vas/update/entity/DownloadInfoParams:mItemId	Ljava/lang/String;
    //   130: lload 7
    //   132: lload 9
    //   134: iload 4
    //   136: invokeinterface 117 7 0
    //   141: lload 7
    //   143: lstore 5
    //   145: goto -76 -> 69
    //   148: astore 12
    //   150: aload 12
    //   152: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   155: aload_2
    //   156: aload_1
    //   157: getfield 111	com/tencent/vas/update/entity/DownloadInfoParams:mItemId	Ljava/lang/String;
    //   160: bipush 23
    //   162: aload_3
    //   163: invokevirtual 124	okhttp3/Response:code	()I
    //   166: aload 12
    //   168: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   171: invokeinterface 132 5 0
    //   176: aload 14
    //   178: ifnull +8 -> 186
    //   181: aload 14
    //   183: invokevirtual 135	java/io/InputStream:close	()V
    //   186: aload 11
    //   188: ifnull +8 -> 196
    //   191: aload 11
    //   193: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   196: return
    //   197: aload_2
    //   198: aload_1
    //   199: getfield 111	com/tencent/vas/update/entity/DownloadInfoParams:mItemId	Ljava/lang/String;
    //   202: iconst_0
    //   203: aload_3
    //   204: invokevirtual 124	okhttp3/Response:code	()I
    //   207: ldc 138
    //   209: invokeinterface 132 5 0
    //   214: aload 14
    //   216: ifnull +8 -> 224
    //   219: aload 14
    //   221: invokevirtual 135	java/io/InputStream:close	()V
    //   224: aload 11
    //   226: ifnull -30 -> 196
    //   229: aload 11
    //   231: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   234: return
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   240: return
    //   241: astore_1
    //   242: aload_1
    //   243: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   246: return
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_2
    //   250: aload 14
    //   252: ifnull +8 -> 260
    //   255: aload 14
    //   257: invokevirtual 135	java/io/InputStream:close	()V
    //   260: aload_2
    //   261: ifnull +7 -> 268
    //   264: aload_2
    //   265: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   268: aload_1
    //   269: athrow
    //   270: astore_2
    //   271: aload_2
    //   272: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   275: goto -7 -> 268
    //   278: astore_1
    //   279: aload 11
    //   281: astore_2
    //   282: goto -32 -> 250
    //   285: astore_1
    //   286: aload 11
    //   288: astore_2
    //   289: goto -39 -> 250
    //   292: astore 12
    //   294: aload 13
    //   296: astore 11
    //   298: goto -148 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	DefaultHttpDownloaderImpl
    //   0	301	1	paramDownloadInfoParams	DownloadInfoParams
    //   0	301	2	paramIDownloadListener	IDownloadListener
    //   0	301	3	paramResponse	okhttp3.Response
    //   76	59	4	i	int
    //   67	77	5	l1	long
    //   100	42	7	l2	long
    //   64	69	9	l3	long
    //   23	274	11	localObject1	Object
    //   55	32	12	arrayOfByte	byte[]
    //   148	19	12	localException1	java.lang.Exception
    //   292	1	12	localException2	java.lang.Exception
    //   1	294	13	localObject2	Object
    //   10	246	14	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   50	66	148	java/lang/Exception
    //   69	78	148	java/lang/Exception
    //   84	94	148	java/lang/Exception
    //   102	117	148	java/lang/Exception
    //   125	141	148	java/lang/Exception
    //   197	214	148	java/lang/Exception
    //   219	224	235	java/io/IOException
    //   229	234	235	java/io/IOException
    //   181	186	241	java/io/IOException
    //   191	196	241	java/io/IOException
    //   25	39	247	finally
    //   39	50	247	finally
    //   255	260	270	java/io/IOException
    //   264	268	270	java/io/IOException
    //   50	66	278	finally
    //   69	78	278	finally
    //   84	94	278	finally
    //   102	117	278	finally
    //   125	141	278	finally
    //   197	214	278	finally
    //   150	176	285	finally
    //   25	39	292	java/lang/Exception
    //   39	50	292	java/lang/Exception
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