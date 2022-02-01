package com.tencent.mobileqq.kandian.biz.common;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadInJoyHandler
  extends BusinessHandler
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ReadInJoyRemoteCommand jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRemoteCommand = null;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  
  public ReadInJoyHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    ReadInJoyRemoteCommand localReadInJoyRemoteCommand = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRemoteCommand;
    if (localReadInJoyRemoteCommand != null)
    {
      localReadInJoyRemoteCommand.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRemoteCommand = null;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readInJoyFeedsMsgNotify, isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",isNewMsgCome=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(",reason=");
      localStringBuilder.append(paramInt);
      QLog.i("ReadInJoyHandler", 2, localStringBuilder.toString());
    }
    notifyUI(1, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null) {
      this.allowCmdSet = new HashSet();
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ReadInJoyObserver.class;
  }
  
  public void onDestroy()
  {
    a();
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyHandler
 * JD-Core Version:    0.7.0.1
 */