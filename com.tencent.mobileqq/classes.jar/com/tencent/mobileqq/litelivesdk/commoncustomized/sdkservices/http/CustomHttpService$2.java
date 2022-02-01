package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import android.os.Handler;
import com.tencent.falco.base.libapi.http.DownloadCallback;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

class CustomHttpService$2
  implements Callback
{
  CustomHttpService$2(CustomHttpService paramCustomHttpService, DownloadCallback paramDownloadCallback, String paramString) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    CustomHttpService.b(this.c).post(new CustomHttpService.2.1(this));
  }
  
  /* Error */
  public void onResponse(Call paramCall, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 52	okhttp3/Response:code	()I
    //   4: sipush 200
    //   7: if_icmpeq +24 -> 31
    //   10: aload_0
    //   11: getfield 16	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:c	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   14: invokestatic 31	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:b	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Landroid/os/Handler;
    //   17: new 54	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$2
    //   20: dup
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 57	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$2:<init>	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2;Lokhttp3/Response;)V
    //   26: invokevirtual 42	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   29: pop
    //   30: return
    //   31: sipush 2048
    //   34: newarray byte
    //   36: astore 9
    //   38: aconst_null
    //   39: astore_1
    //   40: aload_2
    //   41: invokevirtual 61	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   44: invokevirtual 67	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   47: astore 8
    //   49: aload_2
    //   50: invokevirtual 61	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   53: invokevirtual 71	okhttp3/ResponseBody:contentLength	()J
    //   56: lstore 6
    //   58: new 73	java/io/File
    //   61: dup
    //   62: aload_0
    //   63: getfield 20	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:b	Ljava/lang/String;
    //   66: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_1
    //   70: new 78	java/io/FileOutputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   78: astore_2
    //   79: lconst_0
    //   80: lstore 4
    //   82: aload 8
    //   84: aload 9
    //   86: invokevirtual 87	java/io/InputStream:read	([B)I
    //   89: istore_3
    //   90: iload_3
    //   91: iconst_m1
    //   92: if_icmpeq +59 -> 151
    //   95: aload_2
    //   96: aload 9
    //   98: iconst_0
    //   99: iload_3
    //   100: invokevirtual 91	java/io/FileOutputStream:write	([BII)V
    //   103: lload 4
    //   105: iload_3
    //   106: i2l
    //   107: ladd
    //   108: lstore 4
    //   110: lload 4
    //   112: l2f
    //   113: fconst_1
    //   114: fmul
    //   115: lload 6
    //   117: l2f
    //   118: fdiv
    //   119: ldc 92
    //   121: fmul
    //   122: f2i
    //   123: istore_3
    //   124: aload_0
    //   125: getfield 16	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:c	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   128: invokestatic 31	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:b	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Landroid/os/Handler;
    //   131: new 94	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$3
    //   134: dup
    //   135: aload_0
    //   136: lload 4
    //   138: lload 6
    //   140: iload_3
    //   141: invokespecial 97	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$3:<init>	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2;JJI)V
    //   144: invokevirtual 42	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   147: pop
    //   148: goto -66 -> 82
    //   151: aload_2
    //   152: invokevirtual 100	java/io/FileOutputStream:flush	()V
    //   155: aload_0
    //   156: getfield 16	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:c	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   159: invokestatic 31	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:b	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Landroid/os/Handler;
    //   162: new 102	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$4
    //   165: dup
    //   166: aload_0
    //   167: aload_1
    //   168: invokespecial 105	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$4:<init>	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2;Ljava/io/File;)V
    //   171: invokevirtual 42	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   174: pop
    //   175: aload 8
    //   177: ifnull +16 -> 193
    //   180: aload 8
    //   182: invokevirtual 108	java/io/InputStream:close	()V
    //   185: goto +8 -> 193
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   193: aload_2
    //   194: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   197: return
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   203: return
    //   204: astore_1
    //   205: goto +36 -> 241
    //   208: astore_1
    //   209: goto +12 -> 221
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_2
    //   215: goto +26 -> 241
    //   218: astore_1
    //   219: aconst_null
    //   220: astore_2
    //   221: aload 8
    //   223: astore 9
    //   225: aload_1
    //   226: astore 8
    //   228: aload 9
    //   230: astore_1
    //   231: goto +17 -> 248
    //   234: astore_1
    //   235: aconst_null
    //   236: astore 8
    //   238: aload 8
    //   240: astore_2
    //   241: goto +119 -> 360
    //   244: astore 8
    //   246: aconst_null
    //   247: astore_2
    //   248: aload_0
    //   249: getfield 16	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:c	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   252: invokestatic 115	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:a	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Lcom/tencent/falco/base/libapi/http/HttpInterface$HttpComponentAdapter;
    //   255: invokeinterface 121 1 0
    //   260: astore 9
    //   262: new 123	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   269: astore 10
    //   271: aload 10
    //   273: ldc 126
    //   275: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 10
    //   281: aload 8
    //   283: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 9
    //   289: ldc 135
    //   291: aload 10
    //   293: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: iconst_0
    //   297: anewarray 4	java/lang/Object
    //   300: invokeinterface 145 4 0
    //   305: aload_0
    //   306: getfield 16	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:c	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   309: invokestatic 31	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:b	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Landroid/os/Handler;
    //   312: new 147	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$5
    //   315: dup
    //   316: aload_0
    //   317: invokespecial 148	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$5:<init>	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2;)V
    //   320: invokevirtual 42	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   323: pop
    //   324: aload_1
    //   325: ifnull +15 -> 340
    //   328: aload_1
    //   329: invokevirtual 108	java/io/InputStream:close	()V
    //   332: goto +8 -> 340
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   340: aload_2
    //   341: ifnull +7 -> 348
    //   344: aload_2
    //   345: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   348: return
    //   349: astore 9
    //   351: aload_1
    //   352: astore 8
    //   354: aload 9
    //   356: astore_1
    //   357: goto -116 -> 241
    //   360: aload 8
    //   362: ifnull +18 -> 380
    //   365: aload 8
    //   367: invokevirtual 108	java/io/InputStream:close	()V
    //   370: goto +10 -> 380
    //   373: astore 8
    //   375: aload 8
    //   377: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   380: aload_2
    //   381: ifnull +15 -> 396
    //   384: aload_2
    //   385: invokevirtual 112	java/io/FileOutputStream:close	()V
    //   388: goto +8 -> 396
    //   391: astore_2
    //   392: aload_2
    //   393: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   396: goto +5 -> 401
    //   399: aload_1
    //   400: athrow
    //   401: goto -2 -> 399
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	2
    //   0	404	1	paramCall	Call
    //   0	404	2	paramResponse	okhttp3.Response
    //   89	52	3	i	int
    //   80	57	4	l1	long
    //   56	83	6	l2	long
    //   47	192	8	localObject1	Object
    //   244	38	8	localException1	java.lang.Exception
    //   352	14	8	localCall	Call
    //   373	3	8	localException2	java.lang.Exception
    //   36	252	9	localObject2	Object
    //   349	6	9	localObject3	Object
    //   269	23	10	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   180	185	188	java/lang/Exception
    //   193	197	198	java/lang/Exception
    //   344	348	198	java/lang/Exception
    //   82	90	204	finally
    //   95	103	204	finally
    //   110	148	204	finally
    //   151	175	204	finally
    //   82	90	208	java/lang/Exception
    //   95	103	208	java/lang/Exception
    //   110	148	208	java/lang/Exception
    //   151	175	208	java/lang/Exception
    //   49	79	212	finally
    //   49	79	218	java/lang/Exception
    //   40	49	234	finally
    //   40	49	244	java/lang/Exception
    //   328	332	335	java/lang/Exception
    //   248	324	349	finally
    //   365	370	373	java/lang/Exception
    //   384	388	391	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService.2
 * JD-Core Version:    0.7.0.1
 */