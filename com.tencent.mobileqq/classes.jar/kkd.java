import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

public class kkd
  extends MessageObserver
{
  public kkd(TroopRedTouchHandler paramTroopRedTouchHandler) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (105 == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "mGetRedPointPushObserver");
      }
      this.a.a(105, true, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kkd
 * JD-Core Version:    0.7.0.1
 */