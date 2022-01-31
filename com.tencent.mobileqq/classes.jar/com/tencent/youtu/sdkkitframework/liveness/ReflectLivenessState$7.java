package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import java.util.HashMap;

class ReflectLivenessState$7
  implements YTAGReflectLiveCheckInterface.LightLiveCheckResult
{
  ReflectLivenessState$7(ReflectLivenessState paramReflectLivenessState) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = "message:" + paramString1 + "\ntips:" + paramString2 + "\ncode:" + paramInt;
    YtLogger.e(ReflectLivenessState.access$100(), "failed :" + paramString1);
    paramString1 = new HashMap();
    paramString1.put("ui_tips", "rst_failed");
    paramString1.put("ui_action", "process_finished");
    paramString1.put("process_action", "failed");
    paramString1.put("error_code", Integer.valueOf(4194304));
    paramString1.put("error_reason_code", Integer.valueOf(paramInt));
    paramString1.put("message", "屏幕闪烁时\n请尽量保持不动");
    YtFSM.getInstance().sendFSMEvent(paramString1);
    ReflectLivenessState.access$402(this.this$0, ReflectLivenessState.ReflectProcessType.RPT_FINISH);
  }
  
  public void onSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse, String paramString)
  {
    int i = 0;
    String str;
    if (paramBoolean)
    {
      paramString = "活体检测：通过";
      YtLogger.d(ReflectLivenessState.access$100(), "######lightDiffResponse.similarity_float:" + paramLightDiffResponse.similarity_float);
      str = "rst_failed";
      if (paramLightDiffResponse.similarity_float == -1.0D) {
        break label281;
      }
      if (paramLightDiffResponse.similarity_float <= ReflectLivenessState.access$300(this.this$0)) {
        break label233;
      }
      paramString = paramString + "\n对比验证：通过";
      str = "rst_succeed";
    }
    label281:
    for (;;)
    {
      Object localObject = paramString;
      if (i != 0)
      {
        paramLightDiffResponse.best_image = null;
        localObject = new WeJson();
        localObject = paramString + "\n" + ((WeJson)localObject).toJson(paramLightDiffResponse);
      }
      ReflectLivenessState.access$402(this.this$0, ReflectLivenessState.ReflectProcessType.RPT_FINISH);
      i = (int)paramLightDiffResponse.similarity_float;
      YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.7.1(this));
      if (paramBoolean)
      {
        paramLightDiffResponse = (YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE)).getStateDataBy("best_frame");
        YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.7.2(this, (String)localObject, paramLightDiffResponse, str, i));
        return;
        paramString = "活体检测：不通过";
        i = 1;
        break;
        label233:
        paramString = paramString + "\n对比验证：不通过";
        str = "rst_failed";
        i = 1;
        continue;
      }
      YtFSM.getInstance().sendFSMEvent(new ReflectLivenessState.7.3(this, paramLightDiffResponse, (String)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.7
 * JD-Core Version:    0.7.0.1
 */