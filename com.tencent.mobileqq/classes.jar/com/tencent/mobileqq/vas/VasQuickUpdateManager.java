package com.tencent.mobileqq.vas;

import ajtx;
import ajty;
import ajtz;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;

public class VasQuickUpdateManager
  implements Manager
{
  public static final String a;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  public QQAppInterface a;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new ajtx(this);
  private VasQuickUpdateEngine.QuickUpdateBusinessCallback jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine$QuickUpdateBusinessCallback = new ajty(this);
  private VasQuickUpdateEngine.QuickUpdateListener jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine$QuickUpdateListener = new ajtz(this);
  public VasQuickUpdateEngine a;
  public AtomicBoolean a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + ".vas_quickupdate_test/";
  }
  
  public VasQuickUpdateManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
  }
  
  public static File a(AppRuntime paramAppRuntime, long paramLong, String paramString1, String paramString2, boolean paramBoolean, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (paramAppRuntime != null) {
        str = paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString1;
      }
    }
    if (TextUtils.isEmpty(str))
    {
      QLog.e("VasQuickUpdateManager", 1, "getFileFromLocal err filePath, bid=" + paramLong + ",scid:" + paramString1 + ", app=" + paramAppRuntime + ", filePaht=" + str);
      return null;
    }
    File localFile = new File(str);
    paramString2 = localFile;
    if (!localFile.exists())
    {
      if (!paramBoolean) {
        break label404;
      }
      if (paramAppRuntime == null) {
        break label238;
      }
      paramString2 = paramAppRuntime.getManager(183);
      if ((paramString2 != null) && ((paramString2 instanceof VasQuickUpdateManager))) {
        break label244;
      }
      QLog.e("VasQuickUpdateManager", 1, "getFileFromLocal, Err0, bid=" + paramLong + ",scid:" + paramString1 + ", mgr:" + paramString2 + ", app=" + paramAppRuntime + ", filePaht=" + str);
      paramString2 = null;
    }
    for (;;)
    {
      return paramString2;
      label238:
      paramString2 = null;
      break;
      label244:
      paramString2 = (VasQuickUpdateManager)paramString2;
      if (!paramString2.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        paramString2.a();
      }
      paramString2.a(paramCallBacker);
      if (3L == paramLong)
      {
        paramString2.a(paramLong, paramString1, "getFileFromLocal_theme");
        paramString2 = null;
      }
      else if (16L == paramLong)
      {
        paramAppRuntime = "getFileFromLocal_redPacket";
        if (("iRedPacket_v3.json".equals(paramString1)) || ("iRedPacket_v3.char300.json".equals(paramString1)) || ("iRedPacket_v3.font.zip".equals(paramString1)) || ("iRedPacket_v3.specialChar.zip".equals(paramString1))) {
          paramAppRuntime = "silent_download.redbag" + paramString1;
        }
        paramString2.a(paramLong, paramString1, paramAppRuntime);
        paramString2 = null;
      }
      else
      {
        paramString2.a(paramLong, paramString1, "getFileFromLocal_" + paramLong);
        label404:
        paramString2 = null;
      }
    }
  }
  
  public static JSONObject a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocal, app == null; scid:" + paramString + ", app=" + paramAppRuntime);
      return null;
    }
    Object localObject = new File(paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString);
    if (((File)localObject).exists()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(FileUtils.a((File)localObject));
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasQuickUpdateManager", 2, "getJsonOOM,json_name:" + paramString, localThrowable);
        }
        ((File)localObject).delete();
      }
    }
    if (paramBoolean)
    {
      localObject = paramAppRuntime.getManager(183);
      if ((localObject == null) || (!(localObject instanceof VasQuickUpdateManager)))
      {
        QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocal, manager == null; scid:" + paramString + ", mgr:" + localObject + ", app=" + paramAppRuntime);
        return null;
      }
      paramAppRuntime = (VasQuickUpdateManager)localObject;
      if (!paramAppRuntime.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        paramAppRuntime.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "getJSONFromLocal addCallBacker:" + paramString);
      }
      paramAppRuntime.a(paramCallBacker);
      paramAppRuntime.a(1000L, paramString, "getJSONFromLocal");
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    try
    {
      paramString = new File(BaseApplicationImpl.getApplication().getFilesDir() + File.separator + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void b()
  {
    try
    {
      a("VASBiz_FuncDev_webview.json");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine = VasQuickUpdateEngine.getInstance();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mUpdateManagerInstance != 0L) && (this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.hasRegistered.get())) {
        this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.nativeupdateAllItem(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mUpdateManagerInstance);
      }
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mDefaultCallback = this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine$QuickUpdateBusinessCallback;
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mDefaultListener = this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine$QuickUpdateListener;
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mExtensionHandler = ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71));
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "cancelDwonloadItem bid = " + paramLong + " scid = " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.cancelDwonloadItem(paramLong, paramString);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.downloadItem(paramLong, paramString1, paramString2);
    }
  }
  
  /* Error */
  public void a(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +53 -> 59
    //   9: ldc 113
    //   11: iconst_2
    //   12: new 20	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 281
    //   22: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_1
    //   26: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc_w 283
    //   32: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 4
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 285
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_3
    //   47: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: getfield 287	com/tencent/mobileqq/vas/VasQuickUpdateManager:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   63: ifnull -7 -> 56
    //   66: aload_0
    //   67: getfield 287	com/tencent/mobileqq/vas/VasQuickUpdateManager:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   70: invokevirtual 293	android/util/SparseArray:clone	()Landroid/util/SparseArray;
    //   73: astore 12
    //   75: aload 12
    //   77: invokevirtual 297	android/util/SparseArray:size	()I
    //   80: istore 10
    //   82: iconst_0
    //   83: istore 9
    //   85: iload 9
    //   87: iload 10
    //   89: if_icmpge -33 -> 56
    //   92: aload 12
    //   94: iload 9
    //   96: invokevirtual 301	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   99: astore 11
    //   101: aload 11
    //   103: instanceof 303
    //   106: ifeq +37 -> 143
    //   109: aload 11
    //   111: checkcast 303	com/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker
    //   114: astore 11
    //   116: aload 11
    //   118: ifnull +16 -> 134
    //   121: aload 11
    //   123: lload_1
    //   124: aload_3
    //   125: aload 4
    //   127: lload 5
    //   129: lload 7
    //   131: invokevirtual 306	com/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker:onProgress	(JLjava/lang/String;Ljava/lang/String;JJ)V
    //   134: iload 9
    //   136: iconst_1
    //   137: iadd
    //   138: istore 9
    //   140: goto -55 -> 85
    //   143: aconst_null
    //   144: astore 11
    //   146: goto -30 -> 116
    //   149: astore_3
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_3
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	VasQuickUpdateManager
    //   0	154	1	paramLong1	long
    //   0	154	3	paramString1	String
    //   0	154	4	paramString2	String
    //   0	154	5	paramLong2	long
    //   0	154	7	paramLong3	long
    //   83	56	9	i	int
    //   80	10	10	j	int
    //   99	46	11	localObject	Object
    //   73	20	12	localSparseArray	SparseArray
    // Exception table:
    //   from	to	target	type
    //   2	56	149	finally
    //   59	82	149	finally
    //   92	116	149	finally
    //   121	134	149	finally
  }
  
  /* Error */
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +75 -> 81
    //   9: ldc 113
    //   11: iconst_2
    //   12: new 20	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 281
    //   22: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_1
    //   26: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc_w 283
    //   32: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 4
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 285
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_3
    //   47: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 309
    //   53: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 5
    //   58: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 311
    //   64: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload 6
    //   69: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: aload_0
    //   82: getfield 287	com/tencent/mobileqq/vas/VasQuickUpdateManager:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   85: ifnull -7 -> 78
    //   88: aload_0
    //   89: getfield 287	com/tencent/mobileqq/vas/VasQuickUpdateManager:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   92: invokevirtual 293	android/util/SparseArray:clone	()Landroid/util/SparseArray;
    //   95: astore 11
    //   97: aload 11
    //   99: invokevirtual 297	android/util/SparseArray:size	()I
    //   102: istore 9
    //   104: iconst_0
    //   105: istore 8
    //   107: iload 8
    //   109: iload 9
    //   111: if_icmpge -33 -> 78
    //   114: aload 11
    //   116: iload 8
    //   118: invokevirtual 301	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   121: astore 10
    //   123: aload 10
    //   125: instanceof 303
    //   128: ifeq +40 -> 168
    //   131: aload 10
    //   133: checkcast 303	com/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker
    //   136: astore 10
    //   138: aload 10
    //   140: ifnull +19 -> 159
    //   143: aload 10
    //   145: lload_1
    //   146: aload_3
    //   147: aload 4
    //   149: aload 5
    //   151: iload 6
    //   153: iload 7
    //   155: aload_0
    //   156: invokevirtual 318	com/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker:callback	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mobileqq/vas/VasQuickUpdateManager;)V
    //   159: iload 8
    //   161: iconst_1
    //   162: iadd
    //   163: istore 8
    //   165: goto -58 -> 107
    //   168: aconst_null
    //   169: astore 10
    //   171: goto -33 -> 138
    //   174: astore_3
    //   175: aload_0
    //   176: monitorexit
    //   177: aload_3
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	VasQuickUpdateManager
    //   0	179	1	paramLong	long
    //   0	179	3	paramString1	String
    //   0	179	4	paramString2	String
    //   0	179	5	paramString3	String
    //   0	179	6	paramInt1	int
    //   0	179	7	paramInt2	int
    //   105	59	8	i	int
    //   102	10	9	j	int
    //   121	49	10	localObject	Object
    //   95	20	11	localSparseArray	SparseArray
    // Exception table:
    //   from	to	target	type
    //   2	78	174	finally
    //   81	104	174	finally
    //   114	138	174	finally
    //   143	159	174	finally
  }
  
  public void a(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "downloadGatherItem bid = " + paramLong + " scid = " + paramString1 + " scidList = " + TextUtils.join(",", paramArrayOfString) + " from = " + paramString2);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "downloadGatherItem engine not ready, initEngine");
      }
      a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.downloadGatherItem(paramLong, paramString1, paramArrayOfString, paramString2);
    }
  }
  
  public void a(VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    if (paramCallBacker == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
          this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfValue(paramCallBacker) >= 0) {
          continue;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1), paramCallBacker);
        paramCallBacker.key = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      }
      finally {}
    }
  }
  
  public void b(VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramCallBacker == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramCallBacker.key);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mExtensionHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mUpdateListenerList.clear();
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mBusinessCallbackList.clear();
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mDefaultCallback = null;
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateEngine.mDefaultListener = null;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager
 * JD-Core Version:    0.7.0.1
 */