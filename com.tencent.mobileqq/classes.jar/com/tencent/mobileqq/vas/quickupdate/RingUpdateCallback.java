package com.tencent.mobileqq.vas.quickupdate;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class RingUpdateCallback
  extends BaseUpdateCallback
{
  public static final long BID = 37L;
  private static final String RING_DIR = "ring";
  private static final String SCID_RING = "specialRing.";
  private static final String TAG = "RingUpdateCallback";
  public static RingUpdateCallback sInstance = new RingUpdateCallback();
  
  public static void downloadRing(int paramInt, QuickUpdateListener paramQuickUpdateListener, boolean paramBoolean)
  {
    sInstance.download("specialRing." + paramInt, paramQuickUpdateListener, paramBoolean);
  }
  
  public static String getName(Context paramContext, int paramInt)
  {
    paramContext = sInstance.getDir(paramContext, "specialRing." + paramInt);
    paramContext = FileUtils.a(new File(paramContext + File.separator + paramInt + ".json"));
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = new JSONObject(paramContext).optString("name", null);
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        QLog.e("RingUpdateCallback", 1, "getName error", paramContext);
        return null;
      }
    }
    QLog.e("RingUpdateCallback", 1, "getName missing json: " + paramInt);
    return null;
  }
  
  public static String getWavPath(Context paramContext, int paramInt)
  {
    paramContext = sInstance.getDir(paramContext, "specialRing." + paramInt);
    return paramContext + File.separator + paramInt + ".wav";
  }
  
  public static boolean isRingExists(Context paramContext, int paramInt)
  {
    Object localObject = "specialRing." + paramInt;
    paramContext = sInstance.getDir(paramContext, (String)localObject);
    if (!new File(paramContext).exists()) {
      return false;
    }
    localObject = new String[3];
    localObject[0] = ".wav";
    localObject[1] = ".json";
    localObject[2] = ".jpg";
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = localObject[i];
      if (!new File(paramContext, paramInt + str).exists())
      {
        QLog.e("RingUpdateCallback", 1, "missing: " + paramInt + str);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public long getBID()
  {
    return 37L;
  }
  
  protected String getRootDir()
  {
    return "ring";
  }
  
  protected String getScidPrefix()
  {
    return "specialRing.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.RingUpdateCallback
 * JD-Core Version:    0.7.0.1
 */