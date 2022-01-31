import android.content.SharedPreferences;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.common.app.AppInterface;
import mqq.app.MobileQQ;

public class syn
{
  public static String a(QQUserUIItem paramQQUserUIItem)
  {
    paramQQUserUIItem = tsu.a();
    return paramQQUserUIItem.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQUserUIItem.getCurrentAccountUin(), 0).getString("key_story_qim_online_icon_url", null);
  }
  
  public static String b(QQUserUIItem paramQQUserUIItem)
  {
    paramQQUserUIItem = tsu.a();
    return paramQQUserUIItem.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQUserUIItem.getCurrentAccountUin(), 0).getString("profile_card_qim_online_url", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syn
 * JD-Core Version:    0.7.0.1
 */