package com.tencent.viola.core;

import com.tencent.viola.ui.context.RenderActionContextImpl;
import java.util.WeakHashMap;

class ViolaRenderManager$1
  implements Runnable
{
  ViolaRenderManager$1(ViolaRenderManager paramViolaRenderManager, String paramString) {}
  
  public void run()
  {
    if (ViolaRenderManager.access$000(this.this$0) != null)
    {
      RenderActionContextImpl localRenderActionContextImpl = (RenderActionContextImpl)ViolaRenderManager.access$000(this.this$0).get(this.val$instanceId);
      if (localRenderActionContextImpl != null) {
        localRenderActionContextImpl.destroy();
      }
      ViolaRenderManager.access$000(this.this$0).remove(this.val$instanceId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.core.ViolaRenderManager.1
 * JD-Core Version:    0.7.0.1
 */