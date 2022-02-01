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
  private static EquipLockWebImpl jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl = null;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private Messenger jdField_a_of_type_AndroidOsMessenger = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new EquipLockWebImpl.1(this);
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference = null;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new EquipLockWebImpl.2(this);
  
  public static EquipLockWebImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl == null) {
          jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl = new EquipLockWebImpl();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl != null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if ((jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl != null) && (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl.jdField_a_of_type_JavaLangRefWeakReference != null))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localQQAppInterface != null) {
            localQQAppInterface.removeObserver(jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          }
          jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl = null;
        }
        return;
      }
    }
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
    if (this.jdField_a_of_type_AndroidOsMessenger != null) {
      try
      {
        Message localMessage = Message.obtain(null, 4);
        localMessage.setData(paramBundle);
        this.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
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
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsMessenger = paramMessenger;
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (QQAppInterface)((WeakReference)localObject).get();
      if (localObject != null)
      {
        i = EquipmentLockImpl.a().a((AppRuntime)localObject, ((QQAppInterface)localObject).getCurrentAccountUin(), null, paramArrayOfByte, this.jdField_a_of_type_MqqObserverWtloginObserver);
        break label47;
      }
    }
    int i = -1;
    label47:
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipLockWebImpl
 * JD-Core Version:    0.7.0.1
 */