import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;

public class plp
  implements rwj
{
  public plp(VideoView paramVideoView) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.d("gifvideo.VideoView", 1, "install success");
      VideoView.access$000(this.a, 2);
      VideoView.access$100(this.a);
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "install fail");
    VideoView.access$000(this.a, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     plp
 * JD-Core Version:    0.7.0.1
 */