package com.tencent.mobileqq.qqgamepub.adapter;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import java.util.HashSet;

public class QQGamePaAdInfoListenerAdapter
  implements WadlTrpcListener
{
  public HashSet<String> getFilterCmds()
  {
    return new QQGamePaAdInfoListenerAdapter.1(this);
  }
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.adapter.QQGamePaAdInfoListenerAdapter
 * JD-Core Version:    0.7.0.1
 */