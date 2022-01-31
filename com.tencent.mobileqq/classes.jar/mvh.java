import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import mqq.os.MqqHandler;

public class mvh
  implements Runnable
{
  public mvh(ServiceAccountFolderActivity paramServiceAccountFolderActivity) {}
  
  public void run()
  {
    ServiceAccountFolderManager localServiceAccountFolderManager = ServiceAccountFolderManager.a();
    ServiceAccountFolderActivity.a(this.a, localServiceAccountFolderManager.a());
    ServiceAccountFolderActivity.a(this.a).sendEmptyMessage(101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvh
 * JD-Core Version:    0.7.0.1
 */