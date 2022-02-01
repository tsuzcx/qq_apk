package com.tencent.mobileqq.kandian.biz.xtab.badge;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isXTabBadgeMsg", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "toRIJXTabBadgeInfo", "Lcom/tencent/mobileqq/kandian/repo/tab/RIJXTabRedDotInfo;", "kandian_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class RIJXTabBadgeInfoExtKt
{
  @Nullable
  public static final RIJXTabRedDotInfo a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "$this$toRIJXTabBadgeInfo");
    boolean bool = paramMessageRecord instanceof MessageForStructing;
    Object localObject3 = null;
    if (!bool) {
      localObject1 = null;
    } else {
      localObject1 = paramMessageRecord;
    }
    Object localObject1 = (MessageForStructing)localObject1;
    if (localObject1 != null)
    {
      Object localObject2 = ((MessageForStructing)localObject1).structingMsg;
      if (localObject2 != null)
      {
        localObject1 = ((AbsStructMsg)localObject2).mMsgActionData;
        if (localObject1 != null)
        {
          JSONObject localJSONObject = new JSONObject((String)localObject1);
          localObject1 = ((AbsStructMsg)localObject2).mAlgorithmIds;
          if (localObject1 == null) {
            localObject1 = "";
          }
          String str1 = ((AbsStructMsg)localObject2).mStrategyIds;
          if (str1 == null) {
            str1 = "";
          }
          String str2 = ((AbsStructMsg)localObject2).reportEventFolderStatusValue;
          if (str2 == null) {
            str2 = "";
          }
          localObject2 = ((AbsStructMsg)localObject2).mArticleIds;
          if (localObject2 == null) {
            localObject2 = "";
          }
          long l1 = paramMessageRecord.time;
          long l2 = 1000;
          if (!localJSONObject.has("cid")) {
            return null;
          }
          int i = localJSONObject.optInt("cid", -1);
          int j = localJSONObject.optInt("pcid", -1);
          long l3 = localJSONObject.optLong("uin", 0L);
          if (localJSONObject.optInt("big", 0) == 1) {
            bool = true;
          } else {
            bool = false;
          }
          localJSONObject = localJSONObject.optJSONObject("red_info");
          paramMessageRecord = localObject3;
          if (localJSONObject != null) {
            paramMessageRecord = localJSONObject.toString();
          }
          return new RIJXTabRedDotInfo((String)localObject1, str1, str2, (String)localObject2, l1 * l2, i, j, l3, bool, paramMessageRecord, 0L, 1024, null);
        }
      }
    }
    return null;
  }
  
  public static final boolean a(@NotNull MessageRecord paramMessageRecord, @NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "$this$isXTabBadgeMsg");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    int i = KandianMergeManager.a(paramMessageRecord, (AppInterface)paramQQAppInterface);
    boolean bool = false;
    if (i != 0) {
      return false;
    }
    if (a(paramMessageRecord) != null) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeInfoExtKt
 * JD-Core Version:    0.7.0.1
 */