import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.OnFetchUserInfoCallback;
import com.tencent.qphone.base.util.QLog;

public final class nrf
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  public nrf(PlayModeUtils.OnFetchUserInfoCallback paramOnFetchUserInfoCallback, String paramString1, String paramString2) {}
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilPlayModeUtils$OnFetchUserInfoCallback != null)
    {
      boolean bool = paramUpdateUserInfoEvent.errorInfo.isSuccess();
      paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.a;
      if ((bool) && (paramUpdateUserInfoEvent != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals(paramUpdateUserInfoEvent.uid)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("Q.qqstory.player.PlayModeUtils", 2, "[az]PlayModeUtils.fetchUserInfo: ohhh! bad guy!!! require " + this.jdField_a_of_type_JavaLangString + " and the return uid is " + paramUpdateUserInfoEvent.uid);
        }
        paramUpdateUserInfoEvent.uid = this.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.b)) {
          paramUpdateUserInfoEvent.qq = this.b;
        }
        ((UserManager)SuperManager.a(2)).a(paramUpdateUserInfoEvent);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilPlayModeUtils$OnFetchUserInfoCallback.a(bool, paramUpdateUserInfoEvent, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrf
 * JD-Core Version:    0.7.0.1
 */