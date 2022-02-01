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
    ApolloRender localApolloRender = this.a;
    if ((localApolloRender != null) && (localApolloRender.mEditWindow != null))
    {
      if (this.b == null) {
        return;
      }
      this.a.mEditWindow.showAtLocation(this.b.getRootView(), 0, 0, this.c);
      this.a.mEditWindow.update(0, this.c, this.a.mEditWindow.getWidth(), this.a.mEditWindow.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.7
 * JD-Core Version:    0.7.0.1
 */