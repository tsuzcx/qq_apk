import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.redtouch.VipBannerInfo;

public class shx
  extends GameCenterObserver
{
  public shx(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt);
    if ((paramBoolean1) && (paramInt != 2) && (Conversation.b(this.a))) {
      VipBannerInfo.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shx
 * JD-Core Version:    0.7.0.1
 */