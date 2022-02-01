package com.tencent.qcircle.application.initprocess;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.datacenter.rank.QCircleRankEdgeConfig;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import qqcircle.QQCircleConfig.GetRainbowKVConfRsp;

class QCircleInitStartProcess$2
  implements Call.OnRspCallBack<QCircleBaseRequest>
{
  QCircleInitStartProcess$2(QCircleInitStartProcess paramQCircleInitStartProcess) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramLong == 0L) && ((paramObject instanceof QQCircleConfig.GetRainbowKVConfRsp)))
    {
      paramString = (QQCircleConfig.GetRainbowKVConfRsp)paramObject;
      paramQCircleBaseRequest = new StringBuilder();
      paramQCircleBaseRequest.append("getRankConfig");
      paramQCircleBaseRequest.append(paramString.data.get());
      QLog.d("QCircleInitStartProcess", 1, paramQCircleBaseRequest.toString());
      if (TextUtils.isEmpty(paramString.data.get())) {
        return;
      }
      paramString = (QCircleRankEdgeConfig)new Gson().fromJson(paramString.data.get(), QCircleRankEdgeConfig.class);
      if (paramString != null) {
        QCirclePluginGlobalInfo.a(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.application.initprocess.QCircleInitStartProcess.2
 * JD-Core Version:    0.7.0.1
 */