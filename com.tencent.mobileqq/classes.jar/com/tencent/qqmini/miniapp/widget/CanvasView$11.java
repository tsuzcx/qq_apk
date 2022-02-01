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
      CanvasView.access$1102(this.this$0, CanvasView.access$1700(this.this$0));
      CanvasView.access$1202(this.this$0, CanvasView.access$1800(this.this$0));
      CanvasView.access$1602(this.this$0, CanvasView.access$1900(this.this$0));
      CanvasView.access$2002(this.this$0, CanvasView.access$2100(this.this$0));
      CanvasView.access$2202(this.this$0, CanvasView.access$2300(this.this$0));
      CanvasView.access$2402(this.this$0, CanvasView.access$2500(this.this$0));
      CanvasView.access$2602(this.this$0, CanvasView.access$2700(this.this$0));
      CanvasView.access$2802(this.this$0, CanvasView.access$2900(this.this$0));
      CanvasView.access$3002(this.this$0, CanvasView.access$3100(this.this$0));
      CanvasView.access$3202(this.this$0, CanvasView.access$3300(this.this$0));
      return;
    }
    catch (Exception paramCanvas)
    {
      for (;;)
      {
        QMLog.e("CanvasView", "ACTION_RESTORE: " + Log.getStackTraceString(paramCanvas));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.11
 * JD-Core Version:    0.7.0.1
 */