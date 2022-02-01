package dov.com.qq.im.aeeditor.module.music;

import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;

final class AEEditorMusicHelper$3
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StSmartMatchMusicRsp>
{
  AEEditorMusicHelper$3(VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    AEQLog.b("AEEditorMusicHelper", "[requestRecommendedMusicList], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_ComTencentBizRichframeworkNetworkObserverVSDispatchObserver$onVSRspCallBack != null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkNetworkObserverVSDispatchObserver$onVSRspCallBack.onReceive(paramBaseRequest, paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int i = (int)paramLong;
    if (paramBoolean) {
      i = 1000;
    }
    AEBaseDataReporter.a().a(i, l1 - l2 + "", "AEEditorMusicList", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.3
 * JD-Core Version:    0.7.0.1
 */