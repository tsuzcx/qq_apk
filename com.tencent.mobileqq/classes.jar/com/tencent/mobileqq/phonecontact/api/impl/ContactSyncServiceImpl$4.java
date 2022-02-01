package com.tencent.mobileqq.phonecontact.api.impl;

import android.accounts.Account;

class ContactSyncServiceImpl$4
  implements Runnable
{
  ContactSyncServiceImpl$4(ContactSyncServiceImpl paramContactSyncServiceImpl, Account[] paramArrayOfAccount) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$4:this$0	Lcom/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl;
    //   4: invokestatic 29	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:access$700	(Lcom/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl;)Ljava/util/concurrent/locks/Lock;
    //   7: invokeinterface 34 1 0
    //   12: iconst_1
    //   13: istore_1
    //   14: iload_1
    //   15: aload_0
    //   16: getfield 16	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$4:a	[Landroid/accounts/Account;
    //   19: arraylength
    //   20: if_icmpge +86 -> 106
    //   23: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +39 -> 65
    //   29: new 42	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: ldc 45
    //   40: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 16	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$4:a	[Landroid/accounts/Account;
    //   49: iload_1
    //   50: aaload
    //   51: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 54
    //   57: iconst_2
    //   58: aload_2
    //   59: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: getfield 14	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$4:this$0	Lcom/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl;
    //   69: invokestatic 66	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:access$800	(Lcom/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl;)Landroid/accounts/AccountManager;
    //   72: aload_0
    //   73: getfield 16	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$4:a	[Landroid/accounts/Account;
    //   76: iload_1
    //   77: aaload
    //   78: aconst_null
    //   79: aconst_null
    //   80: invokevirtual 72	android/accounts/AccountManager:removeAccount	(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
    //   83: pop
    //   84: iload_1
    //   85: iconst_1
    //   86: iadd
    //   87: istore_1
    //   88: goto -74 -> 14
    //   91: astore_2
    //   92: aload_0
    //   93: getfield 14	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$4:this$0	Lcom/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl;
    //   96: invokestatic 29	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:access$700	(Lcom/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl;)Ljava/util/concurrent/locks/Lock;
    //   99: invokeinterface 75 1 0
    //   104: aload_2
    //   105: athrow
    //   106: aload_0
    //   107: getfield 14	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl$4:this$0	Lcom/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl;
    //   110: invokestatic 29	com/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl:access$700	(Lcom/tencent/mobileqq/phonecontact/api/impl/ContactSyncServiceImpl;)Ljava/util/concurrent/locks/Lock;
    //   113: invokeinterface 75 1 0
    //   118: return
    //   119: astore_2
    //   120: goto -14 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	4
    //   13	75	1	i	int
    //   36	23	2	localStringBuilder	java.lang.StringBuilder
    //   91	14	2	localObject	Object
    //   119	1	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   14	65	91	finally
    //   65	84	91	finally
    //   14	65	119	java/lang/Throwable
    //   65	84	119	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */