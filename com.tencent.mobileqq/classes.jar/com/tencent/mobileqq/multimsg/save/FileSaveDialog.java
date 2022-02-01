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
  public FileSaveDialog.IFileSaveCancelInterface a;
  private FileSaveProgressView b;
  private TextView c;
  private DialogInterface.OnKeyListener d = new FileSaveDialog.1(this);
  
  public FileSaveDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131952060);
    a(paramContext);
  }
  
  private void a()
  {
    setCanceledOnTouchOutside(false);
    setOnKeyListener(this.d);
  }
  
  private void a(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131624778, null);
    setContentView(paramContext);
    this.b = ((FileSaveProgressView)paramContext.findViewById(2131445241));
    this.c = ((TextView)paramContext.findViewById(2131430272));
    this.c.setOnClickListener(this);
    a();
  }
  
  private void b()
  {
    if (isShowing())
    {
      FileSaveDialog.IFileSaveCancelInterface localIFileSaveCancelInterface = this.a;
      if (localIFileSaveCancelInterface != null) {
        localIFileSaveCancelInterface.a();
      }
      try
      {
        super.cancel();
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cancel dialog exception: ");
          localStringBuilder.append(localThrowable.getMessage());
          QLog.d("FileSaveDialog", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    FileSaveProgressView localFileSaveProgressView = this.b;
    if (localFileSaveProgressView != null) {
      localFileSaveProgressView.setProgress(paramInt);
    }
  }
  
  public void a(FileSaveDialog.IFileSaveCancelInterface paramIFileSaveCancelInterface)
  {
    this.a = paramIFileSaveCancelInterface;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430272) {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    if (!isShowing()) {
      try
      {
        super.show();
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("show dialog exception: ");
          localStringBuilder.append(localThrowable.getMessage());
          QLog.d("FileSaveDialog", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveDialog
 * JD-Core Version:    0.7.0.1
 */