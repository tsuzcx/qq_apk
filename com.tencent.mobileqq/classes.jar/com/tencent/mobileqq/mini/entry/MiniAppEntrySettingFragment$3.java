package com.tencent.mobileqq.mini.entry;

import java.util.List;

class MiniAppEntrySettingFragment$3
  implements Runnable
{
  MiniAppEntrySettingFragment$3(MiniAppEntrySettingFragment paramMiniAppEntrySettingFragment, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment$3:this$0	Lcom/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment;
    //   4: invokestatic 29	com/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment:access$200	(Lcom/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment;)Lcom/tencent/mobileqq/app/BaseActivity;
    //   7: ifnull +102 -> 109
    //   10: aload_0
    //   11: getfield 14	com/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment$3:this$0	Lcom/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment;
    //   14: invokestatic 29	com/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment:access$200	(Lcom/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment;)Lcom/tencent/mobileqq/app/BaseActivity;
    //   17: getfield 35	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +12 -> 34
    //   25: ldc 37
    //   27: iconst_2
    //   28: ldc 39
    //   30: invokestatic 45	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: return
    //   34: ldc 37
    //   36: iconst_1
    //   37: ldc 47
    //   39: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: invokevirtual 56	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   46: invokevirtual 62	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnonnull +4 -> 55
    //   54: return
    //   55: aload_2
    //   56: invokevirtual 68	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 73	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   64: aload_2
    //   65: ldc 75
    //   67: invokevirtual 79	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   70: pop
    //   71: aload_1
    //   72: invokevirtual 82	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   75: goto +12 -> 87
    //   78: astore_2
    //   79: goto +24 -> 103
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   87: aload_1
    //   88: invokevirtual 88	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   91: aload_0
    //   92: getfield 14	com/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment$3:this$0	Lcom/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment;
    //   95: aload_0
    //   96: getfield 16	com/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment$3:val$serverSwitchInfoEntities	Ljava/util/List;
    //   99: invokestatic 91	com/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment:access$400	(Lcom/tencent/mobileqq/mini/entry/MiniAppEntrySettingFragment;Ljava/util/List;)V
    //   102: return
    //   103: aload_1
    //   104: invokevirtual 88	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   107: aload_2
    //   108: athrow
    //   109: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	3
    //   20	84	1	localObject1	Object
    //   49	16	2	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   78	1	2	localObject2	Object
    //   82	26	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   60	75	78	finally
    //   83	87	78	finally
    //   60	75	82	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.3
 * JD-Core Version:    0.7.0.1
 */