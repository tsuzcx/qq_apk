import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.mobileqq.app.QQAppInterface;

public class npq
  extends ProtoUtils.TroopProtocolObserver
{
  public npq(QQStoryFriendSettingDelegate paramQQStoryFriendSettingDelegate, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = this.a;
      if (!this.b) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte.a(3, bool);
        this.a.a(0, this.a.a.getString(2131435357));
        return;
      }
    }
    ((QQStoryManager)this.a.a.app.getManager(180)).b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npq
 * JD-Core Version:    0.7.0.1
 */