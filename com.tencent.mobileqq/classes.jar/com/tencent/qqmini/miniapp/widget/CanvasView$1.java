package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONObject;

class CanvasView$1
  implements Runnable
{
  CanvasView$1(CanvasView paramCanvasView, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = CanvasView.access$000((CanvasView)localObject, (View)localObject, true);
    ThreadManager.getSubThreadHandler().post(new CanvasView.1.1(this, (Bitmap)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.1
 * JD-Core Version:    0.7.0.1
 */