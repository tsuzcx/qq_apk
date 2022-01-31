import android.text.TextUtils;

public class tdq
  extends tcb<tdt>
{
  private long jdField_a_of_type_Long;
  private tey jdField_a_of_type_Tey = new tdr(this);
  protected boolean a;
  
  public tdq()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (tcv)tdc.a(10);
    this.jdField_a_of_type_Long = ((Long)((tcv)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((tcv)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((tcv)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        veg.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new tdt(i, (String)localObject);
        return;
      }
    }
    veg.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public tdt a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (tdt)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    veg.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    tnl localtnl = new tnl(1, paramInt1, paramInt2);
    syr.a().a(localtnl, new tds(this));
  }
  
  protected void a(teu paramteu)
  {
    veg.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      veg.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    tev localtev = (tev)tdc.a(9);
    teu localteu = paramteu;
    if (paramteu == null) {
      localteu = localtev.b();
    }
    if (localteu != null)
    {
      a(localteu.b, localteu.a);
      return;
    }
    localtev.a(this.jdField_a_of_type_Tey);
    localtev.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdq
 * JD-Core Version:    0.7.0.1
 */