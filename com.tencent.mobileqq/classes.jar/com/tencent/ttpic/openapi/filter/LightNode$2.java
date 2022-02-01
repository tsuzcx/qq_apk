package com.tencent.ttpic.openapi.filter;

import android.util.Log;
import org.light.listener.TipsListener;

class LightNode$2
  implements TipsListener
{
  LightNode$2(LightNode paramLightNode) {}
  
  public void tipsNeedHide(String paramString1, String paramString2, int paramInt)
  {
    Log.d("LightNode", "tipsNeedHide: tips=" + paramString1 + ", icon=" + paramString2 + ", type=" + paramInt);
    if (LightNode.access$100(this.this$0) != null)
    {
      if (paramInt != 0) {
        break label70;
      }
      LightNode.access$100(this.this$0).onHideNormalTip();
    }
    label70:
    while (paramInt != 1) {
      return;
    }
    LightNode.access$100(this.this$0).onHidePagTip();
  }
  
  public void tipsNeedShow(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Log.d("LightNode", "tipsNeedShow: tips=" + paramString1 + ", icon=" + paramString2 + ", type=" + paramInt1 + ", duration=" + paramInt2);
    if (LightNode.access$100(this.this$0) != null)
    {
      if (paramInt1 != 0) {
        break label84;
      }
      LightNode.access$100(this.this$0).onShowNormalTip(paramString1, paramString2, paramInt2);
    }
    label84:
    while (paramInt1 != 1) {
      return;
    }
    LightNode.access$100(this.this$0).onShowPagTip(paramString2, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.LightNode.2
 * JD-Core Version:    0.7.0.1
 */