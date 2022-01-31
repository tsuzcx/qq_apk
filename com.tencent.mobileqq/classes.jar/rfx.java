import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class rfx
  extends QidianBusinessObserver
{
  public rfx(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if (AddFriendVerifyActivity.a(this.a).equals(paramHashMap.uin)) {
        if (AddFriendVerifyActivity.b(this.a) != null)
        {
          str = AddFriendVerifyActivity.b(this.a).getText().toString();
          if ((TextUtils.isEmpty(str)) || (str.equals(AddFriendVerifyActivity.a(this.a)))) {
            AddFriendVerifyActivity.b(this.a).setText(paramHashMap.nickname);
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo not current uin");
      return;
    }
    QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rfx
 * JD-Core Version:    0.7.0.1
 */