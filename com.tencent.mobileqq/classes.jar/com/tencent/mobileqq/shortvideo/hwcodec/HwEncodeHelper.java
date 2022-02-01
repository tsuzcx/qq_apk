package com.tencent.mobileqq.shortvideo.hwcodec;

import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.qphone.base.util.QLog;

public class HwEncodeHelper
  implements SVHwDataSource, SVHwOutputNotify
{
  private int jdField_a_of_type_Int = 0;
  private SVHwEncoder.HwFrame jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame = new SVHwEncoder.HwFrame();
  private VideoSourceHelper jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper;
  private final String jdField_a_of_type_JavaLangString = "HwEncodeHelper";
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private long[] jdField_a_of_type_ArrayOfLong = new long[1];
  private SVHwEncoder.HwFrame jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame = new SVHwEncoder.HwFrame();
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte = null;
  private String c;
  
  public HwEncodeHelper(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper = new VideoSourceHelper(paramString1, paramString2);
  }
  
  private boolean a()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getBufferSize();
    if (arrayOfInt != null)
    {
      if (arrayOfInt.length < 2) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initMediaBuffer videosize=");
        localStringBuilder.append(arrayOfInt[0]);
        localStringBuilder.append(", audiosize=");
        localStringBuilder.append(arrayOfInt[1]);
        QLog.d("HwEncodeHelper", 4, localStringBuilder.toString());
      }
      try
      {
        if (this.jdField_a_of_type_ArrayOfByte == null) {
          this.jdField_a_of_type_ArrayOfByte = new byte[arrayOfInt[0]];
        }
        if (this.jdField_b_of_type_ArrayOfByte == null) {
          this.jdField_b_of_type_ArrayOfByte = new byte[arrayOfInt[1]];
        }
        return true;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    return false;
  }
  
  public int a()
  {
    if (!HwEnvData.a()) {
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.initHelperParam() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initHelperParam error");
      }
      return -1;
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initMediaBuffer error");
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.closeHelper();
      return -1;
    }
    SVHwEncoder localSVHwEncoder = new SVHwEncoder();
    int i = CodecParam.mAudioChannel;
    int j = 2;
    if (i == 16) {
      i = 1;
    } else {
      i = 2;
    }
    if (CodecParam.mAudioFormat != 2) {
      j = 1;
    }
    int k = CodecParam.mAudioSampleRate;
    localSVHwEncoder.a(CodecParam.mAudioSampleRate, i, k * i * j * 8, j);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.getSourceVideoParam();
    localSVHwEncoder.a(this.jdField_b_of_type_JavaLangString, localObject[0], localObject[1]);
    boolean bool = localSVHwEncoder.a(CodecParam.mRecordFrames, CodecParam.mRecordTime, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.mOrientationDegree);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startHwEncode mRecordFrames=");
      ((StringBuilder)localObject).append(CodecParam.mRecordFrames);
      ((StringBuilder)localObject).append(", mRecordTime=");
      ((StringBuilder)localObject).append(CodecParam.mRecordTime);
      ((StringBuilder)localObject).append(" successCode=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("HwEncodeHelper", 4, ((StringBuilder)localObject).toString());
    }
    if (!bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.closeHelper();
      return -1;
    }
    localSVHwEncoder.a(this, this, true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper.closeHelper();
    return this.jdField_a_of_type_Int;
  }
  
  public SVHwEncoder.HwFrame a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper;
    if ((localObject != null) && (!this.jdField_a_of_type_Boolean))
    {
      int i = ((VideoSourceHelper)localObject).getNextAudioFrame(this.jdField_b_of_type_ArrayOfByte);
      localObject = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame;
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      boolean bool = false;
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Int = 0;
      ((SVHwEncoder.HwFrame)localObject).jdField_b_of_type_Int = i;
      ((SVHwEncoder.HwFrame)localObject).jdField_b_of_type_Boolean = false;
      if (i <= 0) {
        bool = true;
      }
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Boolean = bool;
      localObject = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame;
      ((SVHwEncoder.HwFrame)localObject).c = -1;
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Long = -1;
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Float = -1.0F;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAudioFrame() bufferSize=");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_ArrayOfByte.length);
        ((StringBuilder)localObject).append(", readSize=");
        ((StringBuilder)localObject).append(i);
        QLog.d("HwEncodeHelper", 4, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Boolean = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame.jdField_a_of_type_Boolean;
      return this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame;
    }
    return null;
  }
  
  public SVHwEncoder.HwFrame a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecVideoSourceHelper;
    if ((localObject != null) && (!this.jdField_b_of_type_Boolean))
    {
      paramInt = ((VideoSourceHelper)localObject).getNextVideoFrame(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfLong, paramInt);
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame;
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Int = 0;
      ((SVHwEncoder.HwFrame)localObject).jdField_b_of_type_Int = paramInt;
      boolean bool = true;
      ((SVHwEncoder.HwFrame)localObject).jdField_b_of_type_Boolean = true;
      if (paramInt > 0) {
        bool = false;
      }
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Boolean = bool;
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame;
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_ArrayOfLong[0];
      ((SVHwEncoder.HwFrame)localObject).c = -1;
      ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Float = -1.0F;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getVideoFrame() bufferSize=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfByte.length);
        ((StringBuilder)localObject).append(", readSize=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", frametime=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfLong[0]);
        QLog.d("HwEncodeHelper", 4, ((StringBuilder)localObject).toString());
      }
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame.jdField_a_of_type_Boolean;
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwFrame;
    }
    return null;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("svMergeOK() path=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", totalTime=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" mergetime=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" us");
      QLog.d("HwEncodeHelper", 4, localStringBuilder.toString());
    }
    this.c = paramString;
  }
  
  public void b() {}
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("svErrorOcured() code=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", subcode=");
      localStringBuilder.append(paramInt2);
      QLog.d("HwEncodeHelper", 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.HwEncodeHelper
 * JD-Core Version:    0.7.0.1
 */