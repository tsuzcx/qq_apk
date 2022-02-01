package com.tencent.mobileqq.pluspanel;

import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/pluspanel/PlusPanelRedPointAppIdInterface;", "Lcom/tencent/mobileqq/tianshu/data/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "()V", "getAioPanelRedDotIds", "", "", "appInterface", "Lmqq/app/AppRuntime;", "getRedPointPaths", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PlusPanelRedPointAppIdInterface
  implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
{
  private final List<String> a(AppRuntime paramAppRuntime)
  {
    Set localSet = (Set)new HashSet();
    for (;;)
    {
      try
      {
        Object localObject1 = C2CPlusPanelAppConfigHelper.INSTANCE.getC2CAppInfo();
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          boolean bool = ((Iterator)localObject2).hasNext();
          if (bool)
          {
            Object localObject3 = ((Iterator)localObject2).next();
            PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)localObject3;
            Intrinsics.checkExpressionValueIsNotNull(localPlusPanelAppInfo, "it");
            if (localPlusPanelAppInfo.getRedDotID() <= 0) {
              break label372;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            ((Collection)localObject1).add(localObject3);
            continue;
          }
          localObject1 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (PlusPanelAppInfo)((Iterator)localObject1).next();
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
            localSet.add(String.valueOf(((PlusPanelAppInfo)localObject2).getRedDotID()));
            continue;
          }
        }
        if ((paramAppRuntime instanceof QQAppInterface))
        {
          paramAppRuntime = paramAppRuntime.getRuntimeService(ITroopAioAppService.class, "");
          Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "appInterface.getRuntimeS…va, ProcessConstant.MAIN)");
          paramAppRuntime = ((ITroopAioAppService)paramAppRuntime).getAllAppsFromCache();
          Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "appInfoList");
          localObject1 = (Iterable)paramAppRuntime;
          paramAppRuntime = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (((TroopAIOAppInfo)localObject2).appid <= 0) {
              break label377;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            paramAppRuntime.add(localObject2);
            continue;
          }
          paramAppRuntime = ((Iterable)paramAppRuntime).iterator();
          if (paramAppRuntime.hasNext())
          {
            localSet.add(String.valueOf(((TroopAIOAppInfo)paramAppRuntime.next()).appid));
            continue;
          }
        }
        return (List)new ArrayList((Collection)localSet);
      }
      catch (Throwable paramAppRuntime)
      {
        QLog.e("PlusPanelRedPointAppIdInterface", 1, paramAppRuntime, new Object[0]);
      }
      label372:
      int i = 0;
      continue;
      label377:
      i = 0;
    }
  }
  
  @NotNull
  public List<String> getRedPointPaths(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appInterface");
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanelRedPointAppIdInterface", 2, "getRedPointPaths");
    }
    return a(paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.PlusPanelRedPointAppIdInterface
 * JD-Core Version:    0.7.0.1
 */