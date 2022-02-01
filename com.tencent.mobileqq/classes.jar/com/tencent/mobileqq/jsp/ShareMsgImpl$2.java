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
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "shareMsgToSina download image:" + this.jdField_a_of_type_JavaLangString);
    }
    String str = ImageUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, null);
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "shareMsgToSina path:" + str);
    }
    if (WBShareHelper.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      WBShareHelper.a(2).a((Activity)this.this$0.a, this.b, this.c, this.d, "text", BitmapFactory.decodeFile(str));
      QLog.d("ShareMsgImpl", 1, "shareMsgToSina use weibo sdk!");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ShareMsgImpl.2.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("ShareMsgImpl", 2, "shareMsgToSina start weibo!");
      }
      return;
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setFlags(268435456);
      localIntent.setType("image/*");
      localIntent.putExtra("android.intent.extra.TEXT", this.b + this.d);
      if (!TextUtils.isEmpty(str)) {
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
      }
      FileProvider7Helper.intentCompatForN(this.jdField_a_of_type_AndroidAppActivity, localIntent);
      localIntent.setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.2
 * JD-Core Version:    0.7.0.1
 */