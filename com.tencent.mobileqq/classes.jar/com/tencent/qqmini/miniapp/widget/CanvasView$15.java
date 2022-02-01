package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import org.json.JSONArray;
import org.json.JSONObject;

class CanvasView$15
  implements CanvasView.DrawAction
{
  CanvasView$15(CanvasView paramCanvasView) {}
  
  public void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray)
  {
    paramCanvas.rotate((float)(paramJSONArray.optDouble(0, 0.0D) * 180.0D / 3.141592653589793D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.15
 * JD-Core Version:    0.7.0.1
 */