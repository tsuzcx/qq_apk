package com.tencent.mobileqq.wink.pick.circle;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.pick.circle.model.PickAlbumViewModel;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic.MusicInfoRsp;

class WinkCirclePhotoListLogic$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.MusicInfoRsp>
{
  WinkCirclePhotoListLogic$2(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.MusicInfoRsp paramMusicInfoRsp)
  {
    if (paramMusicInfoRsp != null)
    {
      paramBaseRequest = WinkEditorMusicHelper.b(WinkEditorMusicHelper.a(paramMusicInfoRsp.musicListInfo.get())).iterator();
      while (paramBaseRequest.hasNext())
      {
        paramString = (WinkEditorMusicInfo)paramBaseRequest.next();
        this.a.f.a = paramString.e();
        this.a.f.b = "音乐";
        this.a.f.c = URLDrawable.getDrawable(paramString.i());
        if (this.a.g != null) {
          this.a.g.a(this.a.f);
        }
      }
    }
    WinkQLog.a("WinkCirclePhotoListLogic", "MusicInfoReqCallBack, musicInfoRsp == null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic.2
 * JD-Core Version:    0.7.0.1
 */