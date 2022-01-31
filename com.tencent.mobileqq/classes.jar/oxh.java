import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import org.json.JSONException;
import org.json.JSONObject;

public class oxh
  implements TVK_IMediaPlayer.OnDownloadCallbackListener
{
  public oxh(VideoView paramVideoView) {}
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString.getInt("callBackType");
      int i = paramString.getInt("fileSize");
      this.a.setFileSize(i);
      return;
    }
    catch (JSONException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxh
 * JD-Core Version:    0.7.0.1
 */