import android.os.Handler;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.model.WeatherDataProvider.WeatherInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo;

public class ojd
  implements DataProvider.DataUpdateListener
{
  public ojd(EditVideoFilterNeo paramEditVideoFilterNeo) {}
  
  public void a(boolean paramBoolean, WeatherDataProvider.WeatherInfo paramWeatherInfo)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramWeatherInfo != null))
    {
      SLog.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramWeatherInfo.a));
      int i = paramWeatherInfo.a;
      EditVideoFilterNeo.a(this.a).post(new oje(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojd
 * JD-Core Version:    0.7.0.1
 */