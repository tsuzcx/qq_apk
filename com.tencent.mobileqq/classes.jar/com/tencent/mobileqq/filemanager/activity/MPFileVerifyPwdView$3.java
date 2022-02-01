package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.util.Timer;

class MPFileVerifyPwdView$3
  implements View.OnClickListener
{
  MPFileVerifyPwdView$3(MPFileVerifyPwdView paramMPFileVerifyPwdView) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131694422));
    }
    else
    {
      FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131694232));
      DataLineHandler localDataLineHandler = (DataLineHandler)MPFileVerifyPwdView.a(this.a).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      MPFileVerifyPwdView.a(this.a, localDataLineHandler.a().a(3));
      MPFileVerifyPwdView.b(this.a).setEnabled(false);
      MPFileVerifyPwdView.b(this.a).setTextColor(-7829368);
      MPFileVerifyPwdView.a(this.a).schedule(new MPFileVerifyPwdView.3.1(this), 15000L);
      if (MPFileVerifyPwdView.a(this.a) != null) {
        MPFileVerifyPwdView.a(this.a).a(MPFileVerifyPwdView.a(this.a));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView.3
 * JD-Core Version:    0.7.0.1
 */