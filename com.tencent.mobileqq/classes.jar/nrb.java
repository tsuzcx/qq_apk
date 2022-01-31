import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.mobileqq.app.QQAppInterface;

public class nrb
  extends QQStoryObserver
{
  public nrb(QQStoryFriendSettingDelegate paramQQStoryFriendSettingDelegate) {}
  
  public void c(boolean paramBoolean)
  {
    QQStoryManager localQQStoryManager = (QQStoryManager)this.a.a.app.getManager(180);
    this.a.a(2, localQQStoryManager.a());
    this.a.a(3, localQQStoryManager.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrb
 * JD-Core Version:    0.7.0.1
 */