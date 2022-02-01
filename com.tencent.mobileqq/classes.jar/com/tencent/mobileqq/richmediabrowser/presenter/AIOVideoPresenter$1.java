package com.tencent.mobileqq.richmediabrowser.presenter;

import android.os.Message;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class AIOVideoPresenter$1
  extends MqqHandler
{
  AIOVideoPresenter$1(AIOVideoPresenter paramAIOVideoPresenter) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.a != null)
    {
      if (this.a.a.a == null) {
        return;
      }
      if (paramMessage.what == ((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getVideoSaveFailCode())
      {
        QQToast.a(this.a.a.a, 2131718263, 0).a();
        return;
      }
      if (paramMessage.what == ((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getVideoSaveSuccessCode())
      {
        paramMessage = (String)paramMessage.obj;
        BaseImageUtil.a(this.a.a.a, paramMessage);
        QQToast.a(this.a.a.a, 2, 2131718258, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */