import android.os.Handler;
import com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;

public class orr
  extends MessageObserver
{
  public orr(TroopStoryForwardTask paramTroopStoryForwardTask) {}
  
  protected void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    paramStatictisInfo = this.a.a;
    if (paramBoolean) {}
    for (int i = 4;; i = 5)
    {
      paramStatictisInfo.sendEmptyMessage(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orr
 * JD-Core Version:    0.7.0.1
 */