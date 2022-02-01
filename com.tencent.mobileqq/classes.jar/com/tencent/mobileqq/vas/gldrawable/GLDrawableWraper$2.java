package com.tencent.mobileqq.vas.gldrawable;

import android.media.MediaCodecInfo;
import android.os.Build.VERSION;
import bhpu;
import bhrj;
import bhrl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.ArrayList;
import kotlin.Pair;

public class GLDrawableWraper$2
  implements Runnable
{
  public GLDrawableWraper$2(bhrj parambhrj) {}
  
  public void run()
  {
    Object localObject1;
    if ((bhpu.a()) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject1 = bhrl.a("video/avc");
      if (((ArrayList)localObject1).size() <= 0) {
        break label136;
      }
      localObject1 = ((MediaCodecInfo)((ArrayList)localObject1).get(0)).getName();
      localObject2 = bhrl.a("video/hevc");
      if (((ArrayList)localObject2).size() <= 0) {
        break label142;
      }
    }
    label136:
    label142:
    for (Object localObject2 = ((MediaCodecInfo)((ArrayList)localObject2).get(0)).getName();; localObject2 = "")
    {
      bhpu.a("gldrawable_video_codec", new Pair[] { new Pair("avc", localObject1), new Pair("hevc", localObject2), new Pair("api", String.valueOf(Build.VERSION.SDK_INT)), new Pair("level", String.valueOf(DeviceInfoUtil.getPerfLevel())) });
      return;
      localObject1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper.2
 * JD-Core Version:    0.7.0.1
 */