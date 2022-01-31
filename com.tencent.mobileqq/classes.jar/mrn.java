import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import mqq.os.MqqHandler;

public class mrn
  implements Runnable
{
  public mrn(ServiceAccountFolderActivity paramServiceAccountFolderActivity) {}
  
  public void run()
  {
    ServiceAccountFolderManager localServiceAccountFolderManager = ServiceAccountFolderManager.a();
    ServiceAccountFolderActivity.a(this.a, localServiceAccountFolderManager.a());
    ServiceAccountFolderActivity.a(this.a).sendEmptyMessage(101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrn
 * JD-Core Version:    0.7.0.1
 */