package com.tencent.mobileqq.winkpublish.task.compress;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.RemoteHandleConst;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.service.video.RemoteVideoServiceHandler;
import com.tencent.mobileqq.winkpublish.task.AUploadQueueTask;
import com.tencent.mobileqq.winkpublish.task.AUploadTask;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VideoCompressTask
  extends AUploadQueueTask
{
  public ShuoshuoVideoInfo a;
  public String b;
  volatile boolean c = false;
  int d;
  boolean e = false;
  VideoCompressTask.VideoCompressListener f;
  public boolean g;
  Runnable h = new VideoCompressTask.1(this);
  VideoCompressTask.HandleVideoTimeoutRunnable i = new VideoCompressTask.HandleVideoTimeoutRunnable(this, null);
  String j = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoProcessVideoTimeOut", "视频处理超时");
  private String k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int o;
  private long p;
  private long q;
  
  public VideoCompressTask(ShuoshuoVideoInfo paramShuoshuoVideoInfo, String paramString, VideoCompressTask.VideoCompressListener paramVideoCompressListener, boolean paramBoolean)
  {
    this.a = paramShuoshuoVideoInfo;
    paramShuoshuoVideoInfo = new StringBuilder();
    paramShuoshuoVideoInfo.append(paramString);
    paramShuoshuoVideoInfo.append(System.currentTimeMillis());
    this.k = paramShuoshuoVideoInfo.toString();
    this.f = paramVideoCompressListener;
    this.g = paramBoolean;
  }
  
  private void p()
  {
    int i1 = this.a.m;
    Object localObject = Integer.valueOf(300000);
    if (i1 == 0) {}
    for (i1 = QCircleConfigHelper.a("MiniVideo", "videoCompressTimeoutRecord", (Integer)localObject).intValue();; i1 = QCircleConfigHelper.a("MiniVideo", "videoCompressTimeoutTrim", (Integer)localObject).intValue())
    {
      l1 = i1;
      break label303;
      if (QCircleConfigHelper.a("MiniVideo", "videoTrimEnableHw", Integer.valueOf(1)).intValue() != 1) {
        break;
      }
    }
    long l3 = new File(this.a.b).length();
    long l2 = this.a.t;
    long l1 = 0L;
    if (l2 != 0L)
    {
      long l4 = (this.a.p - this.a.o) * l3 / this.a.t;
      l2 = QCircleHostQzoneHelper.getLong(QCircleHostQzoneHelper.KEY_VIDEO_COMPRESS_SPEED(), -1L);
      l1 = l2;
      if (l2 <= 0L) {
        l1 = QCircleConfigHelper.a("MiniVideo", "videoCompressSwTrimAverageSpeed", Integer.valueOf(75)).intValue();
      }
      l1 = l4 / l1 * 3L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("compress video, path=");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append(",inputFileSize=");
      localStringBuilder.append(l3);
      localStringBuilder.append(", trimmedFileSize=");
      localStringBuilder.append(l4);
      localStringBuilder.append(", estimate timeout=");
      localStringBuilder.append(l1);
      QLog.i("[upload2_VideoCompressTask]", 1, localStringBuilder.toString());
    }
    l2 = QCircleConfigHelper.a("MiniVideo", "videoCompressTimeoutTrim", (Integer)localObject).intValue();
    if (l1 < l2) {
      l1 = l2;
    }
    label303:
    this.p = 1000L;
    this.q = l1;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("compress video, path=");
    ((StringBuilder)localObject).append(this.a.b);
    ((StringBuilder)localObject).append(" estimate timeout=");
    ((StringBuilder)localObject).append(l1);
    QLog.i("[upload2_VideoCompressTask]", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(AUploadTask paramAUploadTask) {}
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public ShuoshuoVideoInfo b()
  {
    return this.a;
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void c()
  {
    j();
  }
  
  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean cancel()
  {
    d();
    this.l = true;
    return true;
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoCompressTask.abort mVideoHandling:");
    ((StringBuilder)localObject).append(this.c);
    QLog.i("[upload2_VideoCompressTask]", 1, ((StringBuilder)localObject).toString());
    if (this.c)
    {
      this.c = false;
      localObject = Message.obtain();
      ((Message)localObject).what = 1006;
      Intent localIntent = new Intent();
      localIntent.putExtra("client_key", getCacheKey());
      ((Message)localObject).obj = localIntent;
      RemoteVideoServiceHandler.a().b((Message)localObject);
      QCircleHostQzoneThreadHelper.removeRealTimeThreadTask(this.i);
      QCircleHostQzoneThreadHelper.removeRealTimeThreadTask(this.h);
      this.ad = null;
    }
  }
  
  public void e() {}
  
  public boolean f()
  {
    return this.c;
  }
  
  public String getCacheKey()
  {
    return this.k;
  }
  
  public int getExactType()
  {
    return 20;
  }
  
  public double h()
  {
    long l1 = this.q;
    if (l1 == 0L) {
      return 0.0D;
    }
    double d1 = this.o;
    Double.isNaN(d1);
    double d2 = l1;
    Double.isNaN(d2);
    return d1 * 20000.0D / d2;
  }
  
  void j()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoCompressTask.asyncCompressVideo, video path:");
    ((StringBuilder)localObject).append(this.a.b);
    QLog.i("[upload2_VideoCompressTask]", 1, ((StringBuilder)localObject).toString());
    this.c = true;
    localObject = Message.obtain();
    ((Message)localObject).what = 1001;
    Intent localIntent = new Intent();
    localIntent.putExtra("client_key", this.k);
    localIntent.putExtra("video_source_path", this.a.b);
    localIntent.putExtra("video_type", this.a.m);
    localIntent.putExtra("start_time", this.a.o);
    localIntent.putExtra("end_time", this.a.p);
    localIntent.putExtra("need_origin", this.a.q);
    localIntent.putExtra("retry_num", this.d);
    localIntent.putExtra("video_total_duration", this.a.t);
    if (this.g) {
      localIntent.putExtra("noDeleteFile", true);
    }
    localIntent.putExtra("encode_video_params", this.a.u);
    localIntent.putExtra("video_new_fake_vid", this.a.x);
    localIntent.putExtra("video_is_generate_gif", this.e);
    boolean bool;
    if (this.a.u == null) {
      bool = false;
    } else {
      bool = this.a.u.getBoolean("video_is_sync_to_weishi", false);
    }
    localIntent.putExtra("video_is_sync_to_weishi", bool);
    if (this.a.u == null) {
      bool = false;
    } else {
      bool = this.a.u.getBoolean("video_is_use_qcircle_rate", false);
    }
    localIntent.putExtra("video_is_use_qcircle_rate", bool);
    localIntent.putExtra(QCircleHostConstants.RemoteHandleConst.PARAM_FROM_AIO(), this.m);
    localIntent.putExtra(QCircleHostConstants.RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN(), this.n);
    ((Message)localObject).obj = localIntent;
    RemoteVideoServiceHandler.a().b((Message)localObject);
    RemoteVideoServiceHandler.a().a(getCacheKey());
    p();
    this.i.a = getCacheKey();
    this.o = 0;
    this.b = this.a.b;
  }
  
  public void k()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoCompressTask::compress video start, path=");
    ((StringBuilder)localObject).append(this.a.b);
    ((StringBuilder)localObject).append(", start timeout & progress runnable, timeout:");
    ((StringBuilder)localObject).append(this.q);
    QLog.i("[upload2_VideoCompressTask]", 1, ((StringBuilder)localObject).toString());
    QCircleHostQzoneThreadHelper.postRealTimeThreadDelayed(this.i, this.q);
    QCircleHostQzoneThreadHelper.postRealTimeThreadDelayed(this.h, this.p);
    localObject = this.f;
    if (localObject != null) {
      ((VideoCompressTask.VideoCompressListener)localObject).a(this);
    }
  }
  
  void l()
  {
    if ((this.a.m == 0) && (!TextUtils.isEmpty(this.a.b)))
    {
      Object localObject = new File(this.a.b);
      if (((File)localObject).exists())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add to media library, savedFilePath=");
        localStringBuilder.append(this.a.b);
        QLog.i("[upload2_VideoCompressTask]", 1, localStringBuilder.toString());
        localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile((File)localObject));
        RFApplication.getApplication().sendBroadcast((Intent)localObject);
      }
    }
  }
  
  public boolean m()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.compress.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */