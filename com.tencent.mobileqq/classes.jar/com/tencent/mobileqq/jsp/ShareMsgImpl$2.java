package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.wbapi.WBShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ShareMsgImpl$2
  implements Runnable
{
  ShareMsgImpl$2(ShareMsgImpl paramShareMsgImpl, String paramString1, Activity paramActivity, String paramString2, String paramString3, String paramString4, ApplicationInfo paramApplicationInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareMsgToSina download image:");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ImageUtil.a(BaseApplication.getContext(), this.a, null);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("shareMsgToSina path:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject2).toString());
    }
    if (WBShareHelper.a(this.b))
    {
      WBShareHelper.a(2).a((Activity)this.this$0.f, this.c, this.d, this.e, "text", BitmapFactory.decodeFile((String)localObject1));
      QLog.d("ShareMsgImpl", 1, "shareMsgToSina use weibo sdk!");
    }
    else
    {
      localObject2 = new Intent("android.intent.action.SEND");
      ((Intent)localObject2).setFlags(268435456);
      ((Intent)localObject2).setType("image/*");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(this.e);
      ((Intent)localObject2).putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((Intent)localObject2).putExtra("android.intent.extra.STREAM", Uri.fromFile(new File((String)localObject1)));
      }
      FileProvider7Helper.intentCompatForN(this.b, (Intent)localObject2);
      ((Intent)localObject2).setPackage(this.f.packageName);
      this.b.startActivity((Intent)localObject2);
    }
    this.b.runOnUiThread(new ShareMsgImpl.2.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "shareMsgToSina start weibo!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.2
 * JD-Core Version:    0.7.0.1
 */