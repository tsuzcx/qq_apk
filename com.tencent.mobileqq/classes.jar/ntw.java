import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.atomic.AtomicBoolean;

public class ntw
  implements LegoResponseCallBack
{
  public ntw(StoryDetailPresenter paramStoryDetailPresenter, CommentEntry paramCommentEntry, boolean paramBoolean) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, "网络错误");
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    QQToast.a(BaseApplication.getContext(), 1, "删除失败", 0).a();
    SLog.e("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. errorCode = %d, errorMsg=%s.", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    if (!StoryDetailPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter).get()) {
      StoryDetailPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntw
 * JD-Core Version:    0.7.0.1
 */