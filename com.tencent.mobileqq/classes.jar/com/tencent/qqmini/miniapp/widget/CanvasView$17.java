package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import org.json.JSONArray;
import org.json.JSONObject;

class CanvasView$17
  implements CanvasView.DrawAction
{
  CanvasView$17(CanvasView paramCanvasView) {}
  
  public void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray)
  {
    paramCanvas.translate(this.this$0.mpx2px(paramJSONArray.optDouble(0, 0.0D)), this.this$0.mpx2px(paramJSONArray.optDouble(1, 0.0D)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.17
 * JD-Core Version:    0.7.0.1
 */