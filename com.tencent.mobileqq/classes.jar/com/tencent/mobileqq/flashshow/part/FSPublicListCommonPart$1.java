package com.tencent.mobileqq.flashshow.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.flashshow.list.blocks.FSBaseListBlock;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSPublicListCommonPart$1
  implements View.OnClickListener
{
  FSPublicListCommonPart$1(FSPublicListCommonPart paramFSPublicListCommonPart, int paramInt, View paramView, FSBaseListBlock paramFSBaseListBlock) {}
  
  public void onClick(View paramView)
  {
    FSPublicListCommonPart.a(this.d, this.a);
    if (FastClickUtils.a(String.valueOf(this.b.hashCode()))) {
      this.c.onDoubleClickTitle();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSPublicListCommonPart.1
 * JD-Core Version:    0.7.0.1
 */