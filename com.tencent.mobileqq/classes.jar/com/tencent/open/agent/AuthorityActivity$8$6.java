package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Message;
import arzy;
import bexw;
import cooperation.qqfav.util.HandlerPlus;

public class AuthorityActivity$8$6
  implements Runnable
{
  public AuthorityActivity$8$6(bexw parambexw, String paramString) {}
  
  public void run()
  {
    arzy.a("KEY_GET_APP_ADS_PIC");
    Bitmap localBitmap = AuthorityActivity.a(this.jdField_a_of_type_JavaLangString);
    arzy.a("KEY_GET_APP_ADS_PIC", this.jdField_a_of_type_Bexw.a.jdField_a_of_type_Bfmm);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 9;
      this.jdField_a_of_type_Bexw.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.8.6
 * JD-Core Version:    0.7.0.1
 */