package com.tencent.mobileqq.profilecard.vas.view;

import anmw;
import azfe;
import bgks;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class VasProfileQVipV5View$1
  implements Runnable
{
  VasProfileQVipV5View$1(VasProfileQVipV5View paramVasProfileQVipV5View, azfe paramazfe, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((anmw)VasProfileQVipV5View.a(this.this$0).getManager(51)).a(this.jdField_a_of_type_Azfe.a.a);
    VasProfileQVipV5View.1.1 local1 = new VasProfileQVipV5View.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (bgks.b(localExtensionInfo.pendantId)))
    {
      VasProfileQVipV5View.d(this.this$0).addObserver(VasProfileQVipV5View.a(this.this$0));
      bgks.a(VasProfileQVipV5View.e(this.this$0), this.jdField_a_of_type_Azfe.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View.1
 * JD-Core Version:    0.7.0.1
 */