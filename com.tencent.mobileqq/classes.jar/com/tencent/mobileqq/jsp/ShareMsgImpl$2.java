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
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ImageUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, null);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("shareMsgToSina path:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject2).toString());
    }
    if (WBShareHelper.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      WBShareHelper.a(2).a((Activity)this.this$0.a, this.b, this.c, this.d, "text", BitmapFactory.decodeFile((String)localObject1));
      QLog.d("ShareMsgImpl", 1, "shareMsgToSina use weibo sdk!");
    }
    else
    {
      localObject2 = new Intent("android.intent.action.SEND");
      ((Intent)localObject2).setFlags(268435456);
      ((Intent)localObject2).setType("image/*");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(this.d);
      ((Intent)localObject2).putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((Intent)localObject2).putExtra("android.intent.extra.STREAM", Uri.fromFile(new File((String)localObject1)));
      }
      FileProvider7Helper.intentCompatForN(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2);
      ((Intent)localObject2).setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ShareMsgImpl.2.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "shareMsgToSina start weibo!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.2
 * JD-Core Version:    0.7.0.1
 */