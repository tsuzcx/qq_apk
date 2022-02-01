package com.tencent.mobileqq.equipmentlock;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;

public class EquipLockWebImpl
{
  private static byte[] b = new byte[0];
  private static EquipLockWebImpl c = null;
  WtloginObserver a = new EquipLockWebImpl.2(this);
  private WeakReference<QQAppInterface> d = null;
  private Messenger e = null;
  private FriendListObserver f = new EquipLockWebImpl.1(this);
  
  public static EquipLockWebImpl a()
  {
    if (c == null) {
      synchronized (b)
      {
        if (c == null) {
          c = new EquipLockWebImpl();
        }
      }
    }
    return c;
  }
  
  private void a(int paramInt)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("checkDevLockSms_ret", paramInt);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "openEquipmentLock");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.e != null) {
      try
      {
        Message localMessage = Message.obtain(null, 4);
        localMessage.setData(paramBundle);
        this.e.send(localMessage);
        if (QLog.isColorLevel())
        {
          QLog.i("EquipLockWebImpl", 2, "resp to sever: ");
          return;
        }
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isWaiting", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "setWaitingResponse");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  public static void b()
  {
    if (c != null) {
      synchronized (b)
      {
        if ((c != null) && (c.d != null))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)c.d.get();
          if (localQQAppInterface != null) {
            localQQAppInterface.removeObserver(c.f);
          }
          c = null;
        }
        return;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("setMobileResult", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "setMobileResult");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  private void c(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isBack", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "closeWeb");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Messenger paramMessenger)
  {
    this.d = new WeakReference(paramQQAppInterface);
    this.e = paramMessenger;
    paramQQAppInterface.addObserver(this.f);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (QQAppInterface)((WeakReference)localObject).get();
      if (localObject != null)
      {
        i = EquipmentLockImpl.a().a((AppRuntime)localObject, ((QQAppInterface)localObject).getCurrentAccountUin(), null, paramArrayOfByte, this.a);
        break label47;
      }
    }
    int i = -1;
    label47:
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipLockWebImpl
 * JD-Core Version:    0.7.0.1
 */