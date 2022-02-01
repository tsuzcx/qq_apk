package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.text.Editable;
import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

class KeyBoardUtil$9$1
  extends IApolloRunnableTask
{
  KeyBoardUtil$9$1(KeyBoardUtil.9 param9, Editable paramEditable) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getRender();
    if ((localApolloRender != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorAddr != 0L)) {
      localApolloRender.getSavaWrapper().editorTextChangeCallBack(this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRender.mEditorAddr, this.a.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.9.1
 * JD-Core Version:    0.7.0.1
 */