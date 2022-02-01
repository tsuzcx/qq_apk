package com.tencent.mobileqq.emosm;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.xaction.openapi.XAApi;
import com.tencent.xaction.openapi.api.IXAGlobal;

public class AIOBubbleAnimHelper
  implements IHelper, ILifeCycleHelper
{
  @NonNull
  public String getTag()
  {
    return "AIOBubbleAnimHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14, 16, 17, 10, 18 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 10)
    {
      if (paramInt != 14) {}
      switch (paramInt)
      {
      default: 
        return;
      case 16: 
      case 17: 
        XAApi.e().pauseAll();
        return;
      }
    }
    XAApi.e().resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOBubbleAnimHelper
 * JD-Core Version:    0.7.0.1
 */