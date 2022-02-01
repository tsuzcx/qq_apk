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
    if (o_()) {
      QAPM.beginScene(paramString, QAPM.ModeDropFrame);
    }
  }
  
  public void b()
  {
    QAPM.setProperty(113, this);
  }
  
  public void b(String paramString)
  {
    if (o_()) {
      QAPM.endScene(paramString, QAPM.ModeDropFrame);
    }
  }
  
  public void onRecordData(@Nullable DropFrameResultMeta paramDropFrameResultMeta)
  {
    DropFrameMonitor.a().a(paramDropFrameResultMeta.scene, (paramDropFrameResultMeta.duration / 1000000.0F), paramDropFrameResultMeta.dropCount, paramDropFrameResultMeta.dropIntervals);
    if (QLog.isColorLevel())
    {
      double d1 = paramDropFrameResultMeta.dropIntervals[0];
      Double.isNaN(d1);
      double d2 = paramDropFrameResultMeta.dropIntervals[1];
      Double.isNaN(d2);
      double d3 = paramDropFrameResultMeta.dropIntervals[2];
      Double.isNaN(d3);
      double d4 = paramDropFrameResultMeta.dropIntervals[3];
      Double.isNaN(d4);
      long l = (paramDropFrameResultMeta.duration / 1000000.0F);
      double d5 = l;
      Double.isNaN(d5);
      d1 = (d1 * 16.699999999999999D + d2 * 25.049999999999997D + d3 * 50.099999999999994D + d4 * 100.19999999999999D) / d5;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DropFrameQAPM ");
      localStringBuilder.append(d1);
      localStringBuilder.append(" 时间 ");
      localStringBuilder.append(l);
      localStringBuilder.append(" 分布 ");
      localStringBuilder.append(Arrays.toString(paramDropFrameResultMeta.dropIntervals));
      QLog.i("MagnifierSDK.QAPM", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.dropframe.QAPMDropFrameWrapper
 * JD-Core Version:    0.7.0.1
 */