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
  public static byte[] a = RecordParams.a(1, 16000);
  private volatile List<VoiceBean> b = new ArrayList();
  private volatile ConfirmSendInfo c;
  private AtomicLong d = new AtomicLong();
  private String e;
  private String f;
  private FileOutputStream g;
  private FileOutputStream h;
  
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
  
  private VoiceBean a(VoiceBeanProcessor paramVoiceBeanProcessor)
  {
    this.e = AssistantUtils.b(String.valueOf(System.nanoTime()), "slk");
    a(this.g, null, true);
    this.g = new FileOutputStream(this.e);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("write slk pth(divide): ");
    ((StringBuilder)localObject1).append(this.e);
    AssistantUtils.a("VoiceCacheHolder", ((StringBuilder)localObject1).toString());
    a(this.g, a, false);
    long l3 = this.c.a * 32L;
    Object localObject2 = AssistantUtils.c(this.c.c);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.c.a());
    ((StringBuilder)localObject1).append(", locateOff:");
    ((StringBuilder)localObject1).append(l3);
    AssistantUtils.a("VoiceCacheHolder", ((StringBuilder)localObject1).toString());
    Iterator localIterator = this.b.iterator();
    long l1 = 0L;
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      localObject1 = (VoiceBean)localIterator.next();
      l2 = l1;
      if (((VoiceBean)localObject1).h.equals(localObject2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("divide bean: ");
        localStringBuilder.append(((VoiceBean)localObject1).c());
        AssistantUtils.a("VoiceCacheHolder", localStringBuilder.toString());
        if ((l3 >= l1) && (l3 <= ((VoiceBean)localObject1).f + l1))
        {
          l2 = l3 - l1;
          break label340;
        }
        l2 = l1 + ((VoiceBean)localObject1).f;
      }
      j = i;
      if (((VoiceBean)localObject1).f())
      {
        a(this.g, ((VoiceBean)localObject1).a, false);
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
      paramVoiceBeanProcessor = a(paramVoiceBeanProcessor, ((VoiceBean)localObject1).e, l2);
      a(this.g, paramVoiceBeanProcessor, false);
    }
    a(this.g, null, true);
    this.d.set(a((VoiceBean)localObject1, l2, i));
    if (localObject1 != null)
    {
      paramVoiceBeanProcessor = AssistantUtils.b(AssistantUtils.d(((VoiceBean)localObject1).h), "slk");
      FileUtils.rename(this.e, paramVoiceBeanProcessor);
      this.e = paramVoiceBeanProcessor;
    }
    return localObject1;
  }
  
  private void a(VoiceBean paramVoiceBean)
  {
    if (this.b.size() < 2)
    {
      this.b.clear();
      a();
    }
    int i = this.b.size();
    this.b.add(i - 1, paramVoiceBean);
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
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.f, "rw");
        localRandomAccessFile.seek(paramLong1);
        byte[] arrayOfByte = new byte[(int)paramLong2];
        localRandomAccessFile.read(arrayOfByte, 0, arrayOfByte.length);
        paramVoiceBeanProcessor = paramVoiceBeanProcessor.a(arrayOfByte);
        localRandomAccessFile.close();
        paramVoiceBeanProcessor = paramVoiceBeanProcessor.a;
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
  
  private void b(int paramInt, VoiceBeanProcessor paramVoiceBeanProcessor)
  {
    VoiceTimeTraceUtil.a().c();
    a(this.h, null, true);
    if (this.c == null) {
      paramVoiceBeanProcessor = f();
    } else {
      paramVoiceBeanProcessor = a(paramVoiceBeanProcessor);
    }
    VoiceTimeTraceUtil.a().a("SLK", this.e);
    if (paramVoiceBeanProcessor != null) {
      paramVoiceBeanProcessor = AssistantUtils.d(paramVoiceBeanProcessor.h);
    } else {
      paramVoiceBeanProcessor = "";
    }
    if (!TextUtils.isEmpty(paramVoiceBeanProcessor))
    {
      String str = AssistantUtils.b(paramVoiceBeanProcessor, "pcm");
      FileUtils.rename(this.f, str);
      this.f = str;
    }
    VoiceTimeTraceUtil.a().a("BUF", paramVoiceBeanProcessor, g());
    VoiceTimeTraceUtil.a().a("PCM", this.f);
    VoiceTimeTraceUtil.a().b();
    paramVoiceBeanProcessor = new StringBuilder();
    paramVoiceBeanProcessor.append("clear cache buffer, final size: ");
    paramVoiceBeanProcessor.append(this.b.size());
    AssistantUtils.a("VoiceCacheHolder", paramVoiceBeanProcessor.toString());
    this.b.clear();
    VoiceTimeTraceUtil.a().d();
    a(null);
  }
  
  private VoiceBean f()
  {
    this.e = AssistantUtils.b(String.valueOf(System.nanoTime()), "slk");
    a(this.g, null, true);
    this.g = new FileOutputStream(this.e);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("write slk pth(normal): ");
    ((StringBuilder)localObject1).append(this.e);
    AssistantUtils.a("VoiceCacheHolder", ((StringBuilder)localObject1).toString());
    a(this.g, a, false);
    Iterator localIterator = this.b.iterator();
    localObject1 = null;
    int i = 0;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (VoiceBean)localIterator.next();
      if (((VoiceBean)localObject2).f())
      {
        a(this.g, ((VoiceBean)localObject2).a, false);
        i += 1;
        localObject1 = localObject2;
      }
    }
    a(this.g, null, true);
    this.d.set(a((VoiceBean)localObject1, 0L, i));
    if (localObject1 != null)
    {
      localObject2 = AssistantUtils.b(AssistantUtils.d(((VoiceBean)localObject1).h), "slk");
      FileUtils.rename(this.e, (String)localObject2);
      this.e = ((String)localObject2);
    }
    return localObject1;
  }
  
  private String g()
  {
    StringBuilder localStringBuilder = new StringBuilder("\n");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((VoiceBean)localIterator.next()).c());
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
  
  public VoiceBean a(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        if (paramInt < this.b.size())
        {
          VoiceBean localVoiceBean = (VoiceBean)this.b.get(paramInt);
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
  
  public void a()
  {
    try
    {
      AssistantUtils.a("VoiceCacheHolder", "rawVadBuffer, fix null bean at header&tailor.");
      Object localObject1 = AssistantUtils.e();
      this.b.add(0, new VoiceBean(null, (String)localObject1));
      this.b.add(new VoiceBean(null, (String)localObject1));
      this.d.set(0L);
      try
      {
        this.f = AssistantUtils.b(String.valueOf(System.currentTimeMillis()), "pcm");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("write pcm pth: ");
        ((StringBuilder)localObject1).append(this.f);
        AssistantUtils.a("VoiceCacheHolder", ((StringBuilder)localObject1).toString());
        a(this.h, null, true);
        this.h = new FileOutputStream(this.f);
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
    //   5: invokespecial 309	com/tencent/mobileqq/qassistant/audio/VoiceCacheHolder:b	(ILcom/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor;)V
    //   8: goto +12 -> 20
    //   11: astore_2
    //   12: goto +11 -> 23
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 237	java/io/FileNotFoundException:printStackTrace	()V
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
    this.c = paramConfirmSendInfo;
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
      a(this.h, paramArrayOfByte, false);
    }
    finally
    {
      label36:
      label40:
      break label36;
    }
    throw paramArrayOfByte;
  }
  
  public String b()
  {
    try
    {
      String str;
      if (TextUtils.isEmpty(this.e)) {
        str = "";
      } else {
        str = this.e;
      }
      return str;
    }
    finally {}
  }
  
  public long c()
  {
    try
    {
      long l = this.d.get();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int d()
  {
    try
    {
      int i = this.b.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e()
  {
    try
    {
      boolean bool = this.b.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceCacheHolder
 * JD-Core Version:    0.7.0.1
 */