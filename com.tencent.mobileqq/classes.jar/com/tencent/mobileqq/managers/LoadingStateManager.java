package com.tencent.mobileqq.managers;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.NetStateTipsObserver;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LoadingStateManager
{
  private static LoadingStateManager a;
  private int b = 1;
  private boolean c = false;
  private boolean d = false;
  
  private LoadingStateManager()
  {
    if (NetConnInfoCenter.socketConnState == 4) {
      this.b = 2;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LoadingStateManager init loadingstate = ");
      localStringBuilder.append(this.b);
      QLog.d("LoadingStateManager", 2, localStringBuilder.toString());
    }
  }
  
  public static LoadingStateManager b()
  {
    if (a == null) {
      a = new LoadingStateManager();
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, QQAppInterface paramQQAppInterface)
  {
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.getAttribute("_tag_socket") == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("notifyIsNotIllegalNetWork mShowIllegalNetworkBar=");
        paramFromServiceMsg.append(this.c);
        QLog.d("LoadingStateManager", 2, paramFromServiceMsg.toString());
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("changeConversationLoadingState mShowErrorNetworkBar=");
        paramFromServiceMsg.append(this.d);
        QLog.d("LoadingStateManager", 2, paramFromServiceMsg.toString());
      }
      paramQQAppInterface.notifyObservers(NetStateTipsObserver.class, 1, true, null);
      if ((!this.c) && (!this.d)) {
        return;
      }
      if (this.d)
      {
        paramFromServiceMsg = paramQQAppInterface.getHandler(Conversation.class);
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.obtainMessage(10002, null).sendToTarget();
        }
        return;
      }
      if (!d()) {
        a(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadingStateManager", 2, "notifyIsNotIllegalNetWork");
      }
      paramFromServiceMsg = paramQQAppInterface.getHandler(Conversation.class);
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.obtainMessage(1134012, null).sendToTarget();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean c()
  {
    int i = this.b;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean d()
  {
    return this.b == 3;
  }
  
  public boolean e()
  {
    return this.b == 4;
  }
  
  public int f()
  {
    return this.b;
  }
  
  public void g()
  {
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.LoadingStateManager
 * JD-Core Version:    0.7.0.1
 */