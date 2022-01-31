package cooperation.hce;

import akfx;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

final class HceDataProxy$1
  extends akfx
{
  HceDataProxy$1(String paramString, HceDataProxy.GetLocationListener paramGetLocationListener)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.val$li.onLocationFinish(paramInt, paramSosoLbsInfo.a.e, paramSosoLbsInfo.a.f);
      return;
    }
    this.val$li.onLocationFinish(-1, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.hce.HceDataProxy.1
 * JD-Core Version:    0.7.0.1
 */