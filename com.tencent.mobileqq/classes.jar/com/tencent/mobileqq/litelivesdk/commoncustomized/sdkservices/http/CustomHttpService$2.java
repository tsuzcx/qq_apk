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
    CustomHttpService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService).post(new CustomHttpService.2.1(this));
  }
  
  /* Error */
  public void onResponse(Call paramCall, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_2
    //   7: invokevirtual 50	okhttp3/Response:code	()I
    //   10: sipush 200
    //   13: if_icmpeq +24 -> 37
    //   16: aload_0
    //   17: getfield 14	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   20: invokestatic 29	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:a	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Landroid/os/Handler;
    //   23: new 52	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$2
    //   26: dup
    //   27: aload_0
    //   28: aload_2
    //   29: invokespecial 55	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$2:<init>	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2;Lokhttp3/Response;)V
    //   32: invokevirtual 40	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   35: pop
    //   36: return
    //   37: sipush 2048
    //   40: newarray byte
    //   42: astore 10
    //   44: aload_2
    //   45: invokevirtual 59	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   48: invokevirtual 65	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   51: astore_1
    //   52: aload_2
    //   53: invokevirtual 59	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   56: invokevirtual 69	okhttp3/ResponseBody:contentLength	()J
    //   59: lstore 6
    //   61: new 71	java/io/File
    //   64: dup
    //   65: aload_0
    //   66: getfield 18	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 11
    //   74: new 76	java/io/FileOutputStream
    //   77: dup
    //   78: aload 11
    //   80: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore_2
    //   84: lconst_0
    //   85: lstore 4
    //   87: aload_1
    //   88: aload 10
    //   90: invokevirtual 85	java/io/InputStream:read	([B)I
    //   93: istore_3
    //   94: iload_3
    //   95: iconst_m1
    //   96: if_icmpeq +153 -> 249
    //   99: aload_2
    //   100: aload 10
    //   102: iconst_0
    //   103: iload_3
    //   104: invokevirtual 89	java/io/FileOutputStream:write	([BII)V
    //   107: lload 4
    //   109: iload_3
    //   110: i2l
    //   111: ladd
    //   112: lstore 4
    //   114: lload 4
    //   116: l2f
    //   117: fconst_1
    //   118: fmul
    //   119: lload 6
    //   121: l2f
    //   122: fdiv
    //   123: ldc 90
    //   125: fmul
    //   126: f2i
    //   127: istore_3
    //   128: aload_0
    //   129: getfield 14	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   132: invokestatic 29	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:a	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Landroid/os/Handler;
    //   135: new 92	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$3
    //   138: dup
    //   139: aload_0
    //   140: lload 4
    //   142: lload 6
    //   144: iload_3
    //   145: invokespecial 95	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$3:<init>	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2;JJI)V
    //   148: invokevirtual 40	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   151: pop
    //   152: goto -65 -> 87
    //   155: astore 9
    //   157: aload_2
    //   158: astore 8
    //   160: aload 9
    //   162: astore_2
    //   163: aload_0
    //   164: getfield 14	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   167: invokestatic 98	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:a	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Lcom/tencent/falco/base/libapi/http/HttpInterface$HttpComponentAdapter;
    //   170: invokeinterface 104 1 0
    //   175: ldc 106
    //   177: new 108	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   184: ldc 111
    //   186: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_2
    //   190: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: iconst_0
    //   197: anewarray 4	java/lang/Object
    //   200: invokeinterface 128 4 0
    //   205: aload_0
    //   206: getfield 14	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   209: invokestatic 29	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:a	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Landroid/os/Handler;
    //   212: new 130	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$5
    //   215: dup
    //   216: aload_0
    //   217: invokespecial 131	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$5:<init>	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2;)V
    //   220: invokevirtual 40	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   223: pop
    //   224: aload_1
    //   225: ifnull +7 -> 232
    //   228: aload_1
    //   229: invokevirtual 134	java/io/InputStream:close	()V
    //   232: aload 8
    //   234: ifnull -198 -> 36
    //   237: aload 8
    //   239: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   242: return
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   248: return
    //   249: aload_2
    //   250: invokevirtual 141	java/io/FileOutputStream:flush	()V
    //   253: aload_0
    //   254: getfield 14	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2:jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService	Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;
    //   257: invokestatic 29	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService:a	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService;)Landroid/os/Handler;
    //   260: new 143	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$4
    //   263: dup
    //   264: aload_0
    //   265: aload 11
    //   267: invokespecial 146	com/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2$4:<init>	(Lcom/tencent/mobileqq/litelivesdk/commoncustomized/sdkservices/http/CustomHttpService$2;Ljava/io/File;)V
    //   270: invokevirtual 40	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   273: pop
    //   274: aload_1
    //   275: ifnull +7 -> 282
    //   278: aload_1
    //   279: invokevirtual 134	java/io/InputStream:close	()V
    //   282: aload_2
    //   283: ifnull -247 -> 36
    //   286: aload_2
    //   287: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   290: return
    //   291: astore_1
    //   292: aload_1
    //   293: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   296: return
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   302: goto -20 -> 282
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   310: goto -78 -> 232
    //   313: astore_2
    //   314: aconst_null
    //   315: astore_1
    //   316: aload 9
    //   318: astore 8
    //   320: aload_1
    //   321: ifnull +7 -> 328
    //   324: aload_1
    //   325: invokevirtual 134	java/io/InputStream:close	()V
    //   328: aload 8
    //   330: ifnull +8 -> 338
    //   333: aload 8
    //   335: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   338: aload_2
    //   339: athrow
    //   340: astore_1
    //   341: aload_1
    //   342: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   345: goto -17 -> 328
    //   348: astore_1
    //   349: aload_1
    //   350: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   353: goto -15 -> 338
    //   356: astore_2
    //   357: aload 9
    //   359: astore 8
    //   361: goto -41 -> 320
    //   364: astore 9
    //   366: aload_2
    //   367: astore 8
    //   369: aload 9
    //   371: astore_2
    //   372: goto -52 -> 320
    //   375: astore_2
    //   376: goto -56 -> 320
    //   379: astore_2
    //   380: aconst_null
    //   381: astore_1
    //   382: goto -219 -> 163
    //   385: astore_2
    //   386: goto -223 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	2
    //   0	389	1	paramCall	Call
    //   0	389	2	paramResponse	okhttp3.Response
    //   93	52	3	i	int
    //   85	56	4	l1	long
    //   59	84	6	l2	long
    //   4	364	8	localObject1	Object
    //   1	1	9	localObject2	Object
    //   155	203	9	localException	java.lang.Exception
    //   364	6	9	localObject3	Object
    //   42	59	10	arrayOfByte	byte[]
    //   72	194	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   87	94	155	java/lang/Exception
    //   99	107	155	java/lang/Exception
    //   114	152	155	java/lang/Exception
    //   249	274	155	java/lang/Exception
    //   237	242	243	java/lang/Exception
    //   286	290	291	java/lang/Exception
    //   278	282	297	java/lang/Exception
    //   228	232	305	java/lang/Exception
    //   44	52	313	finally
    //   324	328	340	java/lang/Exception
    //   333	338	348	java/lang/Exception
    //   52	84	356	finally
    //   87	94	364	finally
    //   99	107	364	finally
    //   114	152	364	finally
    //   249	274	364	finally
    //   163	224	375	finally
    //   44	52	379	java/lang/Exception
    //   52	84	385	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService.2
 * JD-Core Version:    0.7.0.1
 */