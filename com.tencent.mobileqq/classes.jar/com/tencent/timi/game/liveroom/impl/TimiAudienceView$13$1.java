package com.tencent.timi.game.liveroom.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;

class TimiAudienceView$13$1
  implements IQQLiveFollowCallback
{
  TimiAudienceView$13$1(TimiAudienceView.13 param13) {}
  
  public void a()
  {
    Logger.a("TimiAudienceView", "on follow success");
    if (TimiAudienceView.o(this.a.b) != null) {
      TimiAudienceView.o(this.a.b).setFollow(1);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Logger.a("TimiAudienceView", "on follow failed");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "关注失败";
    }
    CustomToastView.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.13.1
 * JD-Core Version:    0.7.0.1
 */