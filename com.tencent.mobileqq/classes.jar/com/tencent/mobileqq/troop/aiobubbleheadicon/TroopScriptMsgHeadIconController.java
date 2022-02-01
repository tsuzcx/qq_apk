package com.tencent.mobileqq.troop.aiobubbleheadicon;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;

public class TroopScriptMsgHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  public boolean a()
  {
    return TroopBindPublicAccountMgr.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  protected void b()
  {
    b(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840425));
  }
  
  protected void c()
  {
    a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aiobubbleheadicon.TroopScriptMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */