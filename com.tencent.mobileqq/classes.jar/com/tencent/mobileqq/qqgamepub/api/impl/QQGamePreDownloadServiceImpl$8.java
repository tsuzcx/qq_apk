package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl.DSLPermitRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class QQGamePreDownloadServiceImpl$8
  implements WadlTrpcListener
{
  QQGamePreDownloadServiceImpl$8(QQGamePreDownloadServiceImpl paramQQGamePreDownloadServiceImpl) {}
  
  public HashSet<String> getFilterCmds()
  {
    return new QQGamePreDownloadServiceImpl.8.1(this);
  }
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    String str = paramIntent.getStringExtra("activityId");
    int i;
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.get() != null)) {
      try
      {
        QQGameResFlowControl.DSLPermitRsp localDSLPermitRsp = new QQGameResFlowControl.DSLPermitRsp();
        localDSLPermitRsp.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        int j = localDSLPermitRsp.resState.get();
        i = j;
        if (j != 1) {
          break label124;
        }
        try
        {
          QQGamePreDownloadServiceImpl.access$300(this.a, str);
          i = j;
        }
        catch (Exception paramTrpcInovkeRsp)
        {
          i = j;
        }
        QLog.e("QQGamePub_QQGamePreDownloadServiceImpl", 1, paramTrpcInovkeRsp, new Object[0]);
      }
      catch (Exception paramTrpcInovkeRsp)
      {
        i = 0;
      }
    } else {
      i = 0;
    }
    label124:
    if (QLog.isColorLevel())
    {
      paramTrpcInovkeRsp = new StringBuilder();
      paramTrpcInovkeRsp.append("onTrpcRs,:request:");
      paramTrpcInovkeRsp.append(paramIntent);
      paramTrpcInovkeRsp.append(",cmd:");
      paramTrpcInovkeRsp.append(paramString);
      paramTrpcInovkeRsp.append(",ret:");
      paramTrpcInovkeRsp.append(paramLong);
      paramTrpcInovkeRsp.append(",rsp resState:");
      paramTrpcInovkeRsp.append(i);
      paramTrpcInovkeRsp.append(",activityId:");
      paramTrpcInovkeRsp.append(str);
      QLog.i("QQGamePub_QQGamePreDownloadServiceImpl", 2, paramTrpcInovkeRsp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */