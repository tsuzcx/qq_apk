package com.tencent.mobileqq.qqlive.prepare;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.api.live.GameLiveResultListener;

class QQLivePrepareFragment$14
  implements GameLiveResultListener
{
  QQLivePrepareFragment$14(QQLivePrepareFragment paramQQLivePrepareFragment) {}
  
  public void a()
  {
    this.a.getQBaseActivity().finish();
  }
  
  public void a(int paramInt, String paramString)
  {
    Context localContext = this.a.getContext();
    if (TextUtils.isEmpty(paramString)) {
      paramString = "恢复直播失败";
    }
    QQToast.makeText(localContext, paramString, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.14
 * JD-Core Version:    0.7.0.1
 */