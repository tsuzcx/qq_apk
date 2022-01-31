import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;

public class owz
  implements oxm
{
  public owz(VideoView paramVideoView) {}
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
    {
      paramArrayOfString2 = paramArrayOfString2[0];
      if ((!TextUtils.isEmpty(VideoView.d(this.a))) && (VideoView.d(this.a).equals(paramArrayOfString1[0])))
      {
        this.a.b(paramArrayOfString2);
        return;
      }
      QLog.d("gifvideo.VideoView", 2, "not current video");
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "urls null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owz
 * JD-Core Version:    0.7.0.1
 */