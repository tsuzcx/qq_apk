package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import aufu;
import ayyz;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ForwardSdkBaseOption$8
  implements Runnable
{
  ForwardSdkBaseOption$8(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void run()
  {
    this.this$0.a("ForwardOption.ForwardSdkBaseOption", "asyncUploadImageAndSendToBuddy running...");
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || ((this.this$0.m) && (this.this$0.jdField_a_of_type_Aufu != null)))
      {
        if ((this.this$0.b != 65520L) && (!this.this$0.s())) {
          this.this$0.K();
        }
      }
      else {
        try
        {
          this.this$0.a("ForwardOption.ForwardSdkBaseOption", "asyncUploadImageAndSendToBuddy sleeping...");
          Thread.sleep(1000L);
          this.this$0.a("ForwardOption.ForwardSdkBaseOption", "asyncUploadImageAndSendToBuddy awake.");
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "InterruptedException", localInterruptedException);
          this.this$0.K();
          return;
        }
      }
    }
    if ((!this.this$0.m) || (TextUtils.isEmpty(this.this$0.k)))
    {
      this.this$0.a("ForwardOption.ForwardSdkBaseOption", "-->asyncUploadImageAndSendToBuddy--skey not ready");
      this.this$0.I();
      this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardSdkBaseOption.8.1(this));
      this.this$0.K();
      return;
    }
    if (this.this$0.jdField_a_of_type_Aufu != null)
    {
      if ((this.this$0.jdField_a_of_type_Aufu.b() != null) && (this.this$0.b != Long.parseLong("1103584836"))) {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", this.this$0.jdField_a_of_type_Aufu.b());
      }
      if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Aufu.a())) {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", this.this$0.jdField_a_of_type_Aufu.a());
      }
      if (this.this$0.jdField_a_of_type_Aufu.c() != null) {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", this.this$0.jdField_a_of_type_Aufu.c());
      }
      if (this.this$0.jdField_a_of_type_Aufu.d() != null) {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", this.this$0.jdField_a_of_type_Aufu.d());
      }
    }
    String str1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str2 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject2 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
    String str3 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
    HashMap localHashMap = new HashMap();
    if ((!TextUtils.isEmpty(str2)) && (str2.length() > 150)) {
      localHashMap.put("targetUrl", str2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localHashMap.put("sourceUrl", localObject2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localHashMap.put("sourceIcon", str3);
    }
    localObject2 = new ImageInfo();
    ((ImageInfo)localObject2).h = str1;
    ((ImageInfo)localObject2).c = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("uin");
    localObject2 = StructMsgForImageShare.scaleLocalImage(this.this$0.jdField_a_of_type_AndroidAppActivity, (ImageInfo)localObject2, (String)localObject1, this.this$0.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
    if (localObject2 == null) {}
    for (;;)
    {
      localObject2 = new CompressInfo((String)localObject1, 0);
      ayyz.b((CompressInfo)localObject2);
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
      this.this$0.a(str2, str1, localHashMap);
      return;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.8
 * JD-Core Version:    0.7.0.1
 */