package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

final class VideoExtractFrameManager$2
  implements VideoExtractFrameTask.Callback
{
  VideoExtractFrameManager$2(VideoExtractFrameManager.VideoInfo paramVideoInfo) {}
  
  public void a(int paramInt, String paramString, HashMap<Integer, VideoExtractFrameTask.FrameInfo> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("执行结果，onResult code = ");
      localStringBuilder.append(paramInt);
      QLog.d("VideoExtractFrame", 2, localStringBuilder.toString());
    }
    try
    {
      int i = VideoExtractFrameManager.d().optInt("KEY_LOCAL_RESULT_SUCC_COUNT", 0);
      VideoExtractFrameManager.d().put("KEY_LOCAL_RESULT_SUCC_COUNT", i + 1);
      RIJSPUtils.a("kandian_video_extract_frame_local_result", VideoExtractFrameManager.d().toString());
      label76:
      VideoExtractFrameManager.a(System.currentTimeMillis() - VideoExtractFrameManager.e());
      VideoExtractFrameManager.b(paramLong);
      VideoExtractFrameManager.a(BaseApplication.getContext(), this.a, paramInt, paramString, paramHashMap);
      if (!VideoExtractFrameManager.c().compareAndSet(false, true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "任务已销毁，直接返回");
        }
        return;
      }
      if (VideoExtractFrameManager.f() != null)
      {
        VideoExtractFrameManager.f().b();
        VideoExtractFrameManager.a(null);
      }
      return;
    }
    catch (Exception localException)
    {
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameManager.2
 * JD-Core Version:    0.7.0.1
 */