package com.tencent.mobileqq.ocr;

import alet;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import atzt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import java.util.HashMap;

public class TranslateController
{
  private alet jdField_a_of_type_Alet;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private atzt jdField_a_of_type_Atzt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HashMap<String, TranslateController.ImageTranslateTask> jdField_a_of_type_JavaUtilHashMap;
  
  public TranslateController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Alet = new alet(paramQQAppInterface);
    this.jdField_a_of_type_Alet.a();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("TranslateFileUpload_" + System.currentTimeMillis());
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Atzt = ((atzt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(113));
  }
  
  private void a(boolean paramBoolean, String paramString, TranslateResult arg3)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_Atzt == null) {
      return;
    }
    if (??? != null) {
      ???.c = paramString;
    }
    this.jdField_a_of_type_Atzt.notifyUI(2, paramBoolean, new Object[] { Integer.valueOf(2), ??? });
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_Alet != null)
    {
      this.jdField_a_of_type_Alet.a();
      this.jdField_a_of_type_Alet.b();
      this.jdField_a_of_type_Alet = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_Atzt != null) {
      this.jdField_a_of_type_Atzt.a(paramString1, paramString2, paramString3);
    }
  }
  
  /* Error */
  public void a(String paramString1, String arg2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/tencent/mobileqq/ocr/TranslateController:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 141	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +21 -> 31
    //   13: ldc 143
    //   15: iconst_1
    //   16: ldc 145
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 151	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   25: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +38 -> 72
    //   37: ldc 143
    //   39: iconst_2
    //   40: ldc 162
    //   42: iconst_4
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_2
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: aload_3
    //   57: aastore
    //   58: dup
    //   59: iconst_3
    //   60: iload 4
    //   62: invokestatic 167	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   65: aastore
    //   66: invokestatic 151	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   69: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: new 169	com/tencent/mobileqq/ocr/TranslateController$ImageTranslateTask
    //   75: dup
    //   76: aload_0
    //   77: aload_1
    //   78: aload_2
    //   79: aload_3
    //   80: iload 4
    //   82: invokespecial 172	com/tencent/mobileqq/ocr/TranslateController$ImageTranslateTask:<init>	(Lcom/tencent/mobileqq/ocr/TranslateController;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   85: astore_3
    //   86: aload_0
    //   87: getfield 76	com/tencent/mobileqq/ocr/TranslateController:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   90: astore_2
    //   91: aload_2
    //   92: monitorenter
    //   93: aload_0
    //   94: getfield 76	com/tencent/mobileqq/ocr/TranslateController:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   97: aload_1
    //   98: aload_3
    //   99: invokevirtual 176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: aload_2
    //   104: monitorexit
    //   105: aload_0
    //   106: getfield 71	com/tencent/mobileqq/ocr/TranslateController:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   109: aload_3
    //   110: invokevirtual 180	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   113: pop
    //   114: goto -86 -> 28
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_2
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	TranslateController
    //   0	127	1	paramString1	String
    //   0	127	3	paramString3	String
    //   0	127	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	28	117	finally
    //   31	72	117	finally
    //   72	93	117	finally
    //   105	114	117	finally
    //   125	127	117	finally
    //   93	105	122	finally
    //   123	125	122	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateController
 * JD-Core Version:    0.7.0.1
 */