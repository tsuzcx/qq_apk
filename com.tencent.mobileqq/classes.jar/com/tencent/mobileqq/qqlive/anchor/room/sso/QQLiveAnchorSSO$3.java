package com.tencent.mobileqq.qqlive.anchor.room.sso;

import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.GetRtmpPushUrlRsp;

final class QQLiveAnchorSSO$3
  extends QQLiveBusinessObserver
{
  QQLiveAnchorSSO$3(QQLiveAnchorSSO.Callback paramCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPushRtmpUrl receive, type:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", success:");
      localStringBuilder.append(paramBoolean);
      QLog.d("QQLiveAnchor_SSO", 1, localStringBuilder.toString());
    }
    try
    {
      QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
      paramQQLiveRspData = GetRtmpPushUrlRsp.a(paramQQLiveRspData.a());
      if (paramQQLiveRspData.a == 0)
      {
        paramQQLiveRspData = QQLiveAnchorSSOHelper.a(paramQQLiveRspData);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("push rtmp result:");
          localStringBuilder.append(paramQQLiveRspData.toString());
          QLog.d("QQLiveAnchor_SSO", 1, localStringBuilder.toString());
        }
        this.a.a(paramQQLiveRspData);
        return;
      }
      throw new QQLiveAnchorThrowable("getPushRtmpUrl rsp error", paramQQLiveRspData.a, "");
    }
    catch (Throwable paramQQLiveRspData)
    {
      QLog.d("QQLiveAnchor_SSO", 1, "getPushRtmpUrl failed: ", paramQQLiveRspData);
      paramQQLiveRspData = QQLiveAnchorThrowable.covert(6221, paramQQLiveRspData);
      this.a.a(new QQLiveAnchorDataPushInfo(false, paramQQLiveRspData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.3
 * JD-Core Version:    0.7.0.1
 */