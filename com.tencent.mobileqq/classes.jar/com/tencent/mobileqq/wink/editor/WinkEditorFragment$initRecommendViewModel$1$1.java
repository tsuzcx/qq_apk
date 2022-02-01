package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.LiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.recommend.WinkRecommendViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import qqcircle.QQCircleSmartMatchMusic.MusicInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "", "musicInfoRsp", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfoRsp;", "onReceive"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initRecommendViewModel$1$1<T>
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.MusicInfoRsp>
{
  WinkEditorFragment$initRecommendViewModel$1$1(WinkEditorFragment.initRecommendViewModel.1 param1, List paramList) {}
  
  public final void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.MusicInfoRsp paramMusicInfoRsp)
  {
    if (paramMusicInfoRsp != null)
    {
      paramBaseRequest = WinkEditorMusicHelper.b(WinkEditorMusicHelper.a(paramMusicInfoRsp.musicListInfo.get()));
      paramString = WinkEditorFragment.e(this.a.a);
      paramMusicInfoRsp = this.b;
      Intrinsics.checkExpressionValueIsNotNull(paramMusicInfoRsp, "it");
      paramString.a(paramMusicInfoRsp, paramBaseRequest);
      paramBaseRequest = WinkEditorFragment.o(this.a.a);
      paramString = WinkEditorFragment.p(this.a.a).b().getValue();
      if (paramString != null)
      {
        paramBaseRequest.a("MqKuaishanEdit", (ArrayList)paramString, 2);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.ByteArray?> /* = java.util.ArrayList<kotlin.ByteArray?> */");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initRecommendViewModel.1.1
 * JD-Core Version:    0.7.0.1
 */