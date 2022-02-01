package com.tencent.mobileqq.kandian.biz.video.danmaku.ext;

import android.os.SystemClock;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ext/DanmakuDrawTimerExt;", "Lcom/tencent/mobileqq/danmaku/tool/DanmakuDrawTimer;", "()V", "mBaseTime", "", "mElapsedTime", "mLastInterval", "mSpeedRatio", "", "getSpeedRatio", "getTime", "lastInterval", "resetTime", "", "setSpeedRatio", "playerSpeedRatio", "update", "updateBaseTime", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuDrawTimerExt
  extends DanmakuDrawTimer
{
  private float jdField_a_of_type_Float = 1.0F;
  private long jdField_a_of_type_Long;
  private long b;
  private long c;
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public long b()
  {
    this.b = (((float)(SystemClock.uptimeMillis() - this.c) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_Long += this.b;
    b();
    return this.b;
  }
  
  public void b()
  {
    this.c = SystemClock.uptimeMillis();
  }
  
  public long c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.ext.DanmakuDrawTimerExt
 * JD-Core Version:    0.7.0.1
 */