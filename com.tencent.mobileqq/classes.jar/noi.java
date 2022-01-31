import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnDownloadListener;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class noi
  implements TVK_IMediaPlayer.OnDownloadCallbackListener
{
  public noi(VideoViewTVKImpl paramVideoViewTVKImpl, String paramString) {}
  
  public void OnDownloadCallback(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.a != null) {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.getInt("callBackType");
        if (QLog.isColorLevel()) {
          QLog.d("VideoViewTVKImpl", 2, "OnDownloadCallback callBackType=" + i);
        }
        if (i == 2)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.b))
          {
            i = paramString.getInt("offset");
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.c, new File(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.b), i);
          }
        }
        else if (i == 7)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.b)) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoViewTVKImpl", 2, "OnDownloadCallback success , vid = " + this.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.c, new File(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.b));
        }
      }
      catch (JSONException paramString)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("VideoViewTVKImpl", 2, "OnDownloadCallback JSONException=" + paramString.getMessage());
          return;
          if ((i == 4) || (i == 5))
          {
            i = paramString.getInt("errorCode");
            if (QLog.isColorLevel()) {
              QLog.d("VideoViewTVKImpl", 2, "OnDownloadCallback errorCode=" + i);
            }
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.c, i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noi
 * JD-Core Version:    0.7.0.1
 */