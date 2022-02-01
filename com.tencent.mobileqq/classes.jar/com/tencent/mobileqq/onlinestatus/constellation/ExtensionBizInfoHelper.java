package com.tencent.mobileqq.onlinestatus.constellation;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tencent.im.onlinestatus.OnlineStatusExtInfo.AutoStateBizInfo;
import tencent.im.onlinestatus.OnlineStatusExtInfo.ZodiacBizInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/constellation/ExtensionBizInfoHelper;", "", "()V", "autoStatusTime", "", "packAutoStatusBundle", "Landroid/os/Bundle;", "updateSecond", "extStatus", "", "requestSetAutoStatusExtInfo", "", "app", "Lcom/tencent/common/app/AppInterface;", "requestSetConstellationExtInfo", "Lmqq/app/AppRuntime;", "statusId", "jumpUrl", "", "todayTrend", "tomorrowTrend", "todayDate", "luckyColor", "luckyNum", "requestSyncAutoStatusExtInfo", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class ExtensionBizInfoHelper
{
  public static final ExtensionBizInfoHelper a = new ExtensionBizInfoHelper();
  
  private final Bundle a(long paramLong, int paramInt)
  {
    OnlineStatusExtInfo.AutoStateBizInfo localAutoStateBizInfo = new OnlineStatusExtInfo.AutoStateBizInfo();
    localAutoStateBizInfo.uint64_update_time.set(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("ExtInfo", localAutoStateBizInfo.toByteArray());
    localBundle.putInt("StatusId", paramInt);
    return localBundle;
  }
  
  private final void a(AppRuntime paramAppRuntime, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("statusId: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  todayTrend: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("  jumpUrl: ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSetConstellationExtInfo: called. ", ((StringBuilder)localObject).toString() });
    }
    if (paramAppRuntime != null)
    {
      paramAppRuntime = ((AppInterface)paramAppRuntime).getBusinessHandler(OnlineStatusHandler.class.getName());
      if (paramAppRuntime != null)
      {
        paramAppRuntime = (OnlineStatusHandler)paramAppRuntime;
        localObject = new OnlineStatusExtInfo.ZodiacBizInfo();
        ((OnlineStatusExtInfo.ZodiacBizInfo)localObject).string_miniapp.set(paramString1);
        ((OnlineStatusExtInfo.ZodiacBizInfo)localObject).string_today_trend.set(paramString2);
        ((OnlineStatusExtInfo.ZodiacBizInfo)localObject).string_tomorrow_trend.set(paramString3);
        ((OnlineStatusExtInfo.ZodiacBizInfo)localObject).string_today_date.set(paramString4);
        if (!TextUtils.isEmpty((CharSequence)paramString5)) {
          ((OnlineStatusExtInfo.ZodiacBizInfo)localObject).string_lucky_color.set(paramString5);
        }
        if (!TextUtils.isEmpty((CharSequence)paramString6)) {
          ((OnlineStatusExtInfo.ZodiacBizInfo)localObject).string_lucky_number.set(paramString6);
        }
        paramString1 = new Bundle();
        paramString1.putByteArray("ExtInfo", ((OnlineStatusExtInfo.ZodiacBizInfo)localObject).toByteArray());
        paramString1.putInt("StatusId", paramInt);
        paramAppRuntime.a(3, paramString1, null);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
  }
  
  public final long a()
  {
    return NetConnInfoCenter.getServerTimeMillis() / 1000L;
  }
  
  public final void a(@NotNull AppInterface paramAppInterface, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    paramAppInterface = paramAppInterface.getBusinessHandler(OnlineStatusHandler.class.getName());
    if (paramAppInterface != null)
    {
      ((OnlineStatusHandler)paramAppInterface).a(3, a(paramLong, paramInt), null);
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("updateSecond: ");
        paramAppInterface.append(paramLong);
        paramAppInterface.append("  extStatus: ");
        paramAppInterface.append(paramInt);
        QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSetAutoStatusExtInfo: called. ", paramAppInterface.toString() });
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler");
  }
  
  public final void a(@NotNull AppRuntime paramAppRuntime, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    String str1 = paramAppRuntime.getCurrentAccountUin();
    String str2 = ConstellationUtilKt.e(paramAppRuntime);
    Intrinsics.checkExpressionValueIsNotNull(str1, "uin");
    a(paramAppRuntime, paramInt, str2, ConstellationUtilKt.a(str1), ConstellationUtilKt.b(str1), ConstellationUtilKt.b(), ConstellationUtilKt.c(str1), ConstellationUtilKt.d(str1));
  }
  
  public final void b(@NotNull AppInterface paramAppInterface, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    Object localObject = paramAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
    localObject = ((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusDataManager.class);
    if (localObject != null)
    {
      localObject = (OnlineStatusDataManager)localObject;
      boolean bool = ((OnlineStatusDataManager)localObject).a(40000);
      if (bool)
      {
        paramAppInterface = paramAppInterface.getBusinessHandler(OnlineStatusHandler.class.getName());
        if (paramAppInterface != null)
        {
          ((OnlineStatusHandler)paramAppInterface).a(3, a(paramLong, paramInt));
          long l = NetConnInfoCenter.getServerTime();
          ((OnlineStatusDataManager)localObject).a(40000, l);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("serverTime: ");
            paramAppInterface.append(l);
            QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSyncAutoStatusExtInfo: called. (每次执行sync后，需要刷新本地的更新时间，用于下次限频判断) ", paramAppInterface.toString() });
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler");
        }
      }
      else if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("expired: ");
        paramAppInterface.append(bool);
        QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSyncAutoStatusExtInfo: called. (触发限频逻辑，不用频繁上报) ", paramAppInterface.toString() });
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("updateSecond: ");
        paramAppInterface.append(paramLong);
        paramAppInterface.append("  extStatus: ");
        paramAppInterface.append(paramInt);
        paramAppInterface.append("  expired: ");
        paramAppInterface.append(bool);
        QLog.d("ExtensionBizInfoHelper", 2, new Object[] { "requestSyncAutoStatusExtInfo: called. ", paramAppInterface.toString() });
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.constellation.ExtensionBizInfoHelper
 * JD-Core Version:    0.7.0.1
 */