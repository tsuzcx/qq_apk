package com.tencent.mobileqq.guild.audio.data;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

public class AudioRoomError
{
  public static String a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 2)
    {
      if (paramInt2 == 46001) {
        return "该子频道已满员，去别的子频道逛逛吧。";
      }
      if (((paramInt2 == 46100) || (paramInt2 == 46200) || (paramInt2 == 23002)) && (!TextUtils.isEmpty(paramString))) {
        return paramString;
      }
      return "加入语音子频道失败";
    }
    if ((paramInt1 == 3) && (paramInt2 == -3301)) {
      return "数据异常，自动退出语音子频道，请稍候重试。";
    }
    return "操作失败";
  }
  
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("audio_exit_reason", Integer.valueOf(paramInt));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).doReportEvent("ev_audio_channel_exit", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.data.AudioRoomError
 * JD-Core Version:    0.7.0.1
 */