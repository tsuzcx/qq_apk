package com.tencent.mtt.hippy.bridge;

import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.a.n;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.UrlUtils;

class HippyBridgeImpl$2
  implements Runnable
{
  HippyBridgeImpl$2(HippyBridgeImpl paramHippyBridgeImpl, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = HippyBridgeImpl.access$100(this.c).getDevSupportManager();
    if ((HippyBridgeImpl.access$100(this.c) != null) && (!TextUtils.isEmpty(this.a)) && (UrlUtils.isWebUrl(this.a)) && (localObject != null))
    {
      ((n)localObject).a(this.a, new HippyBridgeImpl.2.1(this));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fetchResourceWithUri: can not call loadRemoteResource with ");
    ((StringBuilder)localObject).append(this.a);
    LogUtils.e("HippyBridgeImpl", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridgeImpl.2
 * JD-Core Version:    0.7.0.1
 */