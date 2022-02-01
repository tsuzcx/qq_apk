package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler.EditorResultReceiver;
import java.lang.ref.WeakReference;

class BridgeModule$MyEditorResultReceiver
  extends WebCommentEditorHandler.EditorResultReceiver
{
  private final WeakReference<BridgeModule> a;
  
  BridgeModule$MyEditorResultReceiver(BridgeModule paramBridgeModule)
  {
    this.a = new WeakReference(paramBridgeModule);
  }
  
  public void a(String paramString, Object paramObject)
  {
    BridgeModule localBridgeModule = (BridgeModule)this.a.get();
    if (localBridgeModule == null) {
      return;
    }
    localBridgeModule.invokeCallJS(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.MyEditorResultReceiver
 * JD-Core Version:    0.7.0.1
 */