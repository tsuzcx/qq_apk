package com.tencent.ttpic.openapi.util;

import android.text.TextUtils;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;
import com.tencent.ttpic.util.FrameRateUtil;
import com.tencent.ttpic.util.FrameRateUtil.Operation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GeneralFpsService$FPSFrameCallback
  implements Choreographer.FrameCallback
{
  private boolean enabled = true;
  private List<FrameRateUtil.Operation> tagsList = new ArrayList();
  
  public void addFpsTag(FrameRateUtil.Operation paramOperation)
  {
    if (!this.tagsList.contains(paramOperation)) {
      this.tagsList.add(paramOperation);
    }
  }
  
  public void clearTags()
  {
    this.tagsList.clear();
  }
  
  public void doFrame(long paramLong)
  {
    if (!this.enabled) {
      return;
    }
    Iterator localIterator = this.tagsList.iterator();
    while (localIterator.hasNext())
    {
      FrameRateUtil.Operation localOperation = (FrameRateUtil.Operation)localIterator.next();
      if (localOperation == FrameRateUtil.Operation.CAMERA)
      {
        if (TextUtils.isEmpty(DeviceAttrs.getInstance().str_videoPreview720Fps)) {
          FrameRateUtil.getInstance(localOperation).recordFps(true);
        } else {
          FrameRateUtil.getInstance(localOperation).recordFps(false);
        }
      }
      else {
        FrameRateUtil.getInstance(localOperation).recordFps(false);
      }
    }
    Choreographer.getInstance().postFrameCallback(this);
  }
  
  public void removeFpsTag(FrameRateUtil.Operation paramOperation)
  {
    this.tagsList.remove(paramOperation);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.GeneralFpsService.FPSFrameCallback
 * JD-Core Version:    0.7.0.1
 */