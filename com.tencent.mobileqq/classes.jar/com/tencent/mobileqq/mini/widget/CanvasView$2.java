package com.tencent.mobileqq.mini.widget;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import org.json.JSONObject;

class CanvasView$2
  implements Runnable
{
  CanvasView$2(CanvasView paramCanvasView, boolean paramBoolean, WebviewContainer paramWebviewContainer, String paramString1, int paramInt, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    ThreadManagerV2.executeOnSubThread(new CanvasView.2.1(this, CanvasView.access$000(this.this$0, this.this$0, this.val$isPngFile)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView.2
 * JD-Core Version:    0.7.0.1
 */