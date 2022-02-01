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
    if (SystemUtil.a()) {}
    for (String str1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
    {
      String str2 = str1;
      if (str1 != null)
      {
        str2 = str1;
        if (!str1.endsWith(File.separator)) {
          str2 = str1 + File.separator;
        }
      }
      return str2 + "troopgamecard/res" + File.separator;
    }
  }
  
  public String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    paramDownloadParam = a() + paramDownloadParam.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardResHandler", 2, "getUnzipDirPath dir = " + paramDownloadParam);
    }
    return paramDownloadParam;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    String str = b(paramDownloadParam);
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    Object localObject1 = new File(str);
    boolean bool = ((File)localObject1).exists();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardResHandler", 2, "needDownload path[" + str + "], exists[" + bool + "]");
    }
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardResHandler", 2, "needDownload exists, path[" + str + "]");
      }
      return true;
    }
    Object localObject2 = null;
    try
    {
      localObject1 = MD5FileUtil.a((File)localObject1);
      if (!TextUtils.equals((CharSequence)localObject1, paramDownloadParam.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameCardResHandler", 2, "needDownload exists, path[" + str + "], filemd5[" + (String)localObject1 + "], downloadMd5[" + paramDownloadParam.b + "]");
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopGameCardResHandler", 2, "needDownload Exception" + localException);
          localObject1 = localObject2;
        }
      }
    }
    return super.a(paramDownloadParam);
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramDownloadParam.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4).getLong(paramDownloadParam.b, -1L);
      paramDownloadParam = new File(a(paramDownloadParam));
      paramBoolean = bool2;
      if (paramDownloadParam.exists())
      {
        long l2 = paramDownloadParam.lastModified();
        l1 = l2;
        paramBoolean = bool2;
        if (l3 > 0L)
        {
          l1 = l2;
          paramBoolean = bool2;
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
        QLog.d("TroopGameCardResHandler", 2, "verifyUnzipDir result = " + paramBoolean + ",recordedModifyTime = " + l3 + ",realModifyTime = " + l1);
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public String b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (paramDownloadParam.a) {}
    for (paramDownloadParam = a() + paramDownloadParam.b + ".end";; paramDownloadParam = a() + paramDownloadParam.b + paramDownloadParam.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardResHandler", 2, "getDownloadPath path[" + paramDownloadParam + "]");
      }
      return paramDownloadParam;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardResHandler
 * JD-Core Version:    0.7.0.1
 */