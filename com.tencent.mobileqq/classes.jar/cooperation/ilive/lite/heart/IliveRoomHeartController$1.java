package cooperation.ilive.lite.heart;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.qphone.base.util.QLog;

class IliveRoomHeartController$1
  implements Runnable
{
  IliveRoomHeartController$1(IliveRoomHeartController paramIliveRoomHeartController) {}
  
  public void run()
  {
    if ((IliveRoomHeartController.a(this.this$0) != 0L) && (IliveRoomHeartController.b(this.this$0)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = IliveRoomHeartController.a(this.this$0);
      IliveRoomHeartController.a(this.this$0, false, false, l1 - l2);
      ThreadCenter.postDefaultUITask(this, IliveRoomHeartController.d(this.this$0));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("heartBeatRunnable mEnterPageTime == 0 , roomId = ");
    localStringBuilder.append(IliveRoomHeartController.c(this.this$0));
    localStringBuilder.append(" isHeartReportEnable = ");
    localStringBuilder.append(IliveRoomHeartController.b(this.this$0));
    QLog.i("IliveRoomHeartController", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.heart.IliveRoomHeartController.1
 * JD-Core Version:    0.7.0.1
 */