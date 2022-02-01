package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

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
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCServer;
import java.util.ArrayList;
import java.util.Collection;
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
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExpandChatRepository.1(this);
  private final HashMap<String, RecentMatchChatListItem> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<RecentMatchChatListItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Observer jdField_a_of_type_JavaUtilObserver = new ExpandChatRepository.3(this);
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private final List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_b_of_type_Boolean = false;
  private final List<Long> c = new ArrayList();
  
  public ExpandChatRepository(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_JavaUtilObserver);
    } else {
      QLog.e("expand.chat.ExpandChatRepository", 1, "msg facade is null?");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private ExpandConverListResponse a(int paramInt1, int paramInt2, ExpandChatRepository.GetConversationListCallback paramGetConversationListCallback)
  {
    ExpandConverListResponse localExpandConverListResponse = new ExpandConverListResponse();
    paramInt2 += paramInt1;
    if (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size())
    {
      localExpandConverListResponse.finishFlag = true;
      localExpandConverListResponse.cursor = "";
      paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
    }
    else
    {
      localExpandConverListResponse.finishFlag = false;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("");
      localExpandConverListResponse.cursor = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.subList(paramInt1, paramInt2);
    Object localObject1 = new ArrayList(((List)localObject2).size());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(ExpandConversation.convert2Con((RecentMatchChatListItem)((Iterator)localObject2).next()));
    }
    localExpandConverListResponse.conversations = ((List)localObject1);
    paramGetConversationListCallback.a(0, "", localExpandConverListResponse);
    if (!this.c.isEmpty())
    {
      paramGetConversationListCallback = new ArrayList();
      localObject1 = new ArrayList(this.c);
      localObject2 = localExpandConverListResponse.conversations.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ExpandConversation localExpandConversation = (ExpandConversation)((Iterator)localObject2).next();
        OnlineStateInfo localOnlineStateInfo = new OnlineStateInfo();
        localOnlineStateInfo.uin = localExpandConversation.peerUin;
        try
        {
          localOnlineStateInfo.online = ((List)localObject1).contains(Long.valueOf(Long.parseLong(localOnlineStateInfo.uin)));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("uin error ");
          localStringBuilder2.append(localOnlineStateInfo.uin);
          localStringBuilder2.append(" ");
          localStringBuilder2.append(localNumberFormatException);
          QLog.w("expand.chat.ExpandChatRepository", 1, localStringBuilder2.toString());
          localOnlineStateInfo.online = false;
        }
        paramGetConversationListCallback.add(localOnlineStateInfo);
        if (localOnlineStateInfo.online)
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("getPageSizeConversation notifyOnlineState  ");
          localStringBuilder1.append(MsfSdkUtils.getShortUin(localOnlineStateInfo.uin));
          QLog.d("expand.chat.ExpandChatRepository", 1, localStringBuilder1.toString());
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
    QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyConversationUpdate", (Bundle)localObject);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = (RecentMatchChatListItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject == null)
    {
      b(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyConversationChanged delete uin =");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("expand.chat.ExpandChatRepository", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (((RecentMatchChatListItem)localObject).getRecentUserUin() == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyConversationChanged error update uin =");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("expand.chat.ExpandChatRepository", 1, ((StringBuilder)localObject).toString());
      return;
    }
    a(ExpandConversation.convert2Con((RecentMatchChatListItem)localObject));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyConversationChanged update uin =");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("expand.chat.ExpandChatRepository", 2, ((StringBuilder)localObject).toString());
    }
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
    QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyGetOnLineStateResponse", localBundle);
  }
  
  private List<MessageRecord> b(List<MessageRecord> paramList)
  {
    Object localObject = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (localHashSet.contains(UinTypeUtil.b((MessageRecord)paramList.get(i)))) {
        ((List)localObject).add(paramList.get(i));
      } else {
        localHashSet.add(UinTypeUtil.b((MessageRecord)paramList.get(i)));
      }
      i -= 1;
    }
    paramList.removeAll((Collection)localObject);
    Collections.reverse(paramList);
    if (paramList.size() > 150)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("too many conversation items ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.i("expand.chat.ExpandChatRepository", 1, ((StringBuilder)localObject).toString());
      return paramList.subList(0, 150);
    }
    return paramList;
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyConversationRefresh", localBundle);
    QLog.i("expand.chat.ExpandChatRepository", 1, "notifyRefreshConversationList");
  }
  
  private void b(String paramString)
  {
    Object localObject = new ArrayList(1);
    ((List)localObject).add(paramString);
    paramString = new Gson().toJson(localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("response", paramString);
    QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyConversationDelete", (Bundle)localObject);
  }
  
  private List<RecentMatchChatListItem> c(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
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
          ((IExpandManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(localMessageRecord.frienduin, true);
        }
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("error uin ");
          localStringBuilder.append(str);
          QLog.w("expand.chat.ExpandChatRepository", 1, localStringBuilder.toString());
          QLog.w("expand.chat.ExpandChatRepository", 1, localException.toString());
        }
      }
      if (!localArrayList.isEmpty())
      {
        paramList = (IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
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
    if (paramInt <= 0)
    {
      paramString = new StringBuilder();
      paramString.append("getConversationList param error. pageCount:");
      paramString.append(paramInt);
      QLog.w("expand.chat.ExpandChatRepository", 1, paramString.toString());
      paramGetConversationListCallback.a(-1, "pageCount error", null);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConversationList cursor=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" pageCount=");
      localStringBuilder.append(paramInt);
      QLog.d("expand.chat.ExpandChatRepository", 2, localStringBuilder.toString());
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
    try
    {
      int j = Integer.parseInt(paramString);
      int i;
      if (j < 0)
      {
        i = 0;
      }
      else
      {
        i = j;
        if (j >= this.jdField_a_of_type_JavaUtilList.size())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getConversationList find no data with cursor:");
          localStringBuilder.append(paramString);
          QLog.w("expand.chat.ExpandChatRepository", 1, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("find no data with cursor:");
          localStringBuilder.append(paramString);
          paramGetConversationListCallback.a(-1, localStringBuilder.toString(), null);
          return;
        }
      }
      a(i, paramInt, paramGetConversationListCallback);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getConversationList time cost:");
        paramString.append(SystemClock.elapsedRealtime() - l);
        QLog.d("expand.chat.ExpandChatRepository", 2, paramString.toString());
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label325:
      break label325;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getConversationList error cursor:");
    localStringBuilder.append(paramString);
    QLog.w("expand.chat.ExpandChatRepository", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("cursor error ");
    localStringBuilder.append(paramString);
    paramGetConversationListCallback.a(-1, localStringBuilder.toString(), null);
  }
  
  public void a(List<String> paramList)
  {
    Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      localObject1 = (QQAppInterface)localObject1;
    } else {
      localObject1 = null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (String)paramList.next();
      localObject2 = (RecentMatchChatListItem)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if (localObject2 != null) {
        MatchChatMsgUtil.a((QQAppInterface)localObject1, (RecentMatchChatListItem)localObject2, true);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("expand.chat.ExpandChatRepository", 1, "start load data");
      }
      List localList = a();
      paramMessage = (ExpandChatRepository.GetConversationListFirstPageEvent)paramMessage.obj;
      paramMessage.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load by user. data size=");
      localStringBuilder.append(localList.size());
      localStringBuilder.append("time cost:");
      localStringBuilder.append(SystemClock.elapsedRealtime() - ExpandChatRepository.GetConversationListFirstPageEvent.a(paramMessage));
      QLog.i("expand.chat.ExpandChatRepository", 1, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository
 * JD-Core Version:    0.7.0.1
 */