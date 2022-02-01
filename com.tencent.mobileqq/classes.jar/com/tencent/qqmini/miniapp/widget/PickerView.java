package com.tencent.qqmini.miniapp.widget;

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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.miniapp.R.id;
import com.tencent.qqmini.miniapp.R.layout;
import com.tencent.qqmini.miniapp.R.style;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
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
    super(paramContext, R.style.Theme_Light_NoTitle_Dialog);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_dialog_picker, null);
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
    this.mNumPicker = ((NumberPicker)paramContext.findViewById(R.id.numPicker));
    this.mCancelTextView = ((TextView)paramContext.findViewById(R.id.tv_cancel));
    this.mCancelTextView.setOnClickListener(this);
    this.mConfirmTextView = ((TextView)paramContext.findViewById(R.id.tv_confirm));
    this.mConfirmTextView.setOnClickListener(this);
    setNumpickerDiverColor(this.mNumPicker);
    setOnCancelListener(this);
  }
  
  private void setNumpickerDiverColor(NumberPicker paramNumberPicker)
  {
    Field[] arrayOfField = NumberPicker.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if (localField.getName().equals("mSelectionDivider"))
      {
        localField.setAccessible(true);
        try
        {
          localField.set(paramNumberPicker, new ColorDrawable(ColorUtils.parseColor("#3CB371")));
          return;
        }
        catch (IllegalAccessException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (Resources.NotFoundException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (IllegalArgumentException paramNumberPicker)
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
    paramDialogInterface = this.mOnConfirmListener;
    if (paramDialogInterface != null) {
      paramDialogInterface.onValCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    PickerView.OnConfirmListener localOnConfirmListener;
    if (paramView.getId() == R.id.tv_cancel)
    {
      localOnConfirmListener = this.mOnConfirmListener;
      if (localOnConfirmListener != null) {
        localOnConfirmListener.onValCancel();
      }
      dismissDlg();
    }
    else if (paramView.getId() == R.id.tv_confirm)
    {
      localOnConfirmListener = this.mOnConfirmListener;
      if (localOnConfirmListener != null) {
        localOnConfirmListener.onValConfirm(this.result);
      }
      dismissDlg();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.PickerView
 * JD-Core Version:    0.7.0.1
 */