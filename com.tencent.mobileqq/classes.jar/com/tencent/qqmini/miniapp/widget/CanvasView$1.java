package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONObject;

class CanvasView$1
  implements Runnable
{
  CanvasView$1(CanvasView paramCanvasView, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Bitmap localBitmap = CanvasView.access$000(this.this$0, this.this$0, true);
    ThreadManager.getSubThreadHandler().post(new CanvasView.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.1
 * JD-Core Version:    0.7.0.1
 */