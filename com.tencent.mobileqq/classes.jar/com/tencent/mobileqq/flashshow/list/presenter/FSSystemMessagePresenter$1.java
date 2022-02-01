package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.utils.FSJsUrlUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StNotice;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;

class FSSystemMessagePresenter$1
  implements View.OnClickListener
{
  FSSystemMessagePresenter$1(FSSystemMessagePresenter paramFSSystemMessagePresenter, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clickSystemMessage messageId");
    ((StringBuilder)localObject).append(this.b.d.feedId.get());
    QLog.i("FSSystemMessagePresenter", 1, ((StringBuilder)localObject).toString());
    if ((this.b.e != null) && (this.b.e.busiInfo.get() != null))
    {
      localObject = FSJsUrlUtils.a(this.b.e.busiInfo.get(), "noticeFeedJumpUrl");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickSystemMessage get jumpUrl");
      localStringBuilder.append((String)localObject);
      QLog.i("FSSystemMessagePresenter", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        FSNativeLauncher.a(this.a, (String)localObject, null, -1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSSystemMessagePresenter.1
 * JD-Core Version:    0.7.0.1
 */