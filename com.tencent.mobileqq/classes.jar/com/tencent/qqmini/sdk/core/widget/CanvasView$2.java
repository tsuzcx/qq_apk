package com.tencent.qqmini.sdk.core.widget;

import bglb;
import org.json.JSONObject;

class CanvasView$2
  implements Runnable
{
  public void run()
  {
    this.a.optInt("x");
    this.a.optInt("y");
    this.a.optInt("width");
    this.a.optInt("height");
    CanvasView.a(bglb.a(this.a.optJSONArray("__nativeBuffers__")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CanvasView.2
 * JD-Core Version:    0.7.0.1
 */