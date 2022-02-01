package com.tencent.timi.game.liveroom.impl.notice;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveSetAnnounceCallback;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;

class TimiNoticeEditFragment$3
  implements IQQLiveSetAnnounceCallback
{
  TimiNoticeEditFragment$3(TimiNoticeEditFragment paramTimiNoticeEditFragment) {}
  
  public void a()
  {
    SimpleEventBus.getInstance().dispatchEvent(new UpdateNoticeEvent());
    TimiNoticeEditFragment.b(this.a);
    CustomToastView.b("公告保存成功");
    Logger.a("Timi_Notice", "getRoomAnnounce success ");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt != -11654) {
      localObject = "服务器出了小差，请稍后重试";
    } else {
      localObject = "内容存在敏感信息，请检查修改后再尝试";
    }
    CustomToastView.a((String)localObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getRoomAnnounce failed :errorCode == ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",errorMessage == ");
    ((StringBuilder)localObject).append(paramString);
    Logger.c("Timi_Notice", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.notice.TimiNoticeEditFragment.3
 * JD-Core Version:    0.7.0.1
 */