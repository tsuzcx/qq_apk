import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;

public class okp
  implements Runnable
{
  public okp(EditVideoPlayer paramEditVideoPlayer, int paramInt) {}
  
  public void run()
  {
    SLog.a("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.jdField_a_of_type_Int));
    VideoSourceHelper.nativeSetPlayMode(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okp
 * JD-Core Version:    0.7.0.1
 */