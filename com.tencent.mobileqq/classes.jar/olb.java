import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class olb
{
  public static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, olj paramolj)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    ubb.a(paramActivity);
    int i = paramAdvertisementInfo.clickPos;
    boolean bool = oli.a(paramAdvertisementInfo, paramActivity, paramolj);
    if (bool)
    {
      paramInt1 = nxw.T;
      paramAdvertisementInfo.clickPos = i;
    }
    for (;;)
    {
      olm.a(bool, paramActivity, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olb
 * JD-Core Version:    0.7.0.1
 */