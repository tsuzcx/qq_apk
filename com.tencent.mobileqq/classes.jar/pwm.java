import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pts.nativemodule.IPTSNavigateTo;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class pwm
  implements IPTSNavigateTo
{
  private final String a = "PTSNavigateToModule";
  
  public void navigateTo(String paramString)
  {
    QLog.i("PTSNavigateToModule", 1, "[navigateTo], url = " + paramString);
    paramString = Pattern.compile("\\/").split(paramString);
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[(paramString.length - 1)];
      Intent localIntent = new Intent();
      localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppName", paramString);
      PublicFragmentActivity.a(BaseActivity.sTopActivity, localIntent, PTSFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pwm
 * JD-Core Version:    0.7.0.1
 */