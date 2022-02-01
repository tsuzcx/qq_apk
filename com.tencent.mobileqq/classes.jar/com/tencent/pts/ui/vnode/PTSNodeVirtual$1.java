package com.tencent.pts.ui.vnode;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PTSNodeVirtual$1
  implements View.OnClickListener
{
  PTSNodeVirtual$1(PTSNodeVirtual paramPTSNodeVirtual) {}
  
  public void onClick(View paramView)
  {
    PTSNodeVirtual.access$000(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeVirtual.1
 * JD-Core Version:    0.7.0.1
 */