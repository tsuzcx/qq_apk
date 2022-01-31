package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import aphd;
import apld;
import atqs;
import bcad;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mpl;

public class ForwardSdkBaseOption$9
  implements Runnable
{
  public ForwardSdkBaseOption$9(apld paramapld) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 4, "asyncUploadImageAndSendToBuddy running...");
    }
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || ((this.this$0.m) && (this.this$0.jdField_a_of_type_Aphd != null)))
      {
        if ((this.this$0.b != 65520L) && (!this.this$0.d())) {
          this.this$0.J();
        }
      }
      else {
        try
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 4, "asyncUploadImageAndSendToBuddy sleeping...");
          }
          Thread.sleep(1000L);
          if (QLog.isDevelopLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 4, "asyncUploadImageAndSendToBuddy awake.");
          }
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "InterruptedException", localInterruptedException);
          this.this$0.J();
          return;
        }
      }
    }
    if ((!this.this$0.m) || (TextUtils.isEmpty(this.this$0.k)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardSdkBaseOption", 2, "-->asyncUploadImageAndSendToBuddy--skey not ready");
      }
      this.this$0.H();
      this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardSdkBaseOption.9.1(this));
      this.this$0.J();
      return;
    }
    if (this.this$0.jdField_a_of_type_Aphd != null)
    {
      if ((this.this$0.jdField_a_of_type_Aphd.b() != null) && (this.this$0.b != Long.parseLong("1103584836"))) {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", this.this$0.jdField_a_of_type_Aphd.b());
      }
      if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Aphd.a())) {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", this.this$0.jdField_a_of_type_Aphd.a());
      }
      if (this.this$0.jdField_a_of_type_Aphd.c() != null) {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", this.this$0.jdField_a_of_type_Aphd.c());
      }
      if (this.this$0.jdField_a_of_type_Aphd.d() != null) {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", this.this$0.jdField_a_of_type_Aphd.d());
      }
    }
    String str1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str2 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject2 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
    String str3 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
    Object localObject3 = new HashMap();
    if ((!TextUtils.isEmpty(str2)) && (str2.length() > 150)) {
      ((HashMap)localObject3).put("targetUrl", str2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((HashMap)localObject3).put("sourceUrl", localObject2);
    }
    if (!TextUtils.isEmpty(str3)) {
      ((HashMap)localObject3).put("sourceIcon", str3);
    }
    localObject2 = new ImageInfo();
    ((ImageInfo)localObject2).h = str1;
    ((ImageInfo)localObject2).c = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("uin");
    localObject2 = StructMsgForImageShare.scaleLocalImage(this.this$0.jdField_a_of_type_AndroidAppActivity, (ImageInfo)localObject2, (String)localObject1, this.this$0.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
    long l;
    if (localObject2 == null)
    {
      localObject2 = new CompressInfo((String)localObject1, 0);
      atqs.b((CompressInfo)localObject2);
      if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
      {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("struct_share_key_thumb_height", ((CompressInfo)localObject2).jdField_e_of_type_Int);
        this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("struct_share_key_thumb_width", ((CompressInfo)localObject2).d);
      }
      this.this$0.jdField_a_of_type_AndroidOsBundle.putString("image_url", (String)localObject1);
      this.this$0.jdField_a_of_type_AndroidOsBundle.remove("image_url_remote");
      this.this$0.jdField_a_of_type_AndroidOsBundle.remove("title");
      this.this$0.jdField_a_of_type_AndroidOsBundle.remove("desc");
      this.this$0.jdField_a_of_type_AndroidOsBundle.remove("detail_url");
      l = System.currentTimeMillis();
      localObject1 = new Bundle();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("report_type", "102");
      ((Bundle)localObject2).putString("act_type", "52");
      ((Bundle)localObject2).putString("intext_3", "0");
      ((Bundle)localObject2).putString("stringext_1", str2);
      bcad.a().a((Bundle)localObject2, "", str1, false);
      localObject2 = mpl.a(BaseApplication.getContext(), str1, this.this$0.k, 1, (HashMap)localObject3, (Bundle)localObject1);
      l = System.currentTimeMillis() - l;
      if ((localObject2 == null) || (((HashMap)localObject2).size() <= 0) || (!((String)((HashMap)localObject2).get(((HashMap)localObject2).keySet().iterator().next())).contains("url.cn"))) {
        break label1285;
      }
    }
    label1285:
    for (i = 0;; i = 1)
    {
      if (QLog.isColorLevel())
      {
        localObject3 = "batchUrlExchange for IMAGE_SHARE, isFailed = " + i + ", cost = " + l;
        if ((i != 1) && (l <= 3000L)) {
          break label1274;
        }
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, (String)localObject3);
      }
      for (;;)
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("report_type", "102");
        ((Bundle)localObject3).putString("act_type", "12");
        ((Bundle)localObject3).putString("intext_3", "0");
        ((Bundle)localObject3).putString("intext_1", "" + i);
        ((Bundle)localObject3).putString("intext_2", "" + ((Bundle)localObject1).getInt("retcode", 0));
        ((Bundle)localObject3).putString("intext_5", "" + l);
        if (i == 1) {
          ((Bundle)localObject3).putString("stringext_1", str2);
        }
        bcad.a().a((Bundle)localObject3, "", str1, false);
        if (localObject2 != null)
        {
          if (((HashMap)localObject2).containsKey("imageUrl"))
          {
            this.this$0.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)((HashMap)localObject2).get("imageUrl"));
            this.this$0.jdField_a_of_type_AndroidOsBundle.remove("image_url");
          }
          if (((HashMap)localObject2).containsKey("audioUrl")) {
            this.this$0.jdField_a_of_type_AndroidOsBundle.putString("audio_url", (String)((HashMap)localObject2).get("audioUrl"));
          }
          if (((HashMap)localObject2).containsKey("targetUrl")) {
            this.this$0.jdField_a_of_type_AndroidOsBundle.putString("detail_url", (String)((HashMap)localObject2).get("targetUrl"));
          }
          if (((HashMap)localObject2).containsKey("sourceUrl")) {
            this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", (String)((HashMap)localObject2).get("sourceUrl"));
          }
          if (((HashMap)localObject2).containsKey("sourceIcon")) {
            this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)((HashMap)localObject2).get("sourceIcon"));
          }
        }
        this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardSdkBaseOption.9.2(this));
        return;
        localObject1 = localObject2;
        break;
        label1274:
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, (String)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.9
 * JD-Core Version:    0.7.0.1
 */