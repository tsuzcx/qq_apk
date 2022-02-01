package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;

class UploaderProxyImpl$1
  implements Runnable
{
  UploaderProxyImpl$1(UploaderProxyImpl paramUploaderProxyImpl, String paramString1, Map paramMap1, String paramString2, Map paramMap2, String paramString3, String paramString4, UploaderProxy.UploadListener paramUploadListener) {}
  
  public void run()
  {
    Object localObject1 = MiniOkHttpClientFactory.getUploadClient();
    Request.Builder localBuilder = new Request.Builder();
    localBuilder.tag(localObject1).url(this.jdField_a_of_type_JavaLangString).addHeader("Charset", "utf-8").addHeader("connection", "keep-alive");
    Object localObject2 = this.jdField_a_of_type_JavaUtilMap;
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        localBuilder.addHeader(str, (String)this.jdField_a_of_type_JavaUtilMap.get(str));
      }
    }
    localBuilder.method("POST", HttpUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilMap, this.c, this.d, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyUploaderProxy$UploadListener));
    localObject1 = ((OkHttpClient)localObject1).newCall(localBuilder.build());
    ((Call)localObject1).enqueue(new UploaderProxyImpl.1.1(this));
    this.this$0.a.put(this.jdField_a_of_type_JavaLangString, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.UploaderProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */