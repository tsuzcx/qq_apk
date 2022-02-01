package mqq.app;

import android.content.Context;
import android.os.Bundle;

public class ThirdPushSupportHelper
{
  public static IThirdPushSupport sThirdPushSupport;
  
  public static int getThirdPushType(Context paramContext, Bundle paramBundle)
  {
    int i = 1;
    if (sThirdPushSupport != null) {
      i = sThirdPushSupport.getThirdPushType(paramContext, paramBundle);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.ThirdPushSupportHelper
 * JD-Core Version:    0.7.0.1
 */