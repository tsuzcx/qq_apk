package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

final class KeyBoardUtil$9
  implements TextWatcher
{
  KeyBoardUtil$9(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ApolloSurfaceView localApolloSurfaceView = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView;
    if (localApolloSurfaceView == null) {
      return;
    }
    localApolloSurfaceView.runRenderTask(new KeyBoardUtil.9.1(this, paramEditable));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.9
 * JD-Core Version:    0.7.0.1
 */