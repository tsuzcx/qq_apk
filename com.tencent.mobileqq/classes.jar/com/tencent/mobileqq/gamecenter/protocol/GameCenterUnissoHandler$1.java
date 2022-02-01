package com.tencent.mobileqq.gamecenter.protocol;

import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import java.util.HashSet;

class GameCenterUnissoHandler$1
  implements WadlTrpcListener
{
  GameCenterUnissoHandler$1(GameCenterUnissoHandler paramGameCenterUnissoHandler) {}
  
  public HashSet<String> a()
  {
    return new GameCenterUnissoHandler.1.1(this);
  }
  
  public void a(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("hippyUpdateAction-" + GameCenterUnissoHandler.a(), 1, "WadlTrpcListener onTrpcRsp cmd:" + paramString + " ret:" + paramLong);
    }
    if ("/v1/33".equals(paramString)) {
      HippyUpdateManager.getInstance().handleResponse(paramIntent, paramLong, paramTrpcInovkeRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler.1
 * JD-Core Version:    0.7.0.1
 */