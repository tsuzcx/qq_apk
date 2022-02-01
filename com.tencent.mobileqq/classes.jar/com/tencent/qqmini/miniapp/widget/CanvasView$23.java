package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.json.JSONArray;
import org.json.JSONObject;

class CanvasView$23
  implements CanvasView.DrawAction
{
  CanvasView$23(CanvasView paramCanvasView) {}
  
  public void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray)
  {
    float f = this.this$0.mpx2px(paramJSONArray.optDouble(0, 0.0D));
    CanvasView.access$1100(this.this$0).setStrokeMiter(f);
    CanvasView.access$1200(this.this$0).setStrokeMiter(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.23
 * JD-Core Version:    0.7.0.1
 */