import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.playmode.child.CommentPlayMode;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class nnr
  extends QQUIEventReceiver
{
  public nnr(@NonNull CommentPlayMode paramCommentPlayMode)
  {
    super(paramCommentPlayMode);
  }
  
  public void a(@NonNull CommentPlayMode paramCommentPlayMode, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent.errorInfo.isSuccess()) && (paramUpdateUserInfoEvent.a != null)) {
      CommentPlayMode.a(paramCommentPlayMode, paramUpdateUserInfoEvent.a);
    }
    SLog.b(this.TAG, "UpdateUserInfoEventReceiver. ", paramUpdateUserInfoEvent);
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnr
 * JD-Core Version:    0.7.0.1
 */