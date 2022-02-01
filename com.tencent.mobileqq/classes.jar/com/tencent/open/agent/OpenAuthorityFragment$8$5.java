package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Message;
import aukw;
import bimq;
import cooperation.qqfav.util.HandlerPlus;

public class OpenAuthorityFragment$8$5
  implements Runnable
{
  public OpenAuthorityFragment$8$5(bimq parambimq, String paramString) {}
  
  public void run()
  {
    aukw.a("KEY_GET_APP_ADS_PIC");
    Bitmap localBitmap = OpenAuthorityFragment.a(this.jdField_a_of_type_JavaLangString);
    aukw.a("KEY_GET_APP_ADS_PIC", OpenAuthorityFragment.a(this.jdField_a_of_type_Bimq.a));
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 9;
      this.jdField_a_of_type_Bimq.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.8.5
 * JD-Core Version:    0.7.0.1
 */