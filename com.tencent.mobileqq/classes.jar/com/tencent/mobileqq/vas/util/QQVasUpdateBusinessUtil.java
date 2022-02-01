package com.tencent.mobileqq.vas.util;

import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.IVasUpdateManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IRemoteVasUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.entity.VasUpdateParcelableParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.qzone.util.JarReflectUtil;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQVasUpdateBusinessUtil
{
  private static HashMap<Class, Object> a = new HashMap();
  
  public static <T extends QQVasUpdateBusiness> T a(Class<T> paramClass)
  {
    if (!a()) {
      return b(paramClass);
    }
    return (QQVasUpdateBusiness)((IVasQuickUpdateService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasQuickUpdateService.class, "")).getBusinessCallback(paramClass);
  }
  
  public static VasUpdateParcelableParams a(UpdateListenerParams paramUpdateListenerParams)
  {
    if ((paramUpdateListenerParams != null) && (paramUpdateListenerParams.mBusinessUpdateParams != null))
    {
      VasUpdateParcelableParams localVasUpdateParcelableParams = new VasUpdateParcelableParams();
      localVasUpdateParcelableParams.c = paramUpdateListenerParams.mBusinessUpdateParams.mFrom;
      localVasUpdateParcelableParams.d = paramUpdateListenerParams.mBusinessUpdateParams.mBid;
      localVasUpdateParcelableParams.e = paramUpdateListenerParams.mBusinessUpdateParams.mScid;
      localVasUpdateParcelableParams.f = paramUpdateListenerParams.mErrorCode;
      localVasUpdateParcelableParams.g = paramUpdateListenerParams.mHttpCode;
      localVasUpdateParcelableParams.h = paramUpdateListenerParams.mProgress;
      localVasUpdateParcelableParams.i = paramUpdateListenerParams.mProgressMax;
      localVasUpdateParcelableParams.j = paramUpdateListenerParams.mProgressRate;
      localVasUpdateParcelableParams.k = paramUpdateListenerParams.mErrorMessage;
      return localVasUpdateParcelableParams;
    }
    return new VasUpdateParcelableParams();
  }
  
  public static UpdateListenerParams a(VasUpdateParcelableParams paramVasUpdateParcelableParams)
  {
    if (paramVasUpdateParcelableParams == null) {
      return new UpdateListenerParams();
    }
    UpdateListenerParams localUpdateListenerParams = new UpdateListenerParams();
    localUpdateListenerParams.mBusinessUpdateParams = new BusinessUpdateParams(paramVasUpdateParcelableParams.d, paramVasUpdateParcelableParams.e, paramVasUpdateParcelableParams.c);
    localUpdateListenerParams.mErrorCode = paramVasUpdateParcelableParams.f;
    localUpdateListenerParams.mHttpCode = paramVasUpdateParcelableParams.g;
    localUpdateListenerParams.mProgress = paramVasUpdateParcelableParams.h;
    localUpdateListenerParams.mProgressMax = paramVasUpdateParcelableParams.i;
    localUpdateListenerParams.mProgressRate = paramVasUpdateParcelableParams.j;
    localUpdateListenerParams.mErrorMessage = paramVasUpdateParcelableParams.k;
    return localUpdateListenerParams;
  }
  
  public static void a(VasUpdateParcelableParams paramVasUpdateParcelableParams, IRemoteVasUpdateListener paramIRemoteVasUpdateListener)
  {
    if (paramVasUpdateParcelableParams != null)
    {
      if (paramIRemoteVasUpdateListener == null) {
        return;
      }
      if (paramVasUpdateParcelableParams.b)
      {
        paramIRemoteVasUpdateListener.c(paramVasUpdateParcelableParams);
        return;
      }
      if (paramVasUpdateParcelableParams.a)
      {
        paramIRemoteVasUpdateListener.a(paramVasUpdateParcelableParams);
        return;
      }
      paramIRemoteVasUpdateListener.b(paramVasUpdateParcelableParams);
    }
  }
  
  public static <T extends QQVasUpdateBusiness> void a(Class<T> paramClass, String paramString, IRemoteVasUpdateListener paramIRemoteVasUpdateListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRemoteDownload scid = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" cls = ");
      localStringBuilder.append(paramClass.getSimpleName());
      QLog.i("QQVasUpdateBusinessUtil", 1, localStringBuilder.toString());
    }
    if (MobileQQ.sMobileQQ != null)
    {
      if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
        return;
      }
      ((IVasService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasService.class, "all")).getVasUpdateManager().startRemoteDownload(paramClass, paramString, new QQVasUpdateBusinessUtil.1(paramIRemoteVasUpdateListener));
    }
  }
  
  public static boolean a()
  {
    return BaseApplication.getContext().getPackageName().equals(MobileQQ.processName);
  }
  
  public static <T extends QQVasUpdateBusiness> T b(Class<T> paramClass)
  {
    if (a.get(paramClass) != null) {
      return (QQVasUpdateBusiness)a.get(paramClass);
    }
    QQVasUpdateBusiness localQQVasUpdateBusiness = (QQVasUpdateBusiness)JarReflectUtil.creatSpecifiedObject(paramClass.getName(), null, null);
    a.put(paramClass, localQQVasUpdateBusiness);
    return (QQVasUpdateBusiness)localQQVasUpdateBusiness;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil
 * JD-Core Version:    0.7.0.1
 */