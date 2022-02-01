package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.json.JSONArray;
import org.json.JSONObject;

class CanvasView$19
  implements CanvasView.DrawAction
{
  CanvasView$19(CanvasView paramCanvasView) {}
  
  public void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray)
  {
    paramCanvas = new CanvasView.ShadowLayer(this.this$0);
    paramJSONObject = paramJSONArray.optJSONArray(3);
    float f1 = this.this$0.mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f2 = this.this$0.mpx2px(paramJSONArray.optDouble(0, 0.0D));
    float f3 = this.this$0.mpx2px(paramJSONArray.optDouble(1, 0.0D));
    paramCanvas.radius = f1;
    paramCanvas.dx = f2;
    paramCanvas.dy = f3;
    paramCanvas.color = CanvasView.access$3600(this.this$0, paramJSONObject);
    CanvasView.access$1100(this.this$0).setShadowLayer(paramCanvas.radius, paramCanvas.dx, paramCanvas.dy, paramCanvas.color);
    CanvasView.access$1200(this.this$0).setShadowLayer(paramCanvas.radius, paramCanvas.dx, paramCanvas.dy, paramCanvas.color);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.19
 * JD-Core Version:    0.7.0.1
 */