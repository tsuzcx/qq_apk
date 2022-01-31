import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class tdp
  implements syq<tni, tot>
{
  tdp(tdn paramtdn) {}
  
  public void a(@NonNull tni paramtni, @Nullable tot paramtot, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramtot != null))
    {
      ved.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramtot.b));
      this.a.jdField_a_of_type_JavaLangObject = new tdq(paramtot.b, paramtot.a);
      ved.c("WeatherDataProvider", "update local weather data.");
      paramtni = (tcs)tcz.a(10);
      paramtni.b("edit_video_weather_filter_data", Integer.valueOf(paramtot.b));
      paramtni.b("edit_video_weather_desc", paramtot.a);
      tdn.a(this.a, System.currentTimeMillis() + 14400000L);
      paramtni.b("edit_video_weather_expiry_time", Long.valueOf(tdn.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      ved.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramtni });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdp
 * JD-Core Version:    0.7.0.1
 */