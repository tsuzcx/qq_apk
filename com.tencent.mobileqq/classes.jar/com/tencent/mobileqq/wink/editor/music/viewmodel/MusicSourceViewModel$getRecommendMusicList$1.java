package com.tencent.mobileqq.wink.editor.music.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "baseRequest", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "isSuccess", "", "retCode", "", "errMsg", "", "rsp", "Lqqcircle/QQCircleSmartMatchMusic$SmartMatchMusicRsp;", "onReceive"}, k=3, mv={1, 1, 16})
final class MusicSourceViewModel$getRecommendMusicList$1<T>
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.SmartMatchMusicRsp>
{
  MusicSourceViewModel$getRecommendMusicList$1(MusicSourceViewModel paramMusicSourceViewModel, List paramList) {}
  
  public final void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.SmartMatchMusicRsp paramSmartMatchMusicRsp)
  {
    if (paramBoolean)
    {
      if (paramSmartMatchMusicRsp != null)
      {
        paramBaseRequest = paramSmartMatchMusicRsp.musicListInfo;
        if (paramBaseRequest != null)
        {
          paramString = WinkEditorMusicHelper.a(WinkEditorMusicHelper.b(WinkEditorMusicHelper.a(paramBaseRequest.get())), this.b);
          paramSmartMatchMusicRsp = this.a;
          Intrinsics.checkExpressionValueIsNotNull(paramString, "finalMusicList");
          paramBaseRequest = (List)this.a.a().getValue();
          if (paramBaseRequest == null)
          {
            paramBaseRequest = WinkEditorMusicInfo.a;
            Intrinsics.checkExpressionValueIsNotNull(paramBaseRequest, "WinkEditorMusicInfo.DEFAULT_LIST");
          }
          paramBaseRequest = MusicSourceViewModel.a(paramSmartMatchMusicRsp, paramString, paramBaseRequest);
          this.a.a().postValue(paramBaseRequest);
        }
      }
    }
    else {
      this.a.j().postValue(Integer.valueOf(2131886354));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.getRecommendMusicList.1
 * JD-Core Version:    0.7.0.1
 */