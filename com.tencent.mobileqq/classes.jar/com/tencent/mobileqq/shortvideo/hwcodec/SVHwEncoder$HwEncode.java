package com.tencent.mobileqq.shortvideo.hwcodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.Lock;
import com.tencent.mobileqq.shortvideo.util.SVMp4Merge;
import com.tencent.mobileqq.shortvideo.util.videoconverter.InputSurface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class SVHwEncoder$HwEncode
  implements SVHwDataSource, SVHwOutputNotify, Runnable
{
  private int jdField_a_of_type_Int = 0;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat = null;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer = null;
  private SVHwCodec jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec = new SVHwCodec();
  private SVHwDataSource jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource = null;
  private SVHwEncoder.HwEncode.HwTimeTool jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool = new SVHwEncoder.HwEncode.HwTimeTool(this);
  SVHwEncoder.HwEncode.IntelX86Error jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error = new SVHwEncoder.HwEncode.IntelX86Error(this);
  private SVHwEncoder.HwEncode.MuxerValidData jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData = new SVHwEncoder.HwEncode.MuxerValidData(this);
  private SVHwOutputNotify jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify = null;
  SVHwThumbGen jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen = new SVHwThumbGen();
  private SVHwVideoFpsSmooth jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth = new SVHwVideoFpsSmooth();
  private InputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = null;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private MediaFormat jdField_b_of_type_AndroidMediaMediaFormat = null;
  private SVHwCodec jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec = new SVHwCodec();
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private MediaFormat jdField_c_of_type_AndroidMediaMediaFormat = null;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private MediaFormat jdField_d_of_type_AndroidMediaMediaFormat = null;
  private String jdField_d_of_type_JavaLangString = null;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = null;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private String jdField_f_of_type_JavaLangString = null;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int = 0;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int = 0;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int = 0;
  private boolean jdField_l_of_type_Boolean = true;
  private int jdField_m_of_type_Int = 0;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int = 0;
  private volatile boolean jdField_n_of_type_Boolean = false;
  private boolean o = false;
  private volatile boolean p = false;
  
  SVHwEncoder$HwEncode(SVHwEncoder paramSVHwEncoder, String paramString, SVHwOutputNotify paramSVHwOutputNotify, SVHwDataSource paramSVHwDataSource, boolean paramBoolean, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_e_of_type_JavaLangString = a(paramString);
    this.jdField_g_of_type_Boolean = paramBoolean;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify = paramSVHwOutputNotify;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource = paramSVHwDataSource;
    a();
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_n_of_type_Int = paramInt;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.o = false;
    this.jdField_g_of_type_Int = 0;
  }
  
  float a(int paramInt)
  {
    int i1 = SVHwEncoder.h(this.this$0);
    int i2 = SVHwEncoder.i(this.this$0);
    int i3 = SVHwEncoder.j(this.this$0);
    return paramInt * 1000.0F / (i1 * i2 * i3);
  }
  
  int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(this.jdField_c_of_type_AndroidMediaMediaFormat, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.c = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    if (!bool) {
      return -2;
    }
    return 0;
  }
  
  int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    int i4 = 2;
    Object localObject3 = SVHwCodec.a("audio/mp4a-latm");
    Object localObject2 = SVHwCodec.a("audio/mp4a-latm", true);
    if ((((List)localObject3).size() <= 0) && (((List)localObject2).size() <= 0)) {
      return -7;
    }
    int i1;
    String str;
    if (((List)localObject2).size() > 0)
    {
      this.this$0.a("audioEncodeInit", " HardCodecSize=" + ((List)localObject2).size());
      i1 = this.this$0.a((List)localObject2, "audio/mp4a-latm");
      if (i1 < 0)
      {
        str = ((MediaCodecInfo)((List)localObject2).get(((List)localObject2).size() - 1)).getName();
        localObject2 = ((MediaCodecInfo)((List)localObject2).get(0)).getCapabilitiesForType("audio/mp4a-latm");
        if ((((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels == null) || (((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels.length <= 0)) {
          break label445;
        }
        i1 = localObject2.profileLevels[0].profile;
      }
    }
    for (;;)
    {
      int i2;
      if (((List)localObject3).size() > 0)
      {
        this.this$0.a("audioEncodeInit", " softCodecSize=" + ((List)localObject3).size());
        i2 = this.this$0.a((List)localObject3, "audio/mp4a-latm");
        if (i2 < 0)
        {
          localObject2 = ((MediaCodecInfo)((List)localObject3).get(0)).getName();
          localObject3 = ((MediaCodecInfo)((List)localObject3).get(0)).getCapabilitiesForType("audio/mp4a-latm");
          localObject1 = localObject2;
          if (((MediaCodecInfo.CodecCapabilities)localObject3).profileLevels == null) {
            break label439;
          }
          localObject1 = localObject2;
          if (((MediaCodecInfo.CodecCapabilities)localObject3).profileLevels.length <= 0) {
            break label439;
          }
          i2 = localObject3.profileLevels[0].profile;
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        label315:
        int i3 = i1;
        if (i1 == -1) {
          i3 = 2;
        }
        if (i2 == -1) {}
        for (i1 = i4;; i1 = i2)
        {
          this.jdField_d_of_type_AndroidMediaMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
          this.jdField_d_of_type_AndroidMediaMediaFormat.setInteger("bitrate", paramInt3);
          this.jdField_b_of_type_JavaLangString = str;
          this.jdField_c_of_type_JavaLangString = ((String)localObject1);
          this.jdField_d_of_type_Int = i3;
          this.jdField_e_of_type_Int = i1;
          return 0;
          str = ((MediaCodecInfo)((List)localObject2).get(i1)).getName();
          i1 = 2;
          break;
          localObject1 = ((MediaCodecInfo)((List)localObject3).get(i2)).getName();
          i2 = 2;
          break label315;
        }
        label439:
        i2 = -1;
      }
      label445:
      i1 = -1;
      continue;
      i1 = -1;
      str = null;
    }
  }
  
  int a(MediaFormat paramMediaFormat, String paramString, int paramInt1, int paramInt2)
  {
    int i4 = 0;
    int i5 = -1;
    List localList = SVHwCodec.a(paramString, true);
    if (localList.size() <= 0) {
      return -6;
    }
    int i1 = 0;
    while (i1 < localList.size())
    {
      this.this$0.a("encodeVideoInit", " codecname=" + ((MediaCodecInfo)localList.get(i1)).getName());
      i1 += 1;
    }
    int i2 = 0;
    int i3;
    Object localObject;
    for (;;)
    {
      i3 = i5;
      i1 = i4;
      if (i2 < localList.size())
      {
        localObject = SVHwCodec.a((MediaCodecInfo)localList.get(i2), paramString);
        if (localObject == null) {
          return -26;
        }
        localObject = ((MediaCodecInfo.CodecCapabilities)localObject).colorFormats;
        i1 = 0;
        while (i1 < localObject.length)
        {
          this.this$0.a("encodeVideoInit", " colorformat=0x" + Integer.toHexString(localObject[i1]));
          i1 += 1;
        }
        if (ArrayUtils.contains((int[])localObject, 21))
        {
          i1 = 21;
          i3 = i2;
        }
      }
      else
      {
        if (i3 >= 0) {
          break label420;
        }
        i2 = 0;
        if (i2 >= localList.size()) {
          break label420;
        }
        localObject = SVHwCodec.a((MediaCodecInfo)localList.get(i2), paramString);
        if (localObject != null) {
          break;
        }
        return -26;
      }
      i2 += 1;
    }
    if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19)) {
      i1 = 19;
    }
    for (;;)
    {
      if ((i1 != 19) && (i1 != 21))
      {
        return -1;
        i2 += 1;
        break;
      }
      if ((i1 == 2130708361) || (i1 == 19)) {
        this.this$0.jdField_a_of_type_Int = 19;
      }
      for (;;)
      {
        paramMediaFormat.setInteger("color-format", i1);
        paramMediaFormat.setInteger("frame-rate", paramInt1);
        paramMediaFormat.setInteger("bitrate", paramInt2);
        paramMediaFormat.setInteger("i-frame-interval", 1);
        this.jdField_a_of_type_JavaLangString = ((MediaCodecInfo)localList.get(i2)).getName();
        return 0;
        if (i1 == 21) {
          this.this$0.jdField_a_of_type_Int = 21;
        }
      }
      label420:
      i2 = i3;
    }
  }
  
  int a(boolean paramBoolean)
  {
    int i1 = 0;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    try
    {
      bool = a(paramBoolean).a();
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.d = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
        if (!bool) {
          i1 = -3;
        }
        return i1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("SVHwEncoder", 2, "Exception", localException);
        }
        boolean bool = false;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.i = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      }
    }
  }
  
  long a()
  {
    long l1;
    if (SVHwEncoder.b(this.this$0)) {
      l1 = this.jdField_n_of_type_Int;
    }
    long l2;
    do
    {
      return l1;
      l2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.b();
      l1 = l2;
    } while (l2 <= this.jdField_n_of_type_Int);
    return this.jdField_n_of_type_Int;
  }
  
  SVHwCodec a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec;
    }
    return this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec;
  }
  
  public SVHwEncoder.HwFrame a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource.a();
  }
  
  public SVHwEncoder.HwFrame a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource.a(paramInt);
  }
  
  String a()
  {
    return this.jdField_e_of_type_JavaLangString + "shortvideo_merge.mp4";
  }
  
  String a(String paramString)
  {
    paramString = paramString + "_qq_hw/";
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString;
  }
  
  void a()
  {
    this.jdField_f_of_type_JavaLangString = (this.jdField_e_of_type_JavaLangString + "shortvideo_seg_" + this.jdField_f_of_type_Int + ".mp4");
    this.jdField_f_of_type_Int += 1;
  }
  
  void a(String paramString)
  {
    this.this$0.a(paramString, ": mExitVideoEncode=" + SVHwEncoder.c(this.this$0) + " mVideoWritedFrameCount=" + this.jdField_h_of_type_Int + " mVideoEncodedframeCount=" + this.jdField_i_of_type_Int + " mVideoMuxeredframeCount=" + this.jdField_j_of_type_Int);
    this.this$0.a(paramString, ": mExitVideoEncode=" + SVHwEncoder.c(this.this$0) + " mAudioWritedFrameCount=" + this.jdField_k_of_type_Int + " mAudioEncodedframeCount=" + this.jdField_l_of_type_Int + " mAudioMuxeredframeCount=" + this.jdField_m_of_type_Int);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramString, paramInt1, paramInt2, paramInt3);
    }
    this.this$0.a("hw_video_callback_msg", "svSegmentOK:path=" + paramString + " index=" + paramInt1 + "width=" + paramInt2 + " height=" + paramInt3 + " mCacellVideoEncode=" + SVHwEncoder.a(this.this$0));
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramString1, paramInt1, paramInt2, paramString2);
    }
    this.this$0.a("hw_video_callback_msg", "svThumbOK:path=" + paramString1 + " md5=" + paramString2 + "width=" + paramInt1 + " height=" + paramInt2 + " mCacellVideoEncode=" + SVHwEncoder.a(this.this$0));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramString, paramInt, paramLong);
    }
    this.this$0.a("hw_video_callback_msg", "svMergeOK:path=" + paramString + " totalTime=" + paramInt + " mergeTime=" + paramLong + " mCacellVideoEncode=" + SVHwEncoder.a(this.this$0));
  }
  
  void a(boolean paramBoolean)
  {
    try
    {
      SVHwCodec localSVHwCodec = a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      localSVHwCodec.b();
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.d = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
        localSVHwCodec.c();
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.f = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
        return;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.i = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.k = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
  }
  
  boolean a(String paramString)
  {
    if (SVHwEncoder.a(this.this$0))
    {
      a(paramString);
      return true;
    }
    if (SVHwEncoder.c(this.this$0))
    {
      int i1 = this.this$0.a(SVHwEncoder.a(this.this$0));
      int i2 = this.this$0.a(SVHwEncoder.b(this.this$0));
      if ((i1 <= 0) && (i2 <= 0))
      {
        a(paramString + "videosize=" + i1 + " audiosize=" + i2);
        return true;
      }
    }
    return false;
  }
  
  boolean a(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
  {
    boolean bool2 = false;
    for (;;)
    {
      SVHwEncoder.HwFrame localHwFrame = this.this$0.a(paramArrayList);
      bool1 = bool2;
      if (localHwFrame == null) {
        return bool1;
      }
      if (!localHwFrame.jdField_a_of_type_Boolean) {
        break;
      }
      this.this$0.a(paramArrayList);
    }
    boolean bool1 = true;
    return bool1;
  }
  
  /* Error */
  boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: getfield 49	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:this$0	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   8: ldc_w 477
    //   11: new 231	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 479
    //   21: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 60	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_a_of_type_Boolean	Z
    //   28: invokevirtual 388	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: ldc_w 481
    //   34: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload_1
    //   38: invokevirtual 388	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: ldc_w 483
    //   44: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokevirtual 248	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: getfield 60	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_a_of_type_Boolean	Z
    //   57: ifeq +98 -> 155
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 60	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_a_of_type_Boolean	Z
    //   65: aload_0
    //   66: iconst_m1
    //   67: putfield 78	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_b_of_type_Int	I
    //   70: aload_0
    //   71: iconst_m1
    //   72: putfield 80	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_c_of_type_Int	I
    //   75: iload_1
    //   76: ifeq +90 -> 166
    //   79: aload_0
    //   80: getfield 96	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   83: invokevirtual 488	android/media/MediaMuxer:stop	()V
    //   86: aload_0
    //   87: getfield 49	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:this$0	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   90: ldc_w 477
    //   93: new 231	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 479
    //   103: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 60	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_a_of_type_Boolean	Z
    //   110: invokevirtual 388	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   113: ldc_w 481
    //   116: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_1
    //   120: invokevirtual 388	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   123: ldc_w 490
    //   126: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 248	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: iload_1
    //   136: ifeq +52 -> 188
    //   139: aload_0
    //   140: getfield 96	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   143: invokevirtual 493	android/media/MediaMuxer:release	()V
    //   146: iload_3
    //   147: istore_1
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 96	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   153: iload_1
    //   154: istore_2
    //   155: iload_2
    //   156: ireturn
    //   157: astore 4
    //   159: aload 4
    //   161: invokevirtual 494	java/lang/IllegalStateException:printStackTrace	()V
    //   164: iconst_1
    //   165: ireturn
    //   166: aload_0
    //   167: getfield 96	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   170: invokevirtual 488	android/media/MediaMuxer:stop	()V
    //   173: goto -87 -> 86
    //   176: astore 4
    //   178: aload 4
    //   180: invokevirtual 494	java/lang/IllegalStateException:printStackTrace	()V
    //   183: iconst_1
    //   184: istore_1
    //   185: goto -37 -> 148
    //   188: aload_0
    //   189: getfield 96	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   192: invokevirtual 493	android/media/MediaMuxer:release	()V
    //   195: iload_3
    //   196: istore_1
    //   197: goto -49 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	HwEncode
    //   0	200	1	paramBoolean	boolean
    //   1	155	2	bool1	boolean
    //   3	193	3	bool2	boolean
    //   157	3	4	localIllegalStateException1	IllegalStateException
    //   176	3	4	localIllegalStateException2	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   79	86	157	java/lang/IllegalStateException
    //   139	146	176	java/lang/IllegalStateException
  }
  
  int b()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    if (this.jdField_c_of_type_JavaLangString != null) {
      this.jdField_d_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", this.jdField_e_of_type_Int);
    }
    for (boolean bool1 = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(this.jdField_d_of_type_AndroidMediaMediaFormat, this.jdField_c_of_type_JavaLangString);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SVHwEncoder", 2, "audioEncodeInit: sfCodecinit error codecNameHw=" + this.jdField_c_of_type_JavaLangString);
        }
        bool2 = bool1;
        if (this.jdField_b_of_type_JavaLangString != null)
        {
          this.jdField_d_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", this.jdField_d_of_type_Int);
          bool2 = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(this.jdField_d_of_type_AndroidMediaMediaFormat, this.jdField_b_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.h = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      if (!bool2) {
        return -8;
      }
      return 0;
    }
  }
  
  long b()
  {
    long l1;
    if (SVHwEncoder.b(this.this$0)) {
      l1 = this.jdField_n_of_type_Int;
    }
    long l2;
    do
    {
      return l1;
      l2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.c();
      l1 = l2;
    } while (l2 <= this.jdField_n_of_type_Int);
    return this.jdField_n_of_type_Int;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.b();
    }
    this.this$0.a("hw_video_callback_msg", "svEncodeBegin mCacellVideoEncode=" + SVHwEncoder.a(this.this$0));
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.b(paramInt);
    }
    this.this$0.a("hw_video_callback_msg", "svEncodeProgress: progress=" + paramInt + " mCacellVideoEncode=" + SVHwEncoder.a(this.this$0));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.b(paramInt1, paramInt2);
    }
    this.this$0.a("hw_video_callback_msg", "svErrorOcured:error=" + paramInt1 + " subcode=" + paramInt2 + " mCacellVideoEncode=" + SVHwEncoder.a(this.this$0));
  }
  
  int c()
  {
    String str = SVHwCodec.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    this.jdField_c_of_type_AndroidMediaMediaFormat = MediaFormat.createVideoFormat(str, SVHwEncoder.c(this.this$0), SVHwEncoder.d(this.this$0));
    int i1 = a(this.jdField_c_of_type_AndroidMediaMediaFormat, str, (int)SVHwEncoder.a(this.this$0), SVHwEncoder.k(this.this$0));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.b = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    if (i1 != 0) {}
    int i2;
    do
    {
      do
      {
        return i1;
      } while (!this.jdField_g_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      i2 = a(SVHwEncoder.h(this.this$0), SVHwEncoder.i(this.this$0), SVHwEncoder.l(this.this$0));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.g = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      i1 = i2;
    } while (i2 == 0);
    return i2;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.c();
    }
    this.this$0.a("hw_video_callback_msg", "svEncodeEnd mCacellVideoEncode=" + SVHwEncoder.a(this.this$0));
  }
  
  int d()
  {
    i();
    int i1 = a();
    if (i1 != 0) {}
    int i2;
    do
    {
      do
      {
        do
        {
          return i1;
          j();
          i2 = a(true);
          i1 = i2;
        } while (i2 != 0);
        i1 = i2;
      } while (!this.jdField_g_of_type_Boolean);
      i2 = b();
      i1 = i2;
    } while (i2 != 0);
    return a(false);
  }
  
  void d()
  {
    if ((this.jdField_f_of_type_Int == 1) && (!SVHwEncoder.b(this.this$0)) && (!this.jdField_m_of_type_Boolean) && (this.jdField_h_of_type_Int >= 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      this.jdField_n_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Long = 0L;
      new SVHwEncoder.HwEncode.HwThumbGenTask(this).execute(new Void[0]);
      this.jdField_m_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.m = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    }
  }
  
  int e()
  {
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("frame-rate", (int)SVHwEncoder.a(this.this$0));
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("bitrate", SVHwEncoder.k(this.this$0));
    this.jdField_a_of_type_AndroidMediaMediaFormat = null;
    int i1 = a();
    if (i1 != 0) {}
    int i2;
    do
    {
      return i1;
      i2 = a(true);
      i1 = i2;
    } while (i2 == 0);
    this.this$0.a("VideoEncodeExit", "err=" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.c();
    return i2;
  }
  
  void e()
  {
    this.jdField_a_of_type_Int = 0;
    if ((this.jdField_n_of_type_Boolean) && (!this.o))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Int == 0) {
        break label163;
      }
      this.jdField_a_of_type_Int = -9;
      b(-9, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Int);
      this.this$0.a("hw_av_merge_segment", "genThumbFile mLastErrCode=" + this.jdField_a_of_type_Int + " subcode=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.this$0.a("hw_video_segment_notify_msg", "svThumbOK:mCallSegmentIndex=" + this.jdField_g_of_type_Int + " mLastErrCode=" + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.l = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Long;
      this.o = true;
      return;
      label163:
      a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_b_of_type_JavaLangString, SVHwEncoder.f(this.this$0), SVHwEncoder.g(this.this$0), this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_JavaLangString);
    }
  }
  
  int f()
  {
    try
    {
      Thread.sleep(300L);
      label6:
      this.jdField_b_of_type_AndroidMediaMediaFormat = null;
      int i1 = b();
      if (i1 != 0) {
        this.this$0.a("audioEncodeInit", "err=" + this.jdField_a_of_type_Int);
      }
      int i2;
      do
      {
        return i1;
        i2 = a(false);
        i1 = i2;
      } while (i2 == 0);
      this.this$0.a("audioEncodeInit", "err=" + this.jdField_a_of_type_Int);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.c();
      return i2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label6;
    }
  }
  
  void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.a("pauseThread", "resumeThread:mHavePaused=" + this.p);
      this.p = false;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  void g()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.a("pauseThread", "pauseThread:mHavePaused=" + this.p);
      if (!this.p) {
        this.p = true;
      }
    }
    try
    {
      this.jdField_a_of_type_JavaLangObject.wait();
      label59:
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label59;
    }
  }
  
  void h()
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    String str = a();
    if (i1 <= 0)
    {
      this.this$0.a("hw_av_merge_segment", "size <= 0");
      return;
    }
    long l1;
    File localFile1;
    File localFile2;
    if (i1 == 1)
    {
      l1 = System.nanoTime();
      this.this$0.a("hw_av_merge_segment", "renameTo.");
      localFile1 = new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      localFile2 = new File(str);
      if (SVHwEncoder.b(this.this$0)) {
        if ((this.jdField_j_of_type_Int <= 0) && (this.jdField_m_of_type_Int <= 0))
        {
          i1 = -2;
          FileUtils.e(localFile1.getAbsolutePath());
          this.this$0.a("hw_av_merge_segment", "[mOnlyGenOneMp4:check]mVideoMuxeredframeCount=" + this.jdField_j_of_type_Int + " mAudioMuxeredframeCount=" + this.jdField_m_of_type_Int);
          l1 = (System.nanoTime() - l1) / 1000L;
        }
      }
    }
    for (;;)
    {
      this.this$0.a("hw_av_merge_segment", "merge mp4 Over error=" + i1);
      if (i1 != 0) {
        break label330;
      }
      a(str, SVHwEncoder.b(this.this$0), l1);
      this.this$0.a("hw_av_merge_segment", "notify merge OK......");
      return;
      if (!localFile1.renameTo(localFile2))
      {
        i1 = -1;
        break;
        FileUtils.a(localFile1, localFile2);
      }
      i1 = 0;
      break;
      l1 = System.nanoTime();
      i1 = SVMp4Merge.a(this.jdField_a_of_type_JavaUtilArrayList, str);
      l1 = (System.nanoTime() - l1) / 1000L;
      this.this$0.a("hw_av_merge_segment", "merge:time=" + l1 + " us");
    }
    label330:
    b(-40, i1);
    FileUtils.a(this.jdField_e_of_type_JavaLangString);
    this.this$0.a("hw_av_merge_segment", "merge error delete cache......");
  }
  
  void i()
  {
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("width", SVHwEncoder.c(this.this$0));
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("height", SVHwEncoder.d(this.this$0));
  }
  
  void j() {}
  
  void k() {}
  
  void l()
  {
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Int = c();
    if (this.jdField_a_of_type_Int != 0)
    {
      this.this$0.a("configHardWareComponent", " err=" + this.jdField_a_of_type_Int);
      b(this.jdField_a_of_type_Int, 0);
      this.jdField_c_of_type_AndroidMediaMediaFormat = null;
      this.jdField_d_of_type_AndroidMediaMediaFormat = null;
      return;
    }
    if ((!SVHwEncoder.b(this.this$0)) && (!Lock.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      boolean bool1;
      synchronized (Lock.jdField_a_of_type_JavaLangObject)
      {
        bool1 = Lock.jdField_a_of_type_Boolean;
        if (bool1) {}
      }
      try
      {
        Lock.jdField_a_of_type_JavaLangObject.wait(1000L);
        if (!SVHwEncoder.c(this.this$0)) {
          continue;
        }
        return;
        localObject2 = finally;
        throw localObject2;
        this.this$0.a("[Lock.CAPTURE_LOCK=true]", "begin to record video......");
        b();
        this.jdField_a_of_type_Int = d();
        if (this.jdField_a_of_type_Int != 0)
        {
          this.this$0.a("initEncodeStatus", " err=" + this.jdField_a_of_type_Int);
          b(this.jdField_a_of_type_Int, 0);
          a(true);
          a(false);
          k();
          return;
        }
        if (SVHwEncoder.b(this.this$0))
        {
          this.jdField_i_of_type_Boolean = true;
          SVHwEncoder.a(this.this$0, SVHwEncoder.a(this.this$0) * 1000 / SVHwEncoder.b(this.this$0));
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a(SVHwEncoder.a(this.this$0));
          this.this$0.a("HwEncodeHelper:mOnlyGenOneMp4", "mTotalFrames=" + SVHwEncoder.a(this.this$0) + " mTotalTimes=" + SVHwEncoder.b(this.this$0) + " mVideoFps=" + SVHwEncoder.a(this.this$0));
        }
        if (SVHwEncoder.a(this.this$0))
        {
          label367:
          a(true);
          a(false);
          k();
          this.this$0.a("hw_video_time_used_msg", "HwTimeUsed_End=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.toString());
          this.this$0.a("hw_av_merge_segment", "release resource ok......");
          if (this.jdField_a_of_type_Int == 0) {
            break label5226;
          }
          this.this$0.a("hw_av_merge_segment", "mLastErrCode=" + this.jdField_a_of_type_Int);
          SVHwEncoder.a(this.this$0, true);
          a(true);
          label485:
          if (!SVHwEncoder.a(this.this$0)) {
            break label5233;
          }
          this.this$0.a("hw_av_merge_segment", "clear cache mCacellVideoEncode=" + SVHwEncoder.a(this.this$0));
          FileUtils.a(this.jdField_e_of_type_JavaLangString);
        }
        for (;;)
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify = null;
            this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource = null;
            SVHwEncoder.c(this.this$0).clear();
            SVHwEncoder.a(this.this$0).clear();
            SVHwEncoder.b(this.this$0).clear();
            SVHwEncoder.a(this.this$0, null);
            SVHwEncoder.b(this.this$0, null);
            SVHwEncoder.c(this.this$0, null);
            this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a();
            this.jdField_g_of_type_Int = 0;
            return;
            Object localObject3 = null;
            ??? = localObject3;
            if (!SVHwEncoder.b(this.this$0))
            {
              ??? = localObject3;
              if (!this.jdField_b_of_type_Boolean) {
                ??? = this.this$0.a(SVHwEncoder.a(this.this$0));
              }
            }
            this.this$0.a("hw_video_write_frame", "mVideoSourceDone=" + this.jdField_b_of_type_Boolean + " mDataSource=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource);
            this.this$0.a("hw_video_write_frame", "mMuxerCreated=" + this.jdField_a_of_type_Boolean + " encoderOutputVideoFormat=" + this.jdField_a_of_type_AndroidMediaMediaFormat);
            if (((??? != null) || ((SVHwEncoder.b(this.this$0)) && (!this.jdField_b_of_type_Boolean))) && ((this.jdField_a_of_type_AndroidMediaMediaFormat == null) || (this.jdField_a_of_type_Boolean))) {}
            label865:
            label1020:
            int i1;
            label1506:
            int i2;
            for (;;)
            {
              try
              {
                l1 = a();
                this.this$0.a("hw_video_timestamp", "videotimeout=" + l1);
                localBufferData = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(l1);
                if ((localBufferData != null) && (localBufferData.jdField_a_of_type_Int != -1)) {
                  break label1506;
                }
                this.this$0.a("hw_video_write_frame", "INFO_TRY_AGAIN_LATER");
                localObject3 = null;
                ??? = localObject3;
                if (!SVHwEncoder.b(this.this$0))
                {
                  ??? = localObject3;
                  if (!this.jdField_c_of_type_Boolean) {
                    ??? = this.this$0.a(SVHwEncoder.b(this.this$0));
                  }
                }
                if ((??? != null) || ((SVHwEncoder.b(this.this$0)) && (!this.jdField_c_of_type_Boolean))) {
                  if (this.jdField_b_of_type_AndroidMediaMediaFormat != null) {
                    if (!this.jdField_a_of_type_Boolean) {
                      continue;
                    }
                  }
                }
              }
              catch (IllegalStateException localIllegalStateException1)
              {
                for (;;)
                {
                  SVHwCodec.BufferData localBufferData;
                  try
                  {
                    l1 = b();
                    this.this$0.a("hw_audio_timestamp", "audiotimeout=" + l1);
                    localBufferData = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(l1);
                    if ((localBufferData == null) || (localBufferData.jdField_a_of_type_Int == -1))
                    {
                      this.this$0.a("hw_audio_write_frame", "INFO_TRY_AGAIN_LATER");
                      if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.jdField_j_of_type_Boolean) && (!SVHwEncoder.b(this.this$0)))
                      {
                        this.this$0.a("hw_smooth_time_stamp", "mUpdateVideoFps=" + this.jdField_j_of_type_Boolean + " mVideoFps=" + SVHwEncoder.a(this.this$0));
                        this.jdField_j_of_type_Boolean = false;
                        this.jdField_i_of_type_Boolean = true;
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a();
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a(SVHwEncoder.a(this.this$0));
                      }
                      if ((this.jdField_l_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
                        if (this.jdField_a_of_type_AndroidMediaMediaFormat != null) {
                          if (!this.jdField_a_of_type_Boolean) {
                            continue;
                          }
                        }
                      }
                    }
                  }
                  catch (IllegalStateException localIllegalStateException3)
                  {
                    SVHwEncoder.HwEncode.IntelX86Error localIntelX86Error1;
                    localIllegalStateException3.printStackTrace();
                    this.jdField_a_of_type_Int = -18;
                    b(this.jdField_a_of_type_Int, 0);
                  }
                  try
                  {
                    l1 = a();
                    this.this$0.a("hw_video_encode_frame", "videoOutTime=" + l1);
                    ??? = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.b(l1);
                    if (??? == null)
                    {
                      this.this$0.a("hw_video_encode_frame", "encoderOutputBuffer=null");
                      if ((this.jdField_l_of_type_Boolean) && (!this.jdField_e_of_type_Boolean)) {
                        if (this.jdField_b_of_type_AndroidMediaMediaFormat != null) {
                          if (!this.jdField_a_of_type_Boolean) {
                            continue;
                          }
                        }
                      }
                    }
                  }
                  catch (IllegalStateException localIllegalStateException5)
                  {
                    SVHwEncoder.HwEncode.IntelX86Error localIntelX86Error2;
                    int i3;
                    float f1;
                    localIllegalStateException5.printStackTrace();
                    this.jdField_a_of_type_Int = -23;
                    b(this.jdField_a_of_type_Int, 0);
                  }
                  try
                  {
                    l1 = b();
                    this.this$0.a("hw_audio_encode_frame", "audioOutTime=" + l1);
                    ??? = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.b(l1);
                    if (??? != null) {
                      break label3496;
                    }
                    this.this$0.a("hw_audio_encode_frame", "encoderOutputBuffer=null");
                    if ((SVHwEncoder.b(this.this$0)) && (!this.jdField_h_of_type_Boolean))
                    {
                      i1 = this.jdField_i_of_type_Int * 100 / SVHwEncoder.a(this.this$0);
                      b(i1);
                      if (i1 >= 100) {
                        this.jdField_h_of_type_Boolean = true;
                      }
                    }
                    if (SVHwEncoder.d(this.this$0)) {
                      g();
                    }
                    d();
                    e();
                    if (this.jdField_a_of_type_Int != 0) {
                      break;
                    }
                    if ((!this.jdField_d_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
                      break label4407;
                    }
                    bool1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.c();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.a();
                    if (bool1) {
                      break label3920;
                    }
                    this.this$0.a("releaseMuxer[check]", "validSegment=" + bool1);
                    this.jdField_a_of_type_Int = -14;
                    b(this.jdField_a_of_type_Int, 0);
                  }
                  catch (IllegalStateException localIllegalStateException6)
                  {
                    localIllegalStateException6.printStackTrace();
                    this.jdField_a_of_type_Int = -22;
                    b(this.jdField_a_of_type_Int, 0);
                  }
                }
                localIllegalStateException1 = localIllegalStateException1;
                localIllegalStateException1.printStackTrace();
                this.jdField_a_of_type_Int = -19;
                b(this.jdField_a_of_type_Int, 0);
              }
              break;
              if (localBufferData.jdField_a_of_type_JavaNioByteBuffer == null)
              {
                localIntelX86Error1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error;
                localIntelX86Error1.jdField_a_of_type_Int += 1;
                this.this$0.a("hw_intel_x86__err_msg", "INFO_TRY_AGAIN_LATER: buffer = null mVideoBuferErrCount=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_a_of_type_Int);
                if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_a_of_type_Int < 3) {
                  continue;
                }
                this.jdField_a_of_type_Int = -21;
                b(this.jdField_a_of_type_Int, 0);
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_a_of_type_Int = 0;
              localObject3 = localIntelX86Error1;
              if (SVHwEncoder.b(this.this$0))
              {
                localObject3 = localIntelX86Error1;
                if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource != null) {
                  localObject3 = a(this.this$0.jdField_a_of_type_Int);
                }
              }
              if (!((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Boolean)
              {
                localBufferData.jdField_a_of_type_JavaNioByteBuffer.clear();
                i1 = localBufferData.jdField_a_of_type_JavaNioByteBuffer.capacity();
                i2 = ((SVHwEncoder.HwFrame)localObject3).jdField_b_of_type_Int - ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int;
                if (i1 >= i2)
                {
                  localBufferData.jdField_a_of_type_JavaNioByteBuffer.put(((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_ArrayOfByte, ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int, i2);
                  ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int += i2;
                  l2 = 1000L * ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Long;
                  if (!this.jdField_i_of_type_Boolean) {
                    break label5265;
                  }
                  l1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a(((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Long);
                  this.this$0.a("hw_video_timestamp", "oldTime=" + l2 + " frameTime=" + l1);
                }
              }
              label2217:
              for (;;)
              {
                try
                {
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localBufferData, ((SVHwEncoder.HwFrame)localObject3).jdField_b_of_type_Int, l1, 0);
                  this.jdField_h_of_type_Int += 1;
                  this.this$0.a("hw_video_write_frame", "mVideoWritedFrameCount=" + this.jdField_h_of_type_Int);
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a(true);
                  if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource != null) || (((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int != ((SVHwEncoder.HwFrame)localObject3).jdField_b_of_type_Int)) {
                    break label865;
                  }
                  this.this$0.a(SVHwEncoder.a(this.this$0));
                  if (this.this$0.a((SVHwEncoder.HwFrame)localObject3)) {
                    break label865;
                  }
                  ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_ArrayOfByte = null;
                }
                catch (IllegalStateException localIllegalStateException2)
                {
                  localIllegalStateException2.printStackTrace();
                  this.jdField_a_of_type_Int = -17;
                  b(this.jdField_a_of_type_Int, 0);
                }
                this.jdField_a_of_type_Int = -12;
                b(this.jdField_a_of_type_Int, 0);
                break;
                break;
                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localBufferData, 0, 0L, 4);
                this.jdField_b_of_type_Boolean = true;
                this.this$0.a("hw_video_write_frame", "[end-of-stream] fps=" + ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Float + " bitrate" + ((SVHwEncoder.HwFrame)localObject3).jdField_c_of_type_Int);
                if ((((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Float > 0.0F) && (!SVHwEncoder.b(this.this$0)))
                {
                  this.this$0.a("hw_smooth_time_stamp", "mNeedDoSmooth=" + this.jdField_i_of_type_Boolean + " mUpdateVideoFps=" + this.jdField_j_of_type_Boolean + " mVideoFps=" + SVHwEncoder.a(this.this$0));
                  SVHwEncoder.a(this.this$0, ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Float);
                  if (!this.jdField_i_of_type_Boolean) {
                    break label2149;
                  }
                }
                for (;;)
                {
                  if (((SVHwEncoder.HwFrame)localObject3).jdField_c_of_type_Int <= 0) {
                    break label2217;
                  }
                  SVHwEncoder.a(this.this$0, ((SVHwEncoder.HwFrame)localObject3).jdField_c_of_type_Int);
                  break;
                  label2149:
                  this.jdField_j_of_type_Boolean = true;
                  this.this$0.a("hw_smooth_time_stamp", "mNeedDoSmooth=" + this.jdField_i_of_type_Boolean + " mUpdateVideoFps=" + this.jdField_j_of_type_Boolean + " mVideoFps=" + SVHwEncoder.a(this.this$0));
                }
              }
              break;
              if (localBufferData.jdField_a_of_type_JavaNioByteBuffer == null)
              {
                localIntelX86Error2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error;
                localIntelX86Error2.jdField_b_of_type_Int += 1;
                this.this$0.a("hw_intel_x86__err_msg", "INFO_TRY_AGAIN_LATER: buffer=null mAudioBuferErrCount=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_b_of_type_Int);
                if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_b_of_type_Int < 3) {
                  continue;
                }
                this.jdField_a_of_type_Int = -20;
                b(this.jdField_a_of_type_Int, 0);
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_b_of_type_Int = 0;
              localObject3 = localIntelX86Error2;
              if (SVHwEncoder.b(this.this$0))
              {
                localObject3 = localIntelX86Error2;
                if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource != null) {
                  localObject3 = a();
                }
              }
              if (!((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Boolean)
              {
                localBufferData.jdField_a_of_type_JavaNioByteBuffer.clear();
                i2 = localBufferData.jdField_a_of_type_JavaNioByteBuffer.capacity();
                i3 = ((SVHwEncoder.HwFrame)localObject3).jdField_b_of_type_Int - ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int;
                if (i2 >= i3)
                {
                  localBufferData.jdField_a_of_type_JavaNioByteBuffer.put(((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_ArrayOfByte, ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int, i3);
                  ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int += i3;
                  i1 = i3;
                  label2456:
                  this.this$0.a("hw_audio_write_frame", "offset=" + ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int + " size=" + ((SVHwEncoder.HwFrame)localObject3).jdField_b_of_type_Int + " audiovalidSize=" + i3);
                  this.this$0.a("hw_audio_write_frame", "audiocapacity=" + i2 + " writedByte=" + i1);
                  l2 = 1000L * ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Long;
                  if (!this.jdField_i_of_type_Boolean) {
                    break label5258;
                  }
                  f1 = a(i1);
                  l1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a(f1);
                  this.this$0.a("hw_audio_timestamp", "oldTime=" + l2 + " frameTime=" + l1);
                }
              }
              for (;;)
              {
                try
                {
                  this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localBufferData, i1, l1, 0);
                  this.jdField_k_of_type_Int += 1;
                  this.this$0.a("hw_audio_write_frame", "mWritedFrameCount=" + this.jdField_k_of_type_Int);
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a(false);
                  if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource != null) || (((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int != ((SVHwEncoder.HwFrame)localObject3).jdField_b_of_type_Int)) {
                    break label1020;
                  }
                  this.this$0.a(SVHwEncoder.b(this.this$0));
                  ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_ArrayOfByte = null;
                }
                catch (IllegalStateException localIllegalStateException4)
                {
                  this.this$0.a("hw_audio_timestamp", "offset=" + ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int + " size=" + ((SVHwEncoder.HwFrame)localObject3).jdField_b_of_type_Int + " audiovalidSize=" + i3);
                  this.this$0.a("hw_audio_timestamp", "audiocapacity=" + i2 + " writedByte=" + i1);
                  localIllegalStateException4.printStackTrace();
                  this.jdField_a_of_type_Int = -16;
                  b(this.jdField_a_of_type_Int, 0);
                }
                localBufferData.jdField_a_of_type_JavaNioByteBuffer.put(((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_ArrayOfByte, ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int, i2);
                ((SVHwEncoder.HwFrame)localObject3).jdField_a_of_type_Int += i2;
                i1 = i2;
                break label2456;
                break;
                this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localBufferData, 0, 0L, 4);
                this.jdField_c_of_type_Boolean = true;
                this.this$0.a("hw_audio_write_frame", "mWritedFrameCount=" + this.jdField_k_of_type_Int + " [Finish]...");
              }
              break;
              localObject3 = localIllegalStateException5.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
              i1 = localIllegalStateException5.jdField_a_of_type_Int;
              if (i1 == -1)
              {
                this.this$0.a("hw_video_encode_frame", "try later");
              }
              else if (i1 == -3)
              {
                this.this$0.a("hw_video_encode_frame", "output buffers changed");
              }
              else if (i1 == -2)
              {
                this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a().getOutputFormat();
                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.a(this.jdField_a_of_type_AndroidMediaMediaFormat);
                this.this$0.a("hw_video_encode_frame", "out format changed");
              }
              else if ((((MediaCodec.BufferInfo)localObject3).flags & 0x2) != 0)
              {
                this.this$0.a("hw_video_encode_frame", "get Config data...");
                this.this$0.a(localIllegalStateException5.jdField_a_of_type_JavaNioByteBuffer, (MediaCodec.BufferInfo)localObject3, "mVideoEncoder_dequeueOutputBuffer", 30);
                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localIllegalStateException5);
              }
              else
              {
                this.this$0.a("hw_video_encode_frame", "writedata size=" + ((MediaCodec.BufferInfo)localObject3).size);
                if (((MediaCodec.BufferInfo)localObject3).size != 0)
                {
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.b(true);
                  this.jdField_i_of_type_Int += 1;
                  if (this.jdField_a_of_type_AndroidMediaMediaMuxer == null) {
                    break label3455;
                  }
                  if ((((MediaCodec.BufferInfo)localObject3).flags & 0x1) != 0)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.jdField_a_of_type_Boolean = true;
                    if (this.jdField_j_of_type_Int == 0) {
                      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.jdField_c_of_type_Boolean = true;
                    }
                  }
                  if (this.jdField_j_of_type_Int == 0)
                  {
                    if (this.jdField_m_of_type_Int != 0) {
                      break label3406;
                    }
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.jdField_b_of_type_Boolean = true;
                  }
                  label3262:
                  this.jdField_j_of_type_Int += 1;
                  this.this$0.a("hw_video_writesample", "track=" + this.jdField_b_of_type_Int + " pts=" + ((MediaCodec.BufferInfo)localObject3).presentationTimeUs);
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.a(((MediaCodec.BufferInfo)localObject3).presentationTimeUs, true);
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
                }
                for (;;)
                {
                  try
                  {
                    this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_b_of_type_Int, localIllegalStateException5.jdField_a_of_type_JavaNioByteBuffer, (MediaCodec.BufferInfo)localObject3);
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.c(true);
                    if ((((MediaCodec.BufferInfo)localObject3).flags & 0x4) != 0)
                    {
                      this.jdField_d_of_type_Boolean = true;
                      this.this$0.a("hw_video_encode_frame", "end of stream");
                    }
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localIllegalStateException5);
                  }
                  catch (Throwable localThrowable1)
                  {
                    label3406:
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of video erro", localThrowable1);
                    this.jdField_a_of_type_Int = -25;
                    b(this.jdField_a_of_type_Int, 0);
                  }
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.jdField_b_of_type_Boolean = false;
                  break label3262;
                  break;
                  label3455:
                  this.this$0.a("hw_video_encode_frame", "video encoder:muxer is null");
                }
                break;
                label3496:
                localObject3 = localIllegalStateException6.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
                i1 = localIllegalStateException6.jdField_a_of_type_Int;
                if (i1 == -1)
                {
                  this.this$0.a("hw_audio_encode_frame", "try later");
                }
                else if (i1 == -3)
                {
                  this.this$0.a("hw_audio_encode_frame", "out buffer change");
                }
                else if (i1 == -2)
                {
                  this.jdField_b_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a().getOutputFormat();
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.b(this.jdField_b_of_type_AndroidMediaMediaFormat);
                  this.this$0.a("hw_audio_encode_frame", "out format change");
                }
                else
                {
                  if ((((MediaCodec.BufferInfo)localObject3).flags & 0x2) == 0) {
                    break label3653;
                  }
                  this.this$0.a("hw_audio_encode_frame", "get config......");
                  this.this$0.a(localIllegalStateException6.jdField_a_of_type_JavaNioByteBuffer, (MediaCodec.BufferInfo)localObject3, "mAudioEncoder_dequeueOutputBuffer", 10);
                  this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localIllegalStateException6);
                }
              }
            }
            label3653:
            this.this$0.a("hw_audio_encode_frame", "writedata size=" + ((MediaCodec.BufferInfo)localObject3).size);
            if (((MediaCodec.BufferInfo)localObject3).size != 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.b(false);
              this.jdField_l_of_type_Int += 1;
              if (this.jdField_a_of_type_AndroidMediaMediaMuxer == null) {
                break label3904;
              }
              this.jdField_m_of_type_Int += 1;
              this.this$0.a("hw_audio_writesample", "track=" + this.jdField_c_of_type_Int + " pts=" + ((MediaCodec.BufferInfo)localObject3).presentationTimeUs);
              if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.a(((MediaCodec.BufferInfo)localObject3).presentationTimeUs, false)) {
                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
              }
            }
            for (;;)
            {
              try
              {
                this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_c_of_type_Int, localIllegalStateException6.jdField_a_of_type_JavaNioByteBuffer, (MediaCodec.BufferInfo)localObject3);
                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.c(false);
                if ((((MediaCodec.BufferInfo)localObject3).flags & 0x4) != 0)
                {
                  this.jdField_e_of_type_Boolean = true;
                  this.this$0.a("hw_audio_encode_frame", "end of stream");
                }
                this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localIllegalStateException6);
              }
              catch (Throwable localThrowable2)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of audio erro", localThrowable2);
                }
                this.jdField_a_of_type_Int = -24;
                b(this.jdField_a_of_type_Int, 0);
              }
              break;
              label3904:
              this.this$0.a("hw_audio_encode_frame", "muxer is null");
            }
            label3920:
            if (a(true))
            {
              this.jdField_a_of_type_Int = -14;
              b(this.jdField_a_of_type_Int, 1);
              break label367;
            }
            if (this.o)
            {
              if (this.jdField_g_of_type_Int + 1 < this.jdField_f_of_type_Int)
              {
                if (this.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_f_of_type_Int - 1)
                {
                  this.jdField_a_of_type_Int = -15;
                  b(this.jdField_a_of_type_Int, 0);
                  break label367;
                }
                i1 = 0;
                while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
                {
                  this.this$0.a("hw_video_segment_notify_msg", "svSegmentOK:[roll] i=" + i1 + " mCallSegmentIndex=" + this.jdField_g_of_type_Int);
                  a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1), i1 + 1, SVHwEncoder.c(this.this$0), SVHwEncoder.d(this.this$0));
                  this.jdField_g_of_type_Int += 1;
                  i1 += 1;
                }
              }
              this.this$0.a("hw_video_segment_notify_msg", "svSegmentOK:[new]mCallSegmentIndex=" + this.jdField_g_of_type_Int);
              a(this.jdField_f_of_type_JavaLangString, this.jdField_f_of_type_Int, SVHwEncoder.c(this.this$0), SVHwEncoder.d(this.this$0));
              this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_f_of_type_JavaLangString);
              this.jdField_g_of_type_Int += 1;
            }
            for (;;)
            {
              if ((SVHwEncoder.b(this.this$0)) || (a("VideoEncodeExit[one]"))) {
                break label4345;
              }
              a(true);
              a(false);
              this.this$0.a("hw_video_time_used_msg", "HwTimeUsed=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.toString());
              a();
              this.jdField_a_of_type_Int = e();
              if (this.jdField_a_of_type_Int == 0) {
                break label4347;
              }
              b(this.jdField_a_of_type_Int, 0);
              break;
              this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_f_of_type_JavaLangString);
              this.this$0.a("hw_video_segment_notify_msg", "mHasCallSVThumbOk=" + this.o + " size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
            }
            label4345:
            break label367;
            label4347:
            if (this.jdField_g_of_type_Boolean)
            {
              this.jdField_a_of_type_Int = f();
              if (this.jdField_a_of_type_Int != 0)
              {
                b(this.jdField_a_of_type_Int, 0);
                break label367;
              }
            }
            this.jdField_d_of_type_Boolean = false;
            if (this.jdField_g_of_type_Boolean) {
              this.jdField_e_of_type_Boolean = false;
            }
            l();
            this.jdField_k_of_type_Boolean = true;
            label4407:
            if (this.jdField_k_of_type_Boolean)
            {
              if (a("VideoEncodeExit[two]")) {
                break label367;
              }
              bool1 = false;
              boolean bool2 = a(SVHwEncoder.a(this.this$0));
              if (this.jdField_g_of_type_Boolean) {
                bool1 = a(SVHwEncoder.b(this.this$0));
              }
              if (SVHwEncoder.c(this.this$0))
              {
                if (!bool2) {
                  this.jdField_f_of_type_Boolean = false;
                }
                if (!bool1) {
                  this.jdField_g_of_type_Boolean = false;
                }
                if ((!this.jdField_f_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
                {
                  a("VideoEncodeExit[Four]startVideo=" + bool2 + " startAudio=" + bool1);
                  break label367;
                }
              }
              if (!this.jdField_f_of_type_Boolean)
              {
                bool2 = true;
                this.jdField_d_of_type_Boolean = true;
                this.jdField_a_of_type_AndroidMediaMediaFormat = null;
              }
              if (!this.jdField_g_of_type_Boolean)
              {
                bool1 = true;
                this.jdField_e_of_type_Boolean = true;
                this.jdField_b_of_type_AndroidMediaMediaFormat = null;
              }
              if ((bool2) && (bool1))
              {
                this.jdField_b_of_type_Boolean = false;
                this.jdField_c_of_type_Boolean = false;
                this.jdField_l_of_type_Boolean = true;
                this.jdField_k_of_type_Boolean = false;
                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.a("releaseMuxer[mEnableEncode=true]");
                this.this$0.a("hw_video_writesample", "track=" + this.jdField_b_of_type_Int);
                this.this$0.a("hw_audio_writesample", "track=" + this.jdField_c_of_type_Int);
                this.this$0.a("hw_video_timestamp", "new segment");
                this.this$0.a("hw_audio_timestamp", "new segment");
                label4715:
                if ((this.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_AndroidMediaMediaFormat == null) && (this.jdField_f_of_type_Boolean)) || ((this.jdField_b_of_type_AndroidMediaMediaFormat == null) && (this.jdField_g_of_type_Boolean))) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
              }
            }
            try
            {
              this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.jdField_f_of_type_JavaLangString, 0);
              this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(SVHwEncoder.e(this.this$0));
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.n = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
              if (this.jdField_a_of_type_Int != 0)
              {
                b(this.jdField_a_of_type_Int, 0);
                break label367;
                this.jdField_l_of_type_Boolean = false;
                break label4715;
                if (!SVHwEncoder.c(this.this$0)) {
                  break label4715;
                }
                i1 = 0;
                i2 = this.this$0.a(SVHwEncoder.a(this.this$0));
                if (this.jdField_g_of_type_Boolean) {
                  i1 = this.this$0.a(SVHwEncoder.b(this.this$0));
                }
                a("VideoEncodeExit[three]videoSize=" + i2 + " audioSize=" + i1);
                if (((i2 > 0) || (i1 > 0)) && ((!this.jdField_g_of_type_Boolean) || (i1 > 0) || (!this.jdField_d_of_type_Boolean) || (i2 > 3))) {
                  break label4715;
                }
                if (i2 > 0)
                {
                  this.this$0.a("VideoEncodeExit[three]", "videoSize=" + i2 + " mVideoEncodeDone=" + this.jdField_d_of_type_Boolean);
                  this.this$0.b(SVHwEncoder.a(this.this$0));
                }
                a("VideoEncodeExit[three]");
                this.this$0.d();
              }
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                localIOException.printStackTrace();
                this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
                this.jdField_a_of_type_Boolean = false;
                this.jdField_a_of_type_Int = -11;
              }
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
              if (this.jdField_a_of_type_AndroidMediaMediaFormat != null)
              {
                this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_AndroidMediaMediaFormat);
                this.this$0.a("hw_media_muxer_seg", "adding video track:outputVideoTrack=" + this.jdField_b_of_type_Int);
              }
              if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
              {
                this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_b_of_type_AndroidMediaMediaFormat);
                this.this$0.a("hw_media_muxer_seg", " adding audio track:outputAudioTrack=" + this.jdField_c_of_type_Int);
              }
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.o = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
              this.this$0.a("hw_media_muxer_seg", "starting......");
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
              this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.p = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
              this.jdField_a_of_type_Boolean = true;
            }
          }
          break;
          label5226:
          c();
          break label485;
          label5233:
          this.this$0.a("hw_av_merge_segment", "begin merge segments.");
          h();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          long l2;
          continue;
          label5258:
          long l1 = l2;
          continue;
          label5265:
          l1 = l2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode
 * JD-Core Version:    0.7.0.1
 */