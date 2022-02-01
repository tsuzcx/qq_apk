package dov.com.qq.im.aeeditor.module.music;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;

final class AEEditorMusicHelper$4
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StBatchGetMusicInfoRsp>
{
  AEEditorMusicHelper$4(VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    AEQLog.b("AEEditorMusicHelper", "[requestDetailedMusicInfo], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_ComTencentBizRichframeworkNetworkObserverVSDispatchObserver$onVSRspCallBack != null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkNetworkObserverVSDispatchObserver$onVSRspCallBack.onReceive(paramBaseRequest, paramBoolean, paramLong, paramString, paramStBatchGetMusicInfoRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int i = (int)paramLong;
    if (paramBoolean) {
      i = 1000;
    }
    AEBaseDataReporter.a().a(i, l1 - l2 + "", "AEEditorMusicInfo", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.4
 * JD-Core Version:    0.7.0.1
 */