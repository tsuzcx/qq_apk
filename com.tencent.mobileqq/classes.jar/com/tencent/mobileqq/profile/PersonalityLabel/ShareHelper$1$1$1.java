package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;

class ShareHelper$1$1$1
  implements Runnable
{
  ShareHelper$1$1$1(ShareHelper.1.1 param1, String paramString) {}
  
  public void run()
  {
    if (this.b.a.a.e.isFinishing()) {
      return;
    }
    this.b.a.a.g.a(false);
    if (TextUtils.isEmpty(this.a))
    {
      QRUtils.a(1, 2131894251);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.a);
    localBundle.putString("forward_thumb", this.a);
    localBundle.putString("forward_urldrawable_big_url", this.a);
    localBundle.putString("forward_extra", this.a);
    localBundle.putInt(ForwardBaseOption.M, 1);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a(this.b.a.a.e, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1.1
 * JD-Core Version:    0.7.0.1
 */