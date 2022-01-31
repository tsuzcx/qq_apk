package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Message;
import aqgj;
import bdcf;
import cooperation.qqfav.util.HandlerPlus;

public class OpenAuthorityFragment$9$5
  implements Runnable
{
  public OpenAuthorityFragment$9$5(bdcf parambdcf, String paramString) {}
  
  public void run()
  {
    aqgj.a("KEY_GET_APP_ADS_PIC");
    Bitmap localBitmap = OpenAuthorityFragment.a(this.jdField_a_of_type_JavaLangString);
    aqgj.a("KEY_GET_APP_ADS_PIC", this.jdField_a_of_type_Bdcf.a.jdField_a_of_type_Bdnp);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 9;
      this.jdField_a_of_type_Bdcf.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.9.5
 * JD-Core Version:    0.7.0.1
 */