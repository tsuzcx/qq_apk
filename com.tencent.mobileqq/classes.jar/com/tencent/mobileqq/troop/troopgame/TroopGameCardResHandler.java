package com.tencent.mobileqq.troop.troopgame;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.armap.ResDownloadHandler.DefaultRDHandler;
import com.tencent.mobileqq.armap.ResDownloadManager.DownloadParam;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;

public class TroopGameCardResHandler
  extends ResDownloadHandler.DefaultRDHandler
{
  private static String a()
  {
    if (SystemUtil.a()) {
      localObject1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
    } else {
      localObject1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath();
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith(File.separator))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(File.separator);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("troopgamecard/res");
    ((StringBuilder)localObject1).append(File.separator);
    return ((StringBuilder)localObject1).toString();
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    String str = c(paramDownloadParam);
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    Object localObject = new File(str);
    boolean bool = ((File)localObject).exists();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("needDownload path[");
      localStringBuilder.append(str);
      localStringBuilder.append("], exists[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.d("TroopGameCardResHandler", 2, localStringBuilder.toString());
    }
    if (!bool)
    {
      if (QLog.isColorLevel())
      {
        paramDownloadParam = new StringBuilder();
        paramDownloadParam.append("needDownload exists, path[");
        paramDownloadParam.append(str);
        paramDownloadParam.append("]");
        QLog.d("TroopGameCardResHandler", 2, paramDownloadParam.toString());
      }
      return true;
    }
    StringBuilder localStringBuilder = null;
    try
    {
      localObject = MD5FileUtil.a((File)localObject);
    }
    catch (Exception localException)
    {
      localObject = localStringBuilder;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("needDownload Exception");
        ((StringBuilder)localObject).append(localException);
        QLog.d("TroopGameCardResHandler", 2, ((StringBuilder)localObject).toString());
        localObject = localStringBuilder;
      }
    }
    if (!TextUtils.equals((CharSequence)localObject, paramDownloadParam.c))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("needDownload exists, path[");
        localStringBuilder.append(str);
        localStringBuilder.append("], filemd5[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("], downloadMd5[");
        localStringBuilder.append(paramDownloadParam.c);
        localStringBuilder.append("]");
        QLog.d("TroopGameCardResHandler", 2, localStringBuilder.toString());
      }
      return true;
    }
    return super.a(paramDownloadParam);
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    paramBoolean = paramDownloadParam.f;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramBoolean)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4);
      String str = paramDownloadParam.c;
      long l1 = -1L;
      long l3 = localSharedPreferences.getLong(str, -1L);
      paramDownloadParam = new File(b(paramDownloadParam));
      paramBoolean = bool2;
      if (paramDownloadParam.exists())
      {
        long l2 = paramDownloadParam.lastModified();
        paramBoolean = bool2;
        l1 = l2;
        if (l3 > 0L)
        {
          paramBoolean = bool2;
          l1 = l2;
          if (l3 != l2)
          {
            paramBoolean = false;
            l1 = l2;
          }
        }
      }
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        paramDownloadParam = new StringBuilder();
        paramDownloadParam.append("verifyUnzipDir result = ");
        paramDownloadParam.append(paramBoolean);
        paramDownloadParam.append(",recordedModifyTime = ");
        paramDownloadParam.append(l3);
        paramDownloadParam.append(",realModifyTime = ");
        paramDownloadParam.append(l1);
        QLog.d("TroopGameCardResHandler", 2, paramDownloadParam.toString());
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public String b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(paramDownloadParam.c);
    localStringBuilder.append(File.separator);
    paramDownloadParam = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUnzipDirPath dir = ");
      localStringBuilder.append(paramDownloadParam);
      QLog.d("TroopGameCardResHandler", 2, localStringBuilder.toString());
    }
    return paramDownloadParam;
  }
  
  public String c(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    StringBuilder localStringBuilder;
    if (paramDownloadParam.f)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append(paramDownloadParam.c);
      localStringBuilder.append(".end");
      paramDownloadParam = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append(paramDownloadParam.c);
      localStringBuilder.append(paramDownloadParam.d);
      paramDownloadParam = localStringBuilder.toString();
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDownloadPath path[");
      localStringBuilder.append(paramDownloadParam);
      localStringBuilder.append("]");
      QLog.d("TroopGameCardResHandler", 2, localStringBuilder.toString());
    }
    return paramDownloadParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardResHandler
 * JD-Core Version:    0.7.0.1
 */