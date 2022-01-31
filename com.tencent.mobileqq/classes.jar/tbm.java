import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class tbm
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public tbm(WSHomeFragment paramWSHomeFragment) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("launch mini program ");
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      tlo.d("WSHomeFragment", str + ", bundle: " + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbm
 * JD-Core Version:    0.7.0.1
 */