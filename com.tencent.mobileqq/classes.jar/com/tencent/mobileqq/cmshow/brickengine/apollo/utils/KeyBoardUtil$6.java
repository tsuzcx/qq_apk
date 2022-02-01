package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

final class KeyBoardUtil$6
  implements Runnable
{
  KeyBoardUtil$6(ApolloRender paramApolloRender, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender == null) {
      return;
    }
    int i = (int)(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth() - DeviceInfoUtil.a * 80.0F);
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorPop.setWidth(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.6
 * JD-Core Version:    0.7.0.1
 */