package com.tencent.mobileqq.wink.editor.music.viewmodel;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.MusicDownloadCallback;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.MusicDownloadRunnable;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import qqcircle.QQCircleSmartMatchMusic.MusicInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "", "musicInfoRsp", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfoRsp;", "onReceive"}, k=3, mv={1, 1, 16})
final class MusicSourceViewModel$updateBgmData$1<T>
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.MusicInfoRsp>
{
  MusicSourceViewModel$updateBgmData$1(MusicSourceViewModel paramMusicSourceViewModel, String paramString) {}
  
  public final void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.MusicInfoRsp paramMusicInfoRsp)
  {
    if (paramMusicInfoRsp == null) {
      return;
    }
    paramBaseRequest = paramMusicInfoRsp.musicListInfo;
    if (paramBaseRequest != null) {
      paramBaseRequest = paramBaseRequest.get();
    } else {
      paramBaseRequest = null;
    }
    paramBaseRequest = WinkEditorMusicHelper.b(WinkEditorMusicHelper.a(paramBaseRequest));
    if ((paramBaseRequest != null) && ((((Collection)paramBaseRequest).isEmpty() ^ true)))
    {
      paramBaseRequest = (WinkEditorMusicInfo)paramBaseRequest.get(0);
      if (paramBaseRequest.d == 1) {
        return;
      }
      paramBaseRequest.d = 1;
      paramString = MobileQQ.sMobileQQ.peekAppRuntime();
      Intrinsics.checkExpressionValueIsNotNull(paramBaseRequest, "selectEditorMusicInfo");
      ThreadManager.excute((Runnable)new WinkEditorMusicHelper.MusicDownloadRunnable(paramString, paramBaseRequest, paramBaseRequest.f(), this.b, (WinkEditorMusicHelper.MusicDownloadCallback)new MusicSourceViewModel.updateBgmData.1.runnable.1(this)), 128, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.updateBgmData.1
 * JD-Core Version:    0.7.0.1
 */