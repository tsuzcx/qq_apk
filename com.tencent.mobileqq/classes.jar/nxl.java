import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class nxl
  extends QQUIEventReceiver
{
  public nxl(@NonNull QQStoryMemoriesPresenter paramQQStoryMemoriesPresenter)
  {
    super(paramQQStoryMemoriesPresenter);
  }
  
  public void a(@NonNull QQStoryMemoriesPresenter paramQQStoryMemoriesPresenter, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString)))
    {
      SLog.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramUpdateUserInfoEvent);
      paramQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      QQStoryMemoriesPresenter.a(paramQQStoryMemoriesPresenter).d();
      QQStoryMemoriesPresenter.a(paramQQStoryMemoriesPresenter).b();
      QQStoryMemoriesPresenter.a(paramQQStoryMemoriesPresenter).c();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxl
 * JD-Core Version:    0.7.0.1
 */