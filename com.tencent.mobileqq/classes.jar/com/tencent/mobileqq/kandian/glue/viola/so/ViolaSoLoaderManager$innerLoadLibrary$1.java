package com.tencent.mobileqq.kandian.glue.viola.so;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInjoyWebRenderSoLoader;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/glue/viola/so/ViolaSoLoaderManager$innerLoadLibrary$1", "Lcom/tencent/mobileqq/kandian/biz/fastweb/LoadLibCallback;", "onError", "", "code", "", "onFinish", "fromType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaSoLoaderManager$innerLoadLibrary$1
  implements LoadLibCallback
{
  ViolaSoLoaderManager$innerLoadLibrary$1(String paramString, LoadLibCallback paramLoadLibCallback) {}
  
  public void onError(int paramInt)
  {
    Object localObject;
    if (ViolaSoLoaderManager.a(this.a))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load v8 error. from: ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", code: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", switch to jsc loader");
      QLog.e("ViolaSoLoaderManager", 1, ((StringBuilder)localObject).toString());
      ViolaSoLoaderManager.b(this.a);
      RIJSPUtils.a(ReadInjoyWebRenderSoLoader.b, Boolean.valueOf(true));
      localObject = this.c;
      if (localObject != null) {
        ((LoadLibCallback)localObject).onError(paramInt);
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load v8 error. from: ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", code: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("ViolaSoLoaderManager", 1, ((StringBuilder)localObject).toString());
      localObject = this.c;
      if (localObject != null) {
        ((LoadLibCallback)localObject).onError(paramInt);
      }
    }
  }
  
  public void onFinish(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((LoadLibCallback)localObject).onFinish(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load success. from: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", loaderType: ");
    ((StringBuilder)localObject).append(ViolaSoLoaderManager.c(this.a));
    QLog.e("ViolaSoLoaderManager", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.innerLoadLibrary.1
 * JD-Core Version:    0.7.0.1
 */