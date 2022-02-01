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
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static boolean jdField_e_of_type_Boolean = false;
  private double jdField_a_of_type_Double = 0.0D;
  private volatile float jdField_a_of_type_Float = 30.0F;
  public int a;
  private SVHwEncoder.HwEncode jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode = null;
  private SVHwOutputNotify jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<SVHwEncoder.HwFrame> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  private double jdField_b_of_type_Double = 0.0D;
  private int jdField_b_of_type_Int;
  private ArrayList<SVHwEncoder.HwFrame> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private ArrayList<SVHwEncoder.HwFrame> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_c_of_type_Boolean = false;
  private volatile int jdField_d_of_type_Int = 480000;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 44100;
  private int f = 1;
  private int g = 128000;
  private int h = 2;
  private int i = -1;
  private int j = -1;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  
  public SVHwEncoder()
  {
    this.jdField_a_of_type_Int = 21;
  }
  
  private native boolean adjustDstresolution(int[] paramArrayOfInt);
  
  int a(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
  {
    try
    {
      int n = paramArrayList.size();
      return n;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  int a(List<MediaCodecInfo> paramList, String paramString)
  {
    if (paramList.size() <= 0) {
      return -1;
    }
    int n = 0;
    int i2;
    for (int i1 = -1; n < paramList.size(); i1 = i2)
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = SVHwCodec.a((MediaCodecInfo)paramList.get(n), paramString);
      if (localCodecCapabilities == null) {
        return i1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("name=");
      localStringBuilder.append(((MediaCodecInfo)paramList.get(n)).getName());
      a("selectAudioCodec", localStringBuilder.toString());
      i2 = i1;
      if (localCodecCapabilities.profileLevels != null) {
        if (localCodecCapabilities.profileLevels.length <= 0)
        {
          i2 = i1;
        }
        else
        {
          int i3 = 0;
          for (;;)
          {
            i2 = i1;
            if (i3 >= localCodecCapabilities.profileLevels.length) {
              break;
            }
            if (localCodecCapabilities.profileLevels[i3].profile == 2)
            {
              i2 = n;
              break;
            }
            i3 += 1;
          }
        }
      }
      n += 1;
    }
    return i1;
  }
  
  public SVHwEncoder.HwFrame a()
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    Object localObject1 = null;
    Object localObject4 = null;
    byte[] arrayOfByte = null;
    Object localObject3 = localObject4;
    if (!bool)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      localObject3 = localObject4;
      if (localArrayList != null)
      {
        if (localArrayList.size() > 0)
        {
          localObject3 = this.jdField_a_of_type_JavaLangObject;
          localObject1 = arrayOfByte;
          try
          {
            if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
            {
              localObject1 = (SVHwEncoder.HwFrame)this.jdField_a_of_type_JavaUtilArrayList.get(0);
              this.jdField_a_of_type_JavaUtilArrayList.remove(0);
            }
          }
          finally {}
        }
        if ((localHwFrame != null) && (localHwFrame.jdField_a_of_type_ArrayOfByte != null))
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
            arrayOfByte = new byte[this.jdField_b_of_type_Int * this.jdField_c_of_type_Int * 3 / 2];
            localObject3 = new SVHwEncoder.HwFrame();
            try
            {
              ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_ArrayOfByte = arrayOfByte;
              ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Float = -1.0F;
              ((SVHwEncoder.HwFrame)localObject3).jdField_c_of_type_Int = -1;
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
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify;
          if (localObject3 != null) {
            ((SVHwOutputNotify)localObject3).b(-27, 0);
          }
          b();
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
  
  void a()
  {
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int n = this.jdField_b_of_type_Int;
    int i1 = 0;
    arrayOfInt1[0] = n;
    arrayOfInt1[1] = this.jdField_c_of_type_Int;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = 0;
    try
    {
      boolean bool = adjustDstresolution(arrayOfInt1);
      i1 = bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    if (i1 == 0)
    {
      n = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (n - n % 16);
      n = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (n - n % 16);
      return;
    }
    int[] arrayOfInt2 = this.jdField_a_of_type_ArrayOfInt;
    this.jdField_b_of_type_Int = arrayOfInt2[2];
    this.jdField_c_of_type_Int = arrayOfInt2[3];
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 8000) || (paramInt1 == 16000) || (paramInt1 == 44100)) {
      this.jdField_e_of_type_Int = paramInt1;
    }
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.f = paramInt2;
    }
    if ((paramInt3 == 64000) || (paramInt3 == 128000)) {
      this.g = paramInt3;
    }
    if ((paramInt4 == 1) || (paramInt4 == 2)) {
      this.h = paramInt4;
    }
  }
  
  public void a(SVHwEncoder.HwFrame paramHwFrame, boolean paramBoolean)
  {
    try
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        StringBuilder localStringBuilder;
        if ((paramBoolean) && (this.jdField_b_of_type_JavaUtilArrayList != null))
        {
          this.jdField_b_of_type_JavaUtilArrayList.add(paramHwFrame);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("finish=");
          localStringBuilder.append(paramHwFrame.jdField_a_of_type_Boolean);
          localStringBuilder.append(" size=");
          localStringBuilder.append(paramHwFrame.jdField_b_of_type_Int);
          a("hw_video_write_frame", localStringBuilder.toString());
        }
        else if (this.jdField_c_of_type_JavaUtilArrayList != null)
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(paramHwFrame);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("finish=");
          localStringBuilder.append(paramHwFrame.jdField_a_of_type_Boolean);
          localStringBuilder.append(" size=");
          localStringBuilder.append(paramHwFrame.jdField_b_of_type_Int);
          a("hw_audio_write_frame", localStringBuilder.toString());
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(SVHwOutputNotify paramSVHwOutputNotify, SVHwDataSource paramSVHwDataSource, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify = paramSVHwOutputNotify;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode = new SVHwEncoder.HwEncode(this, this.jdField_a_of_type_JavaLangString, paramSVHwOutputNotify, paramSVHwDataSource, paramBoolean, 0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.run();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    a();
  }
  
  void a(String paramString1, String paramString2)
  {
    if ((!jdField_e_of_type_Boolean) && (QLog.isColorLevel()))
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
  
  void a(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
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
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.i = paramInt1;
    this.j = paramInt2;
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
    this.k = paramInt1;
    if (this.j <= 0)
    {
      this.j = 1000;
      return false;
    }
    if (this.i <= 0)
    {
      this.i = 1;
      return false;
    }
    return true;
  }
  
  boolean a(SVHwEncoder.HwFrame paramHwFrame)
  {
    int n = this.jdField_a_of_type_JavaUtilArrayList.size();
    boolean bool = false;
    if (n < 3) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < 3)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramHwFrame);
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
  }
  
  void b(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
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
  
  void c()
  {
    try
    {
      SVHwEncoder.HwFrame localHwFrame = new SVHwEncoder.HwFrame();
      localHwFrame.jdField_a_of_type_Boolean = true;
      localHwFrame.jdField_b_of_type_Boolean = true;
      localHwFrame.jdField_a_of_type_Float = 30.0F;
      localHwFrame.jdField_c_of_type_Int = 480000;
      this.jdField_b_of_type_JavaUtilArrayList.add(localHwFrame);
      localHwFrame = new SVHwEncoder.HwFrame();
      localHwFrame.jdField_a_of_type_Boolean = true;
      localHwFrame.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_JavaUtilArrayList.add(localHwFrame);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder
 * JD-Core Version:    0.7.0.1
 */