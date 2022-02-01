package com.tencent.mobileqq.qqlive.anchor.room.sso;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAddress;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFrame;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStream;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.iliveStreamControl.nano.GetLiveStreamsRsp;
import java.util.ArrayList;

final class QQLiveAnchorSSO$4
  extends QQLiveBusinessObserver
{
  QQLiveAnchorSSO$4(String paramString, QQLiveAnchorSSO.Callback paramCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get pull url recieve, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", success:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQLiveAnchor_SSO", 1, ((StringBuilder)localObject).toString());
    }
    try
    {
      QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
      paramQQLiveRspData = GetLiveStreamsRsp.a(paramQQLiveRspData.a());
      if (paramQQLiveRspData.a == 0)
      {
        QQLiveAnchorDataPullInfo localQQLiveAnchorDataPullInfo = QQLiveAnchorSSOHelper.a(paramQQLiveRspData);
        paramQQLiveRspData = "";
        try
        {
          localObject = ((QQLiveAnchorDataAddress)((QQLiveAnchorDataFrame)((QQLiveAnchorDataStream)localQQLiveAnchorDataPullInfo.streams.get(0)).frames.get(0)).addresses.get(0)).url;
          paramQQLiveRspData = (QQLiveRspData)localObject;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("QQLiveAnchor_SSO", 1, "get pull url error, try use push url to play", localThrowable);
          if (!TextUtils.isEmpty(this.a)) {
            paramQQLiveRspData = this.a.replace("livepush", "liveplay");
          }
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("get pull url = ");
          localStringBuilder.append(paramQQLiveRspData);
          QLog.d("QQLiveAnchor_SSO", 1, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty(paramQQLiveRspData))
        {
          localQQLiveAnchorDataPullInfo.defaultPlayUrl = paramQQLiveRspData;
          this.b.a(localQQLiveAnchorDataPullInfo);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get pull url is null or empty: ");
        localStringBuilder.append(paramQQLiveRspData);
        throw new Throwable(localStringBuilder.toString());
      }
      throw new QQLiveAnchorThrowable("get pull url result error", paramQQLiveRspData.a, paramQQLiveRspData.b);
    }
    catch (Throwable paramQQLiveRspData)
    {
      QLog.e("QQLiveAnchor_SSO", 1, "error:", paramQQLiveRspData);
      paramQQLiveRspData = QQLiveAnchorThrowable.covert(6231, paramQQLiveRspData);
      this.b.a(new QQLiveAnchorDataPullInfo(false, paramQQLiveRspData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.4
 * JD-Core Version:    0.7.0.1
 */