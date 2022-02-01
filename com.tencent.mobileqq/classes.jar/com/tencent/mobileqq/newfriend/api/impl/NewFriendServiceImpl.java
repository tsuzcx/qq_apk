package com.tencent.mobileqq.newfriend.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfProcessor;
import com.tencent.mobileqq.newfriend.data.NewFriendMoreInfo;
import com.tencent.mobileqq.newfriend.data.NewFriendSubTitle;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.newfriend.msg.ContactBindedMessage;
import com.tencent.mobileqq.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.MayKnowBannerMessage;
import com.tencent.mobileqq.newfriend.msg.MayKnowMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendBindContactGuideMsg;
import com.tencent.mobileqq.newfriend.msg.NewFriendBindContactGuideMsgV2;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSlideTabMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSubTitleMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSysEmptyMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendTabEmptyMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendTabGuideMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendTabInfoMessage;
import com.tencent.mobileqq.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.newfriend.msg.QIMFollowMessage;
import com.tencent.mobileqq.newfriend.observer.NewFriendListObserver;
import com.tencent.mobileqq.newfriend.observer.NewFriendNotifyPokeObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.ContactBinded;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;>;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class NewFriendServiceImpl
  extends Observable
  implements Handler.Callback, INewFriendService
{
  private static final int MSG_LOADDATA = 1;
  private static final int MSG_MARKREADED = 3;
  private static final int MSG_MARKRECOMMEND_READED = 8;
  private static final int MSG_MARKSYSMSG_READED = 5;
  private static final int MSG_REFRESHDATA = 2;
  public static final int NEW_FRIEND_ICON_ID = 2130841172;
  public static final String NEW_FRIEND_TAG = HardCodeUtil.a(2131905333);
  public static final String TAG = "NEW_FRD.NewFriendServiceImpl";
  private EntityManager em;
  private NewFriendListObserver flo = new NewFriendServiceImpl.4(this);
  private volatile boolean hasInitNewFriendList = false;
  AppInterface mApp;
  public NewFriendContactGuideConfBean mBean = null;
  private Comparator<NewFriendMessage> mComparator = new NewFriendServiceImpl.1(this);
  private IFriendDataService mFriendDataService;
  private Handler mHandler;
  public boolean mHasReadContactPermission = false;
  private boolean mIsGuideBindReported = false;
  private boolean mIsGuidePermissionReported = false;
  private int mLastSysMsgTotalCount;
  private LinkedList<INewFriendListener> mListenerList = new LinkedList();
  ArrayList<NewFriendMessage> mMixedMessages = new ArrayList();
  private HashSet<String> mNewFriends = new HashSet();
  private IPhoneContactListener mPCListener = new NewFriendServiceImpl.5(this);
  private IPhoneContactService mPhoneContactService;
  NewFriendNotifyPokeObserver mPokeObserver = new NewFriendServiceImpl.3(this);
  private int mRecommendShowCount;
  private int mRecommendSubTitleIndex = -1;
  private ConcurrentHashMap<Long, SysSuspiciousMsg> mSuspiciousMsgMap = new ConcurrentHashMap(50);
  private boolean mSysMsgShouldAddMoreInfo;
  private int mSysMsgShowCount;
  private volatile boolean mSysSuspiciousForceLoadDb = true;
  private Comparator<SysSuspiciousMsg> mSysSuspiciousMsgComparator = new NewFriendServiceImpl.2(this);
  private volatile int mSysSuspiciousUnreadNum = 0;
  private Comparator<Object> newFriendMsgHeadComparator = new NewFriendServiceImpl.8(this);
  private boolean showContactGuide = false;
  public boolean showContactGuideV2 = false;
  ArrayList<FriendSystemMessage> unReadNewFriendSystemMsg = new ArrayList();
  
  private void addEducationInfo(ArrayList<MayKnowRecommend> paramArrayList, ArrayList<NewFriendMessage> paramArrayList1)
  {
    if (paramArrayList1 == null) {
      return;
    }
    Object localObject = ((IProfileDataService)this.mApp.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(this.mApp.getCurrentAccountUin(), true);
    ArrayList localArrayList = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getSelfProfileSchoolInfo(this.mApp);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadNewFriendMsg|card.strSchool = ");
      localStringBuilder.append(((Card)localObject).strSchool);
      localStringBuilder.append("schoolInfos =");
      localStringBuilder.append(localArrayList);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, localStringBuilder.toString());
    }
    if ((TextUtils.isEmpty(((Card)localObject).strSchool)) && ((localArrayList == null) || (localArrayList.isEmpty())) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject = new ConnectsExplorationBanner();
      ((ConnectsExplorationBanner)localObject).setBanner(true);
      localObject = new MayKnowBannerMessage((ConnectsExplorationBanner)localObject);
      if (paramArrayList.size() <= 4)
      {
        paramArrayList1.add(localObject);
        return;
      }
      paramArrayList1.add(4, localObject);
    }
  }
  
  private ArrayList<FriendSystemMessage> getClonedUnReadNewFriendSystemMsg()
  {
    return (ArrayList)this.unReadNewFriendSystemMsg.clone();
  }
  
  private ArrayList<Entity> getRecommendContacts(boolean paramBoolean1, ArrayList<NewFriendMessage> paramArrayList, StringBuilder paramStringBuilder, ArrayList<ConnectionsTabInfo> paramArrayList1, boolean paramBoolean2, ArrayList<Entity> paramArrayList2)
  {
    Object localObject = paramArrayList2;
    if (this.mHasReadContactPermission)
    {
      ArrayList localArrayList = (ArrayList)this.mPhoneContactService.getRecommendContact().clone();
      Iterator localIterator = null;
      localObject = null;
      paramArrayList2 = localIterator;
      if (paramArrayList1 != null)
      {
        paramArrayList2 = localIterator;
        if (!paramArrayList1.isEmpty())
        {
          localIterator = paramArrayList1.iterator();
          paramArrayList1 = (ArrayList<ConnectionsTabInfo>)localObject;
          for (;;)
          {
            paramArrayList2 = paramArrayList1;
            if (!localIterator.hasNext()) {
              break;
            }
            paramArrayList2 = (ConnectionsTabInfo)localIterator.next();
            if (paramBoolean1) {
              paramArrayList1 = paramArrayList2;
            }
          }
        }
      }
      if ((paramArrayList2 != null) && (QLog.isColorLevel()))
      {
        paramArrayList1 = new StringBuilder();
        paramArrayList1.append("loadNewFriendMsg init defaultTabInfo.recommend_count = ");
        paramArrayList1.append(paramArrayList2.b);
        QLog.d("NEW_FRD.NewFriendServiceImpl", 2, paramArrayList1.toString());
      }
      localObject = localArrayList;
      if (localArrayList != null)
      {
        localObject = localArrayList;
        if (localArrayList.size() > 0)
        {
          paramArrayList1 = localArrayList.iterator();
          while (paramArrayList1.hasNext())
          {
            localObject = (Entity)paramArrayList1.next();
            if ((localObject instanceof ContactMatch))
            {
              if (paramBoolean2) {
                paramArrayList.add(new ContactMatchMessage((ContactMatch)localObject));
              }
              if (paramArrayList2 != null) {
                paramArrayList2.b += 1;
              }
              if (QLog.isColorLevel())
              {
                paramStringBuilder.append(" cm");
                localObject = (ContactMatch)localObject;
                paramStringBuilder.append(((ContactMatch)localObject).mobileNo);
                paramStringBuilder.append(((ContactMatch)localObject).isReaded);
              }
            }
            else if ((localObject instanceof ContactBinded))
            {
              if (paramBoolean2) {
                paramArrayList.add(new ContactBindedMessage((ContactBinded)localObject));
              }
              if (QLog.isColorLevel())
              {
                paramStringBuilder.append(" cb");
                paramStringBuilder.append(((ContactBinded)localObject).isReaded);
              }
            }
          }
          localObject = localArrayList;
          if (paramArrayList2 != null)
          {
            localObject = localArrayList;
            if (QLog.isColorLevel())
            {
              paramArrayList = new StringBuilder();
              paramArrayList.append("loadNewFriendMsg result defaultTabInfo.recommend_count = ");
              paramArrayList.append(paramArrayList2.b);
              QLog.d("NEW_FRD.NewFriendServiceImpl", 2, paramArrayList.toString());
              localObject = localArrayList;
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private ArrayList<FriendSystemMessage> getUnReadNewFriendSystemMsgFromDB()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getUnReadNewFriendSystemMsgFromDB start,old unReadNewFriendSystemMsg.size() = ");
          ((StringBuilder)localObject1).append(this.unReadNewFriendSystemMsg.size());
          QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject1).toString());
        }
        this.unReadNewFriendSystemMsg.clear();
        localObject1 = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          continue;
        }
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
        if (!(localMessageRecord instanceof MessageForSystemMsg)) {
          continue;
        }
        ((MessageForSystemMsg)localMessageRecord).parse();
        if (((((MessageForSystemMsg)localMessageRecord).structMsg.msg.sub_type.get() == 13) && (this.mFriendDataService.isFriend(String.valueOf(((MessageForSystemMsg)localMessageRecord).structMsg.req_uin.get())))) || (localMessageRecord.isread)) {
          continue;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getUnReadNewFriendSystemMsgFromDB add a msg,mr.senderuin = ");
          ((StringBuilder)localObject3).append(localMessageRecord.senderuin);
          ((StringBuilder)localObject3).append(",mr.time = ");
          ((StringBuilder)localObject3).append(localMessageRecord.time);
          QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject3).toString());
        }
        if (this.unReadNewFriendSystemMsg.size() <= 0) {
          continue;
        }
        Object localObject3 = this.unReadNewFriendSystemMsg.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          continue;
        }
        FriendSystemMessage localFriendSystemMessage = (FriendSystemMessage)((Iterator)localObject3).next();
        if ((localFriendSystemMessage.a == null) || (!localFriendSystemMessage.a.senderuin.equals(localMessageRecord.senderuin))) {
          continue;
        }
        i = 1;
      }
      finally
      {
        Object localObject1;
        MessageRecord localMessageRecord;
        continue;
        throw localObject2;
        continue;
        int i = 0;
        continue;
      }
      if (i == 0) {
        this.unReadNewFriendSystemMsg.add(new FriendSystemMessage((MessageForSystemMsg)localMessageRecord));
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getUnReadNewFriendSystemMsgFromDB size = ");
      ((StringBuilder)localObject1).append(this.unReadNewFriendSystemMsg.size());
      QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.unReadNewFriendSystemMsg;
    return localObject1;
  }
  
  private void insertMsgForAIOShowNewsMsg(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertMsgForAIOShowNewsMsg");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",msgType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    long l2 = MessageCache.c() - 60L;
    Object localObject = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getAIOList(paramString2, 0);
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (!((List)localObject).isEmpty()) {
        l1 = ((MessageRecord)((List)localObject).get(0)).time - 360L;
      }
    }
    localObject = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getAllMessages(paramString2, 0, new int[] { paramInt });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null) {
          ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).removeMsgFromCacheByUniseq(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
    }
    localObject = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramInt);
    ((MessageRecord)localObject).init(this.mApp.getCurrentAccountUin(), paramString2, paramString2, paramString1, l1, paramInt, 0, l1);
    ((MessageRecord)localObject).isread = true;
    if (!MessageHandlerUtils.a(this.mApp, (MessageRecord)localObject, false))
    {
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).addAIOHeadMessage(paramString2, 0, paramString1);
    }
  }
  
  private boolean isConnectionsOpen()
  {
    return ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isMayKnowConnectionsUserClosed(this.mApp) ^ true;
  }
  
  private boolean isMessageRecordExist(String paramString, int paramInt)
  {
    paramString = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getAllMessages(paramString, 0, new int[] { paramInt });
    return (paramString != null) && (paramString.size() > 0);
  }
  
  private boolean isShouldCreateOrGetRecentUser(NewFriendMessage paramNewFriendMessage)
  {
    Object localObject = this.mApp;
    if (localObject == null) {
      return false;
    }
    localObject = ((IRecentUserProxyService)((AppInterface)localObject).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    if (paramNewFriendMessage != null)
    {
      if (localObject == null) {
        return false;
      }
      return (!paramNewFriendMessage.b()) || (((RecentUserProxy)localObject).a(AppConstants.RECOMMEND_CONTACT_UIN, 4000));
    }
    return false;
  }
  
  public static boolean isSuspiciousSysMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      if (paramMessageRecord.msgData == null) {
        return false;
      }
      try
      {
        boolean bool = FriendSystemMessage.a(MessageForSystemMsg.parseStructMsg(paramMessageRecord.msgData));
        return bool;
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("NEW_FRD.NewFriendServiceImpl", 2, paramMessageRecord, new Object[0]);
      }
    }
    return false;
  }
  
  private ArrayList<ConnectionsTabInfo> loadConnectionsTabInfos(int paramInt, boolean paramBoolean1, ArrayList<NewFriendMessage> paramArrayList, StringBuilder paramStringBuilder, boolean paramBoolean2, ArrayList<MayKnowRecommend> paramArrayList1, ArrayList<ConnectionsTabInfo> paramArrayList2, boolean paramBoolean3)
  {
    Object localObject;
    if (paramBoolean3)
    {
      localObject = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getConnectionsTabInfoListLocal(this.mApp);
      paramArrayList2 = (ArrayList<ConnectionsTabInfo>)localObject;
      if (localObject != null)
      {
        paramArrayList2 = (ArrayList<ConnectionsTabInfo>)localObject;
        if (!((ArrayList)localObject).isEmpty())
        {
          ArrayList localArrayList = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getConnectionsPersonLocal(paramInt, this.mApp);
          paramArrayList2 = (ArrayList<ConnectionsTabInfo>)localObject;
          if (localArrayList != null)
          {
            paramArrayList1.addAll(localArrayList);
            paramArrayList2 = (ArrayList<ConnectionsTabInfo>)localObject;
          }
        }
      }
    }
    if ((!paramBoolean1) && (!paramBoolean2)) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0) && (paramInt != 0))
    {
      localObject = new ArrayList(paramArrayList1.size());
      ((ArrayList)localObject).addAll(paramArrayList1);
      paramArrayList1 = ((ArrayList)localObject).iterator();
      while (paramArrayList1.hasNext())
      {
        localObject = (MayKnowRecommend)paramArrayList1.next();
        if ((localObject != null) && ((localObject instanceof MayKnowRecommend)))
        {
          paramArrayList.add(new MayKnowMessage((MayKnowRecommend)localObject));
          if (QLog.isColorLevel())
          {
            paramStringBuilder.append("mk uin:");
            paramStringBuilder.append(((MayKnowRecommend)localObject).uin);
            paramStringBuilder.append(" reason:");
            paramStringBuilder.append(((MayKnowRecommend)localObject).recommendReason);
          }
        }
      }
    }
    return paramArrayList2;
  }
  
  private void loadGuideMessage(ArrayList<NewFriendMessage> paramArrayList, IPhoneContactService paramIPhoneContactService)
  {
    if (isShowContactGuide())
    {
      paramArrayList.add(new NewFriendBindContactGuideMsg());
      return;
    }
    if ((this.showContactGuideV2) && ((!this.mHasReadContactPermission) || (paramIPhoneContactService.needUploadContact()))) {
      paramArrayList.add(new NewFriendBindContactGuideMsgV2(getConfBean(), this.mHasReadContactPermission));
    }
  }
  
  private void loadLimitCountNewFriendMsg(ArrayList<NewFriendMessage> paramArrayList1, ArrayList<NewFriendMessage> paramArrayList2, int paramInt1, ArrayList<ConnectionsTabInfo> paramArrayList, boolean paramBoolean, ArrayList<Entity> paramArrayList3, int paramInt2)
  {
    if (paramArrayList2.size() > 0)
    {
      Collections.sort(paramArrayList2, this.mComparator);
      Object localObject = new NewFriendSubTitle();
      ((NewFriendSubTitle)localObject).a = this.mApp.getApp().getApplicationContext().getResources().getString(2131892124);
      int j = 0;
      int i = 0;
      boolean bool;
      if (paramInt2 == 3) {
        bool = true;
      } else {
        bool = false;
      }
      ((NewFriendSubTitle)localObject).b = bool;
      ((NewFriendSubTitle)localObject).c = ((INewFriendVerificationService)this.mApp.getRuntimeService(INewFriendVerificationService.class, "")).isShowRedPointAtNewFriendBanner();
      paramArrayList1.add(new NewFriendSubTitleMessage((NewFriendSubTitle)localObject));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadNewFriendMsg|mLastSysMsgTotalCount = ");
        ((StringBuilder)localObject).append(this.mLastSysMsgTotalCount);
        ((StringBuilder)localObject).append(",notifyListSize = ");
        ((StringBuilder)localObject).append(paramArrayList2.size());
        ((StringBuilder)localObject).append(", mSysMsgShouldAddMoreInfo = ");
        ((StringBuilder)localObject).append(this.mSysMsgShouldAddMoreInfo);
        QLog.d("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      if (((!this.mHasReadContactPermission) || (paramArrayList3 == null) || (paramArrayList3.size() <= 0)) && (!paramBoolean) && ((paramArrayList == null) || (paramArrayList.isEmpty())))
      {
        if (paramArrayList2.size() > 100)
        {
          paramInt1 = i;
          while (paramInt1 < 100)
          {
            paramArrayList1.add(paramArrayList2.get(paramInt1));
            paramInt1 += 1;
          }
          paramArrayList2 = new NewFriendMoreInfo();
          paramArrayList2.a = this.mApp.getApp().getApplicationContext().getResources().getString(2131892118);
          paramArrayList2.b = 1000;
          paramArrayList1.add(new NewFriendMoreInfoMessage(paramArrayList2));
          return;
        }
        paramArrayList1.addAll(paramArrayList2);
        if (((paramInt1 % 20 == 0) && (!((INewFriendApi)QRoute.api(INewFriendApi.class)).isHasNoMoreMsg(this.mApp))) || ((paramInt1 > 20) && (!((INewFriendApi)QRoute.api(INewFriendApi.class)).getSysMsgOverValue(this.mApp))))
        {
          paramArrayList2 = new NewFriendMoreInfo();
          paramArrayList2.a = this.mApp.getApp().getApplicationContext().getResources().getString(2131892118);
          paramArrayList2.b = 1000;
          paramArrayList1.add(new NewFriendMoreInfoMessage(paramArrayList2));
        }
      }
      else
      {
        paramInt1 = j;
        if (this.mLastSysMsgTotalCount != paramArrayList2.size())
        {
          loadWhenNotifyListSizeNotEqTotal(paramArrayList1, paramArrayList2);
        }
        else
        {
          while (paramInt1 < this.mSysMsgShowCount)
          {
            paramArrayList1.add((NewFriendMessage)paramArrayList2.get(paramInt1));
            paramInt1 += 1;
          }
          if (this.mSysMsgShouldAddMoreInfo)
          {
            paramArrayList = new NewFriendMoreInfo();
            paramArrayList.a = this.mApp.getApp().getApplicationContext().getResources().getString(2131892118);
            paramArrayList.b = 1000;
            paramArrayList1.add(new NewFriendMoreInfoMessage(paramArrayList));
          }
        }
        this.mLastSysMsgTotalCount = paramArrayList2.size();
      }
    }
    else
    {
      paramArrayList1.add(new NewFriendSysEmptyMessage());
    }
  }
  
  private void loadMsgAccordingToTabAndMayKnow(ArrayList<NewFriendMessage> paramArrayList1, boolean paramBoolean1, ArrayList<NewFriendMessage> paramArrayList2, boolean paramBoolean2, ArrayList<ConnectionsTabInfo> paramArrayList, boolean paramBoolean3)
  {
    if ((paramBoolean3) && (paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      if (paramArrayList.size() > 1) {
        paramBoolean3 = true;
      } else {
        paramBoolean3 = false;
      }
      paramArrayList1.add(new NewFriendTabInfoMessage(paramArrayList, paramBoolean3));
      if (paramArrayList.size() > 1) {
        paramArrayList1.add(new NewFriendSlideTabMessage(paramArrayList));
      }
      if (paramBoolean1)
      {
        if (paramArrayList2.size() == 0) {
          paramArrayList1.add(new NewFriendTabEmptyMessage());
        }
      }
      else if (paramBoolean2)
      {
        if (paramArrayList2.size() == 0) {
          paramArrayList1.add(new NewFriendTabEmptyMessage());
        }
      }
      else {
        paramArrayList1.add(new NewFriendTabGuideMessage());
      }
    }
    else if (paramArrayList2.size() > 0)
    {
      paramArrayList2 = new NewFriendSubTitle();
      paramArrayList2.a = this.mApp.getApp().getApplicationContext().getResources().getString(2131886306);
      paramArrayList1.add(new NewFriendSubTitleMessage(paramArrayList2));
    }
  }
  
  private void loadPhoneContactAddMsg(ArrayList<PhoneContactAdd> paramArrayList, ArrayList<NewFriendMessage> paramArrayList1, StringBuilder paramStringBuilder)
  {
    if ((this.mHasReadContactPermission) && (paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = ((ArrayList)paramArrayList.clone()).iterator();
      while (paramArrayList.hasNext())
      {
        PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)paramArrayList.next();
        paramArrayList1.add(new PhoneContactAddMessage(localPhoneContactAdd));
        if (QLog.isColorLevel())
        {
          paramStringBuilder.append(" pca");
          paramStringBuilder.append(localPhoneContactAdd.unifiedCode);
        }
      }
    }
  }
  
  private void loadQIMMsg(ArrayList<QIMFollwerAdd> paramArrayList, ArrayList<NewFriendMessage> paramArrayList1)
  {
    ArrayList localArrayList = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQIMNotifyAddFriendsMsg(false, this.mApp);
    if (localArrayList.size() > 0) {
      paramArrayList1.addAll(localArrayList);
    }
    if ((((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).hasQimSource(this.mApp)) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        paramArrayList1.add(new QIMFollowMessage((QIMFollwerAdd)paramArrayList.next()));
      }
    }
  }
  
  private void loadRecommendAndEducation(ArrayList<NewFriendMessage> paramArrayList1, boolean paramBoolean1, ArrayList<NewFriendMessage> paramArrayList2, StringBuilder paramStringBuilder, ArrayList<MayKnowRecommend> paramArrayList, boolean paramBoolean2)
  {
    if (paramArrayList2.size() > 0)
    {
      this.mRecommendSubTitleIndex = paramArrayList1.size();
      Collections.sort(paramArrayList2, this.mComparator);
      if ((paramBoolean2) && (paramBoolean1)) {
        addEducationInfo(paramArrayList, paramArrayList2);
      }
      paramArrayList1.addAll(paramArrayList2);
    }
    this.mRecommendShowCount = paramArrayList2.size();
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append(" mRecommendSubTitleIndex : ");
      paramStringBuilder.append(this.mRecommendSubTitleIndex);
      paramStringBuilder.append(" mRecommendShowCount : ");
      paramStringBuilder.append(this.mRecommendShowCount);
      paramStringBuilder.append(" shouldShowNewFriendMayknow:");
      paramStringBuilder.append(paramBoolean2);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, paramStringBuilder.toString());
    }
  }
  
  private int loadSystemMsg(boolean paramBoolean, StringBuilder paramStringBuilder, ArrayList<NewFriendMessage> paramArrayList, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      long l = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getOldestSysMsgTime(this.mApp);
      localObject2 = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l);
      localObject1 = new ArrayList(((List)localObject2).size());
      ((List)localObject1).addAll((Collection)localObject2);
    }
    else
    {
      localObject1 = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    }
    int i = paramInt;
    if (localObject1 != null)
    {
      i = paramInt;
      if (((List)localObject1).size() > 0)
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          i = paramInt;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject2 instanceof MessageForSystemMsg))
          {
            if (QLog.isColorLevel())
            {
              paramStringBuilder.append(" sys");
              paramStringBuilder.append(((MessageRecord)localObject2).isread);
            }
            MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localObject2;
            localMessageForSystemMsg.parse();
            i = paramInt;
            if (localMessageForSystemMsg.structMsg.msg.sub_type.get() == 13)
            {
              if (this.mFriendDataService.isFriend(String.valueOf(localMessageForSystemMsg.structMsg.req_uin.get()))) {
                continue;
              }
              paramInt += 1;
              i = paramInt;
              if (QLog.isColorLevel())
              {
                paramStringBuilder.append(" sys");
                paramStringBuilder.append(((MessageRecord)localObject2).isread);
                i = paramInt;
              }
            }
            paramArrayList.add(new FriendSystemMessage(localMessageForSystemMsg));
            paramInt = i;
          }
        }
      }
    }
    return i;
  }
  
  private void loadWhenNotifyListSizeNotEqTotal(ArrayList<NewFriendMessage> paramArrayList1, ArrayList<NewFriendMessage> paramArrayList2)
  {
    int i = paramArrayList2.size();
    int j = 0;
    int k = 0;
    if (i > 3)
    {
      i = paramArrayList2.size();
      boolean bool2 = true;
      i -= 1;
      while ((i >= 0) && (((NewFriendMessage)paramArrayList2.get(i)).b())) {
        i -= 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadNewFriendMsg|lastUnReadIndex = ");
        localStringBuilder.append(i);
        QLog.d("NEW_FRD.NewFriendServiceImpl", 2, localStringBuilder.toString());
      }
      int m = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getUnReadFriendSystemMsgNum(this.mApp);
      boolean bool1;
      if (i <= 2)
      {
        i = k;
        while (i < 3)
        {
          paramArrayList1.add((NewFriendMessage)paramArrayList2.get(i));
          i += 1;
        }
        this.mSysMsgShowCount = 3;
        bool1 = bool2;
      }
      else
      {
        while (j <= i)
        {
          paramArrayList1.add((NewFriendMessage)paramArrayList2.get(j));
          j += 1;
        }
        i += 1;
        this.mSysMsgShowCount = i;
        bool1 = bool2;
        if (m <= 99)
        {
          bool1 = bool2;
          if (i == paramArrayList2.size()) {
            bool1 = true ^ ((INewFriendApi)QRoute.api(INewFriendApi.class)).getSysMsgOverValue(this.mApp);
          }
        }
      }
      this.mSysMsgShouldAddMoreInfo = bool1;
      if (bool1)
      {
        paramArrayList2 = new NewFriendMoreInfo();
        paramArrayList2.a = this.mApp.getApp().getApplicationContext().getResources().getString(2131892118);
        paramArrayList2.b = 1000;
        paramArrayList1.add(new NewFriendMoreInfoMessage(paramArrayList2));
      }
    }
    else
    {
      paramArrayList1.addAll(paramArrayList2);
      this.mSysMsgShouldAddMoreInfo = false;
      this.mSysMsgShowCount = paramArrayList2.size();
    }
  }
  
  private void logLoadMsgSizeAndUnReadMsgCountInCache(ArrayList<NewFriendMessage> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      int i = 0;
      Object localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        NewFriendMessage localNewFriendMessage = (NewFriendMessage)((Iterator)localObject).next();
        if ((localNewFriendMessage != null) && (!localNewFriendMessage.b()) && ((localNewFriendMessage instanceof FriendSystemMessage))) {
          i += 1;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadNewFriendMsg size = ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      ((StringBuilder)localObject).append(",unReadSysMsgCountInCache = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void logMsg(String paramString, List<? extends MessageRecord> paramList) {}
  
  private void markQIMFollwerReaded()
  {
    EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    Object localObject = (ArrayList)localEntityManager.query(QIMFollwerAdd.class);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFollwerAdd localQIMFollwerAdd = (QIMFollwerAdd)((Iterator)localObject).next();
        localQIMFollwerAdd.isRead = true;
        localEntityManager.update(localQIMFollwerAdd);
      }
    }
    localEntityManager.close();
  }
  
  private void refreshNotification()
  {
    NewFriendMessage localNewFriendMessage = getLastUnreadNewFriendMessage();
    if (localNewFriendMessage != null)
    {
      refreshRecentData(localNewFriendMessage);
      setChanged();
      notifyObservers(localNewFriendMessage);
    }
    else
    {
      removeNewFriendRecentUser();
    }
    refreshContactUnreadCount();
  }
  
  private void refreshRecentData(NewFriendMessage paramNewFriendMessage)
  {
    if (!isShouldCreateOrGetRecentUser(paramNewFriendMessage)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, "refreshRecentData | isShouldCreateOrGetRecentUser = true");
    }
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
    if ((localRecentUser.msg != null) && (!(localRecentUser.msg instanceof String)))
    {
      if (QLog.isColorLevel())
      {
        paramNewFriendMessage = new StringBuilder();
        paramNewFriendMessage.append("wrong ru.msg error | type is :");
        paramNewFriendMessage.append(localRecentUser.msg.getClass().toString());
        QLog.d("NEW_FRD.NewFriendServiceImpl", 2, paramNewFriendMessage.toString());
      }
      return;
    }
    localRecentUser.msgType = 25;
    localRecentUser.displayName = NEW_FRIEND_TAG;
    if ((paramNewFriendMessage != null) && ((paramNewFriendMessage instanceof MayKnowMessage)))
    {
      localRecentUser.lastmsgdrafttime = paramNewFriendMessage.d;
      localRecentUser.msg = paramNewFriendMessage.c;
      if (QLog.isColorLevel())
      {
        paramNewFriendMessage = new StringBuilder();
        paramNewFriendMessage.append("resetRecentUserUnreadCount | temp str = ");
        paramNewFriendMessage.append(localRecentUser.msg);
        QLog.d("NEW_FRD.NewFriendServiceImpl", 2, paramNewFriendMessage.toString());
      }
    }
    else if ((paramNewFriendMessage != null) && ((paramNewFriendMessage instanceof FriendSystemMessage)) && (!TextUtils.isEmpty(paramNewFriendMessage.c)))
    {
      if (paramNewFriendMessage.d > 0L) {
        localRecentUser.lastmsgtime = paramNewFriendMessage.d;
      }
      localRecentUser.msg = paramNewFriendMessage.c;
      if (QLog.isColorLevel())
      {
        paramNewFriendMessage = new StringBuilder();
        paramNewFriendMessage.append("resetRecentUserUnreadCount | ru.lastmsgtime = ");
        paramNewFriendMessage.append(localRecentUser.lastmsgtime);
        QLog.d("NEW_FRD.NewFriendServiceImpl", 2, paramNewFriendMessage.toString());
      }
    }
    if (localRecentUser.msgData == null) {
      localRecentUser.msgData = String.valueOf(localRecentUser.msg).getBytes();
    }
    if (QLog.isColorLevel())
    {
      paramNewFriendMessage = new StringBuilder();
      paramNewFriendMessage.append("refreshRecentData | ru.msg = ");
      paramNewFriendMessage.append(localRecentUser.msg);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, paramNewFriendMessage.toString());
    }
    localRecentUserProxy.b(localRecentUser);
  }
  
  public static boolean shouldMergeNewFriendContact(AppInterface paramAppInterface, String paramString)
  {
    boolean bool = false;
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if ((!paramString.equals(AppConstants.RECOMMEND_CONTACT_UIN)) && (!paramString.equals(AppConstants.MAYKNOW_RECOMMEND_UIN)) && (!paramString.equals(AppConstants.FRIEND_SYSTEM_MSG_UIN)) && (!paramString.equals(AppConstants.FRIEND_ANNIVER_UIN))) {
        return false;
      }
      bool = true;
    }
    return bool;
  }
  
  public void addListener(INewFriendListener paramINewFriendListener)
  {
    synchronized (this.mListenerList)
    {
      if (!this.mListenerList.contains(paramINewFriendListener)) {
        this.mListenerList.add(paramINewFriendListener);
      }
      return;
    }
  }
  
  public void addObserver(Observer paramObserver)
  {
    super.addObserver(paramObserver);
  }
  
  public void clearAllSysSuspiciousCache()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NEW_FRD.NewFriendServiceImpl", 2, "clearAllSysSuspiciousCache ");
    }
    if (!this.mSuspiciousMsgMap.isEmpty()) {
      this.mSuspiciousMsgMap.clear();
    }
    this.mSysSuspiciousForceLoadDb = true;
  }
  
  public void clearAllSysSuspiciousMsg()
  {
    this.mSuspiciousMsgMap.clear();
    Object localObject = this.em;
    if ((localObject != null) && (((EntityManager)localObject).isOpen()))
    {
      boolean bool = this.em.drop(SysSuspiciousMsg.class);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearAllSysSuspiciousMsg ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    try
    {
      super.deleteObserver(paramObserver);
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void deleteQIMFollowerAdd(QIMFollwerAdd paramQIMFollwerAdd)
  {
    this.mApp.getEntityManagerFactory().createEntityManager().remove(paramQIMFollwerAdd);
  }
  
  public void deleteSysSuspiciousMsg(long paramLong)
  {
    SysSuspiciousMsg localSysSuspiciousMsg = (SysSuspiciousMsg)this.mSuspiciousMsgMap.remove(Long.valueOf(paramLong));
    Object localObject = this.em;
    if ((localObject != null) && (((EntityManager)localObject).isOpen()))
    {
      localObject = localSysSuspiciousMsg;
      if (localSysSuspiciousMsg == null) {
        localObject = (SysSuspiciousMsg)this.em.find(SysSuspiciousMsg.class, paramLong);
      }
      boolean bool = false;
      if (localObject != null) {
        bool = this.em.remove((Entity)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteSysSuspiciousMsg ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public List<SysSuspiciousMsg> getAllSysSuspiciousMsg()
  {
    boolean bool = this.mSysSuspiciousForceLoadDb;
    Object localObject2 = null;
    Object localObject3;
    Object localObject1;
    if (!bool)
    {
      localObject3 = this.mSuspiciousMsgMap.values();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = new ArrayList((Collection)localObject3);
      }
    }
    else
    {
      localObject3 = this.em;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((EntityManager)localObject3).isOpen())
        {
          localObject1 = this.em.query(SysSuspiciousMsg.class);
          this.mSuspiciousMsgMap.clear();
          if (localObject1 != null)
          {
            localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (SysSuspiciousMsg)((Iterator)localObject2).next();
              this.mSuspiciousMsgMap.put(Long.valueOf(((SysSuspiciousMsg)localObject3).uin), localObject3);
            }
          }
          this.mSysSuspiciousForceLoadDb = false;
        }
      }
    }
    if (localObject1 != null) {
      Collections.sort((List)localObject1, this.mSysSuspiciousMsgComparator);
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getAllSysSuspiciousMsg ");
      ((StringBuilder)localObject3).append(this.mSysSuspiciousForceLoadDb);
      ((StringBuilder)localObject3).append(" ");
      if (localObject1 != null) {
        localObject2 = Integer.valueOf(((List)localObject1).size());
      } else {
        localObject2 = "null";
      }
      ((StringBuilder)localObject3).append(localObject2);
      QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject3).toString());
    }
    return localObject1;
  }
  
  public int getAllUnreadMessageCount()
  {
    int k = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getUnReadFriendSystemMsgNum(this.mApp);
    Object localObject = getMixedNewFriendDatas().iterator();
    int i = 0;
    int j = 0;
    while (((Iterator)localObject).hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)((Iterator)localObject).next();
      if ((localNewFriendMessage != null) && (!localNewFriendMessage.b())) {
        if ((localNewFriendMessage instanceof FriendSystemMessage)) {
          j += 1;
        } else if ((localNewFriendMessage instanceof ContactBindedMessage)) {
          i += this.mPhoneContactService.getRecommendUnreadCount();
        } else {
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAllUnreadMessageCount|total unread = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",unReadSysMsgCount = ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(",unReadSysMsgCountInCache = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    return i + k;
  }
  
  public List<Object> getAllUnreadMsg()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getMixedNewFriendDatas().iterator();
    int i = 0;
    Object localObject2;
    StringBuilder localStringBuilder;
    while (localIterator.hasNext())
    {
      localObject2 = (NewFriendMessage)localIterator.next();
      if ((localObject2 != null) && (!((NewFriendMessage)localObject2).b())) {
        if ((localObject2 instanceof FriendSystemMessage))
        {
          i += 1;
        }
        else if ((localObject2 instanceof ContactBindedMessage))
        {
          localObject2 = this.mPhoneContactService.getRecommendUnreadList();
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            localArrayList.addAll((Collection)localObject2);
          }
        }
        else if ((localObject2 instanceof ContactMatchMessage))
        {
          localArrayList.add(localObject2);
        }
        else
        {
          localArrayList.add(localObject2);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getAllUnreadMsg unexpected nfm = ");
          localStringBuilder.append(localObject2);
          QLog.d("NEW_FRD.NewFriendServiceImpl", 1, localStringBuilder.toString());
        }
      }
    }
    localArrayList.addAll(getClonedUnReadNewFriendSystemMsg());
    if (localArrayList.size() > 0) {
      try
      {
        Collections.sort(localArrayList, this.newFriendMsgHeadComparator);
      }
      catch (Exception localException)
      {
        QLog.d("NEW_FRD.NewFriendServiceImpl", 1, "getAllUnreadMsg sort exception ", localException);
      }
    }
    if (QLog.isColorLevel())
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAllUnreadMsg size = ");
      ((StringBuilder)localObject1).append(localArrayList.size());
      ((StringBuilder)localObject1).append(",unReadSysMsgCountInCache = ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject1).toString());
      if (localArrayList.size() > 0)
      {
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof PhoneContact))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getAllUnreadMsg PhoneContact time  = ");
            localStringBuilder.append(((PhoneContact)localObject2).lastScanTime);
            QLog.d("NEW_FRD.NewFriendServiceImpl", 2, localStringBuilder.toString());
          }
          else if ((localObject2 instanceof FriendSystemMessage))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getAllUnreadMsg FriendSystemMessage time  = ");
            localStringBuilder.append(((FriendSystemMessage)localObject2).d * 1000L);
            QLog.d("NEW_FRD.NewFriendServiceImpl", 2, localStringBuilder.toString());
          }
          else if ((localObject2 instanceof ContactMatchMessage))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getAllUnreadMsg ContactMatchMessage time  = ");
            localStringBuilder.append(((ContactMatchMessage)localObject2).d * 1000L);
            QLog.d("NEW_FRD.NewFriendServiceImpl", 2, localStringBuilder.toString());
          }
        }
      }
    }
    return localArrayList;
  }
  
  public NewFriendContactGuideConfBean getConfBean()
  {
    if (this.mBean == null) {
      this.mBean = NewFriendContactGuideConfProcessor.a();
    }
    return this.mBean;
  }
  
  public NewFriendMessage getLastUnreadNewFriendMessage()
  {
    Object localObject = getMixedNewFriendDatas();
    int j = 0;
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localNewFriendMessage1 = (NewFriendMessage)((ArrayList)localObject).get(i);
      if ((localNewFriendMessage1 != null) && (!localNewFriendMessage1.b())) {
        break label52;
      }
      i += 1;
    }
    NewFriendMessage localNewFriendMessage1 = null;
    label52:
    if ((localNewFriendMessage1 != null) && (!(localNewFriendMessage1 instanceof ContactBindedMessage)) && (!(localNewFriendMessage1 instanceof MayKnowMessage)))
    {
      i = j;
      if ((localNewFriendMessage1 instanceof ContactMatchMessage)) {
        return localNewFriendMessage1;
      }
      while (i < ((ArrayList)localObject).size())
      {
        localNewFriendMessage2 = (NewFriendMessage)((ArrayList)localObject).get(i);
        if ((localNewFriendMessage2 != null) && (!localNewFriendMessage2.b()) && (!(localNewFriendMessage2 instanceof FriendSystemMessage))) {
          break label135;
        }
        i += 1;
      }
      NewFriendMessage localNewFriendMessage2 = null;
      if (localNewFriendMessage2 != null)
      {
        localObject = localNewFriendMessage2;
        if (localNewFriendMessage1.d >= localNewFriendMessage2.d) {
          localObject = localNewFriendMessage1;
        }
        return localObject;
      }
    }
    label135:
    return localNewFriendMessage1;
  }
  
  public ArrayList<NewFriendMessage> getMixedNewFriendDatas()
  {
    return (ArrayList)this.mMixedMessages.clone();
  }
  
  public ArrayList<QIMFollwerAdd> getQIMFollwerAddList()
  {
    return (ArrayList)this.mApp.getEntityManagerFactory().createEntityManager().query(QIMFollwerAdd.class);
  }
  
  public int getRceommendShowCount()
  {
    return this.mRecommendShowCount;
  }
  
  public int getRecommendSubTitleIndex()
  {
    return this.mRecommendSubTitleIndex;
  }
  
  public int getSysSuspiciousUnreadNum()
  {
    return this.mSysSuspiciousUnreadNum;
  }
  
  public SysSuspiciousMsg getSysSuspicousMsg(long paramLong)
  {
    SysSuspiciousMsg localSysSuspiciousMsg2 = (SysSuspiciousMsg)this.mSuspiciousMsgMap.get(Long.valueOf(paramLong));
    Object localObject = localSysSuspiciousMsg2;
    if (localSysSuspiciousMsg2 == null)
    {
      localObject = this.em;
      SysSuspiciousMsg localSysSuspiciousMsg1 = localSysSuspiciousMsg2;
      if (localObject != null)
      {
        localSysSuspiciousMsg1 = localSysSuspiciousMsg2;
        if (((EntityManager)localObject).isOpen()) {
          localSysSuspiciousMsg1 = (SysSuspiciousMsg)this.em.find(SysSuspiciousMsg.class, paramLong);
        }
      }
      localObject = localSysSuspiciousMsg1;
      if (localSysSuspiciousMsg1 != null)
      {
        this.mSuspiciousMsgMap.put(Long.valueOf(paramLong), localSysSuspiciousMsg1);
        localObject = localSysSuspiciousMsg1;
      }
    }
    return localObject;
  }
  
  public void getUnreadMessageCountAsync()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      refreshContactUnreadCount();
      return;
    }
    ThreadManager.postImmediately(new NewFriendServiceImpl.7(this), null, false);
  }
  
  public int getUnreadSystemMessageCount()
  {
    return ((INewFriendApi)QRoute.api(INewFriendApi.class)).getUnReadFriendSystemMsgNum(this.mApp);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HandleMessage what=");
      localStringBuilder.append(paramMessage.what);
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5)
          {
            if (i != 8) {
              return true;
            }
            this.mPhoneContactService.markRecommendReaded();
            reloadNewFriendMsg();
            return true;
          }
          ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).setReaded(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
          ((INewFriendApi)QRoute.api(INewFriendApi.class)).setUnReadFriendSystemMsgNum(this.mApp, 0);
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendFriendSystemMsgReadedReport(this.mApp);
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).markQIMNotifyAddFriendsRead(this.mApp);
          reloadNewFriendMsg();
          return true;
        }
        ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).setReaded(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
        this.mPhoneContactService.markRecommendReaded();
        markQIMFollwerReaded();
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).markQIMNotifyAddFriendsRead(this.mApp);
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).setUnReadFriendSystemMsgNum(this.mApp, 0);
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendFriendSystemMsgReadedReport(this.mApp);
        reloadNewFriendMsg();
        return true;
      }
      reloadNewFriendMsg();
      return true;
    }
    loadNewFriendMsg(true);
    return true;
  }
  
  public boolean handleNewFrdAIOShow(int paramInt, String paramString)
  {
    if (paramInt != 0) {
      return false;
    }
    boolean bool1 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isNewFrdMiniCardSwitchOn(this.mApp);
    boolean bool2 = isNewFriend(paramString);
    QLog.d("NEW_FRD.NewFriendServiceImpl", 1, String.format("handleNewFrdAIOShow [isNewFrd,newFrdMiniCardSwitch]=[%b,%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    if (!bool2) {
      return false;
    }
    if (!bool1)
    {
      isFirstEnterNewFriendAio(paramString);
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).insertCommonHobbyIfNeeded(this.mApp, paramString);
    }
    return true;
  }
  
  public void handleQIMNewFollower(QIMFollwerAdd paramQIMFollwerAdd)
  {
    EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    localEntityManager.persistOrReplace(paramQIMFollwerAdd);
    localEntityManager.close();
    reloadNewFriendMsg();
    ((IAppBadgeService)this.mApp.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
  }
  
  public void initNewFriendList()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("initNewFriendList hasInitNewFriendList: ");
      ((StringBuilder)???).append(this.hasInitNewFriendList);
      QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)???).toString());
    }
    if (this.hasInitNewFriendList) {
      return;
    }
    this.hasInitNewFriendList = true;
    ??? = MobileQQ.sMobileQQ;
    int i = 0;
    ??? = ((MobileQQ)???).getSharedPreferences("new_friend", 0).getString("new_friend_list", "");
    if (TextUtils.isEmpty((CharSequence)???)) {
      return;
    }
    String[] arrayOfString = ((String)???).split("#");
    synchronized (this.mNewFriends)
    {
      int j = arrayOfString.length;
      if (i < j)
      {
        if (!TextUtils.isEmpty(arrayOfString[i])) {
          this.mNewFriends.add(arrayOfString[i]);
        }
      }
      else {
        return;
      }
    }
  }
  
  public void insertCommonHobbyForAIOShowNewsMsg(String paramString1, String paramString2)
  {
    if (!isMessageRecordExist(paramString2, -2015)) {
      insertMsgForAIOShowNewsMsg(paramString1, paramString2, -2023);
    }
  }
  
  public void insertFriendFeedForAIOShowNewsMsg(String paramString1, String paramString2)
  {
    if (!isMessageRecordExist(paramString2, -2023)) {
      insertMsgForAIOShowNewsMsg(paramString1, paramString2, -2015);
    }
  }
  
  public boolean isFirstEnterNewFriendAio(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    synchronized (this.mNewFriends)
    {
      boolean bool = this.mNewFriends.remove(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.mNewFriends.iterator();
      while (localIterator.hasNext())
      {
        paramString.append((String)localIterator.next());
        paramString.append("#");
      }
      MobileQQ.sMobileQQ.getSharedPreferences("new_friend", 0).edit().putString("new_friend_list", paramString.toString()).apply();
      return bool;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean isGuideBindReported()
  {
    return this.mIsGuideBindReported;
  }
  
  public boolean isGuidePermissionReported()
  {
    return this.mIsGuidePermissionReported;
  }
  
  public boolean isNewFriend(String paramString)
  {
    synchronized (this.mNewFriends)
    {
      boolean bool = this.mNewFriends.contains(paramString);
      return bool;
    }
  }
  
  public boolean isShowContactGuide()
  {
    return this.showContactGuide;
  }
  
  public void loadNewFriendMsg(boolean paramBoolean)
  {
    loadNewFriendMsg(paramBoolean, 23);
  }
  
  public void loadNewFriendMsg(boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList4 = this.mPhoneContactService.getPhoneContactAddList();
        ArrayList localArrayList5 = getQIMFollwerAddList();
        if (paramInt == 23)
        {
          bool1 = true;
          ArrayList localArrayList2 = new ArrayList();
          ArrayList localArrayList3 = new ArrayList();
          StringBuilder localStringBuilder = new StringBuilder(256);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("loadNewFriendMsg");
          }
          Object localObject2 = (IPhoneContactService)this.mApp.getRuntimeService(IPhoneContactService.class, "");
          this.mHasReadContactPermission = PermissionChecker.a().e();
          loadGuideMessage(localArrayList1, (IPhoneContactService)localObject2);
          int i = loadSystemMsg(paramBoolean, localStringBuilder, localArrayList2, 0);
          loadQIMMsg(localArrayList5, localArrayList2);
          loadPhoneContactAddMsg(localArrayList4, localArrayList2, localStringBuilder);
          paramBoolean = isConnectionsOpen();
          localArrayList4 = new ArrayList();
          boolean bool2 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).shouldShowMayKnowInNewFriend(this.mApp);
          localArrayList5 = loadConnectionsTabInfos(paramInt, bool1, localArrayList3, localStringBuilder, paramBoolean, localArrayList4, null, bool2);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("loadNewFriendMsg mHasReadContactPermission = ");
            ((StringBuilder)localObject2).append(this.mHasReadContactPermission);
            ((StringBuilder)localObject2).append(",needAddContactMsg =");
            ((StringBuilder)localObject2).append(bool1);
            QLog.d("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject2).toString());
          }
          loadLimitCountNewFriendMsg(localArrayList1, localArrayList2, i, localArrayList5, bool2, getRecommendContacts(bool1, localArrayList3, localStringBuilder, localArrayList5, bool1, null), ((INewFriendVerificationService)this.mApp.getRuntimeService(INewFriendVerificationService.class, "")).getEntranceType());
          loadMsgAccordingToTabAndMayKnow(localArrayList1, bool1, localArrayList3, paramBoolean, localArrayList5, bool2);
          loadRecommendAndEducation(localArrayList1, bool1, localArrayList3, localStringBuilder, localArrayList4, bool2);
          logLoadMsgSizeAndUnReadMsgCountInCache(localArrayList1);
          this.mMixedMessages = localArrayList1;
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public void markAllDataReaded()
  {
    this.mHandler.sendEmptyMessage(3);
  }
  
  public void markRecommendReaded()
  {
    this.mHandler.sendEmptyMessage(8);
  }
  
  public void markSystemMsgReaded()
  {
    this.mHandler.sendEmptyMessage(5);
  }
  
  public boolean needShowAvatar()
  {
    NewFriendMessage localNewFriendMessage = getLastUnreadNewFriendMessage();
    return (localNewFriendMessage != null) && (localNewFriendMessage.a(this.mApp));
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.em = this.mApp.getEntityManagerFactory().createEntityManager();
    this.mPhoneContactService = ((IPhoneContactService)this.mApp.getRuntimeService(IPhoneContactService.class, ""));
    this.mFriendDataService = ((IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, ""));
    this.mPhoneContactService.addListener(this.mPCListener);
    this.mApp.addObserver(this.flo, true);
    this.mApp.addObserver(this.mPokeObserver);
    this.mHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, "onDestroy");
    }
    this.mMixedMessages.clear();
    this.mPhoneContactService.removeListener(this.mPCListener);
    this.mApp.removeObserver(this.flo);
    this.mApp.removeObserver(this.mPokeObserver);
  }
  
  public void reSetLastSysMsgTotalCount(int paramInt)
  {
    this.mLastSysMsgTotalCount = paramInt;
  }
  
  public void refreshContactUnreadCount()
  {
    int i = getAllUnreadMessageCount();
    getUnReadNewFriendSystemMsgFromDB();
    this.mApp.runOnUiThread(new NewFriendServiceImpl.6(this, i));
  }
  
  public void refreshNotificationWithFriendSystemMessage(FriendSystemMessage paramFriendSystemMessage)
  {
    long l = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getOldestSysMsgTime(this.mApp);
    Object localObject = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if ((!localMessageRecord.isread) && ((localMessageRecord instanceof MessageForSystemMsg)))
      {
        localObject = new FriendSystemMessage((MessageForSystemMsg)localMessageRecord);
        break label110;
      }
    }
    localObject = null;
    label110:
    if (localObject != null)
    {
      ((FriendSystemMessage)localObject).d = paramFriendSystemMessage.d;
      ((FriendSystemMessage)localObject).c = paramFriendSystemMessage.c;
      refreshRecentData((NewFriendMessage)localObject);
      setChanged();
      notifyObservers(localObject);
    }
    else
    {
      removeNewFriendRecentUser();
    }
    refreshContactUnreadCount();
  }
  
  public void reloadNewFriendMsg()
  {
    loadNewFriendMsg(true);
    refreshNotification();
  }
  
  public void removeListener(INewFriendListener paramINewFriendListener)
  {
    synchronized (this.mListenerList)
    {
      this.mListenerList.remove(paramINewFriendListener);
      return;
    }
  }
  
  public void removeNewFriendRecentUser()
  {
    Object localObject = this.mApp;
    if (localObject == null) {
      return;
    }
    localObject = ((IRecentUserProxyService)((AppInterface)localObject).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    RecentUser localRecentUser = ((RecentUserProxy)localObject).c(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
    if (localRecentUser != null) {
      ((RecentUserProxy)localObject).a(localRecentUser);
    }
  }
  
  public void saveNewFriend2Cache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.mNewFriends)
    {
      this.mNewFriends.add(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.mNewFriends.iterator();
      while (localIterator.hasNext())
      {
        paramString.append((String)localIterator.next());
        paramString.append("#");
      }
      MobileQQ.sMobileQQ.getSharedPreferences("new_friend", 0).edit().putString("new_friend_list", paramString.toString()).apply();
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void setContactGuideCancelByUser()
  {
    this.showContactGuideV2 = false;
    this.mApp.getPreferences().edit().putBoolean("contact_guide_user_close", true).putInt("new_friend_show_count_after_user_close", 0).apply();
  }
  
  public void setIsGuideBindReported(boolean paramBoolean)
  {
    this.mIsGuideBindReported = paramBoolean;
  }
  
  public void setIsGuidePermissionReported(boolean paramBoolean)
  {
    this.mIsGuidePermissionReported = paramBoolean;
  }
  
  public void setShowContactGuide(boolean paramBoolean)
  {
    this.showContactGuide = paramBoolean;
  }
  
  public void setSysSuspiciousUnreadNum(int paramInt)
  {
    this.mSysSuspiciousUnreadNum = paramInt;
  }
  
  public void updateBindContactGuideState()
  {
    SharedPreferences localSharedPreferences = this.mApp.getPreferences();
    if (isShowContactGuide())
    {
      this.showContactGuideV2 = false;
      localSharedPreferences.edit().putInt("new_friend_show_count_after_user_close", 0).putBoolean("contact_guide_user_close", false).apply();
      return;
    }
    boolean bool = localSharedPreferences.getBoolean("contact_guide_user_close", false);
    int i = localSharedPreferences.getInt("new_friend_show_count_after_user_close", 0);
    NewFriendContactGuideConfBean localNewFriendContactGuideConfBean = getConfBean();
    if (QLog.isColorLevel()) {
      QLog.i("NEW_FRD.NewFriendServiceImpl", 2, String.format("updateBindContactGuideState [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(localNewFriendContactGuideConfBean.a), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(localNewFriendContactGuideConfBean.b) }));
    }
    if ((localNewFriendContactGuideConfBean.a) && ((!bool) || (i >= localNewFriendContactGuideConfBean.b)))
    {
      this.showContactGuideV2 = true;
      localSharedPreferences.edit().putBoolean("contact_guide_user_close", false).putInt("new_friend_show_count_after_user_close", 0).apply();
      return;
    }
    if (bool) {
      localSharedPreferences.edit().putInt("new_friend_show_count_after_user_close", i + 1).apply();
    }
    this.showContactGuideV2 = false;
  }
  
  protected boolean updateEntity(Entity paramEntity)
  {
    boolean bool2 = this.em.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.em.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.em.update(paramEntity);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity em closed e=");
      localStringBuilder.append(paramEntity.getTableName());
      QLog.d("NEW_FRD.NewFriendServiceImpl", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void updateOrInsertSysSuspiciousMsg(SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if (paramSysSuspiciousMsg != null)
    {
      Object localObject = this.em;
      if ((localObject != null) && (((EntityManager)localObject).isOpen()))
      {
        this.em.persistOrReplace(paramSysSuspiciousMsg);
        this.mSuspiciousMsgMap.put(Long.valueOf(paramSysSuspiciousMsg.uin), paramSysSuspiciousMsg);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateOrInsertSysSuspiciousMsg ");
          ((StringBuilder)localObject).append(paramSysSuspiciousMsg.uin);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramSysSuspiciousMsg.time);
          QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void updateSuspiciousMsgListFromServer(ArrayList<SysSuspiciousMsg> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateSuspiciousMsgListFromServer ");
        ((StringBuilder)localObject1).append(paramBoolean);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(paramArrayList.size());
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(paramArrayList.toString());
        QLog.i("NEW_FRD.NewFriendServiceImpl", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = getAllSysSuspiciousMsg();
      if (localObject2 != null)
      {
        int i = paramArrayList.size();
        if ((i == 0) && (paramBoolean))
        {
          clearAllSysSuspiciousMsg();
        }
        else if (i > 0)
        {
          Collections.sort(paramArrayList, this.mSysSuspiciousMsgComparator);
          localObject1 = (SysSuspiciousMsg)paramArrayList.get(0);
          SysSuspiciousMsg localSysSuspiciousMsg1 = (SysSuspiciousMsg)paramArrayList.get(paramArrayList.size() - 1);
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SysSuspiciousMsg localSysSuspiciousMsg2 = (SysSuspiciousMsg)((Iterator)localObject2).next();
            if (!paramBoolean)
            {
              if ((localSysSuspiciousMsg2.time <= ((SysSuspiciousMsg)localObject1).time) && (localSysSuspiciousMsg2.time >= localSysSuspiciousMsg1.time)) {
                deleteSysSuspiciousMsg(localSysSuspiciousMsg2.uin);
              }
            }
            else if (localSysSuspiciousMsg2.time <= ((SysSuspiciousMsg)localObject1).time) {
              deleteSysSuspiciousMsg(localSysSuspiciousMsg2.uin);
            }
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("NEW_FRD.NewFriendServiceImpl", 2, "updateSuspiciousMsgListFromServer local empty");
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        updateOrInsertSysSuspiciousMsg((SysSuspiciousMsg)paramArrayList.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl
 * JD-Core Version:    0.7.0.1
 */