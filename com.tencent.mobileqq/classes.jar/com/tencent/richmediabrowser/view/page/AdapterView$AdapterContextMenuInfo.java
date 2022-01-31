package com.tencent.richmediabrowser.view.page;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class AdapterView$AdapterContextMenuInfo
  implements ContextMenu.ContextMenuInfo
{
  public long id;
  public int position;
  public View targetView;
  
  public AdapterView$AdapterContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    this.targetView = paramView;
    this.position = paramInt;
    this.id = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.AdapterView.AdapterContextMenuInfo
 * JD-Core Version:    0.7.0.1
 */