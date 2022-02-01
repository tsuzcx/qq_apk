package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.reflect.Field;

public class PickerView
  extends ReportDialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private TextView mCancelTextView;
  private TextView mConfirmTextView;
  private NumberPicker mNumPicker;
  private PickerView.OnConfirmListener mOnConfirmListener;
  private int result;
  private String[] vals;
  
  public PickerView(@NonNull Context paramContext)
  {
    super(paramContext, 2131755381);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559094, null);
    setContentView(paramContext);
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setGravity(80);
    }
    this.mNumPicker = ((NumberPicker)paramContext.findViewById(2131371962));
    this.mCancelTextView = ((TextView)paramContext.findViewById(2131379503));
    this.mCancelTextView.setOnClickListener(this);
    this.mConfirmTextView = ((TextView)paramContext.findViewById(2131379542));
    this.mConfirmTextView.setOnClickListener(this);
    setNumpickerDiverColor(this.mNumPicker);
    setOnCancelListener(this);
  }
  
  private void setNumpickerDiverColor(NumberPicker paramNumberPicker)
  {
    Field[] arrayOfField = NumberPicker.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      Field localField;
      if (i < j)
      {
        localField = arrayOfField[i];
        if (localField.getName().equals("mSelectionDivider")) {
          localField.setAccessible(true);
        }
      }
      else
      {
        try
        {
          localField.set(paramNumberPicker, new ColorDrawable(ColorUtils.parseColor("#3CB371")));
          return;
        }
        catch (IllegalArgumentException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (Resources.NotFoundException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (IllegalAccessException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public void dismissDlg()
  {
    try
    {
      if (isShowing()) {
        dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void init(int paramInt, PickerView.OnConfirmListener paramOnConfirmListener)
  {
    this.result = paramInt;
    this.mNumPicker.setOnValueChangedListener(new PickerView.1(this));
    this.mOnConfirmListener = paramOnConfirmListener;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.mOnConfirmListener != null) {
      this.mOnConfirmListener.onValCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131379503)
    {
      if (this.mOnConfirmListener != null) {
        this.mOnConfirmListener.onValCancel();
      }
      dismissDlg();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131379542)
      {
        if (this.mOnConfirmListener != null) {
          this.mOnConfirmListener.onValConfirm(this.result);
        }
        dismissDlg();
      }
    }
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    this.vals = paramArrayOfString;
    this.mNumPicker.setDisplayedValues(paramArrayOfString);
  }
  
  public void setMaxValues(int paramInt)
  {
    this.mNumPicker.setMaxValue(paramInt);
  }
  
  public void setMinValue(int paramInt)
  {
    this.mNumPicker.setMinValue(paramInt);
  }
  
  public void setValue(int paramInt)
  {
    this.mNumPicker.setValue(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.PickerView
 * JD-Core Version:    0.7.0.1
 */