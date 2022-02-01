package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.HashMap;
import java.util.Map;

public class StdEventParamChecker
{
  private static final Map<StdEventCode, Class<?>> CODE_BUILDER_MAP = new HashMap();
  private static final String TAG = "StdEventParamChecker";
  
  static
  {
    CODE_BUILDER_MAP.put(StdEventCode.VIDEO_START, VideoStartEventParamsBuilder.class);
    CODE_BUILDER_MAP.put(StdEventCode.VIDEO_END, VideoEndEventParamsBuilder.class);
  }
  
  public static boolean checkParamBuilder(StdEventCode paramStdEventCode, IEventParamsBuilder paramIEventParamsBuilder)
  {
    Class localClass = (Class)CODE_BUILDER_MAP.get(paramStdEventCode);
    if (localClass == null)
    {
      handleError("校验错误, 事件 [" + paramStdEventCode.codeName + "] 不支持!");
      return false;
    }
    if (!localClass.isInstance(paramIEventParamsBuilder))
    {
      handleError("校验错误, 事件 [" + paramStdEventCode.codeName + "] 需要使用 " + localClass.getSimpleName());
      return false;
    }
    if ((paramIEventParamsBuilder instanceof BaseEventParamsBuilder))
    {
      paramIEventParamsBuilder = ((BaseEventParamsBuilder)paramIEventParamsBuilder).checkValidity();
      if (!paramIEventParamsBuilder.success)
      {
        handleError("校验错误, 事件 [" + paramStdEventCode.codeName + "] 参数有误：\n" + paramIEventParamsBuilder.errMsg);
        return false;
      }
    }
    return true;
  }
  
  private static void handleError(String paramString)
  {
    Log.e("StdEventParamChecker", paramString);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Toast.makeText(ReportUtils.getContext(), paramString, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventParamChecker
 * JD-Core Version:    0.7.0.1
 */