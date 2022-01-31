package com.tencent.mobileqq.richmedia.conn;

import ahnb;
import ahnc;
import ahnd;
import ahne;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
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
  private IConnection jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection;
  private ChannelStateManager jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected ConcurrentLinkedQueue a;
  
  public ConnManager(AppInterface paramAppInterface, ChannelStateManager paramChannelStateManager)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager = paramChannelStateManager;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ahne(this, paramLong));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection.b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.d()) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeConnection : TCP not opened  mTCPstate =" + this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b(13);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection = null;
  }
  
  public void a(long paramLong, IConnection paramIConnection)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onDisConnect connId = " + paramLong + ",sendDataQueue size =" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() + " mTCPstate =" + this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b());
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b(10);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.a())
    {
      ((PeakAudioTransHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0)).a(String.valueOf(paramLong), "TransInfo.ExitSession", null, 0, 0, false);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onDisConnect : session not open need not sso exit");
  }
  
  public void a(HostInfo paramHostInfo, long paramLong)
  {
    if (paramHostInfo == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is null");
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramHostInfo.jdField_a_of_type_JavaLangString)) || (paramHostInfo.jdField_a_of_type_Int == 0))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is illegal");
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.a())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : Session not Open");
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.f())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : TCP not Close mTCPstate =" + this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b());
        return;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "openNewConnection : host:" + paramHostInfo.jdField_a_of_type_JavaLangString + ",port=" + paramHostInfo.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo = paramHostInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection = new LiteTcpConnection(this, paramLong, paramHostInfo, 3000, 10000);
    } while (this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection == null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection.a(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b(11);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public void a(boolean paramBoolean, long paramLong, IConnection paramIConnection, HostInfo paramHostInfo, int paramInt)
  {
    int j = 0;
    paramIConnection = (PeakAudioTransHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0);
    if (paramHostInfo == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect failed ep = null return");
      b(paramLong);
    }
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new ahnb(this, paramIConnection, paramLong, paramHostInfo));
        return;
      }
      paramIConnection = paramHostInfo.jdField_a_of_type_JavaLangString;
      int i = paramHostInfo.jdField_a_of_type_Int;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo == null) || (!paramIConnection.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_JavaLangString)) || (i != this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_Int))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect ip or port changed ");
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.h())
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect reConnect state legal lSessionID = " + paramLong);
        }
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.e())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "onConnect : TCP not in Opening state = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaServerChannelStateManager.b());
        a(paramLong);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.c >= 1)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "reConnect > 1 return");
        paramInt = 0;
        for (;;)
        {
          i = j;
          if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramIConnection = (HostInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((paramIConnection != this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo) && (paramIConnection.c == 0))
            {
              this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo = paramIConnection;
              i = 1;
            }
          }
          else
          {
            if (i == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed change ip new ip = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_Int);
            }
            a(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo, paramLong);
            return;
          }
          paramInt += 1;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect  not ip notify  connect failed ");
        b(paramLong);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed reconnect ip = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_Int);
      }
      if (paramInt == 3) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ahnc(this, paramLong), 2000L);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo != null)
      {
        paramIConnection = this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo;
        paramIConnection.c += 1;
        return;
        this.jdField_a_of_type_AndroidOsHandler.post(new ahnd(this, paramLong));
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramArrayOfByte);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnection.c();
    }
  }
  
  public boolean a()
  {
    return NetworkUtil.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
  }
  
  public byte[] a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      return (byte[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.ConnManager
 * JD-Core Version:    0.7.0.1
 */