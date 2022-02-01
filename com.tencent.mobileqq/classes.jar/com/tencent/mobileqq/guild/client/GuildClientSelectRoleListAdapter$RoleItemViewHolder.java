package com.tencent.mobileqq.guild.client;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class GuildClientSelectRoleListAdapter$RoleItemViewHolder
  extends RecyclerView.ViewHolder
{
  private final TextView a;
  private final TextView b;
  private final CheckBox c;
  
  public GuildClientSelectRoleListAdapter$RoleItemViewHolder(View paramView)
  {
    super(paramView);
    paramView.setOnClickListener(new GuildClientSelectRoleListAdapter.RoleItemViewHolder.1(this));
    this.a = ((TextView)paramView.findViewById(2131445119));
    this.b = ((TextView)paramView.findViewById(2131445113));
    this.c = ((CheckBox)paramView.findViewById(2131430681));
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.itemView.setBackgroundResource(2130840858);
      return;
    }
    this.itemView.setBackgroundResource(2130840853);
  }
  
  public void a(GuildClientRoleInfo.RoleInfo paramRoleInfo, int paramInt1, int paramInt2)
  {
    a(paramInt1);
    this.a.setText(paramRoleInfo.b());
    this.b.setText(paramRoleInfo.c());
    this.c.setTag(Integer.valueOf(paramInt1));
    if (paramInt2 == paramInt1)
    {
      this.c.setChecked(true);
      this.c.setVisibility(0);
      return;
    }
    this.c.setChecked(false);
    this.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientSelectRoleListAdapter.RoleItemViewHolder
 * JD-Core Version:    0.7.0.1
 */