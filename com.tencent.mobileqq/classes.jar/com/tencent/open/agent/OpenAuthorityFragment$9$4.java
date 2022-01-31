package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Message;
import apmt;
import bbxq;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;
import xdy;

public class OpenAuthorityFragment$9$4
  implements Runnable
{
  public OpenAuthorityFragment$9$4(bbxq parambbxq, xdy paramxdy) {}
  
  public void run()
  {
    apmt.a("KEY_GET_APP_ICON");
    Bitmap localBitmap = OpenAuthorityFragment.a(this.jdField_a_of_type_Xdy.a.get());
    apmt.a("KEY_GET_APP_ICON", this.jdField_a_of_type_Bbxq.a.jdField_a_of_type_Bciz);
    this.jdField_a_of_type_Bbxq.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(OpenAuthorityFragment.a(this.jdField_a_of_type_Bbxq.a), localBitmap);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_Bbxq.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.9.4
 * JD-Core Version:    0.7.0.1
 */