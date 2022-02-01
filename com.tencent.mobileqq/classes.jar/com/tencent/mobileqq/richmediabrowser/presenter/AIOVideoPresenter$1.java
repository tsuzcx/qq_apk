package com.tencent.mobileqq.richmediabrowser.presenter;

import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class AIOVideoPresenter$1
  extends MqqHandler
{
  AIOVideoPresenter$1(AIOVideoPresenter paramAIOVideoPresenter) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(AIOVideoPresenter.a(this.a).mContext, 2131719357, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    ImageUtil.a(AIOVideoPresenter.a(this.a).mContext, paramMessage);
    QQToast.a(AIOVideoPresenter.a(this.a).mContext, 2, HardCodeUtil.a(2131700221), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */