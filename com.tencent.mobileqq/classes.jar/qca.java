import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;

public class qca
  implements qcj
{
  public qca(VideoView paramVideoView) {}
  
  public void a(String[] paramArrayOfString1, String[] arg2)
  {
    if ((??? != null) && (???.length > 0) && (paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      String str = ???[0];
      synchronized (this.a)
      {
        if ((!TextUtils.isEmpty(VideoView.access$3200(this.a))) && (VideoView.access$3200(this.a).equals(paramArrayOfString1[0])))
        {
          this.a.openVideoByUrl(str);
          return;
        }
        QLog.d("gifvideo.VideoView", 2, "not current video");
      }
    }
    QLog.d("gifvideo.VideoView", 2, "urls null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qca
 * JD-Core Version:    0.7.0.1
 */