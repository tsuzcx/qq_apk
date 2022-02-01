package me.ele.uetool.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.util.JarResource;

public class MultipleAttrsDialog$Adapter$SwitchViewHolder
  extends MultipleAttrsDialog.Adapter.BaseViewHolder<SwitchItem>
{
  private MultipleAttrsDialog.ValidCallBack callBack;
  private TextView vName;
  private Switch vSwitch;
  
  public MultipleAttrsDialog$Adapter$SwitchViewHolder(View paramView)
  {
    super(paramView);
    this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
    this.vSwitch = ((Switch)paramView.findViewById(JarResource.getIdByName("id", "switch_view")));
    this.vSwitch.setOnCheckedChangeListener(new MultipleAttrsDialog.Adapter.SwitchViewHolder.1(this, paramView));
  }
  
  public static SwitchViewHolder newInstance(ViewGroup paramViewGroup)
  {
    return new SwitchViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_switch"), paramViewGroup, false));
  }
  
  public void bindView(SwitchItem paramSwitchItem)
  {
    super.bindView(paramSwitchItem);
    this.vName.setText(paramSwitchItem.getName());
    this.vSwitch.setChecked(paramSwitchItem.isChecked());
  }
  
  public void setCallBack(MultipleAttrsDialog.ValidCallBack paramValidCallBack)
  {
    this.callBack = paramValidCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.SwitchViewHolder
 * JD-Core Version:    0.7.0.1
 */