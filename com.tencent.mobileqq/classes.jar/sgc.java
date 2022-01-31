import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager.Callback;
import com.tencent.qphone.base.util.QLog;

public class sgc
  implements NowHongbaoPushManager.Callback
{
  private sgc(Conversation paramConversation) {}
  
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
    boolean bool3 = false;
    if ((Conversation.a(this.a) != null) && (Conversation.a(this.a).a())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("now_enter.pendant", 2, "onShowTopView, isNowEntranceShow=" + bool1 + ", url=" + paramString);
      }
      boolean bool2 = bool3;
      if (Conversation.a(this.a) != null)
      {
        bool2 = bool3;
        if (bool1)
        {
          Conversation.a(this.a).b(false);
          bool2 = true;
        }
      }
      Conversation.a(this.a, true);
      return bool2;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "onShowFloatView : imageUrl=" + paramString1 + ",jumpUrl=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return this.a.a(true, paramString1, paramString2);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "onHideFloatView");
    }
    this.a.a(false, null, null);
  }
  
  public boolean b(String paramString)
  {
    QLog.d("Q.recent", 2, "checkCurrentUI onActiveEnable,url:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      c();
    }
    do
    {
      return false;
      Conversation.b(this.a, true);
      Conversation.a(this.a, paramString);
    } while (Conversation.a(this.a) == null);
    Conversation.a(this.a).a(paramString);
    paramString = (NowEnterManager)this.a.a.getManager(264);
    if (paramString != null) {
      paramString.a();
    }
    return true;
  }
  
  public void c()
  {
    QLog.d("Q.recent", 2, "checkCurrentUI onActiveDisable");
    Conversation.b(this.a, false);
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgc
 * JD-Core Version:    0.7.0.1
 */