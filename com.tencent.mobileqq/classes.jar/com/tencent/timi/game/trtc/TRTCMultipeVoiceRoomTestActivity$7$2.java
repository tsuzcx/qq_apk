package com.tencent.timi.game.trtc;

import com.tencent.mobileqq.widget.QQToast;

class TRTCMultipeVoiceRoomTestActivity$7$2
  implements Runnable
{
  TRTCMultipeVoiceRoomTestActivity$7$2(TRTCMultipeVoiceRoomTestActivity.7 param7, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = this.a;
    TRTCMultipeVoiceRoomTestActivity localTRTCMultipeVoiceRoomTestActivity;
    StringBuilder localStringBuilder;
    if (i == -2)
    {
      localTRTCMultipeVoiceRoomTestActivity = this.c.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("请退出该业务后重试，业务：");
      localStringBuilder.append(this.b);
      QQToast.makeText(localTRTCMultipeVoiceRoomTestActivity, localStringBuilder.toString(), 1).show();
    }
    else if (i == -1)
    {
      localTRTCMultipeVoiceRoomTestActivity = this.c.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("业务所需组件加载失败，请稍后重试：");
      localStringBuilder.append(this.b);
      QQToast.makeText(localTRTCMultipeVoiceRoomTestActivity, localStringBuilder.toString(), 1).show();
    }
    else if (i == -3)
    {
      localTRTCMultipeVoiceRoomTestActivity = this.c.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("用户权限校验失败，请稍后重试：");
      localStringBuilder.append(this.b);
      QQToast.makeText(localTRTCMultipeVoiceRoomTestActivity, localStringBuilder.toString(), 1).show();
    }
    this.c.a.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity.7.2
 * JD-Core Version:    0.7.0.1
 */