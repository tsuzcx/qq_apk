package me.ele.uetool.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.util.JarResource;

public class AttrsDialog$Adapter$SwitchViewHolder
  extends AttrsDialog.Adapter.BaseViewHolder<SwitchItem>
{
  private TextView vName;
  private Switch vSwitch;
  
  public AttrsDialog$Adapter$SwitchViewHolder(View paramView, AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
  {
    super(paramView);
    this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
    this.vSwitch = ((Switch)paramView.findViewById(JarResource.getIdByName("id", "switch_view")));
    this.vSwitch.setOnCheckedChangeListener(new AttrsDialog.Adapter.SwitchViewHolder.1(this, paramView, paramAttrDialogCallback));
  }
  
  public static SwitchViewHolder newInstance(ViewGroup paramViewGroup, AttrsDialog.AttrDialogCallback paramAttrDialogCallback)
  {
    return new SwitchViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_switch"), paramViewGroup, false), paramAttrDialogCallback);
  }
  
  public void bindView(SwitchItem paramSwitchItem)
  {
    super.bindView(paramSwitchItem);
    this.vName.setText(paramSwitchItem.getName());
    this.vSwitch.setChecked(paramSwitchItem.isChecked());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.SwitchViewHolder
 * JD-Core Version:    0.7.0.1
 */