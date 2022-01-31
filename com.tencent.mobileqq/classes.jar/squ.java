import android.text.TextUtils;

public class squ
  extends spf<sqx>
{
  private long jdField_a_of_type_Long;
  private ssc jdField_a_of_type_Ssc = new sqv(this);
  protected boolean a;
  
  public squ()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (spz)sqg.a(10);
    this.jdField_a_of_type_Long = ((Long)((spz)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((spz)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((spz)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        urk.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new sqx(i, (String)localObject);
        return;
      }
    }
    urk.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public sqx a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (sqx)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    urk.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    tap localtap = new tap(1, paramInt1, paramInt2);
    slv.a().a(localtap, new sqw(this));
  }
  
  protected void a(sry paramsry)
  {
    urk.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      urk.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    srz localsrz = (srz)sqg.a(9);
    sry localsry = paramsry;
    if (paramsry == null) {
      localsry = localsrz.b();
    }
    if (localsry != null)
    {
      a(localsry.b, localsry.a);
      return;
    }
    localsrz.a(this.jdField_a_of_type_Ssc);
    localsrz.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     squ
 * JD-Core Version:    0.7.0.1
 */