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
    Object localObject = RIJQQAppInterfaceUtil.a();
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
        TroopBarAssistantManager.a().a(localQQAppInterface, ((Message)localObject).frienduin);
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
    Object localObject1 = RIJQQAppInterfaceUtil.a();
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
      paramMessageRecord.jdField_a_of_type_Long = paramLong1;
      paramMessageRecord.jdField_a_of_type_JavaLangString = ((MessageRecord)localObject1).frienduin;
      paramMessageRecord.b = i;
      try
      {
        if ((localObject1 instanceof MessageForPubAccount))
        {
          ((MessageForPubAccount)localObject1).parse();
          paramMessageRecord.jdField_a_of_type_Int = 1;
          paramContext = ((MessageForPubAccount)localObject1).mPAMessage;
          if (paramContext != null)
          {
            paramContext = paramContext.items.iterator();
            while (paramContext.hasNext())
            {
              paramString = (PAMessage.Item)paramContext.next();
              localObject2 = new SubscriptionFeedItem();
              ((SubscriptionFeedItem)localObject2).jdField_a_of_type_Int = 1;
              ((SubscriptionFeedItem)localObject2).jdField_a_of_type_JavaLangString = paramString.cover;
              ((SubscriptionFeedItem)localObject2).d = paramString.url;
              ((SubscriptionFeedItem)localObject2).e = paramString.actionData;
              ((SubscriptionFeedItem)localObject2).b = paramString.title;
              paramMessageRecord.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
          }
        }
        else if ((localObject1 instanceof MessageForStructing))
        {
          ((MessageForStructing)localObject1).parse();
          paramMessageRecord.jdField_a_of_type_Int = 1;
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
                localSubscriptionFeedItem.jdField_a_of_type_Int = 1;
                localSubscriptionFeedItem.c = localAbsStructMsgElement1.g;
                localSubscriptionFeedItem.g = paramString.mTagName;
                if ((localAbsStructMsgElement1 instanceof AbsStructMsgItem))
                {
                  paramContext = ((AbsStructMsgItem)localAbsStructMsgElement1).a.iterator();
                  for (;;)
                  {
                    if (!paramContext.hasNext()) {
                      break label631;
                    }
                    Object localObject3 = (AbsStructMsgElement)paramContext.next();
                    if ((localObject3 instanceof StructMsgItemCover))
                    {
                      localSubscriptionFeedItem.jdField_a_of_type_JavaLangString = ((StructMsgItemCover)localObject3).ac;
                    }
                    else if ((localObject3 instanceof StructMsgItemTitle))
                    {
                      localSubscriptionFeedItem.b = ((StructMsgItemTitle)localObject3).b();
                    }
                    else if ((localObject3 instanceof StructMsgItemVideo))
                    {
                      localSubscriptionFeedItem.jdField_a_of_type_JavaLangString = ((StructMsgItemVideo)localObject3).ac;
                    }
                    else if ((localObject3 instanceof StructMsgItemPAAudio))
                    {
                      localSubscriptionFeedItem.jdField_a_of_type_JavaLangString = ((StructMsgItemPAAudio)localObject3).ac;
                    }
                    else if ((localObject3 instanceof StructMsgItemPAVideo))
                    {
                      localSubscriptionFeedItem.jdField_a_of_type_JavaLangString = ((StructMsgItemPAVideo)localObject3).ac;
                    }
                    else if ((localObject3 instanceof StructMsgGroupElement))
                    {
                      localObject3 = ((StructMsgGroupElement)localObject3).jdField_a_of_type_JavaUtilList.iterator();
                      if (((Iterator)localObject3).hasNext())
                      {
                        AbsStructMsgElement localAbsStructMsgElement2 = (AbsStructMsgElement)((Iterator)localObject3).next();
                        if (!(localAbsStructMsgElement2 instanceof StructMsgItemTitle)) {
                          break;
                        }
                        localSubscriptionFeedItem.b = ((StructMsgItemTitle)localAbsStructMsgElement2).b();
                      }
                    }
                  }
                  label631:
                  if (TextUtils.isEmpty((CharSequence)localAbsStructMsgElement1.b)) {
                    paramContext = paramString.mMsgUrl;
                  } else {
                    paramContext = localAbsStructMsgElement1.b;
                  }
                  localSubscriptionFeedItem.d = paramContext;
                }
                else
                {
                  localSubscriptionFeedItem.jdField_a_of_type_Int = 0;
                }
                if (localAbsStructMsgElement1 == null) {
                  break;
                }
                if ((((AbsStructMsgItem)localAbsStructMsgElement1).a.size() != 1) || (!((AbsStructMsgElement)((AbsStructMsgItem)localAbsStructMsgElement1).a.get(0) instanceof StructMsgItemHr))) {
                  paramMessageRecord.jdField_a_of_type_JavaUtilList.add(localSubscriptionFeedItem);
                }
              }
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.structmsg.AbsStructMsgItem");
            }
          }
        }
        else if ((localObject1 instanceof MessageForPic))
        {
          ((MessageForPic)localObject1).parse();
          paramMessageRecord.jdField_a_of_type_Int = 3;
          paramString = new SubscriptionFeedItem();
          paramString.jdField_a_of_type_Int = 2;
          paramString.c = ((QQAppInterface)localObject2).getMessageFacade().b(paramContext, (MessageRecord)localObject1, false);
          paramString.f = ((MessageForPic)localObject1).path;
          paramString.jdField_a_of_type_JavaNetURL = URLDrawableHelper.getURL((PicUiInterface)localObject1, 65537, null);
          paramMessageRecord.jdField_a_of_type_JavaUtilList.add(paramString);
        }
        else
        {
          if ((localObject1 instanceof MessageForText))
          {
            paramMessageRecord.jdField_a_of_type_Int = 0;
            ((MessageForText)localObject1).parse();
          }
          else if ((localObject1 instanceof MessageForVideo))
          {
            paramMessageRecord.jdField_a_of_type_Int = 2;
            ((MessageForVideo)localObject1).parse();
          }
          else if ((localObject1 instanceof MessageForShortVideo))
          {
            paramMessageRecord.jdField_a_of_type_Int = 2;
            ((MessageForShortVideo)localObject1).parse();
          }
          else if ((localObject1 instanceof MessageForPtt))
          {
            paramMessageRecord.jdField_a_of_type_Int = 4;
          }
          paramString = new SubscriptionFeedItem();
          paramString.jdField_a_of_type_Int = 0;
          paramString.c = ((QQAppInterface)localObject2).getMessageFacade().b(paramContext, (MessageRecord)localObject1, false);
          paramMessageRecord.jdField_a_of_type_JavaUtilList.add(paramString);
        }
      }
      catch (Exception paramContext)
      {
        paramMessageRecord.jdField_a_of_type_Int = 0;
        paramString = new SubscriptionFeedItem();
        paramString.jdField_a_of_type_Int = 0;
        paramString.c = ((MessageRecord)localObject1).msg;
        paramMessageRecord.jdField_a_of_type_JavaUtilList.clear();
        paramMessageRecord.jdField_a_of_type_JavaUtilList.add(paramString);
        if (QLog.isColorLevel()) {
          QLog.w("SubscriptionFeed", 2, "convertMsgToSubscriptionFeed exception: ", (Throwable)paramContext);
        }
      }
      label1034:
      paramMessageRecord.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      return paramMessageRecord;
    }
    paramContext = new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    for (;;)
    {
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.impl.RIJSubscriptionFeedsImpl
 * JD-Core Version:    0.7.0.1
 */