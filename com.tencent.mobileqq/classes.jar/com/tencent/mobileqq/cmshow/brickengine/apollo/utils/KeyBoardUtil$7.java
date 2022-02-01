package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;

final class KeyBoardUtil$7
  implements Runnable
{
  KeyBoardUtil$7(ApolloRender paramApolloRender, View paramView, int paramInt) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender;
    if ((localApolloRender != null) && (localApolloRender.mEditWindow != null))
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView.getRootView(), 0, 0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditWindow.update(0, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditWindow.getWidth(), this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditWindow.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.7
 * JD-Core Version:    0.7.0.1
 */