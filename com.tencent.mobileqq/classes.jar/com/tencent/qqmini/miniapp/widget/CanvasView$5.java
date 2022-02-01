package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.json.JSONArray;
import org.json.JSONObject;

class CanvasView$5
  implements CanvasView.DrawAction
{
  CanvasView$5(CanvasView paramCanvasView) {}
  
  public void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray)
  {
    float f = this.this$0.mpx2px(paramJSONArray.optDouble(0, 0.0D));
    CanvasView.access$1100(this.this$0).setTextSize(f);
    CanvasView.access$1200(this.this$0).setTextSize(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.5
 * JD-Core Version:    0.7.0.1
 */