package com.tencent.mobileqq.voicechange.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VoiceTuneUtilImpl
  implements IVoiceTuneUtil
{
  public static final String TAG = "VoiceTuneUtilImpl";
  
  public void deleteAllFiles(String paramString1, String paramString2)
  {
    new File(paramString1).delete();
    new File(paramString2).delete();
    int i = 0;
    while (i < IVoiceTuneUtil.MAX_TYPES)
    {
      new File(((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).getChangedSoundFilePath(paramString1, i)).delete();
      i += 1;
    }
  }
  
  public void deleteAllFilesOnExit(String paramString1, String paramString2)
  {
    new File(paramString1).deleteOnExit();
    new File(paramString2).deleteOnExit();
    int i = 0;
    while (i < IVoiceTuneUtil.MAX_TYPES)
    {
      new File(((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).getChangedSoundFilePath(paramString1, i)).deleteOnExit();
      i += 1;
    }
  }
  
  public void deleteOtherTmpFiles(String paramString1, String paramString2, int paramInt)
  {
    new File(paramString1).delete();
    new File(paramString2).delete();
    paramString2 = null;
    int i = 0;
    while (i < IVoiceTuneUtil.MAX_TYPES)
    {
      String str = getChangedSoundFilePath(paramString1, i);
      if (i == paramInt) {
        paramString2 = str;
      } else {
        new File(str).delete();
      }
      i += 1;
    }
    if (paramString2 != null) {
      new File(paramString2).renameTo(new File(paramString1));
    }
  }
  
  public String getChangedSoundFilePath(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf(".");
    String str = paramString.substring(0, i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return str.concat(localStringBuilder.toString()).concat(paramString.substring(i, paramString.length()));
  }
  
  @SuppressLint({"WrongConstant"})
  public boolean isExternalStorageReady(Context paramContext)
  {
    long l1 = System.currentTimeMillis();
    boolean bool3 = Utils.a();
    Object localObject = paramContext;
    boolean bool2;
    if (bool3)
    {
      localObject = paramContext;
      if (paramContext == null) {
        bool2 = bool3;
      }
    }
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext();
        int j = -10;
        bool1 = bool3;
        int i = j;
        if (bool3)
        {
          bool1 = bool3;
          i = j;
          if (localObject != null)
          {
            bool2 = bool3;
            i = ((Context)localObject).checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
            if (i != 0) {
              break label290;
            }
            bool1 = true;
          }
        }
        bool2 = bool1;
        long l2 = System.currentTimeMillis();
        bool2 = bool1;
        if (!QLog.isColorLevel())
        {
          bool2 = bool1;
          if (bool1) {}
        }
        else
        {
          bool2 = bool1;
          paramContext = new StringBuilder();
          bool2 = bool1;
          paramContext.append("isExternalStorageReady have sdCARD:");
          bool2 = bool1;
          paramContext.append(bool1);
          bool2 = bool1;
          paramContext.append(", type=");
          bool2 = bool1;
          paramContext.append(i);
          bool2 = bool1;
          paramContext.append(", lonth=");
          bool2 = bool1;
          paramContext.append(l2 - l1);
          bool2 = bool1;
          QLog.d("VoiceTuneUtilImpl", 1, paramContext.toString());
          return bool1;
        }
      }
      catch (Exception paramContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isExternalStorageReady have sdCARD:");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append(", lonth=");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
        ((StringBuilder)localObject).append(", msg=");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QLog.e("VoiceTuneUtilImpl", 1, ((StringBuilder)localObject).toString());
      }
      return bool2;
      label290:
      boolean bool1 = false;
    }
  }
  
  public String renameFileToPcm(String paramString)
  {
    String str = paramString.substring(0, paramString.lastIndexOf(".")).concat(".pcm");
    new File(paramString).renameTo(new File(str));
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.impl.VoiceTuneUtilImpl
 * JD-Core Version:    0.7.0.1
 */