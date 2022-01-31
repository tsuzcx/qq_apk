import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.WeatherDataProvider;
import com.tencent.biz.qqstory.model.WeatherDataProvider.WeatherInfo;
import com.tencent.biz.qqstory.network.request.GetWeatherRequest;
import com.tencent.biz.qqstory.network.response.GetWeatherResponse;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nch
  implements CmdTaskManger.CommandCallback
{
  public nch(WeatherDataProvider paramWeatherDataProvider) {}
  
  public void a(@NonNull GetWeatherRequest paramGetWeatherRequest, @Nullable GetWeatherResponse paramGetWeatherResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramGetWeatherResponse != null))
    {
      SLog.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramGetWeatherResponse.b));
      this.a.jdField_a_of_type_JavaLangObject = new WeatherDataProvider.WeatherInfo(paramGetWeatherResponse.b);
      SLog.c("WeatherDataProvider", "update local weather data.");
      paramGetWeatherRequest = (StoryConfigManager)SuperManager.a(10);
      paramGetWeatherRequest.b("edit_video_weather_filter_data", Integer.valueOf(paramGetWeatherResponse.b));
      paramGetWeatherRequest.b("edit_video_weather_expiry_time", Long.valueOf(System.currentTimeMillis() + 14400000L));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      SLog.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramGetWeatherRequest });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nch
 * JD-Core Version:    0.7.0.1
 */