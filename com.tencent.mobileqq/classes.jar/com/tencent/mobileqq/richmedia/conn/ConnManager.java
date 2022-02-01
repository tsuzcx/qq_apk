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
  private static String b = "PeakAudioTransHandler ConnManager";
  protected ConcurrentLinkedQueue<byte[]> a = new ConcurrentLinkedQueue();
  private IConnection c = null;
  private AppInterface d;
  private Handler e;
  private HostInfo f;
  private ArrayList<HostInfo> g = new ArrayList();
  private ChannelStateManager h;
  
  public ConnManager(AppInterface paramAppInterface, ChannelStateManager paramChannelStateManager)
  {
    this.d = paramAppInterface;
    this.h = paramChannelStateManager;
    this.e = new Handler(Looper.getMainLooper());
  }
  
  private void b(long paramLong)
  {
    this.e.post(new ConnManager.4(this, paramLong));
  }
  
  public void a(long paramLong)
  {
    if (this.c != null)
    {
      if (!this.h.g())
      {
        String str = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeConnection : TCP not opened  mTCPstate =");
        localStringBuilder.append(this.h.b());
        QLog.e(str, 1, localStringBuilder.toString());
        return;
      }
      this.h.b(13);
      this.c.b();
      this.c = null;
    }
  }
  
  public void a(long paramLong, IConnection paramIConnection)
  {
    if (QLog.isColorLevel())
    {
      paramIConnection = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDisConnect connId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",sendDataQueue size =");
      localStringBuilder.append(this.a.size());
      localStringBuilder.append(" mTCPstate =");
      localStringBuilder.append(this.h.b());
      QLog.e(paramIConnection, 2, localStringBuilder.toString());
    }
    this.h.b(10);
    this.f = null;
    this.a.clear();
    this.g.clear();
    if (this.h.c())
    {
      ((PeakAudioTransHandler)this.d.getBusinessHandler(PeakAppInterface.b)).a(String.valueOf(paramLong), "TransInfo.ExitSession", null, 0, 0, false);
      return;
    }
    QLog.e(b, 1, "onDisConnect : session not open need not sso exit");
  }
  
  public void a(HostInfo paramHostInfo, long paramLong)
  {
    if (paramHostInfo == null)
    {
      QLog.e(b, 1, "openNewConnection : endPoint is null");
      return;
    }
    if ((!TextUtils.isEmpty(paramHostInfo.a)) && (paramHostInfo.b != 0))
    {
      if (!this.h.c())
      {
        QLog.e(b, 1, "openNewConnection : Session not Open");
        return;
      }
      if (!this.h.i())
      {
        paramHostInfo = b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openNewConnection : TCP not Close mTCPstate =");
        ((StringBuilder)localObject).append(this.h.b());
        QLog.e(paramHostInfo, 1, ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openNewConnection : host:");
      localStringBuilder.append(paramHostInfo.a);
      localStringBuilder.append(",port=");
      localStringBuilder.append(paramHostInfo.b);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      this.f = paramHostInfo;
      localObject = this.c;
      if (localObject != null) {
        ((IConnection)localObject).b();
      }
      this.c = new LiteTcpConnection(this, paramLong, paramHostInfo, 3000, 10000);
      paramHostInfo = this.c;
      if (paramHostInfo != null)
      {
        paramHostInfo.a(this);
        this.c.a();
        this.h.b(11);
      }
      return;
    }
    QLog.e(b, 1, "openNewConnection : endPoint is illegal");
  }
  
  public void a(ArrayList<HostInfo> paramArrayList)
  {
    this.g.clear();
    this.g.addAll(paramArrayList);
  }
  
  public void a(boolean paramBoolean, long paramLong, IConnection paramIConnection, HostInfo paramHostInfo, int paramInt)
  {
    paramIConnection = (PeakAudioTransHandler)this.d.getBusinessHandler(PeakAppInterface.b);
    if (paramHostInfo == null)
    {
      QLog.e(b, 2, "onConnect failed ep = null return");
      b(paramLong);
      return;
    }
    if (paramBoolean)
    {
      this.e.post(new ConnManager.1(this, paramIConnection, paramLong, paramHostInfo));
      return;
    }
    paramIConnection = paramHostInfo.a;
    int i = paramHostInfo.b;
    paramHostInfo = this.f;
    if ((paramHostInfo != null) && (paramIConnection.equals(paramHostInfo.a)) && (i == this.f.b))
    {
      if (!this.h.k())
      {
        if (QLog.isColorLevel())
        {
          paramIConnection = b;
          paramHostInfo = new StringBuilder();
          paramHostInfo.append("onConnect reConnect state legal lSessionID = ");
          paramHostInfo.append(paramLong);
          QLog.e(paramIConnection, 2, paramHostInfo.toString());
        }
        b(paramLong);
        return;
      }
      if (!this.h.h())
      {
        paramIConnection = b;
        paramHostInfo = new StringBuilder();
        paramHostInfo.append("onConnect : TCP not in Opening state = ");
        paramHostInfo.append(this.h.b());
        QLog.e(paramIConnection, 1, paramHostInfo.toString());
        a(paramLong);
        return;
      }
      if (this.f.f >= 1)
      {
        QLog.d(b, 2, "reConnect > 1 return");
        int j = 0;
        paramInt = 0;
        for (;;)
        {
          i = j;
          if (paramInt >= this.g.size()) {
            break;
          }
          paramIConnection = (HostInfo)this.g.get(paramInt);
          if ((paramIConnection != this.f) && (paramIConnection.f == 0))
          {
            this.f = paramIConnection;
            i = 1;
            break;
          }
          paramInt += 1;
        }
        if (i != 0)
        {
          if (QLog.isColorLevel())
          {
            paramIConnection = b;
            paramHostInfo = new StringBuilder();
            paramHostInfo.append("onConnect failed change ip new ip = ");
            paramHostInfo.append(this.f.a);
            paramHostInfo.append(", port =");
            paramHostInfo.append(this.f.b);
            QLog.d(paramIConnection, 2, paramHostInfo.toString());
          }
          a(this.f, paramLong);
          return;
        }
        QLog.e(b, 2, "onConnect  not ip notify  connect failed ");
        b(paramLong);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramIConnection = b;
        paramHostInfo = new StringBuilder();
        paramHostInfo.append("onConnect failed reconnect ip = ");
        paramHostInfo.append(this.f.a);
        paramHostInfo.append(", port =");
        paramHostInfo.append(this.f.b);
        QLog.d(paramIConnection, 2, paramHostInfo.toString());
      }
      if (paramInt == 3) {
        this.e.postDelayed(new ConnManager.2(this, paramLong), 2000L);
      } else {
        this.e.post(new ConnManager.3(this, paramLong));
      }
      paramIConnection = this.f;
      if (paramIConnection != null) {
        paramIConnection.f += 1;
      }
      return;
    }
    QLog.e(b, 2, "onConnect ip or port changed ");
    b(paramLong);
  }
  
  public boolean a()
  {
    return NetworkUtil.isNetSupportHw(this.d.getApp().getApplicationContext());
  }
  
  public byte[] b()
  {
    if (!this.a.isEmpty()) {
      return (byte[])this.a.poll();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.ConnManager
 * JD-Core Version:    0.7.0.1
 */