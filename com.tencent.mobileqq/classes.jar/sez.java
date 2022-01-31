import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.redtouch.VipBannerInfo;

public class sez
  extends GameCenterObserver
{
  public sez(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt);
    if ((paramBoolean1) && (paramInt != 2) && (Conversation.b(this.a))) {
      VipBannerInfo.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sez
 * JD-Core Version:    0.7.0.1
 */