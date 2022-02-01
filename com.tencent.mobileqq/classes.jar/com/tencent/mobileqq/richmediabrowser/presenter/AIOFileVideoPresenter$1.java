package com.tencent.mobileqq.richmediabrowser.presenter;

import android.os.Message;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class AIOFileVideoPresenter$1
  extends MqqHandler
{
  AIOFileVideoPresenter$1(AIOFileVideoPresenter paramAIOFileVideoPresenter) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.e != null)
    {
      if (this.a.e.c == null) {
        return;
      }
      if (paramMessage.what == ((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getVideoSaveFailCode())
      {
        QQToast.makeText(this.a.e.c, 2131915755, 0).show();
        return;
      }
      if (paramMessage.what == ((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getVideoSaveSuccessCode())
      {
        paramMessage = (String)paramMessage.obj;
        BaseImageUtil.b(this.a.e.c, paramMessage);
        QQToast.makeText(this.a.e.c, 2, 2131915750, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOFileVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */