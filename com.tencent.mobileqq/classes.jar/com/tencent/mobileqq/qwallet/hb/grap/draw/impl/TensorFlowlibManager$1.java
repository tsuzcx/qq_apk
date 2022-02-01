package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;

class TensorFlowlibManager$1
  implements OnLoadListener
{
  TensorFlowlibManager$1(TensorFlowlibManager paramTensorFlowlibManager, TensorFlowlibManager.OnInitLibListener paramOnInitLibListener) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      TensorFlowlibManager.a(this.b, true);
      paramLoadExtResult = this.a;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.a(true);
      }
      return;
    }
    paramLoadExtResult = this.a;
    if (paramLoadExtResult != null) {
      paramLoadExtResult.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.TensorFlowlibManager.1
 * JD-Core Version:    0.7.0.1
 */