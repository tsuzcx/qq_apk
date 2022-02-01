package com.tencent.mobileqq.pluspanel;

import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
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
    Object localObject2;
    int i;
    try
    {
      localObject1 = C2CPlusPanelAppConfigHelper.INSTANCE.getC2CAppInfo();
      if (localObject1 != null)
      {
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = ((Iterator)localObject2).next();
            PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)localObject3;
            Intrinsics.checkExpressionValueIsNotNull(localPlusPanelAppInfo, "it");
            if (localPlusPanelAppInfo.getRedDotID() > 0)
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              ((Collection)localObject1).add(localObject3);
              continue;
              return (List)new ArrayList((Collection)localSet);
            }
          }
        }
      }
    }
    catch (Throwable paramAppRuntime)
    {
      QLog.e("PlusPanelRedPointAppIdInterface", 1, paramAppRuntime, new Object[0]);
    }
    do
    {
      i = 0;
      break;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PlusPanelAppInfo)((Iterator)localObject1).next();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
        localSet.add(String.valueOf(((PlusPanelAppInfo)localObject2).getRedDotID()));
      }
    } while (!(paramAppRuntime instanceof QQAppInterface));
    paramAppRuntime = AioGroupAppsManager.a((QQAppInterface)paramAppRuntime);
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "aioGroupAppsManager");
    paramAppRuntime = paramAppRuntime.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "appInfoList");
    Object localObject1 = (Iterable)paramAppRuntime;
    paramAppRuntime = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label264:
    label359:
    label362:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((TroopAIOAppInfo)localObject2).appid <= 0) {
          break label359;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label362;
        }
        paramAppRuntime.add(localObject2);
        break label264;
        paramAppRuntime = ((Iterable)paramAppRuntime).iterator();
        while (paramAppRuntime.hasNext()) {
          localSet.add(String.valueOf(((TroopAIOAppInfo)paramAppRuntime.next()).appid));
        }
        break;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.PlusPanelRedPointAppIdInterface
 * JD-Core Version:    0.7.0.1
 */