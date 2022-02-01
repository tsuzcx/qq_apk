package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class EditItemBase<VH extends RecyclerView.ViewHolder, D extends EditItemInfoBase>
  implements View.OnClickListener
{
  public XMediaEditor a;
  public EditItemBase.OnEditItemListener a;
  
  public EditItemBase(XMediaEditor paramXMediaEditor)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = paramXMediaEditor;
  }
  
  public abstract VH a(ViewGroup paramViewGroup);
  
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
  
  public void a(VH paramVH) {}
  
  public abstract void a(VH paramVH, D paramD, int paramInt);
  
  public abstract void a(View paramView, VH paramVH);
  
  public void b(VH paramVH) {}
  
  public void b(View paramView, VH paramVH)
  {
    paramView.setTag(paramVH);
    paramView.setOnClickListener(this);
  }
  
  public void b(D paramD) {}
  
  public void c(VH paramVH) {}
  
  public void c(D paramD) {}
  
  public void d(D paramD) {}
  
  public void onClick(View paramView)
  {
    a(paramView, (RecyclerView.ViewHolder)paramView.getTag());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditItemBase
 * JD-Core Version:    0.7.0.1
 */