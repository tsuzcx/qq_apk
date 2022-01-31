import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager.Callback;
import com.tencent.qphone.base.util.QLog;

public class snu
  implements NowHongbaoPushManager.Callback
{
  private snu(Conversation paramConversation) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("now_enter.pendant", 2, "onHideTopView");
    }
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).b();
    }
    Conversation.a(this.a, false);
  }
  
  public boolean a(String paramString)
  {
    QLog.d("Q.recent", 2, "checkCurrentUI onActiveEnable,url:" + paramString + ",but this feature is offline");
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (Conversation.a(this.a) != null)
    {
      Conversation.a(this.a).a(false, paramString2);
      bool = true;
    }
    Conversation.a(this.a, true);
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "onHideFloatView");
    }
    this.a.a(false, null, null);
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "onShowFloatView : imageUrl=" + paramString1 + ",jumpUrl=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return this.a.a(true, paramString1, paramString2);
  }
  
  public void c()
  {
    QLog.d("Q.recent", 2, "checkCurrentUI onActiveDisable,but this feature is offline");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     snu
 * JD-Core Version:    0.7.0.1
 */