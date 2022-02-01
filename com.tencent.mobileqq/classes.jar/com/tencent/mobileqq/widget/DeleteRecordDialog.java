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
import com.tencent.mobileqq.simpleui.SimpleUIFixHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.app.AppRuntime;

public class DeleteRecordDialog
  extends ReportDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private AppRuntime a;
  private Context b;
  private boolean c;
  private TextView d;
  private TextView e;
  private CheckBox f;
  private TextView g;
  private TextView h;
  private DeleteRecordDialog.OnDeleteRecordDialogClickListener i;
  
  public DeleteRecordDialog(Context paramContext, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    super(paramContext, 2131953338);
    this.b = paramContext;
    this.a = paramAppRuntime;
    this.c = paramBoolean;
    b();
  }
  
  private void b()
  {
    setContentView(2131629184);
    SimpleUIFixHelper.a(this);
    SimpleUIFixHelper.b(this);
    this.d = ((TextView)findViewById(2131431880));
    this.e = ((TextView)findViewById(2131431876));
    this.f = ((CheckBox)findViewById(2131430666));
    this.g = ((TextView)findViewById(2131431864));
    this.h = ((TextView)findViewById(2131431870));
    Object localObject = this.d;
    if (localObject != null) {
      ((TextView)localObject).setText(HardCodeUtil.a(2131901251));
    }
    localObject = this.e;
    if (localObject != null) {
      ((TextView)localObject).setText(HardCodeUtil.a(2131901250));
    }
    localObject = this.f;
    if (localObject != null) {
      if (this.c)
      {
        ((CheckBox)localObject).setVisibility(0);
        this.f.setText(HardCodeUtil.a(2131901252));
        this.f.setChecked(a(this.b, this.a.getCurrentUin()));
        this.f.setOnCheckedChangeListener(this);
      }
      else
      {
        ((CheckBox)localObject).setVisibility(8);
        this.f.setChecked(false);
      }
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131887648);
      this.g.setOnClickListener(this);
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131892267);
      this.h.setOnClickListener(this);
    }
    setCancelable(true);
    setCanceledOnTouchOutside(true);
  }
  
  public void a(int paramInt)
  {
    super.show();
    ReportController.b(this.a, "dc00898", "", "", "0X800A363", "0X800A363", paramInt, 0, "1", "", "", "");
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
    this.i = paramOnDeleteRecordDialogClickListener;
  }
  
  @Deprecated
  public void a(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public boolean a()
  {
    CheckBox localCheckBox = this.f;
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
    this.e.setText(paramString);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int j;
    if (this.c)
    {
      if (this.f.isChecked()) {
        j = 1;
      } else {
        j = 2;
      }
    }
    else {
      j = 3;
    }
    int k = paramView.getId();
    if (k == 2131431864)
    {
      dismiss();
      ReportController.b(this.a, "dc00898", "", "", "0X800A365", "0X800A365", j, 0, "1", "", "", "");
    }
    else if (k == 2131431870)
    {
      DeleteRecordDialog.OnDeleteRecordDialogClickListener localOnDeleteRecordDialogClickListener = this.i;
      if (localOnDeleteRecordDialogClickListener != null)
      {
        localOnDeleteRecordDialogClickListener.a(this, paramView, a());
        if (this.c) {
          a(this.b, this.a.getCurrentUin(), this.f.isChecked());
        }
        dismiss();
      }
      ReportController.b(this.a, "dc00898", "", "", "0X800A364", "0X800A364", j, 0, "1", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DeleteRecordDialog
 * JD-Core Version:    0.7.0.1
 */