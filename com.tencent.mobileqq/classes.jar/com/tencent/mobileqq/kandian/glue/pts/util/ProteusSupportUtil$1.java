package com.tencent.mobileqq.kandian.glue.pts.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

final class ProteusSupportUtil$1
  implements ViewFactory.FoundClickableViewListener
{
  ProteusSupportUtil$1(VafContext paramVafContext, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    if (i != 1134)
    {
      if (i != 1135)
      {
        paramViewBase.setOnClickListener(new ProteusSupportUtil.1.3(this, paramViewBase));
        return;
      }
      paramViewBase.setOnClickListener(new ProteusSupportUtil.1.2(this));
      return;
    }
    paramViewBase.setOnClickListener(new ProteusSupportUtil.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil.1
 * JD-Core Version:    0.7.0.1
 */