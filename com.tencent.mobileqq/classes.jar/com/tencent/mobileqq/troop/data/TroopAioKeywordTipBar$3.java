package com.tencent.mobileqq.troop.data;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopAioKeywordTipBar$3
  implements Animation.AnimationListener
{
  TroopAioKeywordTipBar$3(TroopAioKeywordTipBar paramTroopAioKeywordTipBar, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (TroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar) != null)
    {
      TroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar).a.clearAnimation();
      TroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar).a.setVisibility(8);
    }
    TroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar, false);
    TroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar, null);
    TroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar, null);
    TroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!TroopAioKeywordTipBar.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar)))
    {
      ThreadManager.getUIHandler().post(TroopAioKeywordTipBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar));
      TroopAioKeywordTipBar.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipBar, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.3
 * JD-Core Version:    0.7.0.1
 */