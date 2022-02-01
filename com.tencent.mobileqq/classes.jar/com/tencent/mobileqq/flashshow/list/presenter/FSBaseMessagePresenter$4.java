package com.tencent.mobileqq.flashshow.list.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

class FSBaseMessagePresenter$4
  implements View.OnClickListener
{
  FSBaseMessagePresenter$4(FSBaseMessagePresenter paramFSBaseMessagePresenter) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.d != null) && (!TextUtils.isEmpty(this.a.d.operation.opUser.id.get())))
    {
      FSPersonalDetailBean localFSPersonalDetailBean = new FSPersonalDetailBean(this.a.e());
      localFSPersonalDetailBean.setUin(this.a.d.operation.opUser.id.get());
      if (!TextUtils.isEmpty(this.a.d.operation.opUser.jumpUrl.get()))
      {
        this.a.b();
        FSNativeLauncher.a(paramView.getContext(), this.a.d.operation.opUser.jumpUrl.get());
      }
      else
      {
        FSNativeLauncher.a(paramView.getContext(), localFSPersonalDetailBean);
      }
    }
    FSBaseMessagePresenter.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter.4
 * JD-Core Version:    0.7.0.1
 */