import android.os.Handler;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler.VideoInfoListEvent;

public class now
  implements BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback
{
  public now(NewFriendsPlayMode paramNewFriendsPlayMode) {}
  
  public void a(BatchGetVideoInfoHandler.VideoInfoListEvent paramVideoInfoListEvent)
  {
    this.a.a.post(new nox(this, paramVideoInfoListEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     now
 * JD-Core Version:    0.7.0.1
 */