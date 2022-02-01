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
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

public class MsgBackupListAdapter$BackupAndMigrateItemHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public View a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private MsgBackupListAdapter.OnItemCheckedChangeListener jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener;
  public RecentDynamicAvatarView a;
  public SingleLineTextView a;
  
  public MsgBackupListAdapter$BackupAndMigrateItemHolder(MsgBackupListAdapter paramMsgBackupListAdapter, View paramView, MsgBackupListAdapter.OnItemCheckedChangeListener paramOnItemCheckedChangeListener)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369423));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130839219);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131369351));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131369435));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(MsgBackupListAdapter.a(paramMsgBackupListAdapter).getResources().getColor(2131167040));
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener = paramOnItemCheckedChangeListener;
    paramMsgBackupListAdapter.a(this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener != null)
    {
      int i = getAdapterPosition();
      if (QLog.isColorLevel()) {
        QLog.i("MsgBackup.BackupAndMigrateListAdapter", 2, "BackupAndMigrateItemHolder onCheckedChanged: " + i + ", isChecked = " + paramBoolean);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      MsgBackupListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter).setValueAt(i, Boolean.valueOf(paramBoolean));
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener.a(this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), (RecentBaseData)MsgBackupListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter).get(i));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox;
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener != null)
    {
      bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (bool) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupListAdapter.BackupAndMigrateItemHolder
 * JD-Core Version:    0.7.0.1
 */