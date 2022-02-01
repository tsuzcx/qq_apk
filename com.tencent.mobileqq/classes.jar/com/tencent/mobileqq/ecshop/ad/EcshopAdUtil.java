package com.tencent.mobileqq.ecshop.ad;

import com.google.gson.Gson;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieCallback;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.DateUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/ad/EcshopAdUtil;", "", "()V", "SP_KEY_RISK_AD_DEL_TIME", "", "SP_KEY_RISK_AIDS", "TAG", "deleteRiskAd", "", "chatPieCallback", "Lcom/tencent/mobileqq/ecshop/aio/IEcshopChatPieCallback;", "delIds", "", "", "getAdItemMessageInAIO", "", "Lcom/tencent/mobileqq/data/ChatMessage;", "list", "aid", "getRiskAids", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "saveRiskAids", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class EcshopAdUtil
{
  public static final EcshopAdUtil a = new EcshopAdUtil();
  
  private final HashSet<Long> a()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = (IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class);
    Object localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
    localObject2 = ((IQWalletPreferenceApi)localObject2).getString(((AppRuntime)localObject3).getCurrentAccountUin(), "risk_ids", "");
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "QRoute.api(IQWalletPrefe…in, SP_KEY_RISK_AIDS, \"\")");
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("---getRiskAids---");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.i("EcshopAdUtil", 2, ((StringBuilder)localObject3).toString());
    }
    if (StringUtil.isEmpty((String)localObject2)) {
      return localObject1;
    }
    localObject1 = new Gson().fromJson((String)localObject2, new EcshopAdUtil.getRiskAids.1().getType());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "gson.fromJson(strJson, o…n<Set<Long?>?>() {}.type)");
    return (HashSet)localObject1;
  }
  
  @JvmStatic
  @Nullable
  public static final List<ChatMessage> a(@Nullable List<? extends ChatMessage> paramList, long paramLong)
  {
    List localList;
    Object localObject1;
    int i;
    int j;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localList = (List)new ArrayList();
      localObject1 = QRoute.api(IEcshopMessageApi.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IEcshopMessageApi::class.java)");
      localObject1 = (IEcshopMessageApi)localObject1;
      i = 0;
      j = ((Collection)paramList).size();
    }
    for (;;)
    {
      ChatMessage localChatMessage;
      Object localObject2;
      if (i < j)
      {
        localChatMessage = (ChatMessage)paramList.get(i);
        localObject2 = (MessageRecord)localChatMessage;
        if (((IEcshopMessageApi)localObject1).isMessageForArkApp((MessageRecord)localObject2))
        {
          localObject2 = ((IEcshopMessageApi)localObject1).getArkMsgMetaList((MessageRecord)localObject2);
          if (StringUtil.isEmpty((String)localObject2)) {
            break label336;
          }
        }
      }
      try
      {
        localObject2 = new JSONObject((String)localObject2).optJSONObject("gdt");
        boolean bool = QLog.isColorLevel();
        if ((bool) && (localObject2 != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("---aid---");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(" gdtJson: ");
          localStringBuilder.append(((JSONObject)localObject2).optString("aid"));
          QLog.i("EcshopAdUtil", 2, localStringBuilder.toString());
        }
        if ((localObject2 != null) && (paramLong == ((JSONObject)localObject2).optLong("aid")))
        {
          localList.add(localChatMessage);
          break label336;
          if (((IEcshopMessageApi)localObject1).isMessageForStructing((MessageRecord)localObject2))
          {
            localObject2 = ((IEcshopMessageApi)localObject1).getStructMsgGdtAid((MessageRecord)localObject2);
            l2 = 0L;
            l1 = l2;
            if (localObject2 == null) {}
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          l1 = Long.parseLong((String)localObject2);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("---aid---");
            ((StringBuilder)localObject2).append(l1);
            QLog.i("EcshopAdUtil", 2, ((StringBuilder)localObject2).toString());
          }
          if (paramLong == l1) {
            localList.add(localChatMessage);
          }
          for (;;)
          {
            label336:
            i += 1;
            break;
            return localList;
            return null;
            localException1 = localException1;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            long l2;
            long l1 = l2;
          }
        }
      }
    }
  }
  
  private final void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdUtil", 2, "---saveRiskAids---");
    }
    Object localObject1 = new Gson();
    Object localObject2 = a();
    ((HashSet)localObject2).add(Long.valueOf(paramLong));
    localObject1 = ((Gson)localObject1).toJson(localObject2);
    localObject2 = (IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class);
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
    ((IQWalletPreferenceApi)localObject2).putString(localAppRuntime.getCurrentAccountUin(), "risk_ids", (String)localObject1);
  }
  
  @JvmStatic
  public static final void a(@NotNull IEcshopChatPieCallback paramIEcshopChatPieCallback, @NotNull List<Long> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramIEcshopChatPieCallback, "chatPieCallback");
    Intrinsics.checkParameterIsNotNull(paramList, "delIds");
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      Set localSet = (Set)a.a();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("---cacheRiskAids---");
        ((StringBuilder)localObject).append(localSet);
        QLog.d("EcshopAdUtil", 2, ((StringBuilder)localObject).toString());
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        long l = ((Number)paramList.next()).longValue();
        if (localSet.contains(Long.valueOf(l)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EcshopAdUtil", 2, "already deleted!!!");
          }
        }
        else
        {
          localObject = a(paramIEcshopChatPieCallback.a(), l);
          if ((localObject != null) && ((((Collection)localObject).isEmpty() ^ true)))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              paramIEcshopChatPieCallback.a((ChatMessage)((Iterator)localObject).next());
            }
            localObject = (IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class);
            AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
            ((IQWalletPreferenceApi)localObject).putString(localAppRuntime.getCurrentAccountUin(), "risk_ad_del_time", DateUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd"));
            a.a(l);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.ad.EcshopAdUtil
 * JD-Core Version:    0.7.0.1
 */