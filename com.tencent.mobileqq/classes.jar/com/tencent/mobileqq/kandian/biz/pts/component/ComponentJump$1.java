package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;

class ComponentJump$1
  implements View.OnClickListener
{
  ComponentJump$1(ComponentJump paramComponentJump, articlesummary.PackJumpInfo paramPackJumpInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.str_url.get();
    ReadInJoyUtils.a(this.b.getContext(), paramView);
    ReadInJoyFooterPresenter.a(2, this.a.str_wording.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentJump.1
 * JD-Core Version:    0.7.0.1
 */