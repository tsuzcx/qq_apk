package com.tencent.mobileqq.kandian.biz.hippy.tuwen.util;

import androidx.annotation.VisibleForTesting;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.qphone.base.util.QLog;

@VisibleForTesting
public class TKDTuWenHippyEngineManager$MyEngineListener
  implements HippyQQEngine.HippyQQEngineListener
{
  public TKDTuWenHippyEngineManager$MyEngineListener(TKDTuWenHippyEngineManager paramTKDTuWenHippyEngineManager) {}
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hippy: initHippy error statusCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(paramString);
    QLog.d("TKDTuWenHippyEngineManager", 1, localStringBuilder.toString());
    TKDTuWenHippyEngineManager.access$100(this.this$0, 2);
  }
  
  public void onSuccess()
  {
    QLog.d("TKDTuWenHippyEngineManager", 1, "Hippy: initHippy success");
    TKDTuWenHippyEngineManager.access$100(this.this$0, 3);
    if (TKDTuWenHippyEngineManager.access$200(this.this$0))
    {
      TKDTuWenHippyEngineManager localTKDTuWenHippyEngineManager = this.this$0;
      TKDTuWenHippyEngineManager.access$400(localTKDTuWenHippyEngineManager, TKDTuWenHippyEngineManager.access$300(localTKDTuWenHippyEngineManager));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenHippyEngineManager.MyEngineListener
 * JD-Core Version:    0.7.0.1
 */