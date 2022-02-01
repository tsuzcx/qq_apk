package com.tencent.mobileqq.wink.editor.music;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic.MusicInfoRsp;

public class WinkEditorMusicHelper$ReqMusicDownloadCallBack
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.MusicInfoRsp>
{
  private List<WinkEditorMusicInfo> a;
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.MusicInfoRsp paramMusicInfoRsp)
  {
    if (paramMusicInfoRsp != null)
    {
      this.a = WinkEditorMusicHelper.b(WinkEditorMusicHelper.a(paramMusicInfoRsp.musicListInfo.get()));
      paramBaseRequest = this.a.iterator();
      while (paramBaseRequest.hasNext()) {
        WinkEditorMusicHelper.a((WinkEditorMusicInfo)paramBaseRequest.next(), null);
      }
    }
    WinkQLog.a("AEEditorMusicHelper", "MusicInfoReqCallBack, musicInfoRsp == null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.ReqMusicDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */