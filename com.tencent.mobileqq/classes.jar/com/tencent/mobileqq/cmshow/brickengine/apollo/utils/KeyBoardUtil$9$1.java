package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.text.Editable;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IApolloRunnableTask;

class KeyBoardUtil$9$1
  extends IApolloRunnableTask
{
  KeyBoardUtil$9$1(KeyBoardUtil.9 param9, Editable paramEditable) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.this$0.a.getRender();
    if ((localApolloRender != null) && (this.this$0.b.mEditorAddr != 0L)) {
      localApolloRender.getSavaWrapper().editorTextChangeCallBack(this.this$0.b.mEditorAddr, this.a.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.9.1
 * JD-Core Version:    0.7.0.1
 */