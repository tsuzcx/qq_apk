import com.tencent.biz.qqstory.model.WeatherDataProvider;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;

public class ndr
  implements LbsManager.LbsUpdateListener
{
  public ndr(WeatherDataProvider paramWeatherDataProvider) {}
  
  public void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    SLog.b("WeatherDataProvider", "WeatherLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramBasicLocation != null))
    {
      this.a.a(paramBasicLocation.b, paramBasicLocation.a);
      return;
    }
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndr
 * JD-Core Version:    0.7.0.1
 */