package com.tencent.mobileqq.video;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.lang.ref.WeakReference;

public class VipVideoManager
{
  public static int a = 0;
  private static boolean b = false;
  
  public static void a(Context paramContext, TVK_SDKMgr.InstallListener paramInstallListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("install video plugin and context=");
      String str2 = "null";
      String str1;
      if (paramContext == null) {
        str1 = "null";
      } else {
        str1 = "not null";
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(",mMediaSdkInited");
      localStringBuilder.append(b);
      localStringBuilder.append(",listener=");
      if (paramInstallListener == null) {
        str1 = str2;
      } else {
        str1 = "not null";
      }
      localStringBuilder.append(str1);
      QLog.d("VipVideoManager", 2, localStringBuilder.toString());
    }
    if ((paramContext != null) && (paramInstallListener != null)) {
      try
      {
        if (!b) {
          b(paramContext);
        }
        a = 0;
        TVK_SDKMgr.installPlugin(paramContext, (TVK_SDKMgr.InstallListener)new WeakReference(paramInstallListener).get());
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramInstallListener = new StringBuilder();
          paramInstallListener.append("install video plugin exception msg=");
          paramInstallListener.append(paramContext.getMessage());
          QLog.d("VipVideoManager", 2, paramInstallListener.toString());
        }
        paramContext.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isInstalled Plugin=");
      localStringBuilder.append(TVK_SDKMgr.isInstalled(paramContext));
      localStringBuilder.append(",Context=");
      String str;
      if (paramContext == null) {
        str = "null";
      } else {
        str = "not null";
      }
      localStringBuilder.append(str);
      QLog.d("VipVideoManager", 2, localStringBuilder.toString());
    }
    return (paramContext != null) && (TVK_SDKMgr.isInstalled(paramContext));
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init video plugin context ");
      String str;
      if (paramContext != null) {
        str = "is not null";
      } else {
        str = "is null";
      }
      localStringBuilder.append(str);
      QLog.d("VipVideoManager", 2, localStringBuilder.toString());
    }
    try
    {
      try
      {
        if (!b)
        {
          TVK_SDKMgr.setOnLogListener(new VipVideoManager.1());
          if (paramContext != null)
          {
            TVK_SDKMgr.initSdk(paramContext, "ZDJ2DK+QcEksd+C8RIzfwQhjkPCNDsewhQBcxciUfYyphf1ntN4M1sXu5waGVy3CMB36XLopJFqaMtHxKS4BXScewkVRuSfBoAJVDEJHZv+opKWeviyxuUnc4R4MlMmTO2M2de47GRD6te9FtjtFCd1KLUPZuW QBq8aXUxi+IyhmKBZoXWUxLkdfIZ7Gleriirf7ewcykmS64TG7zbV1uMCdIaO9hwDhVJbRlGN2si1sepphKPCuuOoAdZz52edGEfp5oIgA7THflGFidFnsrPksn8nGbr+OYOI8kcixjzblTIjBAqHHFRJnIQhh74pVkqtiqE7iz46FclQB17JJmg==", "");
            b = true;
          }
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoManager
 * JD-Core Version:    0.7.0.1
 */