package dov.com.qq.im.capture.music;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask.GetMusicInfoCallback;

class QIMMusicConfigManager$2
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StBatchGetMusicInfoRsp>
{
  QIMMusicConfigManager$2(QIMMusicConfigManager paramQIMMusicConfigManager, GetSingleFullMusicInfoTask.GetMusicInfoCallback paramGetMusicInfoCallback) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((!paramBoolean) || (paramStBatchGetMusicInfoRsp.vecMusic.size() == 0)) {
      this.jdField_a_of_type_DovComQqImCaptureControlGetSingleFullMusicInfoTask$GetMusicInfoCallback.a(false, new FlowMusic());
    }
    while (this.jdField_a_of_type_DovComQqImCaptureControlGetSingleFullMusicInfoTask$GetMusicInfoCallback == null) {
      return;
    }
    paramBaseRequest = new FlowMusic((META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(0));
    QLog.i("QIMMusicConfigManager", 1, "getSingleFullMusicInfo from story success flow info:" + paramBaseRequest.toString());
    this.jdField_a_of_type_DovComQqImCaptureControlGetSingleFullMusicInfoTask$GetMusicInfoCallback.a(true, paramBaseRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager.2
 * JD-Core Version:    0.7.0.1
 */