package com.tencent.qqmini.miniapp.widget;

import android.graphics.Canvas;
import org.json.JSONArray;
import org.json.JSONObject;

abstract interface CanvasView$DrawAction
{
  public abstract void doAction(Canvas paramCanvas, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.DrawAction
 * JD-Core Version:    0.7.0.1
 */