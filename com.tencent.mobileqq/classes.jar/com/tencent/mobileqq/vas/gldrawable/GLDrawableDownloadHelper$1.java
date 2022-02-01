package com.tencent.mobileqq.vas.gldrawable;

import android.media.MediaCodecInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.ArrayList;
import kotlin.Pair;

final class GLDrawableDownloadHelper$1
  implements Runnable
{
  public void run()
  {
    GLDrawableDownloadHelper.a(Utils.a("video/avc").isEmpty() ^ true);
    if ((VasStatisticCollector.a()) && (Build.VERSION.SDK_INT >= 16))
    {
      Object localObject = Utils.a("video/avc");
      int i = ((ArrayList)localObject).size();
      String str = "";
      if (i > 0) {
        localObject = ((MediaCodecInfo)((ArrayList)localObject).get(0)).getName();
      } else {
        localObject = "";
      }
      ArrayList localArrayList = Utils.a("video/hevc");
      if (localArrayList.size() > 0) {
        str = ((MediaCodecInfo)localArrayList.get(0)).getName();
      }
      VasStatisticCollector.a("gldrawable_video_codec", new Pair[] { new Pair("avc", localObject), new Pair("hevc", str), new Pair("api", String.valueOf(Build.VERSION.SDK_INT)), new Pair("level", String.valueOf(DeviceInfoUtils.a())) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper.1
 * JD-Core Version:    0.7.0.1
 */