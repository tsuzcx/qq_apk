package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
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
    while ((i < 3) && ((!this.this$0.n) || (this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo == null))) {
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
        this.this$0.L();
        return;
      }
    }
    if ((this.this$0.b != 65520L) && (!this.this$0.w()))
    {
      this.this$0.L();
      return;
    }
    if ((this.this$0.n) && (!TextUtils.isEmpty(this.this$0.k)))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo != null)
      {
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.b() != null) && (this.this$0.b != Long.parseLong("1103584836"))) {
          this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.b());
        }
        if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.a())) {
          this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.a());
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.c() != null) {
          this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.c());
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.d() != null) {
          this.this$0.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", this.this$0.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.d());
        }
      }
      String str2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str3 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
      Object localObject2 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("image_url");
      Object localObject1 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
      String str1 = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
      HashMap localHashMap = new HashMap();
      if ((!TextUtils.isEmpty(str3)) && (str3.length() > 150)) {
        localHashMap.put("targetUrl", str3);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localHashMap.put("sourceUrl", localObject1);
      }
      if (!TextUtils.isEmpty(str1)) {
        localHashMap.put("sourceIcon", str1);
      }
      localObject1 = new ImageInfo();
      ((ImageInfo)localObject1).h = str2;
      ((ImageInfo)localObject1).c = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("uin");
      str1 = StructMsgForImageShare.scaleLocalImage(this.this$0.jdField_a_of_type_AndroidAppActivity, (ImageInfo)localObject1, (String)localObject2, this.this$0.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
      localObject1 = str1;
      if (str1 == null) {
        localObject1 = localObject2;
      }
      localObject2 = new CompressInfo((String)localObject1, 0);
      ((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail((CompressInfo)localObject2);
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
      this.this$0.a(str3, str2, localHashMap);
      return;
    }
    this.this$0.a("ForwardOption.ForwardSdkBaseOption", "-->asyncUploadImageAndSendToBuddy--skey not ready");
    this.this$0.J();
    this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardSdkBaseOption.8.1(this));
    this.this$0.L();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.8
 * JD-Core Version:    0.7.0.1
 */