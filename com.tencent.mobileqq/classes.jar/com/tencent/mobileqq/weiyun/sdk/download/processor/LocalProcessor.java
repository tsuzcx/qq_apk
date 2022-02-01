package com.tencent.mobileqq.weiyun.sdk.download.processor;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.IOUtils;

public class LocalProcessor
  implements Handler.Callback
{
  private final LocalProcessor.LocalProcessorCallback jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor$LocalProcessorCallback;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public LocalProcessor(LocalProcessor.LocalProcessorCallback paramLocalProcessorCallback, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor$LocalProcessorCallback = paramLocalProcessorCallback;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 34	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   3: iconst_1
    //   4: invokevirtual 38	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: iconst_4
    //   17: invokestatic 44	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   20: astore_2
    //   21: new 46	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 49
    //   32: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: ldc 55
    //   39: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_3
    //   44: ldc 57
    //   46: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_3
    //   51: ldc 59
    //   53: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_3
    //   62: aload 4
    //   64: ldc 64
    //   66: iconst_1
    //   67: anewarray 66	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: ldc 68
    //   74: aastore
    //   75: aload_3
    //   76: iconst_2
    //   77: anewarray 66	java/lang/String
    //   80: dup
    //   81: iconst_0
    //   82: aload_1
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload_2
    //   87: aastore
    //   88: aconst_null
    //   89: aconst_null
    //   90: ldc 70
    //   92: invokevirtual 76	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +27 -> 124
    //   100: aload_3
    //   101: invokeinterface 82 1 0
    //   106: ifeq +18 -> 124
    //   109: aload_3
    //   110: iconst_0
    //   111: invokeinterface 85 2 0
    //   116: astore_2
    //   117: goto +9 -> 126
    //   120: astore_1
    //   121: goto +15 -> 136
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_3
    //   127: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   130: goto +20 -> 150
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_3
    //   137: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   140: aload_1
    //   141: athrow
    //   142: aconst_null
    //   143: astore_3
    //   144: aload_3
    //   145: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   148: aconst_null
    //   149: astore_2
    //   150: aload_2
    //   151: astore_3
    //   152: aload_2
    //   153: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +152 -> 308
    //   159: iconst_4
    //   160: invokestatic 44	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   163: astore_3
    //   164: new 46	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   171: astore 5
    //   173: aload 5
    //   175: ldc 99
    //   177: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 5
    //   183: ldc 55
    //   185: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: ldc 57
    //   193: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 5
    //   199: ldc 59
    //   201: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 5
    //   207: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore 5
    //   212: aload 4
    //   214: ldc 101
    //   216: iconst_1
    //   217: anewarray 66	java/lang/String
    //   220: dup
    //   221: iconst_0
    //   222: ldc 68
    //   224: aastore
    //   225: aload 5
    //   227: iconst_2
    //   228: anewarray 66	java/lang/String
    //   231: dup
    //   232: iconst_0
    //   233: aload_1
    //   234: aastore
    //   235: dup
    //   236: iconst_1
    //   237: aload_3
    //   238: aastore
    //   239: aconst_null
    //   240: aconst_null
    //   241: ldc 70
    //   243: invokevirtual 76	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   246: astore_3
    //   247: aload_2
    //   248: astore_1
    //   249: aload_3
    //   250: ifnull +32 -> 282
    //   253: aload_2
    //   254: astore_1
    //   255: aload_3
    //   256: invokeinterface 82 1 0
    //   261: ifeq +21 -> 282
    //   264: aload_3
    //   265: iconst_0
    //   266: invokeinterface 85 2 0
    //   271: astore_1
    //   272: goto +10 -> 282
    //   275: astore_1
    //   276: goto +18 -> 294
    //   279: goto +23 -> 302
    //   282: aload_3
    //   283: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   286: aload_1
    //   287: astore_3
    //   288: goto +20 -> 308
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_3
    //   294: aload_3
    //   295: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   298: aload_1
    //   299: athrow
    //   300: aconst_null
    //   301: astore_3
    //   302: aload_3
    //   303: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   306: aload_2
    //   307: astore_3
    //   308: invokestatic 34	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   311: aload 4
    //   313: invokevirtual 105	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   316: aload_3
    //   317: areturn
    //   318: astore_2
    //   319: goto -177 -> 142
    //   322: astore_2
    //   323: goto -181 -> 142
    //   326: astore_2
    //   327: goto -183 -> 144
    //   330: astore_1
    //   331: goto -31 -> 300
    //   334: astore_1
    //   335: goto -56 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	LocalProcessor
    //   0	338	1	paramString	String
    //   20	287	2	str	String
    //   318	1	2	localThrowable1	java.lang.Throwable
    //   322	1	2	localThrowable2	java.lang.Throwable
    //   326	1	2	localThrowable3	java.lang.Throwable
    //   28	289	3	localObject1	Object
    //   7	305	4	localJobDbWrapper	com.tencent.weiyun.transmission.db.JobDbWrapper
    //   171	55	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   100	117	120	finally
    //   16	62	133	finally
    //   62	96	133	finally
    //   255	272	275	finally
    //   159	247	291	finally
    //   16	62	318	java/lang/Throwable
    //   62	96	322	java/lang/Throwable
    //   100	117	326	java/lang/Throwable
    //   159	247	330	java/lang/Throwable
    //   255	272	334	java/lang/Throwable
  }
  
  private void b(DownloadJobContext paramDownloadJobContext)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    String str2 = paramDownloadJobContext.d();
    String str3 = paramDownloadJobContext.a().c;
    String str4 = paramDownloadJobContext.b();
    long l1 = paramDownloadJobContext.a().a;
    long l2 = paramDownloadJobContext.a().b;
    if (paramDownloadJobContext.d()) {
      return;
    }
    if ((!TextUtils.isEmpty(str2)) && (TextUtils.equals(str3, IOUtils.getFileSha1(str2))))
    {
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor$LocalProcessorCallback.a(paramDownloadJobContext.a(), true, false, false, str2);
      return;
    }
    if (paramDownloadJobContext.d()) {
      return;
    }
    if (!IOUtils.ensureStorageSpace(str4, l1 - l2))
    {
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor$LocalProcessorCallback.a(paramDownloadJobContext.a(), false, false, true, "");
      return;
    }
    if (paramDownloadJobContext.d()) {
      return;
    }
    if (!IOUtils.ensureWritable(str4))
    {
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor$LocalProcessorCallback.a(paramDownloadJobContext.a(), false, true, false, "");
      return;
    }
    if (paramDownloadJobContext.d()) {
      return;
    }
    Object localObject = IOUtils.ensureFilePath(str4, paramDownloadJobContext.a().b);
    if (paramDownloadJobContext.d()) {
      return;
    }
    String str1 = a(str3);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.equals(str2, str1)) && (TextUtils.equals(str3, IOUtils.getFileSha1(str1))))
    {
      boolean bool;
      if (TextUtils.equals(str4, IOUtils.getParentDir(str1)))
      {
        localObject = str1;
        bool = true;
      }
      else
      {
        bool = IOUtils.copyFileAndNotifyOS(WeiyunTransmissionGlobal.getInstance().getContext(), str1, (String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor$LocalProcessorCallback.a(paramDownloadJobContext.a(), bool, false, false, (String)localObject);
      return;
    }
    if (paramDownloadJobContext.d()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorLocalProcessor$LocalProcessorCallback.a(paramDownloadJobContext.a(), false, false, false, (String)localObject);
  }
  
  public void a(DownloadJobContext paramDownloadJobContext)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 11, paramDownloadJobContext));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 11)
    {
      b((DownloadJobContext)paramMessage.obj);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.LocalProcessor
 * JD-Core Version:    0.7.0.1
 */