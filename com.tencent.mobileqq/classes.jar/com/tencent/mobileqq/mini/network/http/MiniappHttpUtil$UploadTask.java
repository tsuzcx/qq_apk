package com.tencent.mobileqq.mini.network.http;

import android.text.TextUtils;
import com.tencent.plato.mqq.network.ProgressRequestBody;
import java.io.File;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;
import org.json.JSONObject;

public class MiniappHttpUtil$UploadTask
  implements Runnable
{
  Call call;
  HttpCallBack callBack;
  String filePath;
  JSONObject formDataObj;
  JSONObject headerObj;
  volatile boolean isCanceled = false;
  String method;
  String name;
  String uploadFileName;
  String url;
  
  MiniappHttpUtil$UploadTask(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString4, String paramString5, HttpCallBack paramHttpCallBack)
  {
    this.method = paramString1;
    this.url = paramString2;
    this.filePath = paramString3;
    this.headerObj = paramJSONObject1;
    this.formDataObj = paramJSONObject2;
    this.name = paramString4;
    this.uploadFileName = paramString5;
    this.callBack = paramHttpCallBack;
  }
  
  private RequestBody buildMultiPartBody(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    MultipartBody.Builder localBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    if (paramJSONObject != null)
    {
      localObject1 = paramJSONObject.keys();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localBuilder.addFormDataPart((String)localObject2, paramJSONObject.optString((String)localObject2));
      }
    }
    Object localObject2 = new File(this.filePath);
    Object localObject1 = new ProgressRequestBody(RequestBody.create(MediaType.parse(MiniappHttpUtil.access$000(this.filePath)), (File)localObject2), new MiniappHttpUtil.UploadTask.2(this));
    paramJSONObject = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramJSONObject = ((File)localObject2).getName();
    }
    localBuilder.addFormDataPart(paramString1, paramJSONObject, (RequestBody)localObject1);
    return localBuilder.build();
  }
  
  public void abort()
  {
    this.isCanceled = true;
    Call localCall = this.call;
    if (localCall != null) {
      localCall.cancel();
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 152	com/tencent/mobileqq/mini/network/http/MiniOkHttpClientFactory:getUploadClient	()Lokhttp3/OkHttpClient;
    //   3: astore_1
    //   4: new 154	okhttp3/Request$Builder
    //   7: dup
    //   8: invokespecial 155	okhttp3/Request$Builder:<init>	()V
    //   11: astore_2
    //   12: aload_2
    //   13: aload_1
    //   14: invokevirtual 159	okhttp3/Request$Builder:tag	(Ljava/lang/Object;)Lokhttp3/Request$Builder;
    //   17: aload_0
    //   18: getfield 32	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:url	Ljava/lang/String;
    //   21: invokevirtual 162	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   24: ldc 164
    //   26: ldc 166
    //   28: invokevirtual 170	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   31: ldc 172
    //   33: ldc 174
    //   35: invokevirtual 170	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   38: pop
    //   39: aload_0
    //   40: getfield 36	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:headerObj	Lorg/json/JSONObject;
    //   43: ifnull +50 -> 93
    //   46: aload_0
    //   47: getfield 36	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:headerObj	Lorg/json/JSONObject;
    //   50: invokevirtual 66	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   53: astore_3
    //   54: aload_3
    //   55: invokeinterface 72 1 0
    //   60: ifeq +33 -> 93
    //   63: aload_3
    //   64: invokeinterface 76 1 0
    //   69: checkcast 78	java/lang/String
    //   72: astore 4
    //   74: aload_2
    //   75: aload 4
    //   77: aload_0
    //   78: getfield 36	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:headerObj	Lorg/json/JSONObject;
    //   81: aload 4
    //   83: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokevirtual 170	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   89: pop
    //   90: goto -36 -> 54
    //   93: aload_0
    //   94: getfield 28	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:isCanceled	Z
    //   97: ifeq +15 -> 112
    //   100: aload_0
    //   101: getfield 44	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:callBack	Lcom/tencent/mobileqq/mini/network/http/HttpCallBack;
    //   104: bipush 251
    //   106: aconst_null
    //   107: aconst_null
    //   108: invokevirtual 180	com/tencent/mobileqq/mini/network/http/HttpCallBack:httpCallBack	(I[BLjava/util/Map;)V
    //   111: return
    //   112: aload_2
    //   113: aload_0
    //   114: getfield 30	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:method	Ljava/lang/String;
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 38	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:formDataObj	Lorg/json/JSONObject;
    //   122: aload_0
    //   123: getfield 40	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:name	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 42	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:uploadFileName	Ljava/lang/String;
    //   130: invokespecial 182	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:buildMultiPartBody	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/RequestBody;
    //   133: invokevirtual 185	okhttp3/Request$Builder:method	(Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   136: pop
    //   137: aload_0
    //   138: aload_1
    //   139: aload_2
    //   140: invokevirtual 188	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   143: invokevirtual 194	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   146: putfield 138	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:call	Lokhttp3/Call;
    //   149: aload_0
    //   150: getfield 138	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:call	Lokhttp3/Call;
    //   153: new 196	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask$1
    //   156: dup
    //   157: aload_0
    //   158: invokespecial 197	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask$1:<init>	(Lcom/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask;)V
    //   161: invokeinterface 201 2 0
    //   166: return
    //   167: astore_1
    //   168: goto +28 -> 196
    //   171: astore_1
    //   172: ldc 203
    //   174: iconst_1
    //   175: ldc 205
    //   177: aload_1
    //   178: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_0
    //   182: getfield 44	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil$UploadTask:callBack	Lcom/tencent/mobileqq/mini/network/http/HttpCallBack;
    //   185: aload_1
    //   186: iconst_m1
    //   187: invokestatic 215	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil:getRetCodeFrom	(Ljava/lang/Throwable;I)I
    //   190: aconst_null
    //   191: aconst_null
    //   192: invokevirtual 180	com/tencent/mobileqq/mini/network/http/HttpCallBack:httpCallBack	(I[BLjava/util/Map;)V
    //   195: return
    //   196: goto +5 -> 201
    //   199: aload_1
    //   200: athrow
    //   201: goto -2 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	UploadTask
    //   3	136	1	localOkHttpClient	okhttp3.OkHttpClient
    //   167	1	1	localObject	Object
    //   171	29	1	localThrowable	java.lang.Throwable
    //   11	129	2	localBuilder	okhttp3.Request.Builder
    //   53	11	3	localIterator	Iterator
    //   72	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	54	167	finally
    //   54	90	167	finally
    //   93	111	167	finally
    //   112	166	167	finally
    //   172	195	167	finally
    //   0	54	171	java/lang/Throwable
    //   54	90	171	java/lang/Throwable
    //   93	111	171	java/lang/Throwable
    //   112	166	171	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.MiniappHttpUtil.UploadTask
 * JD-Core Version:    0.7.0.1
 */