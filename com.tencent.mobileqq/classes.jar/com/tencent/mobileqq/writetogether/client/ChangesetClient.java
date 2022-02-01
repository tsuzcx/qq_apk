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
  int jdField_a_of_type_Int;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private IChangesetTracker jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker;
  INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private WriteTogetherOidbObserver jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver;
  private IQQWriteTogetherService jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService;
  private IOnChangesetCommit jdField_a_of_type_ComTencentMobileqqWritetogetherClientIOnChangesetCommit;
  IScheduler jdField_a_of_type_ComTencentMobileqqWritetogetherClientIScheduler;
  private LocalATextGetter jdField_a_of_type_ComTencentMobileqqWritetogetherDataLocalATextGetter;
  UserChangesReqMsg jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg;
  private String jdField_a_of_type_JavaLangString;
  TreeSet<NewChangesMsg.Data> jdField_a_of_type_JavaUtilTreeSet = new TreeSet();
  int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  public ChangesetClient(AppRuntime paramAppRuntime, @NonNull IChangesetTracker paramIChangesetTracker, @NonNull String paramString1, int paramInt, String paramString2)
  {
    if ((paramAppRuntime instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramAppRuntime);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService = ((IQQWriteTogetherService)paramAppRuntime.getRuntimeService(IQQWriteTogetherService.class, ""));
      this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker = paramIChangesetTracker;
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramAppRuntime.getAccount();
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_b_of_type_Int = paramInt;
      this.d = paramString2;
      e();
      return;
      QLog.e("ChangesetClient", 1, "appRuntime is not AppInterface");
    }
  }
  
  private UserChangeData a(boolean paramBoolean)
  {
    if ((paramBoolean) || (!this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.b())) {
      return this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a(this.jdField_b_of_type_JavaLangString);
    }
    return null;
  }
  
  private void a(NewChangesMsg.Data paramData)
  {
    this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a(paramData.changeset, paramData.author, paramData.apool);
    a(this.jdField_a_of_type_Int + 1);
  }
  
  private void d()
  {
    a(this.jdField_a_of_type_Int + 1);
    this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a();
    if (this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a()) {
      a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIOnChangesetCommit != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIOnChangesetCommit.a(this.jdField_a_of_type_Int);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ChangesetClient.MyNetInfoHandler(this, null);
    a(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService.addObservers(this);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver = new ChangesetClient.1(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIScheduler != null) && ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataLocalATextGetter == null) || (!WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataLocalATextGetter.a())))) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIScheduler.a(1, 500);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService.updateRev(paramInt);
  }
  
  void a(INetInfoHandler paramINetInfoHandler)
  {
    AppNetConnInfo.registerConnectionChangeReceiver(MobileQQ.sMobileQQ, paramINetInfoHandler);
  }
  
  public void a(IOnChangesetCommit paramIOnChangesetCommit)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIOnChangesetCommit = paramIOnChangesetCommit;
  }
  
  public void a(IScheduler paramIScheduler)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIScheduler = paramIScheduler;
    paramIScheduler.a(this);
  }
  
  void a(CommitErrorMsg paramCommitErrorMsg)
  {
    if ((((CommitErrorMsg.Body)paramCommitErrorMsg.body).data.reason == 40401) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg != null) && (((CommitErrorMsg.Header)paramCommitErrorMsg.header).taskId == ((UserChangesHeader)this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg.header).taskId))
    {
      QLog.w("ChangesetClient", 1, "characters reach the limit");
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIOnChangesetCommit.a(((CommitErrorMsg.Body)paramCommitErrorMsg.body).data.reason, ((CommitErrorMsg.Body)paramCommitErrorMsg.body).data.msg);
  }
  
  void a(LastReversionMsg paramLastReversionMsg)
  {
    if (((LastReversionMsg.Body)paramLastReversionMsg.body).notice.lastRev > this.jdField_a_of_type_Int)
    {
      b(((LastReversionMsg.Body)paramLastReversionMsg.body).notice.lastRev);
      this.jdField_b_of_type_Int = ((LastReversionMsg.Body)paramLastReversionMsg.body).notice.lastRev;
    }
  }
  
  public void a(Type paramType, boolean paramBoolean, Object paramObject)
  {
    switch (ChangesetClient.2.a[paramType.ordinal()])
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, (UserChangesRespMsg)paramObject);
      return;
    case 2: 
      a(paramBoolean, (AcceptCommitMsg)paramObject);
      return;
    case 3: 
      a(paramBoolean, (NewChangesMsg)paramObject);
      return;
    case 4: 
      a((LastReversionMsg)paramObject);
      return;
    }
    a((CommitErrorMsg)paramObject);
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChangesetClient", 2, "handleUserChange");
    }
    if ((this.jdField_c_of_type_JavaLangString != null) || ((!this.jdField_a_of_type_ComTencentMobileqqEasysync2IChangesetTracker.a()) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg == null))) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg != null)
      {
        QLog.d("ChangesetClient", 1, "handleUserChange: waiting commit to be accepted");
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService.sendData(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg);
        return;
      }
      if (!a())
      {
        QLog.d("ChangesetClient", 1, "handleUserChange: no network");
        return;
      }
      Object localObject = a(true);
      if ((localObject == null) || (((UserChangeData)localObject).jdField_a_of_type_JavaLangString == null))
      {
        QLog.d("ChangesetClient", 1, "handleUserChange: user change data is null");
        return;
      }
      localObject = new UserChangesReqMsg(new UserChangesHeader(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int), new UserChangesReqMsg.UserChangesReqBody(this.jdField_a_of_type_Int, ((UserChangeData)localObject).jdField_a_of_type_JavaLangString, ((UserChangeData)localObject).jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool, this.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg = ((UserChangesReqMsg)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService.sendData((IWriteTogetherMsg)localObject);
    } while (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIOnChangesetCommit == null);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIOnChangesetCommit.a();
  }
  
  void a(boolean paramBoolean, AcceptCommitMsg paramAcceptCommitMsg)
  {
    if (!paramBoolean) {
      return;
    }
    AcceptCommitAndNewChangesHeader localAcceptCommitAndNewChangesHeader = (AcceptCommitAndNewChangesHeader)paramAcceptCommitMsg.header;
    if ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg != null) && (localAcceptCommitAndNewChangesHeader.taskId == ((UserChangesHeader)this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg.header).taskId))
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg = null;
      if (localAcceptCommitAndNewChangesHeader.newRev != this.jdField_a_of_type_Int + 1)
      {
        this.jdField_c_of_type_Int = localAcceptCommitAndNewChangesHeader.baseRev;
        b(localAcceptCommitAndNewChangesHeader.newRev - 1);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder().append("accept commit with mismatch task id: ");
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg == null) {}
      for (paramAcceptCommitMsg = "null";; paramAcceptCommitMsg = localAcceptCommitAndNewChangesHeader.taskId + " <-> " + ((UserChangesHeader)this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgUserChangesReqMsg.header).taskId)
      {
        QLog.e("ChangesetClient", 1, paramAcceptCommitMsg);
        break;
      }
    }
    d();
  }
  
  void a(boolean paramBoolean, NewChangesMsg paramNewChangesMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "handleNewChanges");
    }
    if (!paramBoolean) {}
    AcceptCommitAndNewChangesHeader localAcceptCommitAndNewChangesHeader;
    do
    {
      return;
      localAcceptCommitAndNewChangesHeader = (AcceptCommitAndNewChangesHeader)paramNewChangesMsg.header;
      paramNewChangesMsg = ((NewChangesMsg.Body)paramNewChangesMsg.body).data;
      if (localAcceptCommitAndNewChangesHeader.newRev <= this.jdField_a_of_type_Int + 1) {
        break;
      }
      QLog.w("ChangesetClient", 1, "get broken cs, cur rev: " + this.jdField_a_of_type_Int + ", new rev: " + localAcceptCommitAndNewChangesHeader.newRev + ", newest pending merge rev: " + this.jdField_b_of_type_Int);
    } while (localAcceptCommitAndNewChangesHeader.newRev <= this.jdField_b_of_type_Int);
    paramNewChangesMsg.newRev = localAcceptCommitAndNewChangesHeader.newRev;
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramNewChangesMsg);
    b(localAcceptCommitAndNewChangesHeader.newRev - 1);
    this.jdField_b_of_type_Int = localAcceptCommitAndNewChangesHeader.newRev;
    return;
    if (localAcceptCommitAndNewChangesHeader.newRev <= this.jdField_a_of_type_Int)
    {
      QLog.w("ChangesetClient", 1, "get duplicate cs");
      return;
    }
    a(paramNewChangesMsg);
    b();
  }
  
  void a(boolean paramBoolean, UserChangesRespMsg paramUserChangesRespMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChangesetClient", 2, "isSuccess: " + paramBoolean + ", result" + ((OnPostWrapper)paramUserChangesRespMsg.body).onpost.result);
    }
    if (((OnPostWrapper)paramUserChangesRespMsg.body).onpost.result != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIOnChangesetCommit.a(((OnPostWrapper)paramUserChangesRespMsg.body).onpost.result, ((OnPostWrapper)paramUserChangesRespMsg.body).onpost.errMsg);
    }
  }
  
  boolean a()
  {
    return NetworkUtil.a();
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 1)
    {
      a(false);
      return true;
    }
    return false;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "handlePendingMerges");
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    while (localIterator.hasNext())
    {
      NewChangesMsg.Data localData = (NewChangesMsg.Data)localIterator.next();
      if (localData.newRev == this.jdField_a_of_type_Int + 1)
      {
        a(localData);
        localArrayList.add(localData);
      }
      else if (localData.newRev <= this.jdField_a_of_type_Int)
      {
        QLog.w("ChangesetClient", 1, "get duplicate pending merge cs");
        localArrayList.add(localData);
      }
      else
      {
        if (this.jdField_c_of_type_Int == this.jdField_a_of_type_Int + 1) {
          d();
        }
        if (localData.newRev != this.jdField_a_of_type_Int + 1) {
          break;
        }
        a(localData);
        localArrayList.add(localData);
      }
    }
    this.jdField_a_of_type_JavaUtilTreeSet.removeAll(localArrayList);
  }
  
  void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "pullDoc");
    }
    IWriteTogetherOidbHandler localIWriteTogetherOidbHandler = (IWriteTogetherOidbHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME);
    int i = Math.max(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int) + 1;
    while (paramInt - i >= 0)
    {
      int j = Math.min(paramInt - i + 1, 50);
      localIWriteTogetherOidbHandler.pullDoc(this.d, this.jdField_a_of_type_JavaLangString, i, j + i - 1);
      i += 50;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherApiIQQWriteTogetherService.removeObserver(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.ChangesetClient
 * JD-Core Version:    0.7.0.1
 */