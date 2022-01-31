import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class mrf
  implements Runnable
{
  mrf(mre parammre) {}
  
  public void run()
  {
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)BaseApplicationImpl.getApplication().getRuntime().getManager(55);
    mre.a(this.a, localPublicAccountDataManager.a(Long.valueOf(mre.a(this.a))));
    if ((!mre.a(this.a)) && (mre.b(this.a))) {
      mre.b(this.a, true);
    }
    ThreadManager.getUIHandler().post(new mrg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrf
 * JD-Core Version:    0.7.0.1
 */