package com.tencent.mobileqq.kandian.glue.pts.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;

class ProteusSupportUtil$1$3
  implements ViewBase.OnClickListener
{
  ProteusSupportUtil$1$3(ProteusSupportUtil.1 param1, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.b.b != null)
    {
      ProteusSupportUtil.a(this.b.b.findViewById(this.a.getName()));
      ProteusSupportUtil.a(this.b.b, this.a);
    }
    RIJJumpUtils.c(this.b.a.getContext(), this.a.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil.1.3
 * JD-Core Version:    0.7.0.1
 */