package com.tencent.mobileqq.qqlive.sso;

import androidx.annotation.NonNull;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QQLiveCallbackObserver
  extends QQLiveBusinessObserver
{
  private final BaseSsoCallback a;
  
  public QQLiveCallbackObserver(@NonNull BaseSsoCallback paramBaseSsoCallback)
  {
    this.a = paramBaseSsoCallback;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (this.a == null)
    {
      QLog.e("BaseSsoCallback", 1, "the callback is null");
      return;
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramBoolean) {
      if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
      {
        if (paramQQLiveRspData.c() != 0)
        {
          localObject = this.a;
          paramInt = paramQQLiveRspData.c();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("business error ");
          localStringBuilder.append(paramQQLiveRspData.e());
          ((BaseSsoCallback)localObject).onBusinessFailed(paramInt, localStringBuilder.toString());
          return;
        }
        if (paramQQLiveRspData.d() != 0)
        {
          localObject = this.a;
          paramInt = paramQQLiveRspData.d();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("business error ");
          localStringBuilder.append(paramQQLiveRspData.e());
          ((BaseSsoCallback)localObject).onFailed(paramInt, localStringBuilder.toString());
          return;
        }
      }
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onProxyRequestSuccess method:");
        ((StringBuilder)localObject).append(paramQQLiveRspData.b().getServiceCmd());
        QLog.d("BaseSsoCallback", 2, ((StringBuilder)localObject).toString());
      }
      this.a.onProxyRequestSuccess(paramInt, paramQQLiveRspData);
      return;
    }
    catch (InvalidProtocolBufferNanoException paramQQLiveRspData)
    {
      label205:
      break label205;
    }
    this.a.onFailed(-1, " transform error: InvalidProtocolBufferNanoException ");
    return;
    this.a.onFailed(-1, "the data is null");
    return;
    if (paramQQLiveRspData.b() != null)
    {
      localObject = this.a;
      paramInt = paramQQLiveRspData.b().getResultCode();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sso fail request: ");
      localStringBuilder.append(paramQQLiveRspData.b().getServiceCmd());
      ((BaseSsoCallback)localObject).onFailed(paramInt, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver
 * JD-Core Version:    0.7.0.1
 */