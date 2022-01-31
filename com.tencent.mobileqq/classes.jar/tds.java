import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class tds
  implements syt<tnl, tow>
{
  tds(tdq paramtdq) {}
  
  public void a(@NonNull tnl paramtnl, @Nullable tow paramtow, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramtow != null))
    {
      veg.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramtow.b));
      this.a.jdField_a_of_type_JavaLangObject = new tdt(paramtow.b, paramtow.a);
      veg.c("WeatherDataProvider", "update local weather data.");
      paramtnl = (tcv)tdc.a(10);
      paramtnl.b("edit_video_weather_filter_data", Integer.valueOf(paramtow.b));
      paramtnl.b("edit_video_weather_desc", paramtow.a);
      tdq.a(this.a, System.currentTimeMillis() + 14400000L);
      paramtnl.b("edit_video_weather_expiry_time", Long.valueOf(tdq.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      veg.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramtnl });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tds
 * JD-Core Version:    0.7.0.1
 */