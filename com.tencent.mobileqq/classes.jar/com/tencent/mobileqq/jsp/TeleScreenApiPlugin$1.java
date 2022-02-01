package com.tencent.mobileqq.jsp;

import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.bigbrother.JumpCallback;
import com.tencent.mobileqq.bigbrother.TeleScreen;

class TeleScreenApiPlugin$1
  implements JumpCallback
{
  TeleScreenApiPlugin$1(TeleScreenApiPlugin paramTeleScreenApiPlugin, String paramString) {}
  
  public void onJump(int paramInt1, int paramInt2)
  {
    if (TeleScreenApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspTeleScreenApiPlugin) != null) {
      TeleScreenApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspTeleScreenApiPlugin).remove(Integer.valueOf(paramInt1));
    }
    TeleScreen.a().a(paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqJspTeleScreenApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"openresult\":" + paramInt2 + "}" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TeleScreenApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */