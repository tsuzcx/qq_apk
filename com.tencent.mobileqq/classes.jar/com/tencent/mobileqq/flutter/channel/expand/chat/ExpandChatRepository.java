package com.tencent.mobileqq.flutter.channel.expand.chat;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCServer;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCServer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ExpandChatRepository
  implements Handler.Callback
{
  private long jdField_a_of_type_Long = 0L;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ExpandChatRepository.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExpandChatRepository.3(this);
  private HashMap<String, RecentMatchChatListItem> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<RecentMatchChatListItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Observer jdField_a_of_type_JavaUtilObserver = new ExpandChatRepository.1(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_b_of_type_Boolean = false;
  private List<Long> c = new ArrayList();
  
  public ExpandChatRepository(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_JavaUtilObserver);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
      return;
      QLog.e("expand.chat.ExpandChatRepository", 1, "msg facade is null?");
    }
  }
  
  private ExpandConverListResponse a(int paramInt1, int paramInt2, ExpandChatRepository.GetConversationListCallback paramGetConversationListCallback)
  {
    ExpandConverListResponse localExpandConverListResponse = new ExpandConverListResponse();
    if (paramInt1 + paramInt2 >= this.jdField_a_of_type_JavaUtilList.size())
    {
      localExpandConverListResponse.finishFlag = true;
      localExpandConverListResponse.cursor = "";
      paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
    }
    Object localObject;
    ArrayList localArrayList;
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.subList(paramInt1, paramInt2);
      localArrayList = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(ExpandConversation.convert2Con((RecentMatchChatListItem)((Iterator)localObject).next()));
      }
      localExpandConverListResponse.finishFlag = false;
      paramInt2 = paramInt1 + paramInt2;
      localExpandConverListResponse.cursor = (paramInt2 + "");
    }
    localExpandConverListResponse.conversations = localArrayList;
    paramGetConversationListCallback.a(0, "", localExpandConverListResponse);
    if (!this.c.isEmpty())
    {
      paramGetConversationListCallback = new ArrayList();
      localArrayList = new ArrayList(this.c);
      localObject = localExpandConverListResponse.conversations.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ExpandConversation localExpandConversation = (ExpandConversation)((Iterator)localObject).next();
          OnlineStateInfo localOnlineStateInfo = new OnlineStateInfo();
          localOnlineStateInfo.uin = localExpandConversation.peerUin;
          try
          {
            localOnlineStateInfo.online = localArrayList.contains(Long.valueOf(Long.parseLong(localOnlineStateInfo.uin)));
            paramGetConversationListCallback.add(localOnlineStateInfo);
            if (localOnlineStateInfo.online) {
              QLog.d("expand.chat.ExpandChatRepository", 1, "getPageSizeConversation notifyOnlineState  " + MsfSdkUtils.getShortUin(localOnlineStateInfo.uin));
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              QLog.w("expand.chat.ExpandChatRepository", 1, "uin error " + localOnlineStateInfo.uin + " " + localNumberFormatException);
              localOnlineStateInfo.online = false;
            }
          }
        }
      }
      a(paramGetConversationListCallback, -1);
    }
    return localExpandConverListResponse;
  }
  
  private List<RecentMatchChatListItem> a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.MATCH_CHAT_UIN, 1044, null, 150);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject1 = c(a((List)localObject1));
    this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    this.jdField_a_of_type_Boolean = true;
    localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      RecentMatchChatListItem localRecentMatchChatListItem = (RecentMatchChatListItem)localIterator.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localRecentMatchChatListItem.getRecentUserUin(), localRecentMatchChatListItem);
      ((List)localObject2).add(localRecentMatchChatListItem.getRecentUserUin());
    }
    a((List)localObject2);
    return localObject1;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList)
  {
    return b(paramList);
  }
  
  private void a(ExpandConversation paramExpandConversation)
  {
    Object localObject = new ArrayList(1);
    ((List)localObject).add(paramExpandConversation);
    paramExpandConversation = new Gson().toJson(localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("response", paramExpandConversation);
    QIPCServerHelper.getInstance().getServer().callClient(ExpandFlutterIPCServer.a(), 1, "ExpandFlutterIPCClient", "notifyConversationUpdate", (Bundle)localObject);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      RecentMatchChatListItem localRecentMatchChatListItem = (RecentMatchChatListItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localRecentMatchChatListItem == null)
      {
        b(paramString);
        QLog.i("expand.chat.ExpandChatRepository", 1, "notifyConversationChanged delete uin =" + paramString);
        return;
      }
      if (localRecentMatchChatListItem.getRecentUserUin() == null)
      {
        QLog.i("expand.chat.ExpandChatRepository", 1, "notifyConversationChanged error update uin =" + paramString);
        return;
      }
      a(ExpandConversation.convert2Con(localRecentMatchChatListItem));
    } while (!QLog.isColorLevel());
    QLog.d("expand.chat.ExpandChatRepository", 2, "notifyConversationChanged update uin =" + paramString);
  }
  
  private void a(List<OnlineStateInfo> paramList, int paramInt)
  {
    if (paramList.isEmpty()) {
      return;
    }
    paramList = new Gson().toJson(paramList);
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramList);
    localBundle.putInt("seqNum", paramInt);
    QIPCServerHelper.getInstance().getServer().callClient(ExpandFlutterIPCServer.a(), 1, "ExpandFlutterIPCClient", "notifyGetOnLineStateResponse", localBundle);
  }
  
  private List<MessageRecord> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      if (localHashSet.contains(UinTypeUtil.b((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(UinTypeUtil.b((MessageRecord)paramList.get(i)));
      }
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    if (paramList.size() > 150)
    {
      QLog.i("expand.chat.ExpandChatRepository", 1, "too many conversation items " + paramList.size());
      return paramList.subList(0, 150);
    }
    return paramList;
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    QIPCServerHelper.getInstance().getServer().callClient(ExpandFlutterIPCServer.a(), 1, "ExpandFlutterIPCClient", "notifyConversationRefresh", localBundle);
    QLog.i("expand.chat.ExpandChatRepository", 1, "notifyRefreshConversationList");
  }
  
  private void b(String paramString)
  {
    Object localObject = new ArrayList(1);
    ((List)localObject).add(paramString);
    paramString = new Gson().toJson(localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("response", paramString);
    QIPCServerHelper.getInstance().getServer().callClient(ExpandFlutterIPCServer.a(), 1, "ExpandFlutterIPCClient", "notifyConversationDelete", (Bundle)localObject);
  }
  
  private List<RecentMatchChatListItem> c(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord != null)
      {
        RecentMatchChatListItem localRecentMatchChatListItem = new RecentMatchChatListItem(localMessageRecord);
        localRecentMatchChatListItem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        localArrayList.add(localRecentMatchChatListItem);
        ((ExtendFriendManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(localMessageRecord.frienduin, true);
      }
    }
    return localArrayList;
  }
  
  public int a(List<String> paramList)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_b_of_type_Boolean) || (l - this.jdField_a_of_type_Long > 180000L))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        try
        {
          localArrayList.add(Long.valueOf(str));
        }
        catch (Exception localException)
        {
          QLog.w("expand.chat.ExpandChatRepository", 1, "error uin " + str);
          QLog.w("expand.chat.ExpandChatRepository", 1, localException.toString());
        }
      }
      if (!localArrayList.isEmpty())
      {
        paramList = (ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        int i = paramList.a();
        if (paramList.a(localArrayList, i))
        {
          this.jdField_a_of_type_Long = l;
          this.jdField_b_of_type_Boolean = false;
          this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(i));
        }
        return i;
      }
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null) {
      localQQMessageFacade.deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.c.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
    QLog.i("expand.chat.ExpandChatRepository", 1, "onDestroy");
  }
  
  public void a(String paramString, int paramInt, ExpandChatRepository.GetConversationListCallback paramGetConversationListCallback)
  {
    int i = 0;
    if (paramInt <= 0)
    {
      QLog.w("expand.chat.ExpandChatRepository", 1, "getConversationList param error. pageCount:" + paramInt);
      paramGetConversationListCallback.a(-1, "pageCount error", null);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("expand.chat.ExpandChatRepository", 2, "getConversationList cursor=" + paramString + " pageCount=" + paramInt);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new Message();
      paramString.what = 0;
      paramString.arg2 = paramInt;
      paramString.obj = new ExpandChatRepository.GetConversationListFirstPageEvent(this, l, paramInt, paramGetConversationListCallback);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramString);
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        j = Integer.parseInt(paramString);
        if (j < 0)
        {
          a(i, paramInt, paramGetConversationListCallback);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("expand.chat.ExpandChatRepository", 2, "getConversationList time cost:" + (SystemClock.elapsedRealtime() - l));
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.w("expand.chat.ExpandChatRepository", 1, "getConversationList error cursor:" + paramString);
        paramGetConversationListCallback.a(-1, "cursor error " + paramString, null);
        return;
      }
      if (j >= this.jdField_a_of_type_JavaUtilList.size())
      {
        QLog.w("expand.chat.ExpandChatRepository", 1, "getConversationList find no data with cursor:" + paramString);
        paramGetConversationListCallback.a(-1, "find no data with cursor:" + paramString, null);
        return;
      }
      i = j;
    }
  }
  
  public void a(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = (RecentMatchChatListItem)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (localObject != null) {
        MatchChatMsgUtil.a(ExtendFriendManager.a(), (RecentMatchChatListItem)localObject, true);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("expand.chat.ExpandChatRepository", 1, "start load data");
      }
      List localList = a();
      paramMessage = (ExpandChatRepository.GetConversationListFirstPageEvent)paramMessage.obj;
      paramMessage.a();
      QLog.i("expand.chat.ExpandChatRepository", 1, "load by user. data size=" + localList.size() + "time cost:" + (SystemClock.elapsedRealtime() - ExpandChatRepository.GetConversationListFirstPageEvent.a(paramMessage)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository
 * JD-Core Version:    0.7.0.1
 */