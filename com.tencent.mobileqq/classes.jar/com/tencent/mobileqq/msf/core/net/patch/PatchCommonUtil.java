package com.tencent.mobileqq.msf.core.net.patch;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class PatchCommonUtil
{
  public static final String TAG_PATCH_LOG = "PatchLogTag";
  
  public static String getPatchDirPath(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (TextUtils.isEmpty(paramContext)) {
      return "/data/data/com.tencent.mobileqq/files/hotpatch";
    }
    paramContext = new StringBuilder(paramContext);
    paramContext.append(File.separator);
    paramContext.append("hotpatch");
    return paramContext.toString();
  }
  
  public static String getPatchPath(String paramString)
  {
    Object localObject = getPatchDirPath(BaseApplication.getContext());
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    localObject = new StringBuilder((String)localObject);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean isArtGeN()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean isArtGeO()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static boolean isArtLM()
  {
    return (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT <= 23);
  }
  
  public static boolean isDalvik()
  {
    return Build.VERSION.SDK_INT <= 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil
 * JD-Core Version:    0.7.0.1
 */