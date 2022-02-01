package com.tencent.mobileqq.wink.editor.music;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

final class WinkEditorMusicHelper$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.SmartMatchMusicRsp>
{
  WinkEditorMusicHelper$1(VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, QQWinkSmartMatchMusicReq paramQQWinkSmartMatchMusicReq) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.SmartMatchMusicRsp paramSmartMatchMusicRsp)
  {
    paramBaseRequest = this.a;
    if (paramBaseRequest != null) {
      paramBaseRequest.onReceive(this.b, paramBoolean, paramLong, paramString, paramSmartMatchMusicRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.1
 * JD-Core Version:    0.7.0.1
 */