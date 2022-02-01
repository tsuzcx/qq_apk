package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;

class OlympicShareActionSheetHelper$6$1
  implements Runnable
{
  OlympicShareActionSheetHelper$6$1(OlympicShareActionSheetHelper.6 param6, String paramString) {}
  
  public void run()
  {
    if (this.b.this$0.c != null)
    {
      if (this.b.this$0.c.isFinishing()) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putString("forward_filepath", this.a);
      localBundle.putString("forward_thumb", this.a);
      localBundle.putString("forward_urldrawable_big_url", this.a);
      localBundle.putString("forward_extra", this.a);
      localBundle.putBoolean("key_help_forward_pic", true);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      ((IForwardOption)QRoute.api(IForwardOption.class)).startForwardActivityForResult(this.b.this$0.c, localIntent, ((IForwardApi)QRoute.api(IForwardApi.class)).getForwardRecentTranslucentActivityClass(), 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.6.1
 * JD-Core Version:    0.7.0.1
 */