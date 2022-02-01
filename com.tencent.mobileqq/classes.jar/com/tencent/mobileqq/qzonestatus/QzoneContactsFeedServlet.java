package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.QzoneData;
import NS_MOBILE_NEWEST_FEEDS.feed_info;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import NS_QQ_STORY_META.META.StImage;
import NS_QQ_STORY_META.META.StStoryFeed;
import NS_WEISHI_QQ_PROFILE.stGetNewestFeedRspInner;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneContactsFeedServlet
  extends MSFServlet
{
  private void b(boolean paramBoolean, newest_feeds_rsp paramnewest_feeds_rsp)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    if ((paramBoolean) && (paramnewest_feeds_rsp != null))
    {
      a(paramBoolean, paramnewest_feeds_rsp);
      localQQAppInterface.getContactsFeedManager().a(paramnewest_feeds_rsp);
      localQQAppInterface.getContactsFeedManager().f();
      return;
    }
    localQQAppInterface.getContactsFeedManager().e();
  }
  
  protected void a(boolean paramBoolean, newest_feeds_rsp paramnewest_feeds_rsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed isSuc=%s last_feed_time=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramnewest_feeds_rsp.last_feed_time) }));
    }
    Object localObject1;
    FriendsManager localFriendsManager;
    if (paramBoolean)
    {
      localObject1 = (QQAppInterface)getAppRuntime();
      if (localObject1 != null)
      {
        localFriendsManager = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localFriendsManager == null) {}
      }
    }
    label936:
    label939:
    label944:
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject3 = paramnewest_feeds_rsp.mapVcByte;
        Object localObject2 = localObject1;
        Object localObject4;
        long l;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!((Map)localObject3).isEmpty())
          {
            localObject4 = ((Map)localObject3).keySet().iterator();
            localObject2 = localObject1;
            if (((Iterator)localObject4).hasNext())
            {
              localObject2 = (Long)((Iterator)localObject4).next();
              Object localObject5 = (QzoneData)((Map)localObject3).get(localObject2);
              localObject2 = localFriendsManager.x(String.valueOf(localObject2));
              if (localObject2 == null) {
                continue;
              }
              Object localObject6;
              if (((QzoneData)localObject5).iType == 2)
              {
                localObject6 = new JceInputStream();
                ((JceInputStream)localObject6).wrap(((QzoneData)localObject5).vcByte);
                ((JceInputStream)localObject6).setServerEncoding("utf-8");
                localObject5 = new stGetNewestFeedRspInner();
                ((stGetNewestFeedRspInner)localObject5).readFrom((JceInputStream)localObject6);
                localObject6 = ((stGetNewestFeedRspInner)localObject5).mapItemInfo;
                if ((localObject6 == null) || (((Map)localObject6).isEmpty())) {
                  break label936;
                }
                localObject5 = (String)((Map)localObject6).get("upload_time");
                localObject6 = (String)((Map)localObject6).get("desc");
                if (QLog.isColorLevel()) {
                  QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed weishi feed, uploadTime=%s desc=%s", new Object[] { localObject5, localObject6 }));
                }
                try
                {
                  l = Long.valueOf((String)localObject5).longValue();
                  try
                  {
                    if ((((ExtensionInfo)localObject2).feedTime > l) && (((ExtensionInfo)localObject2).feedType != 1)) {
                      break label936;
                    }
                    ((ExtensionInfo)localObject2).feedType = 1;
                    ((ExtensionInfo)localObject2).feedTime = l;
                    ((ExtensionInfo)localObject2).feedContent = ((String)localObject6);
                    ((ExtensionInfo)localObject2).feedHasPhoto = false;
                    ((ExtensionInfo)localObject2).feedPhotoUrl = null;
                    localArrayList.add(localObject2);
                  }
                  catch (NumberFormatException localNumberFormatException1) {}
                  QLog.e("QzoneContactsFeedServlet", 1, "onGetQzoneContactsFeed fail.", localNumberFormatException2);
                }
                catch (NumberFormatException localNumberFormatException2) {}
                break label936;
              }
              int i = ((QzoneData)localObject5).iType;
              if (i != 3) {
                break label936;
              }
              try
              {
                localObject6 = new META.StStoryFeed();
                ((META.StStoryFeed)localObject6).mergeFrom(((QzoneData)localObject5).vcByte);
                if (QLog.isColorLevel()) {
                  QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed story feed, uploadTime=%s feedPhotoUrl=%s", new Object[] { Long.valueOf(((META.StStoryFeed)localObject6).createTime.get()), ((META.StStoryFeed)localObject6).coverImage.url.get() }));
                }
                if (((localNumberFormatException2.feedTime > ((META.StStoryFeed)localObject6).createTime.get()) && (localNumberFormatException2.feedType != 2)) || (TextUtils.isEmpty(((META.StStoryFeed)localObject6).coverImage.url.get()))) {
                  break label936;
                }
                localNumberFormatException2.feedType = 2;
                localNumberFormatException2.feedTime = ((META.StStoryFeed)localObject6).createTime.get();
                localNumberFormatException2.feedContent = BaseApplicationImpl.getApplication().getString(2131886588);
                localNumberFormatException2.feedHasPhoto = false;
                localNumberFormatException2.feedPhotoUrl = ((META.StStoryFeed)localObject6).coverImage.url.get();
                localArrayList.add(localNumberFormatException2);
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
              {
                QLog.e("QzoneContactsFeedServlet", 1, "onGetQzoneContactsFeed fail.", localInvalidProtocolBufferMicroException);
              }
            }
          }
        }
        paramnewest_feeds_rsp = paramnewest_feeds_rsp.vec_feed_info;
        localObject1 = localInvalidProtocolBufferMicroException;
        if (paramnewest_feeds_rsp != null)
        {
          localObject1 = localInvalidProtocolBufferMicroException;
          if (!paramnewest_feeds_rsp.isEmpty())
          {
            localObject3 = paramnewest_feeds_rsp.iterator();
            paramnewest_feeds_rsp = localInvalidProtocolBufferMicroException;
            localObject1 = paramnewest_feeds_rsp;
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = (feed_info)((Iterator)localObject3).next();
              ExtensionInfo localExtensionInfo = localFriendsManager.x(String.valueOf(((feed_info)localObject1).opuin));
              if (localExtensionInfo == null) {
                break label944;
              }
              l = ((feed_info)localObject1).time;
              localObject4 = QzoneContactsFeedUtils.a(((feed_info)localObject1).strcontent, paramnewest_feeds_rsp);
              if (((feed_info)localObject1).has_pic != 1L) {
                break label939;
              }
              paramBoolean = true;
              if (QLog.isColorLevel()) {
                QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed qzone feed, qZoneFeedTime=%s qZoneFeedContent=%s qZoneFeedHasPhoto=%s", new Object[] { Long.valueOf(l), localObject4, Boolean.valueOf(paramBoolean) }));
              }
              if ((localExtensionInfo.feedTime > l) && (localExtensionInfo.feedType != 0)) {
                break label944;
              }
              localExtensionInfo.feedType = 0;
              localExtensionInfo.feedTime = l;
              localExtensionInfo.feedContent = ((String)localObject4);
              localExtensionInfo.feedHasPhoto = paramBoolean;
              localExtensionInfo.feedPhotoUrl = ((feed_info)localObject1).strImgUrl;
              localArrayList.add(localExtensionInfo);
              break label944;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed update size=%s", new Object[] { Integer.valueOf(localArrayList.size()) }));
        }
        if (localArrayList.size() > 0)
        {
          localFriendsManager.b(localArrayList);
          paramnewest_feeds_rsp = (FriendListHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          if (paramnewest_feeds_rsp != null)
          {
            paramnewest_feeds_rsp.notifyUI(2, true, null);
            return;
          }
        }
      }
      catch (Exception paramnewest_feeds_rsp)
      {
        QLog.e("QzoneContactsFeedServlet", 1, "onGetQzoneContactsFeed fail.", paramnewest_feeds_rsp);
      }
      return;
      continue;
      paramBoolean = false;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = QzoneContactsFeedRequest.a(paramFromServiceMsg.getWupBuffer());
      if (paramIntent != null)
      {
        b(true, paramIntent);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedServlet", 2, "inform QzoneContactsFeedServlet isSuccess false");
      }
      b(false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedServlet", 2, "inform QzoneContactsFeedServlet resultcode fail.");
    }
    b(false, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject = new QzoneContactsFeedRequest(QzoneContactsFeedUtils.a(paramIntent)).encode();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append("getAIONewestFeeds");
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedServlet
 * JD-Core Version:    0.7.0.1
 */