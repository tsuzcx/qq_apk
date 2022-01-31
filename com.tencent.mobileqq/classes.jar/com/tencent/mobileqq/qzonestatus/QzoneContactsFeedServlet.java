package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.QzoneData;
import NS_MOBILE_NEWEST_FEEDS.feed_info;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import NS_WEISHI_QQ_PROFILE.stGetNewestFeedRspInner;
import android.content.Intent;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
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
      localQQAppInterface.a().a(paramnewest_feeds_rsp);
      localQQAppInterface.a().d();
      return;
    }
    localQQAppInterface.a().c();
  }
  
  protected void a(boolean paramBoolean, newest_feeds_rsp paramnewest_feeds_rsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed isSuc=%s last_feed_time=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramnewest_feeds_rsp.last_feed_time) }));
    }
    QQAppInterface localQQAppInterface;
    FriendsManager localFriendsManager;
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramBoolean)
    {
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      if (localQQAppInterface != null)
      {
        localFriendsManager = (FriendsManager)localQQAppInterface.getManager(50);
        if (localFriendsManager != null) {
          try
          {
            localArrayList = new ArrayList();
            localObject1 = paramnewest_feeds_rsp.mapVcByte;
            if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
            {
              localObject2 = ((Map)localObject1).keySet().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (Long)((Iterator)localObject2).next();
                Object localObject4 = (QzoneData)((Map)localObject1).get(localObject3);
                localObject3 = localFriendsManager.a(String.valueOf(localObject3));
                if ((((QzoneData)localObject4).iType == 2) && (localObject3 != null))
                {
                  Object localObject5 = new JceInputStream();
                  ((JceInputStream)localObject5).wrap(((QzoneData)localObject4).vcByte);
                  ((JceInputStream)localObject5).setServerEncoding("utf-8");
                  localObject4 = new stGetNewestFeedRspInner();
                  ((stGetNewestFeedRspInner)localObject4).readFrom((JceInputStream)localObject5);
                  localObject5 = ((stGetNewestFeedRspInner)localObject4).mapItemInfo;
                  if ((localObject5 != null) && (!((Map)localObject5).isEmpty()))
                  {
                    localObject4 = (String)((Map)localObject5).get("upload_time");
                    localObject5 = (String)((Map)localObject5).get("desc");
                    if (QLog.isColorLevel()) {
                      QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed weishi feed, uploadTime=%s desc=%s", new Object[] { localObject4, localObject5 }));
                    }
                    ((ExtensionInfo)localObject3).feedType = 1;
                    ((ExtensionInfo)localObject3).feedTime = Long.valueOf((String)localObject4).longValue();
                    ((ExtensionInfo)localObject3).feedContent = ((String)localObject5);
                    ((ExtensionInfo)localObject3).feedHasPhoto = false;
                    localArrayList.add(localObject3);
                    continue;
                    return;
                  }
                }
              }
            }
          }
          catch (Exception paramnewest_feeds_rsp)
          {
            QLog.e("QzoneContactsFeedServlet", 1, "onGetQzoneContactsFeed fail.", paramnewest_feeds_rsp);
          }
        }
      }
    }
    paramnewest_feeds_rsp = paramnewest_feeds_rsp.vec_feed_info;
    label382:
    long l;
    if ((paramnewest_feeds_rsp != null) && (!paramnewest_feeds_rsp.isEmpty()))
    {
      paramnewest_feeds_rsp = paramnewest_feeds_rsp.iterator();
      while (paramnewest_feeds_rsp.hasNext())
      {
        localObject1 = (feed_info)paramnewest_feeds_rsp.next();
        localObject2 = localFriendsManager.a(String.valueOf(((feed_info)localObject1).opuin));
        if (localObject2 != null)
        {
          l = ((feed_info)localObject1).time;
          localObject3 = QzoneContactsFeedUtils.a(((feed_info)localObject1).strcontent, localQQAppInterface);
          if (((feed_info)localObject1).has_pic != 1L) {
            break label597;
          }
        }
      }
    }
    label597:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed qzone feed, qZoneFeedTime=%s qZoneFeedContent=%s qZoneFeedHasPhoto=%s", new Object[] { Long.valueOf(l), localObject3, Boolean.valueOf(paramBoolean) }));
      }
      ((ExtensionInfo)localObject2).feedType = 0;
      ((ExtensionInfo)localObject2).feedTime = l;
      ((ExtensionInfo)localObject2).feedContent = ((String)localObject3);
      ((ExtensionInfo)localObject2).feedHasPhoto = paramBoolean;
      localArrayList.add(localObject2);
      break label382;
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedServlet", 2, String.format("onGetQzoneContactsFeed update size=%s", new Object[] { Integer.valueOf(localArrayList.size()) }));
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      localFriendsManager.b(localArrayList);
      paramnewest_feeds_rsp = (FriendListHandler)localQQAppInterface.a(1);
      if (paramnewest_feeds_rsp == null) {
        break;
      }
      paramnewest_feeds_rsp.a(2, true, null);
      return;
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
    byte[] arrayOfByte = new QzoneContactsFeedRequest(QzoneContactsFeedUtils.a(paramIntent)).encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "getAIONewestFeeds");
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedServlet
 * JD-Core Version:    0.7.0.1
 */