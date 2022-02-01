package com.tencent.mobileqq.kandian.glue.viola.so;

import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resCode", "", "<anonymous parameter 1>", "Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;", "kotlin.jvm.PlatformType", "onLoadResult"}, k=3, mv={1, 1, 16})
final class ViolaSoLoader$loadLibrary$1
  implements OnLoadListener
{
  ViolaSoLoader$loadLibrary$1(ViolaSoLoader paramViolaSoLoader, LoadLibCallback paramLoadLibCallback, String paramString) {}
  
  public final void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      ViolaSoLoader.a(this.a, true);
      paramLoadExtResult = this.b;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.onFinish(ReadInJoyWebRenderEngine.g);
      }
      ViolaSoLoader.a(this.a, 0);
      ViolaSoLoaderManager.a.a().g();
      paramLoadExtResult = new StringBuilder();
      paramLoadExtResult.append("load viola so success, from: ");
      paramLoadExtResult.append(this.c);
      QLog.d("ViolaSoLoader", 1, paramLoadExtResult.toString());
      return;
    }
    ViolaSoLoader.a(this.a, false);
    if (ViolaSoLoader.a(this.a) < 3)
    {
      this.a.a(this.c, this.b);
      paramLoadExtResult = this.a;
      ViolaSoLoader.a(paramLoadExtResult, ViolaSoLoader.a(paramLoadExtResult) + 1);
      paramLoadExtResult = new StringBuilder();
      paramLoadExtResult.append("load viola so error, from: ");
      paramLoadExtResult.append(this.c);
      paramLoadExtResult.append(", retryCount: ");
      paramLoadExtResult.append(ViolaSoLoader.a(this.a));
      paramLoadExtResult.append(", errorCode: ");
      paramLoadExtResult.append(paramInt);
      QLog.e("ViolaSoLoader", 1, paramLoadExtResult.toString());
      return;
    }
    ViolaSoLoader.a(this.a, 0);
    paramLoadExtResult = this.b;
    if (paramLoadExtResult != null) {
      paramLoadExtResult.onError(paramInt);
    }
    paramLoadExtResult = new StringBuilder();
    paramLoadExtResult.append("load viola so error, from: ");
    paramLoadExtResult.append(this.c);
    paramLoadExtResult.append(", errorCode: ");
    paramLoadExtResult.append(paramInt);
    QLog.d("ViolaSoLoader", 1, paramLoadExtResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoader.loadLibrary.1
 * JD-Core Version:    0.7.0.1
 */