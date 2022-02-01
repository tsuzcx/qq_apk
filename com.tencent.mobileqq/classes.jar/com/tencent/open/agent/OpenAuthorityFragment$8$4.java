package com.tencent.open.agent;

import abcw;
import android.graphics.Bitmap;
import android.os.Message;
import aukw;
import bimq;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class OpenAuthorityFragment$8$4
  implements Runnable
{
  public OpenAuthorityFragment$8$4(bimq parambimq, abcw paramabcw) {}
  
  public void run()
  {
    aukw.a("KEY_GET_APP_ICON");
    Bitmap localBitmap = OpenAuthorityFragment.a(this.jdField_a_of_type_Abcw.a.get());
    aukw.a("KEY_GET_APP_ICON", OpenAuthorityFragment.a(this.jdField_a_of_type_Bimq.a));
    OpenAuthorityFragment.a(this.jdField_a_of_type_Bimq.a).a(OpenAuthorityFragment.a(this.jdField_a_of_type_Bimq.a), localBitmap);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_Bimq.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.8.4
 * JD-Core Version:    0.7.0.1
 */