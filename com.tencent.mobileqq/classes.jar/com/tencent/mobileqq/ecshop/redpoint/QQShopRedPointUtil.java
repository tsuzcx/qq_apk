package com.tencent.mobileqq.ecshop.redpoint;

import com.google.gson.Gson;
import com.tencent.mobileqq.ecshop.EcshopNewServlet;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.TabConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.SharedPreferencesUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/redpoint/QQShopRedPointUtil;", "", "()V", "SP_KEY_CONF_REDPOINT_CLICK_PREFIX", "", "SP_KEY_CONF_REDPOINT_INFO_PREFIX", "SP_KEY_CONF_SHOW_REDPOINT_PREFIX", "TAG", "mRedPointCallbackRef", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/ecshop/redpoint/QQShopRedPointUtil$IGetRedPointCallback;", "clearRedPointClickTag", "", "tabId", "", "clearRedPointInfos", "clearRedPointShowTag", "getRedPointClickTag", "", "taksId", "getRedPointInfo", "shouldReqQgg", "getRedPointInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/ecshop/redpoint/RedPointInfo;", "getRedPointShowDelay", "", "redPointInfo", "currentTime", "getRedPointShowTag", "onResponseRedPoint", "", "Ltencent/im/oidb/qqshop/qq_ad$QQAdGetRsp$RedPointInfo;", "parseToArrayList", "redPointInfos", "resetRedPointShowTag", "saveRedPointClickTag", "saveRedPointInfos", "saveRedPointShowTag", "setGetRedPointCallback", "callback", "verifyRedPointInfo", "currentTabId", "IGetRedPointCallback", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopRedPointUtil
{
  public static final QQShopRedPointUtil a;
  private static WeakReference<QQShopRedPointUtil.IGetRedPointCallback> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqEcshopRedpointQQShopRedPointUtil = new QQShopRedPointUtil();
  }
  
  @JvmStatic
  @Nullable
  public static final ArrayList<RedPointInfo> a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("redpoint_info_");
    ((StringBuilder)localObject).append(AppUtils.a().getCurrentAccountUin());
    localObject = SharedPreferencesUtil.a(((StringBuilder)localObject).toString());
    Type localType = new QQShopRedPointUtil.getRedPointInfos.type.1().getType();
    return (ArrayList)new Gson().fromJson((String)localObject, localType);
  }
  
  private final ArrayList<RedPointInfo> a(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.isEmpty()) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (qq_ad.QQAdGetRsp.RedPointInfo)paramList.next();
      localObject = new RedPointInfo().parse((qq_ad.QQAdGetRsp.RedPointInfo)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "RedPointInfo().parse(redPointInfoFromRsp)");
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  @JvmStatic
  public static final void a()
  {
    Object localObject = EcshopConfProcessor.a();
    if (localObject != null)
    {
      localObject = ((EcshopConfBean)localObject).a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ecshopConfBean.tabConfs");
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        b(((EcshopConfBean.TabConfBean)((Iterator)localObject).next()).a);
      }
    }
  }
  
  @JvmStatic
  public static final void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("redpoint_show_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(AppUtils.a().getCurrentAccountUin());
    SharedPreferencesUtil.a(localStringBuilder.toString(), true);
  }
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[saveRedPointClickTag]  taksId: ");
    localStringBuilder.append(paramInt2);
    QLog.i("QQShopRedPointUtil", 2, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("redpoint_click_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(AppUtils.a().getCurrentAccountUin());
    SharedPreferencesUtil.a(localStringBuilder.toString(), paramInt2);
  }
  
  @JvmStatic
  public static final void a(@NotNull QQShopRedPointUtil.IGetRedPointCallback paramIGetRedPointCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIGetRedPointCallback, "callback");
    jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramIGetRedPointCallback);
  }
  
  @JvmStatic
  public static final void a(@NotNull List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "redPointInfo");
    if (QLog.isColorLevel()) {
      QLog.i("QQShopRedPointUtil", 2, "[onResponseRedpoint]");
    }
    paramList = jdField_a_of_type_ComTencentMobileqqEcshopRedpointQQShopRedPointUtil.a(paramList);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("redpoint info: ");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("QQShopRedPointUtil", 2, ((StringBuilder)localObject).toString());
    }
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      jdField_a_of_type_ComTencentMobileqqEcshopRedpointQQShopRedPointUtil.a(paramList);
      localObject = jdField_a_of_type_MqqUtilWeakReference;
      if (localObject != null)
      {
        localObject = (QQShopRedPointUtil.IGetRedPointCallback)((WeakReference)localObject).get();
        if (localObject != null) {
          ((QQShopRedPointUtil.IGetRedPointCallback)localObject).a(paramList);
        }
      }
    }
  }
  
  @JvmStatic
  public static final void a(boolean paramBoolean)
  {
    Object localObject1 = a();
    if ((localObject1 != null) && ((((Collection)localObject1).isEmpty() ^ true)))
    {
      Object localObject2 = jdField_a_of_type_MqqUtilWeakReference;
      if (localObject2 != null)
      {
        localObject2 = (QQShopRedPointUtil.IGetRedPointCallback)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          ((QQShopRedPointUtil.IGetRedPointCallback)localObject2).a((ArrayList)localObject1);
        }
      }
    }
    else
    {
      localObject1 = new qq_ad.QQAdGet();
      if (paramBoolean) {
        ((qq_ad.QQAdGet)localObject1).trigger_type.set(12);
      } else {
        ((qq_ad.QQAdGet)localObject1).trigger_type.set(8);
      }
      EcshopNewServlet.a(((qq_ad.QQAdGet)localObject1).toByteArray(), "trpc.qqshop.adpush.PushService.GetAd", (BusinessObserver)QQShopRedPointUtil.getRedPointInfo.1.a);
    }
  }
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("redpoint_show_");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(AppUtils.a().getCurrentAccountUin());
      boolean bool = SharedPreferencesUtil.a(localStringBuilder.toString());
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QQShopRedPointUtil", 1, "[getRedPointShowTag] fail.", (Throwable)localException);
    }
    return false;
  }
  
  @JvmStatic
  public static final boolean a(int paramInt1, int paramInt2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("redpoint_click_");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(AppUtils.a().getCurrentAccountUin());
      paramInt1 = SharedPreferencesUtil.a(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getRedPointClickTag] cachedTaskId: ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" taskId: ");
        localStringBuilder.append(paramInt2);
        QLog.i("QQShopRedPointUtil", 2, localStringBuilder.toString());
      }
      if (paramInt1 == paramInt2) {
        return true;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QQShopRedPointUtil", 1, "[getRedPointClickTag] fail.", (Throwable)localException);
    }
    return false;
  }
  
  @JvmStatic
  public static final void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("redpoint_show_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(AppUtils.a().getCurrentAccountUin());
    SharedPreferencesUtil.a(localStringBuilder.toString(), false);
  }
  
  public final long a(@NotNull RedPointInfo paramRedPointInfo, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRedPointInfo, "redPointInfo");
    long l1 = paramRedPointInfo.mBeginTime;
    long l2 = paramRedPointInfo.mEndTime;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTime: ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" endTime: ");
    localStringBuilder.append(l2);
    localStringBuilder.append(" currentTime: ");
    localStringBuilder.append(paramLong);
    QLog.i("QQShopRedPointUtil", 2, localStringBuilder.toString());
    if (a(paramRedPointInfo.mTabId)) {
      return 0L;
    }
    if (l1 > paramLong) {
      return 0L;
    }
    if (l2 >= paramLong)
    {
      l1 = NetConnInfoCenter.getServerTime();
      return Math.abs(paramRedPointInfo.mDelaySeconds * 1000 - (l1 - paramLong));
    }
    return 0L;
  }
  
  public final void a(@NotNull ArrayList<RedPointInfo> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "redPointInfos");
    if (paramArrayList.isEmpty()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("redpoint_info_");
    localStringBuilder.append(AppUtils.a().getCurrentAccountUin());
    SharedPreferencesUtil.a(localStringBuilder.toString(), new Gson().toJson(paramArrayList));
  }
  
  public final boolean a(@NotNull RedPointInfo paramRedPointInfo, int paramInt, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRedPointInfo, "redPointInfo");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tab_id: ");
    localStringBuilder.append(paramRedPointInfo.mTabId);
    localStringBuilder.append(",red_type: ");
    localStringBuilder.append(paramRedPointInfo.mRedType);
    localStringBuilder.append(",red_url: ");
    localStringBuilder.append(paramRedPointInfo.mRedUrl);
    localStringBuilder.append(" task_id: ");
    localStringBuilder.append(paramRedPointInfo.mTashId);
    QLog.i("QQShopRedPointUtil", 2, localStringBuilder.toString());
    ReportUtil.a("gouwu.tab.show", String.valueOf(paramRedPointInfo.mTabId), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), String.valueOf(paramRedPointInfo.mTashId), paramInt);
    ReportUtil.b("gouwu_tab_show", String.valueOf(paramRedPointInfo.mTabId), String.valueOf(NetConnInfoCenter.getServerTimeMillis()), String.valueOf(paramRedPointInfo.mTashId), paramInt);
    int i = paramRedPointInfo.mTashId;
    if ((!a(paramRedPointInfo.mTabId, i)) && (paramInt != paramRedPointInfo.mTabId))
    {
      long l1 = paramRedPointInfo.mBeginTime;
      long l2 = paramRedPointInfo.mEndTime;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startTime: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" endTime: ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" currentTime: ");
      localStringBuilder.append(paramLong);
      QLog.i("QQShopRedPointUtil", 2, localStringBuilder.toString());
      if (!a(paramRedPointInfo.mTabId))
      {
        if (l1 > paramLong) {
          return false;
        }
        if (l2 < paramLong) {
          return false;
        }
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tab_id: ");
      localStringBuilder.append(paramRedPointInfo.mTabId);
      localStringBuilder.append(" has clicked!!!");
      QLog.i("QQShopRedPointUtil", 2, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil
 * JD-Core Version:    0.7.0.1
 */