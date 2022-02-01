package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import org.json.JSONArray;
import org.json.JSONObject;

class CanvasView$8
  implements CanvasView.DrawAction
{
  CanvasView$8(CanvasView paramCanvasView) {}
  
  public void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray)
  {
    int j = 0;
    paramCanvas = paramJSONArray.optString(0);
    paramJSONObject = CanvasView.access$1100(this.this$0).getTypeface();
    if (paramJSONObject != null) {
      i = paramJSONObject.getStyle();
    } else {
      i = 0;
    }
    CanvasView.access$1100(this.this$0).setTypeface(Typeface.create(paramCanvas, i));
    paramCanvas = CanvasView.access$1200(this.this$0).getTypeface();
    int i = j;
    if (paramCanvas != null) {
      i = paramCanvas.getStyle();
    }
    CanvasView.access$1200(this.this$0).setTypeface(Typeface.create(paramCanvas, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.8
 * JD-Core Version:    0.7.0.1
 */