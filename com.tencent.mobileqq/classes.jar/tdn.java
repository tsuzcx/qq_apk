import android.text.TextUtils;

public class tdn
  extends tby<tdq>
{
  private long jdField_a_of_type_Long;
  private tev jdField_a_of_type_Tev = new tdo(this);
  protected boolean a;
  
  public tdn()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (tcs)tcz.a(10);
    this.jdField_a_of_type_Long = ((Long)((tcs)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((tcs)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((tcs)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        ved.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new tdq(i, (String)localObject);
        return;
      }
    }
    ved.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public tdq a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (tdq)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    ved.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    tni localtni = new tni(1, paramInt1, paramInt2);
    syo.a().a(localtni, new tdp(this));
  }
  
  protected void a(ter paramter)
  {
    ved.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      ved.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    tes localtes = (tes)tcz.a(9);
    ter localter = paramter;
    if (paramter == null) {
      localter = localtes.b();
    }
    if (localter != null)
    {
      a(localter.b, localter.a);
      return;
    }
    localtes.a(this.jdField_a_of_type_Tev);
    localtes.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdn
 * JD-Core Version:    0.7.0.1
 */