import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class tgv
  extends LbsManager.OnLocationListener
{
  public tgv(NearbyActivity paramNearbyActivity, String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startLocation end, errCode=").append(paramInt).append(" lbsInfo=").append(paramSosoLbsInfo).append(", info.location=");
      if (paramSosoLbsInfo == null) {
        break label75;
      }
    }
    label75:
    for (SosoInterface.SosoLocation localSosoLocation = paramSosoLbsInfo.a;; localSosoLocation = null)
    {
      QLog.d("nearby.heart_beat", 2, localSosoLocation);
      this.a.a.a(1, paramSosoLbsInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgv
 * JD-Core Version:    0.7.0.1
 */