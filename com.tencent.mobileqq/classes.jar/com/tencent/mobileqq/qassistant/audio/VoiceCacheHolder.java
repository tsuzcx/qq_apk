package com.tencent.mobileqq.qassistant.audio;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.data.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoiceBean;
import com.tencent.mobileqq.qassistant.data.VoiceEncodeResult;
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
  private volatile ConfirmSendInfo jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo;
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
    long l2 = paramInt * 200;
    long l1 = 0L;
    if (paramLong > 0L) {
      l1 = paramLong / 32L;
    }
    paramVoiceBean = new StringBuilder();
    paramVoiceBean.append("duration estimate, cnt:");
    paramVoiceBean.append(paramInt);
    paramVoiceBean.append("d1:");
    paramVoiceBean.append(l2);
    paramVoiceBean.append(", d2:");
    paramVoiceBean.append(l1);
    AssistantUtils.a("VoiceCacheHolder", paramVoiceBean.toString());
    return l2 + l1;
  }
  
  private VoiceBean a()
  {
    this.jdField_a_of_type_JavaLangString = AssistantUtils.a(String.valueOf(System.nanoTime()), "slk");
    a(this.jdField_a_of_type_JavaIoFileOutputStream, null, true);
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("write slk pth(normal): ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    AssistantUtils.a("VoiceCacheHolder", ((StringBuilder)localObject1).toString());
    a(this.jdField_a_of_type_JavaIoFileOutputStream, jdField_a_of_type_ArrayOfByte, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    localObject1 = null;
    int i = 0;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (VoiceBean)localIterator.next();
      if (((VoiceBean)localObject2).e())
      {
        a(this.jdField_a_of_type_JavaIoFileOutputStream, ((VoiceBean)localObject2).jdField_a_of_type_ArrayOfByte, false);
        i += 1;
        localObject1 = localObject2;
      }
    }
    a(this.jdField_a_of_type_JavaIoFileOutputStream, null, true);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(a((VoiceBean)localObject1, 0L, i));
    if (localObject1 != null)
    {
      localObject2 = AssistantUtils.a(AssistantUtils.b(((VoiceBean)localObject1).jdField_a_of_type_JavaLangString), "slk");
      FileUtils.rename(this.jdField_a_of_type_JavaLangString, (String)localObject2);
      this.jdField_a_of_type_JavaLangString = ((String)localObject2);
    }
    return localObject1;
  }
  
  private VoiceBean a(VoiceBeanProcessor paramVoiceBeanProcessor)
  {
    this.jdField_a_of_type_JavaLangString = AssistantUtils.a(String.valueOf(System.nanoTime()), "slk");
    a(this.jdField_a_of_type_JavaIoFileOutputStream, null, true);
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("write slk pth(divide): ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    AssistantUtils.a("VoiceCacheHolder", ((StringBuilder)localObject1).toString());
    a(this.jdField_a_of_type_JavaIoFileOutputStream, jdField_a_of_type_ArrayOfByte, false);
    long l3 = this.jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo.jdField_a_of_type_Long * 32L;
    Object localObject2 = AssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo.jdField_a_of_type_JavaLangString);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo.a());
    ((StringBuilder)localObject1).append(", locateOff:");
    ((StringBuilder)localObject1).append(l3);
    AssistantUtils.a("VoiceCacheHolder", ((StringBuilder)localObject1).toString());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    long l1 = 0L;
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localObject1 = (VoiceBean)localIterator.next();
      l2 = l1;
      if (((VoiceBean)localObject1).jdField_a_of_type_JavaLangString.equals(localObject2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("divide bean: ");
        localStringBuilder.append(((VoiceBean)localObject1).a());
        AssistantUtils.a("VoiceCacheHolder", localStringBuilder.toString());
        if ((l3 >= l1) && (l3 <= ((VoiceBean)localObject1).b + l1))
        {
          l2 = l3 - l1;
          break label340;
        }
        l2 = l1 + ((VoiceBean)localObject1).b;
      }
      j = i;
      if (((VoiceBean)localObject1).e())
      {
        a(this.jdField_a_of_type_JavaIoFileOutputStream, ((VoiceBean)localObject1).jdField_a_of_type_ArrayOfByte, false);
        j = i + 1;
      }
      l1 = l2;
    }
    long l2 = 0L;
    localObject1 = null;
    label340:
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("divide curOff:");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append(", remains:");
    ((StringBuilder)localObject2).append(l2);
    AssistantUtils.a("VoiceCacheHolder", ((StringBuilder)localObject2).toString());
    if ((localObject1 != null) && (l2 > 0L))
    {
      paramVoiceBeanProcessor = a(paramVoiceBeanProcessor, ((VoiceBean)localObject1).jdField_a_of_type_Long, l2);
      a(this.jdField_a_of_type_JavaIoFileOutputStream, paramVoiceBeanProcessor, false);
    }
    a(this.jdField_a_of_type_JavaIoFileOutputStream, null, true);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(a((VoiceBean)localObject1, l2, i));
    if (localObject1 != null)
    {
      paramVoiceBeanProcessor = AssistantUtils.a(AssistantUtils.b(((VoiceBean)localObject1).jdField_a_of_type_JavaLangString), "slk");
      FileUtils.rename(this.jdField_a_of_type_JavaLangString, paramVoiceBeanProcessor);
      this.jdField_a_of_type_JavaLangString = paramVoiceBeanProcessor;
    }
    return localObject1;
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
    if (paramFileOutputStream != null)
    {
      if (paramArrayOfByte != null) {}
      try
      {
        paramFileOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        paramFileOutputStream.flush();
        if (paramBoolean)
        {
          paramFileOutputStream.close();
          return;
        }
      }
      catch (IOException paramFileOutputStream)
      {
        paramFileOutputStream.printStackTrace();
      }
    }
  }
  
  private byte[] a(VoiceBeanProcessor paramVoiceBeanProcessor, long paramLong1, long paramLong2)
  {
    if ((paramVoiceBeanProcessor != null) && (paramLong1 > 0L))
    {
      if (paramLong2 <= 0L) {
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
      catch (IOException paramVoiceBeanProcessor)
      {
        paramVoiceBeanProcessor.printStackTrace();
        return null;
      }
      catch (FileNotFoundException paramVoiceBeanProcessor)
      {
        paramVoiceBeanProcessor.printStackTrace();
      }
    }
    return null;
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder("\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((VoiceBean)localIterator.next()).a());
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private void b(int paramInt, VoiceBeanProcessor paramVoiceBeanProcessor)
  {
    VoiceTimeTraceUtil.a().b();
    a(this.jdField_b_of_type_JavaIoFileOutputStream, null, true);
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo == null) {
      paramVoiceBeanProcessor = a();
    } else {
      paramVoiceBeanProcessor = a(paramVoiceBeanProcessor);
    }
    VoiceTimeTraceUtil.a().a("SLK", this.jdField_a_of_type_JavaLangString);
    if (paramVoiceBeanProcessor != null) {
      paramVoiceBeanProcessor = AssistantUtils.b(paramVoiceBeanProcessor.jdField_a_of_type_JavaLangString);
    } else {
      paramVoiceBeanProcessor = "";
    }
    if (!TextUtils.isEmpty(paramVoiceBeanProcessor))
    {
      String str = AssistantUtils.a(paramVoiceBeanProcessor, "pcm");
      FileUtils.rename(this.jdField_b_of_type_JavaLangString, str);
      this.jdField_b_of_type_JavaLangString = str;
    }
    VoiceTimeTraceUtil.a().a("BUF", paramVoiceBeanProcessor, b());
    VoiceTimeTraceUtil.a().a("PCM", this.jdField_b_of_type_JavaLangString);
    VoiceTimeTraceUtil.a().a();
    paramVoiceBeanProcessor = new StringBuilder();
    paramVoiceBeanProcessor.append("clear cache buffer, final size: ");
    paramVoiceBeanProcessor.append(this.jdField_a_of_type_JavaUtilList.size());
    AssistantUtils.a("VoiceCacheHolder", paramVoiceBeanProcessor.toString());
    this.jdField_a_of_type_JavaUtilList.clear();
    VoiceTimeTraceUtil.a().c();
    a(null);
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
  
  public VoiceBean a(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          VoiceBean localVoiceBean = (VoiceBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          return localVoiceBean;
        }
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    return null;
  }
  
  public String a()
  {
    try
    {
      String str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        str = "";
      } else {
        str = this.jdField_a_of_type_JavaLangString;
      }
      return str;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      AssistantUtils.a("VoiceCacheHolder", "rawVadBuffer, fix null bean at header&tailor.");
      Object localObject1 = AssistantUtils.a();
      this.jdField_a_of_type_JavaUtilList.add(0, new VoiceBean(null, (String)localObject1));
      this.jdField_a_of_type_JavaUtilList.add(new VoiceBean(null, (String)localObject1));
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      try
      {
        this.jdField_b_of_type_JavaLangString = AssistantUtils.a(String.valueOf(System.currentTimeMillis()), "pcm");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("write pcm pth: ");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        AssistantUtils.a("VoiceCacheHolder", ((StringBuilder)localObject1).toString());
        a(this.jdField_b_of_type_JavaIoFileOutputStream, null, true);
        this.jdField_b_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_b_of_type_JavaLangString);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(int paramInt, VoiceBeanProcessor paramVoiceBeanProcessor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: aload_2
    //   5: invokespecial 301	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:b	(ILcom/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor;)V
    //   8: goto +12 -> 20
    //   11: astore_2
    //   12: goto +11 -> 23
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 231	java/io/FileNotFoundException:printStackTrace	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	VoiceCacheHolder
    //   0	27	1	paramInt	int
    //   0	27	2	paramVoiceBeanProcessor	VoiceBeanProcessor
    // Exception table:
    //   from	to	target	type
    //   2	8	11	finally
    //   16	20	11	finally
    //   2	8	15	java/io/FileNotFoundException
  }
  
  public void a(@Nullable ConfirmSendInfo paramConfirmSendInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo = paramConfirmSendInfo;
  }
  
  public void a(byte[] paramArrayOfByte, VoiceBean paramVoiceBean)
  {
    if (paramVoiceBean != null) {}
    try
    {
      a(paramVoiceBean);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
        break label40;
      }
      a(this.jdField_b_of_type_JavaIoFileOutputStream, paramArrayOfByte, false);
    }
    finally
    {
      label36:
      label40:
      break label36;
    }
    throw paramArrayOfByte;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceCacheHolder
 * JD-Core Version:    0.7.0.1
 */