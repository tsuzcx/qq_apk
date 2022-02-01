package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.widget.EditText;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;

final class KeyBoardUtil$5
  implements Runnable
{
  KeyBoardUtil$5(ApolloRender paramApolloRender, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorPop != null) && (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorPop.getText().toString().compareToIgnoreCase(this.jdField_a_of_type_JavaLangString) != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorPop.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorPop.setSelection(this.jdField_a_of_type_JavaLangString.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.5
 * JD-Core Version:    0.7.0.1
 */