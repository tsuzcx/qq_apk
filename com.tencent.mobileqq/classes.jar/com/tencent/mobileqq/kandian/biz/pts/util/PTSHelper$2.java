package com.tencent.mobileqq.kandian.biz.pts.util;

import android.view.View;
import com.tencent.pts.utils.PTSNodeVirtualUtil.INodeVirtualOnViewClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class PTSHelper$2
  implements PTSNodeVirtualUtil.INodeVirtualOnViewClick
{
  public void onViewClicked(View paramView)
  {
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSHelper.2
 * JD-Core Version:    0.7.0.1
 */