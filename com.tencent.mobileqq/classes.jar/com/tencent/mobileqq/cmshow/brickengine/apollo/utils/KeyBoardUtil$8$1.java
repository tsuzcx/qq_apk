package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IApolloRunnableTask;

class KeyBoardUtil$8$1
  extends IApolloRunnableTask
{
  KeyBoardUtil$8$1(KeyBoardUtil.8 param8, String paramString) {}
  
  public void run()
  {
    if (this.this$0.b.getRender() != null) {
      this.this$0.b.getRender().getSavaWrapper().editorOnClickCallBack(this.this$0.a.mEditorAddr, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.8.1
 * JD-Core Version:    0.7.0.1
 */