package cooperation.qqreader.host;

import android.content.Intent;
import android.os.Bundle;

public class ChannelIdHelper
{
  private static String a = "-1";
  
  public static String getChannelId()
  {
    return a;
  }
  
  public static void initChannelId(Intent paramIntent)
  {
    if (("-1".equals(a)) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("ChannelID");
      if (paramIntent != null) {
        a = paramIntent;
      }
    }
  }
  
  public static boolean isFromKandian()
  {
    return "100081".equals(a);
  }
  
  public static boolean isFromLeba()
  {
    return "100020".equals(a);
  }
  
  public static boolean isFromUnknown()
  {
    return "-1".equals(a);
  }
  
  public static void setChannelId(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.hasExtra("ChannelID")))
    {
      paramIntent = paramIntent.getStringExtra("ChannelID");
      if ((paramIntent != null) && (!"-1".equals(paramIntent))) {
        a = paramIntent;
      }
    }
  }
  
  public static void setChannelId(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("ChannelID");
      if ((paramBundle != null) && (!"-1".equals(paramBundle))) {
        a = paramBundle;
      }
    }
  }
  
  public static void setChannelId(String paramString)
  {
    a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.ChannelIdHelper
 * JD-Core Version:    0.7.0.1
 */