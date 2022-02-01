package com.tencent.mobileqq.shortvideo.hwcodec;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class SVHwEncoder
{
  private static boolean D = false;
  private static AtomicInteger b = new AtomicInteger(0);
  private int A = 0;
  private SVHwOutputNotify B;
  private int[] C = new int[4];
  public int a = 21;
  private int c;
  private int d;
  private String e;
  private volatile float f = 30.0F;
  private volatile int g = 480000;
  private int h = 44100;
  private int i = 1;
  private int j = 128000;
  private int k = 2;
  private boolean l = false;
  private int m = -1;
  private int n = -1;
  private int o = 0;
  private Object p = new Object();
  private ArrayList<SVHwEncoder.HwFrame> q = new ArrayList();
  private ArrayList<SVHwEncoder.HwFrame> r = new ArrayList();
  private ArrayList<SVHwEncoder.HwFrame> s = new ArrayList();
  private volatile boolean t = false;
  private volatile boolean u = false;
  private volatile boolean v = false;
  private SVHwEncoder.HwEncode w = null;
  private double x = 0.0D;
  private double y = 0.0D;
  private int z = 0;
  
  private native boolean adjustDstresolution(int[] paramArrayOfInt);
  
  int a(List<MediaCodecInfo> paramList, String paramString)
  {
    if (paramList.size() <= 0) {
      return -1;
    }
    int i1 = 0;
    int i3;
    for (int i2 = -1; i1 < paramList.size(); i2 = i3)
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = SVHwCodec.a((MediaCodecInfo)paramList.get(i1), paramString);
      if (localCodecCapabilities == null) {
        return i2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("name=");
      localStringBuilder.append(((MediaCodecInfo)paramList.get(i1)).getName());
      a("selectAudioCodec", localStringBuilder.toString());
      i3 = i2;
      if (localCodecCapabilities.profileLevels != null) {
        if (localCodecCapabilities.profileLevels.length <= 0)
        {
          i3 = i2;
        }
        else
        {
          int i4 = 0;
          for (;;)
          {
            i3 = i2;
            if (i4 >= localCodecCapabilities.profileLevels.length) {
              break;
            }
            if (localCodecCapabilities.profileLevels[i4].profile == 2)
            {
              i3 = i1;
              break;
            }
            i4 += 1;
          }
        }
      }
      i1 += 1;
    }
    return i2;
  }
  
  public SVHwEncoder.HwFrame a()
  {
    boolean bool = this.t;
    Object localObject1 = null;
    Object localObject4 = null;
    byte[] arrayOfByte = null;
    Object localObject3 = localObject4;
    if (!bool)
    {
      ArrayList localArrayList = this.q;
      localObject3 = localObject4;
      if (localArrayList != null)
      {
        if (localArrayList.size() > 0)
        {
          localObject3 = this.p;
          localObject1 = arrayOfByte;
          try
          {
            if (this.q.size() > 0)
            {
              localObject1 = (SVHwEncoder.HwFrame)this.q.get(0);
              this.q.remove(0);
            }
          }
          finally {}
        }
        if ((localHwFrame != null) && (localHwFrame.a != null))
        {
          localObject3 = localHwFrame;
          if (QLog.isColorLevel())
          {
            QLog.d("SVHwEncoder", 2, "getRecycleFrame[cache frame]");
            return localHwFrame;
          }
        }
        else
        {
          Object localObject2;
          try
          {
            arrayOfByte = new byte[this.c * this.d * 3 / 2];
            localObject3 = new SVHwEncoder.HwFrame();
            try
            {
              ((SVHwEncoder.HwFrame)localObject3).a = arrayOfByte;
              ((SVHwEncoder.HwFrame)localObject3).g = -1.0F;
              ((SVHwEncoder.HwFrame)localObject3).h = -1;
              localObject2 = localObject3;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              localObject2 = localObject3;
            }
            if (!QLog.isColorLevel()) {
              break label197;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError2) {}
          QLog.e("SVHwEncoder", 2, "getRecycleFrame allocate frame OOM erro ", localOutOfMemoryError2);
          label197:
          localObject3 = this.B;
          if (localObject3 != null) {
            ((SVHwOutputNotify)localObject3).b(-27, 0);
          }
          c();
          localObject3 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("SVHwEncoder", 2, "getRecycleFrame[allocate frame]");
            localObject3 = localObject2;
          }
        }
      }
    }
    return localObject3;
  }
  
  SVHwEncoder.HwFrame a(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
  {
    SVHwEncoder.HwFrame localHwFrame = null;
    try
    {
      if (paramArrayList.size() > 0) {
        localHwFrame = (SVHwEncoder.HwFrame)paramArrayList.get(0);
      }
      return localHwFrame;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 8000) || (paramInt1 == 16000) || (paramInt1 == 44100)) {
      this.h = paramInt1;
    }
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.i = paramInt2;
    }
    if ((paramInt3 == 64000) || (paramInt3 == 128000)) {
      this.j = paramInt3;
    }
    if ((paramInt4 == 1) || (paramInt4 == 2)) {
      this.k = paramInt4;
    }
  }
  
  public void a(SVHwEncoder.HwFrame paramHwFrame, boolean paramBoolean)
  {
    try
    {
      if (!this.t)
      {
        StringBuilder localStringBuilder;
        if ((paramBoolean) && (this.r != null))
        {
          this.r.add(paramHwFrame);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("finish=");
          localStringBuilder.append(paramHwFrame.e);
          localStringBuilder.append(" size=");
          localStringBuilder.append(paramHwFrame.c);
          a("hw_video_write_frame", localStringBuilder.toString());
        }
        else if (this.s != null)
        {
          this.s.add(paramHwFrame);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("finish=");
          localStringBuilder.append(paramHwFrame.e);
          localStringBuilder.append(" size=");
          localStringBuilder.append(paramHwFrame.c);
          a("hw_audio_write_frame", localStringBuilder.toString());
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(SVHwOutputNotify paramSVHwOutputNotify, SVHwDataSource paramSVHwDataSource, boolean paramBoolean)
  {
    this.B = paramSVHwOutputNotify;
    this.w = new SVHwEncoder.HwEncode(this, this.e, paramSVHwOutputNotify, paramSVHwDataSource, paramBoolean, 0);
    this.w.run();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.e = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
    b();
  }
  
  void a(String paramString1, String paramString2)
  {
    if ((!D) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString2);
      QLog.d("SVHwEncoder", 2, localStringBuilder.toString());
    }
  }
  
  void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, String paramString, int paramInt)
  {
    if (paramByteBuffer == null)
    {
      a(paramString, "Configdata buferData=null");
      return;
    }
    StringBuilder localStringBuilder;
    if (paramBufferInfo.size != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Configdata size=");
      localStringBuilder.append(paramBufferInfo.size);
      a(paramString, localStringBuilder.toString());
    }
    if (paramBufferInfo.size < paramInt)
    {
      localStringBuilder = new StringBuilder();
      paramInt = 0;
      while (paramInt < paramBufferInfo.size)
      {
        paramByteBuffer.position(paramBufferInfo.offset + paramInt);
        localStringBuilder.append(paramByteBuffer.get());
        localStringBuilder.append(',');
        paramInt += 1;
      }
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("Configdata =");
      paramByteBuffer.append(localStringBuilder.toString());
      a(paramString, paramByteBuffer.toString());
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.l = true;
    this.m = paramInt1;
    this.n = paramInt2;
    paramInt1 = paramInt3;
    if (paramInt3 != 0)
    {
      paramInt1 = paramInt3;
      if (paramInt3 != 90)
      {
        paramInt1 = paramInt3;
        if (paramInt3 != 180)
        {
          paramInt1 = paramInt3;
          if (paramInt3 != 270) {
            paramInt1 = 0;
          }
        }
      }
    }
    this.o = paramInt1;
    if (this.n <= 0)
    {
      this.n = 1000;
      return false;
    }
    if (this.m <= 0)
    {
      this.m = 1;
      return false;
    }
    return true;
  }
  
  boolean a(SVHwEncoder.HwFrame paramHwFrame)
  {
    int i1 = this.q.size();
    boolean bool = false;
    if (i1 < 3) {
      synchronized (this.p)
      {
        if (this.q.size() < 3)
        {
          this.q.add(paramHwFrame);
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  void b()
  {
    int[] arrayOfInt1 = this.C;
    int i1 = this.c;
    int i2 = 0;
    arrayOfInt1[0] = i1;
    arrayOfInt1[1] = this.d;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = 0;
    try
    {
      boolean bool = adjustDstresolution(arrayOfInt1);
      i2 = bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    if (i2 == 0)
    {
      i1 = this.c;
      this.c = (i1 - i1 % 16);
      i1 = this.d;
      this.d = (i1 - i1 % 16);
      return;
    }
    int[] arrayOfInt2 = this.C;
    this.c = arrayOfInt2[2];
    this.d = arrayOfInt2[3];
  }
  
  void b(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
  {
    try
    {
      if (paramArrayList.size() > 0) {
        paramArrayList.remove(0);
      }
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  int c(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
  {
    try
    {
      int i1 = paramArrayList.size();
      return i1;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public void c()
  {
    this.t = true;
    this.u = true;
  }
  
  void d()
  {
    try
    {
      SVHwEncoder.HwFrame localHwFrame = new SVHwEncoder.HwFrame();
      localHwFrame.e = true;
      localHwFrame.f = true;
      localHwFrame.g = 30.0F;
      localHwFrame.h = 480000;
      this.r.add(localHwFrame);
      localHwFrame = new SVHwEncoder.HwFrame();
      localHwFrame.e = true;
      localHwFrame.f = false;
      this.s.add(localHwFrame);
      a("hw_video_write_frame", "addMediaEndFrame finish...");
      a("hw_audio_write_frame", "addMediaEndFrame finish...");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void d(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
  {
    try
    {
      paramArrayList.clear();
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder
 * JD-Core Version:    0.7.0.1
 */