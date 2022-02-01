package com.tencent.ttpic.openapi.filter;

import android.util.Log;
import org.light.listener.TipsListener;

class LightNode$2
  implements TipsListener
{
  LightNode$2(LightNode paramLightNode) {}
  
  public void tipsNeedHide(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tipsNeedHide: tips=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", icon=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", type=");
    localStringBuilder.append(paramInt);
    Log.d("LightNode", localStringBuilder.toString());
    if (LightNode.access$100(this.this$0) != null)
    {
      if (paramInt == 0)
      {
        LightNode.access$100(this.this$0).onHideNormalTip();
        return;
      }
      if (paramInt == 1) {
        LightNode.access$100(this.this$0).onHidePagTip();
      }
    }
  }
  
  public void tipsNeedShow(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tipsNeedShow: tips=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", icon=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", type=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(paramInt2);
    Log.d("LightNode", localStringBuilder.toString());
    if (LightNode.access$100(this.this$0) != null)
    {
      if (paramInt1 == 0)
      {
        LightNode.access$100(this.this$0).onShowNormalTip(paramString1, paramString2, paramInt2);
        return;
      }
      if (paramInt1 == 1) {
        LightNode.access$100(this.this$0).onShowPagTip(paramString2, paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.LightNode.2
 * JD-Core Version:    0.7.0.1
 */