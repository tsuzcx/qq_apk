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
  private List<RecentMatchChatListItem> a = new ArrayList();
  private final HashMap<String, RecentMatchChatListItem> b = new HashMap();
  private final MqqHandler c;
  private volatile boolean d = false;
  private long e = 0L;
  private volatile boolean f = false;
  private final List<Integer> g = new ArrayList();
  private final List<Long> h = new ArrayList();
  private final ExpandObserver i = new ExpandChatRepository.1(this);
  private final QQAppInterface j;
  private final FriendListObserver k = new ExpandChatRepository.2(this);
  private final Observer l = new ExpandChatRepository.3(this);
  
  public ExpandChatRepository(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.j = paramQQAppInterface;
    this.j.addObserver(this.i);
    paramQQAppInterface = this.j.getMessageFacade();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.addObserver(this.l);
    } else {
      QLog.e("expand.chat.ExpandChatRepository", 1, "msg facade is null?");
    }
    this.j.addObserver(this.k);
    this.c = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private ExpandConverListResponse a(int paramInt1, int paramInt2, ExpandChatRepository.GetConversationListCallback paramGetConversationListCallback)
  {
    ExpandConverListResponse localExpandConverListResponse = new ExpandConverListResponse();
    paramInt2 += paramInt1;
    if (paramInt2 >= this.a.size())
    {
      localExpandConverListResponse.finishFlag = true;
      localExpandConverListResponse.cursor = "";
      paramInt2 = this.a.size();
    }
    else
    {
      localExpandConverListResponse.finishFlag = false;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("");
      localExpandConverListResponse.cursor = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = this.a.subList(paramInt1, paramInt2);
    Object localObject1 = new ArrayList(((List)localObject2).size());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(ExpandConversation.convert2Con((RecentMatchChatListItem)((Iterator)localObject2).next()));
    }
    localExpandConverListResponse.conversations = ((List)localObject1);
    paramGetConversationListCallback.a(0, "", localExpandConverListResponse);
    if (!this.h.isEmpty())
    {
      paramGetConversationListCallback = new ArrayList();
      localObject1 = new ArrayList(this.h);
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
    Object localObject = (RecentMatchChatListItem)this.b.get(paramString);
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
  
  private List<RecentMatchChatListItem> b()
  {
    Object localObject2 = this.j.getMessageFacade().a(AppConstants.MATCH_CHAT_UIN, 1044, null, 150);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject1 = e(c((List)localObject1));
    this.a = ((List)localObject1);
    this.d = true;
    localObject2 = new ArrayList(this.a.size());
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecentMatchChatListItem localRecentMatchChatListItem = (RecentMatchChatListItem)localIterator.next();
      this.b.put(localRecentMatchChatListItem.getRecentUserUin(), localRecentMatchChatListItem);
      ((List)localObject2).add(localRecentMatchChatListItem.getRecentUserUin());
    }
    a((List)localObject2);
    return localObject1;
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
  
  private List<MessageRecord> c(List<MessageRecord> paramList)
  {
    return d(paramList);
  }
  
  private void c()
  {
    Bundle localBundle = new Bundle();
    QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyConversationRefresh", localBundle);
    QLog.i("expand.chat.ExpandChatRepository", 1, "notifyRefreshConversationList");
  }
  
  private List<MessageRecord> d(List<MessageRecord> paramList)
  {
    Object localObject = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int m = paramList.size() - 1;
    while (m >= 0)
    {
      if (localHashSet.contains(UinTypeUtil.b((MessageRecord)paramList.get(m)))) {
        ((List)localObject).add(paramList.get(m));
      } else {
        localHashSet.add(UinTypeUtil.b((MessageRecord)paramList.get(m)));
      }
      m -= 1;
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
  
  private List<RecentMatchChatListItem> e(List<MessageRecord> paramList)
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
          localRecentMatchChatListItem.a(this.j, BaseApplicationImpl.getContext());
          localArrayList.add(localRecentMatchChatListItem);
          ((IExpandManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(localMessageRecord.frienduin, true);
        }
      }
    }
    return localArrayList;
  }
  
  public int a(List<String> paramList)
  {
    long l1 = System.currentTimeMillis();
    if ((this.f) || (l1 - this.e > 180000L))
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
        paramList = (IExpandHandler)this.j.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        int m = paramList.c();
        if (paramList.a(localArrayList, m))
        {
          this.e = l1;
          this.f = false;
          this.g.add(Integer.valueOf(m));
        }
        return m;
      }
    }
    return 0;
  }
  
  public void a()
  {
    this.j.removeObserver(this.i);
    this.j.removeObserver(this.k);
    QQMessageFacade localQQMessageFacade = this.j.getMessageFacade();
    if (localQQMessageFacade != null) {
      localQQMessageFacade.deleteObserver(this.l);
    }
    this.a.clear();
    this.d = false;
    this.h.clear();
    this.g.clear();
    this.e = 0L;
    this.c.removeMessages(0);
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
    long l1 = SystemClock.elapsedRealtime();
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
      paramString.obj = new ExpandChatRepository.GetConversationListFirstPageEvent(this, l1, paramInt, paramGetConversationListCallback);
      this.c.sendMessage(paramString);
      return;
    }
    try
    {
      int n = Integer.parseInt(paramString);
      int m;
      if (n < 0)
      {
        m = 0;
      }
      else
      {
        m = n;
        if (n >= this.a.size())
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
      a(m, paramInt, paramGetConversationListCallback);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getConversationList time cost:");
        paramString.append(SystemClock.elapsedRealtime() - l1);
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
  
  public void b(List<String> paramList)
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
      localObject2 = (RecentMatchChatListItem)this.b.get(localObject2);
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
      List localList = b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository
 * JD-Core Version:    0.7.0.1
 */