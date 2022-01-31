import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;

public class nrf
  extends ProtoUtils.TroopProtocolObserver
{
  public nrf(QQStoryFriendSettingDelegate paramQQStoryFriendSettingDelegate, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = this.a;
      if (!this.b) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte.a(7, bool);
        this.a.a(0, this.a.a.getString(2131435374));
        return;
      }
    }
    ((StoryConfigManager)SuperManager.a(10)).b("story_publish_flag_compress", Boolean.valueOf(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrf
 * JD-Core Version:    0.7.0.1
 */