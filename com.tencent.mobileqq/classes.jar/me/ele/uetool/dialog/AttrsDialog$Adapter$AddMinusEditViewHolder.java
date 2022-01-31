package me.ele.uetool.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.AddMinusEditItem.CustomAddMin;
import me.ele.uetool.util.JarResource;

public class AttrsDialog$Adapter$AddMinusEditViewHolder
  extends AttrsDialog.Adapter.EditTextViewHolder<AddMinusEditItem>
{
  private AddMinusEditItem.CustomAddMin addMin;
  private View vAdd;
  private View vMinus;
  
  public AttrsDialog$Adapter$AddMinusEditViewHolder(View paramView)
  {
    super(paramView);
    this.vAdd = paramView.findViewById(JarResource.getIdByName("id", "add"));
    this.vMinus = paramView.findViewById(JarResource.getIdByName("id", "minus"));
    this.vAdd.setOnClickListener(new AttrsDialog.Adapter.AddMinusEditViewHolder.1(this));
    this.vMinus.setOnClickListener(new AttrsDialog.Adapter.AddMinusEditViewHolder.2(this));
  }
  
  public static AddMinusEditViewHolder newInstance(ViewGroup paramViewGroup)
  {
    return new AddMinusEditViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_add_minus_edit"), paramViewGroup, false));
  }
  
  public void bindView(AddMinusEditItem paramAddMinusEditItem)
  {
    super.bindView(paramAddMinusEditItem);
  }
  
  public void setAddMin(AddMinusEditItem.CustomAddMin paramCustomAddMin)
  {
    this.addMin = paramCustomAddMin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.AddMinusEditViewHolder
 * JD-Core Version:    0.7.0.1
 */