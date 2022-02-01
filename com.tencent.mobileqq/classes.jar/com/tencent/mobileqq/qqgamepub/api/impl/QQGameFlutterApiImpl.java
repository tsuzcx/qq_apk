package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.flutter.api.IQFlutterInstallService;
import com.tencent.mobileqq.flutter.download.InstallCallback;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqgamepub/api/impl/QQGameFlutterApiImpl;", "Lcom/tencent/mobileqq/qqgamepub/api/IQQGameFlutterApi;", "Lcom/tencent/mobileqq/flutter/download/InstallCallback;", "()V", "DEBUG_RES_DIR", "", "MAX_HEAP_LIMIT", "", "mMaxMemory", "", "isAppInstalled", "", "isEngineInstalled", "isFlutterEnabled", "onProgress", "", "progress", "onResult", "success", "installDir", "isEngineExist", "isAppExist", "preloadFlutter", "Companion", "qqgamepubaccount-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGameFlutterApiImpl
  implements InstallCallback, IQQGameFlutterApi
{
  public static final QQGameFlutterApiImpl.Companion Companion = new QQGameFlutterApiImpl.Companion(null);
  @NotNull
  public static final String TAG = "QQGameFlutterUtilsImpl";
  private final String DEBUG_RES_DIR;
  private final int MAX_HEAP_LIMIT = 209715200;
  private long mMaxMemory;
  
  public QQGameFlutterApiImpl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppOpenConstants.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qflutter");
    this.DEBUG_RES_DIR = localStringBuilder.toString();
  }
  
  private final boolean isFlutterEnabled()
  {
    try
    {
      Object localObject = QRoute.api(IQQGameConfigUtil.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IQQGameConfigUtil::class.java)");
      if (!((IQQGameConfigUtil)localObject).isFlutterPreLoad())
      {
        QLog.w("QQGameFlutterUtilsImpl", 4, "[isFlutterEnabled] master switch off");
        return false;
      }
      if (this.mMaxMemory == 0L) {
        this.mMaxMemory = Runtime.getRuntime().maxMemory();
      }
      if (this.mMaxMemory < this.MAX_HEAP_LIMIT)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[isFlutterEnable] heap limit not supported, heap=");
        ((StringBuilder)localObject).append(this.mMaxMemory);
        QLog.w("QQGameFlutterUtilsImpl", 1, ((StringBuilder)localObject).toString());
        return false;
      }
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("QQGameFlutterUtilsImpl", 1, "[isFlutterEnabled] ", (Throwable)localException);
    }
    return false;
  }
  
  public boolean isAppInstalled()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject != null) && ((localObject instanceof BaseQQAppInterface)))
    {
      localObject = ((AppRuntime)localObject).getRuntimeService(IQFlutterInstallService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.getRuntimeService(IQF…ava, ProcessConstant.ALL)");
      return ((IQFlutterInstallService)localObject).isAppInstalled();
    }
    return false;
  }
  
  public boolean isEngineInstalled()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject != null) && ((localObject instanceof BaseQQAppInterface)))
    {
      localObject = ((AppRuntime)localObject).getRuntimeService(IQFlutterInstallService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.getRuntimeService(IQF…ava, ProcessConstant.ALL)");
      return ((IQFlutterInstallService)localObject).isEngineInstalled();
    }
    return false;
  }
  
  public void onProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preloadFlutter] onProgress =");
      localStringBuilder.append(paramInt);
      QLog.d("QQGameFlutterUtilsImpl", 1, localStringBuilder.toString());
    }
  }
  
  public void onResult(boolean paramBoolean1, @Nullable String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preloadFlutter] onResult success=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",installDir=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(',');
      localStringBuilder.append("isEngineExist=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(",isAppExist=");
      localStringBuilder.append(paramBoolean3);
      QLog.d("QQGameFlutterUtilsImpl", 1, localStringBuilder.toString());
    }
  }
  
  public void preloadFlutter()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameFlutterUtilsImpl", 2, "[preloadFlutter] ");
    }
    if (!isFlutterEnabled())
    {
      QLog.w("QQGameFlutterUtilsImpl", 1, "[preloadFlutter] flutter not enabled");
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && ((localAppRuntime instanceof BaseQQAppInterface))) {
      ((IQFlutterInstallService)localAppRuntime.getRuntimeService(IQFlutterInstallService.class, "all")).install((InstallCallback)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameFlutterApiImpl
 * JD-Core Version:    0.7.0.1
 */