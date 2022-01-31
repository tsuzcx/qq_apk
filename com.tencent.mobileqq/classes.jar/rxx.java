import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;

class rxx
  implements Runnable
{
  rxx(rxw paramrxw) {}
  
  public void run()
  {
    if (this.a.a.b)
    {
      this.a.a.b = false;
      MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.a.a.app.getManager(91);
      if (localMessageRoamManager != null) {
        localMessageRoamManager.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxx
 * JD-Core Version:    0.7.0.1
 */