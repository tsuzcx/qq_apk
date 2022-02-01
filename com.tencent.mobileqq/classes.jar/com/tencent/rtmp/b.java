package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceChangerType;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceReverbType;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d;
import com.tencent.liteav.d.a;
import com.tencent.liteav.g;
import com.tencent.liteav.m;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.h;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class b
  implements com.tencent.liteav.audio.e, com.tencent.liteav.basic.b.b, d.a, m, com.tencent.liteav.qos.a
{
  private static final String d = "b";
  private ArrayList<b.b> A;
  private TXLivePusher.ITXAudioVolumeEvaluationListener B;
  private int C;
  private com.tencent.liteav.basic.b.a D;
  private com.tencent.liteav.audio.f E;
  private b.a F;
  private Runnable G;
  private com.tencent.liteav.muxer.c H;
  private boolean I;
  private String J;
  private long K;
  private boolean L;
  private TXRecordCommon.ITXVideoRecordListener M;
  private boolean N;
  TXLivePusher.OnBGMNotify a;
  final TXAudioEffectManager.TXVoiceReverbType[] b;
  final TXAudioEffectManager.TXVoiceChangerType[] c;
  private TXCloudVideoView e;
  private TXLivePushConfig f = null;
  private ITXLivePushListener g = null;
  private int h = -1;
  private TXLivePusher.VideoCustomProcessListener i;
  private TXLivePusher.AudioCustomProcessListener j;
  private g k = null;
  private d l = null;
  private TXCStreamUploader m = null;
  private Context n = null;
  private Handler o = null;
  private TXCQoS p = null;
  private com.tencent.liteav.e q = null;
  private String r = "";
  private String s = "";
  private boolean t;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private HashSet<String> y;
  private HashMap<Integer, Long> z;
  
  public b(Context paramContext)
  {
    boolean bool = false;
    this.t = false;
    this.u = -1;
    this.v = -1;
    this.w = false;
    this.x = false;
    this.y = new HashSet();
    this.z = new HashMap();
    this.b = new TXAudioEffectManager.TXVoiceReverbType[] { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
    this.c = new TXAudioEffectManager.TXVoiceChangerType[] { TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11 };
    this.A = new ArrayList();
    this.B = null;
    this.C = 0;
    this.D = new b.1(this);
    this.E = new b.6(this);
    this.F = null;
    this.G = new b.7(this);
    this.H = null;
    this.I = false;
    this.J = "";
    Long localLong = Long.valueOf(0L);
    this.K = 0L;
    this.L = false;
    this.N = false;
    this.f = new TXLivePushConfig();
    this.k = new g();
    this.n = paramContext.getApplicationContext();
    TXCCommonUtil.setAppContext(this.n);
    TXCLog.init();
    this.o = new Handler(Looper.getMainLooper());
    com.tencent.liteav.basic.d.c.a().a(this.n);
    TXCAudioEngine.CreateInstance(this.n, R());
    TXCAudioEngine.getInstance().clean();
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.D));
    long l1 = com.tencent.liteav.basic.d.c.a().a("Audio", "EnableAutoRestartDevice");
    paramContext = TXCAudioEngine.getInstance();
    if ((l1 == 1L) || (l1 == -1L)) {
      bool = true;
    }
    paramContext.enableAutoRestartDevice(bool);
    this.l = new d(this.n);
    this.l.d(true);
    this.l.a(this);
    LicenceCheck.a().a(null, this.n);
    TXCTimeUtil.initAppStartTime();
    this.z.put(Integer.valueOf(-1303), localLong);
    this.z.put(Integer.valueOf(1101), localLong);
    this.z.put(Integer.valueOf(1006), localLong);
  }
  
  private void A()
  {
    this.o.post(new b.11(this));
  }
  
  @TargetApi(16)
  private void B()
  {
    MediaFormat localMediaFormat = com.tencent.liteav.basic.util.f.a(this.f.mAudioSample, this.f.mAudioChannels, 2);
    com.tencent.liteav.muxer.c localc = this.H;
    if (localc != null) {
      localc.b(localMediaFormat);
    }
  }
  
  private void C()
  {
    this.N = true;
    Handler localHandler = this.o;
    if (localHandler != null) {
      localHandler.postDelayed(new b.3(this), 2000L);
    }
  }
  
  private void D()
  {
    this.N = false;
  }
  
  private void E()
  {
    com.tencent.liteav.a.a(this.s, null);
  }
  
  private void F()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void G()
  {
    Object localObject = new h();
    ((h)localObject).d = this.f.mAudioChannels;
    ((h)localObject).e = this.f.mAudioSample;
    ((h)localObject).a = 0;
    ((h)localObject).c = 20;
    ((h)localObject).b = 0;
    ((h)localObject).f = 3;
    int i2 = 1;
    ((h)localObject).j = true;
    ((h)localObject).l = true;
    ((h)localObject).k = false;
    ((h)localObject).h = 40;
    ((h)localObject).i = 5000;
    ((h)localObject).m = this.k.P;
    ((h)localObject).n = this.k.Q;
    ((h)localObject).o = i(this.h);
    this.m = new TXCStreamUploader(this.n, (h)localObject);
    this.m.setID(this.s);
    this.m.setMetaData(this.f.mMetaData);
    localObject = this.m;
    if (localObject != null) {
      ((TXCStreamUploader)localObject).setAudioInfo(this.k.s, this.k.t);
    }
    this.m.setNotifyListener(this);
    if (this.k.M) {
      this.m.setAudioMute(this.x);
    }
    this.r = this.m.start(this.r, this.k.N, this.k.O);
    if (this.k.M) {
      this.m.setMode(1);
    }
    if (this.k.P)
    {
      int i4 = this.k.q;
      int i3 = this.k.r;
      int i1 = i4;
      if (i4 < 5) {
        i1 = 5;
      }
      if (i3 <= 1) {
        i2 = i3;
      }
      this.m.setRetryInterval(i2);
      this.m.setRetryTimes(i1);
      this.m.setVideoDropParams(false, this.k.h, 1000);
    }
    else
    {
      this.m.setRetryInterval(this.k.r);
      this.m.setRetryTimes(this.k.q);
      this.m.setVideoDropParams(true, 40, 3000);
    }
    this.m.setSendStrategy(this.k.P, this.k.Q);
  }
  
  private void H()
  {
    TXCStreamUploader localTXCStreamUploader = this.m;
    if (localTXCStreamUploader != null)
    {
      localTXCStreamUploader.stop();
      this.m.setNotifyListener(null);
      this.m = null;
    }
  }
  
  private void I()
  {
    this.p = new TXCQoS(true);
    this.p.setListener(this);
    this.p.setNotifyListener(this);
    this.p.setAutoAdjustBitrate(this.k.g);
    this.p.setAutoAdjustStrategy(this.k.f);
    this.p.setDefaultVideoResolution(this.k.k);
    this.p.setVideoEncBitrate(this.k.e, this.k.d, this.k.c);
    if (this.k.g) {
      this.p.start(2000L);
    }
  }
  
  private void J()
  {
    TXCQoS localTXCQoS = this.p;
    if (localTXCQoS != null)
    {
      localTXCQoS.stop();
      this.p.setListener(null);
      this.p.setNotifyListener(null);
      this.p = null;
    }
  }
  
  private void K()
  {
    this.q = new com.tencent.liteav.e(this.n);
    this.q.d(this.s);
    this.q.a(this.k.c);
    this.q.b(this.k.s);
    this.q.a(this.k.a, this.k.b);
    this.q.a(this.r);
    this.q.a();
  }
  
  private void L()
  {
    com.tencent.liteav.e locale = this.q;
    if (locale != null)
    {
      locale.b();
      this.q = null;
    }
  }
  
  private void M()
  {
    d locald = this.l;
    if (locald != null)
    {
      locald.setID(this.s);
      this.l.a(this);
      this.l.e();
    }
  }
  
  private void N()
  {
    d locald = this.l;
    if (locald != null)
    {
      locald.a(null);
      this.l.f();
      this.l.a(null);
    }
  }
  
  private void O()
  {
    TXCAudioEngine.getInstance().setEncoderSampleRate(this.f.mAudioSample);
    TXCAudioEngine.getInstance().setEncoderChannels(this.f.mAudioChannels);
    TXCAudioEngine.getInstance().muteLocalAudio(this.x);
    boolean bool;
    if ((this.f.mCustomModeType & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
    TXCAudioEngineJNI.nativeUseSysAudioDevice(TXCAudioEngine.hasTrae() ^ true);
    TXCAudioEngine.getInstance().startLocalAudio(10, bool);
    TXCAudioEngine.getInstance().enableEncodedDataCallback(true);
  }
  
  private void P()
  {
    TXCAudioEngine.getInstance().stopLocalAudio();
  }
  
  private void Q()
  {
    if (this.l == null) {
      return;
    }
    TXCAudioEngine.getInstance().enableSoftAGC(this.k.v, 100);
    TXCAudioEngine.getInstance().enableSoftANS(this.k.w, 100);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.setSystemVolumeType(this.k.x);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioEarMonitoring(this.k.z);
    this.l.a(this.k);
    this.l.b(this.k.o);
    Object localObject;
    if (this.l.j())
    {
      if (this.m != null)
      {
        boolean bool = this.k.P;
        int i2 = 1;
        if (bool)
        {
          int i4 = this.k.q;
          int i3 = this.k.r;
          int i1 = i4;
          if (i4 < 5) {
            i1 = 5;
          }
          if (i3 <= 1) {
            i2 = i3;
          }
          this.m.setRetryInterval(i2);
          this.m.setRetryTimes(i1);
          this.m.setVideoDropParams(false, this.k.h, 1000);
        }
        else
        {
          this.m.setRetryInterval(this.k.r);
          this.m.setRetryTimes(this.k.q);
          this.m.setVideoDropParams(true, 40, 3000);
        }
        this.m.setSendStrategy(this.k.P, this.k.Q);
      }
      localObject = this.p;
      if (localObject != null)
      {
        ((TXCQoS)localObject).stop();
        this.p.setAutoAdjustBitrate(this.k.g);
        this.p.setAutoAdjustStrategy(this.k.f);
        this.p.setDefaultVideoResolution(this.k.k);
        this.p.setVideoEncBitrate(this.k.e, this.k.d, this.k.c);
        if (this.k.g) {
          this.p.start(2000L);
        }
      }
    }
    else
    {
      localObject = this.m;
      if (localObject != null) {
        ((TXCStreamUploader)localObject).setAudioInfo(this.k.s, this.k.t);
      }
    }
  }
  
  private String R()
  {
    com.tencent.liteav.basic.d.c localc = com.tencent.liteav.basic.d.c.a();
    String str = localc.c();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return TXCAudioEngine.buildTRAEConfig(this.n, null, localc.h(), localc.i());
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    int i1 = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 3006: 
    case 3007: 
      i1 = 3005;
      break;
    case 3003: 
      i1 = 3003;
      break;
    case 3002: 
      i1 = 3002;
      break;
    case 2110: 
      i1 = 2110;
      break;
    case 1109: 
    case 2003: 
    case 2009: 
      return;
    case 1103: 
      i1 = 1103;
      break;
    case 1102: 
      i1 = 1102;
      break;
    case 1101: 
      i1 = 1101;
      break;
    case 1021: 
      i1 = 1021;
      break;
    case 1020: 
      i1 = 1020;
      break;
    case 1019: 
      i1 = 1019;
      break;
    case 1018: 
      i1 = 1018;
      break;
    case 1008: 
    case 1027: 
    case 1028: 
      i1 = 1008;
      break;
    case 1002: 
      i1 = 1002;
      break;
    case 1001: 
      i1 = 1001;
      break;
    case 0: 
      return;
    case -1303: 
      i1 = -1303;
      break;
    case -1313: 
      i1 = -1313;
      break;
    case -1315: 
    case -1314: 
    case -1301: 
      i1 = -1301;
      break;
    case -1317: 
    case -1302: 
      i1 = -1302;
      break;
    case -1325: 
    case -1324: 
    case -1307: 
    case 3008: 
      i1 = -1307;
      break;
    case -1326: 
      i1 = 3004;
    }
    Handler localHandler = this.o;
    if (localHandler != null) {
      localHandler.post(new b.5(this, i1, paramBundle));
    }
  }
  
  private void a(TXSNALPacket paramTXSNALPacket, byte[] paramArrayOfByte)
  {
    if (this.K == 0L) {
      this.K = paramTXSNALPacket.pts;
    }
    long l1 = paramTXSNALPacket.pts;
    long l2 = this.K;
    int i1;
    if (paramTXSNALPacket.info == null)
    {
      if (paramTXSNALPacket.nalType == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
    else {
      i1 = paramTXSNALPacket.info.flags;
    }
    this.H.b(paramArrayOfByte, 0, paramArrayOfByte.length, paramTXSNALPacket.pts * 1000L, i1);
    this.o.post(new b.13(this, l1 - l2));
  }
  
  private void a(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap)
  {
    if (paramITXSnapshotListener == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new b.2(this, paramITXSnapshotListener, paramBitmap));
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.o.post(new b.12(this, paramString1, paramString2));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = b(paramBoolean1, paramBoolean2);
    if (i1 == -1)
    {
      this.f.setAutoAdjustBitrate(false);
      this.f.setAutoAdjustStrategy(-1);
      return;
    }
    this.f.setAutoAdjustBitrate(true);
    this.f.setAutoAdjustStrategy(i1);
  }
  
  private byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = h(paramInt);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1 + paramArrayOfByte.length + 1];
    arrayOfByte2[0] = -14;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, arrayOfByte1.length);
    paramInt = 1 + arrayOfByte1.length;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, paramInt, paramArrayOfByte.length);
    arrayOfByte2[(paramInt + paramArrayOfByte.length)] = -128;
    return arrayOfByte2;
  }
  
  private int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == true)
    {
      if (paramBoolean2 == true) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
  
  private void b(TXLivePushConfig paramTXLivePushConfig)
  {
    g localg = this.k;
    localg.c = paramTXLivePushConfig.mVideoBitrate;
    localg.e = paramTXLivePushConfig.mMinVideoBitrate;
    localg.d = paramTXLivePushConfig.mMaxVideoBitrate;
    localg.f = paramTXLivePushConfig.mAutoAdjustStrategy;
    localg.g = paramTXLivePushConfig.mAutoAdjustBitrate;
    localg.h = paramTXLivePushConfig.mVideoFPS;
    localg.i = paramTXLivePushConfig.mVideoEncodeGop;
    localg.j = paramTXLivePushConfig.mHardwareAccel;
    localg.k = paramTXLivePushConfig.mVideoResolution;
    int i1;
    if (paramTXLivePushConfig.mEnableVideoHardEncoderMainProfile) {
      i1 = 3;
    } else {
      i1 = 1;
    }
    localg.n = i1;
    localg.o = paramTXLivePushConfig.mLocalVideoMirrorType;
    localg.s = paramTXLivePushConfig.mAudioSample;
    localg.t = paramTXLivePushConfig.mAudioChannels;
    localg.u = paramTXLivePushConfig.mEnableAec;
    localg.v = paramTXLivePushConfig.mEnableAgc;
    localg.w = paramTXLivePushConfig.mEnableAns;
    localg.x = paramTXLivePushConfig.mVolumeType;
    localg.D = paramTXLivePushConfig.mPauseFlag;
    localg.C = paramTXLivePushConfig.mPauseFps;
    localg.A = paramTXLivePushConfig.mPauseImg;
    localg.B = paramTXLivePushConfig.mPauseTime;
    localg.M = paramTXLivePushConfig.mEnablePureAudioPush;
    localg.K = paramTXLivePushConfig.mTouchFocus;
    localg.L = paramTXLivePushConfig.mEnableZoom;
    localg.E = paramTXLivePushConfig.mWatermark;
    localg.F = paramTXLivePushConfig.mWatermarkX;
    localg.G = paramTXLivePushConfig.mWatermarkY;
    localg.H = paramTXLivePushConfig.mWatermarkXF;
    localg.I = paramTXLivePushConfig.mWatermarkYF;
    localg.J = paramTXLivePushConfig.mWatermarkWidth;
    localg.l = paramTXLivePushConfig.mHomeOrientation;
    localg.N = paramTXLivePushConfig.mEnableNearestIP;
    localg.O = paramTXLivePushConfig.mRtmpChannelType;
    localg.q = paramTXLivePushConfig.mConnectRetryCount;
    localg.r = paramTXLivePushConfig.mConnectRetryInterval;
    localg.m = paramTXLivePushConfig.mFrontCamera;
    localg.R = paramTXLivePushConfig.mCustomModeType;
    localg.S = paramTXLivePushConfig.mVideoEncoderXMirror;
    localg.T = paramTXLivePushConfig.mEnableHighResolutionCapture;
    localg.V = paramTXLivePushConfig.mEnableScreenCaptureAutoRotate;
    localg.z = paramTXLivePushConfig.mEnableAudioPreview;
    localg.a();
  }
  
  private byte[] d(byte[] paramArrayOfByte)
  {
    int i2 = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[i2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i2);
    int i4;
    for (int i1 = 0;; i1 = i1 + i4 + 4)
    {
      int i3 = i1 + 4;
      if (i3 >= i2) {
        break;
      }
      i4 = ByteBuffer.wrap(paramArrayOfByte, i1, 4).getInt();
      if (i3 + i4 <= i2)
      {
        arrayOfByte[i1] = 0;
        arrayOfByte[(i1 + 1)] = 0;
        arrayOfByte[(i1 + 2)] = 0;
        arrayOfByte[(i1 + 3)] = 1;
      }
    }
    return arrayOfByte;
  }
  
  private byte[] e(byte[] paramArrayOfByte)
  {
    int i5 = paramArrayOfByte.length * 4 / 3 + 2;
    byte[] arrayOfByte = new byte[i5];
    int i1 = 0;
    int i3;
    for (int i2 = 0; (i1 < paramArrayOfByte.length) && (i2 < i5); i2 = i3 + 1)
    {
      int i4 = i1;
      i3 = i2;
      if (i1 + 3 < paramArrayOfByte.length)
      {
        i4 = i1;
        i3 = i2;
        if (paramArrayOfByte[i1] == 0)
        {
          int i6 = i1 + 1;
          i4 = i1;
          i3 = i2;
          if (paramArrayOfByte[i6] == 0)
          {
            int i7 = i1 + 2;
            i4 = i1;
            i3 = i2;
            if (paramArrayOfByte[i7] >= 0)
            {
              i4 = i1;
              i3 = i2;
              if (paramArrayOfByte[i7] <= 3)
              {
                i3 = i2 + 1;
                arrayOfByte[i2] = paramArrayOfByte[i1];
                i1 = i3 + 1;
                arrayOfByte[i3] = paramArrayOfByte[i6];
                arrayOfByte[i1] = 3;
                i4 = i6 + 1;
                i3 = i1 + 1;
              }
            }
          }
        }
      }
      arrayOfByte[i3] = paramArrayOfByte[i4];
      i1 = i4 + 1;
    }
    paramArrayOfByte = new byte[i2];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i2);
    return paramArrayOfByte;
  }
  
  private void f(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("rtmp://"))
    {
      h(paramString);
      return;
    }
    if (paramString.startsWith("room://cloud.tencent.com"))
    {
      g(paramString);
      return;
    }
    TXCLog.i(d, "initMonitor： init default monitor.");
    Monitor.a(paramString, 0, "");
  }
  
  private String g(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "UNKNOWN";
              }
              return "WIRED";
            }
            return "2G";
          }
          return "3G";
        }
        return "4G";
      }
      return "WIFI";
    }
    return "UNKNOWN";
  }
  
  private void g(String paramString)
  {
    int i1;
    try
    {
      String[] arrayOfString = paramString.split("[?&]");
      int i4 = arrayOfString.length;
      localObject2 = "";
      localObject1 = localObject2;
      int i2 = 0;
      i1 = 0;
      for (;;)
      {
        localObject5 = localObject2;
        Object localObject3 = localObject1;
        i3 = i1;
        if (i2 >= i4) {
          break label298;
        }
        Object localObject6 = arrayOfString[i2];
        localObject3 = localObject2;
        localObject5 = localObject1;
        i3 = i1;
        try
        {
          if (((String)localObject6).indexOf("=") != -1)
          {
            localObject6 = ((String)localObject6).split("[=]");
            localObject3 = localObject2;
            localObject5 = localObject1;
            i3 = i1;
            if (localObject6.length == 2)
            {
              CharSequence localCharSequence = localObject6[0];
              localObject6 = localObject6[1];
              localObject3 = localObject2;
              localObject5 = localObject1;
              i3 = i1;
              if (!TextUtils.isEmpty(localCharSequence))
              {
                localObject3 = localObject2;
                localObject5 = localObject1;
                i3 = i1;
                if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                  if (localCharSequence.equalsIgnoreCase("sdkappid"))
                  {
                    i3 = Integer.parseInt((String)localObject6);
                    localObject3 = localObject2;
                    localObject5 = localObject1;
                  }
                  else if (localCharSequence.equalsIgnoreCase("roomid"))
                  {
                    localObject3 = localObject6;
                    localObject5 = localObject1;
                    i3 = i1;
                  }
                  else
                  {
                    boolean bool = localCharSequence.equalsIgnoreCase("userid");
                    localObject3 = localObject2;
                    localObject5 = localObject1;
                    i3 = i1;
                    if (bool)
                    {
                      localObject5 = localObject6;
                      i3 = i1;
                      localObject3 = localObject2;
                    }
                  }
                }
              }
            }
          }
          i2 += 1;
          localObject2 = localObject3;
          localObject1 = localObject5;
          i1 = i3;
        }
        catch (Exception localException1) {}
      }
      TXCLog.e(d, "initMonitorByRoom: catch exception.", localException2);
    }
    catch (Exception localException2)
    {
      localObject2 = "";
      localObject1 = localObject2;
      i1 = 0;
    }
    int i3 = i1;
    Object localObject4 = localObject1;
    Object localObject5 = localObject2;
    label298:
    if (!TextUtils.isEmpty(localObject4)) {
      paramString = localObject4;
    }
    Object localObject1 = d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initMonitorByRoom: sdkappId:");
    ((StringBuilder)localObject2).append(i3);
    ((StringBuilder)localObject2).append(" roomId:");
    ((StringBuilder)localObject2).append(localObject5);
    ((StringBuilder)localObject2).append(" userId:");
    ((StringBuilder)localObject2).append(paramString);
    TXCLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
    Monitor.a(paramString, i3, localObject5);
  }
  
  private void h(String paramString)
  {
    String str = i(paramString);
    if (!TextUtils.isEmpty(str)) {
      paramString = str;
    }
    str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initMonitorByStreamId: streamId: ");
    localStringBuilder.append(paramString);
    TXCLog.i(str, localStringBuilder.toString());
    Monitor.a(paramString, 0, "");
  }
  
  private byte[] h(int paramInt)
  {
    int i2 = paramInt / 255 + 1;
    byte[] arrayOfByte = new byte[i2];
    int i1 = 0;
    int i3;
    for (;;)
    {
      i3 = i2 - 1;
      if (i1 >= i3) {
        break;
      }
      arrayOfByte[i1] = -1;
      i1 += 1;
    }
    arrayOfByte[i3] = ((byte)(paramInt % 255 & 0xFF));
    return arrayOfByte;
  }
  
  private int i(int paramInt)
  {
    long l1;
    switch (paramInt)
    {
    default: 
      return 0;
    case 7: 
      l1 = com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
      break;
    case 6: 
      l1 = com.tencent.liteav.basic.d.c.a().a("QUICMode", "RTC");
      break;
    case 5: 
      l1 = com.tencent.liteav.basic.d.c.a().a("QUICMode", "LinkSub");
      break;
    case 4: 
      l1 = com.tencent.liteav.basic.d.c.a().a("QUICMode", "LinkMain");
      break;
    case 3: 
      l1 = com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
      break;
    case 2: 
      l1 = com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
      break;
    case 1: 
      l1 = com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
    }
    return (int)l1;
  }
  
  private String i(String paramString)
  {
    try
    {
      int i1 = paramString.lastIndexOf("/");
      int i2 = paramString.indexOf("?");
      if (i1 == -1)
      {
        TXCLog.e(d, "parseStreamId: un find slash line.");
        return null;
      }
      if (i2 != -1) {
        return paramString.substring(i1 + 1, i2);
      }
      paramString = paramString.substring(i1 + 1);
      return paramString;
    }
    catch (Exception paramString)
    {
      TXCLog.e(d, "parseStreamId: catch exception.", paramString);
    }
    return null;
  }
  
  private boolean j(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = paramString.split("[?&]");
      int i2 = paramString.length;
      int i1 = 0;
      Object localObject1;
      Object localObject2;
      while (i1 < i2)
      {
        localObject1 = paramString[i1];
        if (((String)localObject1).indexOf("=") != -1)
        {
          localObject2 = ((String)localObject1).split("[=]");
          if (localObject2.length == 2)
          {
            localObject1 = localObject2[0];
            localObject2 = localObject2[1];
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject1).equalsIgnoreCase("enableblackstream")))
            {
              i1 = Integer.parseInt((String)localObject2);
              if (i1 == 1) {
                bool = true;
              }
              return bool;
            }
          }
        }
        i1 += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      localObject1 = d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse black stream flag error ");
      ((StringBuilder)localObject2).append(paramString.toString());
      TXCLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void k(String paramString)
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((TXCStreamUploader)localObject).setID(paramString);
    }
    localObject = this.l;
    if (localObject != null) {
      ((d)localObject).setID(paramString);
    }
    localObject = this.q;
    if (localObject != null) {
      ((com.tencent.liteav.e)localObject).d(paramString);
    }
    this.s = paramString;
  }
  
  private void y()
  {
    if ((this.C > 0) && (m()))
    {
      TXCAudioEngine.getInstance();
      TXCAudioEngine.enableAudioVolumeEvaluation(true, 300);
      if (this.F == null) {
        this.F = new b.a(this, null);
      }
      this.F.a(this.C);
      Handler localHandler = this.o;
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.F);
        this.o.postDelayed(this.F, this.C);
      }
    }
  }
  
  private void z()
  {
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(false, 300);
    Object localObject = this.F;
    if (localObject != null) {
      ((b.a)localObject).a(0);
    }
    localObject = this.o;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.F);
    }
    this.F = null;
    this.C = 0;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    TXLivePusher.VideoCustomProcessListener localVideoCustomProcessListener = this.i;
    if (localVideoCustomProcessListener != null) {
      return localVideoCustomProcessListener.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api startPusher ");
    localStringBuilder.append(this);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      paramString = d;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start push error when url is empty ");
      ((StringBuilder)localObject).append(this);
      TXCLog.e(paramString, ((StringBuilder)localObject).toString());
      return -1;
    }
    if ((!TextUtils.isEmpty(this.r)) && (m()))
    {
      if (this.r.equalsIgnoreCase(paramString))
      {
        paramString = d;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ignore start push when new url is the same with old url  ");
        ((StringBuilder)localObject).append(this);
        TXCLog.w(paramString, ((StringBuilder)localObject).toString());
        return -1;
      }
      localObject = d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" stop old push when new url is not the same with old url  ");
      localStringBuilder.append(this);
      TXCLog.w((String)localObject, localStringBuilder.toString());
      j();
    }
    TXCLog.i(d, "liteav_api ================================================================================================================================================");
    TXCLog.i(d, "liteav_api ================================================================================================================================================");
    localObject = d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api ============= startPush pushUrl = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" SDKVersion = ");
    localStringBuilder.append(TXCCommonUtil.getSDKID());
    localStringBuilder.append(" , ");
    localStringBuilder.append(TXCCommonUtil.getSDKVersionStr());
    localStringBuilder.append("=============");
    TXCLog.i((String)localObject, localStringBuilder.toString());
    TXCLog.i(d, "liteav_api ================================================================================================================================================");
    TXCLog.i(d, "liteav_api ================================================================================================================================================");
    this.r = paramString;
    k(this.r);
    G();
    M();
    O();
    I();
    K();
    f(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startPush(");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" sdk:");
    localStringBuilder.append(TXCCommonUtil.getSDKID());
    Monitor.a(1, (String)localObject, localStringBuilder.toString(), 0);
    C();
    paramString = this.e;
    if (paramString != null) {
      paramString.clearLog();
    }
    if (j(this.r)) {
      this.l.b(true);
    }
    y();
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.l != null)
    {
      if (paramInt1 != 3)
      {
        if (paramInt1 != 5) {
          return -1000;
        }
        paramInt1 = 2;
      }
      else
      {
        paramInt1 = 1;
      }
      return this.l.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, 0L);
    }
    return -1000;
  }
  
  public void a()
  {
    TXLivePusher.VideoCustomProcessListener localVideoCustomProcessListener = this.i;
    if (localVideoCustomProcessListener != null) {
      localVideoCustomProcessListener.onTextureDestoryed();
    }
  }
  
  public void a(float paramFloat)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setExposureCompensation ");
    localStringBuilder.append(paramFloat);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = this.l;
    if (localObject == null) {
      return;
    }
    ((d)localObject).a(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    d locald = this.l;
    if (locald != null) {
      locald.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    TXCLog.i(d, "liteav_api setRenderRotation ");
    d locald = this.l;
    if (locald == null) {
      return;
    }
    locald.g(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setSurfaceSize ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = this.l;
    if (localObject == null) {
      return;
    }
    ((d)localObject).a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = paramInt;
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setVideoQuality ");
    localStringBuilder.append(i1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramBoolean2);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("quality:");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" adjustBitrate:");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" adjustResolution:");
    ((StringBuilder)localObject).append(paramBoolean1);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = false;
    int i2 = 1;
    Monitor.a(1, "setVideoQuality", (String)localObject, 0);
    paramInt = i1;
    if (Build.VERSION.SDK_INT < 18) {
      if (i1 != 2)
      {
        paramInt = i1;
        if (i1 != 3) {}
      }
      else
      {
        paramInt = 1;
      }
    }
    if (this.f == null) {
      this.f = new TXLivePushConfig();
    }
    this.f.setVideoFPS(18);
    if ((paramBoolean2) && (paramBoolean1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    switch (paramInt)
    {
    default: 
      this.f.setHardwareAcceleration(2);
      localObject = d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVideoPushQuality: invalid quality ");
      localStringBuilder.append(paramInt);
      TXCLog.e((String)localObject, localStringBuilder.toString());
      return;
    case 7: 
      this.f.enableAEC(false);
      this.f.setHardwareAcceleration(1);
      this.f.setVideoResolution(30);
      this.f.setAudioSampleRate(48000);
      a(paramBoolean1, false);
      this.f.setMinVideoBitrate(2500);
      this.f.setVideoBitrate(3000);
      this.f.setMaxVideoBitrate(3000);
    }
    for (;;)
    {
      paramBoolean1 = false;
      paramBoolean2 = bool;
      break;
      this.f.enableAEC(true);
      this.f.setHardwareAcceleration(1);
      this.f.setVideoResolution(0);
      this.f.setAudioSampleRate(48000);
      this.f.setAutoAdjustBitrate(true);
      this.f.setAutoAdjustStrategy(5);
      this.f.setMinVideoBitrate(190);
      this.f.setVideoBitrate(400);
      this.f.setMaxVideoBitrate(810);
      paramBoolean1 = true;
      break label540;
      this.f.enableAEC(true);
      this.f.setHardwareAcceleration(1);
      this.f.setVideoResolution(6);
      this.f.setAutoAdjustBitrate(false);
      this.f.setVideoBitrate(350);
      this.f.setAudioSampleRate(48000);
      for (;;)
      {
        paramBoolean1 = false;
        label540:
        paramBoolean2 = true;
        break;
        if (Build.VERSION.SDK_INT < 18)
        {
          this.f.enableAEC(true);
          this.f.setHardwareAcceleration(0);
          this.f.setVideoResolution(0);
          this.f.setAutoAdjustBitrate(true);
          this.f.setAutoAdjustStrategy(4);
          this.f.setMinVideoBitrate(500);
          this.f.setVideoBitrate(800);
          this.f.setMaxVideoBitrate(900);
        }
        else
        {
          i1 = this.h;
          if (i1 == 1)
          {
            this.f.enableAEC(true);
            this.f.setHardwareAcceleration(1);
            this.f.setVideoResolution(0);
            this.f.setAutoAdjustBitrate(true);
            this.f.setAutoAdjustStrategy(4);
            this.f.setMinVideoBitrate(500);
            this.f.setVideoBitrate(800);
            this.f.setMaxVideoBitrate(900);
          }
          else if (i1 == 3)
          {
            this.f.enableAEC(true);
            this.f.setHardwareAcceleration(1);
            this.f.setVideoResolution(2);
            this.f.setAutoAdjustBitrate(true);
            this.f.setAutoAdjustStrategy(4);
            this.f.setMinVideoBitrate(1000);
            this.f.setVideoBitrate(1800);
            this.f.setMaxVideoBitrate(1800);
          }
          else if (i1 == 7)
          {
            this.f.enableAEC(true);
            this.f.setHardwareAcceleration(1);
            this.f.setVideoResolution(30);
            this.f.setAutoAdjustBitrate(true);
            this.f.setAutoAdjustStrategy(4);
            this.f.setMinVideoBitrate(2000);
            this.f.setVideoBitrate(3000);
            this.f.setMaxVideoBitrate(3000);
          }
          else
          {
            this.f.enableAEC(true);
            this.f.setHardwareAcceleration(1);
            this.f.setVideoResolution(1);
            this.f.setAutoAdjustBitrate(true);
            this.f.setAutoAdjustStrategy(4);
            this.f.setMinVideoBitrate(800);
            this.f.setVideoBitrate(1200);
            this.f.setMaxVideoBitrate(1500);
          }
        }
        this.f.setAudioSampleRate(48000);
      }
      this.f.enableAEC(false);
      this.f.setHardwareAcceleration(1);
      this.f.setVideoResolution(2);
      this.f.setAudioSampleRate(48000);
      a(paramBoolean1, paramBoolean2);
      if (i1 != 0)
      {
        this.f.setMinVideoBitrate(600);
        this.f.setVideoBitrate(1800);
        this.f.setMaxVideoBitrate(1800);
      }
      else
      {
        this.f.setMinVideoBitrate(1000);
        this.f.setVideoBitrate(1800);
        this.f.setMaxVideoBitrate(1800);
        continue;
        this.f.enableAEC(false);
        this.f.setHardwareAcceleration(2);
        this.f.setVideoResolution(1);
        this.f.setAudioSampleRate(48000);
        a(paramBoolean1, paramBoolean2);
        if (i1 != 0)
        {
          this.f.setMinVideoBitrate(600);
          this.f.setVideoBitrate(1200);
          this.f.setMaxVideoBitrate(1500);
        }
        else
        {
          this.f.setMinVideoBitrate(800);
          this.f.setVideoBitrate(1200);
          this.f.setMaxVideoBitrate(1500);
          continue;
          this.f.enableAEC(false);
          this.f.setHardwareAcceleration(2);
          this.f.setVideoResolution(0);
          this.f.setAudioSampleRate(48000);
          a(paramBoolean1, paramBoolean2);
          if (i1 != 0)
          {
            this.f.setMinVideoBitrate(301);
            this.f.setVideoBitrate(800);
            this.f.setMaxVideoBitrate(900);
          }
          else
          {
            this.f.setMinVideoBitrate(500);
            this.f.setVideoBitrate(800);
            this.f.setMaxVideoBitrate(900);
          }
        }
      }
    }
    this.h = paramInt;
    this.f.enableVideoHardEncoderMainProfile(paramBoolean2 ^ true);
    localObject = this.f;
    if (paramBoolean2) {
      paramInt = i2;
    } else {
      paramInt = 3;
    }
    ((TXLivePushConfig)localObject).setVideoEncodeGop(paramInt);
    localObject = this.k;
    if (localObject != null)
    {
      ((g)localObject).P = paramBoolean2;
      ((g)localObject).Q = paramBoolean1;
    }
    a(this.f);
  }
  
  public void a(Surface paramSurface)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setSurface ");
    localStringBuilder.append(paramSurface);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = this.l;
    if (localObject == null) {
      return;
    }
    ((d)localObject).a(paramSurface);
  }
  
  public void a(ITXLivePushListener paramITXLivePushListener)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setPushListener ");
    localStringBuilder.append(paramITXLivePushListener);
    TXCLog.i(str, localStringBuilder.toString());
    this.g = paramITXLivePushListener;
  }
  
  public void a(TXLivePushConfig paramTXLivePushConfig)
  {
    String str2 = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setConfig ");
    String str1 = "null";
    if (paramTXLivePushConfig != null) {
      localObject = paramTXLivePushConfig.toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ,  pusher:");
    localStringBuilder.append(this);
    TXCLog.i(str2, localStringBuilder.toString());
    Object localObject = paramTXLivePushConfig;
    if (paramTXLivePushConfig == null) {
      localObject = new TXLivePushConfig();
    }
    this.f = ((TXLivePushConfig)localObject);
    b((TXLivePushConfig)localObject);
    Q();
    paramTXLivePushConfig = str1;
    if (localObject != null) {
      paramTXLivePushConfig = ((TXLivePushConfig)localObject).toString();
    }
    Monitor.a(1, "setConfig", paramTXLivePushConfig, 0);
  }
  
  public void a(TXLivePusher.AudioCustomProcessListener paramAudioCustomProcessListener)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setAudioProcessListener ");
    localStringBuilder.append(paramAudioCustomProcessListener);
    TXCLog.i(str, localStringBuilder.toString());
    this.j = paramAudioCustomProcessListener;
  }
  
  public void a(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.B = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api snapshot ");
    localStringBuilder.append(paramITXSnapshotListener);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    if ((!this.t) && (paramITXSnapshotListener != null))
    {
      localObject = this.l;
      if (localObject == null) {
        return;
      }
      if (localObject != null)
      {
        this.t = true;
        ((d)localObject).a(new b.9(this, paramITXSnapshotListener));
        this.o.postDelayed(this.G, 2000L);
        return;
      }
      this.t = false;
    }
  }
  
  public void a(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setBGMNofify ");
    localStringBuilder.append(paramOnBGMNotify);
    TXCLog.i(str, localStringBuilder.toString());
    this.a = paramOnBGMNotify;
    if (this.a != null)
    {
      TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.E);
      return;
    }
    TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
  }
  
  public void a(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setVideoProcessListener ");
    localStringBuilder.append(paramVideoCustomProcessListener);
    TXCLog.i(str, localStringBuilder.toString());
    this.i = paramVideoCustomProcessListener;
    if (this.i == null)
    {
      paramVideoCustomProcessListener = this.l;
      if (paramVideoCustomProcessListener != null) {
        paramVideoCustomProcessListener.a(null);
      }
    }
    else
    {
      paramVideoCustomProcessListener = this.l;
      if (paramVideoCustomProcessListener != null) {
        paramVideoCustomProcessListener.a(this);
      }
    }
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api startCameraPreview ");
    localStringBuilder.append(paramTXCloudVideoView);
    localStringBuilder.append(", ");
    localStringBuilder.append(this);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startCameraPreview [view:");
    int i1;
    if (paramTXCloudVideoView != null) {
      i1 = paramTXCloudVideoView.hashCode();
    } else {
      i1 = 0;
    }
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("]");
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    a(this.f);
    if (this.k.M)
    {
      TXCLog.e(d, "enable pure audio push , so can not start preview!");
      return;
    }
    localObject = this.e;
    if ((localObject != paramTXCloudVideoView) && (localObject != null)) {
      ((TXCloudVideoView)localObject).removeVideoView();
    }
    this.e = paramTXCloudVideoView;
    if (this.l == null) {
      this.l = new d(this.n);
    }
    this.l.a(this);
    this.l.a(this);
    this.l.a(paramTXCloudVideoView);
    this.l.b(this.f.mBeautyLevel, this.f.mWhiteningLevel, this.f.mRuddyLevel);
    LicenceCheck.a().a(null, this.n);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setVideoRecordListener ");
    localStringBuilder.append(paramITXVideoRecordListener);
    TXCLog.i(str, localStringBuilder.toString());
    this.M = paramITXVideoRecordListener;
  }
  
  public void a(boolean paramBoolean)
  {
    TXCStreamUploader localTXCStreamUploader = this.m;
    if (localTXCStreamUploader != null) {
      localTXCStreamUploader.setDropEanble(paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    TXCAudioEngine.getInstance().sendCustomPCMData(paramArrayOfByte, this.f.mAudioSample, this.f.mAudioChannels);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      ((d)localObject).h(paramInt1);
      this.l.b(paramInt2, paramInt3, paramInt4);
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((TXLivePushConfig)localObject).mBeautyLevel = paramInt2;
      ((TXLivePushConfig)localObject).mWhiteningLevel = paramInt3;
      ((TXLivePushConfig)localObject).mRuddyLevel = paramInt4;
    }
    return true;
  }
  
  public int b()
  {
    return TXCStatus.c(this.s, 4002);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.l;
    if (localObject != null) {
      ((d)localObject).a(paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      localObject = this.k;
      ((g)localObject).a = paramInt2;
      ((g)localObject).b = paramInt3;
    }
    if (paramInt1 != 0)
    {
      localObject = this.k;
      ((g)localObject).c = paramInt1;
      Monitor.a(2, String.format("Qos: Change [mode:%d][bitrate:%d][videosize:%d*%d]", new Object[] { Integer.valueOf(((g)localObject).f), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }), "", 0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api stopCameraPreview ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ");
    localStringBuilder.append(this);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    Monitor.a(1, "stopCameraPreview", "", 0);
    localObject = this.l;
    if (localObject == null) {
      return;
    }
    ((d)localObject).c(paramBoolean);
  }
  
  public boolean b(float paramFloat)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setBGMVolume ");
    localStringBuilder.append(paramFloat);
    TXCLog.i(str, localStringBuilder.toString());
    return TXCLiveBGMPlayer.getInstance().setVolume(paramFloat);
  }
  
  public boolean b(int paramInt)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setZoom ");
    localStringBuilder.append(paramInt);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = this.l;
    if (localObject == null) {
      return false;
    }
    return ((d)localObject).i(paramInt);
  }
  
  public boolean b(String paramString)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api playBGM ");
    localStringBuilder.append(paramString);
    TXCLog.i(str, localStringBuilder.toString());
    return TXCLiveBGMPlayer.getInstance().startPlay(paramString);
  }
  
  public boolean b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length > 0) && (paramArrayOfByte.length <= 2048)) {
      try
      {
        if (this.A != null)
        {
          b.b localb = new b.b(this, null);
          localb.a = TXCTimeUtil.generatePtsMS();
          byte[] arrayOfByte = e(paramArrayOfByte);
          localb.b = a(paramArrayOfByte.length, arrayOfByte);
          this.A.add(localb);
        }
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public int c()
  {
    int i2 = TXCStatus.c(this.s, 7002);
    int i1;
    if (this.k.P) {
      i1 = TXCStatus.c(this.s, 7001);
    } else {
      i1 = TXCStatus.c(this.s, 4002);
    }
    return i2 + i1;
  }
  
  public int c(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.l != null)
    {
      EGLContext localEGLContext = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
      return this.l.a(paramInt1, paramInt2, paramInt3, localEGLContext, 0L);
    }
    return -1000;
  }
  
  public int c(String paramString)
  {
    return TXCLiveBGMPlayer.getInstance().getBGMDuration(paramString);
  }
  
  @Deprecated
  public void c(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.A != null)
      {
        b.b localb = new b.b(this, null);
        localb.a = TXCTimeUtil.generatePtsMS();
        localb.b = e(paramArrayOfByte);
        this.A.add(localb);
      }
      return;
    }
    finally {}
  }
  
  public boolean c(float paramFloat)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setMicVolume ");
    localStringBuilder.append(paramFloat);
    TXCLog.i(str, localStringBuilder.toString());
    return TXCAudioEngine.getInstance().setSoftwareCaptureVolume(paramFloat);
  }
  
  public boolean c(int paramInt)
  {
    TXCLiveBGMPlayer.getInstance().setBGMPosition(paramInt);
    return true;
  }
  
  public boolean c(boolean paramBoolean)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setMirror ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = this.f;
    if (localObject != null) {
      ((TXLivePushConfig)localObject).setVideoEncoderXMirror(paramBoolean);
    }
    localObject = this.l;
    if (localObject == null) {
      return false;
    }
    ((d)localObject).f(paramBoolean);
    return true;
  }
  
  public int d()
  {
    if (this.m == null) {
      return 0;
    }
    return TXCStatus.c(this.s, 7004) + TXCStatus.c(this.s, 7003);
  }
  
  public int d(String paramString)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api startRecord ");
    localStringBuilder.append(paramString);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    if (Build.VERSION.SDK_INT < 18)
    {
      paramString = d;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("API levl is too low (record need 18, current is");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject).append(")");
      TXCLog.e(paramString, ((StringBuilder)localObject).toString());
      return -3;
    }
    if (this.L)
    {
      TXCLog.w(d, "ignore start record when recording");
      return -1;
    }
    localObject = this.l;
    if ((localObject != null) && (((d)localObject).j()))
    {
      TXCLog.w(d, "start record ");
      this.L = true;
      this.J = paramString;
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      this.H = new com.tencent.liteav.muxer.c(this.n, 1);
      this.I = false;
      this.H.a(this.J);
      B();
      TXCDRApi.txReportDAU(this.n.getApplicationContext(), com.tencent.liteav.basic.datareport.a.aH);
      paramString = this.l;
      if (paramString != null) {
        paramString.t();
      }
      return 0;
    }
    TXCLog.w(d, "ignore start record when not pushing");
    return -2;
  }
  
  public void d(float paramFloat)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setBGMPitch ");
    localStringBuilder.append(paramFloat);
    TXCLog.i(str, localStringBuilder.toString());
    TXCLiveBGMPlayer.getInstance().setPitch(paramFloat);
  }
  
  public void d(int paramInt)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setReverb ");
    localStringBuilder.append(paramInt);
    TXCLog.i(str, localStringBuilder.toString());
    if ((paramInt >= 0) && (paramInt <= 7))
    {
      TXCAudioEngine.getInstance().setReverbType(this.b[paramInt]);
      return;
    }
    str = d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("reverbType not support :");
    localStringBuilder.append(paramInt);
    TXCLog.e(str, localStringBuilder.toString());
  }
  
  public boolean d(boolean paramBoolean)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api turnOnFlashLight ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = this.l;
    if (localObject == null) {
      return false;
    }
    return ((d)localObject).e(paramBoolean);
  }
  
  public int e()
  {
    return 5;
  }
  
  public void e(int paramInt)
  {
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setVoiceChangerType ");
    localStringBuilder.append(paramInt);
    TXCLog.i(str, localStringBuilder.toString());
    if ((paramInt >= 0) && (paramInt <= 11))
    {
      TXCAudioEngine.getInstance().setVoiceChangerType(this.c[paramInt]);
      return;
    }
    str = d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("voiceChangerType not support :");
    localStringBuilder.append(paramInt);
    TXCLog.e(str, localStringBuilder.toString());
  }
  
  public void e(String paramString)
  {
    TXCLog.i("User", paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api setMute ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mute:");
    ((StringBuilder)localObject).append(paramBoolean);
    Monitor.a(1, "setMute", ((StringBuilder)localObject).toString(), 0);
    this.x = paramBoolean;
    TXCAudioEngine.getInstance().muteLocalAudio(paramBoolean);
    if (this.f.mEnablePureAudioPush)
    {
      localObject = this.m;
      if (localObject != null) {
        ((TXCStreamUploader)localObject).setAudioMute(paramBoolean);
      }
    }
  }
  
  public int f()
  {
    return TXCStatus.c(this.s, 7005);
  }
  
  public void f(int paramInt)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api enableAudioVolumeEvaluation intervalMs = ");
    localStringBuilder.append(paramInt);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("liteav_api enableAudioVolumeEvaluation intervalMs = ");
    ((StringBuilder)localObject).append(paramInt);
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    if (paramInt > 0)
    {
      int i1 = paramInt;
      if (paramInt < 100) {
        i1 = 100;
      }
      this.C = i1;
      y();
      return;
    }
    this.C = 0;
    z();
  }
  
  public int g()
  {
    return TXCStatus.c(this.s, 7007);
  }
  
  public int h()
  {
    return TXCStatus.c(this.s, 7021);
  }
  
  public TXLivePushConfig i()
  {
    return this.f;
  }
  
  public void j()
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api stopPusher ");
    localStringBuilder.append(this);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopPush(");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(")");
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    w();
    D();
    L();
    J();
    N();
    t();
    P();
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioEarMonitoring(false);
    this.x = false;
    this.k.P = false;
    H();
    this.r = "";
    this.y.clear();
    Monitor.a();
    this.l.b(false);
    z();
    TXCAudioEngine.getInstance().clean();
    TXCAudioEngine.getInstance().UnInitAudioDevice();
  }
  
  public void k()
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api pausePusher ");
    localStringBuilder.append(this);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    Monitor.a(1, "pausePush", "", 0);
    localObject = this.l;
    if (localObject != null) {
      ((d)localObject).g();
    }
    localObject = d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPauseFlag:");
    localStringBuilder.append(this.f.mPauseFlag);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    if ((this.f.mPauseFlag & 0x2) == 2) {
      TXCAudioEngine.getInstance().pauseAudioCapture(true);
    }
  }
  
  public void l()
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liteav_api resumePusher ");
    localStringBuilder.append(this);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    Monitor.a(1, "resumePush", "", 0);
    localObject = this.l;
    if (localObject != null) {
      ((d)localObject).h();
    }
    TXCAudioEngine.getInstance().resumeAudioCapture();
  }
  
  public boolean m()
  {
    d locald = this.l;
    if (locald != null) {
      return locald.j();
    }
    return false;
  }
  
  public void n()
  {
    TXCLog.i(d, "liteav_api startScreenCapture ");
    Monitor.a(1, "startScreenCapture", "", 0);
    d locald = this.l;
    if (locald == null) {
      return;
    }
    locald.a(null);
  }
  
  public void o()
  {
    TXCLog.i(d, "liteav_api stopScreenCapture ");
    Monitor.a(1, "stopScreenCapture", "", 0);
    d locald = this.l;
    if (locald == null) {
      return;
    }
    locald.l();
  }
  
  public void onBackgroudPushStop()
  {
    TXCAudioEngine.getInstance().resumeAudioCapture();
    TXCAudioEngine.getInstance().muteLocalAudio(false);
  }
  
  public void onEncVideo(TXSNALPacket paramTXSNALPacket)
  {
    Object localObject1 = this.p;
    if (localObject1 != null) {
      ((TXCQoS)localObject1).setHasVideo(true);
    }
    if ((this.m != null) && (paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null)) {}
    for (;;)
    {
      int i1;
      Object localObject2;
      try
      {
        if ((this.A != null) && (!this.A.isEmpty()))
        {
          localObject1 = this.A.iterator();
          i1 = 0;
          boolean bool = ((Iterator)localObject1).hasNext();
          i2 = 10240;
          if (bool)
          {
            localObject2 = (b.b)((Iterator)localObject1).next();
            if (((b.b)localObject2).a <= paramTXSNALPacket.pts)
            {
              if (((b.b)localObject2).b.length > 10240) {
                break label527;
              }
              i2 = ((b.b)localObject2).b.length;
              break label527;
            }
          }
          if (i1 != 0)
          {
            localObject1 = new byte[i1 + paramTXSNALPacket.nalData.length];
            localObject2 = new byte[5];
            Iterator localIterator = this.A.iterator();
            i2 = 0;
            i1 = 0;
            if (localIterator.hasNext())
            {
              b.b localb = (b.b)localIterator.next();
              if (localb.a <= paramTXSNALPacket.pts)
              {
                i3 = i2 + 1;
                if (localb.b.length > 10240) {
                  break label536;
                }
                i2 = localb.b.length;
                int i4 = i2 + 1;
                localObject2[0] = ((byte)(i4 >> 24 & 0xFF));
                localObject2[1] = ((byte)(i4 >> 16 & 0xFF));
                localObject2[2] = ((byte)(i4 >> 8 & 0xFF));
                localObject2[3] = ((byte)(i4 & 0xFF));
                localObject2[4] = 6;
                System.arraycopy(localObject2, 0, localObject1, i1, localObject2.length);
                i1 += localObject2.length;
                System.arraycopy(localb.b, 0, localObject1, i1, i2);
                i1 += i2;
                i2 = i3;
                continue;
              }
            }
            long l1 = paramTXSNALPacket.pts;
            int i3 = 0;
            if (i3 < i2)
            {
              this.A.remove(0);
              i3 += 1;
              continue;
            }
            System.arraycopy(paramTXSNALPacket.nalData, 0, localObject1, i1, paramTXSNALPacket.nalData.length);
            paramTXSNALPacket.nalData = ((byte[])localObject1);
          }
        }
        this.m.pushNAL(paramTXSNALPacket);
      }
      finally {}
      if ((this.L) && (this.H != null) && (paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null))
      {
        localObject1 = d(paramTXSNALPacket.nalData);
        if (this.I)
        {
          a(paramTXSNALPacket, (byte[])localObject1);
          return;
        }
        if (paramTXSNALPacket.nalType == 0)
        {
          localObject2 = com.tencent.liteav.basic.util.f.a((byte[])localObject1, this.l.c(), this.l.d());
          if (localObject2 != null)
          {
            this.H.a((MediaFormat)localObject2);
            this.H.a();
            this.I = true;
            this.K = 0L;
          }
          a(paramTXSNALPacket, (byte[])localObject1);
        }
      }
      return;
      label527:
      i1 += i2 + 5;
      continue;
      label536:
      int i2 = 10240;
    }
  }
  
  public void onEncVideoFormat(MediaFormat paramMediaFormat)
  {
    if (this.L)
    {
      com.tencent.liteav.muxer.c localc = this.H;
      if (localc != null)
      {
        localc.a(paramMediaFormat);
        if (!this.I)
        {
          this.H.a();
          this.I = true;
          this.K = 0L;
        }
      }
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    Object localObject = this.o;
    if (localObject != null) {
      ((Handler)localObject).post(new b.10(this, paramBundle, paramInt));
    }
    if (paramInt < 0)
    {
      if (paramBundle != null) {
        localObject = paramBundle.getString("EVT_MSG");
      } else {
        localObject = "";
      }
      localObject = String.format("%s [code:%d]", new Object[] { localObject, Integer.valueOf(paramInt) });
      String str = d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotifyEvent: ");
      localStringBuilder.append((String)localObject);
      TXCLog.e(str, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("event:");
      ((StringBuilder)localObject).append(paramInt);
      Monitor.a(3, "onNotifyEvent", ((StringBuilder)localObject).toString(), 0);
    }
    a(paramInt, paramBundle);
  }
  
  public void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.L)
    {
      com.tencent.liteav.muxer.c localc = this.H;
      if ((localc != null) && (this.I) && (paramArrayOfByte != null)) {
        localc.a(paramArrayOfByte, 0, paramArrayOfByte.length, paramLong * 1000L, 0);
      }
    }
  }
  
  public void onRecordError(int paramInt, String paramString) {}
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.j;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    TXLivePusher.AudioCustomProcessListener localAudioCustomProcessListener = this.j;
    if (localAudioCustomProcessListener != null) {
      localAudioCustomProcessListener.onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    }
  }
  
  public void p()
  {
    TXCLog.i(d, "liteav_api switchCamera ");
    Monitor.a(1, "switchCamera", "", 0);
    d locald = this.l;
    if (locald == null) {
      return;
    }
    locald.k();
  }
  
  public int q()
  {
    d locald = this.l;
    if (locald == null) {
      return 0;
    }
    return locald.q();
  }
  
  public TXBeautyManager r()
  {
    if (this.l == null) {
      this.l = new d(this.n);
    }
    return this.l.b();
  }
  
  public boolean s()
  {
    TXCLog.i(d, "liteav_api stopBGM ");
    return TXCLiveBGMPlayer.getInstance().stopPlay();
  }
  
  public void t()
  {
    TXCLog.i(d, "liteav_api stopAllBGM ");
    TXCLiveBGMPlayer.getInstance().stopAll();
  }
  
  public boolean u()
  {
    TXCLog.i(d, "liteav_api pauseBGM ");
    return TXCLiveBGMPlayer.getInstance().pause();
  }
  
  public boolean v()
  {
    TXCLog.i(d, "liteav_api resumeBGM ");
    return TXCLiveBGMPlayer.getInstance().resume();
  }
  
  public void w()
  {
    TXCLog.i(d, "liteav_api stopRecord ");
    if (this.L)
    {
      com.tencent.liteav.muxer.c localc = this.H;
      if (localc != null)
      {
        int i1 = localc.b();
        TXCLog.w(d, "start record ");
        this.L = false;
        if (i1 == 0)
        {
          AsyncTask.execute(new b.8(this, this.J));
          return;
        }
        A();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.b
 * JD-Core Version:    0.7.0.1
 */