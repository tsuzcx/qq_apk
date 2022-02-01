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
  private int A = 0;
  private int B = 0;
  private String C = null;
  private int D = 0;
  private int E = 0;
  private int F = 0;
  private int G = 0;
  private int H = 0;
  private int I = 0;
  private SVHwCodec J = new SVHwCodec();
  private SVHwCodec K = new SVHwCodec();
  private InputSurface L = null;
  private boolean M = false;
  private SVHwVideoFpsSmooth N = new SVHwVideoFpsSmooth();
  private boolean O = false;
  private boolean P = false;
  private ArrayList<String> Q = new ArrayList();
  private boolean R = false;
  private boolean S = true;
  private boolean T = false;
  private volatile boolean U = false;
  private boolean V = false;
  private volatile boolean W = false;
  private Object X = new Object();
  private SVHwEncoder.HwEncode.MuxerValidData Y = new SVHwEncoder.HwEncode.MuxerValidData(this);
  private SVHwEncoder.HwEncode.HwTimeTool Z = new SVHwEncoder.HwEncode.HwTimeTool(this);
  SVHwThumbGen a = new SVHwThumbGen();
  private int aa = 0;
  SVHwEncoder.HwEncode.IntelX86Error b = new SVHwEncoder.HwEncode.IntelX86Error(this);
  private SVHwOutputNotify c = null;
  private SVHwDataSource d = null;
  private int e = 0;
  private boolean f = false;
  private MediaFormat g = null;
  private MediaFormat h = null;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = true;
  private boolean n = true;
  private int o = -1;
  private int p = -1;
  private MediaFormat q = null;
  private MediaFormat r = null;
  private String s = null;
  private String t = null;
  private String u = null;
  private int v = 0;
  private int w = 0;
  private MediaMuxer x = null;
  private String y = null;
  private String z = null;
  
  SVHwEncoder$HwEncode(SVHwEncoder paramSVHwEncoder, String paramString, SVHwOutputNotify paramSVHwOutputNotify, SVHwDataSource paramSVHwDataSource, boolean paramBoolean, int paramInt)
  {
    this.y = paramString;
    this.z = a(paramString);
    this.n = paramBoolean;
    this.m = true;
    this.c = paramSVHwOutputNotify;
    this.d = paramSVHwDataSource;
    c();
    if (!this.n)
    {
      this.j = true;
      this.l = true;
    }
    this.e = 0;
    this.aa = paramInt;
    this.P = false;
    this.R = false;
    this.T = false;
    this.U = false;
    this.V = false;
    this.B = 0;
  }
  
  int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject4 = SVHwCodec.b("audio/mp4a-latm");
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
    this.r = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
    this.r.setInteger("bitrate", paramInt3);
    this.t = ((String)localObject1);
    this.u = ((String)localObject2);
    this.v = i3;
    this.w = i1;
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
        this.this$0.a = 21;
      }
    }
    else {
      this.this$0.a = 19;
    }
    paramMediaFormat.setInteger("color-format", i1);
    paramMediaFormat.setInteger("frame-rate", paramInt1);
    paramMediaFormat.setInteger("bitrate", paramInt2);
    paramMediaFormat.setInteger("i-frame-interval", 1);
    this.s = ((MediaCodecInfo)localList.get(i3)).getName();
    return 0;
  }
  
  SVHwCodec a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.J;
    }
    return this.K;
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
    if ((this.c != null) && (!SVHwEncoder.a(this.this$0))) {
      this.c.a();
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svEncodeBegin mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
  }
  
  public void a(int paramInt)
  {
    if ((this.c != null) && (!SVHwEncoder.a(this.this$0))) {
      this.c.a(paramInt);
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svEncodeProgress: progress=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.c != null) && (!SVHwEncoder.a(this.this$0))) {
      this.c.a(paramString, paramInt1, paramInt2, paramInt3);
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
    if ((this.c != null) && (!SVHwEncoder.a(this.this$0))) {
      this.c.a(paramString1, paramInt1, paramInt2, paramString2);
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
    if ((this.c != null) && (!SVHwEncoder.a(this.this$0))) {
      this.c.a(paramString, paramInt, paramLong);
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
  
  boolean a(ArrayList<SVHwEncoder.HwFrame> paramArrayList)
  {
    for (;;)
    {
      SVHwEncoder.HwFrame localHwFrame = this.this$0.a(paramArrayList);
      if (localHwFrame == null) {
        break label33;
      }
      if (!localHwFrame.e) {
        break;
      }
      this.this$0.b(paramArrayList);
    }
    return true;
    label33:
    return false;
  }
  
  int b(boolean paramBoolean)
  {
    this.Z.a();
    boolean bool;
    try
    {
      bool = a(paramBoolean).b();
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
      localHwTimeTool = this.Z;
      localHwTimeTool.d = localHwTimeTool.b();
    }
    else
    {
      localHwTimeTool = this.Z;
      localHwTimeTool.i = localHwTimeTool.b();
    }
    if (!bool) {
      return -3;
    }
    return 0;
  }
  
  public SVHwEncoder.HwFrame b(int paramInt)
  {
    return this.d.b(paramInt);
  }
  
  public void b()
  {
    if ((this.c != null) && (!SVHwEncoder.a(this.this$0))) {
      this.c.b();
    }
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("svEncodeEnd mCacellVideoEncode=");
    localStringBuilder.append(SVHwEncoder.a(this.this$0));
    localSVHwEncoder.a("hw_video_callback_msg", localStringBuilder.toString());
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.c != null) && (!SVHwEncoder.a(this.this$0))) {
      this.c.b(paramInt1, paramInt2);
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
  
  boolean b(String paramString)
  {
    if (SVHwEncoder.a(this.this$0))
    {
      c(paramString);
      return true;
    }
    if (SVHwEncoder.c(this.this$0))
    {
      Object localObject = this.this$0;
      int i1 = ((SVHwEncoder)localObject).c(SVHwEncoder.g((SVHwEncoder)localObject));
      localObject = this.this$0;
      int i2 = ((SVHwEncoder)localObject).c(SVHwEncoder.h((SVHwEncoder)localObject));
      if ((i1 <= 0) && (i2 <= 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("videosize=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" audiosize=");
        ((StringBuilder)localObject).append(i2);
        c(((StringBuilder)localObject).toString());
        return true;
      }
    }
    return false;
  }
  
  float c(int paramInt)
  {
    int i1 = SVHwEncoder.r(this.this$0);
    int i2 = SVHwEncoder.s(this.this$0);
    int i3 = SVHwEncoder.t(this.this$0);
    return paramInt * 1000.0F / (i1 * i2 * i3);
  }
  
  void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.z);
    localStringBuilder.append("shortvideo_seg_");
    localStringBuilder.append(this.A);
    localStringBuilder.append(".mp4");
    this.C = localStringBuilder.toString();
    this.A += 1;
  }
  
  void c(String paramString)
  {
    SVHwEncoder localSVHwEncoder = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(": mExitVideoEncode=");
    localStringBuilder.append(SVHwEncoder.c(this.this$0));
    localStringBuilder.append(" mVideoWritedFrameCount=");
    localStringBuilder.append(this.D);
    localStringBuilder.append(" mVideoEncodedframeCount=");
    localStringBuilder.append(this.E);
    localStringBuilder.append(" mVideoMuxeredframeCount=");
    localStringBuilder.append(this.F);
    localSVHwEncoder.a(paramString, localStringBuilder.toString());
    localSVHwEncoder = this.this$0;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(": mExitVideoEncode=");
    localStringBuilder.append(SVHwEncoder.c(this.this$0));
    localStringBuilder.append(" mAudioWritedFrameCount=");
    localStringBuilder.append(this.G);
    localStringBuilder.append(" mAudioEncodedframeCount=");
    localStringBuilder.append(this.H);
    localStringBuilder.append(" mAudioMuxeredframeCount=");
    localStringBuilder.append(this.I);
    localSVHwEncoder.a(paramString, localStringBuilder.toString());
  }
  
  void c(boolean paramBoolean)
  {
    try
    {
      SVHwCodec localSVHwCodec = a(paramBoolean);
      this.Z.a();
      localSVHwCodec.c();
      if (paramBoolean) {
        this.Z.d = this.Z.b();
      } else {
        this.Z.i = this.Z.b();
      }
      this.Z.a();
      localSVHwCodec.d();
      if (paramBoolean)
      {
        this.Z.f = this.Z.b();
        return;
      }
      this.Z.k = this.Z.b();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.z);
    localStringBuilder.append("shortvideo_merge.mp4");
    return localStringBuilder.toString();
  }
  
  boolean d(boolean paramBoolean)
  {
    SVHwEncoder localSVHwEncoder1 = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release mMuxerCreated=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" needCatch=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("......");
    localSVHwEncoder1.a("hw_media_muxer_seg", localStringBuilder.toString());
    boolean bool3 = this.f;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3)
    {
      this.f = false;
      this.o = -1;
      this.p = -1;
      if (paramBoolean) {
        try
        {
          this.x.stop();
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          localIllegalStateException1.printStackTrace();
          return true;
        }
      } else {
        this.x.stop();
      }
      SVHwEncoder localSVHwEncoder2 = this.this$0;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("release mMuxerCreated=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" needCatch=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("topped...");
      localSVHwEncoder2.a("hw_media_muxer_seg", localStringBuilder.toString());
      if (paramBoolean)
      {
        try
        {
          this.x.release();
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
        this.x.release();
        paramBoolean = bool2;
      }
      this.x = null;
      bool1 = paramBoolean;
    }
    return bool1;
  }
  
  public SVHwEncoder.HwFrame e()
  {
    return this.d.e();
  }
  
  int f()
  {
    this.Z.a();
    boolean bool = this.J.a(this.q, this.s);
    SVHwEncoder.HwEncode.HwTimeTool localHwTimeTool = this.Z;
    localHwTimeTool.c = localHwTimeTool.b();
    if (!bool) {
      return -2;
    }
    return 0;
  }
  
  int g()
  {
    this.Z.a();
    boolean bool1;
    if (this.u != null)
    {
      this.r.setInteger("aac-profile", this.w);
      bool1 = this.K.a(this.r, this.u);
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
        ((StringBuilder)localObject).append(this.u);
        QLog.d("SVHwEncoder", 2, ((StringBuilder)localObject).toString());
      }
      bool2 = bool1;
      if (this.t != null)
      {
        this.r.setInteger("aac-profile", this.v);
        bool2 = this.K.a(this.r, this.t);
      }
    }
    Object localObject = this.Z;
    ((SVHwEncoder.HwEncode.HwTimeTool)localObject).h = ((SVHwEncoder.HwEncode.HwTimeTool)localObject).b();
    if (!bool2) {
      return -8;
    }
    return 0;
  }
  
  long h()
  {
    if (SVHwEncoder.b(this.this$0)) {
      return this.aa;
    }
    long l2 = this.Z.c();
    int i1 = this.aa;
    long l1 = l2;
    if (l2 > i1) {
      l1 = i1;
    }
    return l1;
  }
  
  long i()
  {
    if (SVHwEncoder.b(this.this$0)) {
      return this.aa;
    }
    long l2 = this.Z.d();
    int i1 = this.aa;
    long l1 = l2;
    if (l2 > i1) {
      l1 = i1;
    }
    return l1;
  }
  
  void j()
  {
    if ((this.A == 1) && (!SVHwEncoder.b(this.this$0)) && (!this.T) && (this.D >= 1))
    {
      this.Z.a();
      this.U = false;
      Object localObject = this.a;
      ((SVHwThumbGen)localObject).b = null;
      ((SVHwThumbGen)localObject).a = null;
      ((SVHwThumbGen)localObject).c = 0;
      ((SVHwThumbGen)localObject).d = 0L;
      new SVHwEncoder.HwEncode.HwThumbGenTask(this).execute(new Void[0]);
      this.T = true;
      localObject = this.Z;
      ((SVHwEncoder.HwEncode.HwTimeTool)localObject).m = ((SVHwEncoder.HwEncode.HwTimeTool)localObject).b();
    }
  }
  
  void k()
  {
    this.e = 0;
    if ((this.U) && (!this.V))
    {
      if (this.a.c != 0)
      {
        this.e = -9;
        b(-9, this.a.c);
        localSVHwEncoder = this.this$0;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("genThumbFile mLastErrCode=");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" subcode=");
        localStringBuilder.append(this.a.c);
        localSVHwEncoder.a("hw_av_merge_segment", localStringBuilder.toString());
      }
      else
      {
        a(this.a.b, SVHwEncoder.n(this.this$0), SVHwEncoder.o(this.this$0), this.a.a);
      }
      SVHwEncoder localSVHwEncoder = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("svThumbOK:mCallSegmentIndex=");
      localStringBuilder.append(this.B);
      localStringBuilder.append(" mLastErrCode=");
      localStringBuilder.append(this.e);
      localSVHwEncoder.a("hw_video_segment_notify_msg", localStringBuilder.toString());
      this.Z.l = this.a.d;
      this.V = true;
    }
  }
  
  void l()
  {
    synchronized (this.X)
    {
      SVHwEncoder localSVHwEncoder = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseThread:mHavePaused=");
      localStringBuilder.append(this.W);
      localSVHwEncoder.a("pauseThread", localStringBuilder.toString());
      if (!this.W) {
        this.W = true;
      }
    }
    try
    {
      this.X.wait();
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
  
  void m()
  {
    int i1 = this.Q.size();
    String str = d();
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
      localObject1 = this.Q;
      i1 = 0;
      localObject1 = new File((String)((ArrayList)localObject1).get(0));
      localObject2 = new File(str);
      if (SVHwEncoder.b(this.this$0))
      {
        if ((this.F <= 0) && (this.I <= 0))
        {
          i1 = -2;
          FileUtils.deleteFile(((File)localObject1).getAbsolutePath());
          localObject1 = this.this$0;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[mOnlyGenOneMp4:check]mVideoMuxeredframeCount=");
          ((StringBuilder)localObject2).append(this.F);
          ((StringBuilder)localObject2).append(" mAudioMuxeredframeCount=");
          ((StringBuilder)localObject2).append(this.I);
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
      i1 = SVMp4Merge.a(this.Q, str);
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
      a(str, SVHwEncoder.e(this.this$0), l1);
      this.this$0.a("hw_av_merge_segment", "notify merge OK......");
      return;
    }
    b(-40, i1);
    FileUtils.deleteDirectory(this.z);
    this.this$0.a("hw_av_merge_segment", "merge error delete cache......");
  }
  
  int n()
  {
    Object localObject = SVHwCodec.c;
    this.Z.a();
    this.q = MediaFormat.createVideoFormat((String)localObject, SVHwEncoder.j(this.this$0), SVHwEncoder.k(this.this$0));
    int i1 = a(this.q, (String)localObject, (int)SVHwEncoder.f(this.this$0), SVHwEncoder.u(this.this$0));
    localObject = this.Z;
    ((SVHwEncoder.HwEncode.HwTimeTool)localObject).b = ((SVHwEncoder.HwEncode.HwTimeTool)localObject).b();
    if (i1 != 0) {
      return i1;
    }
    if (!this.n) {
      return i1;
    }
    this.Z.a();
    i1 = a(SVHwEncoder.r(this.this$0), SVHwEncoder.s(this.this$0), SVHwEncoder.v(this.this$0));
    localObject = this.Z;
    ((SVHwEncoder.HwEncode.HwTimeTool)localObject).g = ((SVHwEncoder.HwEncode.HwTimeTool)localObject).b();
    if (i1 != 0) {}
    return i1;
  }
  
  void o()
  {
    this.q.setInteger("width", SVHwEncoder.j(this.this$0));
    this.q.setInteger("height", SVHwEncoder.k(this.this$0));
  }
  
  int p()
  {
    o();
    int i1 = f();
    if (i1 != 0) {
      return i1;
    }
    q();
    i1 = b(true);
    if (i1 != 0) {
      return i1;
    }
    if (!this.n) {
      return i1;
    }
    i1 = g();
    if (i1 != 0) {
      return i1;
    }
    return b(false);
  }
  
  void q() {}
  
  void r() {}
  
  public void run()
  {
    this.e = n();
    if (this.e != 0)
    {
      ??? = this.this$0;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(" err=");
      localStringBuilder1.append(this.e);
      ((SVHwEncoder)???).a("configHardWareComponent", localStringBuilder1.toString());
      b(this.e, 0);
      this.q = null;
      this.r = null;
      return;
    }
    boolean bool1 = SVHwEncoder.b(this.this$0);
    long l2 = 1000L;
    if ((!bool1) && (!Lock.b)) {}
    for (;;)
    {
      synchronized (Lock.a)
      {
        bool1 = Lock.b;
        if (bool1) {}
      }
      try
      {
        Lock.a.wait(1000L);
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
        this.e = p();
        if (this.e != 0)
        {
          ??? = this.this$0;
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append(" err=");
          ((StringBuilder)localObject8).append(this.e);
          ((SVHwEncoder)???).a("initEncodeStatus", ((StringBuilder)localObject8).toString());
          b(this.e, 0);
          c(true);
          c(false);
          r();
          return;
        }
        long l1 = l2;
        if (SVHwEncoder.b(this.this$0))
        {
          this.O = true;
          ??? = this.this$0;
          SVHwEncoder.a((SVHwEncoder)???, SVHwEncoder.d((SVHwEncoder)???) * 1000 / SVHwEncoder.e(this.this$0));
          this.N.a();
          this.N.a(SVHwEncoder.f(this.this$0));
          ??? = this.this$0;
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append("mTotalFrames=");
          ((StringBuilder)localObject8).append(SVHwEncoder.d(this.this$0));
          ((StringBuilder)localObject8).append(" mTotalTimes=");
          ((StringBuilder)localObject8).append(SVHwEncoder.e(this.this$0));
          ((StringBuilder)localObject8).append(" mVideoFps=");
          ((StringBuilder)localObject8).append(SVHwEncoder.f(this.this$0));
          ((SVHwEncoder)???).a("HwEncodeHelper:mOnlyGenOneMp4", ((StringBuilder)localObject8).toString());
          l1 = l2;
        }
        for (;;)
        {
          if (!SVHwEncoder.a(this.this$0))
          {
            if ((!SVHwEncoder.b(this.this$0)) && (!this.i))
            {
              ??? = this.this$0;
              ??? = ((SVHwEncoder)???).a(SVHwEncoder.g((SVHwEncoder)???));
            }
            else
            {
              ??? = null;
            }
            localObject8 = this.this$0;
            Object localObject9 = new StringBuilder();
            ((StringBuilder)localObject9).append("mVideoSourceDone=");
            ((StringBuilder)localObject9).append(this.i);
            ((StringBuilder)localObject9).append(" mDataSource=");
            ((StringBuilder)localObject9).append(this.d);
            ((SVHwEncoder)localObject8).a("hw_video_write_frame", ((StringBuilder)localObject9).toString());
            localObject8 = this.this$0;
            localObject9 = new StringBuilder();
            ((StringBuilder)localObject9).append("mMuxerCreated=");
            ((StringBuilder)localObject9).append(this.f);
            ((StringBuilder)localObject9).append(" encoderOutputVideoFormat=");
            ((StringBuilder)localObject9).append(this.g);
            ((SVHwEncoder)localObject8).a("hw_video_write_frame", ((StringBuilder)localObject9).toString());
            if (((??? != null) || ((SVHwEncoder.b(this.this$0)) && (!this.i))) && ((this.g == null) || (this.f))) {}
            try
            {
              l2 = h();
              localObject8 = this.this$0;
              localObject9 = new StringBuilder();
              ((StringBuilder)localObject9).append("videotimeout=");
              ((StringBuilder)localObject9).append(l2);
              ((SVHwEncoder)localObject8).a("hw_video_timestamp", ((StringBuilder)localObject9).toString());
              localObject9 = this.J.a(l2);
              int i1;
              int i2;
              StringBuilder localStringBuilder2;
              Object localObject2;
              if ((localObject9 != null) && (((SVHwCodec.BufferData)localObject9).c != -1))
              {
                if (((SVHwCodec.BufferData)localObject9).a == null)
                {
                  ??? = this.b;
                  ((SVHwEncoder.HwEncode.IntelX86Error)???).a += 1;
                  ??? = this.this$0;
                  localObject8 = new StringBuilder();
                  ((StringBuilder)localObject8).append("INFO_TRY_AGAIN_LATER: buffer = null mVideoBuferErrCount=");
                  ((StringBuilder)localObject8).append(this.b.a);
                  ((SVHwEncoder)???).a("hw_intel_x86__err_msg", ((StringBuilder)localObject8).toString());
                  if (this.b.a >= 3)
                  {
                    this.e = -21;
                    b(this.e, 0);
                    break label5780;
                  }
                }
                else
                {
                  this.b.a = 0;
                  localObject8 = ???;
                  if (SVHwEncoder.b(this.this$0))
                  {
                    localObject8 = ???;
                    if (this.d != null) {
                      localObject8 = b(this.this$0.a);
                    }
                  }
                  if (!((SVHwEncoder.HwFrame)localObject8).e)
                  {
                    ((SVHwCodec.BufferData)localObject9).a.clear();
                    i1 = ((SVHwCodec.BufferData)localObject9).a.capacity();
                    i2 = ((SVHwEncoder.HwFrame)localObject8).c - ((SVHwEncoder.HwFrame)localObject8).b;
                    if (i1 >= i2)
                    {
                      ((SVHwCodec.BufferData)localObject9).a.put(((SVHwEncoder.HwFrame)localObject8).a, ((SVHwEncoder.HwFrame)localObject8).b, i2);
                      ((SVHwEncoder.HwFrame)localObject8).b += i2;
                      l2 = ((SVHwEncoder.HwFrame)localObject8).d * l1;
                      if (this.O) {
                        l1 = this.N.a(((SVHwEncoder.HwFrame)localObject8).d);
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
                        this.J.a((SVHwCodec.BufferData)localObject9, ((SVHwEncoder.HwFrame)localObject8).c, l1, 0);
                        this.D += 1;
                        ??? = this.this$0;
                        localObject9 = new StringBuilder();
                        ((StringBuilder)localObject9).append("mVideoWritedFrameCount=");
                        ((StringBuilder)localObject9).append(this.D);
                        ((SVHwEncoder)???).a("hw_video_write_frame", ((StringBuilder)localObject9).toString());
                        this.Z.a(true);
                      }
                      catch (IllegalStateException localIllegalStateException1)
                      {
                        localIllegalStateException1.printStackTrace();
                        this.e = -17;
                        b(this.e, 0);
                        break label5780;
                      }
                    }
                    else
                    {
                      this.e = -12;
                      b(this.e, 0);
                      break label5780;
                    }
                  }
                  else
                  {
                    this.J.a((SVHwCodec.BufferData)localObject9, 0, 0L, 4);
                    this.i = true;
                    localObject2 = this.this$0;
                    localObject9 = new StringBuilder();
                    ((StringBuilder)localObject9).append("[end-of-stream] fps=");
                    ((StringBuilder)localObject9).append(((SVHwEncoder.HwFrame)localObject8).g);
                    ((StringBuilder)localObject9).append(" bitrate");
                    ((StringBuilder)localObject9).append(((SVHwEncoder.HwFrame)localObject8).h);
                    ((SVHwEncoder)localObject2).a("hw_video_write_frame", ((StringBuilder)localObject9).toString());
                    if ((((SVHwEncoder.HwFrame)localObject8).g > 0.0F) && (!SVHwEncoder.b(this.this$0)))
                    {
                      localObject2 = this.this$0;
                      localObject9 = new StringBuilder();
                      ((StringBuilder)localObject9).append("mNeedDoSmooth=");
                      ((StringBuilder)localObject9).append(this.O);
                      ((StringBuilder)localObject9).append(" mUpdateVideoFps=");
                      ((StringBuilder)localObject9).append(this.P);
                      ((StringBuilder)localObject9).append(" mVideoFps=");
                      ((StringBuilder)localObject9).append(SVHwEncoder.f(this.this$0));
                      ((SVHwEncoder)localObject2).a("hw_smooth_time_stamp", ((StringBuilder)localObject9).toString());
                      SVHwEncoder.a(this.this$0, ((SVHwEncoder.HwFrame)localObject8).g);
                      if (!this.O)
                      {
                        this.P = true;
                        localObject2 = this.this$0;
                        localObject9 = new StringBuilder();
                        ((StringBuilder)localObject9).append("mNeedDoSmooth=");
                        ((StringBuilder)localObject9).append(this.O);
                        ((StringBuilder)localObject9).append(" mUpdateVideoFps=");
                        ((StringBuilder)localObject9).append(this.P);
                        ((StringBuilder)localObject9).append(" mVideoFps=");
                        ((StringBuilder)localObject9).append(SVHwEncoder.f(this.this$0));
                        ((SVHwEncoder)localObject2).a("hw_smooth_time_stamp", ((StringBuilder)localObject9).toString());
                      }
                    }
                    if (((SVHwEncoder.HwFrame)localObject8).h > 0) {
                      SVHwEncoder.a(this.this$0, ((SVHwEncoder.HwFrame)localObject8).h);
                    }
                  }
                  if ((this.d == null) && (((SVHwEncoder.HwFrame)localObject8).b == ((SVHwEncoder.HwFrame)localObject8).c))
                  {
                    localObject2 = this.this$0;
                    ((SVHwEncoder)localObject2).b(SVHwEncoder.g((SVHwEncoder)localObject2));
                    if (!this.this$0.a((SVHwEncoder.HwFrame)localObject8)) {
                      ((SVHwEncoder.HwFrame)localObject8).a = null;
                    }
                  }
                }
              }
              else {
                this.this$0.a("hw_video_write_frame", "INFO_TRY_AGAIN_LATER");
              }
              if ((!SVHwEncoder.b(this.this$0)) && (!this.j))
              {
                localObject2 = this.this$0;
                localObject2 = ((SVHwEncoder)localObject2).a(SVHwEncoder.h((SVHwEncoder)localObject2));
              }
              else
              {
                localObject2 = null;
              }
              if ((localObject2 == null) && ((!SVHwEncoder.b(this.this$0)) || (this.j))) {}
              label1654:
              while ((this.h != null) && (!this.f)) {
                break;
              }
              try
              {
                l1 = i();
                localObject8 = this.this$0;
                localObject9 = new StringBuilder();
                ((StringBuilder)localObject9).append("audiotimeout=");
                ((StringBuilder)localObject9).append(l1);
                ((SVHwEncoder)localObject8).a("hw_audio_timestamp", ((StringBuilder)localObject9).toString());
                localObject9 = this.K.a(l1);
                Object localObject3;
                if ((localObject9 != null) && (((SVHwCodec.BufferData)localObject9).c != -1))
                {
                  if (((SVHwCodec.BufferData)localObject9).a == null)
                  {
                    localObject2 = this.b;
                    ((SVHwEncoder.HwEncode.IntelX86Error)localObject2).b += 1;
                    localObject2 = this.this$0;
                    localObject8 = new StringBuilder();
                    ((StringBuilder)localObject8).append("INFO_TRY_AGAIN_LATER: buffer=null mAudioBuferErrCount=");
                    ((StringBuilder)localObject8).append(this.b.b);
                    ((SVHwEncoder)localObject2).a("hw_intel_x86__err_msg", ((StringBuilder)localObject8).toString());
                    if (this.b.b < 3) {
                      break label1654;
                    }
                    this.e = -20;
                    b(this.e, 0);
                    break label5780;
                  }
                  this.b.b = 0;
                  localObject8 = localObject2;
                  if (SVHwEncoder.b(this.this$0))
                  {
                    localObject8 = localObject2;
                    if (this.d != null) {
                      localObject8 = e();
                    }
                  }
                  if (!((SVHwEncoder.HwFrame)localObject8).e)
                  {
                    ((SVHwCodec.BufferData)localObject9).a.clear();
                    i2 = ((SVHwCodec.BufferData)localObject9).a.capacity();
                    int i3 = ((SVHwEncoder.HwFrame)localObject8).c - ((SVHwEncoder.HwFrame)localObject8).b;
                    if (i2 >= i3)
                    {
                      ((SVHwCodec.BufferData)localObject9).a.put(((SVHwEncoder.HwFrame)localObject8).a, ((SVHwEncoder.HwFrame)localObject8).b, i3);
                      ((SVHwEncoder.HwFrame)localObject8).b += i3;
                      i1 = i3;
                    }
                    else
                    {
                      ((SVHwCodec.BufferData)localObject9).a.put(((SVHwEncoder.HwFrame)localObject8).a, ((SVHwEncoder.HwFrame)localObject8).b, i2);
                      ((SVHwEncoder.HwFrame)localObject8).b += i2;
                      i1 = i2;
                    }
                    localObject2 = this.this$0;
                    localStringBuilder2 = new StringBuilder();
                    localStringBuilder2.append("offset=");
                    localStringBuilder2.append(((SVHwEncoder.HwFrame)localObject8).b);
                    localStringBuilder2.append(" size=");
                    localStringBuilder2.append(((SVHwEncoder.HwFrame)localObject8).c);
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
                    l2 = ((SVHwEncoder.HwFrame)localObject8).d * 1000L;
                    if (this.O)
                    {
                      float f1 = c(i1);
                      l1 = this.N.b(f1);
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
                      localObject2 = this.K;
                      try
                      {
                        ((SVHwCodec)localObject2).a((SVHwCodec.BufferData)localObject9, i1, l1, 0);
                        this.G += 1;
                        localObject2 = this.this$0;
                        localObject9 = new StringBuilder();
                        ((StringBuilder)localObject9).append("mWritedFrameCount=");
                        ((StringBuilder)localObject9).append(this.G);
                        ((SVHwEncoder)localObject2).a("hw_audio_write_frame", ((StringBuilder)localObject9).toString());
                        this.Z.a(false);
                      }
                      catch (IllegalStateException localIllegalStateException2) {}
                      localObject9 = this.this$0;
                    }
                    catch (IllegalStateException localIllegalStateException3) {}
                    localStringBuilder2 = new StringBuilder();
                    localStringBuilder2.append("offset=");
                    localStringBuilder2.append(((SVHwEncoder.HwFrame)localObject8).b);
                    localStringBuilder2.append(" size=");
                    localStringBuilder2.append(((SVHwEncoder.HwFrame)localObject8).c);
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
                    this.e = -16;
                    b(this.e, 0);
                    break label5780;
                  }
                  this.K.a((SVHwCodec.BufferData)localObject9, 0, 0L, 4);
                  this.j = true;
                  localObject3 = this.this$0;
                  localObject9 = new StringBuilder();
                  ((StringBuilder)localObject9).append("mWritedFrameCount=");
                  ((StringBuilder)localObject9).append(this.G);
                  ((StringBuilder)localObject9).append(" [Finish]...");
                  ((SVHwEncoder)localObject3).a("hw_audio_write_frame", ((StringBuilder)localObject9).toString());
                  if ((this.d != null) || (((SVHwEncoder.HwFrame)localObject8).b != ((SVHwEncoder.HwFrame)localObject8).c)) {
                    break label2652;
                  }
                  localObject3 = this.this$0;
                  ((SVHwEncoder)localObject3).b(SVHwEncoder.h((SVHwEncoder)localObject3));
                  ((SVHwEncoder.HwFrame)localObject8).a = null;
                  break label2652;
                }
                this.this$0.a("hw_audio_write_frame", "INFO_TRY_AGAIN_LATER");
                label2652:
                if ((this.i) && (this.j) && (this.P) && (!SVHwEncoder.b(this.this$0)))
                {
                  localObject3 = this.this$0;
                  localObject8 = new StringBuilder();
                  ((StringBuilder)localObject8).append("mUpdateVideoFps=");
                  ((StringBuilder)localObject8).append(this.P);
                  ((StringBuilder)localObject8).append(" mVideoFps=");
                  ((StringBuilder)localObject8).append(SVHwEncoder.f(this.this$0));
                  ((SVHwEncoder)localObject3).a("hw_smooth_time_stamp", ((StringBuilder)localObject8).toString());
                  this.P = false;
                  this.O = true;
                  this.N.a();
                  this.N.a(SVHwEncoder.f(this.this$0));
                }
                if ((this.S) && (!this.k) && ((this.g == null) || (this.f))) {
                  try
                  {
                    l1 = h();
                    localObject3 = this.this$0;
                    localObject8 = new StringBuilder();
                    ((StringBuilder)localObject8).append("videoOutTime=");
                    ((StringBuilder)localObject8).append(l1);
                    ((SVHwEncoder)localObject3).a("hw_video_encode_frame", ((StringBuilder)localObject8).toString());
                    localObject3 = this.J.b(l1);
                    if (localObject3 == null)
                    {
                      this.this$0.a("hw_video_encode_frame", "encoderOutputBuffer=null");
                    }
                    else
                    {
                      localObject8 = ((SVHwCodec.BufferData)localObject3).d;
                      i1 = ((SVHwCodec.BufferData)localObject3).c;
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
                        this.g = this.J.e().getOutputFormat();
                        this.Y.a(this.g);
                        this.this$0.a("hw_video_encode_frame", "out format changed");
                      }
                      else if ((((MediaCodec.BufferInfo)localObject8).flags & 0x2) != 0)
                      {
                        this.this$0.a("hw_video_encode_frame", "get Config data...");
                        this.this$0.a(((SVHwCodec.BufferData)localObject3).a, (MediaCodec.BufferInfo)localObject8, "mVideoEncoder_dequeueOutputBuffer", 30);
                        this.J.a((SVHwCodec.BufferData)localObject3);
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
                          this.Z.b(true);
                          this.E += 1;
                          if (this.x != null)
                          {
                            if ((((MediaCodec.BufferInfo)localObject8).flags & 0x1) != 0)
                            {
                              localObject9 = this.Y;
                              ((SVHwEncoder.HwEncode.MuxerValidData)localObject9).a = true;
                              if (this.F == 0) {
                                ((SVHwEncoder.HwEncode.MuxerValidData)localObject9).c = true;
                              }
                            }
                            if (this.F == 0) {
                              if (this.I == 0) {
                                this.Y.b = true;
                              } else {
                                this.Y.b = false;
                              }
                            }
                            this.F += 1;
                            localObject9 = this.this$0;
                            localStringBuilder2 = new StringBuilder();
                            localStringBuilder2.append("track=");
                            localStringBuilder2.append(this.o);
                            localStringBuilder2.append(" pts=");
                            localStringBuilder2.append(((MediaCodec.BufferInfo)localObject8).presentationTimeUs);
                            ((SVHwEncoder)localObject9).a("hw_video_writesample", localStringBuilder2.toString());
                            this.Y.a(((MediaCodec.BufferInfo)localObject8).presentationTimeUs, true);
                            this.Z.a();
                            try
                            {
                              this.x.writeSampleData(this.o, ((SVHwCodec.BufferData)localObject3).a, (MediaCodec.BufferInfo)localObject8);
                              this.Z.c(true);
                            }
                            catch (Throwable localThrowable1)
                            {
                              if (QLog.isColorLevel()) {
                                QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of video erro", localThrowable1);
                              }
                              this.e = -25;
                              b(this.e, 0);
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
                          this.k = true;
                          this.this$0.a("hw_video_encode_frame", "end of stream");
                        }
                        this.J.a(localThrowable1);
                      }
                    }
                  }
                  catch (IllegalStateException localIllegalStateException4)
                  {
                    localIllegalStateException4.printStackTrace();
                    this.e = -23;
                    b(this.e, 0);
                    break label5780;
                  }
                }
                if ((this.S) && (!this.l) && ((this.h == null) || (this.f))) {
                  try
                  {
                    l1 = i();
                    Object localObject4 = this.this$0;
                    localObject8 = new StringBuilder();
                    ((StringBuilder)localObject8).append("audioOutTime=");
                    ((StringBuilder)localObject8).append(l1);
                    ((SVHwEncoder)localObject4).a("hw_audio_encode_frame", ((StringBuilder)localObject8).toString());
                    localObject4 = this.K.b(l1);
                    if (localObject4 == null)
                    {
                      this.this$0.a("hw_audio_encode_frame", "encoderOutputBuffer=null");
                    }
                    else
                    {
                      localObject8 = ((SVHwCodec.BufferData)localObject4).d;
                      i1 = ((SVHwCodec.BufferData)localObject4).c;
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
                        this.h = this.K.e().getOutputFormat();
                        this.Y.b(this.h);
                        this.this$0.a("hw_audio_encode_frame", "out format change");
                      }
                      else if ((((MediaCodec.BufferInfo)localObject8).flags & 0x2) != 0)
                      {
                        this.this$0.a("hw_audio_encode_frame", "get config......");
                        this.this$0.a(((SVHwCodec.BufferData)localObject4).a, (MediaCodec.BufferInfo)localObject8, "mAudioEncoder_dequeueOutputBuffer", 10);
                        this.K.a((SVHwCodec.BufferData)localObject4);
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
                          this.Z.b(false);
                          this.H += 1;
                          if (this.x != null)
                          {
                            this.I += 1;
                            localObject9 = this.this$0;
                            localStringBuilder2 = new StringBuilder();
                            localStringBuilder2.append("track=");
                            localStringBuilder2.append(this.p);
                            localStringBuilder2.append(" pts=");
                            localStringBuilder2.append(((MediaCodec.BufferInfo)localObject8).presentationTimeUs);
                            ((SVHwEncoder)localObject9).a("hw_audio_writesample", localStringBuilder2.toString());
                            if (!this.Y.a(((MediaCodec.BufferInfo)localObject8).presentationTimeUs, false))
                            {
                              this.Z.a();
                              try
                              {
                                this.x.writeSampleData(this.p, ((SVHwCodec.BufferData)localObject4).a, (MediaCodec.BufferInfo)localObject8);
                                this.Z.c(false);
                              }
                              catch (Throwable localThrowable2)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of audio erro", localThrowable2);
                                }
                                this.e = -24;
                                b(this.e, 0);
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
                          this.l = true;
                          this.this$0.a("hw_audio_encode_frame", "end of stream");
                        }
                        this.K.a(localThrowable2);
                      }
                    }
                  }
                  catch (IllegalStateException localIllegalStateException5)
                  {
                    localIllegalStateException5.printStackTrace();
                    this.e = -22;
                    b(this.e, 0);
                    break label5780;
                  }
                }
                if ((SVHwEncoder.b(this.this$0)) && (!this.M))
                {
                  i1 = this.E * 100 / SVHwEncoder.d(this.this$0);
                  a(i1);
                  if (i1 >= 100) {
                    this.M = true;
                  }
                }
                if (SVHwEncoder.i(this.this$0)) {
                  l();
                }
                j();
                k();
                if (this.e == 0)
                {
                  Object localObject5;
                  if ((this.k) && (this.l))
                  {
                    bool1 = this.Y.c();
                    this.Y.d();
                    if (!bool1)
                    {
                      localObject5 = this.this$0;
                      localObject8 = new StringBuilder();
                      ((StringBuilder)localObject8).append("validSegment=");
                      ((StringBuilder)localObject8).append(bool1);
                      ((SVHwEncoder)localObject5).a("releaseMuxer[check]", ((StringBuilder)localObject8).toString());
                      this.e = -14;
                      b(this.e, 0);
                    }
                    else if (d(true))
                    {
                      this.e = -14;
                      b(this.e, 1);
                    }
                    else
                    {
                      if (this.V)
                      {
                        if (this.B + 1 < this.A)
                        {
                          if (this.Q.size() != this.A - 1)
                          {
                            this.e = -15;
                            b(this.e, 0);
                            break label5780;
                          }
                          i1 = 0;
                          while (i1 < this.Q.size())
                          {
                            localObject5 = this.this$0;
                            localObject8 = new StringBuilder();
                            ((StringBuilder)localObject8).append("svSegmentOK:[roll] i=");
                            ((StringBuilder)localObject8).append(i1);
                            ((StringBuilder)localObject8).append(" mCallSegmentIndex=");
                            ((StringBuilder)localObject8).append(this.B);
                            ((SVHwEncoder)localObject5).a("hw_video_segment_notify_msg", ((StringBuilder)localObject8).toString());
                            localObject5 = (String)this.Q.get(i1);
                            i1 += 1;
                            a((String)localObject5, i1, SVHwEncoder.j(this.this$0), SVHwEncoder.k(this.this$0));
                            this.B += 1;
                          }
                        }
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("svSegmentOK:[new]mCallSegmentIndex=");
                        ((StringBuilder)localObject8).append(this.B);
                        ((SVHwEncoder)localObject5).a("hw_video_segment_notify_msg", ((StringBuilder)localObject8).toString());
                        a(this.C, this.A, SVHwEncoder.j(this.this$0), SVHwEncoder.k(this.this$0));
                        this.Q.add(this.C);
                        this.B += 1;
                      }
                      else
                      {
                        this.Q.add(this.C);
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("mHasCallSVThumbOk=");
                        ((StringBuilder)localObject8).append(this.V);
                        ((StringBuilder)localObject8).append(" size=");
                        ((StringBuilder)localObject8).append(this.Q.size());
                        ((SVHwEncoder)localObject5).a("hw_video_segment_notify_msg", ((StringBuilder)localObject8).toString());
                      }
                      if ((!SVHwEncoder.b(this.this$0)) && (!b("VideoEncodeExit[one]")))
                      {
                        c(true);
                        c(false);
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("HwTimeUsed=");
                        ((StringBuilder)localObject8).append(this.Z.toString());
                        ((SVHwEncoder)localObject5).a("hw_video_time_used_msg", ((StringBuilder)localObject8).toString());
                        c();
                        this.e = s();
                        i1 = this.e;
                        if (i1 != 0)
                        {
                          b(i1, 0);
                        }
                        else
                        {
                          if (this.n)
                          {
                            this.e = t();
                            i1 = this.e;
                            if (i1 != 0)
                            {
                              b(i1, 0);
                              break label5780;
                            }
                          }
                          this.k = false;
                          if (this.n) {
                            this.l = false;
                          }
                          u();
                          this.R = true;
                        }
                      }
                    }
                  }
                  else
                  {
                    if (this.R)
                    {
                      if (b("VideoEncodeExit[two]")) {
                        break label5780;
                      }
                      boolean bool2 = a(SVHwEncoder.g(this.this$0));
                      if (this.n) {
                        bool1 = a(SVHwEncoder.h(this.this$0));
                      } else {
                        bool1 = false;
                      }
                      if (SVHwEncoder.c(this.this$0))
                      {
                        if (!bool2) {
                          this.m = false;
                        }
                        if (!bool1) {
                          this.n = false;
                        }
                        if ((!this.m) && (!this.n))
                        {
                          localObject5 = new StringBuilder();
                          ((StringBuilder)localObject5).append("VideoEncodeExit[Four]startVideo=");
                          ((StringBuilder)localObject5).append(bool2);
                          ((StringBuilder)localObject5).append(" startAudio=");
                          ((StringBuilder)localObject5).append(bool1);
                          c(((StringBuilder)localObject5).toString());
                          break label5780;
                        }
                      }
                      if (!this.m)
                      {
                        this.k = true;
                        this.g = null;
                        bool2 = true;
                      }
                      if (!this.n)
                      {
                        this.l = true;
                        this.h = null;
                        bool1 = true;
                      }
                      if ((bool2) && (bool1))
                      {
                        this.i = false;
                        this.j = false;
                        this.S = true;
                        this.R = false;
                        this.Y.a("releaseMuxer[mEnableEncode=true]");
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("track=");
                        ((StringBuilder)localObject8).append(this.o);
                        ((SVHwEncoder)localObject5).a("hw_video_writesample", ((StringBuilder)localObject8).toString());
                        localObject5 = this.this$0;
                        localObject8 = new StringBuilder();
                        ((StringBuilder)localObject8).append("track=");
                        ((StringBuilder)localObject8).append(this.p);
                        ((SVHwEncoder)localObject5).a("hw_audio_writesample", ((StringBuilder)localObject8).toString());
                        this.this$0.a("hw_video_timestamp", "new segment");
                        this.this$0.a("hw_audio_timestamp", "new segment");
                      }
                      else
                      {
                        this.S = false;
                      }
                    }
                    else if (SVHwEncoder.c(this.this$0))
                    {
                      localObject5 = this.this$0;
                      i2 = ((SVHwEncoder)localObject5).c(SVHwEncoder.g((SVHwEncoder)localObject5));
                      if (this.n)
                      {
                        localObject5 = this.this$0;
                        i1 = ((SVHwEncoder)localObject5).c(SVHwEncoder.h((SVHwEncoder)localObject5));
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
                      c(((StringBuilder)localObject5).toString());
                      if (((i2 <= 0) && (i1 <= 0)) || ((this.n) && (i1 <= 0) && (this.k) && (i2 <= 3)))
                      {
                        if (i2 > 0)
                        {
                          localObject5 = this.this$0;
                          localObject8 = new StringBuilder();
                          ((StringBuilder)localObject8).append("videoSize=");
                          ((StringBuilder)localObject8).append(i2);
                          ((StringBuilder)localObject8).append(" mVideoEncodeDone=");
                          ((StringBuilder)localObject8).append(this.k);
                          ((SVHwEncoder)localObject5).a("VideoEncodeExit[three]", ((StringBuilder)localObject8).toString());
                          localObject5 = this.this$0;
                          ((SVHwEncoder)localObject5).d(SVHwEncoder.g((SVHwEncoder)localObject5));
                        }
                        c("VideoEncodeExit[three]");
                        this.this$0.d();
                      }
                    }
                    if ((!this.f) && ((this.g != null) || (!this.m)) && ((this.h != null) || (!this.n)))
                    {
                      this.Z.a();
                      try
                      {
                        this.x = new MediaMuxer(this.C, 0);
                        this.x.setOrientationHint(SVHwEncoder.l(this.this$0));
                      }
                      catch (IOException localIOException)
                      {
                        localIOException.printStackTrace();
                        this.x = null;
                        this.f = false;
                        this.e = -11;
                      }
                      Object localObject6 = this.Z;
                      ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).n = ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).b();
                      i1 = this.e;
                      if (i1 != 0)
                      {
                        b(i1, 0);
                      }
                      else
                      {
                        this.Z.a();
                        localObject6 = this.g;
                        if (localObject6 != null)
                        {
                          this.o = this.x.addTrack((MediaFormat)localObject6);
                          localObject6 = this.this$0;
                          localObject8 = new StringBuilder();
                          ((StringBuilder)localObject8).append("adding video track:outputVideoTrack=");
                          ((StringBuilder)localObject8).append(this.o);
                          ((SVHwEncoder)localObject6).a("hw_media_muxer_seg", ((StringBuilder)localObject8).toString());
                        }
                        localObject6 = this.h;
                        if (localObject6 != null)
                        {
                          this.p = this.x.addTrack((MediaFormat)localObject6);
                          localObject6 = this.this$0;
                          localObject8 = new StringBuilder();
                          ((StringBuilder)localObject8).append(" adding audio track:outputAudioTrack=");
                          ((StringBuilder)localObject8).append(this.p);
                          ((SVHwEncoder)localObject6).a("hw_media_muxer_seg", ((StringBuilder)localObject8).toString());
                        }
                        localObject6 = this.Z;
                        ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).o = ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).b();
                        this.this$0.a("hw_media_muxer_seg", "starting......");
                        this.Z.a();
                        this.x.start();
                        localObject6 = this.Z;
                        ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).p = ((SVHwEncoder.HwEncode.HwTimeTool)localObject6).b();
                        this.f = true;
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
                this.e = -18;
                b(this.e, 0);
              }
              c(true);
            }
            catch (IllegalStateException localIllegalStateException7)
            {
              localIllegalStateException7.printStackTrace();
              this.e = -19;
              b(this.e, 0);
            }
          }
        }
        label5780:
        c(false);
        r();
        SVHwEncoder localSVHwEncoder = this.this$0;
        Object localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append("HwTimeUsed_End=");
        ((StringBuilder)localObject8).append(this.Z.toString());
        localSVHwEncoder.a("hw_video_time_used_msg", ((StringBuilder)localObject8).toString());
        this.this$0.a("hw_av_merge_segment", "release resource ok......");
        if (this.e != 0)
        {
          localSVHwEncoder = this.this$0;
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append("mLastErrCode=");
          ((StringBuilder)localObject8).append(this.e);
          localSVHwEncoder.a("hw_av_merge_segment", ((StringBuilder)localObject8).toString());
          SVHwEncoder.a(this.this$0, true);
          d(true);
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
          FileUtils.deleteDirectory(this.z);
        }
        else
        {
          this.this$0.a("hw_av_merge_segment", "begin merge segments.");
          m();
        }
        this.c = null;
        this.d = null;
        SVHwEncoder.m(this.this$0).clear();
        SVHwEncoder.g(this.this$0).clear();
        SVHwEncoder.h(this.this$0).clear();
        SVHwEncoder.a(this.this$0, null);
        SVHwEncoder.b(this.this$0, null);
        SVHwEncoder.c(this.this$0, null);
        this.N.a();
        this.B = 0;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label134;
      }
    }
  }
  
  int s()
  {
    this.q.setInteger("frame-rate", (int)SVHwEncoder.f(this.this$0));
    this.q.setInteger("bitrate", SVHwEncoder.u(this.this$0));
    this.g = null;
    int i1 = f();
    if (i1 != 0) {
      return i1;
    }
    i1 = b(true);
    if (i1 != 0)
    {
      SVHwEncoder localSVHwEncoder = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("err=");
      localStringBuilder.append(this.e);
      localSVHwEncoder.a("VideoEncodeExit", localStringBuilder.toString());
      this.J.d();
    }
    return i1;
  }
  
  int t()
  {
    try
    {
      Thread.sleep(300L);
      label6:
      this.h = null;
      int i1 = g();
      SVHwEncoder localSVHwEncoder;
      StringBuilder localStringBuilder;
      if (i1 != 0)
      {
        localSVHwEncoder = this.this$0;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("err=");
        localStringBuilder.append(this.e);
        localSVHwEncoder.a("audioEncodeInit", localStringBuilder.toString());
        return i1;
      }
      i1 = b(false);
      if (i1 != 0)
      {
        localSVHwEncoder = this.this$0;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("err=");
        localStringBuilder.append(this.e);
        localSVHwEncoder.a("audioEncodeInit", localStringBuilder.toString());
        this.K.d();
      }
      return i1;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label6;
    }
  }
  
  void u()
  {
    this.D = 0;
    this.E = 0;
    this.F = 0;
    this.G = 0;
    this.H = 0;
    this.I = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode
 * JD-Core Version:    0.7.0.1
 */