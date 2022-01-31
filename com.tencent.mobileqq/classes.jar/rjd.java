import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class rjd
  implements Runnable
{
  public rjd(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void run()
  {
    int i = AddFriendVerifyActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
    Object localObject = "{\"m\":0,\"source\":\"joinTroop\", \"gc\":" + this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.b + "}";
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.sendEmptyMessage(1);
    for (;;)
    {
      try
      {
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, true);
        AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, "");
        String str = TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app.getCurrentAccountUin(), "http://admin.qun.qq.com/cgi-bin/qun_admin/upload_msg_img", this.jdField_a_of_type_JavaLangString, (String)localObject, "", LoginHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app), TroopNoticeJsHandler.b);
        if (i != AddFriendVerifyActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.w("AddFriendVerifyActivity", 2, "uploadImage task cancelled.");
          return;
        }
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, false);
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          localObject = HttpUtil.b(str);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        localObject = new JSONObject((String)localObject);
        i = ((JSONObject)localObject).optInt("ec", -1);
        if (i != 0) {
          continue;
        }
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, ((JSONObject)localObject).optLong("gc"));
        AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, ((JSONObject)localObject).optInt("fileid"));
        AddFriendVerifyActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, ((JSONObject)localObject).optString("md5"));
        AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, ((JSONObject)localObject).optString("url"));
      }
      catch (InterruptedException localInterruptedException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage exception:" + localInterruptedException.getMessage());
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.sendEmptyMessage(3);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage error.");
        continue;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage json exception:" + localJSONException.getMessage());
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.sendEmptyMessage(2);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.sendEmptyMessage(3);
      if (QLog.isColorLevel()) {
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage error. ec:" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rjd
 * JD-Core Version:    0.7.0.1
 */