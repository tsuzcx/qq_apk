package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.app.AppRuntime;

public class DeleteRecordDialog
  extends ReportDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DeleteRecordDialog.OnDeleteRecordDialogClickListener jdField_a_of_type_ComTencentMobileqqWidgetDeleteRecordDialog$OnDeleteRecordDialogClickListener;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public DeleteRecordDialog(Context paramContext, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    super(paramContext, 2131756189);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  private void a()
  {
    setContentView(2131562747);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365648));
    this.b = ((TextView)findViewById(2131365644));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364597));
    this.c = ((TextView)findViewById(2131365633));
    this.d = ((TextView)findViewById(2131365639));
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(HardCodeUtil.a(2131703290));
    }
    localObject = this.b;
    if (localObject != null) {
      ((TextView)localObject).setText(HardCodeUtil.a(2131703289));
    }
    localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (localObject != null) {
      if (this.jdField_a_of_type_Boolean)
      {
        ((CheckBox)localObject).setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setText(HardCodeUtil.a(2131703291));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin()));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      }
      else
      {
        ((CheckBox)localObject).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131690728);
      this.c.setOnClickListener(this);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131694583);
      this.d.setOnClickListener(this);
    }
    setCancelable(true);
    setCanceledOnTouchOutside(true);
  }
  
  public void a(int paramInt)
  {
    super.show();
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A363", "0X800A363", paramInt, 0, "1", "", "", "");
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("record_delete_roaming_setting_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public void a(DeleteRecordDialog.OnDeleteRecordDialogClickListener paramOnDeleteRecordDialogClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDeleteRecordDialog$OnDeleteRecordDialogClickListener = paramOnDeleteRecordDialogClickListener;
  }
  
  @Deprecated
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public boolean a()
  {
    CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (localCheckBox != null) {
      return localCheckBox.isChecked();
    }
    return false;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("record_delete_roaming_setting_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public void b(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        i = 1;
      } else {
        i = 2;
      }
    }
    else {
      i = 3;
    }
    int j = paramView.getId();
    if (j == 2131365633)
    {
      dismiss();
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A365", "0X800A365", i, 0, "1", "", "", "");
    }
    else if (j == 2131365639)
    {
      DeleteRecordDialog.OnDeleteRecordDialogClickListener localOnDeleteRecordDialogClickListener = this.jdField_a_of_type_ComTencentMobileqqWidgetDeleteRecordDialog$OnDeleteRecordDialogClickListener;
      if (localOnDeleteRecordDialogClickListener != null)
      {
        localOnDeleteRecordDialogClickListener.a(this, paramView, a());
        if (this.jdField_a_of_type_Boolean) {
          a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
        }
        dismiss();
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A364", "0X800A364", i, 0, "1", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DeleteRecordDialog
 * JD-Core Version:    0.7.0.1
 */