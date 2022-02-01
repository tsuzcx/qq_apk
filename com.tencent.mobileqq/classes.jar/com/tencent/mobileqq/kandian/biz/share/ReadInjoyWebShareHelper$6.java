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

class ReadInjoyWebShareHelper$6
  implements Runnable
{
  ReadInjoyWebShareHelper$6(ReadInjoyWebShareHelper paramReadInjoyWebShareHelper, String paramString1, String paramString2, String paramString3, ApplicationInfo paramApplicationInfo, Activity paramActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareMsgToSina download image:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("WebShareHelper", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ImageUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, null);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("shareMsgToSina path:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("WebShareHelper", 2, ((StringBuilder)localObject2).toString());
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
    ((Intent)localObject2).setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ReadInjoyWebShareHelper.6.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("WebShareHelper", 2, "shareMsgToSina start weibo!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper.6
 * JD-Core Version:    0.7.0.1
 */