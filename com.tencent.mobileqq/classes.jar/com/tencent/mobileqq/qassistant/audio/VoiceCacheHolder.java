package com.tencent.mobileqq.qassistant.audio;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.ConfirmSendInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.RecordParams;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class VoiceCacheHolder
{
  public static byte[] a;
  private volatile VoiceAssiatantRespInfo.ConfirmSendInfo jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private volatile List<VoiceBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong();
  private FileOutputStream jdField_b_of_type_JavaIoFileOutputStream;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = RecordParams.a(1, 16000);
  }
  
  public VoiceCacheHolder()
  {
    a();
  }
  
  private long a(@Nullable VoiceBean paramVoiceBean, long paramLong, int paramInt)
  {
    long l1 = 0L;
    long l2 = paramInt * 200;
    if (paramLong > 0L) {
      l1 = paramLong / 32L;
    }
    AssistantUtils.a("VoiceCacheHolder", "duration estimate, cnt:" + paramInt + "d1:" + l2 + ", d2:" + l1);
    return l1 + l2;
  }
  
  private VoiceBean a()
  {
    this.jdField_a_of_type_JavaLangString = AssistantUtils.a(String.valueOf(System.nanoTime()), "slk");
    a(this.jdField_a_of_type_JavaIoFileOutputStream, null, true);
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
    AssistantUtils.a("VoiceCacheHolder", "write slk pth(normal): " + this.jdField_a_of_type_JavaLangString);
    a(this.jdField_a_of_type_JavaIoFileOutputStream, jdField_a_of_type_ArrayOfByte, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (VoiceBean)localIterator.next();
      if (!((VoiceBean)localObject2).c()) {
        break label201;
      }
      a(this.jdField_a_of_type_JavaIoFileOutputStream, ((VoiceBean)localObject2).jdField_a_of_type_ArrayOfByte, false);
      localObject1 = localObject2;
      i += 1;
    }
    label201:
    for (;;)
    {
      break;
      a(this.jdField_a_of_type_JavaIoFileOutputStream, null, true);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(a(localObject1, 0L, i));
      if (localObject1 != null)
      {
        localObject2 = AssistantUtils.a(AssistantUtils.b(localObject1.jdField_a_of_type_JavaLangString), "slk");
        FileUtils.c(this.jdField_a_of_type_JavaLangString, (String)localObject2);
        this.jdField_a_of_type_JavaLangString = ((String)localObject2);
      }
      return localObject1;
    }
  }
  
  private VoiceBean a(VoiceBeanProcessor paramVoiceBeanProcessor)
  {
    this.jdField_a_of_type_JavaLangString = AssistantUtils.a(String.valueOf(System.nanoTime()), "slk");
    a(this.jdField_a_of_type_JavaIoFileOutputStream, null, true);
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
    AssistantUtils.a("VoiceCacheHolder", "write slk pth(divide): " + this.jdField_a_of_type_JavaLangString);
    a(this.jdField_a_of_type_JavaIoFileOutputStream, jdField_a_of_type_ArrayOfByte, false);
    long l4 = this.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo.jdField_a_of_type_Long * 32L;
    long l1 = 0L;
    long l3 = 0L;
    String str = AssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo.jdField_a_of_type_JavaLangString);
    AssistantUtils.a("VoiceCacheHolder", this.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo.a() + ", locateOff:" + l4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    VoiceBean localVoiceBean;
    if (localIterator.hasNext())
    {
      localVoiceBean = (VoiceBean)localIterator.next();
      l2 = l1;
      if (localVoiceBean.jdField_a_of_type_JavaLangString.equals(str))
      {
        AssistantUtils.a("VoiceCacheHolder", "divide bean: " + localVoiceBean.a());
        if ((l4 < l1) || (l4 > localVoiceBean.b + l1)) {}
      }
    }
    for (long l2 = l4 - l1;; l2 = l3)
    {
      AssistantUtils.a("VoiceCacheHolder", "divide curOff:" + l1 + ", remains:" + l2);
      if ((localVoiceBean != null) && (l2 > 0L))
      {
        paramVoiceBeanProcessor = a(paramVoiceBeanProcessor, localVoiceBean.jdField_a_of_type_Long, l2);
        a(this.jdField_a_of_type_JavaIoFileOutputStream, paramVoiceBeanProcessor, false);
      }
      a(this.jdField_a_of_type_JavaIoFileOutputStream, null, true);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(a(localVoiceBean, l2, i));
      if (localVoiceBean != null)
      {
        paramVoiceBeanProcessor = AssistantUtils.a(AssistantUtils.b(localVoiceBean.jdField_a_of_type_JavaLangString), "slk");
        FileUtils.c(this.jdField_a_of_type_JavaLangString, paramVoiceBeanProcessor);
        this.jdField_a_of_type_JavaLangString = paramVoiceBeanProcessor;
      }
      return localVoiceBean;
      l2 = l1 + localVoiceBean.b;
      if (localVoiceBean.c())
      {
        a(this.jdField_a_of_type_JavaIoFileOutputStream, localVoiceBean.jdField_a_of_type_ArrayOfByte, false);
        i += 1;
      }
      for (;;)
      {
        l1 = l2;
        break;
      }
      localVoiceBean = null;
    }
  }
  
  private void a(VoiceBean paramVoiceBean)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() < 2)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      a();
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_JavaUtilList.add(i - 1, paramVoiceBean);
  }
  
  private void a(FileOutputStream paramFileOutputStream, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramFileOutputStream == null) || (paramArrayOfByte != null)) {}
    try
    {
      paramFileOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramFileOutputStream.flush();
      if (paramBoolean) {
        paramFileOutputStream.close();
      }
      return;
    }
    catch (IOException paramFileOutputStream)
    {
      paramFileOutputStream.printStackTrace();
    }
  }
  
  private byte[] a(VoiceBeanProcessor paramVoiceBeanProcessor, long paramLong1, long paramLong2)
  {
    if ((paramVoiceBeanProcessor == null) || (paramLong1 <= 0L) || (paramLong2 <= 0L)) {
      return null;
    }
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.jdField_b_of_type_JavaLangString, "rw");
      localRandomAccessFile.seek(paramLong1);
      byte[] arrayOfByte = new byte[(int)paramLong2];
      localRandomAccessFile.read(arrayOfByte, 0, arrayOfByte.length);
      paramVoiceBeanProcessor = paramVoiceBeanProcessor.a(arrayOfByte);
      localRandomAccessFile.close();
      paramVoiceBeanProcessor = paramVoiceBeanProcessor.jdField_a_of_type_ArrayOfByte;
      return paramVoiceBeanProcessor;
    }
    catch (FileNotFoundException paramVoiceBeanProcessor)
    {
      paramVoiceBeanProcessor.printStackTrace();
      return null;
    }
    catch (IOException paramVoiceBeanProcessor)
    {
      paramVoiceBeanProcessor.printStackTrace();
    }
    return null;
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder("\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((VoiceBean)localIterator.next()).a()).append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private void b(int paramInt, VoiceBeanProcessor paramVoiceBeanProcessor)
  {
    VoiceTimeTraceUtil.a().b();
    a(this.jdField_b_of_type_JavaIoFileOutputStream, null, true);
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo == null)
    {
      paramVoiceBeanProcessor = a();
      VoiceTimeTraceUtil.a().a("SLK", this.jdField_a_of_type_JavaLangString);
      if (paramVoiceBeanProcessor == null) {
        break label177;
      }
    }
    label177:
    for (paramVoiceBeanProcessor = AssistantUtils.b(paramVoiceBeanProcessor.jdField_a_of_type_JavaLangString);; paramVoiceBeanProcessor = "")
    {
      if (!TextUtils.isEmpty(paramVoiceBeanProcessor))
      {
        String str = AssistantUtils.a(paramVoiceBeanProcessor, "pcm");
        FileUtils.c(this.jdField_b_of_type_JavaLangString, str);
        this.jdField_b_of_type_JavaLangString = str;
      }
      VoiceTimeTraceUtil.a().a("BUF", paramVoiceBeanProcessor, b());
      VoiceTimeTraceUtil.a().a("PCM", this.jdField_b_of_type_JavaLangString);
      VoiceTimeTraceUtil.a().a();
      AssistantUtils.a("VoiceCacheHolder", "clear cache buffer, final size: " + this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_JavaUtilList.clear();
      VoiceTimeTraceUtil.a().c();
      a(null);
      return;
      paramVoiceBeanProcessor = a(paramVoiceBeanProcessor);
      break;
    }
  }
  
  public int a()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long a()
  {
    try
    {
      long l = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public VoiceBean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt +34 -> 37
    //   6: iload_1
    //   7: aload_0
    //   8: getfield 36	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   11: invokeinterface 181 1 0
    //   16: if_icmpge +21 -> 37
    //   19: aload_0
    //   20: getfield 36	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   23: iload_1
    //   24: invokeinterface 284 2 0
    //   29: checkcast 123	com/tencent/mobileqq/qassistant/audio/VoiceBean
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: aconst_null
    //   38: astore_2
    //   39: goto -6 -> 33
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	VoiceCacheHolder
    //   0	47	1	paramInt	int
    //   32	7	2	localVoiceBean	VoiceBean
    //   42	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	33	42	finally
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +11 -> 20
    //   12: ldc_w 277
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 93	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	VoiceCacheHolder
    //   15	10	1	str	String
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 44
    //   4: ldc_w 286
    //   7: invokestatic 72	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: invokestatic 287	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	()Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: getfield 36	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   18: iconst_0
    //   19: new 123	com/tencent/mobileqq/qassistant/audio/VoiceBean
    //   22: dup
    //   23: aconst_null
    //   24: aload_1
    //   25: invokespecial 290	com/tencent/mobileqq/qassistant/audio/VoiceBean:<init>	([BLjava/lang/String;)V
    //   28: invokeinterface 188 3 0
    //   33: aload_0
    //   34: getfield 36	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   37: new 123	com/tencent/mobileqq/qassistant/audio/VoiceBean
    //   40: dup
    //   41: aconst_null
    //   42: aload_1
    //   43: invokespecial 290	com/tencent/mobileqq/qassistant/audio/VoiceBean:<init>	([BLjava/lang/String;)V
    //   46: invokeinterface 292 2 0
    //   51: pop
    //   52: aload_0
    //   53: getfield 31	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   56: lconst_0
    //   57: invokevirtual 133	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   60: aload_0
    //   61: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   64: invokestatic 86	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   67: ldc_w 256
    //   70: invokestatic 91	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: putfield 209	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   76: ldc 44
    //   78: new 46	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 297
    //   88: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 209	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   95: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 72	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 243	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_b_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   109: aconst_null
    //   110: iconst_1
    //   111: invokespecial 98	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:a	(Ljava/io/FileOutputStream;[BZ)V
    //   114: aload_0
    //   115: new 100	java/io/FileOutputStream
    //   118: dup
    //   119: aload_0
    //   120: getfield 209	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   123: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   126: putfield 243	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:jdField_b_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   129: aload_0
    //   130: monitorexit
    //   131: return
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 230	java/io/FileNotFoundException:printStackTrace	()V
    //   137: goto -8 -> 129
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	VoiceCacheHolder
    //   13	30	1	str	String
    //   132	2	1	localFileNotFoundException	FileNotFoundException
    //   140	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   60	129	132	java/io/FileNotFoundException
    //   2	60	140	finally
    //   60	129	140	finally
    //   133	137	140	finally
  }
  
  public void a(int paramInt, VoiceBeanProcessor paramVoiceBeanProcessor)
  {
    try
    {
      b(paramInt, paramVoiceBeanProcessor);
      return;
    }
    catch (FileNotFoundException paramVoiceBeanProcessor)
    {
      for (;;)
      {
        paramVoiceBeanProcessor.printStackTrace();
      }
    }
    finally {}
  }
  
  public void a(@Nullable VoiceAssiatantRespInfo.ConfirmSendInfo paramConfirmSendInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo = paramConfirmSendInfo;
  }
  
  public void a(byte[] paramArrayOfByte, VoiceBean paramVoiceBean)
  {
    if (paramVoiceBean != null) {}
    try
    {
      a(paramVoiceBean);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        a(this.jdField_b_of_type_JavaIoFileOutputStream, paramArrayOfByte, false);
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilList.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceCacheHolder
 * JD-Core Version:    0.7.0.1
 */