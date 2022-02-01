package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

public class MsgBackupListAdapter$BackupAndMigrateItemHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public View a;
  public ImageView b;
  public SingleLineTextView c;
  private CheckBox e;
  private MsgBackupListAdapter.OnItemCheckedChangeListener f;
  
  public MsgBackupListAdapter$BackupAndMigrateItemHolder(MsgBackupListAdapter paramMsgBackupListAdapter, View paramView, MsgBackupListAdapter.OnItemCheckedChangeListener paramOnItemCheckedChangeListener)
  {
    super(paramView);
    this.a = paramView;
    this.e = ((CheckBox)paramView.findViewById(2131436122));
    this.e.setButtonDrawable(2130839226);
    this.e.setOnCheckedChangeListener(null);
    this.e.setOnCheckedChangeListener(this);
    this.b = ((ImageView)paramView.findViewById(2131436047));
    this.c = ((SingleLineTextView)paramView.findViewById(2131436136));
    this.c.setTextColor(paramView.getContext().getResources().getColor(2131168001));
    this.f = paramOnItemCheckedChangeListener;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.f != null)
    {
      int i = getAdapterPosition();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BackupAndMigrateItemHolder onCheckedChanged: ");
        localStringBuilder.append(i);
        localStringBuilder.append(", isChecked = ");
        localStringBuilder.append(paramBoolean);
        QLog.i("MsgBackup.BackupAndMigrateListAdapter", 2, localStringBuilder.toString());
      }
      this.e.setChecked(paramBoolean);
      MsgBackupListAdapter.a(this.d).setValueAt(i, Boolean.valueOf(paramBoolean));
      this.f.a(this.e.isChecked(), (RecentBaseData)MsgBackupListAdapter.b(this.d).get(i));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (this.f != null)
    {
      boolean bool = this.e.isChecked();
      this.e.setChecked(bool ^ true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupListAdapter.BackupAndMigrateItemHolder
 * JD-Core Version:    0.7.0.1
 */