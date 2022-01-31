package com.tencent.open.downloadnew;

import android.content.DialogInterface.OnClickListener;
import bcds;
import bcdz;
import bchb;
import bchf;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

public class MyAppApi$15$1
  implements Runnable
{
  public MyAppApi$15$1(bchf parambchf, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bchf.jdField_a_of_type_Bcdz.a();
    if (this.jdField_a_of_type_Bchf.jdField_a_of_type_Bchb.a != null) {
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0)) {
            localStringBuilder = new StringBuilder();
          }
        }
        catch (Exception localException2)
        {
          StringBuilder localStringBuilder;
          String str;
          Object localObject;
          localException2.printStackTrace();
          continue;
          ((TMAssistantCallYYB_V2)this.jdField_a_of_type_Bchf.jdField_a_of_type_Bchb.a()).startToAuthorized(this.jdField_a_of_type_Bchf.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bchf.jdField_a_of_type_Bchb.a, "2");
          continue;
        }
        try
        {
          str = util.buf_to_string(this.jdField_a_of_type_ArrayOfByte);
          this.jdField_a_of_type_Bchf.jdField_a_of_type_Bchb.a.uin = (this.jdField_a_of_type_JavaLangString + "&identity=" + str);
          this.jdField_a_of_type_Bchf.jdField_a_of_type_Bchb.d = this.jdField_a_of_type_Bchf.jdField_a_of_type_Long;
          if (this.jdField_a_of_type_Bchf.jdField_a_of_type_Bchb.a() <= 2)
          {
            ((TMAssistantCallYYB_V1)this.jdField_a_of_type_Bchf.jdField_a_of_type_Bchb.a()).startToAuthorized(this.jdField_a_of_type_Bchf.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bchf.jdField_a_of_type_Bchb.a, "2");
            this.jdField_a_of_type_Bchf.jdField_a_of_type_Bchb.a = null;
            if (this.jdField_a_of_type_Bchf.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
              this.jdField_a_of_type_Bchf.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
            }
            return;
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject = null;
        }
      }
    }
    bcds.e("MyAppApi", "startToAuthorizedDirect->onGetA1 mLastAuthorizeParam = null, needCarryQQIdentity = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.15.1
 * JD-Core Version:    0.7.0.1
 */