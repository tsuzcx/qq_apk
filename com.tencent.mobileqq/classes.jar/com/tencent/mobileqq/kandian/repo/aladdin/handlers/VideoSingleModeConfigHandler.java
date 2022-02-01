package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoSingleModeConfigSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class VideoSingleModeConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReceiveConfig] ");
    localStringBuilder.append(paramString);
    QLog.d("VideoSingleModeConfigHandler", 2, localStringBuilder.toString());
    paramString = AladdinParseUtils.a(paramString);
    if ((String)paramString.get("readinjoy_single_video_switch") != null) {
      RIJVideoSingleModeConfigSp.a((String)paramString.get("readinjoy_single_video_switch"));
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJVideoSingleModeConfigSp.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.VideoSingleModeConfigHandler
 * JD-Core Version:    0.7.0.1
 */