import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.ProfilePresenterListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class obp
  extends QQUIEventReceiver
{
  public obp(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter)
  {
    super(paramMemoriesProfilePresenter);
  }
  
  public void a(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (TextUtils.equals(paramUpdateUserInfoEvent.jdField_a_of_type_JavaLangString, String.valueOf(paramMemoriesProfilePresenter.hashCode())))
    {
      if ((paramUpdateUserInfoEvent.errorInfo.isSuccess()) && (paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramUpdateUserInfoEvent);
        paramMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramMemoriesProfilePresenter.jdField_a_of_type_JavaLangString = paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (MemoriesProfilePresenter.a(paramMemoriesProfilePresenter) != -1) {
          paramMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = MemoriesProfilePresenter.a(paramMemoriesProfilePresenter);
        }
        if (MemoriesProfilePresenter.b(paramMemoriesProfilePresenter) != -1) {
          paramMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = MemoriesProfilePresenter.b(paramMemoriesProfilePresenter);
        }
        ((FriendListHandler)PlayModeUtils.a().a(1)).c(paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new obq(this, paramMemoriesProfilePresenter), 5, null, false);
      }
      for (;;)
      {
        MemoriesProfilePresenter.a(paramMemoriesProfilePresenter).a(paramUpdateUserInfoEvent.errorInfo.isSuccess());
        return;
        QQToast.a(BaseApplicationImpl.getContext(), 1, "更新用户信息错误: " + paramUpdateUserInfoEvent.errorInfo.getErrorMessage(), 0);
        SLog.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramUpdateUserInfoEvent });
      }
    }
    SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramUpdateUserInfoEvent);
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obp
 * JD-Core Version:    0.7.0.1
 */