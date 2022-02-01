package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AbstractReadInjoyWebShareHelper$6
  implements Runnable
{
  AbstractReadInjoyWebShareHelper$6(AbstractReadInjoyWebShareHelper paramAbstractReadInjoyWebShareHelper, String paramString1, String paramString2, String paramString3, ApplicationInfo paramApplicationInfo, Activity paramActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareMsgToSina download image:");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("AbstractReadInjoyWebShareHelper", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ImageUtil.a(BaseApplication.getContext(), this.a, null);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("shareMsgToSina path:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("AbstractReadInjoyWebShareHelper", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new Intent("android.intent.action.SEND");
    ((Intent)localObject2).setFlags(268435456);
    ((Intent)localObject2).setType("image/*");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    ((Intent)localObject2).putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((Intent)localObject2).putExtra("android.intent.extra.STREAM", Uri.fromFile(new File((String)localObject1)));
    }
    ((Intent)localObject2).setPackage(this.d.packageName);
    this.e.startActivity((Intent)localObject2);
    this.e.runOnUiThread(new AbstractReadInjoyWebShareHelper.6.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina start weibo!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.6
 * JD-Core Version:    0.7.0.1
 */