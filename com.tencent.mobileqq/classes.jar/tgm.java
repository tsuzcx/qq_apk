import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;

public class tgm
  implements IMiniMsgUnreadCallback
{
  public void destroy()
  {
    tlo.a("AIOLog", 1, "MiniMsgUser destroy");
  }
  
  public void hide()
  {
    tlo.a("AIOLog", 1, "MiniMsgUser hide");
  }
  
  public void hideUnread()
  {
    tlo.a("AIOLog", 1, "MiniMsgUser hideUnread");
  }
  
  public boolean show(int paramInt)
  {
    tlo.a("AIOLog", 1, "MiniMsgUser show = " + paramInt);
    return false;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle)
  {
    tlo.a("AIOLog", 1, "MiniMsgUser updateOnBackFromMiniAIO");
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    tlo.a("AIOLog", 1, "MiniMsgUser updateUnreadCount i = " + paramInt + ", b = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tgm
 * JD-Core Version:    0.7.0.1
 */