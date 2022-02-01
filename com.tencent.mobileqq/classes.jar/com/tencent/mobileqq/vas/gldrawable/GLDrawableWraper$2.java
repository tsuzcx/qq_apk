package com.tencent.mobileqq.vas.gldrawable;

import android.media.MediaCodecInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.ArrayList;
import kotlin.Pair;

class GLDrawableWraper$2
  implements Runnable
{
  GLDrawableWraper$2(GLDrawableWraper paramGLDrawableWraper) {}
  
  public void run()
  {
    Object localObject1;
    if ((VasStatisticCollector.a()) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject1 = Utils.a("video/avc");
      if (((ArrayList)localObject1).size() <= 0) {
        break label136;
      }
      localObject1 = ((MediaCodecInfo)((ArrayList)localObject1).get(0)).getName();
      localObject2 = Utils.a("video/hevc");
      if (((ArrayList)localObject2).size() <= 0) {
        break label142;
      }
    }
    label136:
    label142:
    for (Object localObject2 = ((MediaCodecInfo)((ArrayList)localObject2).get(0)).getName();; localObject2 = "")
    {
      VasStatisticCollector.a("gldrawable_video_codec", new Pair[] { new Pair("avc", localObject1), new Pair("hevc", localObject2), new Pair("api", String.valueOf(Build.VERSION.SDK_INT)), new Pair("level", String.valueOf(DeviceInfoUtils.a())) });
      return;
      localObject1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper.2
 * JD-Core Version:    0.7.0.1
 */