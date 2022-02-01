package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class GameCenterUnissoHandler$1
  implements WadlTrpcListener
{
  GameCenterUnissoHandler$1(GameCenterUnissoHandler paramGameCenterUnissoHandler) {}
  
  public HashSet<String> getFilterCmds()
  {
    return new GameCenterUnissoHandler.1.1(this);
  }
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if (QLog.isColorLevel())
    {
      String str = GameCenterUnissoHandler.g();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WadlTrpcListener onTrpcRsp cmd:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ret:");
      localStringBuilder.append(paramLong);
      QLog.i(str, 1, localStringBuilder.toString());
    }
    if ("/v1/33".equals(paramString))
    {
      this.a.a(paramIntent, paramLong, paramTrpcInovkeRsp);
      return;
    }
    if ("/v1/216".equals(paramString))
    {
      GameCenterUnissoHandler.a(this.a, paramIntent, paramLong, paramTrpcInovkeRsp);
      return;
    }
    if ("/v1/221".equals(paramString)) {
      this.a.b(paramIntent, paramLong, paramTrpcInovkeRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler.1
 * JD-Core Version:    0.7.0.1
 */