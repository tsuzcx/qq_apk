package com.tencent.qqmini.miniapp.widget;

import org.json.JSONArray;

public class CanvasView$DrawActionCommand
{
  public JSONArray drawAction;
  public boolean reverse;
  public boolean useHardwareAccelerate;
  
  public CanvasView$DrawActionCommand() {}
  
  public CanvasView$DrawActionCommand(boolean paramBoolean1, JSONArray paramJSONArray, boolean paramBoolean2)
  {
    this.reverse = paramBoolean1;
    this.drawAction = paramJSONArray;
    this.useHardwareAccelerate = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.DrawActionCommand
 * JD-Core Version:    0.7.0.1
 */