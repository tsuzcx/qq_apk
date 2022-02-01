package com.tencent.open.agent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.Constants;
import com.tencent.open.settings.ServerSetting;

class SocialFriendChooser$1
  extends Handler
{
  SocialFriendChooser$1(SocialFriendChooser paramSocialFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 10001)
    {
      if (i != 10002) {
        return;
      }
      if ((this.a.ah != null) && (!this.a.ah.isCancelled())) {
        this.a.ah.cancel(true);
      }
      this.a.o();
      paramMessage = new Intent();
      paramMessage.putExtra("key_error_code", -7);
      paramMessage.putExtra("key_error_msg", Constants.e);
      this.a.setResult(-1, paramMessage);
      this.a.finish();
      return;
    }
    paramMessage = new Bundle(this.a.N);
    paramMessage.putString("agentversion", CommonDataAdapter.a().k());
    paramMessage.putString("facetype", "mqqface");
    String str = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/appstage/get_image_update");
    OpenSdkFriendService.a().a(str, paramMessage, new SocialFriendChooser.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.SocialFriendChooser.1
 * JD-Core Version:    0.7.0.1
 */