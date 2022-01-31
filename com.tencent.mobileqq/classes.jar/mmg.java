import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class mmg
  implements Runnable
{
  mmg(mmf parammmf) {}
  
  public void run()
  {
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)BaseApplicationImpl.getApplication().getRuntime().getManager(55);
    mmf.a(this.a, localPublicAccountDataManager.a(Long.valueOf(mmf.a(this.a))));
    if ((!mmf.a(this.a)) && (mmf.b(this.a))) {
      mmf.b(this.a, true);
    }
    ThreadManager.getUIHandler().post(new mmh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmg
 * JD-Core Version:    0.7.0.1
 */