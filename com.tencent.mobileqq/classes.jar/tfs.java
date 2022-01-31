import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;

public class tfs
  implements Runnable
{
  public tfs(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void run()
  {
    PhoneUnityBindInfoActivity.a(this.a).g();
    PhoneUnityBindInfoActivity.b(this.a).f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfs
 * JD-Core Version:    0.7.0.1
 */