package com.tencent.mobileqq.writetogetherui;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.writetogether.websocket.NetChangedListener;

class WriteTogetherEditorFragment$MyNetInfoHandler
  extends NetChangedListener
{
  private WriteTogetherEditorFragment$MyNetInfoHandler(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  protected void a()
  {
    ThreadManager.getUIHandlerV2().post(new WriteTogetherEditorFragment.MyNetInfoHandler.1(this));
  }
  
  protected void b()
  {
    ThreadManager.getUIHandlerV2().post(new WriteTogetherEditorFragment.MyNetInfoHandler.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.MyNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */