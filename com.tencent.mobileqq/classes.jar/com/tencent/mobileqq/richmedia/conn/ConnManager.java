package com.tencent.mobileqq.richmedia.conn;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.server.ChannelStateManager;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnManager
  implements IConnectionListener
{
  private static String jdField_a_of_type_JavaLangString = "PeakAudioTransHandler ConnManager";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private HostInfo jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo;
  private IConnection jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection = null;
  private ChannelStateManager jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager;
  private ArrayList<HostInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected ConcurrentLinkedQueue<byte[]> a;
  
  public ConnManager(AppInterface paramAppInterface, ChannelStateManager paramChannelStateManager)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager = paramChannelStateManager;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.4(this, paramLong));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.d())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeConnection : TCP not opened  mTCPstate =");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b());
        QLog.e(str, 1, localStringBuilder.toString());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b(13);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection.b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection = null;
    }
  }
  
  public void a(long paramLong, IConnection paramIConnection)
  {
    if (QLog.isColorLevel())
    {
      paramIConnection = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDisConnect connId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",sendDataQueue size =");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      localStringBuilder.append(" mTCPstate =");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b());
      QLog.e(paramIConnection, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b(10);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.a())
    {
      ((PeakAudioTransHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(PeakAppInterface.jdField_a_of_type_JavaLangString)).a(String.valueOf(paramLong), "TransInfo.ExitSession", null, 0, 0, false);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onDisConnect : session not open need not sso exit");
  }
  
  public void a(HostInfo paramHostInfo, long paramLong)
  {
    if (paramHostInfo == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is null");
      return;
    }
    if ((!TextUtils.isEmpty(paramHostInfo.jdField_a_of_type_JavaLangString)) && (paramHostInfo.jdField_a_of_type_Int != 0))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.a())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : Session not Open");
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.f())
      {
        paramHostInfo = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openNewConnection : TCP not Close mTCPstate =");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b());
        QLog.e(paramHostInfo, 1, ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openNewConnection : host:");
      localStringBuilder.append(paramHostInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",port=");
      localStringBuilder.append(paramHostInfo.jdField_a_of_type_Int);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo = paramHostInfo;
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection;
      if (localObject != null) {
        ((IConnection)localObject).b();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection = new LiteTcpConnection(this, paramLong, paramHostInfo, 3000, 10000);
      paramHostInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection;
      if (paramHostInfo != null)
      {
        paramHostInfo.a(this);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection.a();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b(11);
      }
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is illegal");
  }
  
  public void a(ArrayList<HostInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public void a(boolean paramBoolean, long paramLong, IConnection paramIConnection, HostInfo paramHostInfo, int paramInt)
  {
    paramIConnection = (PeakAudioTransHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(PeakAppInterface.jdField_a_of_type_JavaLangString);
    if (paramHostInfo == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect failed ep = null return");
      b(paramLong);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.1(this, paramIConnection, paramLong, paramHostInfo));
      return;
    }
    paramIConnection = paramHostInfo.jdField_a_of_type_JavaLangString;
    int i = paramHostInfo.jdField_a_of_type_Int;
    paramHostInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo;
    if ((paramHostInfo != null) && (paramIConnection.equals(paramHostInfo.jdField_a_of_type_JavaLangString)) && (i == this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_Int))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.g())
      {
        if (QLog.isColorLevel())
        {
          paramIConnection = jdField_a_of_type_JavaLangString;
          paramHostInfo = new StringBuilder();
          paramHostInfo.append("onConnect reConnect state legal lSessionID = ");
          paramHostInfo.append(paramLong);
          QLog.e(paramIConnection, 2, paramHostInfo.toString());
        }
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.e())
      {
        paramIConnection = jdField_a_of_type_JavaLangString;
        paramHostInfo = new StringBuilder();
        paramHostInfo.append("onConnect : TCP not in Opening state = ");
        paramHostInfo.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b());
        QLog.e(paramIConnection, 1, paramHostInfo.toString());
        a(paramLong);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.d >= 1)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "reConnect > 1 return");
        int j = 0;
        paramInt = 0;
        for (;;)
        {
          i = j;
          if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          paramIConnection = (HostInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
          if ((paramIConnection != this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo) && (paramIConnection.d == 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo = paramIConnection;
            i = 1;
            break;
          }
          paramInt += 1;
        }
        if (i != 0)
        {
          if (QLog.isColorLevel())
          {
            paramIConnection = jdField_a_of_type_JavaLangString;
            paramHostInfo = new StringBuilder();
            paramHostInfo.append("onConnect failed change ip new ip = ");
            paramHostInfo.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_JavaLangString);
            paramHostInfo.append(", port =");
            paramHostInfo.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_Int);
            QLog.d(paramIConnection, 2, paramHostInfo.toString());
          }
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo, paramLong);
          return;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect  not ip notify  connect failed ");
        b(paramLong);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramIConnection = jdField_a_of_type_JavaLangString;
        paramHostInfo = new StringBuilder();
        paramHostInfo.append("onConnect failed reconnect ip = ");
        paramHostInfo.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_JavaLangString);
        paramHostInfo.append(", port =");
        paramHostInfo.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_Int);
        QLog.d(paramIConnection, 2, paramHostInfo.toString());
      }
      if (paramInt == 3) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ConnManager.2(this, paramLong), 2000L);
      } else {
        this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.3(this, paramLong));
      }
      paramIConnection = this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo;
      if (paramIConnection != null) {
        paramIConnection.d += 1;
      }
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect ip or port changed ");
    b(paramLong);
  }
  
  public boolean a()
  {
    return NetworkUtil.isNetSupportHw(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
  }
  
  public byte[] a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      return (byte[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.ConnManager
 * JD-Core Version:    0.7.0.1
 */