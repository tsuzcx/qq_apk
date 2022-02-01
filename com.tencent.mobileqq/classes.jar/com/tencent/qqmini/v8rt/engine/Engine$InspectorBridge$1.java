package com.tencent.qqmini.v8rt.engine;

import com.tencent.qqmini.v8rt.anno.NotNull;

class Engine$InspectorBridge$1
  implements IInspectorAgent.IDebuggerMessageListener
{
  Engine$InspectorBridge$1(Engine.InspectorBridge paramInspectorBridge) {}
  
  public void sendMessageToEngine(@NotNull String paramString)
  {
    Engine.InspectorBridge.access$200(Engine.InspectorBridge.access$100(this.this$0), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.Engine.InspectorBridge.1
 * JD-Core Version:    0.7.0.1
 */