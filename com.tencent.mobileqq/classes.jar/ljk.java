import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import mqq.os.MqqHandler;

public class ljk
  implements PublicAccountGifListener
{
  public ljk(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void a(HotPicData paramHotPicData)
  {
    this.a.a = paramHotPicData;
    ReadInJoyCommentComponentFragment.a(this.a, null);
    ThreadManager.getUIHandler().post(new ljl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljk
 * JD-Core Version:    0.7.0.1
 */