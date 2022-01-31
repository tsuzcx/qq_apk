package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import atdu;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import ndi;

public class QQApiPlugin$2
  implements Runnable
{
  public QQApiPlugin$2(atdu paramatdu, String paramString1, String paramString2, String paramString3, Activity paramActivity, ApplicationInfo paramApplicationInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToSina download image:" + this.jdField_a_of_type_JavaLangString);
    }
    String str = ndi.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, null);
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToSina path:" + str);
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.TEXT", this.b + this.c);
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
    }
    FileProvider7Helper.intentCompatForN(this.jdField_a_of_type_AndroidAppActivity, localIntent);
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new QQApiPlugin.2.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToSina start weibo!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */