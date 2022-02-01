import android.annotation.SuppressLint;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.2;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class nho
{
  private volatile WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentHashMap<String, nhr> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public nho(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      synchronized (this.jdField_a_of_type_JavaLangRefWeakReference)
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        return localQQAppInterface;
      }
    }
    return null;
  }
  
  @SuppressLint({"HandlerLeak"})
  private TransProcessorHandler a()
  {
    return new nhp(this, ThreadManagerV2.getFileThreadLooper());
  }
  
  private String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    TransFileController localTransFileController = paramQQAppInterface.getTransFileController();
    Object localObject = a();
    localTransFileController.addHandle((TransProcessorHandler)localObject);
    ((TransProcessorHandler)localObject).addFilter(new Class[] { BDHCommonUploadProcessor.class });
    localObject = new TransferRequest();
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mCommandId = 78;
    ((TransferRequest)localObject).mLocalPath = paramString2;
    ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000000.0D));
    ((TransferRequest)localObject).mPeerUin = ("" + paramInt);
    ((TransferRequest)localObject).mSelfUin = paramQQAppInterface.getCurrentUin();
    ((TransferRequest)localObject).mFileType = 24;
    ((TransferRequest)localObject).extraObject = paramString1;
    paramQQAppInterface = new Bdh_extinfo.CommFileExtReq();
    paramQQAppInterface.uint32_action_type.set(0);
    paramQQAppInterface.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
    ((TransferRequest)localObject).mExtentionInfo = paramQQAppInterface.toByteArray();
    localTransFileController.transferAsync((TransferRequest)localObject);
    return paramString1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      synchronized (this.jdField_a_of_type_JavaLangRefWeakReference)
      {
        this.jdField_a_of_type_JavaLangRefWeakReference.clear();
        return;
      }
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	nho:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 193	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +31 -> 41
    //   13: ldc 195
    //   15: iconst_1
    //   16: new 105	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   23: aload_1
    //   24: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 197
    //   29: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 203	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: new 205	com/tencent/avgame/gameresult/GameResultUploadMgrForRemote$3
    //   44: dup
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 19	nho:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   50: aload_1
    //   51: invokevirtual 208	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 210	nhr
    //   57: aload_1
    //   58: invokespecial 213	com/tencent/avgame/gameresult/GameResultUploadMgrForRemote$3:<init>	(Lnho;Lnhr;Ljava/lang/String;)V
    //   61: bipush 16
    //   63: aconst_null
    //   64: iconst_0
    //   65: invokestatic 217	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   68: goto -30 -> 38
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	nho
    //   0	76	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	38	71	finally
    //   41	68	71	finally
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 195
    //   4: iconst_1
    //   5: new 105	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 220
    //   18: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_0
    //   28: getfield 19	nho:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   31: astore_3
    //   32: aload_3
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 19	nho:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   38: aload_1
    //   39: invokevirtual 193	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   42: ifne +8 -> 50
    //   45: aload_3
    //   46: monitorexit
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 19	nho:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   54: aload_1
    //   55: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: aload_3
    //   60: monitorexit
    //   61: goto -14 -> 47
    //   64: astore_1
    //   65: aload_3
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	nho
    //   0	74	1	paramString	String
    //   0	74	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   34	47	64	finally
    //   50	61	64	finally
    //   65	67	64	finally
    //   2	34	69	finally
    //   67	69	69	finally
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      nhr localnhr;
      try
      {
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1);
        if (!bool) {
          return;
        }
        localnhr = (nhr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
        localnhr.jdField_a_of_type_Nhq.a(paramString1, paramInt, paramString2);
        if (paramInt == 0)
        {
          localnhr.jdField_a_of_type_Boolean = false;
          continue;
        }
        if (paramInt != 1) {
          continue;
        }
      }
      finally {}
      localnhr.jdField_b_of_type_Boolean = false;
      if (localnhr.c) {
        b(paramString1);
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, nhq paramnhq)
  {
    try
    {
      if (QLog.isDebugVersion()) {
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, "recv avgame upload request playId:" + paramString1);
      }
      nhr localnhr = new nhr(this, null);
      localnhr.jdField_a_of_type_JavaLangString = paramString2;
      localnhr.jdField_b_of_type_JavaLangString = paramString3;
      localnhr.jdField_a_of_type_Nhq = paramnhq;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localnhr);
      ThreadManagerV2.excute(new GameResultUploadMgrForRemote.2(this, paramString2, localnhr, paramQQAppInterface, paramString1), 16, null, false);
      return true;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
        if (!bool) {
          return;
        }
        localObject = (nhr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if ((((nhr)localObject).jdField_b_of_type_Boolean) || (((nhr)localObject).jdField_a_of_type_Boolean))
        {
          ((nhr)localObject).c = true;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("GameResultUploadMgrForRemote_GameRC", 1, String.format("视频正在上传[%b], 图片正在上传[%b],需要延迟清理", new Object[] { Boolean.valueOf(((nhr)localObject).jdField_b_of_type_Boolean), Boolean.valueOf(((nhr)localObject).jdField_a_of_type_Boolean) }));
          continue;
        }
        str = ((nhr)localObject).jdField_a_of_type_JavaLangString;
      }
      finally {}
      String str;
      Object localObject = ((nhr)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (QLog.isDevelopLevel()) {
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, String.format("清理资源[%s]", new Object[] { paramString }));
      }
      ThreadManagerV2.excute(new GameResultUploadMgrForRemote.4(this, str, (String)localObject), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nho
 * JD-Core Version:    0.7.0.1
 */