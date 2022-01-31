import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;

public class tcs
  implements Runnable
{
  public tcs(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void run()
  {
    PhoneUnityBindInfoActivity.a(this.a).g();
    PhoneUnityBindInfoActivity.b(this.a).f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcs
 * JD-Core Version:    0.7.0.1
 */