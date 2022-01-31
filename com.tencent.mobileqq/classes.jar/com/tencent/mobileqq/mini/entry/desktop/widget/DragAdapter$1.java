package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.os.Handler;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class DragAdapter$1
  implements MiniAppCmdInterface
{
  DragAdapter$1(DragAdapter paramDragAdapter) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    DragAdapter.access$500(this.this$0).post(new DragAdapter.1.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.1
 * JD-Core Version:    0.7.0.1
 */