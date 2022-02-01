import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_action.download_action.AdDownloadUtil.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class olc
{
  public static void a(orb paramorb, old paramold)
  {
    if (paramorb == null)
    {
      paramold.a(false);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new AdDownloadUtil.1(paramorb, paramold));
  }
  
  public static boolean a(String paramString)
  {
    return nxw.a(BaseApplicationImpl.getContext(), paramString);
  }
  
  public static boolean a(orb paramorb)
  {
    if ((paramorb == null) || (TextUtils.isEmpty(paramorb.d))) {
      return false;
    }
    return a(paramorb.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olc
 * JD-Core Version:    0.7.0.1
 */