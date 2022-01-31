import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class sqw
  implements slx<tap, tca>
{
  sqw(squ paramsqu) {}
  
  public void a(@NonNull tap paramtap, @Nullable tca paramtca, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramtca != null))
    {
      urk.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramtca.b));
      this.a.jdField_a_of_type_JavaLangObject = new sqx(paramtca.b, paramtca.a);
      urk.c("WeatherDataProvider", "update local weather data.");
      paramtap = (spz)sqg.a(10);
      paramtap.b("edit_video_weather_filter_data", Integer.valueOf(paramtca.b));
      paramtap.b("edit_video_weather_desc", paramtca.a);
      squ.a(this.a, System.currentTimeMillis() + 14400000L);
      paramtap.b("edit_video_weather_expiry_time", Long.valueOf(squ.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      urk.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramtap });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqw
 * JD-Core Version:    0.7.0.1
 */