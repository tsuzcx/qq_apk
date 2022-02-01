package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;

public abstract class UploadEditItem<VH extends RecyclerView.ViewHolder, D extends EditItemInfoBase>
  extends EditItemBase<VH, D>
{
  public UploadEditItem(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public abstract void a(D paramD);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.UploadEditItem
 * JD-Core Version:    0.7.0.1
 */