package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

final class KeyBoardUtil$8
  implements View.OnClickListener
{
  KeyBoardUtil$8(ApolloRender paramApolloRender, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorPop != null) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView != null))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorPop.getText().toString();
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorPop.setText("");
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.runRenderTask(new KeyBoardUtil.8.1(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.8
 * JD-Core Version:    0.7.0.1
 */