package com.tencent.mobileqq.phonecontact.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ReportUtil
{
  /* Error */
  private static int a(AppInterface paramAppInterface, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 19	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4: invokevirtual 25	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 5
    //   20: astore_0
    //   21: getstatic 31	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   24: astore 7
    //   26: iconst_0
    //   27: istore_2
    //   28: aload 4
    //   30: astore_3
    //   31: aload 5
    //   33: astore_0
    //   34: iload_1
    //   35: invokestatic 37	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   38: astore 8
    //   40: aload 4
    //   42: astore_3
    //   43: aload 5
    //   45: astore_0
    //   46: aload 6
    //   48: aload 7
    //   50: iconst_1
    //   51: anewarray 39	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc 41
    //   58: aastore
    //   59: ldc 43
    //   61: iconst_1
    //   62: anewarray 39	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: aload 8
    //   69: aastore
    //   70: aconst_null
    //   71: invokevirtual 49	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore 4
    //   76: iload_2
    //   77: istore_1
    //   78: aload 4
    //   80: ifnull +17 -> 97
    //   83: aload 4
    //   85: astore_3
    //   86: aload 4
    //   88: astore_0
    //   89: aload 4
    //   91: invokeinterface 55 1 0
    //   96: istore_1
    //   97: iload_1
    //   98: istore_2
    //   99: aload 4
    //   101: ifnull +51 -> 152
    //   104: aload 4
    //   106: astore_0
    //   107: aload_0
    //   108: invokeinterface 58 1 0
    //   113: iload_1
    //   114: ireturn
    //   115: astore_0
    //   116: goto +38 -> 154
    //   119: astore 4
    //   121: iconst_m1
    //   122: istore_1
    //   123: aload_0
    //   124: astore_3
    //   125: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +15 -> 143
    //   131: aload_0
    //   132: astore_3
    //   133: ldc 66
    //   135: iconst_2
    //   136: ldc 68
    //   138: aload 4
    //   140: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   143: iload_1
    //   144: istore_2
    //   145: aload_0
    //   146: ifnull +6 -> 152
    //   149: goto -42 -> 107
    //   152: iload_2
    //   153: ireturn
    //   154: aload_3
    //   155: ifnull +9 -> 164
    //   158: aload_3
    //   159: invokeinterface 58 1 0
    //   164: goto +5 -> 169
    //   167: aload_0
    //   168: athrow
    //   169: goto -2 -> 167
    //   172: astore_0
    //   173: iload_1
    //   174: ireturn
    //   175: astore_3
    //   176: goto -12 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramAppInterface	AppInterface
    //   0	179	1	paramInt	int
    //   27	126	2	i	int
    //   17	142	3	localObject1	Object
    //   175	1	3	localThrowable1	java.lang.Throwable
    //   13	92	4	localCursor	android.database.Cursor
    //   119	20	4	localThrowable2	java.lang.Throwable
    //   10	34	5	localObject2	Object
    //   7	40	6	localContentResolver	android.content.ContentResolver
    //   24	25	7	localUri	android.net.Uri
    //   38	30	8	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   21	26	115	finally
    //   34	40	115	finally
    //   46	76	115	finally
    //   89	97	115	finally
    //   125	131	115	finally
    //   133	143	115	finally
    //   21	26	119	java/lang/Throwable
    //   34	40	119	java/lang/Throwable
    //   46	76	119	java/lang/Throwable
    //   89	97	119	java/lang/Throwable
    //   107	113	172	java/lang/Throwable
    //   158	164	175	java/lang/Throwable
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i;
    if (paramInt6 >= 3) {
      if (paramInt2 == 0) {
        i = 11;
      } else if (paramInt3 == 0) {
        i = 12;
      } else {
        i = 13;
      }
    }
    for (;;)
    {
      break;
      if (paramInt4 >= 100)
      {
        if (paramInt2 == 0) {
          i = 21;
        } else if (paramInt3 == 0) {
          i = 22;
        } else {
          i = 23;
        }
      }
      else {
        i = 0;
      }
    }
    if (i == 0) {
      return;
    }
    ThreadManager.post(new ReportUtil.1(paramInt1, i, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7), 5, null, false);
  }
  
  public static boolean a(AppInterface paramAppInterface, int paramInt)
  {
    boolean bool = false;
    if (paramAppInterface == null) {
      return false;
    }
    int i = a(paramAppInterface, paramInt);
    QLog.d("actContactSyncExReport", 1, new Object[] { "isDangerousDel contactId=", Integer.valueOf(paramInt), " rawContactCnt=", Integer.valueOf(i) });
    if (i <= 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.ReportUtil
 * JD-Core Version:    0.7.0.1
 */