package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqgamepub.adapter.QQGamePaAdInfoListenerAdapter;
import com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.LoginReportRsp;
import com.tencent.mobileqq.qqgamepub.utils.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;

class QQGameAdServiceImpl$1
  extends QQGamePaAdInfoListenerAdapter
{
  QQGameAdServiceImpl$1(QQGameAdServiceImpl paramQQGameAdServiceImpl) {}
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    super.onTrpcRsp(paramIntent, paramString, paramLong, paramTrpcInovkeRsp);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("cmd: ");
      paramIntent.append(paramString);
      paramIntent.append(" ret: ");
      paramIntent.append(paramLong);
      QLog.i("QQGamePub_QQGameAdServiceImpl", 2, paramIntent.toString());
    }
    try
    {
      if (("/v1/62".equals(paramString)) && (paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.get() != null))
      {
        paramIntent = new QQGamePaAdInfo.LoginReportRsp();
        paramIntent.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        paramLong = paramIntent.cacheTime.get();
        paramIntent = new StringBuilder();
        paramIntent.append("pull ad cacheTs: ");
        paramIntent.append(paramLong);
        QLog.i("QQGamePub_QQGameAdServiceImpl", 2, paramIntent.toString());
        SharePreferenceUtils.a(QQGameAdServiceImpl.access$000(this.a), QQGameAdServiceImpl.access$100(this.a), paramLong * 1000L);
        SharePreferenceUtils.a(QQGameAdServiceImpl.access$000(this.a), QQGameAdServiceImpl.access$200(this.a), System.currentTimeMillis());
        return;
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e("QQGamePub_QQGameAdServiceImpl", 1, paramIntent, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameAdServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */