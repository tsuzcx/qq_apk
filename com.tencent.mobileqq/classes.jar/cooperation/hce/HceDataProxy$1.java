package cooperation.hce;

import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

final class HceDataProxy$1
  extends LbsManagerService.OnLocationChangeListener
{
  HceDataProxy$1(String paramString, HceDataProxy.GetLocationListener paramGetLocationListener)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      this.val$li.onLocationFinish(paramInt, paramSosoLbsInfo.mLocation.city, paramSosoLbsInfo.mLocation.cityCode);
      return;
    }
    this.val$li.onLocationFinish(-1, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.hce.HceDataProxy.1
 * JD-Core Version:    0.7.0.1
 */