import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.playmode.child.CommentPlayMode;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class nhv
  extends QQUIEventReceiver
{
  public nhv(@NonNull CommentPlayMode paramCommentPlayMode)
  {
    super(paramCommentPlayMode);
  }
  
  public void a(@NonNull CommentPlayMode paramCommentPlayMode, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)) {
      CommentPlayMode.a(paramCommentPlayMode, paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
    }
    SLog.b(this.TAG, "UpdateUserInfoEventReceiver. ", paramUpdateUserInfoEvent);
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhv
 * JD-Core Version:    0.7.0.1
 */