package com.tencent.ttpic.util;

import android.content.Context;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.util.RenderLevelHelper;
import com.tencent.ttpic.openapi.util.RenderLevelHelper.DOWNGRADE_LEVEL;

public class BenchUtilForPitu
  extends BenchUtil
{
  public static String getLastBenchAveragePitu(Context paramContext, int paramInt, double paramDouble)
  {
    paramContext = new StringBuilder();
    float f = elapsed("bench_fps");
    if (f != 0.0F) {
      paramContext.append("fps : " + Math.round(1000.0F / f) + "\n");
    }
    paramContext.append("materialSize : " + paramDouble + " MB\n");
    paramContext.append("rotation : " + paramInt + "\n");
    paramContext.append("render level : " + RenderLevelHelper.getRenderLevel().width + "\n");
    paramContext.append("all preview size : " + PreviewInfoManager.getInstance().getAllPreviewSizeString() + "\n");
    paramContext.append("camera preview size : " + PreviewInfoManager.getInstance().getCameraPreviewSize() + "\n");
    paramContext.append("camera UI size : " + PreviewInfoManager.getInstance().getUISize() + "\n");
    paramContext.append("camera record size : " + PreviewInfoManager.getInstance().getRecordSize() + "\n");
    return paramContext.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.BenchUtilForPitu
 * JD-Core Version:    0.7.0.1
 */