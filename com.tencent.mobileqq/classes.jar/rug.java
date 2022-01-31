import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;

public class rug
  implements Runnable
{
  public rug(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    SpriteCommFunc.a(this.a.a, "receipt_msg", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rug
 * JD-Core Version:    0.7.0.1
 */