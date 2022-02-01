package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import org.json.JSONArray;
import org.json.JSONObject;

class CanvasView$25
  implements CanvasView.DrawAction
{
  CanvasView$25(CanvasView paramCanvasView) {}
  
  public void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONObject.optJSONObject("data");
    int i = paramJSONObject.optInt("callbackId");
    CanvasView.access$4000(this.this$0, paramCanvas, paramString, paramJSONArray, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.25
 * JD-Core Version:    0.7.0.1
 */