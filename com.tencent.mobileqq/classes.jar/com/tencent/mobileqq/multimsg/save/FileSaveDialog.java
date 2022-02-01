package com.tencent.mobileqq.multimsg.save;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class FileSaveDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new FileSaveDialog.1(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public FileSaveDialog.IFileSaveCancelInterface a;
  private FileSaveProgressView jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView;
  
  public FileSaveDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755192);
    a(paramContext);
  }
  
  private void a()
  {
    setCanceledOnTouchOutside(false);
    setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void a(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559241, null);
    setContentView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView = ((FileSaveProgressView)paramContext.findViewById(2131377446));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131364357));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a();
  }
  
  private void b()
  {
    if (isShowing()) {
      if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog$IFileSaveCancelInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog$IFileSaveCancelInterface.a();
      }
    }
    try
    {
      super.cancel();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveDialog", 2, "cancel dialog exception: " + localThrowable.getMessage());
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveProgressView.setProgress(paramInt);
    }
  }
  
  public void a(FileSaveDialog.IFileSaveCancelInterface paramIFileSaveCancelInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog$IFileSaveCancelInterface = paramIFileSaveCancelInterface;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
    }
  }
  
  public void show()
  {
    if (!isShowing()) {}
    try
    {
      super.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveDialog", 2, "show dialog exception: " + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveDialog
 * JD-Core Version:    0.7.0.1
 */