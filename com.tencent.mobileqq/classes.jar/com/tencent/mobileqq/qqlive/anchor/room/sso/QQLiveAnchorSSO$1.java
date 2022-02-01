package com.tencent.mobileqq.qqlive.anchor.room.sso;

import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.PrepareRsp;

final class QQLiveAnchorSSO$1
  extends QQLiveBusinessObserver
{
  QQLiveAnchorSSO$1(QQLiveAnchorSSO.Callback paramCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepare receive, type:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", success:");
      localStringBuilder.append(paramBoolean);
      QLog.d("QQLiveAnchor_SSO", 1, localStringBuilder.toString());
    }
    try
    {
      QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
      paramQQLiveRspData = PrepareRsp.a(paramQQLiveRspData.a());
      if (paramQQLiveRspData.a == 0)
      {
        paramQQLiveRspData = QQLiveAnchorSSOHelper.a(paramQQLiveRspData);
        this.a.a(paramQQLiveRspData);
        return;
      }
      throw new QQLiveAnchorThrowable("prepare rsp error", paramQQLiveRspData.a, paramQQLiveRspData.b);
    }
    catch (Throwable paramQQLiveRspData)
    {
      QLog.e("QQLiveAnchor_SSO", 1, "prepare error, ", paramQQLiveRspData);
      paramQQLiveRspData = QQLiveAnchorThrowable.covert(6200, paramQQLiveRspData);
      this.a.a(new QQLiveAnchorDataPrepare(false, paramQQLiveRspData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.1
 * JD-Core Version:    0.7.0.1
 */