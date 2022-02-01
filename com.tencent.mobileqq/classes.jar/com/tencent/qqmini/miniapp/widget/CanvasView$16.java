package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import org.json.JSONArray;
import org.json.JSONObject;

class CanvasView$16
  implements CanvasView.DrawAction
{
  CanvasView$16(CanvasView paramCanvasView) {}
  
  public void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray)
  {
    paramCanvas.scale((float)paramJSONArray.optDouble(0, 1.0D), (float)paramJSONArray.optDouble(1, 1.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.16
 * JD-Core Version:    0.7.0.1
 */