package com.tencent.mobileqq.utils;

import alto;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;

final class VipUtils$3
  implements Runnable
{
  VipUtils$3(alto paramalto, String paramString, VipUtils.UpdateRecentEfficientVipIconTask paramUpdateRecentEfficientVipIconTask) {}
  
  public void run()
  {
    this.jdField_a_of_type_Alto.e(this.jdField_a_of_type_JavaLangString);
    ThreadManagerV2.getUIHandlerV2().post(this.jdField_a_of_type_ComTencentMobileqqUtilsVipUtils$UpdateRecentEfficientVipIconTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.3
 * JD-Core Version:    0.7.0.1
 */