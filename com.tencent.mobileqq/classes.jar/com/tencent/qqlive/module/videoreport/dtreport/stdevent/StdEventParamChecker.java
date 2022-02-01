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
    Object localObject = (Class)CODE_BUILDER_MAP.get(paramStdEventCode);
    if (localObject == null)
    {
      paramIEventParamsBuilder = new StringBuilder();
      paramIEventParamsBuilder.append("校验错误, 事件 [");
      if (paramStdEventCode == null) {
        paramStdEventCode = null;
      } else {
        paramStdEventCode = paramStdEventCode.codeName;
      }
      paramIEventParamsBuilder.append(paramStdEventCode);
      paramIEventParamsBuilder.append("] 不支持!");
      handleError(paramIEventParamsBuilder.toString());
      return false;
    }
    if (!((Class)localObject).isInstance(paramIEventParamsBuilder))
    {
      paramIEventParamsBuilder = new StringBuilder();
      paramIEventParamsBuilder.append("校验错误, 事件 [");
      paramIEventParamsBuilder.append(paramStdEventCode.codeName);
      paramIEventParamsBuilder.append("] 需要使用 ");
      paramIEventParamsBuilder.append(((Class)localObject).getSimpleName());
      handleError(paramIEventParamsBuilder.toString());
      return false;
    }
    if ((paramIEventParamsBuilder instanceof BaseEventParamsBuilder))
    {
      paramIEventParamsBuilder = ((BaseEventParamsBuilder)paramIEventParamsBuilder).checkValidity();
      if (!paramIEventParamsBuilder.success)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("校验错误, 事件 [");
        ((StringBuilder)localObject).append(paramStdEventCode.codeName);
        ((StringBuilder)localObject).append("] 参数有误：\n");
        ((StringBuilder)localObject).append(paramIEventParamsBuilder.errMsg);
        handleError(((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventParamChecker
 * JD-Core Version:    0.7.0.1
 */