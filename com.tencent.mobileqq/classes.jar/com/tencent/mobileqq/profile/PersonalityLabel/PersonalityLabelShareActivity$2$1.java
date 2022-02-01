package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class PersonalityLabelShareActivity$2$1
  implements Runnable
{
  PersonalityLabelShareActivity$2$1(PersonalityLabelShareActivity.2 param2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.a)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(this.b);
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      this.c.this$0.sendBroadcast(localIntent);
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, this.c.this$0.getString(2131914171, new Object[] { this.b }), 1).show(this.c.this$0.getTitleBarHeight());
    }
    else
    {
      QRUtils.a(1, 2131914170);
    }
    this.c.this$0.o = true;
    this.c.this$0.u = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity.2.1
 * JD-Core Version:    0.7.0.1
 */