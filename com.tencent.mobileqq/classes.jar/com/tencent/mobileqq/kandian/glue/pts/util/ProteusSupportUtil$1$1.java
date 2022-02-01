package com.tencent.mobileqq.kandian.glue.pts.util;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ProteusSupportUtil$1$1
  implements ViewBase.OnClickListener
{
  ProteusSupportUtil$1$1(ProteusSupportUtil.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.a.getCurActivity() != null)
    {
      ProteusSupportUtil.a(this.a.b, paramViewBase);
      this.a.a.getCurActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil.1.1
 * JD-Core Version:    0.7.0.1
 */