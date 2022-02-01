package com.tencent.mobileqq.kandian.biz.video.danmaku.ext;

import android.os.SystemClock;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ext/DanmakuDrawTimerExt;", "Lcom/tencent/common/danmaku/tool/DanmakuDrawTimer;", "()V", "mBaseTime", "", "mElapsedTime", "mLastInterval", "mSpeedRatio", "", "getSpeedRatio", "getTime", "lastInterval", "resetTime", "", "setSpeedRatio", "playerSpeedRatio", "update", "updateBaseTime", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuDrawTimerExt
  extends DanmakuDrawTimer
{
  private long a;
  private long b;
  private long c;
  private float d = 1.0F;
  
  public void a()
  {
    this.a = 0L;
    this.b = 0L;
  }
  
  public final void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public long b()
  {
    return this.a;
  }
  
  public long c()
  {
    this.b = (((float)(SystemClock.uptimeMillis() - this.c) * this.d));
    this.a += this.b;
    d();
    return this.b;
  }
  
  public void d()
  {
    this.c = SystemClock.uptimeMillis();
  }
  
  public long e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.ext.DanmakuDrawTimerExt
 * JD-Core Version:    0.7.0.1
 */