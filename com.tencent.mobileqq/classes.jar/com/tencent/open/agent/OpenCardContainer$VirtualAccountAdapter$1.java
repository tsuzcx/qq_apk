package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.auth.INewAuthorityContract.Presenter;
import com.tencent.open.agent.entity.VirtualAccountInfo;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class OpenCardContainer$VirtualAccountAdapter$1
  implements View.OnClickListener
{
  OpenCardContainer$VirtualAccountAdapter$1(OpenCardContainer.VirtualAccountAdapter paramVirtualAccountAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((OpenCardContainer.VirtualAccountAdapter.a(this.b) != null) && (this.a < OpenCardContainer.VirtualAccountAdapter.a(this.b).size()) && (this.a >= 0))
    {
      if ((this.b.d.a != null) && (OpenCardContainer.VirtualAccountAdapter.a(this.b).get(this.a) != null) && (OpenCardContainer.a(this.b.d) != null)) {
        OpenCardContainer.a(this.b.d).a(((VirtualAccountInfo)OpenCardContainer.VirtualAccountAdapter.a(this.b).get(this.a)).c, QQLiteStatusUtil.a());
      }
      OpenCardContainer.VirtualAccountAdapter.a(this.b).remove(OpenCardContainer.VirtualAccountAdapter.a(this.b).get(this.a));
      this.b.notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.VirtualAccountAdapter.1
 * JD-Core Version:    0.7.0.1
 */