import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;

class sfn
  implements Runnable
{
  sfn(sfm paramsfm) {}
  
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
 * Qualified Name:     sfn
 * JD-Core Version:    0.7.0.1
 */