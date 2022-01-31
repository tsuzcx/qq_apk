package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;

public abstract class EditItemBase
  implements View.OnClickListener
{
  public XMediaEditor a;
  public EditItemBase.OnEditItemListener a;
  
  public EditItemBase(XMediaEditor paramXMediaEditor)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = paramXMediaEditor;
  }
  
  public abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup);
  
  public EditItemBase.OnEditItemListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener;
  }
  
  public EditItemBase a(EditItemBase.OnEditItemListener paramOnEditItemListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener = paramOnEditItemListener;
    return this;
  }
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder) {}
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, EditItemInfoBase paramEditItemInfoBase, int paramInt);
  
  public abstract void a(View paramView, RecyclerView.ViewHolder paramViewHolder);
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(View paramView, RecyclerView.ViewHolder paramViewHolder)
  {
    paramView.setTag(paramViewHolder);
    paramView.setOnClickListener(this);
  }
  
  public void b(EditItemInfoBase paramEditItemInfoBase) {}
  
  public void c(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void c(EditItemInfoBase paramEditItemInfoBase) {}
  
  public void d(EditItemInfoBase paramEditItemInfoBase) {}
  
  public void onClick(View paramView)
  {
    a(paramView, (RecyclerView.ViewHolder)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditItemBase
 * JD-Core Version:    0.7.0.1
 */