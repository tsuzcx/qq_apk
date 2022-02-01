package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import java.util.HashSet;

class QQGameSubscribeServiceImpl$3
  implements WadlTrpcListener
{
  QQGameSubscribeServiceImpl$3(QQGameSubscribeServiceImpl paramQQGameSubscribeServiceImpl) {}
  
  public HashSet<String> getFilterCmds()
  {
    return QQGameSubscribeServiceImpl.access$000(this.a);
  }
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if ("/v1/95".equals(paramString))
    {
      QQGameSubscribeServiceImpl.access$100(this.a, paramIntent, paramString, paramLong, paramTrpcInovkeRsp);
      return;
    }
    if ("/v1/96".equals(paramString))
    {
      QQGameSubscribeServiceImpl.access$200(this.a, paramIntent, paramString, paramLong, paramTrpcInovkeRsp);
      return;
    }
    if ("/v1/97".equals(paramString)) {
      QQGameSubscribeServiceImpl.access$300(this.a, paramIntent, paramString, paramLong, paramTrpcInovkeRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameSubscribeServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */