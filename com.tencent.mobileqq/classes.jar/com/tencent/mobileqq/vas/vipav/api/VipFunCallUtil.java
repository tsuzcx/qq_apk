package com.tencent.mobileqq.vas.vipav.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VipFunCallUtil
{
  public static int a()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Build.MODEL=[");
      ((StringBuilder)localObject1).append(Build.MODEL);
      ((StringBuilder)localObject1).append("],android.os.Build.VERSION.SDK_INT=[");
      ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject1).append("]");
      QLog.d("VipFunCallConstants", 2, ((StringBuilder)localObject1).toString());
    }
    if (VipFunCallConstants.d < 0) {}
    try
    {
      localObject1 = "R8007,SCH-I869,K-Touch E780,HUAWEI C8812E,AMOI N828,7,8,9,10,11,12,13,HUAWEI Y320-T00,gt-s7568i".split(",");
      int i = 0;
      while (i < localObject1.length)
      {
        if (localObject1[i] != null)
        {
          Object localObject2 = localObject1[i];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(Build.VERSION.SDK_INT);
          localStringBuilder.append("");
          if ((localObject2.equalsIgnoreCase(localStringBuilder.toString())) || (localObject1[i].equalsIgnoreCase(Build.MODEL))) {
            VipFunCallConstants.d = 7;
          }
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      label151:
      break label151;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Build.MODEL=[");
    ((StringBuilder)localObject1).append(Build.MODEL);
    ((StringBuilder)localObject1).append("],android.os.Build.VERSION.SDK_INT=[");
    ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject1).append("]");
    QLog.e("VipFunCallConstants", 1, ((StringBuilder)localObject1).toString());
    if (VipFunCallConstants.d < 0) {
      VipFunCallConstants.d = 6;
    }
    return VipFunCallConstants.d;
  }
  
  private static int a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getResIdByUin err:");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("VipFunCallConstants", 1, localStringBuilder.toString());
      }
    }
    return paramInt;
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, 1, null);
    int i = paramAppRuntime.getInt("last_fun_call_play_id", 0);
    paramAppRuntime.edit().remove("last_fun_call_play_id").commit();
    return i;
  }
  
  private static int a(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, SharedPreferences paramSharedPreferences)
  {
    int i = paramInt2;
    if (!paramBoolean)
    {
      i = paramInt2;
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject2 = null;
        Object localObject3 = paramSharedPreferences.getString("group", null);
        Object localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = ((String)localObject3).split(",");
          i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= localObject3.length) {
              break;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("group_");
            ((StringBuilder)localObject1).append(localObject3[i]);
            localObject1 = paramSharedPreferences.getString(((StringBuilder)localObject1).toString(), null);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("-");
              localStringBuilder.append(paramString);
              localStringBuilder.append("-");
              if (((String)localObject1).indexOf(localStringBuilder.toString()) > 0)
              {
                paramString = ((String)localObject1).split(",");
                localObject1 = localObject2;
                if (paramString.length < 3) {
                  break;
                }
                if (3 == paramInt1)
                {
                  localObject1 = paramString[1];
                  break;
                }
                localObject1 = paramString[0];
                break;
              }
            }
            i += 1;
          }
        }
        paramInt2 = a(paramInt2, (String)localObject1);
        i = paramInt2;
        if (paramInt2 == 0)
        {
          paramString = new StringBuilder();
          paramString.append(paramAppRuntime.getAccount());
          paramString.append("callId");
          paramString.append(paramInt1);
          i = paramSharedPreferences.getInt(paramString.toString(), 0);
        }
      }
    }
    return i;
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = VasUtil.a();
    }
    if (localAppRuntime == null)
    {
      QLog.e("VipFunCallConstants", 1, "getResIdByUin null == app");
      return 0;
    }
    SharedPreferences localSharedPreferences = a(localAppRuntime, 1, null);
    if (localSharedPreferences == null)
    {
      QLog.e("VipFunCallConstants", 1, "getResIdByUin null == sp");
      return 0;
    }
    paramAppRuntime = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      if (paramBoolean)
      {
        paramAppRuntime = localAppRuntime.getAccount();
      }
      else
      {
        QLog.e("VipFunCallConstants", 1, "getResIdByUin null == uin, isICall = false");
        paramAppRuntime = paramString1;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramAppRuntime);
    paramString1.append("callId");
    paramString1.append(paramInt);
    return a(localAppRuntime, paramInt, paramBoolean, paramString2, localSharedPreferences.getInt(paramString1.toString(), 0), localSharedPreferences);
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = a(paramAppRuntime, 1, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin_fun_call_id_change_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    int i = localSharedPreferences.getInt(localStringBuilder.toString(), 2);
    if (i != 0) {
      a(paramAppRuntime, paramString1, 0, paramString2, 0);
    }
    return i;
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = VasUtil.a();
    }
    if (localAppRuntime == null)
    {
      QLog.e("VipFunCallConstants", 1, "getFunCallUinSP app == null");
      return null;
    }
    if (1 == paramInt)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("fun_call_uinSp_");
      paramAppRuntime.append(localAppRuntime.getAccount());
      paramAppRuntime = paramAppRuntime.toString();
    }
    else
    {
      paramAppRuntime = "fun_call_appSp";
    }
    Object localObject = paramAppRuntime;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppRuntime);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localAppRuntime.getApplication().getSharedPreferences((String)localObject, 4);
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("funcall");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = b(paramAppRuntime, paramInt1, paramInt2, null);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("getResourcePathByUrl, url=null , id=");
      paramAppRuntime.append(paramInt1);
      paramAppRuntime.append(", type=");
      paramAppRuntime.append(paramInt2);
      QLog.e("VipFunCallConstants", 1, paramAppRuntime.toString());
      return null;
    }
    paramAppRuntime = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
    paramString = new StringBuilder();
    paramString.append(a());
    paramString.append(paramInt1);
    paramString.append(File.separator);
    paramString = paramString.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(paramAppRuntime);
    return ((StringBuilder)localObject).toString();
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, 1, null).edit().putInt("last_fun_call_play_id", paramInt).commit();
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    Object localObject = a(paramAppRuntime, 1, null).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin_fun_call_id_change_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt1).commit();
    if (paramInt2 == 0) {
      return;
    }
    paramString2 = a(paramAppRuntime, paramInt2, 8, null);
    paramString1 = new File(paramString2);
    if (FileUtils.fileExists(paramString2)) {
      return;
    }
    localObject = b(paramAppRuntime, paramInt2, 8, null);
    paramString2 = new Bundle();
    paramString1 = new DownloadTask((String)localObject, paramString1);
    ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).startDownload(paramAppRuntime, paramString2, paramString1, null);
  }
  
  public static boolean a()
  {
    int i = NetworkUtil.getSystemNetwork(null);
    boolean bool = true;
    if (1 != i)
    {
      if (4 == i) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, VideoView paramVideoView, String paramString, int paramInt1, VipFunCallMediaListener paramVipFunCallMediaListener, int paramInt2, boolean paramBoolean)
  {
    if ((paramContext != null) && (paramVideoView != null))
    {
      if (paramString == null) {
        return false;
      }
      paramContext = new File(paramString);
      if ((paramContext.exists()) && (!paramVideoView.isPlaying()))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("playing[");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("]");
          QLog.d("VipFunCallConstants", 2, localStringBuilder.toString());
        }
        if (paramInt1 == 6) {
          return a(paramVideoView, paramVipFunCallMediaListener, paramInt2, paramBoolean, paramContext);
        }
        if ((paramInt1 == 7) && (a(paramVideoView, paramString, paramVipFunCallMediaListener))) {
          return true;
        }
      }
    }
    return false;
  }
  
  @SuppressLint({"WrongConstant"})
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    boolean bool = Utils.a();
    if ((bool) && (paramContext == null)) {}
    for (;;)
    {
      try
      {
        paramContext = VasUtil.a().getApplicationContext();
        if ((bool) && (paramContext != null))
        {
          i = paramContext.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
          if (i == 0) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else
        {
          i = -10;
        }
      }
      catch (Exception paramContext)
      {
        int i;
        long l2;
        StringBuilder localStringBuilder;
        continue;
      }
      try
      {
        l2 = System.currentTimeMillis() - l1;
        if ((QLog.isColorLevel()) || (!bool) || (paramBoolean))
        {
          paramContext = new StringBuilder();
          paramContext.append("isExternalStorageReady have sdCARD:");
          paramContext.append(bool);
          paramContext.append(", from:");
          paramContext.append(paramString);
          paramContext.append(", showLog:");
          paramContext.append(paramBoolean);
          paramContext.append(", type=");
          paramContext.append(i);
          paramContext.append(", lonth=");
          paramContext.append(l2);
          QLog.d("VipFunCallConstants", 1, paramContext.toString());
        }
        ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).vipFuncallReport(paramString, bool, i, l2);
        return bool;
      }
      catch (Exception paramContext)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isExternalStorageReady have sdCARD:");
        localStringBuilder.append(bool);
        localStringBuilder.append(", from:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", lonth=");
        localStringBuilder.append(System.currentTimeMillis() - l1);
        localStringBuilder.append(", msg=");
        localStringBuilder.append(paramContext.getMessage());
        QLog.e("VipFunCallConstants", 1, localStringBuilder.toString());
        return bool;
      }
    }
  }
  
  private static boolean a(VideoView paramVideoView, VipFunCallMediaListener paramVipFunCallMediaListener, int paramInt, boolean paramBoolean, File paramFile)
  {
    paramVideoView.setOnTouchListener(new VipFunCallUtil.1());
    paramVideoView.setVideoPath(paramFile.getAbsolutePath());
    paramVideoView.requestFocus();
    paramVideoView.setVisibility(0);
    paramVideoView.setOnPreparedListener(new VipFunCallUtil.2(paramVipFunCallMediaListener));
    paramVideoView.setOnCompletionListener(new VipFunCallUtil.3(paramVideoView));
    paramVideoView.setOnErrorListener(new VipFunCallUtil.4(paramInt, paramVipFunCallMediaListener, paramVideoView, paramBoolean));
    return true;
  }
  
  private static boolean a(VideoView paramVideoView, String paramString, VipFunCallMediaListener paramVipFunCallMediaListener)
  {
    paramString = BitmapManager.a(paramString);
    if (paramString != null) {
      paramString = new BitmapDrawable(paramString);
    } else {
      paramString = null;
    }
    if (paramString != null)
    {
      paramVideoView = (RelativeLayout)paramVideoView.getParent();
      if (paramVideoView != null)
      {
        if (paramVipFunCallMediaListener != null) {
          paramVipFunCallMediaListener.a();
        }
        paramVideoView.setBackgroundDrawable(paramString);
        return true;
      }
    }
    return false;
  }
  
  public static String b(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString)
  {
    SharedPreferences localSharedPreferences = a(paramAppRuntime, 0, String.valueOf(paramInt1));
    Object localObject = null;
    paramAppRuntime = localObject;
    if (localSharedPreferences != null) {
      if (paramInt2 > -1)
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("_");
        paramAppRuntime.append(paramInt2);
        paramAppRuntime = localSharedPreferences.getString(paramAppRuntime.toString(), null);
      }
      else
      {
        paramAppRuntime = localObject;
        if (!TextUtils.isEmpty(paramString)) {
          paramAppRuntime = localSharedPreferences.getString(paramString, null);
        }
      }
    }
    if (TextUtils.isEmpty(paramAppRuntime))
    {
      paramString = new StringBuilder();
      paramString.append("getResourceUrl, url=null , id=");
      paramString.append(paramInt1);
      paramString.append(", type=");
      paramString.append(paramInt2);
      QLog.e("VipFunCallConstants", 1, paramString.toString());
    }
    return paramAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil
 * JD-Core Version:    0.7.0.1
 */