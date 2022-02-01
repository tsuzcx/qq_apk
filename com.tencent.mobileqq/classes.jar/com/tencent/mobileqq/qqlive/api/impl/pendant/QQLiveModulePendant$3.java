package com.tencent.mobileqq.qqlive.api.impl.pendant;

import com.tencent.mobileqq.qqlive.callback.pendant.PendantInfoCallBack;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PullViewInfoRsp;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

class QQLiveModulePendant$3
  extends BaseSsoCallback
{
  QQLiveModulePendant$3(QQLiveModulePendant paramQQLiveModulePendant) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = PullViewInfoRsp.a(paramQQLiveRspData.a());
    QQLiveModulePendant.access$202(this.this$0, paramQQLiveRspData.b);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("the update Duration ");
    ((StringBuilder)localObject).append(QQLiveModulePendant.access$200(this.this$0));
    QLog.d("QQLiveModulePendant", 4, ((StringBuilder)localObject).toString());
    QQLiveModulePendant.access$300(this.this$0).compareAndSet(false, true);
    paramQQLiveRspData = QQLiveModulePendant.access$400(this.this$0, "init", paramQQLiveRspData);
    localObject = QQLiveModulePendant.access$500(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PendantInfoCallBack)((Iterator)localObject).next()).a(paramQQLiveRspData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.pendant.QQLiveModulePendant.3
 * JD-Core Version:    0.7.0.1
 */