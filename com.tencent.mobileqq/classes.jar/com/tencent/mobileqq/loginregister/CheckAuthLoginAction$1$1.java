package com.tencent.mobileqq.loginregister;

class CheckAuthLoginAction$1$1
  implements Runnable
{
  CheckAuthLoginAction$1$1(CheckAuthLoginAction.1 param1) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: ldc 27
    //   5: invokestatic 32	com/tencent/mobileqq/cooperation/ApkUtils:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   8: ifle +185 -> 193
    //   11: new 34	android/content/Intent
    //   14: dup
    //   15: ldc 36
    //   17: invokespecial 39	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 12	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1$1:a	Lcom/tencent/mobileqq/loginregister/CheckAuthLoginAction$1;
    //   26: getfield 44	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: invokestatic 50	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   32: invokevirtual 54	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   35: pop
    //   36: aload_0
    //   37: getfield 12	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1$1:a	Lcom/tencent/mobileqq/loginregister/CheckAuthLoginAction$1;
    //   40: getfield 57	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1:jdField_a_of_type_ComTencentMobileqqAppQBaseActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   43: aload_2
    //   44: invokevirtual 63	com/tencent/mobileqq/app/QBaseActivity:startActivity	(Landroid/content/Intent;)V
    //   47: iconst_1
    //   48: istore_1
    //   49: aload_0
    //   50: getfield 12	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1$1:a	Lcom/tencent/mobileqq/loginregister/CheckAuthLoginAction$1;
    //   53: getfield 57	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1:jdField_a_of_type_ComTencentMobileqqAppQBaseActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   56: invokevirtual 67	com/tencent/mobileqq/app/QBaseActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   59: ldc 69
    //   61: ldc 71
    //   63: ldc 71
    //   65: ldc 73
    //   67: ldc 73
    //   69: iconst_0
    //   70: iconst_0
    //   71: ldc 71
    //   73: ldc 71
    //   75: ldc 71
    //   77: ldc 71
    //   79: invokestatic 78	com/tencent/mobileqq/statistics/ReportController:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   82: iload_1
    //   83: ifne +97 -> 180
    //   86: aload_0
    //   87: getfield 12	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1$1:a	Lcom/tencent/mobileqq/loginregister/CheckAuthLoginAction$1;
    //   90: getfield 57	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1:jdField_a_of_type_ComTencentMobileqqAppQBaseActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   93: invokevirtual 67	com/tencent/mobileqq/app/QBaseActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   96: ldc 69
    //   98: ldc 71
    //   100: ldc 71
    //   102: ldc 80
    //   104: ldc 80
    //   106: iconst_0
    //   107: iconst_0
    //   108: ldc 71
    //   110: ldc 71
    //   112: ldc 71
    //   114: ldc 71
    //   116: invokestatic 78	com/tencent/mobileqq/statistics/ReportController:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   119: new 34	android/content/Intent
    //   122: dup
    //   123: aload_0
    //   124: getfield 12	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1$1:a	Lcom/tencent/mobileqq/loginregister/CheckAuthLoginAction$1;
    //   127: getfield 57	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1:jdField_a_of_type_ComTencentMobileqqAppQBaseActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   130: ldc 82
    //   132: invokespecial 85	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   135: astore_2
    //   136: aload_2
    //   137: ldc 87
    //   139: aload_0
    //   140: getfield 12	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1$1:a	Lcom/tencent/mobileqq/loginregister/CheckAuthLoginAction$1;
    //   143: getfield 90	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1:b	Ljava/lang/String;
    //   146: invokevirtual 94	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   149: pop
    //   150: new 96	com/tencent/mobileqq/upgrade/AuthCodeWriter
    //   153: dup
    //   154: aload_0
    //   155: getfield 12	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1$1:a	Lcom/tencent/mobileqq/loginregister/CheckAuthLoginAction$1;
    //   158: getfield 99	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1:c	Ljava/lang/String;
    //   161: aconst_null
    //   162: invokespecial 102	com/tencent/mobileqq/upgrade/AuthCodeWriter:<init>	(Ljava/lang/String;Lcom/tencent/mobileqq/upgrade/AuthCodeWriter$ICheckCodeListener;)V
    //   165: invokestatic 107	com/tencent/open/downloadnew/DownloadApi:a	(Lcom/tencent/open/downloadnew/ApkWriteCodeListener;)Z
    //   168: pop
    //   169: aload_0
    //   170: getfield 12	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1$1:a	Lcom/tencent/mobileqq/loginregister/CheckAuthLoginAction$1;
    //   173: getfield 57	com/tencent/mobileqq/loginregister/CheckAuthLoginAction$1:jdField_a_of_type_ComTencentMobileqqAppQBaseActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   176: aload_2
    //   177: invokevirtual 63	com/tencent/mobileqq/app/QBaseActivity:startActivity	(Landroid/content/Intent;)V
    //   180: return
    //   181: astore_2
    //   182: iconst_0
    //   183: istore_1
    //   184: goto -102 -> 82
    //   187: astore_2
    //   188: iconst_1
    //   189: istore_1
    //   190: goto -6 -> 184
    //   193: iconst_0
    //   194: istore_1
    //   195: goto -113 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	1
    //   48	147	1	i	int
    //   20	157	2	localIntent	android.content.Intent
    //   181	1	2	localException1	java.lang.Exception
    //   187	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   36	47	181	java/lang/Exception
    //   49	82	187	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.CheckAuthLoginAction.1.1
 * JD-Core Version:    0.7.0.1
 */