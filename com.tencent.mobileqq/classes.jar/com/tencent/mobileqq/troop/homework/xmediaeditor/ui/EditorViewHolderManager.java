package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo;

public class EditorViewHolderManager
{
  private SparseArray a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    EditItemBase localEditItemBase = a(paramInt);
    if (localEditItemBase != null) {
      return localEditItemBase.a(paramViewGroup);
    }
    return null;
  }
  
  public EditItemBase a(int paramInt)
  {
    return (EditItemBase)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((EditItemBase)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (EditorViewHolderManager.EditViewHolderBase)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      EditItemBase localEditItemBase = a(paramViewHolder.a.b());
      if (localEditItemBase != null) {
        localEditItemBase.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, EditItemInfoBase paramEditItemInfoBase, int paramInt)
  {
    EditItemBase localEditItemBase = a(paramEditItemInfoBase.b());
    if (localEditItemBase != null)
    {
      ((EditorViewHolderManager.EditViewHolderBase)paramViewHolder).a = paramEditItemInfoBase;
      localEditItemBase.a(paramViewHolder, paramEditItemInfoBase, paramInt);
    }
  }
  
  public void a(SparseArray paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(EditItemInfoBase paramEditItemInfoBase)
  {
    EditItemBase localEditItemBase = a(paramEditItemInfoBase.b());
    if (localEditItemBase != null) {
      localEditItemBase.b(paramEditItemInfoBase);
    }
  }
  
  public void a(UploadEditItemInfo paramUploadEditItemInfo)
  {
    EditItemBase localEditItemBase = a(paramUploadEditItemInfo.b());
    if ((localEditItemBase != null) && ((localEditItemBase instanceof UploadEditItem))) {
      ((UploadEditItem)localEditItemBase).a(paramUploadEditItemInfo);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (EditorViewHolderManager.EditViewHolderBase)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      EditItemBase localEditItemBase = a(paramViewHolder.a.b());
      if (localEditItemBase != null) {
        localEditItemBase.b(paramViewHolder);
      }
    }
  }
  
  public void b(EditItemInfoBase paramEditItemInfoBase)
  {
    EditItemBase localEditItemBase = a(paramEditItemInfoBase.b());
    if (localEditItemBase != null) {
      localEditItemBase.c(paramEditItemInfoBase);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (EditorViewHolderManager.EditViewHolderBase)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      EditItemBase localEditItemBase = a(paramViewHolder.a.b());
      if (localEditItemBase != null) {
        localEditItemBase.c(paramViewHolder);
      }
    }
  }
  
  public void c(EditItemInfoBase paramEditItemInfoBase)
  {
    EditItemBase localEditItemBase = a(paramEditItemInfoBase.b());
    if (localEditItemBase != null) {
      localEditItemBase.d(paramEditItemInfoBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager
 * JD-Core Version:    0.7.0.1
 */