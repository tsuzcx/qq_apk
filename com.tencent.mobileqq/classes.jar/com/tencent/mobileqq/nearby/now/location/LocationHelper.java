package com.tencent.mobileqq.nearby.now.location;

import aesn;
import aeth;
import android.util.JsonReader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.LogUtil;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class LocationHelper
{
  private static String a(JsonReader paramJsonReader)
  {
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      if (paramJsonReader.nextName().equals("address_component")) {
        return b(paramJsonReader);
      }
      paramJsonReader.skipValue();
    }
    paramJsonReader.endObject();
    return null;
  }
  
  public static String a(InputStream paramInputStream)
  {
    paramInputStream = new JsonReader(new InputStreamReader(paramInputStream));
    try
    {
      paramInputStream.beginObject();
      while (paramInputStream.hasNext())
      {
        String str = paramInputStream.nextName();
        if ("status".equals(str))
        {
          double d = paramInputStream.nextDouble();
          if (d != 0.0D)
          {
            LogUtil.e("LocationHelper", "parseJson: status code:" + d);
            return null;
          }
        }
        else
        {
          if ("result".equals(str))
          {
            str = a(paramInputStream);
            return str;
          }
          paramInputStream.skipValue();
        }
      }
    }
    finally
    {
      paramInputStream.close();
    }
    paramInputStream.close();
    LogUtil.i("LocationHelper", "parseJson: not found return null!");
    return null;
  }
  
  public static void a(double paramDouble1, double paramDouble2, aeth paramaeth)
  {
    String str = String.format("http://apis.map.qq.com/ws/geocoder/v1/?location=%s&key=HPYBZ-EZUKU-RYOVB-4HVZR-KQHXO-4AB6C&get_poi=0", new Object[] { paramDouble1 + "," + paramDouble2 });
    LogUtil.i("LocationHelper", "getCityByLatLng: url:" + str);
    try
    {
      URL localURL = new URL(str);
      ThreadManager.getSubThreadHandler().post(new aesn(localURL, paramaeth));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      LogUtil.e("LocationHelper", "getCityByLatLng: url convert error!" + str);
      paramaeth.a();
    }
  }
  
  private static String b(JsonReader paramJsonReader)
  {
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      if (paramJsonReader.nextName().equals("city")) {
        return paramJsonReader.nextString();
      }
      paramJsonReader.skipValue();
    }
    paramJsonReader.endObject();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.location.LocationHelper
 * JD-Core Version:    0.7.0.1
 */