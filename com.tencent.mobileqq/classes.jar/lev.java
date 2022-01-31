import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class lev
  implements Runnable
{
  public lev(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    if (this.a.app != null)
    {
      QQMessageFacade localQQMessageFacade = this.a.app.a();
      if (localQQMessageFacade != null)
      {
        int i = localQQMessageFacade.b();
        ReadInJoyChannelActivity.a(this.a, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lev
 * JD-Core Version:    0.7.0.1
 */