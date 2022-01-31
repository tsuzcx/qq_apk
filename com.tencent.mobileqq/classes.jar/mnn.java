import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class mnn
  implements Runnable
{
  mnn(mnm parammnm) {}
  
  public void run()
  {
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)BaseApplicationImpl.getApplication().getRuntime().getManager(55);
    mnm.a(this.a, localPublicAccountDataManager.a(Long.valueOf(mnm.a(this.a))));
    if ((!mnm.a(this.a)) && (mnm.b(this.a))) {
      mnm.b(this.a, true);
    }
    ThreadManager.getUIHandler().post(new mno(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnn
 * JD-Core Version:    0.7.0.1
 */