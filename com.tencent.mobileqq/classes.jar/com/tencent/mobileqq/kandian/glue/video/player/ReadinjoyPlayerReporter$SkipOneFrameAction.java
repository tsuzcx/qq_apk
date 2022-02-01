package com.tencent.mobileqq.kandian.glue.video.player;

import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadinjoyPlayerReporter$SkipOneFrameAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public void a(int paramInt, Object paramObject)
  {
    int i = 0;
    try
    {
      paramObject = new JSONObject((String)paramObject);
      paramInt = paramObject.optInt("decoderMode", 0);
      try
      {
        int j = paramObject.optInt("skipFrameCount", 1);
        i = j;
      }
      catch (Exception paramObject) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Exception paramObject)
    {
      paramInt = 0;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("SkipOneFrameAction json error :");
    localStringBuilder.append(paramObject.getMessage());
    QLog.e("ReadinjoyPlayerReporter", 2, localStringBuilder.toString());
    if (i > 0)
    {
      paramObject = this.a.a;
      paramObject.X += i;
    }
    paramObject = this.a.a;
    paramObject.Y += i;
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = ");
      paramObject.append(paramInt);
      paramObject.append(", skipFrameCount = ");
      paramObject.append(i);
      paramObject.append(", totalSkipCount = ");
      paramObject.append(this.a.a.X);
      paramObject.append(", finalSkipCount = ");
      paramObject.append(this.a.a.Y);
      QLog.d("ReadinjoyPlayerReporter", 2, paramObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.SkipOneFrameAction
 * JD-Core Version:    0.7.0.1
 */