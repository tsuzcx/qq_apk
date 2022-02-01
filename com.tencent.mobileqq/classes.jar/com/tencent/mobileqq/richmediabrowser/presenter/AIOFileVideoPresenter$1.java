package com.tencent.mobileqq.richmediabrowser.presenter;

import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class AIOFileVideoPresenter$1
  extends MqqHandler
{
  AIOFileVideoPresenter$1(AIOFileVideoPresenter paramAIOFileVideoPresenter) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.a.mContext, 2131719357, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    ImageUtil.a(this.a.a.mContext, paramMessage);
    QQToast.a(this.a.a.mContext, 2, HardCodeUtil.a(2131700107), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOFileVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */