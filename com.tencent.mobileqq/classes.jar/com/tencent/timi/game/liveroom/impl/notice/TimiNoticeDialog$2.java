package com.tencent.timi.game.liveroom.impl.notice;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveGetAnnounceCallback;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;

class TimiNoticeDialog$2
  implements IQQLiveGetAnnounceCallback
{
  TimiNoticeDialog$2(TimiNoticeDialog paramTimiNoticeDialog) {}
  
  public void a(int paramInt, String paramString)
  {
    CustomToastView.a("服务器出了小差，请稍后重试");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRoomAnnounce failed :errorCode == ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",errorMessage == ");
    localStringBuilder.append(paramString);
    Logger.c("Timi_Notice", localStringBuilder.toString());
    this.a.dismiss();
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRoomAnnounce success : announce == ");
    localStringBuilder.append(paramString);
    Logger.a("Timi_Notice", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      TimiNoticeDialog.a(this.a).setVisibility(0);
      return;
    }
    TimiNoticeDialog.a(this.a).setVisibility(8);
    TimiNoticeDialog.b(this.a).setText(paramString);
    TimiNoticeDialog.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.notice.TimiNoticeDialog.2
 * JD-Core Version:    0.7.0.1
 */