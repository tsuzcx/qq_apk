import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DebugInfo;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.util.URLUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

public class nun
  extends SimpleJob
{
  public nun(VideoViewTVKImpl paramVideoViewTVKImpl, VideoServerInfoManager paramVideoServerInfoManager, PlayModeUtils.DebugInfo paramDebugInfo, String paramString, DownloadUrlManager paramDownloadUrlManager, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.c;
    if (TextUtils.isEmpty(paramJobContext)) {
      return null;
    }
    if (paramJobContext.contains("qqstocdnd"))
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager.a();
      SLog.a("VideoViewTVKImpl", "get url key:%s", paramVarArgs);
      if (TextUtils.isEmpty(paramVarArgs)) {
        break label80;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.c = URLUtil.a(paramJobContext, "authkey", paramVarArgs);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new nup(this));
      return null;
      label80:
      ThreadManager.getUIHandler().post(new nuo(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nun
 * JD-Core Version:    0.7.0.1
 */