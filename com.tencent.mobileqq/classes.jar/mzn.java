import android.annotation.SuppressLint;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.2;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class mzn
{
  public QQAppInterface a;
  private ConcurrentHashMap<String, mzq> a;
  
  public mzn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  @SuppressLint({"HandlerLeak"})
  private bdzm a()
  {
    return new mzo(this, ThreadManagerV2.getFileThreadLooper());
  }
  
  private String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    bdzi localbdzi = paramQQAppInterface.a();
    Object localObject = a();
    localbdzi.a((bdzm)localObject);
    ((bdzm)localObject).addFilter(new Class[] { bdsp.class });
    localObject = new bdzn();
    ((bdzn)localObject).jdField_a_of_type_Boolean = true;
    ((bdzn)localObject).jdField_c_of_type_Int = 78;
    ((bdzn)localObject).i = paramString2;
    ((bdzn)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    ((bdzn)localObject).jdField_c_of_type_JavaLangString = ("" + paramInt);
    ((bdzn)localObject).jdField_b_of_type_JavaLangString = paramQQAppInterface.c();
    ((bdzn)localObject).jdField_b_of_type_Int = 24;
    ((bdzn)localObject).jdField_b_of_type_JavaLangObject = paramString1;
    paramQQAppInterface = new Bdh_extinfo.CommFileExtReq();
    paramQQAppInterface.uint32_action_type.set(0);
    paramQQAppInterface.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
    ((bdzn)localObject).jdField_a_of_type_ArrayOfByte = paramQQAppInterface.toByteArray();
    localbdzi.a((bdzn)localObject);
    return paramString1;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	mzn:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 166	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +31 -> 41
    //   13: ldc 168
    //   15: iconst_1
    //   16: new 87	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   23: aload_1
    //   24: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 170
    //   29: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 176	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: new 178	com/tencent/avgame/gameresult/GameResultUploadMgrForRemote$3
    //   44: dup
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 18	mzn:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   50: aload_1
    //   51: invokevirtual 182	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 184	mzq
    //   57: aload_1
    //   58: invokespecial 187	com/tencent/avgame/gameresult/GameResultUploadMgrForRemote$3:<init>	(Lmzn;Lmzq;Ljava/lang/String;)V
    //   61: bipush 16
    //   63: aconst_null
    //   64: iconst_0
    //   65: invokestatic 191	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   68: goto -30 -> 38
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	mzn
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
    //   2: ldc 168
    //   4: iconst_1
    //   5: new 87	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 194
    //   18: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_0
    //   28: getfield 18	mzn:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   31: astore_3
    //   32: aload_3
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 18	mzn:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   38: aload_1
    //   39: invokevirtual 166	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   42: ifne +8 -> 50
    //   45: aload_3
    //   46: monitorexit
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 18	mzn:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   54: aload_1
    //   55: invokevirtual 200	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
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
    //   0	74	0	this	mzn
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
      mzq localmzq;
      try
      {
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1);
        if (!bool) {
          return;
        }
        localmzq = (mzq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
        localmzq.jdField_a_of_type_Mzp.a(paramString1, paramInt, paramString2);
        if (paramInt == 0)
        {
          localmzq.jdField_a_of_type_Boolean = false;
          continue;
        }
        if (paramInt != 1) {
          continue;
        }
      }
      finally {}
      localmzq.jdField_b_of_type_Boolean = false;
      if (localmzq.c) {
        b(paramString1);
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, mzp parammzp)
  {
    try
    {
      if (QLog.isDebugVersion()) {
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, "recv avgame upload request playId:" + paramString1);
      }
      mzq localmzq = new mzq(this, null);
      localmzq.jdField_a_of_type_JavaLangString = paramString2;
      localmzq.jdField_b_of_type_JavaLangString = paramString3;
      localmzq.jdField_a_of_type_Mzp = parammzp;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localmzq);
      ThreadManagerV2.excute(new GameResultUploadMgrForRemote.2(this, localmzq, paramQQAppInterface, paramString1, paramString2), 16, null, false);
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
        localObject = (mzq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if ((((mzq)localObject).jdField_b_of_type_Boolean) || (((mzq)localObject).jdField_a_of_type_Boolean))
        {
          ((mzq)localObject).c = true;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("GameResultUploadMgrForRemote_GameRC", 1, String.format("视频正在上传[%b], 图片正在上传[%b],需要延迟清理", new Object[] { Boolean.valueOf(((mzq)localObject).jdField_b_of_type_Boolean), Boolean.valueOf(((mzq)localObject).jdField_a_of_type_Boolean) }));
          continue;
        }
        str = ((mzq)localObject).jdField_a_of_type_JavaLangString;
      }
      finally {}
      String str;
      Object localObject = ((mzq)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (QLog.isDevelopLevel()) {
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, String.format("清理资源[%s]", new Object[] { paramString }));
      }
      ThreadManagerV2.excute(new GameResultUploadMgrForRemote.4(this, str, (String)localObject), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzn
 * JD-Core Version:    0.7.0.1
 */