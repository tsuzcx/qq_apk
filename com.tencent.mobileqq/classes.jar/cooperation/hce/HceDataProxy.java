package cooperation.hce;

import aoor;

public class HceDataProxy
{
  private static final String TAG = "HceDataProxy";
  
  public static void startLocation(String paramString, HceDataProxy.GetLocationListener paramGetLocationListener)
  {
    if (paramGetLocationListener == null) {
      return;
    }
    aoor.a(new HceDataProxy.1(paramString, paramGetLocationListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.hce.HceDataProxy
 * JD-Core Version:    0.7.0.1
 */