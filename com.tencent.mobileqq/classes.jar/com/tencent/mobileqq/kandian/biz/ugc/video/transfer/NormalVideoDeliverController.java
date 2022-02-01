package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.KanDianVideoUploadUtils;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadController;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadController.DeliverVideoTaskListener;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoCompressTask;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoCompressTask.VideoCompressTaskListener;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo.Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class NormalVideoDeliverController
  extends KandianVideoUploadController
  implements VideoCompressTask.VideoCompressTaskListener
{
  private VideoCompressTask A;
  private long B = 0L;
  private long C = 0L;
  private long D = 0L;
  private long E = 0L;
  private long F = 0L;
  private long G = 0L;
  private long H = 0L;
  private long I = 0L;
  private String J = null;
  private String K = null;
  private String L = null;
  private String M = null;
  private boolean N = false;
  private boolean O = false;
  private Context P;
  private FileUploadController.FileUploadListener Q = new NormalVideoDeliverController.1(this);
  private FileUploadController.FileUploadListener R = new NormalVideoDeliverController.2(this);
  public Bundle o;
  ShortVideoResourceStatus.ISVConfig p = new NormalVideoDeliverController.3(this);
  ShortVideoResourceManager.INet_ShortVideoResource q = new NormalVideoDeliverController.4(this);
  private WeakReference<Context> r;
  private boolean s;
  private boolean t;
  private String u;
  private String v;
  private WeakReference<KandianVideoUploadController.DeliverVideoTaskListener> w;
  private QQAppInterface x;
  private FileUploadController y;
  private FileUploadController z;
  
  public NormalVideoDeliverController(Context paramContext, KandianVideoUploadController.DeliverVideoTaskListener paramDeliverVideoTaskListener, Intent paramIntent)
  {
    this.r = new WeakReference(paramContext);
    this.w = new WeakReference(paramDeliverVideoTaskListener);
    this.o = paramIntent.getExtras();
    this.P = paramContext;
    a(this.o);
    KanDianVideoUploadUtils.a(this.o);
    this.y = new ImageUploadController(paramContext, this.x, this.Q);
    this.z = new VideoUploadController(paramContext, this.x, this.R, this.u);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    WeakReference localWeakReference = this.w;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.w.get()).a(this.g, paramInt, VideoMetaInfo.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a(this.C).b(this.D).a());
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.x = ((QQAppInterface)ReadInJoyUtils.b());
    this.g = paramBundle.getString("mTaskID");
    this.s = paramBundle.getBoolean("supportShortVideo", false);
    this.t = paramBundle.getBoolean("shortVideoSoReady", false);
    if (!this.t) {
      d();
    }
    this.u = paramBundle.getString("arg_video_path");
    this.v = paramBundle.getString("arg_video_cover");
    paramBundle.putString("mTaskID", this.g);
  }
  
  private void a(VideoMetaInfo paramVideoMetaInfo)
  {
    this.o.putString("compressPath", this.L);
    a(false, this.P, this.o, paramVideoMetaInfo, (KandianVideoUploadController.DeliverVideoTaskListener)this.w.get());
  }
  
  private void b(float paramFloat)
  {
    this.h = ((paramFloat / 100.0F + 1.0F) * 50.0F);
    WeakReference localWeakReference = this.w;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (!this.N)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.w.get()).a(this.g, this.h);
    }
  }
  
  private void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transitState: from ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" to ");
    localStringBuilder.append(paramInt);
    QLog.d("VideoDeliverController", 1, localStringBuilder.toString());
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt == 4) {
          b(100.0F);
        }
      }
      else
      {
        c(100.0F);
        if (!this.N) {
          this.z.a(this.L, true);
        }
      }
    }
    else {
      this.y.a(this.v, true);
    }
    this.l = paramInt;
  }
  
  private void c()
  {
    this.A = new VideoCompressTask((Context)this.r.get(), this.s, this.t, this);
    this.A.execute(new String[] { this.u });
    this.F = NetConnInfoCenter.getServerTimeMillis();
  }
  
  private void c(float paramFloat)
  {
    this.h = (paramFloat * 50.0F / 100.0F);
    WeakReference localWeakReference = this.w;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (!this.N)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.w.get()).a(this.g, this.h);
    }
  }
  
  private void c(int paramInt)
  {
    a(paramInt, null, null, null, null, null);
  }
  
  private void d()
  {
    this.s = VideoEnvironment.supportShortVideoRecordAndPlay();
    this.t = VideoEnvironment.checkAndLoadAVCodec();
    if (!this.s)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131905438), null);
      return;
    }
    if (this.t)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件ready", null);
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件not ready", null);
    if (NetworkUtil.isNetworkAvailable(null))
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131905433), null);
      ShortVideoResourceManager.b(this.x, this.p);
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131905431), null);
  }
  
  private void d(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.I;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance((Context)this.r.get());
    String str = this.x.getCurrentAccountUin();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
  }
  
  public void a()
  {
    this.m = System.currentTimeMillis();
    this.N = false;
    this.O = false;
    c();
    b(1);
    this.I = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void a(float paramFloat)
  {
    c(paramFloat);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              c(4);
              d(1005);
            }
          }
          else
          {
            c(3);
            d(1003);
          }
        }
        else {
          c(2);
        }
      }
      else {
        c(1);
      }
    }
    else
    {
      this.L = paramString1;
      this.M = paramString2;
      b(2);
    }
    this.E = NetConnInfoCenter.getServerTimeMillis();
    this.B = paramLong1;
    this.C = paramLong2;
    this.D = paramLong3;
  }
  
  public void b()
  {
    this.y.b();
    this.z.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.NormalVideoDeliverController
 * JD-Core Version:    0.7.0.1
 */