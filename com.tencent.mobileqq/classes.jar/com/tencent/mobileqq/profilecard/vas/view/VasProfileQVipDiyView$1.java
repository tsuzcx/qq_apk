package com.tencent.mobileqq.profilecard.vas.view;

import android.widget.ImageView;
import anvk;
import azrb;
import bhcs;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class VasProfileQVipDiyView$1
  implements Runnable
{
  VasProfileQVipDiyView$1(VasProfileQVipDiyView paramVasProfileQVipDiyView, azrb paramazrb, ImageView paramImageView, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((anvk)VasProfileQVipDiyView.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_Azrb.a.a);
    VasProfileQVipDiyView.1.1 local1 = new VasProfileQVipDiyView.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bhcs.b(localExtensionInfo.pendantId)))
    {
      VasProfileQVipDiyView.c(this.this$0).addObserver(VasProfileQVipDiyView.a(this.this$0));
      bhcs.a(VasProfileQVipDiyView.d(this.this$0), this.jdField_a_of_type_Azrb.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.1
 * JD-Core Version:    0.7.0.1
 */