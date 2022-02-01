package com.tencent.mobileqq.profilecard.vas.view;

import amsw;
import android.widget.ImageView;
import aymg;
import bfua;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class VasProfileQVipDiyView$1
  implements Runnable
{
  VasProfileQVipDiyView$1(VasProfileQVipDiyView paramVasProfileQVipDiyView, aymg paramaymg, ImageView paramImageView, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((amsw)VasProfileQVipDiyView.a(this.this$0).getManager(51)).a(this.jdField_a_of_type_Aymg.a.a);
    VasProfileQVipDiyView.1.1 local1 = new VasProfileQVipDiyView.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bfua.b(localExtensionInfo.pendantId)))
    {
      VasProfileQVipDiyView.c(this.this$0).addObserver(VasProfileQVipDiyView.a(this.this$0));
      bfua.a(VasProfileQVipDiyView.d(this.this$0), this.jdField_a_of_type_Aymg.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.1
 * JD-Core Version:    0.7.0.1
 */