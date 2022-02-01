package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.widget.PopupWindow;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;

final class KeyBoardUtil$4
  implements Runnable
{
  KeyBoardUtil$4(ApolloRender paramApolloRender) {}
  
  public void run()
  {
    if (this.a.mShowEditWindow)
    {
      this.a.mEditWindow.dismiss();
      this.a.mShowEditWindow = false;
      KeyBoardUtil.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.4
 * JD-Core Version:    0.7.0.1
 */