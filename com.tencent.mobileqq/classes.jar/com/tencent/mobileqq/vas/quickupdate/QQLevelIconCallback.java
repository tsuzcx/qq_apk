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
    QQLevelIconCallback localQQLevelIconCallback = sInstance;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqVipLevel.");
    localStringBuilder.append(paramInt);
    localQQLevelIconCallback.download(localStringBuilder.toString(), paramQuickUpdateListener, paramBoolean);
  }
  
  public static String getName(Context paramContext, int paramInt)
  {
    Object localObject = sInstance;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqVipLevel.");
    localStringBuilder.append(paramInt);
    paramContext = ((QQLevelIconCallback)localObject).getDir(paramContext, localStringBuilder.toString());
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
        QLog.e("QQLevelIconCallback", 1, "getName error", paramContext);
        return null;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("getName missing json: ");
    paramContext.append(paramInt);
    QLog.e("QQLevelIconCallback", 1, paramContext.toString());
    return null;
  }
  
  public static String getQQLevelIconFilePath(Context paramContext, int paramInt)
  {
    Object localObject = sInstance;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqVipLevel.");
    localStringBuilder.append(paramInt);
    paramContext = ((QQLevelIconCallback)localObject).getDir(paramContext, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".wav");
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean isQQLevelIconExists(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qqVipLevel.");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    return new File(sInstance.getDir(paramContext, (String)localObject)).exists();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.QQLevelIconCallback
 * JD-Core Version:    0.7.0.1
 */