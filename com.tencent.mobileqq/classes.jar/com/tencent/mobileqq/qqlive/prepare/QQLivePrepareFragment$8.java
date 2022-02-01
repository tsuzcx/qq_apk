package com.tencent.mobileqq.qqlive.prepare;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.api.live.GameLiveResultListener;

class QQLivePrepareFragment$8
  implements GameLiveResultListener
{
  QQLivePrepareFragment$8(QQLivePrepareFragment paramQQLivePrepareFragment) {}
  
  public void a()
  {
    QQLivePrepareFragment.a(this.a, false);
    this.a.getQBaseActivity().finish();
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    QQLivePrepareFragment.a(this.a, false);
    Context localContext = this.a.getContext();
    if (TextUtils.isEmpty(paramString)) {
      paramString = "开播失败";
    }
    QQToast.makeText(localContext, paramString, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.8
 * JD-Core Version:    0.7.0.1
 */