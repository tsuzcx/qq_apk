package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;

class OlympicShareActionSheetHelper$5$1
  implements Runnable
{
  OlympicShareActionSheetHelper$5$1(OlympicShareActionSheetHelper.5 param5, String paramString) {}
  
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
      localBundle.putInt("key_req", 1);
      localBundle.putInt("key_direct_show_uin_type", this.b.b);
      localBundle.putString("key_direct_show_uin", this.b.c);
      localBundle.putBoolean("key_help_forward_pic", true);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      ((IForwardOption)QRoute.api(IForwardOption.class)).startForwardActivityForResult(this.b.this$0.c, localIntent, ((IForwardApi)QRoute.api(IForwardApi.class)).getForwardRecentTranslucentActivityClass(), 21, 100500, "biz_src_jc_gxl_ctcshare");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.5.1
 * JD-Core Version:    0.7.0.1
 */