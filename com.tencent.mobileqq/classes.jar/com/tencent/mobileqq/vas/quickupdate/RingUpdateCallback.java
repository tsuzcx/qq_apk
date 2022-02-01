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
    RingUpdateCallback localRingUpdateCallback = sInstance;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("specialRing.");
    localStringBuilder.append(paramInt);
    localRingUpdateCallback.download(localStringBuilder.toString(), paramQuickUpdateListener, paramBoolean);
  }
  
  public static String getName(Context paramContext, int paramInt)
  {
    Object localObject = sInstance;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("specialRing.");
    localStringBuilder.append(paramInt);
    paramContext = ((RingUpdateCallback)localObject).getDir(paramContext, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".json");
    paramContext = FileUtils.readFileContent(new File(((StringBuilder)localObject).toString()));
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
    paramContext = new StringBuilder();
    paramContext.append("getName missing json: ");
    paramContext.append(paramInt);
    QLog.e("RingUpdateCallback", 1, paramContext.toString());
    return null;
  }
  
  public static String getWavPath(Context paramContext, int paramInt)
  {
    Object localObject = sInstance;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("specialRing.");
    localStringBuilder.append(paramInt);
    paramContext = ((RingUpdateCallback)localObject).getDir(paramContext, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".wav");
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean isRingExists(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("specialRing.");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    localObject = sInstance.getDir(paramContext, (String)localObject);
    if (!new File((String)localObject).exists()) {
      return false;
    }
    String[] arrayOfString = new String[3];
    arrayOfString[0] = ".wav";
    arrayOfString[1] = ".json";
    arrayOfString[2] = ".jpg";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramContext = arrayOfString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(paramContext);
      if (!new File((String)localObject, localStringBuilder.toString()).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("missing: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(paramContext);
        QLog.e("RingUpdateCallback", 1, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.RingUpdateCallback
 * JD-Core Version:    0.7.0.1
 */