package com.tencent.mobileqq.vas.quickupdate;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class QQLevelIconCallback
  extends BaseUpdateCallback
{
  public static final long BID = 41L;
  private static final String QQLEVEL_ICON_DIR = "qqlevel_icon";
  public static final String SCID_ICON = "qqVipLevel.";
  private static final String TAG = "QQLevelIconCallback";
  public static QQLevelIconCallback sInstance = new QQLevelIconCallback();
  
  public static void downloadQQLevelIcon(int paramInt, QuickUpdateListener paramQuickUpdateListener, boolean paramBoolean)
  {
    sInstance.download("qqVipLevel." + paramInt, paramQuickUpdateListener, paramBoolean);
  }
  
  public static String getName(Context paramContext, int paramInt)
  {
    paramContext = sInstance.getDir(paramContext, "qqVipLevel." + paramInt);
    paramContext = FileUtils.a(new File(paramContext + File.separator + paramInt + ".json"));
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = new JSONObject(paramContext).optString("name", null);
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        QLog.e("QQLevelIconCallback", 1, "getName error", paramContext);
        return null;
      }
    }
    QLog.e("QQLevelIconCallback", 1, "getName missing json: " + paramInt);
    return null;
  }
  
  public static String getQQLevelIconFilePath(Context paramContext, int paramInt)
  {
    paramContext = sInstance.getDir(paramContext, "qqVipLevel." + paramInt);
    return paramContext + File.separator + paramInt + ".wav";
  }
  
  public static boolean isQQLevelIconExists(Context paramContext, int paramInt)
  {
    String str = "qqVipLevel." + paramInt;
    return new File(sInstance.getDir(paramContext, str)).exists();
  }
  
  public long getBID()
  {
    return 41L;
  }
  
  protected String getRootDir()
  {
    return "qqlevel_icon";
  }
  
  protected String getScidPrefix()
  {
    return "qqVipLevel.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.QQLevelIconCallback
 * JD-Core Version:    0.7.0.1
 */