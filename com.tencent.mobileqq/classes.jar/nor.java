import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.util.URLUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public final class nor
  extends SimpleJob
{
  public nor(VideoServerInfoManager paramVideoServerInfoManager, String[] paramArrayOfString, int paramInt, TVKPreloader.PreloadItem paramPreloadItem, TVK_ICacheMgr paramTVK_ICacheMgr, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager.a();
    SLog.a("Q.qqstory.player.TVKPreloader", "get url key:%s", paramJobContext);
    if (!TextUtils.isEmpty(paramJobContext)) {
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = URLUtil.a(this.jdField_a_of_type_ArrayOfJavaLangString[0], "authkey", paramJobContext);
    }
    SLog.d("Q.qqstory.player.TVKPreloader", "preloadVideo 1 TVK start pre-load video, preload duration : %d, item : %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem });
    TVKPreloader.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, this.jdField_a_of_type_ArrayOfJavaLangString[0], this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nor
 * JD-Core Version:    0.7.0.1
 */