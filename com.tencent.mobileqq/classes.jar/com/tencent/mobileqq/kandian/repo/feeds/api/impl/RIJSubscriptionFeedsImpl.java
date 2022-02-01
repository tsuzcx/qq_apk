package com.tencent.mobileqq.kandian.repo.feeds.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.feeds.api.IRIJSubscriptionFeeds;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeedItem;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgGroupElement;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/api/impl/RIJSubscriptionFeedsImpl;", "Lcom/tencent/mobileqq/kandian/repo/feeds/api/IRIJSubscriptionFeeds;", "()V", "clearUnreadMsg", "", "uin", "", "convertMsgToSubscriptionFeed", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SubscriptionFeed;", "context", "Landroid/content/Context;", "latestMessage", "Lcom/tencent/mobileqq/data/MessageRecord;", "lastMsgTime", "", "lastDraftTime", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJSubscriptionFeedsImpl
  implements IRIJSubscriptionFeeds
{
  public boolean clearUnreadMsg(@Nullable String paramString)
  {
    Object localObject = RIJQQAppInterfaceUtil.e();
    if (localObject != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = (Message)null;
      int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType((AppInterface)localQQAppInterface, paramString);
      QQMessageFacade localQQMessageFacade = localQQAppInterface.getMessageFacade();
      if (localQQMessageFacade != null) {
        localObject = localQQMessageFacade.getLastMessage(paramString, i);
      }
      if (localObject != null)
      {
        TroopBarAssistantManager.a().c(localQQAppInterface, ((Message)localObject).frienduin);
        paramString = localQQAppInterface.getConversationFacade();
        if (paramString != null) {
          paramString.a(((Message)localObject).frienduin, ((Message)localObject).istroop, true);
        }
        return true;
      }
      return false;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @Nullable
  public SubscriptionFeed convertMsgToSubscriptionFeed(@Nullable Context paramContext, @Nullable MessageRecord paramMessageRecord, @Nullable String paramString, long paramLong1, long paramLong2)
  {
    Object localObject1 = RIJQQAppInterfaceUtil.e();
    if (localObject1 != null)
    {
      Object localObject2 = (QQAppInterface)localObject1;
      localObject1 = paramMessageRecord;
      if (paramMessageRecord == null)
      {
        paramString = ((QQAppInterface)localObject2).getMessageFacade().getLastMessage(paramString, 1008);
        if (paramString != null) {
          paramMessageRecord = (MessageRecord)paramString;
        }
        localObject1 = paramMessageRecord;
        if (paramMessageRecord == null) {
          return null;
        }
      }
      paramMessageRecord = new SubscriptionFeed();
      paramString = ((QQAppInterface)localObject2).getConversationFacade();
      int i;
      if (paramString != null) {
        i = paramString.a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
      } else {
        i = 0;
      }
      if (paramLong1 <= paramLong2) {
        paramLong1 = paramLong2;
      }
      paramMessageRecord.d = paramLong1;
      paramMessageRecord.c = ((MessageRecord)localObject1).frienduin;
      paramMessageRecord.b = i;
      try
      {
        if ((localObject1 instanceof MessageForPubAccount))
        {
          ((MessageForPubAccount)localObject1).parse();
          paramMessageRecord.a = 1;
          paramContext = ((MessageForPubAccount)localObject1).mPAMessage;
          if (paramContext != null)
          {
            paramContext = paramContext.items.iterator();
            while (paramContext.hasNext())
            {
              paramString = (PAMessage.Item)paramContext.next();
              localObject2 = new SubscriptionFeedItem();
              ((SubscriptionFeedItem)localObject2).a = 1;
              ((SubscriptionFeedItem)localObject2).b = paramString.cover;
              ((SubscriptionFeedItem)localObject2).e = paramString.url;
              ((SubscriptionFeedItem)localObject2).f = paramString.actionData;
              ((SubscriptionFeedItem)localObject2).c = paramString.title;
              paramMessageRecord.e.add(localObject2);
            }
          }
        }
        else if ((localObject1 instanceof MessageForStructing))
        {
          ((MessageForStructing)localObject1).parse();
          paramMessageRecord.a = 1;
          paramString = ((MessageForStructing)localObject1).structingMsg;
          if ((paramString != null) && ((paramString instanceof AbsShareMsg)))
          {
            paramContext = ((AbsShareMsg)paramString).getStructMsgItemLists();
            if ((QLog.isColorLevel()) && ((paramContext == null) || (paramContext.isEmpty()))) {
              QLog.w("SubscriptionFeed", 2, "convertMsgToSubscriptionFeed MessageForStructing itemlist size = 0");
            }
            if (paramContext != null)
            {
              localObject2 = paramContext.iterator();
              for (;;)
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break label1034;
                }
                AbsStructMsgElement localAbsStructMsgElement1 = (AbsStructMsgElement)((Iterator)localObject2).next();
                SubscriptionFeedItem localSubscriptionFeedItem = new SubscriptionFeedItem();
                localSubscriptionFeedItem.a = 1;
                localSubscriptionFeedItem.d = localAbsStructMsgElement1.i;
                localSubscriptionFeedItem.i = paramString.mTagName;
                if ((localAbsStructMsgElement1 instanceof AbsStructMsgItem))
                {
                  paramContext = ((AbsStructMsgItem)localAbsStructMsgElement1).ax.iterator();
                  for (;;)
                  {
                    if (!paramContext.hasNext()) {
                      break label631;
                    }
                    Object localObject3 = (AbsStructMsgElement)paramContext.next();
                    if ((localObject3 instanceof StructMsgItemCover))
                    {
                      localSubscriptionFeedItem.b = ((StructMsgItemCover)localObject3).av;
                    }
                    else if ((localObject3 instanceof StructMsgItemTitle))
                    {
                      localSubscriptionFeedItem.c = ((StructMsgItemTitle)localObject3).e();
                    }
                    else if ((localObject3 instanceof StructMsgItemVideo))
                    {
                      localSubscriptionFeedItem.b = ((StructMsgItemVideo)localObject3).au;
                    }
                    else if ((localObject3 instanceof StructMsgItemPAAudio))
                    {
                      localSubscriptionFeedItem.b = ((StructMsgItemPAAudio)localObject3).au;
                    }
                    else if ((localObject3 instanceof StructMsgItemPAVideo))
                    {
                      localSubscriptionFeedItem.b = ((StructMsgItemPAVideo)localObject3).au;
                    }
                    else if ((localObject3 instanceof StructMsgGroupElement))
                    {
                      localObject3 = ((StructMsgGroupElement)localObject3).au.iterator();
                      if (((Iterator)localObject3).hasNext())
                      {
                        AbsStructMsgElement localAbsStructMsgElement2 = (AbsStructMsgElement)((Iterator)localObject3).next();
                        if (!(localAbsStructMsgElement2 instanceof StructMsgItemTitle)) {
                          break;
                        }
                        localSubscriptionFeedItem.c = ((StructMsgItemTitle)localAbsStructMsgElement2).e();
                      }
                    }
                  }
                  label631:
                  if (TextUtils.isEmpty((CharSequence)localAbsStructMsgElement1.d)) {
                    paramContext = paramString.mMsgUrl;
                  } else {
                    paramContext = localAbsStructMsgElement1.d;
                  }
                  localSubscriptionFeedItem.e = paramContext;
                }
                else
                {
                  localSubscriptionFeedItem.a = 0;
                }
                if (localAbsStructMsgElement1 == null) {
                  break;
                }
                if ((((AbsStructMsgItem)localAbsStructMsgElement1).ax.size() != 1) || (!((AbsStructMsgElement)((AbsStructMsgItem)localAbsStructMsgElement1).ax.get(0) instanceof StructMsgItemHr))) {
                  paramMessageRecord.e.add(localSubscriptionFeedItem);
                }
              }
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.structmsg.AbsStructMsgItem");
            }
          }
        }
        else if ((localObject1 instanceof MessageForPic))
        {
          ((MessageForPic)localObject1).parse();
          paramMessageRecord.a = 3;
          paramString = new SubscriptionFeedItem();
          paramString.a = 2;
          paramString.d = ((QQAppInterface)localObject2).getMessageFacade().c(paramContext, (MessageRecord)localObject1, false);
          paramString.g = ((MessageForPic)localObject1).path;
          paramString.h = URLDrawableHelper.getURL((PicUiInterface)localObject1, 65537, null);
          paramMessageRecord.e.add(paramString);
        }
        else
        {
          if ((localObject1 instanceof MessageForText))
          {
            paramMessageRecord.a = 0;
            ((MessageForText)localObject1).parse();
          }
          else if ((localObject1 instanceof MessageForVideo))
          {
            paramMessageRecord.a = 2;
            ((MessageForVideo)localObject1).parse();
          }
          else if ((localObject1 instanceof MessageForShortVideo))
          {
            paramMessageRecord.a = 2;
            ((MessageForShortVideo)localObject1).parse();
          }
          else if ((localObject1 instanceof MessageForPtt))
          {
            paramMessageRecord.a = 4;
          }
          paramString = new SubscriptionFeedItem();
          paramString.a = 0;
          paramString.d = ((QQAppInterface)localObject2).getMessageFacade().c(paramContext, (MessageRecord)localObject1, false);
          paramMessageRecord.e.add(paramString);
        }
      }
      catch (Exception paramContext)
      {
        paramMessageRecord.a = 0;
        paramString = new SubscriptionFeedItem();
        paramString.a = 0;
        paramString.d = ((MessageRecord)localObject1).msg;
        paramMessageRecord.e.clear();
        paramMessageRecord.e.add(paramString);
        if (QLog.isColorLevel()) {
          QLog.w("SubscriptionFeed", 2, "convertMsgToSubscriptionFeed exception: ", (Throwable)paramContext);
        }
      }
      label1034:
      paramMessageRecord.f = new WeakReference(localObject1);
      return paramMessageRecord;
    }
    paramContext = new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    for (;;)
    {
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.impl.RIJSubscriptionFeedsImpl
 * JD-Core Version:    0.7.0.1
 */