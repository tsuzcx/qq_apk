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
    c();
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
    SVHwEncoder.HwEncode.HwTimeTool localHwTimeTool = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
    localHwTimeTool.c = localHwTimeTool.a();
    if (!bool) {
      return -2;
    }
    return 0;
  }
  
  int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject4 = SVHwCodec.a("audio/mp4a-latm");
    Object localObject1 = SVHwCodec.a("audio/mp4a-latm", true);
    if ((((List)localObject4).size() <= 0) && (((List)localObject1).size() <= 0)) {
      return -7;
    }
    int i1 = ((List)localObject1).size();
    Object localObject3 = null;
    if (i1 > 0)
    {
      localObject2 = this.this$0;
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(" HardCodecSize=");
      ((StringBuilder)localObject5).append(((List)localObject1).size());
      ((SVHwEncoder)localObject2).a("audioEncodeInit", ((StringBuilder)localObject5).toString());
      i1 = this.this$0.a((List)localObject1, "audio/mp4a-latm");
      if (i1 < 0)
      {
        localObject2 = ((MediaCodecInfo)((List)localObject1).get(((List)localObject1).size() - 1)).getName();
        localObject5 = ((MediaCodecInfo)((List)localObject1).get(0)).getCapabilitiesForType("audio/mp4a-latm");
        localObject1 = localObject2;
        if (((MediaCodecInfo.CodecCapabilities)localObject5).profileLevels != null)
        {
          localObject1 = localObject2;
          if (((MediaCodecInfo.CodecCapabilities)localObject5).profileLevels.length > 0)
          {
            i1 = localObject5.profileLevels[0].profile;
            localObject1 = localObject2;
            break label236;
          }
        }
      }
      else
      {
        localObject1 = ((MediaCodecInfo)((List)localObject1).get(i1)).getName();
        i1 = 2;
        break label236;
      }
    }
    else
    {
      localObject1 = null;
    }
    i1 = -1;
    label236:
    Object localObject2 = localObject3;
    if (((List)localObject4).size() > 0)
    {
      localObject2 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" softCodecSize=");
      ((StringBuilder)localObject3).append(((List)localObject4).size());
      ((SVHwEncoder)localObject2).a("audioEncodeInit", ((StringBuilder)localObject3).toString());
      i2 = this.this$0.a((List)localObject4, "audio/mp4a-latm");
      if (i2 < 0)
      {
        localObject3 = ((MediaCodecInfo)((List)localObject4).get(0)).getName();
        localObject4 = ((MediaCodecInfo)((List)localObject4).get(0)).getCapabilitiesForType("audio/mp4a-latm");
        localObject2 = localObject3;
        if (((MediaCodecInfo.CodecCapabilities)localObject4).profileLevels != null)
        {
          localObject2 = localObject3;
          if (((MediaCodecInfo.CodecCapabilities)localObject4).profileLevels.length > 0)
          {
            i2 = localObject4.profileLevels[0].profile;
            localObject2 = localObject3;
            break label421;
          }
        }
      }
      else
      {
        localObject2 = ((MediaCodecInfo)((List)localObject4).get(i2)).getName();
        i2 = 2;
        break label421;
      }
    }
    int i2 = -1;
    label421:
    int i3 = i1;
    if (i1 == -1) {
      i3 = 2;
    }
    i1 = i2;
    if (i2 == -1) {
      i1 = 2;
    }
    this.jdField_d_of_type_AndroidMediaMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
    this.jdField_d_of_type_AndroidMediaMediaFormat.setInteger("bitrate", paramInt3);
    this.jdField_b_of_type_JavaLangString = ((String)localObject1);
    this.jdField_c_of_type_JavaLangString = ((String)localObject2);
    this.jdField_d_of_type_Int = i3;
    this.jdField_e_of_type_Int = i1;
    return 0;
  }
  
  int a(MediaFormat paramMediaFormat, String paramString, int paramInt1, int paramInt2)
  {
    List localList = SVHwCodec.a(paramString, true);
    if (localList.size() <= 0) {
      return -6;
    }
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    while (i1 < localList.size())
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" codecname=");
      ((StringBuilder)localObject2).append(((MediaCodecInfo)localList.get(i1)).getName());
      ((SVHwEncoder)localObject1).a("encodeVideoInit", ((StringBuilder)localObject2).toString());
      i1 += 1;
    }
    int i2 = 0;
    while (i2 < localList.size())
    {
      localObject1 = SVHwCodec.a((MediaCodecInfo)localList.get(i2), paramString);
      if (localObject1 == null) {
        return -26;
      }
      localObject1 = ((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats;
      i1 = 0;
      while (i1 < localObject1.length)
      {
        localObject2 = this.this$0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" colorformat=0x");
        localStringBuilder.append(Integer.toHexString(localObject1[i1]));
        ((SVHwEncoder)localObject2).a("encodeVideoInit", localStringBuilder.toString());
        i1 += 1;
      }
      if (ArrayUtils.contains((int[])localObject1, 21))
      {
        i1 = 21;
        break label253;
      }
      i2 += 1;
    }
    i2 = -1;
    i1 = 0;
    label253:
    if (i2 < 0)
    {
      i3 = 0;
      while (i3 < localList.size())
      {
        localObject1 = SVHwCodec.a((MediaCodecInfo)localList.get(i3), paramString);
        if (localObject1 == null) {
          return -26;
        }
        if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats, 19))
        {
          i1 = 19;
          break label332;
        }
        i3 += 1;
      }
    }
    int i3 = i2;
    label332:
    if ((i1 != 19) && (i1 != 21)) {
      return -1;
    }
    if ((i1 != 2130708361) && (i1 != 19))
    {
      if (i1 == 21) {
        this.this$0.jdField_a_of_type_Int = 21;
      }
    }
    else {
      this.this$0.jdField_a_of_type_Int = 19;
    }
    paramMediaFormat.setInteger("color-format", i1);
    paramMediaFormat.setInteger("frame-rate", paramInt1);
    paramMediaFormat.setInteger("bitrate", paramInt2);
    paramMediaFormat.setInteger("i-frame-interval", 1);
    this.jdField_a_of_type_JavaLangString = ((MediaCodecInfo)localList.get(i3)).getName();
    return 0;
  }
  
  int a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    boolean bool;
    try
    {
      bool = a(paramBoolean).a();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("SVHwEncoder", 2, "Exception", localException);
      }
      bool = false;
    }
    SVHwEncoder.HwEncode.HwTimeTool localHwTimeTool;
    if (paramBoolean)
    {
      localHwTimeTool = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
      localHwTimeTool.d = localHwTimeTool.a();
    }
    else
    {
      localHwTimeTool = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
      localHwTimeTool.i = localHwTimeTool.a();
    }
    if (!bool) {
      return -3;
    }
    return 0;
  }
  
  long a()
  {
    if (SVHwEncoder.b(this.this$0)) {
      return this.jdField_n_of_type_Int;
    }
    long l2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.b();
    int i1 = this.jdField_n_of_type_Int;
    long l1 = l2;
    if (l2 > i1) {
      l1 = i1;
    }
    return l1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("shortvideo_merge.mp4");
    return localStringBuilder.toString();
  }
  
  String a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_qq_hw/");
    paramString = ((StringBuilder)localObject).toString();
    localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramString;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a();
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svEncodeBegin mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramInt);
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svEncodeProgress: progress=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
  }
  
  void a(String paramString)
  {
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(": mExitVideoEncode=");
    localStringBuilder.append(SVHwEncoder.c(this.this$0));
    localStringBuilder.append(" mVideoWritedFrameCount=");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append(" mVideoEncodedframeCount=");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append(" mVideoMuxeredframeCount=");
    localStringBuilder.append(this.jdField_j_of_type_Int);
    localSVHwEncoder.a(paramString, localStringBuilder.toString());
    localSVHwEncoder = this.this$0;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(": mExitVideoEncode=");
    localStringBuilder.append(SVHwEncoder.c(this.this$0));
    localStringBuilder.append(" mAudioWritedFrameCount=");
    localStringBuilder.append(this.jdField_k_of_type_Int);
    localStringBuilder.append(" mAudioEncodedframeCount=");
    localStringBuilder.append(this.jdField_l_of_type_Int);
    localStringBuilder.append(" mAudioMuxeredframeCount=");
    localStringBuilder.append(this.jdField_m_of_type_Int);
    localSVHwEncoder.a(paramString, localStringBuilder.toString());
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramString, paramInt1, paramInt2, paramInt3);
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svSegmentOK:path=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" index=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("width=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" height=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramString1, paramInt1, paramInt2, paramString2);
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svThumbOK:path=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" md5=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("width=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramString, paramInt, paramLong);
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svMergeOK:path=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" totalTime=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" mergeTime=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
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
      } else {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.i = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      localSVHwCodec.c();
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.f = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.k = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
      Object localObject = this.this$0;
      int i1 = ((SVHwEncoder)localObject).a(SVHwEncoder.a((SVHwEncoder)localObject));
      localObject = this.this$0;
      int i2 = ((SVHwEncoder)localObject).a(SVHwEncoder.b((SVHwEncoder)localObject));
      if ((i1 <= 0) && (i2 <= 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("videosize=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" audiosize=");
        ((StringBuilder)localObject).append(i2);
        a(((StringBuilder)localObject).toString());
        return true;
      }
    }
    return false;
  }
  
  boolean a(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
  {
    for (;;)
    {
      SVHwEncoder.HwFrame localHwFrame = this.this$0.a(paramArrayList);
      if (localHwFrame == null) {
        break label33;
      }
      if (!localHwFrame.jdField_a_of_type_Boolean) {
        break;
      }
      this.this$0.a(paramArrayList);
    }
    return true;
    label33:
    return false;
  }
  
  boolean a(boolean paramBoolean)
  {
    SVHwEncoder localSVHwEncoder1 = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release mMuxerCreated=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" needCatch=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("......");
    localSVHwEncoder1.a("hw_media_muxer_seg", localStringBuilder.toString());
    boolean bool3 = this.jdField_a_of_type_Boolean;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
      if (paramBoolean) {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          localIllegalStateException1.printStackTrace();
          return true;
        }
      } else {
        this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
      }
      SVHwEncoder localSVHwEncoder2 = this.this$0;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("release mMuxerCreated=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" needCatch=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("topped...");
      localSVHwEncoder2.a("hw_media_muxer_seg", localStringBuilder.toString());
      if (paramBoolean)
      {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
          paramBoolean = bool2;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          localIllegalStateException2.printStackTrace();
          paramBoolean = true;
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
        paramBoolean = bool2;
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      bool1 = paramBoolean;
    }
    return bool1;
  }
  
  int b()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    boolean bool1;
    if (this.jdField_c_of_type_JavaLangString != null)
    {
      this.jdField_d_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", this.jdField_e_of_type_Int);
      bool1 = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(this.jdField_d_of_type_AndroidMediaMediaFormat, this.jdField_c_of_type_JavaLangString);
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("audioEncodeInit: sfCodecinit error codecNameHw=");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
        QLog.d("SVHwEncoder", 2, ((StringBuilder)localObject).toString());
      }
      bool2 = bool1;
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        this.jdField_d_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", this.jdField_d_of_type_Int);
        bool2 = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(this.jdField_d_of_type_AndroidMediaMediaFormat, this.jdField_b_of_type_JavaLangString);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
    ((SVHwEncoder.HwEncode.HwTimeTool)localObject).h = ((SVHwEncoder.HwEncode.HwTimeTool)localObject).a();
    if (!bool2) {
      return -8;
    }
    return 0;
  }
  
  long b()
  {
    if (SVHwEncoder.b(this.this$0)) {
      return this.jdField_n_of_type_Int;
    }
    long l2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.c();
    int i1 = this.jdField_n_of_type_Int;
    long l1 = l2;
    if (l2 > i1) {
      l1 = i1;
    }
    return l1;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.b();
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svEncodeEnd mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.this$0))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.b(paramInt1, paramInt2);
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svErrorOcured:error=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" subcode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
  }
  
  int c()
  {
    Object localObject = SVHwCodec.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    this.jdField_c_of_type_AndroidMediaMediaFormat = MediaFormat.createVideoFormat((String)localObject, SVHwEncoder.c(this.this$0), SVHwEncoder.d(this.this$0));
    int i1 = a(this.jdField_c_of_type_AndroidMediaMediaFormat, (String)localObject, (int)SVHwEncoder.a(this.this$0), SVHwEncoder.k(this.this$0));
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
    ((SVHwEncoder.HwEncode.HwTimeTool)localObject).b = ((SVHwEncoder.HwEncode.HwTimeTool)localObject).a();
    if (i1 != 0) {
      return i1;
    }
    if (!this.jdField_g_of_type_Boolean) {
      return i1;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
    i1 = a(SVHwEncoder.h(this.this$0), SVHwEncoder.i(this.this$0), SVHwEncoder.l(this.this$0));
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
    ((SVHwEncoder.HwEncode.HwTimeTool)localObject).g = ((SVHwEncoder.HwEncode.HwTimeTool)localObject).a();
    if (i1 != 0) {}
    return i1;
  }
  
  void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("shortvideo_seg_");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(".mp4");
    this.jdField_f_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_f_of_type_Int += 1;
  }
  
  int d()
  {
    h();
    int i1 = a();
    if (i1 != 0) {
      return i1;
    }
    i();
    i1 = a(true);
    if (i1 != 0) {
      return i1;
    }
    if (!this.jdField_g_of_type_Boolean) {
      return i1;
    }
    i1 = b();
    if (i1 != 0) {
      return i1;
    }
    return a(false);
  }
  
  void d()
  {
    if ((this.jdField_f_of_type_Int == 1) && (!SVHwEncoder.b(this.this$0)) && (!this.jdField_m_of_type_Boolean) && (this.jdField_h_of_type_Int >= 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
      this.jdField_n_of_type_Boolean = false;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen;
      ((SVHwThumbGen)localObject).jdField_b_of_type_JavaLangString = null;
      ((SVHwThumbGen)localObject).jdField_a_of_type_JavaLangString = null;
      ((SVHwThumbGen)localObject).jdField_a_of_type_Int = 0;
      ((SVHwThumbGen)localObject).jdField_a_of_type_Long = 0L;
      new SVHwEncoder.HwEncode.HwThumbGenTask(this).execute(new Void[0]);
      this.jdField_m_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
      ((SVHwEncoder.HwEncode.HwTimeTool)localObject).m = ((SVHwEncoder.HwEncode.HwTimeTool)localObject).a();
    }
  }
  
  int e()
  {
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("frame-rate", (int)SVHwEncoder.a(this.this$0));
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("bitrate", SVHwEncoder.k(this.this$0));
    this.jdField_a_of_type_AndroidMediaMediaFormat = null;
    int i1 = a();
    if (i1 != 0) {
      return i1;
    }
    i1 = a(true);
    if (i1 != 0)
    {
      SVHwEncoder localSVHwEncoder = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("err=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localSVHwEncoder.a("VideoEncodeExit", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.c();
    }
    return i1;
  }
  
  void e()
  {
    this.jdField_a_of_type_Int = 0;
    if ((this.jdField_n_of_type_Boolean) && (!this.o))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Int != 0)
      {
        this.jdField_a_of_type_Int = -9;
        b(-9, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Int);
        localSVHwEncoder = this.this$0;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("genThumbFile mLastErrCode=");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" subcode=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Int);
        localSVHwEncoder.a("hw_av_merge_segment", localStringBuilder.toString());
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_b_of_type_JavaLangString, SVHwEncoder.f(this.this$0), SVHwEncoder.g(this.this$0), this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_JavaLangString);
      }
      SVHwEncoder localSVHwEncoder = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("svThumbOK:mCallSegmentIndex=");
      localStringBuilder.append(this.jdField_g_of_type_Int);
      localStringBuilder.append(" mLastErrCode=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localSVHwEncoder.a("hw_video_segment_notify_msg", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.l = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Long;
      this.o = true;
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
      SVHwEncoder localSVHwEncoder;
      StringBuilder localStringBuilder;
      if (i1 != 0)
      {
        localSVHwEncoder = this.this$0;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("err=");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localSVHwEncoder.a("audioEncodeInit", localStringBuilder.toString());
        return i1;
      }
      i1 = a(false);
      if (i1 != 0)
      {
        localSVHwEncoder = this.this$0;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("err=");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localSVHwEncoder.a("audioEncodeInit", localStringBuilder.toString());
        this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.c();
      }
      return i1;
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
      SVHwEncoder localSVHwEncoder = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseThread:mHavePaused=");
      localStringBuilder.append(this.p);
      localSVHwEncoder.a("pauseThread", localStringBuilder.toString());
      if (!this.p) {
        this.p = true;
      }
    }
    try
    {
      this.jdField_a_of_type_JavaLangObject.wait();
      label67:
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label67;
    }
  }
  
  void g()
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    String str = a();
    if (i1 <= 0)
    {
      this.this$0.a("hw_av_merge_segment", "size <= 0");
      return;
    }
    long l1;
    if (i1 == 1)
    {
      l1 = System.nanoTime();
      this.this$0.a("hw_av_merge_segment", "renameTo.");
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      i1 = 0;
      localObject1 = new File((String)((ArrayList)localObject1).get(0));
      localObject2 = new File(str);
      if (SVHwEncoder.b(this.this$0))
      {
        if ((this.jdField_j_of_type_Int <= 0) && (this.jdField_m_of_type_Int <= 0))
        {
          i1 = -2;
          FileUtils.deleteFile(((File)localObject1).getAbsolutePath());
          localObject1 = this.this$0;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[mOnlyGenOneMp4:check]mVideoMuxeredframeCount=");
          ((StringBuilder)localObject2).append(this.jdField_j_of_type_Int);
          ((StringBuilder)localObject2).append(" mAudioMuxeredframeCount=");
          ((StringBuilder)localObject2).append(this.jdField_m_of_type_Int);
          ((SVHwEncoder)localObject1).a("hw_av_merge_segment", ((StringBuilder)localObject2).toString());
        }
        else if (!((File)localObject1).renameTo((File)localObject2))
        {
          i1 = -1;
        }
      }
      else {
        FileUtils.copyFile((File)localObject1, (File)localObject2);
      }
      l1 = (System.nanoTime() - l1) / 1000L;
    }
    else
    {
      l1 = System.nanoTime();
      i1 = SVMp4Merge.a(this.jdField_a_of_type_JavaUtilArrayList, str);
      l1 = (System.nanoTime() - l1) / 1000L;
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("merge:time=");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(" us");
      ((SVHwEncoder)localObject1).a("hw_av_merge_segment", ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.this$0;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("merge mp4 Over error=");
    ((StringBuilder)localObject2).append(i1);
    ((SVHwEncoder)localObject1).a("hw_av_merge_segment", ((StringBuilder)localObject2).toString());
    if (i1 == 0)
    {
      a(str, SVHwEncoder.b(this.this$0), l1);
      this.this$0.a("hw_av_merge_segment", "notify merge OK......");
      return;
    }
    b(-40, i1);
    FileUtils.deleteDirectory(this.jdField_e_of_type_JavaLangString);
    this.this$0.a("hw_av_merge_segment", "merge error delete cache......");
  }
  
  void h()
  {
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("width", SVHwEncoder.c(this.this$0));
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("height", SVHwEncoder.d(this.this$0));
  }
  
  void i() {}
  
  void j() {}
  
  void k()
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
      ??? = this.this$0;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(" err=");
      localStringBuilder1.append(this.jdField_a_of_type_Int);
      ((SVHwEncoder)???).a("configHardWareComponent", localStringBuilder1.toString());
      b(this.jdField_a_of_type_Int, 0);
      this.jdField_c_of_type_AndroidMediaMediaFormat = null;
      this.jdField_d_of_type_AndroidMediaMediaFormat = null;
      return;
    }
    boolean bool1 = SVHwEncoder.b(this.this$0);
    long l2 = 1000L;
    if ((!bool1) && (!Lock.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      synchronized (Lock.jdField_a_of_type_JavaLangObject)
      {
        bool1 = Lock.jdField_a_of_type_Boolean;
        if (bool1) {}
      }
      try
      {
        Lock.jdField_a_of_type_JavaLangObject.wait(1000L);
        label134:
        if (!SVHwEncoder.c(this.this$0)) {
          continue;
        }
        return;
        break label162;
        localObject7 = finally;
        throw localObject7;
        label162:
        this.this$0.a("[Lock.CAPTURE_LOCK=true]", "begin to record video......");
        a();
        this.jdField_a_of_type_Int = d();
        if (this.jdField_a_of_type_Int != 0)
        {
          ??? = this.this$0;
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append(" err=");
          ((StringBuilder)localObject8).append(this.jdField_a_of_type_Int);
          ((SVHwEncoder)???).a("initEncodeStatus", ((StringBuilder)localObject8).toString());
          b(this.jdField_a_of_type_Int, 0);
          a(true);
          a(false);
          j();
          return;
        }
        long l1 = l2;
        if (SVHwEncoder.b(this.this$0))
        {
          this.jdField_i_of_type_Boolean = true;
          ??? = this.this$0;
          SVHwEncoder.a((SVHwEncoder)???, SVHwEncoder.a((SVHwEncoder)???) * 1000 / SVHwEncoder.b(this.this$0));
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a(SVHwEncoder.a(this.this$0));
          ??? = this.this$0;
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append("mTotalFrames=");
          ((StringBuilder)localObject8).append(SVHwEncoder.a(this.this$0));
          ((StringBuilder)localObject8).append(" mTotalTimes=");
          ((StringBuilder)localObject8).append(SVHwEncoder.b(this.this$0));
          ((StringBuilder)localObject8).append(" mVideoFps=");
          ((StringBuilder)localObject8).append(SVHwEncoder.a(this.this$0));
          ((SVHwEncoder)???).a("HwEncodeHelper:mOnlyGenOneMp4", ((StringBuilder)localObject8).toString());
          l1 = l2;
        }
        for (;;)
        {
          if (!SVHwEncoder.a(this.this$0))
          {
            if ((!SVHwEncoder.b(this.this$0)) && (!this.jdField_b_of_type_Boolean))
            {
              ??? = this.this$0;
              ??? = ((SVHwEncoder)???).a(SVHwEncoder.a((SVHwEncoder)???));
            }
            else
            {
              ??? = null;
            }
            localObject8 = this.this$0;
            Object localObject9 = new StringBuilder();
            ((StringBuilder)localObject9).append("mVideoSourceDone=");
            ((StringBuilder)localObject9).append(this.jdField_b_of_type_Boolean);
            ((StringBuilder)localObject9).append(" mDataSource=");
            ((StringBuilder)localObject9).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource);
            ((SVHwEncoder)localObject8).a("hw_video_write_frame", ((StringBuilder)localObject9).toString());
            localObject8 = this.this$0;
            localObject9 = new StringBuilder();
            ((StringBuilder)localObject9).append("mMuxerCreated=");
            ((StringBuilder)localObject9).append(this.jdField_a_of_type_Boolean);
            ((StringBuilder)localObject9).append(" encoderOutputVideoFormat=");
            ((StringBuilder)localObject9).append(this.jdField_a_of_type_AndroidMediaMediaFormat);
            ((SVHwEncoder)localObject8).a("hw_video_write_frame", ((StringBuilder)localObject9).toString());
            if (((??? != null) || ((SVHwEncoder.b(this.this$0)) && (!this.jdField_b_of_type_Boolean))) && ((this.jdField_a_of_type_AndroidMediaMediaFormat == null) || (this.jdField_a_of_type_Boolean))) {}
            try
            {
              l2 = a();
              localObject8 = this.this$0;
              localObject9 = new StringBuilder();
              ((StringBuilder)localObject9).append("videotimeout=");
              ((StringBuilder)localObject9).append(l2);
              ((SVHwEncoder)localObject8).a("hw_video_timestamp", ((StringBuilder)localObject9).toString());
              localObject9 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(l2);
              int i1;
              int i2;
              StringBuilder localStringBuilder2;
              Object localObject2;
              if ((localObject9 != null) && (((SVHwCodec.BufferData)localObject9).jdField_a_of_type_Int != -1))
              {
                if (((SVHwCodec.BufferData)localObject9).jdField_a_of_type_JavaNioByteBuffer == null)
                {
                  ??? = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error;
                  ((SVHwEncoder.HwEncode.IntelX86Error)???).jdField_a_of_type_Int += 1;
                  ??? = this.this$0;
                  localObject8 = new StringBuilder();
                  ((StringBuilder)localObject8).append("INFO_TRY_AGAIN_LATER: buffer = null mVideoBuferErrCount=");
                  ((StringBuilder)localObject8).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_a_of_type_Int);
                  ((SVHwEncoder)???).a("hw_intel_x86__err_msg", ((StringBuilder)localObject8).toString());
                  if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_a_of_type_Int >= 3)
                  {
                    this.jdField_a_of_type_Int = -21;
                    b(this.jdField_a_of_type_Int, 0);
                    break label5780;
                  }
                }
                else
                {
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_a_of_type_Int = 0;
                  localObject8 = ???;
                  if (SVHwEncoder.b(this.this$0))
                  {
                    localObject8 = ???;
                    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource != null) {
                      localObject8 = a(this.this$0.jdField_a_of_type_Int);
                    }
                  }
                  if (!((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Boolean)
                  {
                    ((SVHwCodec.BufferData)localObject9).jdField_a_of_type_JavaNioByteBuffer.clear();
                    i1 = ((SVHwCodec.BufferData)localObject9).jdField_a_of_type_JavaNioByteBuffer.capacity();
                    i2 = ((SVHwEncoder.HwFrame)localObject8).jdField_b_of_type_Int - ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int;
                    if (i1 >= i2)
                    {
                      ((SVHwCodec.BufferData)localObject9).jdField_a_of_type_JavaNioByteBuffer.put(((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_ArrayOfByte, ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int, i2);
                      ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int += i2;
                      l2 = ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Long * l1;
                      if (this.jdField_i_of_type_Boolean) {
                        l1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a(((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Long);
                      } else {
                        l1 = l2;
                      }
                      ??? = this.this$0;
                      localStringBuilder2 = new StringBuilder();
                      localStringBuilder2.append("oldTime=");
                      localStringBuilder2.append(l2);
                      localStringBuilder2.append(" frameTime=");
                      localStringBuilder2.append(l1);
                      ((SVHwEncoder)???).a("hw_video_timestamp", localStringBuilder2.toString());
                      try
                      {
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a((SVHwCodec.BufferData)localObject9, ((SVHwEncoder.HwFrame)localObject8).jdField_b_of_type_Int, l1, 0);
                        this.jdField_h_of_type_Int += 1;
                        ??? = this.this$0;
                        localObject9 = new StringBuilder();
                        ((StringBuilder)localObject9).append("mVideoWritedFrameCount=");
                        ((StringBuilder)localObject9).append(this.jdField_h_of_type_Int);
                        ((SVHwEncoder)???).a("hw_video_write_frame", ((StringBuilder)localObject9).toString());
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a(true);
                      }
                      catch (IllegalStateException localIllegalStateException1)
                      {
                        localIllegalStateException1.printStackTrace();
                        this.jdField_a_of_type_Int = -17;
                        b(this.jdField_a_of_type_Int, 0);
                        break label5780;
                      }
                    }
                    else
                    {
                      this.jdField_a_of_type_Int = -12;
                      b(this.jdField_a_of_type_Int, 0);
                      break label5780;
                    }
                  }
                  else
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a((SVHwCodec.BufferData)localObject9, 0, 0L, 4);
                    this.jdField_b_of_type_Boolean = true;
                    localObject2 = this.this$0;
                    localObject9 = new StringBuilder();
                    ((StringBuilder)localObject9).append("[end-of-stream] fps=");
                    ((StringBuilder)localObject9).append(((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Float);
                    ((StringBuilder)localObject9).append(" bitrate");
                    ((StringBuilder)localObject9).append(((SVHwEncoder.HwFrame)localObject8).jdField_c_of_type_Int);
                    ((SVHwEncoder)localObject2).a("hw_video_write_frame", ((StringBuilder)localObject9).toString());
                    if ((((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Float > 0.0F) && (!SVHwEncoder.b(this.this$0)))
                    {
                      localObject2 = this.this$0;
                      localObject9 = new StringBuilder();
                      ((StringBuilder)localObject9).append("mNeedDoSmooth=");
                      ((StringBuilder)localObject9).append(this.jdField_i_of_type_Boolean);
                      ((StringBuilder)localObject9).append(" mUpdateVideoFps=");
                      ((StringBuilder)localObject9).append(this.jdField_j_of_type_Boolean);
                      ((StringBuilder)localObject9).append(" mVideoFps=");
                      ((StringBuilder)localObject9).append(SVHwEncoder.a(this.this$0));
                      ((SVHwEncoder)localObject2).a("hw_smooth_time_stamp", ((StringBuilder)localObject9).toString());
                      SVHwEncoder.a(this.this$0, ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Float);
                      if (!this.jdField_i_of_type_Boolean)
                      {
                        this.jdField_j_of_type_Boolean = true;
                        localObject2 = this.this$0;
                        localObject9 = new StringBuilder();
                        ((StringBuilder)localObject9).append("mNeedDoSmooth=");
                        ((StringBuilder)localObject9).append(this.jdField_i_of_type_Boolean);
                        ((StringBuilder)localObject9).append(" mUpdateVideoFps=");
                        ((StringBuilder)localObject9).append(this.jdField_j_of_type_Boolean);
                        ((StringBuilder)localObject9).append(" mVideoFps=");
                        ((StringBuilder)localObject9).append(SVHwEncoder.a(this.this$0));
                        ((SVHwEncoder)localObject2).a("hw_smooth_time_stamp", ((StringBuilder)localObject9).toString());
                      }
                    }
                    if (((SVHwEncoder.HwFrame)localObject8).jdField_c_of_type_Int > 0) {
                      SVHwEncoder.a(this.this$0, ((SVHwEncoder.HwFrame)localObject8).jdField_c_of_type_Int);
                    }
                  }
                  if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource == null) && (((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int == ((SVHwEncoder.HwFrame)localObject8).jdField_b_of_type_Int))
                  {
                    localObject2 = this.this$0;
                    ((SVHwEncoder)localObject2).a(SVHwEncoder.a((SVHwEncoder)localObject2));
                    if (!this.this$0.a((SVHwEncoder.HwFrame)localObject8)) {
                      ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_ArrayOfByte = null;
                    }
                  }
                }
              }
              else {
                this.this$0.a("hw_video_write_frame", "INFO_TRY_AGAIN_LATER");
              }
              if ((!SVHwEncoder.b(this.this$0)) && (!this.jdField_c_of_type_Boolean))
              {
                localObject2 = this.this$0;
                localObject2 = ((SVHwEncoder)localObject2).a(SVHwEncoder.b((SVHwEncoder)localObject2));
              }
              else
              {
                localObject2 = null;
              }
              if ((localObject2 == null) && ((!SVHwEncoder.b(this.this$0)) || (this.jdField_c_of_type_Boolean))) {}
              label1654:
              while ((this.jdField_b_of_type_AndroidMediaMediaFormat != null) && (!this.jdField_a_of_type_Boolean)) {
                break;
              }
              try
              {
                l1 = b();
                localObject8 = this.this$0;
                localObject9 = new StringBuilder();
                ((StringBuilder)localObject9).append("audiotimeout=");
                ((StringBuilder)localObject9).append(l1);
                ((SVHwEncoder)localObject8).a("hw_audio_timestamp", ((StringBuilder)localObject9).toString());
                localObject9 = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(l1);
                Object localObject3;
                if ((localObject9 != null) && (((SVHwCodec.BufferData)localObject9).jdField_a_of_type_Int != -1))
                {
                  if (((SVHwCodec.BufferData)localObject9).jdField_a_of_type_JavaNioByteBuffer == null)
                  {
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error;
                    ((SVHwEncoder.HwEncode.IntelX86Error)localObject2).jdField_b_of_type_Int += 1;
                    localObject2 = this.this$0;
                    localObject8 = new StringBuilder();
                    ((StringBuilder)localObject8).append("INFO_TRY_AGAIN_LATER: buffer=null mAudioBuferErrCount=");
                    ((StringBuilder)localObject8).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_b_of_type_Int);
                    ((SVHwEncoder)localObject2).a("hw_intel_x86__err_msg", ((StringBuilder)localObject8).toString());
                    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_b_of_type_Int < 3) {
                      break label1654;
                    }
                    this.jdField_a_of_type_Int = -20;
                    b(this.jdField_a_of_type_Int, 0);
                    break label5780;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$IntelX86Error.jdField_b_of_type_Int = 0;
                  localObject8 = localObject2;
                  if (SVHwEncoder.b(this.this$0))
                  {
                    localObject8 = localObject2;
                    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource != null) {
                      localObject8 = a();
                    }
                  }
                  if (!((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Boolean)
                  {
                    ((SVHwCodec.BufferData)localObject9).jdField_a_of_type_JavaNioByteBuffer.clear();
                    i2 = ((SVHwCodec.BufferData)localObject9).jdField_a_of_type_JavaNioByteBuffer.capacity();
                    int i3 = ((SVHwEncoder.HwFrame)localObject8).jdField_b_of_type_Int - ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int;
                    if (i2 >= i3)
                    {
                      ((SVHwCodec.BufferData)localObject9).jdField_a_of_type_JavaNioByteBuffer.put(((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_ArrayOfByte, ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int, i3);
                      ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int += i3;
                      i1 = i3;
                    }
                    else
                    {
                      ((SVHwCodec.BufferData)localObject9).jdField_a_of_type_JavaNioByteBuffer.put(((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_ArrayOfByte, ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int, i2);
                      ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int += i2;
                      i1 = i2;
                    }
                    localObject2 = this.this$0;
                    localStringBuilder2 = new StringBuilder();
                    localStringBuilder2.append("offset=");
                    localStringBuilder2.append(((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int);
                    localStringBuilder2.append(" size=");
                    localStringBuilder2.append(((SVHwEncoder.HwFrame)localObject8).jdField_b_of_type_Int);
                    localStringBuilder2.append(" audiovalidSize=");
                    localStringBuilder2.append(i3);
                    ((SVHwEncoder)localObject2).a("hw_audio_write_frame", localStringBuilder2.toString());
                    localObject2 = this.this$0;
                    localStringBuilder2 = new StringBuilder();
                    localStringBuilder2.append("audiocapacity=");
                    localStringBuilder2.append(i2);
                    localStringBuilder2.append(" writedByte=");
                    localStringBuilder2.append(i1);
                    ((SVHwEncoder)localObject2).a("hw_audio_write_frame", localStringBuilder2.toString());
                    l2 = ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Long * 1000L;
                    if (this.jdField_i_of_type_Boolean)
                    {
                      float f1 = a(i1);
                      l1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a(f1);
                    }
                    else
                    {
                      l1 = l2;
                    }
                    localObject2 = this.this$0;
                    localStringBuilder2 = new StringBuilder();
                    localStringBuilder2.append("oldTime=");
                    localStringBuilder2.append(l2);
                    localStringBuilder2.append(" frameTime=");
                    localStringBuilder2.append(l1);
                    ((SVHwEncoder)localObject2).a("hw_audio_timestamp", localStringBuilder2.toString());
                    try
                    {
                      localObject2 = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec;
                      try
                      {
                        ((SVHwCodec)localObject2).a((SVHwCodec.BufferData)localObject9, i1, l1, 0);
                        this.jdField_k_of_type_Int += 1;
                        localObject2 = this.this$0;
                        localObject9 = new StringBuilder();
                        ((StringBuilder)localObject9).append("mWritedFrameCount=");
                        ((StringBuilder)localObject9).append(this.jdField_k_of_type_Int);
                        ((SVHwEncoder)localObject2).a("hw_audio_write_frame", ((StringBuilder)localObject9).toString());
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a(false);
                      }
                      catch (IllegalStateException localIllegalStateException2) {}
                      localObject9 = this.this$0;
                    }
                    catch (IllegalStateException localIllegalStateException3) {}
                    localStringBuilder2 = new StringBuilder();
                    localStringBuilder2.append("offset=");
                    localStringBuilder2.append(((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int);
                    localStringBuilder2.append(" size=");
                    localStringBuilder2.append(((SVHwEncoder.HwFrame)localObject8).jdField_b_of_type_Int);
                    localStringBuilder2.append(" audiovalidSize=");
                    localStringBuilder2.append(i3);
                    ((SVHwEncoder)localObject9).a("hw_audio_timestamp", localStringBuilder2.toString());
                    localObject8 = this.this$0;
                    localObject9 = new StringBuilder();
                    ((StringBuilder)localObject9).append("audiocapacity=");
                    ((StringBuilder)localObject9).append(i2);
                    ((StringBuilder)localObject9).append(" writedByte=");
                    ((StringBuilder)localObject9).append(i1);
                    ((SVHwEncoder)localObject8).a("hw_audio_timestamp", ((StringBuilder)localObject9).toString());
                    localIllegalStateException3.printStackTrace();
                    this.jdField_a_of_type_Int = -16;
                    b(this.jdField_a_of_type_Int, 0);
                    break label5780;
                  }
                  this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a((SVHwCodec.BufferData)localObject9, 0, 0L, 4);
                  this.jdField_c_of_type_Boolean = true;
                  localObject3 = this.this$0;
                  localObject9 = new StringBuilder();
                  ((StringBuilder)localObject9).append("mWritedFrameCount=");
                  ((StringBuilder)localObject9).append(this.jdField_k_of_type_Int);
                  ((StringBuilder)localObject9).append(" [Finish]...");
                  ((SVHwEncoder)localObject3).a("hw_audio_write_frame", ((StringBuilder)localObject9).toString());
                  if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource != null) || (((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_Int != ((SVHwEncoder.HwFrame)localObject8).jdField_b_of_type_Int)) {
                    break label2652;
                  }
                  localObject3 = this.this$0;
                  ((SVHwEncoder)localObject3).a(SVHwEncoder.b((SVHwEncoder)localObject3));
                  ((SVHwEncoder.HwFrame)localObject8).jdField_a_of_type_ArrayOfByte = null;
                  break label2652;
                }
                this.this$0.a("hw_audio_write_frame", "INFO_TRY_AGAIN_LATER");
                label2652:
                if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.jdField_j_of_type_Boolean) && (!SVHwEncoder.b(this.this$0)))
                {
                  localObject3 = this.this$0;
                  localObject8 = new StringBuilder();
                  ((StringBuilder)localObject8).append("mUpdateVideoFps=");
                  ((StringBuilder)localObject8).append(this.jdField_j_of_type_Boolean);
                  ((StringBuilder)localObject8).append(" mVideoFps=");
                  ((StringBuilder)localObject8).append(SVHwEncoder.a(this.this$0));
                  ((SVHwEncoder)localObject3).a("hw_smooth_time_stamp", ((StringBuilder)localObject8).toString());
                  this.jdField_j_of_type_Boolean = false;
                  this.jdField_i_of_type_Boolean = true;
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a();
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth.a(SVHwEncoder.a(this.this$0));
                }
                if ((this.jdField_l_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && ((this.jdField_a_of_type_AndroidMediaMediaFormat == null) || (this.jdField_a_of_type_Boolean))) {
                  try
                  {
                    l1 = a();
                    localObject3 = this.this$0;
                    localObject8 = new StringBuilder();
                    ((StringBuilder)localObject8).append("videoOutTime=");
                    ((StringBuilder)localObject8).append(l1);
                    ((SVHwEncoder)localObject3).a("hw_video_encode_frame", ((StringBuilder)localObject8).toString());
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.b(l1);
                    if (localObject3 == null)
                    {
                      this.this$0.a("hw_video_encode_frame", "encoderOutputBuffer=null");
                    }
                    else
                    {
                      localObject8 = ((SVHwCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
                      i1 = ((SVHwCodec.BufferData)localObject3).jdField_a_of_type_Int;
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
                      else if ((((MediaCodec.BufferInfo)localObject8).flags & 0x2) != 0)
                      {
                        this.this$0.a("hw_video_encode_frame", "get Config data...");
                        this.this$0.a(((SVHwCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer, (MediaCodec.BufferInfo)localObject8, "mVideoEncoder_dequeueOutputBuffer", 30);
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a((SVHwCodec.BufferData)localObject3);
                      }
                      else
                      {
                        localObject9 = this.this$0;
                        localStringBuilder2 = new StringBuilder();
                        localStringBuilder2.append("writedata size=");
                        localStringBuilder2.append(((MediaCodec.BufferInfo)localObject8).size);
                        ((SVHwEncoder)localObject9).a("hw_video_encode_frame", localStringBuilder2.toString());
                        if (((MediaCodec.BufferInfo)localObject8).size != 0)
                        {
                          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.b(true);
                          this.jdField_i_of_type_Int += 1;
                          if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null)
                          {
                            if ((((MediaCodec.BufferInfo)localObject8).flags & 0x1) != 0)
                            {
                              localObject9 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData;
                              ((SVHwEncoder.HwEncode.MuxerValidData)localObject9).jdField_a_of_type_Boolean = true;
                              if (this.jdField_j_of_type_Int == 0) {
                                ((SVHwEncoder.HwEncode.MuxerValidData)localObject9).jdField_c_of_type_Boolean = true;
                              }
                            }
                            if (this.jdField_j_of_type_Int == 0) {
                              if (this.jdField_m_of_type_Int == 0) {
                                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.jdField_b_of_type_Boolean = true;
                              } else {
                                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.jdField_b_of_type_Boolean = false;
                              }
                            }
                            this.jdField_j_of_type_Int += 1;
                            localObject9 = this.this$0;
                            localStringBuilder2 = new StringBuilder();
                            localStringBuilder2.append("track=");
                            localStringBuilder2.append(this.jdField_b_of_type_Int);
                            localStringBuilder2.append(" pts=");
                            localStringBuilder2.append(((MediaCodec.BufferInfo)localObject8).presentationTimeUs);
                            ((SVHwEncoder)localObject9).a("hw_video_writesample", localStringBuilder2.toString());
                            this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.a(((MediaCodec.BufferInfo)localObject8).presentationTimeUs, true);
                            this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
                            try
                            {
                              this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_b_of_type_Int, ((SVHwCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer, (MediaCodec.BufferInfo)localObject8);
                              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.c(true);
                            }
                            catch (Throwable localThrowable1)
                            {
                              if (QLog.isColorLevel()) {
                                QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of video erro", localThrowable1);
                              }
                              this.jdField_a_of_type_Int = -25;
                              b(this.jdField_a_of_type_Int, 0);
                              break label5780;
                            }
                          }
                          else
                          {
                            this.this$0.a("hw_video_encode_frame", "video encoder:muxer is null");
                          }
                        }
                        if ((((MediaCodec.BufferInfo)localObject8).flags & 0x4) != 0)
                        {
                          this.jdField_d_of_type_Boolean = true;
                          this.this$0.a("hw_video_encode_frame", "end of stream");
                        }
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localThrowable1);
                      }
                    }
                  }
                  catch (IllegalStateException localIllegalStateException4)
                  {
                    localIllegalStateException4.printStackTrace();
                    this.jdField_a_of_type_Int = -23;
                    b(this.jdField_a_of_type_Int, 0);
                    break label5780;
                  }
                }
                if ((this.jdField_l_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && ((this.jdField_b_of_type_AndroidMediaMediaFormat == null) || (this.jdField_a_of_type_Boolean))) {
                  try
                  {
                    l1 = b();
                    Object localObject4 = this.this$0;
                    localObject8 = new StringBuilder();
                    ((StringBuilder)localObject8).append("audioOutTime=");
                    ((StringBuilder)localObject8).append(l1);
                    ((SVHwEncoder)localObject4).a("hw_audio_encode_frame", ((StringBuilder)localObject8).toString());
                    localObject4 = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.b(l1);
                    if (localObject4 == null)
                    {
                      this.this$0.a("hw_audio_encode_frame", "encoderOutputBuffer=null");
                    }
                    else
                    {
                      localObject8 = ((SVHwCodec.BufferData)localObject4).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
                      i1 = ((SVHwCodec.BufferData)localObject4).jdField_a_of_type_Int;
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
                      else if ((((MediaCodec.BufferInfo)localObject8).flags & 0x2) != 0)
                      {
                        this.this$0.a("hw_audio_encode_frame", "get config......");
                        this.this$0.a(((SVHwCodec.BufferData)localObject4).jdField_a_of_type_JavaNioByteBuffer, (MediaCodec.BufferInfo)localObject8, "mAudioEncoder_dequeueOutputBuffer", 10);
                        this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a((SVHwCodec.BufferData)localObject4);
                      }
                      else
                      {
                        localObject9 = this.this$0;
                        localStringBuilder2 = new StringBuilder();
                        localStringBuilder2.append("writedata size=");
                        localStringBuilder2.append(((MediaCodec.BufferInfo)localObject8).size);
                        ((SVHwEncoder)localObject9).a("hw_audio_encode_frame", localStringBuilder2.toString());
                        if (((MediaCodec.BufferInfo)localObject8).size != 0)
                        {
                          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.b(false);
                          this.jdField_l_of_type_Int += 1;
                          if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null)
                          {
                            this.jdField_m_of_type_Int += 1;
                            localObject9 = this.this$0;
                            localStringBuilder2 = new StringBuilder();
                            localStringBuilder2.append("track=");
                            localStringBuilder2.append(this.jdField_c_of_type_Int);
                            localStringBuilder2.append(" pts=");
                            localStringBuilder2.append(((MediaCodec.BufferInfo)localObject8).presentationTimeUs);
                            ((SVHwEncoder)localObject9).a("hw_audio_writesample", localStringBuilder2.toString());
                            if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.a(((MediaCodec.BufferInfo)localObject8).presentationTimeUs, false))
                            {
                              this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
                              try
                              {
                                this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_c_of_type_Int, ((SVHwCodec.BufferData)localObject4).jdField_a_of_type_JavaNioByteBuffer, (MediaCodec.BufferInfo)localObject8);
                                this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.c(false);
                              }
                              catch (Throwable localThrowable2)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of audio erro", localThrowable2);
                                }
                                this.jdField_a_of_type_Int = -24;
                                b(this.jdField_a_of_type_Int, 0);
                                break label5780;
                              }
                            }
                          }
                          else
                          {
                            this.this$0.a("hw_audio_encode_frame", "muxer is null");
                          }
                        }
                        if ((((MediaCodec.BufferInfo)localObject8).flags & 0x4) != 0)
                        {
                          this.jdField_e_of_type_Boolean = true;
                          this.this$0.a("hw_audio_encode_frame", "end of stream");
                        }
                        this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(localThrowable2);
                      }
                    }
                  }
                  catch (IllegalStateException localIllegalStateException5)
                  {
                    localIllegalStateException5.printStackTrace();
                    this.jdField_a_of_type_Int = -22;
                    b(this.jdField_a_of_type_Int, 0);
                    break label5780;
                  }
                }
                if ((SVHwEncoder.b(this.this$0)) && (!this.jdField_h_of_type_Boolean))
                {
                  i1 = this.jdField_i_of_type_Int * 100 / SVHwEncoder.a(this.this$0);
                  a(i1);
                  if (i1 >= 100) {
                    this.jdField_h_of_type_Boolean = true;
                  }
                }
                if (SVHwEncoder.d(this.this$0)) {
                  f();
                }
                d();
                e();
                if (this.jdField_a_of_type_Int == 0)
                {
                  Object localObject5;
                  if ((this.jdField_d_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
                  {
                    bool1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.c();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.a();
                    if (!bool1)
                    {
                      localObject5 = this.this$0;
                      localObject8 = new StringBuilder();
                      ((StringBuilder)localObject8).append("validSegment=");
                      ((StringBuilder)localObject8).append(bool1);
                      ((SVHwEncoder)localObject5).a("releaseMuxer[check]", ((StringBuilder)localObject8).toString());
                      this.jdField_a_of_type_Int = -14;
                      b(this.jdField_a_of_type_Int, 0);
                    }
                    else if (a(true))
                    {
                      this.jdField_a_of_type_Int = -14;
                      b(this.jdField_a_of_type_Int, 1);
                    }
                    else
                    {
                      if (this.o)
                      {
                        if (this.jdField_g_of_type_Int + 1 < this.jdField_f_of_type_Int)
                        {
                          if (this.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_f_of_type_Int - 1)
                          {
                            this.jdField_a_of_type_Int = -15;
                            b(this.jdField_a_of_type_Int, 0);
                            break label5780;
                          }
                          i1 = 0;
                          while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
                          {
                            localObject5 = this.this$0;
                            localObject8 = new StringBuilder();
                            ((StringBuilder)localObject8).append("svSegmentOK:[roll] i=");
                            ((StringBuilder)localObject8).append(i1);
                            ((StringBuilder)localObject8).append(" mCallSegmentIndex=");
                            ((StringBuilder)localObject8).append(this.jdField_g_of_type_Int);
                            ((SVHwEncoder)localObject5).a("hw_video_segment_notify_msg", ((StringBuilder)localObject8).toString());
                            localObject5 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
                            i1 += 1;
                            a((String)localObject5, i1, SVHwEncoder.c(this.this$0), SVHwEncoder.d(this.this$0));
                            this.jdField_g_of_type_Int += 1;
                          }
                        }
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("svSegmentOK:[new]mCallSegmentIndex=");
                        ((StringBuilder)localObject8).append(this.jdField_g_of_type_Int);
                        ((SVHwEncoder)localObject5).a("hw_video_segment_notify_msg", ((StringBuilder)localObject8).toString());
                        a(this.jdField_f_of_type_JavaLangString, this.jdField_f_of_type_Int, SVHwEncoder.c(this.this$0), SVHwEncoder.d(this.this$0));
                        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_f_of_type_JavaLangString);
                        this.jdField_g_of_type_Int += 1;
                      }
                      else
                      {
                        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_f_of_type_JavaLangString);
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("mHasCallSVThumbOk=");
                        ((StringBuilder)localObject8).append(this.o);
                        ((StringBuilder)localObject8).append(" size=");
                        ((StringBuilder)localObject8).append(this.jdField_a_of_type_JavaUtilArrayList.size());
                        ((SVHwEncoder)localObject5).a("hw_video_segment_notify_msg", ((StringBuilder)localObject8).toString());
                      }
                      if ((!SVHwEncoder.b(this.this$0)) && (!a("VideoEncodeExit[one]")))
                      {
                        a(true);
                        a(false);
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("HwTimeUsed=");
                        ((StringBuilder)localObject8).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.toString());
                        ((SVHwEncoder)localObject5).a("hw_video_time_used_msg", ((StringBuilder)localObject8).toString());
                        c();
                        this.jdField_a_of_type_Int = e();
                        i1 = this.jdField_a_of_type_Int;
                        if (i1 != 0)
                        {
                          b(i1, 0);
                        }
                        else
                        {
                          if (this.jdField_g_of_type_Boolean)
                          {
                            this.jdField_a_of_type_Int = f();
                            i1 = this.jdField_a_of_type_Int;
                            if (i1 != 0)
                            {
                              b(i1, 0);
                              break label5780;
                            }
                          }
                          this.jdField_d_of_type_Boolean = false;
                          if (this.jdField_g_of_type_Boolean) {
                            this.jdField_e_of_type_Boolean = false;
                          }
                          k();
                          this.jdField_k_of_type_Boolean = true;
                        }
                      }
                    }
                  }
                  else
                  {
                    if (this.jdField_k_of_type_Boolean)
                    {
                      if (a("VideoEncodeExit[two]")) {
                        break label5780;
                      }
                      boolean bool2 = a(SVHwEncoder.a(this.this$0));
                      if (this.jdField_g_of_type_Boolean) {
                        bool1 = a(SVHwEncoder.b(this.this$0));
                      } else {
                        bool1 = false;
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
                          localObject5 = new StringBuilder();
                          ((StringBuilder)localObject5).append("VideoEncodeExit[Four]startVideo=");
                          ((StringBuilder)localObject5).append(bool2);
                          ((StringBuilder)localObject5).append(" startAudio=");
                          ((StringBuilder)localObject5).append(bool1);
                          a(((StringBuilder)localObject5).toString());
                          break label5780;
                        }
                      }
                      if (!this.jdField_f_of_type_Boolean)
                      {
                        this.jdField_d_of_type_Boolean = true;
                        this.jdField_a_of_type_AndroidMediaMediaFormat = null;
                        bool2 = true;
                      }
                      if (!this.jdField_g_of_type_Boolean)
                      {
                        this.jdField_e_of_type_Boolean = true;
                        this.jdField_b_of_type_AndroidMediaMediaFormat = null;
                        bool1 = true;
                      }
                      if ((bool2) && (bool1))
                      {
                        this.jdField_b_of_type_Boolean = false;
                        this.jdField_c_of_type_Boolean = false;
                        this.jdField_l_of_type_Boolean = true;
                        this.jdField_k_of_type_Boolean = false;
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$MuxerValidData.a("releaseMuxer[mEnableEncode=true]");
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("track=");
                        ((StringBuilder)localObject8).append(this.jdField_b_of_type_Int);
                        ((SVHwEncoder)localObject5).a("hw_video_writesample", ((StringBuilder)localObject8).toString());
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("track=");
                        ((StringBuilder)localObject8).append(this.jdField_c_of_type_Int);
                        ((SVHwEncoder)localObject5).a("hw_audio_writesample", ((StringBuilder)localObject8).toString());
                        this.this$0.a("hw_video_timestamp", "new segment");
                        this.this$0.a("hw_audio_timestamp", "new segment");
                      }
                      else
                      {
                        this.jdField_l_of_type_Boolean = false;
                      }
                    }
                    else if (SVHwEncoder.c(this.this$0))
                    {
                      localObject5 = this.this$0;
                      i2 = ((SVHwEncoder)localObject5).a(SVHwEncoder.a((SVHwEncoder)localObject5));
                      if (this.jdField_g_of_type_Boolean)
                      {
                        localObject5 = this.this$0;
                        i1 = ((SVHwEncoder)localObject5).a(SVHwEncoder.b((SVHwEncoder)localObject5));
                      }
                      else
                      {
                        i1 = 0;
                      }
                      localObject5 = new StringBuilder();
                      ((StringBuilder)localObject5).append("VideoEncodeExit[three]videoSize=");
                      ((StringBuilder)localObject5).append(i2);
                      ((StringBuilder)localObject5).append(" audioSize=");
                      ((StringBuilder)localObject5).append(i1);
                      a(((StringBuilder)localObject5).toString());
                      if (((i2 <= 0) && (i1 <= 0)) || ((this.jdField_g_of_type_Boolean) && (i1 <= 0) && (this.jdField_d_of_type_Boolean) && (i2 <= 3)))
                      {
                        if (i2 > 0)
                        {
                          localObject5 = this.this$0;
                          localObject8 = new StringBuilder();
                          ((StringBuilder)localObject8).append("videoSize=");
                          ((StringBuilder)localObject8).append(i2);
                          ((StringBuilder)localObject8).append(" mVideoEncodeDone=");
                          ((StringBuilder)localObject8).append(this.jdField_d_of_type_Boolean);
                          ((SVHwEncoder)localObject5).a("VideoEncodeExit[three]", ((StringBuilder)localObject8).toString());
                          localObject5 = this.this$0;
                          ((SVHwEncoder)localObject5).b(SVHwEncoder.a((SVHwEncoder)localObject5));
                        }
                        a("VideoEncodeExit[three]");
                        this.this$0.c();
                      }
                    }
                    if ((!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidMediaMediaFormat != null) || (!this.jdField_f_of_type_Boolean)) && ((this.jdField_b_of_type_AndroidMediaMediaFormat != null) || (!this.jdField_g_of_type_Boolean)))
                    {
                      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
                      try
                      {
                        this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.jdField_f_of_type_JavaLangString, 0);
                        this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(SVHwEncoder.e(this.this$0));
                      }
                      catch (IOException localIOException)
                      {
                        localIOException.printStackTrace();
                        this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
                        this.jdField_a_of_type_Boolean = false;
                        this.jdField_a_of_type_Int = -11;
                      }
                      Object localObject6 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
                      ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).n = ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).a();
                      i1 = this.jdField_a_of_type_Int;
                      if (i1 != 0)
                      {
                        b(i1, 0);
                      }
                      else
                      {
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
                        localObject6 = this.jdField_a_of_type_AndroidMediaMediaFormat;
                        if (localObject6 != null)
                        {
                          this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject6);
                          localObject6 = this.this$0;
                          localObject8 = new StringBuilder();
                          ((StringBuilder)localObject8).append("adding video track:outputVideoTrack=");
                          ((StringBuilder)localObject8).append(this.jdField_b_of_type_Int);
                          ((SVHwEncoder)localObject6).a("hw_media_muxer_seg", ((StringBuilder)localObject8).toString());
                        }
                        localObject6 = this.jdField_b_of_type_AndroidMediaMediaFormat;
                        if (localObject6 != null)
                        {
                          this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject6);
                          localObject6 = this.this$0;
                          localObject8 = new StringBuilder();
                          ((StringBuilder)localObject8).append(" adding audio track:outputAudioTrack=");
                          ((StringBuilder)localObject8).append(this.jdField_c_of_type_Int);
                          ((SVHwEncoder)localObject6).a("hw_media_muxer_seg", ((StringBuilder)localObject8).toString());
                        }
                        localObject6 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
                        ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).o = ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).a();
                        this.this$0.a("hw_media_muxer_seg", "starting......");
                        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.a();
                        this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
                        localObject6 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool;
                        ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).p = ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).a();
                        this.jdField_a_of_type_Boolean = true;
                      }
                    }
                    else
                    {
                      l1 = 1000L;
                    }
                  }
                }
              }
              catch (IllegalStateException localIllegalStateException6)
              {
                localIllegalStateException6.printStackTrace();
                this.jdField_a_of_type_Int = -18;
                b(this.jdField_a_of_type_Int, 0);
              }
              a(true);
            }
            catch (IllegalStateException localIllegalStateException7)
            {
              localIllegalStateException7.printStackTrace();
              this.jdField_a_of_type_Int = -19;
              b(this.jdField_a_of_type_Int, 0);
            }
          }
        }
        label5780:
        a(false);
        j();
        SVHwEncoder localSVHwEncoder = this.this$0;
        Object localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append("HwTimeUsed_End=");
        ((StringBuilder)localObject8).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$HwTimeTool.toString());
        localSVHwEncoder.a("hw_video_time_used_msg", ((StringBuilder)localObject8).toString());
        this.this$0.a("hw_av_merge_segment", "release resource ok......");
        if (this.jdField_a_of_type_Int != 0)
        {
          localSVHwEncoder = this.this$0;
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append("mLastErrCode=");
          ((StringBuilder)localObject8).append(this.jdField_a_of_type_Int);
          localSVHwEncoder.a("hw_av_merge_segment", ((StringBuilder)localObject8).toString());
          SVHwEncoder.a(this.this$0, true);
          a(true);
        }
        else
        {
          b();
        }
        if (SVHwEncoder.a(this.this$0))
        {
          localSVHwEncoder = this.this$0;
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append("clear cache mCacellVideoEncode=");
          ((StringBuilder)localObject8).append(SVHwEncoder.a(this.this$0));
          localSVHwEncoder.a("hw_av_merge_segment", ((StringBuilder)localObject8).toString());
          FileUtils.deleteDirectory(this.jdField_e_of_type_JavaLangString);
        }
        else
        {
          this.this$0.a("hw_av_merge_segment", "begin merge segments.");
          g();
        }
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
      }
      catch (InterruptedException localInterruptedException)
      {
        break label134;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode
 * JD-Core Version:    0.7.0.1
 */