package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.text.TextUtils;
import apld;
import bcad;
import bcdx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;

public class ForwardSdkBaseOption$3
  implements Runnable
{
  public ForwardSdkBaseOption$3(apld paramapld, String paramString) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    apld.a(this.this$0, "KEY_STAGE_1_CHANGE_IMG_URL");
    Object localObject = bcdx.a(this.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    apld.a(this.this$0, "KEY_STAGE_1_CHANGE_IMG_URL", true);
    int i = ((Integer)localObject[0]).intValue();
    boolean bool = ((Boolean)localObject[1]).booleanValue();
    String str = (String)localObject[2];
    l = System.currentTimeMillis() - l;
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSdkBaseOption", 2, new Object[] { "changeRemoteUrl|ret=", Integer.valueOf(i), ",needRich=", Boolean.valueOf(bool), ",url=", str, ",cost=", Long.valueOf(l) });
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "19");
    localBundle.putString("intext_1", "" + i);
    if (bool)
    {
      localObject = "1";
      localBundle.putString("intext_2", (String)localObject);
      localBundle.putString("intext_3", "0");
      localBundle.putString("intext_5", "" + l);
      localBundle.putString("stringext_2", this.a);
      bcad.a().a(localBundle, "" + this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      if ((!bool) || (this.this$0.n)) {
        break label378;
      }
      QLog.d("ForwardSdkBaseOption", 1, new Object[] { "changeRemoteUrl|need rich since invalid url=", this.a });
      this.this$0.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", "");
      apld.a(this.this$0).sendEmptyMessage(0);
    }
    for (;;)
    {
      return;
      localObject = "0";
      break;
      label378:
      if ((i != 0) || (TextUtils.isEmpty(str))) {
        continue;
      }
      try
      {
        this.this$0.jdField_a_of_type_AndroidOsBundle.putByte("struct_share_key_image_url_status", (byte)3);
        bcdx.a(false, this.a, this.a, str);
        this.this$0.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", str);
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {
          continue;
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.updateCover(str);
        apld.a(this.this$0).sendEmptyMessage(2);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardSdkBaseOption", 2, localException, new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.3
 * JD-Core Version:    0.7.0.1
 */