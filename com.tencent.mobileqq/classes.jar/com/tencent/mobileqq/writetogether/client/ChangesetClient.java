package com.tencent.mobileqq.writetogether.client;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.easysync2.IChangesetTracker;
import com.tencent.mobileqq.easysync2.UserChangeCallback;
import com.tencent.mobileqq.easysync2.UserChangeData;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.writetogether.IWriteTogetherObserver;
import com.tencent.mobileqq.writetogether.WriteTogetherOidbObserver;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherOidbHandler;
import com.tencent.mobileqq.writetogether.api.impl.WriteTogetherOidbHandlerImpl;
import com.tencent.mobileqq.writetogether.data.LocalATextGetter;
import com.tencent.mobileqq.writetogether.websocket.msg.AcceptCommitAndNewChangesHeader;
import com.tencent.mobileqq.writetogether.websocket.msg.AcceptCommitMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.CommitErrorMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.CommitErrorMsg.Body;
import com.tencent.mobileqq.writetogether.websocket.msg.CommitErrorMsg.Data;
import com.tencent.mobileqq.writetogether.websocket.msg.CommitErrorMsg.Header;
import com.tencent.mobileqq.writetogether.websocket.msg.IWriteTogetherMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.LastReversionMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.LastReversionMsg.Body;
import com.tencent.mobileqq.writetogether.websocket.msg.LastReversionMsg.Notice;
import com.tencent.mobileqq.writetogether.websocket.msg.NewChangesMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.NewChangesMsg.Body;
import com.tencent.mobileqq.writetogether.websocket.msg.NewChangesMsg.Data;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.mobileqq.writetogether.websocket.msg.Type;
import com.tencent.mobileqq.writetogether.websocket.msg.UserChangesHeader;
import com.tencent.mobileqq.writetogether.websocket.msg.UserChangesReqMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.UserChangesReqMsg.UserChangesReqBody;
import com.tencent.mobileqq.writetogether.websocket.msg.UserChangesRespMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ChangesetClient
  implements UserChangeCallback, IWriteTogetherObserver, ISchedulerCallback
{
  IScheduler a;
  int b;
  UserChangesReqMsg c;
  TreeSet<NewChangesMsg.Data> d = new TreeSet();
  int e;
  int f;
  INetInfoHandler g;
  private AppInterface h;
  private IQQWriteTogetherService i;
  private String j;
  private String k;
  private String l;
  private String m;
  private IChangesetTracker n;
  private IOnChangesetCommit o;
  private WriteTogetherOidbObserver p;
  private LocalATextGetter q;
  
  public ChangesetClient(AppRuntime paramAppRuntime, @NonNull IChangesetTracker paramIChangesetTracker, @NonNull String paramString1, int paramInt, String paramString2)
  {
    if ((paramAppRuntime instanceof AppInterface)) {
      this.h = ((AppInterface)paramAppRuntime);
    } else {
      QLog.e("ChangesetClient", 1, "appRuntime is not AppInterface");
    }
    this.i = ((IQQWriteTogetherService)paramAppRuntime.getRuntimeService(IQQWriteTogetherService.class, ""));
    this.n = paramIChangesetTracker;
    this.j = paramString1;
    this.k = paramAppRuntime.getAccount();
    this.b = paramInt;
    this.e = paramInt;
    this.m = paramString2;
    f();
  }
  
  private void a(NewChangesMsg.Data paramData)
  {
    this.n.a(paramData.changeset, paramData.author, paramData.apool);
    a(this.b + 1);
  }
  
  private UserChangeData b(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.n.c())) {
      return null;
    }
    return this.n.b(this.k);
  }
  
  private void e()
  {
    a(this.b + 1);
    this.n.a();
    if (this.n.b()) {
      a(false);
    }
    IOnChangesetCommit localIOnChangesetCommit = this.o;
    if (localIOnChangesetCommit != null) {
      localIOnChangesetCommit.a(this.b);
    }
  }
  
  private void f()
  {
    this.g = new ChangesetClient.MyNetInfoHandler(this, null);
    a(this.g);
    this.i.addObservers(this);
    this.p = new ChangesetClient.1(this);
    this.h.addObserver(this.p);
  }
  
  public void a()
  {
    if (this.a != null)
    {
      LocalATextGetter localLocalATextGetter = this.q;
      if ((localLocalATextGetter == null) || (!WriteTogetherUtils.a(localLocalATextGetter.c()))) {
        this.a.a(1, 500);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    this.i.updateRev(paramInt);
  }
  
  void a(INetInfoHandler paramINetInfoHandler)
  {
    AppNetConnInfo.registerConnectionChangeReceiver(MobileQQ.sMobileQQ, paramINetInfoHandler);
  }
  
  public void a(IOnChangesetCommit paramIOnChangesetCommit)
  {
    this.o = paramIOnChangesetCommit;
  }
  
  public void a(IScheduler paramIScheduler)
  {
    this.a = paramIScheduler;
    paramIScheduler.a(this);
  }
  
  void a(CommitErrorMsg paramCommitErrorMsg)
  {
    if ((((CommitErrorMsg.Body)paramCommitErrorMsg.body).data.reason == 40401) && (this.c != null) && (((CommitErrorMsg.Header)paramCommitErrorMsg.header).taskId == ((UserChangesHeader)this.c.header).taskId))
    {
      QLog.w("ChangesetClient", 1, "characters reach the limit");
      this.c = null;
    }
    this.o.a(((CommitErrorMsg.Body)paramCommitErrorMsg.body).data.reason, ((CommitErrorMsg.Body)paramCommitErrorMsg.body).data.msg);
  }
  
  void a(LastReversionMsg paramLastReversionMsg)
  {
    if (((LastReversionMsg.Body)paramLastReversionMsg.body).notice.lastRev > this.b)
    {
      b(((LastReversionMsg.Body)paramLastReversionMsg.body).notice.lastRev);
      this.e = ((LastReversionMsg.Body)paramLastReversionMsg.body).notice.lastRev;
    }
  }
  
  public void a(Type paramType, boolean paramBoolean, Object paramObject)
  {
    int i1 = ChangesetClient.2.a[paramType.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return;
            }
            a((CommitErrorMsg)paramObject);
            return;
          }
          a((LastReversionMsg)paramObject);
          return;
        }
        a(paramBoolean, (NewChangesMsg)paramObject);
        return;
      }
      a(paramBoolean, (AcceptCommitMsg)paramObject);
      return;
    }
    a(paramBoolean, (UserChangesRespMsg)paramObject);
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChangesetClient", 2, "handleUserChange");
    }
    Object localObject = this.l;
    if ((!this.n.b()) && (this.c == null)) {
      return;
    }
    if (this.c != null)
    {
      QLog.d("ChangesetClient", 1, "handleUserChange: waiting commit to be accepted");
      this.i.sendData(this.c);
      return;
    }
    if (!b())
    {
      QLog.d("ChangesetClient", 1, "handleUserChange: no network");
      return;
    }
    localObject = b(true);
    if ((localObject != null) && (((UserChangeData)localObject).a != null))
    {
      localObject = new UserChangesReqMsg(new UserChangesHeader(this.j, this.k, this.b), new UserChangesReqMsg.UserChangesReqBody(this.b, ((UserChangeData)localObject).a, ((UserChangeData)localObject).b, this.l));
      this.c = ((UserChangesReqMsg)localObject);
      this.i.sendData((IWriteTogetherMsg)localObject);
      localObject = this.o;
      if (localObject != null) {
        ((IOnChangesetCommit)localObject).b();
      }
      return;
    }
    QLog.d("ChangesetClient", 1, "handleUserChange: user change data is null");
  }
  
  void a(boolean paramBoolean, AcceptCommitMsg paramAcceptCommitMsg)
  {
    if (!paramBoolean) {
      return;
    }
    AcceptCommitAndNewChangesHeader localAcceptCommitAndNewChangesHeader = (AcceptCommitAndNewChangesHeader)paramAcceptCommitMsg.header;
    if ((this.c != null) && (localAcceptCommitAndNewChangesHeader.taskId == ((UserChangesHeader)this.c.header).taskId))
    {
      this.c = null;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("accept commit with mismatch task id: ");
      if (this.c == null)
      {
        paramAcceptCommitMsg = "null";
      }
      else
      {
        paramAcceptCommitMsg = new StringBuilder();
        paramAcceptCommitMsg.append(localAcceptCommitAndNewChangesHeader.taskId);
        paramAcceptCommitMsg.append(" <-> ");
        paramAcceptCommitMsg.append(((UserChangesHeader)this.c.header).taskId);
        paramAcceptCommitMsg = paramAcceptCommitMsg.toString();
      }
      localStringBuilder.append(paramAcceptCommitMsg);
      QLog.e("ChangesetClient", 1, localStringBuilder.toString());
    }
    if (localAcceptCommitAndNewChangesHeader.newRev != this.b + 1)
    {
      this.f = localAcceptCommitAndNewChangesHeader.baseRev;
      b(localAcceptCommitAndNewChangesHeader.newRev - 1);
      return;
    }
    e();
  }
  
  void a(boolean paramBoolean, NewChangesMsg paramNewChangesMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "handleNewChanges");
    }
    if (!paramBoolean) {
      return;
    }
    AcceptCommitAndNewChangesHeader localAcceptCommitAndNewChangesHeader = (AcceptCommitAndNewChangesHeader)paramNewChangesMsg.header;
    paramNewChangesMsg = ((NewChangesMsg.Body)paramNewChangesMsg.body).data;
    if (localAcceptCommitAndNewChangesHeader.newRev > this.b + 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get broken cs, cur rev: ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", new rev: ");
      localStringBuilder.append(localAcceptCommitAndNewChangesHeader.newRev);
      localStringBuilder.append(", newest pending merge rev: ");
      localStringBuilder.append(this.e);
      QLog.w("ChangesetClient", 1, localStringBuilder.toString());
      if (localAcceptCommitAndNewChangesHeader.newRev > this.e)
      {
        paramNewChangesMsg.newRev = localAcceptCommitAndNewChangesHeader.newRev;
        this.d.add(paramNewChangesMsg);
        b(localAcceptCommitAndNewChangesHeader.newRev - 1);
        this.e = localAcceptCommitAndNewChangesHeader.newRev;
      }
      return;
    }
    if (localAcceptCommitAndNewChangesHeader.newRev <= this.b)
    {
      QLog.w("ChangesetClient", 1, "get duplicate cs");
      return;
    }
    a(paramNewChangesMsg);
    c();
  }
  
  void a(boolean paramBoolean, UserChangesRespMsg paramUserChangesRespMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", result");
      localStringBuilder.append(((OnPostWrapper)paramUserChangesRespMsg.body).onpost.result);
      QLog.d("ChangesetClient", 2, localStringBuilder.toString());
    }
    if (((OnPostWrapper)paramUserChangesRespMsg.body).onpost.result != 0) {
      this.o.a(((OnPostWrapper)paramUserChangesRespMsg.body).onpost.result, ((OnPostWrapper)paramUserChangesRespMsg.body).onpost.errMsg);
    }
  }
  
  void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "pullDoc");
    }
    IWriteTogetherOidbHandler localIWriteTogetherOidbHandler = (IWriteTogetherOidbHandler)this.h.getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME);
    int i1 = Math.max(this.e, this.b) + 1;
    for (;;)
    {
      int i2 = paramInt - i1;
      if (i2 < 0) {
        break;
      }
      i2 = Math.min(i2 + 1, 50);
      localIWriteTogetherOidbHandler.pullDoc(this.m, this.j, i1, i2 + i1 - 1);
      i1 += 50;
    }
  }
  
  boolean b()
  {
    return NetworkUtil.isNetworkAvailable();
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "handlePendingMerges");
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      NewChangesMsg.Data localData = (NewChangesMsg.Data)localIterator.next();
      if (localData.newRev == this.b + 1)
      {
        a(localData);
        localArrayList.add(localData);
      }
      else
      {
        int i1 = localData.newRev;
        int i2 = this.b;
        if (i1 <= i2)
        {
          QLog.w("ChangesetClient", 1, "get duplicate pending merge cs");
          localArrayList.add(localData);
        }
        else
        {
          if (this.f == i2 + 1) {
            e();
          }
          if (localData.newRev != this.b + 1) {
            break;
          }
          a(localData);
          localArrayList.add(localData);
        }
      }
    }
    this.d.removeAll(localArrayList);
  }
  
  public boolean c(int paramInt)
  {
    if (paramInt == 1)
    {
      a(false);
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.i.removeObserver(this);
    this.h.removeObserver(this.p);
    AppNetConnInfo.unregisterNetInfoHandler(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.ChangesetClient
 * JD-Core Version:    0.7.0.1
 */