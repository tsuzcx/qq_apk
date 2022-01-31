import android.os.Handler;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.VideoInfoListEvent;

public class njc
  implements BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback
{
  public njc(NewFriendsPlayMode paramNewFriendsPlayMode) {}
  
  public void a(BatchGetVideoInfoHandler.VideoInfoListEvent paramVideoInfoListEvent)
  {
    this.a.a.post(new njd(this, paramVideoInfoListEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njc
 * JD-Core Version:    0.7.0.1
 */