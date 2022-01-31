import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

class lyb
  implements Runnable
{
  lyb(lya paramlya) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.a.app.getManager(12);
    if ((localWebProcessManager != null) && (localWebProcessManager.d()))
    {
      localWebProcessManager.a(-1, null);
      if (QLog.isColorLevel()) {
        QLog.d("allentest", 2, "sbbbb");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyb
 * JD-Core Version:    0.7.0.1
 */