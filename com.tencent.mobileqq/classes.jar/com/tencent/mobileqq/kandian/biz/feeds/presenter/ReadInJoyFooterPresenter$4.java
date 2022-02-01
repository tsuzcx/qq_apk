package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;

class ReadInJoyFooterPresenter$4
  implements View.OnClickListener
{
  ReadInJoyFooterPresenter$4(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter, articlesummary.PackJumpInfo paramPackJumpInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.str_url.get();
    ReadInJoyUtils.a(ReadInJoyFooterPresenter.a(this.b), paramView);
    ReadInJoyFooterPresenter.a(2, this.a.str_wording.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter.4
 * JD-Core Version:    0.7.0.1
 */