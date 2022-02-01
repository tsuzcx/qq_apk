package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.utils.FSJsUrlUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;

class FSKolMessagePresenter$1
  implements View.OnClickListener
{
  FSKolMessagePresenter$1(FSKolMessagePresenter paramFSKolMessagePresenter, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.e != null) && (this.b.e.busiInfo.get() != null))
    {
      String str = FSJsUrlUtils.a(this.b.e.busiInfo.get(), "noticeFeedJumpUrl");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickSystemMessage get jumpUrl");
      localStringBuilder.append(str);
      QLog.i("FSKolMessagePresenter", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty(str)) {
        FSNativeLauncher.a(this.a, str);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSKolMessagePresenter.1
 * JD-Core Version:    0.7.0.1
 */