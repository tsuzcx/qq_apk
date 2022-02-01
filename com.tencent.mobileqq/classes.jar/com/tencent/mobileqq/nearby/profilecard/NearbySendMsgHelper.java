package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.CommonTag;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.CommonTag.Tag;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.GetMiniCardReq;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.MiniCard;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NearbySendMsgHelper;", "Lcom/tencent/mobileqq/ark/module/IAppNotifyCallback;", "()V", "ARK_APP_DESC", "", "ARK_APP_ID", "ARK_APP_MIN_VERSION", "ARK_APP_NAME", "ARK_APP_VIEW", "TAG", "TRPC_CMD_GET_MINI_CARD", "map", "Ljava/util/HashMap;", "", "addArkMessage", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "matchUin", "uinType", "", "metaData", "Lorg/json/JSONObject;", "text", "getColors", "", "Lkotlin/Pair;", "getGender", "gender", "getMaritalStatus", "status", "notify", "", "appName", "eventName", "params", "parseArkConfigJson", "miniCard", "Lcom/tencent/trpcprotocol/nearby/trpc_nearby_profile/nearby_profile/nearbyProfile$MiniCard;", "tinyId", "", "registerArkListener", "sendMsg", "func", "Lkotlin/Function1;", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbySendMsgHelper
  implements IAppNotifyCallback
{
  public static final NearbySendMsgHelper a = new NearbySendMsgHelper();
  private static final HashMap<String, Object> b = new HashMap();
  
  private final String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return null;
          }
          return "已婚";
        }
        return "恋爱中";
      }
      return "单身";
    }
    return "保密";
  }
  
  private final JSONObject a(nearbyProfile.MiniCard paramMiniCard, long paramLong)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localObject1 = new StringBuilder();
        Object localObject4 = new Ref.BooleanRef();
        ((Ref.BooleanRef)localObject4).element = false;
        Object localObject2 = new NearbySendMsgHelper.parseArkConfigJson.config.1.1.1((StringBuilder)localObject1, (Ref.BooleanRef)localObject4);
        Object localObject3 = new NearbySendMsgHelper.parseArkConfigJson.config.1.1.2((StringBuilder)localObject1, (NearbySendMsgHelper.parseArkConfigJson.config.1.1.1)localObject2);
        Object localObject5 = NearbyProfileUtil.e(paramMiniCard.constellation.get());
        Intrinsics.checkExpressionValueIsNotNull(localObject5, "it");
        if (((CharSequence)localObject5).length() > 0)
        {
          i = 1;
          if (i != 0)
          {
            ((StringBuilder)localObject1).append((String)localObject5);
            ((Ref.BooleanRef)localObject4).element = true;
          }
          localObject4 = a.a(paramMiniCard.marriage.get());
          if (localObject4 != null) {
            ((NearbySendMsgHelper.parseArkConfigJson.config.1.1.2)localObject3).invoke((String)localObject4);
          }
          localObject4 = a.b(paramMiniCard.gender.get());
          if (localObject4 != null) {
            ((NearbySendMsgHelper.parseArkConfigJson.config.1.1.2)localObject3).invoke((String)localObject4);
          }
          i = paramMiniCard.age.get();
          if (i > 0)
          {
            ((NearbySendMsgHelper.parseArkConfigJson.config.1.1.1)localObject2).invoke();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("岁");
          }
          localObject1 = ((StringBuilder)localObject1).toString();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "it");
          if (((CharSequence)localObject1).length() <= 0) {
            break label819;
          }
          i = 1;
          if (i != 0) {
            localJSONObject1.put("title", localObject1);
          }
          localJSONObject1.put("tinyid", String.valueOf(paramLong));
          localJSONObject1.put("from", "来自“兴趣匹配”");
          localJSONObject1.put("icon_url", paramMiniCard.logo.get());
          localObject2 = new JSONArray();
          localJSONObject1.put("tags", localObject2);
          paramMiniCard = paramMiniCard.common_tag.tag.get();
          Intrinsics.checkExpressionValueIsNotNull(paramMiniCard, "miniCard.common_tag.tag.get()");
          localObject3 = ((Iterable)paramMiniCard).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (nearbyProfile.CommonTag.Tag)((Iterator)localObject3).next();
            i = ((nearbyProfile.CommonTag.Tag)localObject4).type.get();
            if (i == 1)
            {
              paramMiniCard = ((nearbyProfile.CommonTag.Tag)localObject4).name.get();
              if (paramMiniCard.isEmpty()) {
                continue;
              }
              localObject1 = a.b();
              localObject4 = new JSONArray();
              Intrinsics.checkExpressionValueIsNotNull(paramMiniCard, "names");
              localObject5 = ((Iterable)paramMiniCard).iterator();
              if (((Iterator)localObject5).hasNext())
              {
                String str = (String)((Iterator)localObject5).next();
                paramMiniCard = (nearbyProfile.MiniCard)localObject1;
                if (((List)localObject1).isEmpty()) {
                  paramMiniCard = a.b();
                }
                localObject1 = (Pair)paramMiniCard.remove(0);
                JSONObject localJSONObject2 = new JSONObject();
                localJSONObject2.put("text", str);
                localJSONObject2.put("color", ((Pair)localObject1).getFirst());
                localJSONObject2.put("textcolor", ((Pair)localObject1).getSecond());
                ((JSONArray)localObject4).put(localJSONObject2);
                localObject1 = paramMiniCard;
                continue;
              }
              localJSONObject1.put("special_tags", localObject4);
              continue;
            }
            paramMiniCard = new JSONObject();
            localObject5 = ((nearbyProfile.CommonTag.Tag)localObject4).name.get();
            if (((List)localObject5).isEmpty()) {
              continue;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(((nearbyProfile.CommonTag.Tag)localObject4).topic.get());
            ((StringBuilder)localObject1).append("：");
            int j = ((List)localObject5).size();
            Intrinsics.checkExpressionValueIsNotNull(localObject5, "names");
            localObject4 = ((Iterable)localObject5).iterator();
            i = 0;
            if (((Iterator)localObject4).hasNext())
            {
              localObject5 = ((Iterator)localObject4).next();
              if (i < 0) {
                CollectionsKt.throwIndexOverflow();
              }
              ((StringBuilder)localObject1).append((String)localObject5);
              if (i == j - 1) {
                break label825;
              }
              ((StringBuilder)localObject1).append("、");
              break label825;
            }
            localObject1 = ((StringBuilder)localObject1).toString();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply {\n…             }.toString()");
            paramMiniCard.put("text", localObject1);
            ((JSONArray)localObject2).put(paramMiniCard);
            continue;
          }
          paramMiniCard = new JSONObject();
          paramMiniCard.put("config", localJSONObject1);
          return paramMiniCard;
        }
      }
      catch (Exception paramMiniCard)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create json error: ");
        ((StringBuilder)localObject1).append(paramMiniCard);
        QLog.e("NearbySendMsgHelper", 1, ((StringBuilder)localObject1).toString());
        return (JSONObject)null;
      }
      int i = 0;
      continue;
      label819:
      i = 0;
      continue;
      label825:
      i += 1;
    }
  }
  
  private final void a()
  {
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.nearbyprofilecard", (IAppNotifyCallback)this);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, long paramLong, @NotNull String paramString1, int paramInt, @NotNull String paramString2, @Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramString1, "matchUin");
    Intrinsics.checkParameterIsNotNull(paramString2, "text");
    if (b.get(paramString1) != null)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("added already: uin=");
      paramQQAppInterface.append(paramString1);
      QLog.i("NearbySendMsgHelper", 1, paramQQAppInterface.toString());
      return;
    }
    nearbyProfile.GetMiniCardReq localGetMiniCardReq = new nearbyProfile.GetMiniCardReq();
    localGetMiniCardReq.target_id.add(Long.valueOf(paramLong));
    ProtoUtils.a((AppRuntime)paramQQAppInterface, (ProtoUtils.TroopProtocolObserver)new NearbySendMsgHelper.sendMsg.1(paramFunction1, paramLong, paramString1, paramQQAppInterface, paramInt, paramString2), localGetMiniCardReq.toByteArray(), "trpc.nearby.trpc_nearby_profile.trpc_nearby_profile.GetMiniCard");
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, long paramLong, @NotNull String paramString, int paramInt, @Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    a(paramQQAppInterface, paramLong, paramString, paramInt, null, paramFunction1, 16, null);
  }
  
  private final void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, JSONObject paramJSONObject, String paramString2)
  {
    NearbyProfileReportKt.a(paramQQAppInterface, paramString1);
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = paramInt;
    localSessionInfo.b = paramString1;
    localSessionInfo.c = "";
    paramString1 = new JSONObject();
    paramString1.put("showSender", 0);
    paramString1 = new ArkAppMessage(paramString2, "com.tencent.nearbyprofilecard", paramString2, "nearbyprofilecard", "", paramJSONObject.toString(), paramString1.toString(), paramString2);
    paramString1 = MessageRecordFactory.b(paramQQAppInterface, localSessionInfo.b, localSessionInfo.c, localSessionInfo.a, paramString1);
    paramQQAppInterface.getMessageFacade().b(CollectionsKt.listOf(paramString1), paramQQAppInterface.getCurrentUin());
    a();
  }
  
  private final String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      return "女";
    }
    return "男";
  }
  
  private final List<Pair<String, String>> b()
  {
    List localList = CollectionsKt.mutableListOf(new String[] { "4D94FF", "00CAFC", "21D9C6", "00D96D", "FF9F40", "FF596A", "FF80CC", "C773FF" });
    LinkedList localLinkedList = new LinkedList();
    while ((((Collection)localList).isEmpty() ^ true))
    {
      String str = (String)localList.remove(Random.Default.nextInt(0, localList.size()));
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0x33");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0xFF");
      localStringBuilder.append(str);
      localLinkedList.add(new Pair(localObject, localStringBuilder.toString()));
    }
    return (List)localLinkedList;
  }
  
  public boolean notify(@Nullable String paramString1, @Nullable String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString3, "params");
    paramString1 = QBaseActivity.sTopActivity;
    if (paramString1 != null)
    {
      try
      {
        paramString2 = new JSONObject(paramString3);
        paramString3 = new JSONObject();
        paramString3.put("mode", -1);
        paramString3.put("source", 5);
        paramString3.put("tinnyid", paramString2.getString("param"));
        paramString3 = paramString3.toString();
        Intrinsics.checkExpressionValueIsNotNull(paramString3, "jsonObject.toString()");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openProfileCard: ");
        ((StringBuilder)localObject).append(paramString3);
        QLog.d("NearbySendMsgHelper", 2, ((StringBuilder)localObject).toString());
        paramString2 = paramString2.getString("param");
        Intrinsics.checkExpressionValueIsNotNull(paramString2, "tinnyid");
        NearbyProfileReportKt.a(paramString2);
        paramString3 = new AllInOne(paramString2, 19);
        localObject = new Intent();
        ((Intent)localObject).putExtra("AllInOne", (Parcelable)paramString3);
        ((Intent)localObject).putExtra("param_mode", 3);
        ((Intent)localObject).putExtra("param_tiny_id", paramString2);
        paramString1.startActivity((Intent)localObject);
        RouteUtils.a((Context)paramString1, (Intent)localObject, "/nearby/people/profile");
      }
      catch (JSONException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("openProfileCard JSONException:");
        paramString2.append(paramString1);
        QLog.e("NearbySendMsgHelper", 2, paramString2.toString());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbySendMsgHelper
 * JD-Core Version:    0.7.0.1
 */