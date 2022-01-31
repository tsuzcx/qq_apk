import android.os.Bundle;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class soy
  extends GameCenterObserver
{
  public soy(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.post(new soz(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     soy
 * JD-Core Version:    0.7.0.1
 */