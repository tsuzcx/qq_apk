import android.os.Handler;
import com.tencent.biz.qqstory.playmode.child.VidListPlayMode;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.VideoInfoListEvent;

public class nkq
  implements BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback
{
  public nkq(VidListPlayMode paramVidListPlayMode) {}
  
  public void a(BatchGetVideoInfoHandler.VideoInfoListEvent paramVideoInfoListEvent)
  {
    this.a.a.post(new nkr(this, paramVideoInfoListEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkq
 * JD-Core Version:    0.7.0.1
 */