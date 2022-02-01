package com.tencent.qqperf.monitor.dropframe;

import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.listener.IDropFrameListener;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.base.AbstractMagnifierItem;
import com.tencent.qqperf.monitor.base.IAPMDropFrame;
import java.util.Arrays;
import org.jetbrains.annotations.Nullable;

public class QAPMDropFrameWrapper
  extends AbstractMagnifierItem
  implements IDropFrameListener, IAPMDropFrame
{
  public String a()
  {
    return "dropframe";
  }
  
  public void a(String paramString)
  {
    if (dH_()) {
      QAPM.beginScene(paramString, QAPM.ModeDropFrame);
    }
  }
  
  public void b(String paramString)
  {
    if (dH_()) {
      QAPM.endScene(paramString, QAPM.ModeDropFrame);
    }
  }
  
  public void j()
  {
    QAPM.setProperty(113, this);
  }
  
  public void onRecordData(@Nullable DropFrameResultMeta paramDropFrameResultMeta)
  {
    long l = (paramDropFrameResultMeta.duration / 1000000.0F);
    double d1 = paramDropFrameResultMeta.dropIntervals[0];
    Double.isNaN(d1);
    double d2 = paramDropFrameResultMeta.dropIntervals[1];
    Double.isNaN(d2);
    double d3 = paramDropFrameResultMeta.dropIntervals[2];
    Double.isNaN(d3);
    double d4 = paramDropFrameResultMeta.dropIntervals[3];
    Double.isNaN(d4);
    d2 = d1 * 16.699999999999999D + d2 * 25.049999999999997D + d3 * 50.099999999999994D + d4 * 100.19999999999999D;
    d3 = l;
    Double.isNaN(d3);
    d1 = d2 / d3;
    d4 = paramDropFrameResultMeta.dropIntervals[4];
    Double.isNaN(d4);
    double d5 = paramDropFrameResultMeta.dropIntervals[5];
    Double.isNaN(d5);
    Double.isNaN(d3);
    d2 = (d2 + d4 * 200.04000000000002D + d5 * 266.72000000000003D) / d3;
    d3 = paramDropFrameResultMeta.smoothTime / paramDropFrameResultMeta.duration;
    DropFrameMonitor.b().a(paramDropFrameResultMeta.scene, l, paramDropFrameResultMeta.dropCount, paramDropFrameResultMeta.dropIntervals, d1, d2, d3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DropFrameQAPM  总滑动时长 ");
      localStringBuilder.append(l);
      localStringBuilder.append(" 老流畅度 ");
      localStringBuilder.append(d1);
      localStringBuilder.append(" 新流畅度 ");
      localStringBuilder.append(d2);
      localStringBuilder.append(" 精准流畅度 ");
      localStringBuilder.append(d3);
      localStringBuilder.append(" 场景 ");
      localStringBuilder.append(paramDropFrameResultMeta.scene);
      localStringBuilder.append(" 具体分布 ");
      localStringBuilder.append(Arrays.toString(paramDropFrameResultMeta.dropIntervals));
      QLog.i("MagnifierSDK.QAPM", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.dropframe.QAPMDropFrameWrapper
 * JD-Core Version:    0.7.0.1
 */