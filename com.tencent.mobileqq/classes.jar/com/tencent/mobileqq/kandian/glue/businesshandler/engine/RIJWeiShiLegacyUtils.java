package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.structmsg.FeedsStructMsg;
import com.tencent.mobileqq.kandian.repo.db.struct.WeishiRedDotInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.AbsBaseVideoArticleInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/RIJWeiShiLegacyUtils;", "", "()V", "commonConfigMessageRecord", "", "newMessageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "brief", "", "time", "", "configureTextMsgWithFields", "mr", "createMsgForWeishi", "createStructingMsgBrief", "app", "Lcom/tencent/common/app/AppInterface;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "Lcom/tencent/mobileqq/kandian/repo/video/entity/AbsBaseVideoArticleInfo;", "getLatestArticleListIngoreState", "", "getLatestStructMsg", "Lcom/tencent/mobileqq/data/MessageForStructing;", "getLatestStructMsgIngoreState", "getMsgActionDataIngoreState", "getRedDotInfo", "Lcom/tencent/mobileqq/kandian/repo/db/struct/WeishiRedDotInfo;", "isMessageRecordFromWeiShi", "", "newTextMsgWithFields", "setRead", "activity", "Landroid/app/Activity;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWeiShiLegacyUtils
{
  public static final RIJWeiShiLegacyUtils a = new RIJWeiShiLegacyUtils();
  
  private final MessageRecord a(MessageRecord paramMessageRecord, String paramString, long paramLong)
  {
    MessageRecord localMessageRecord = (MessageRecord)null;
    if (paramMessageRecord == null) {
      return null;
    }
    localMessageRecord = MessageRecordFactory.a(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString, paramLong);
    return localMessageRecord;
  }
  
  @JvmStatic
  @Nullable
  public static final String a(@Nullable AppInterface paramAppInterface, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    String str = FeedsStructMsg.a(paramAppInterface, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo = FeedsStructMsg.a(paramAbsBaseArticleInfo);
    paramAppInterface = paramAbsBaseArticleInfo;
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append(str);
      paramAppInterface.append(": ");
      paramAppInterface.append(paramAbsBaseArticleInfo);
      paramAppInterface = paramAppInterface.toString();
    }
    return paramAppInterface;
  }
  
  @JvmStatic
  @NotNull
  public static final String a(@Nullable AbsBaseVideoArticleInfo paramAbsBaseVideoArticleInfo)
  {
    if (paramAbsBaseVideoArticleInfo == null) {
      return "";
    }
    String str = paramAbsBaseVideoArticleInfo.subscribeName;
    Intrinsics.checkExpressionValueIsNotNull(str, "articleInfo.subscribeName");
    Object localObject = paramAbsBaseVideoArticleInfo.title;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "articleInfo.title");
    paramAbsBaseVideoArticleInfo = (AbsBaseVideoArticleInfo)localObject;
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      paramAbsBaseVideoArticleInfo = new StringBuilder();
      paramAbsBaseVideoArticleInfo.append(str);
      paramAbsBaseVideoArticleInfo.append(": ");
      paramAbsBaseVideoArticleInfo.append((String)localObject);
      paramAbsBaseVideoArticleInfo = paramAbsBaseVideoArticleInfo.toString();
    }
    localObject = paramAbsBaseVideoArticleInfo;
    if (TextUtils.isEmpty((CharSequence)paramAbsBaseVideoArticleInfo)) {
      localObject = "";
    }
    return localObject;
  }
  
  private final void a(MessageRecord paramMessageRecord, String paramString, long paramLong)
  {
    if (paramMessageRecord == null) {
      Intrinsics.throwNpe();
    }
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.WEISHI_UIN;
    paramMessageRecord.senderuin = AppConstants.WEISHI_UIN;
    paramMessageRecord.istroop = 1008;
    paramMessageRecord.msg = paramString;
    paramMessageRecord.time = paramLong;
    paramMessageRecord.createMessageUniseq();
  }
  
  @Nullable
  public final MessageForStructing a()
  {
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    if (localObject1 != null)
    {
      Object localObject3 = (QQAppInterface)localObject1;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((QQAppInterface)localObject3).getMessageFacade() != null)
        {
          localObject1 = ((QQAppInterface)localObject3).getMessageFacade();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.messageFacade");
          if (((QQMessageFacade)localObject1).a() == null) {
            return null;
          }
          localObject3 = ((QQAppInterface)localObject3).getMessageFacade().b(AppConstants.WEISHI_UIN, 1008);
          localObject1 = localObject2;
          if ((localObject3 instanceof MessageForStructing)) {
            localObject1 = (MessageForStructing)localObject3;
          }
        }
      }
      return localObject1;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @Nullable
  public final MessageRecord a(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "brief");
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      localObject = (QQAppInterface)localObject;
      if (localObject != null)
      {
        MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
        localMessageRecord.selfuin = ((QQAppInterface)localObject).getCurrentAccountUin();
        a(localMessageRecord, paramString, paramLong);
        return localMessageRecord;
      }
      return null;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @Nullable
  public final WeishiRedDotInfo a()
  {
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    if (localObject1 != null)
    {
      Object localObject3 = (QQAppInterface)localObject1;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((QQAppInterface)localObject3).getMessageFacade() != null)
        {
          if (((QQAppInterface)localObject3).getConversationFacade() == null) {
            return null;
          }
          localObject1 = ((QQAppInterface)localObject3).getMessageFacade();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.messageFacade");
          ConversationFacade localConversationFacade = ((QQMessageFacade)localObject1).a();
          Intrinsics.checkExpressionValueIsNotNull(localConversationFacade, "app.messageFacade.conversationFacade");
          localObject1 = localObject2;
          if (localConversationFacade.a(AppConstants.WEISHI_UIN, 1008) > 0)
          {
            localObject3 = ((QQAppInterface)localObject3).getMessageFacade().b(AppConstants.WEISHI_UIN, 1008);
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "app.messageFacade.getLas….UIN_TYPE_PUBLIC_ACCOUNT)");
            localObject1 = localObject2;
            if ((localObject3 instanceof MessageForStructing)) {
              localObject1 = new WeishiRedDotInfo((MessageForStructing)localObject3);
            }
          }
        }
      }
      return localObject1;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((MessageForStructing)localObject).structingMsg;
      if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)((AbsStructMsg)localObject).mMsgActionData)))
      {
        localObject = ((AbsStructMsg)localObject).mMsgActionData;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "structingMsg.mMsgActionData");
        return localObject;
      }
    }
    return "";
  }
  
  @Nullable
  public final List<Long> a()
  {
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    if (localObject1 != null)
    {
      Object localObject2 = (QQAppInterface)localObject1;
      if (localObject2 != null)
      {
        localObject1 = (List)new ArrayList();
        if (((QQAppInterface)localObject2).getMessageFacade() != null)
        {
          Object localObject3 = ((QQAppInterface)localObject2).getMessageFacade();
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "app.messageFacade");
          if (((QQMessageFacade)localObject3).a() == null) {
            return null;
          }
          localObject2 = ((QQAppInterface)localObject2).getMessageFacade().b(AppConstants.WEISHI_UIN, 1008);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.messageFacade.getLas….UIN_TYPE_PUBLIC_ACCOUNT)");
          if ((localObject2 instanceof MessageForStructing))
          {
            localObject2 = (MessageForStructing)localObject2;
            if ((((MessageForStructing)localObject2).structingMsg != null) && (!TextUtils.isEmpty((CharSequence)((MessageForStructing)localObject2).structingMsg.mArticleIds)))
            {
              localObject2 = ((MessageForStructing)localObject2).structingMsg.mArticleIds;
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "structing.structingMsg.mArticleIds");
              localObject2 = (CharSequence)localObject2;
              localObject3 = new Regex("\\|");
              int i = 0;
              localObject2 = ((Collection)((Regex)localObject3).split((CharSequence)localObject2, 0)).toArray(new String[0]);
              if (localObject2 != null)
              {
                localObject2 = (String[])localObject2;
                int j = localObject2.length;
                while (i < j)
                {
                  localObject3 = Long.valueOf(localObject2[i]);
                  Intrinsics.checkExpressionValueIsNotNull(localObject3, "java.lang.Long.valueOf(ids[i])");
                  ((List)localObject1).add(localObject3);
                  i += 1;
                }
              }
              throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
          }
          return localObject1;
        }
      }
      return null;
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public final void a(@Nullable Activity paramActivity)
  {
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    if (localObject1 != null)
    {
      localObject1 = (QQAppInterface)localObject1;
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getMessageFacade();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.messageFacade");
        localObject2 = ((QQMessageFacade)localObject2).a();
        if ((localObject2 != null) && (((ConversationFacade)localObject2).a(AppConstants.WEISHI_UIN, 1008) > 0)) {
          ThreadManager.post((Runnable)new RIJWeiShiLegacyUtils.setRead.1((QQAppInterface)localObject1, paramActivity), 8, null, false);
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public final void a(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "brief");
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      localObject = (QQAppInterface)localObject;
      if (localObject != null)
      {
        if (TextUtils.isEmpty((CharSequence)paramString)) {
          return;
        }
        QQMessageFacade localQQMessageFacade = ((QQAppInterface)localObject).getMessageFacade();
        if (localQQMessageFacade != null) {
          ThreadManager.post((Runnable)new RIJWeiShiLegacyUtils.createMsgForWeishi.1(localQQMessageFacade, paramString, paramLong, (QQAppInterface)localObject), 10, null, false);
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public final boolean a(@Nullable MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return TextUtils.equals((CharSequence)paramMessageRecord.frienduin, (CharSequence)AppConstants.WEISHI_UIN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils
 * JD-Core Version:    0.7.0.1
 */