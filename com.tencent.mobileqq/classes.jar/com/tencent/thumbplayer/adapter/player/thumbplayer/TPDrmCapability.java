package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPThreadUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

public class TPDrmCapability
{
  private static final String DRM_KEY = "DRM_CAP_LIST";
  private static final String DRM_SP_NAME = "DRM_CAP";
  private static final String TAG = "TPDrmCapability";
  private static int[] capArray = new int[0];
  
  private static void capRead(HashSet<String> paramHashSet)
  {
    if (paramHashSet != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramHashSet.size() > 0)
        {
          paramHashSet = paramHashSet.toArray();
          capArray = new int[paramHashSet.length];
          i = 0;
          if (i < paramHashSet.length) {
            if ((paramHashSet[i] instanceof String)) {
              capArray[i] = Integer.parseInt((String)paramHashSet[i]);
            } else {
              capArray[i] = -1;
            }
          }
        }
      }
      finally {}
      TPLogUtil.i("TPDrmCapability", "TPDrmCapability, read sp ret:" + Arrays.toString(capArray));
      return;
      i += 1;
    }
  }
  
  public static int[] getDRMCapabilities()
  {
    return capArray;
  }
  
  public static void init(Context paramContext)
  {
    TPLogUtil.i("TPDrmCapability", "TPDrmCapability, init");
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return;
    }
    TPLogUtil.i("TPDrmCapability", "TPDrmCapability, read sp.");
    paramContext = paramContext.getSharedPreferences("DRM_CAP", 0);
    capRead((HashSet)paramContext.getStringSet("DRM_CAP_LIST", new HashSet()));
    TPThreadUtil.getScheduledExecutorServiceInstance().execute(new TPDrmCapability.1(paramContext));
  }
  
  public static boolean isDRMSupport(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = capArray;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability
 * JD-Core Version:    0.7.0.1
 */