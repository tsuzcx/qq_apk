package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONObject;

class CanvasView$11
  implements CanvasView.DrawAction
{
  CanvasView$11(CanvasView paramCanvasView) {}
  
  public void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray)
  {
    try
    {
      paramCanvas.restore();
    }
    catch (Exception paramCanvas)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("ACTION_RESTORE: ");
      paramJSONObject.append(Log.getStackTraceString(paramCanvas));
      QMLog.e("CanvasView", paramJSONObject.toString());
    }
    paramCanvas = this.this$0;
    CanvasView.access$1102(paramCanvas, CanvasView.access$1700(paramCanvas));
    paramCanvas = this.this$0;
    CanvasView.access$1202(paramCanvas, CanvasView.access$1800(paramCanvas));
    paramCanvas = this.this$0;
    CanvasView.access$1602(paramCanvas, CanvasView.access$1900(paramCanvas));
    paramCanvas = this.this$0;
    CanvasView.access$2002(paramCanvas, CanvasView.access$2100(paramCanvas));
    paramCanvas = this.this$0;
    CanvasView.access$2202(paramCanvas, CanvasView.access$2300(paramCanvas));
    paramCanvas = this.this$0;
    CanvasView.access$2402(paramCanvas, CanvasView.access$2500(paramCanvas));
    paramCanvas = this.this$0;
    CanvasView.access$2602(paramCanvas, CanvasView.access$2700(paramCanvas));
    paramCanvas = this.this$0;
    CanvasView.access$2802(paramCanvas, CanvasView.access$2900(paramCanvas));
    paramCanvas = this.this$0;
    CanvasView.access$3002(paramCanvas, CanvasView.access$3100(paramCanvas));
    paramCanvas = this.this$0;
    CanvasView.access$3202(paramCanvas, CanvasView.access$3300(paramCanvas));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.11
 * JD-Core Version:    0.7.0.1
 */