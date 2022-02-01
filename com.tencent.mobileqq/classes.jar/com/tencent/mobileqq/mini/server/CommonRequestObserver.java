package com.tencent.mobileqq.mini.server;

import android.os.Bundle;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/server/CommonRequestObserver;", "Rsp", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Lmqq/observer/BusinessObserver;", "mRspClazz", "Ljava/lang/Class;", "callback", "Lcom/tencent/mobileqq/mini/server/RequestCallback;", "(Ljava/lang/Class;Lcom/tencent/mobileqq/mini/server/RequestCallback;)V", "mCallbackRef", "Ljava/lang/ref/WeakReference;", "onReceive", "", "type", "", "isSuccess", "", "bundle", "Landroid/os/Bundle;", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class CommonRequestObserver<Rsp extends MessageMicro<Rsp>>
  implements BusinessObserver
{
  public static final CommonRequestObserver.Companion Companion = new CommonRequestObserver.Companion(null);
  private static final String TAG = "CommonRequestObserver";
  private final WeakReference<RequestCallback<Rsp>> mCallbackRef;
  private final Class<Rsp> mRspClazz;
  
  public CommonRequestObserver(@NotNull Class<Rsp> paramClass, @NotNull RequestCallback<Rsp> paramRequestCallback)
  {
    this.mRspClazz = paramClass;
    this.mCallbackRef = new WeakReference(paramRequestCallback);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    Object localObject1 = paramBundle.getByteArray("key_response_data");
    if ((paramBoolean) && (localObject1 != null))
    {
      if (localObject1.length == 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((paramInt ^ 0x1) != 0) {
        try
        {
          Object localObject2 = this.mRspClazz.newInstance();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "mRspClazz.newInstance()");
          localObject2 = (MessageMicro)localObject2;
          ((MessageMicro)localObject2).mergeFrom((byte[])localObject1);
          localObject1 = (RequestCallback)this.mCallbackRef.get();
          if (localObject1 != null) {
            ((RequestCallback)localObject1).onReqSucceed(localObject2);
          }
          return;
        }
        catch (Exception localException)
        {
          QLog.e("CommonRequestObserver", 1, "onReceive: error -->", (Throwable)localException);
        }
      }
    }
    RequestCallback localRequestCallback = (RequestCallback)this.mCallbackRef.get();
    if (localRequestCallback != null) {
      localRequestCallback.onReqFailed(paramBundle.getLong("retCode"), paramBundle.getString("errMsg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.server.CommonRequestObserver
 * JD-Core Version:    0.7.0.1
 */