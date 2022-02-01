package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.miniapp.R.id;
import com.tencent.qqmini.miniapp.R.layout;
import com.tencent.qqmini.miniapp.R.style;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.lang.reflect.Field;

public class TimePickerView
  extends ReportDialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private int hour;
  private NumberPicker hourNumberPicker;
  private TextView mCancelTextView;
  private TextView mConfirmTextView;
  private TimePickerView.OnConfirmListener mOnConfirmListener;
  private TimePicker mTimePicker;
  private int minute;
  private int minuteMaxValue = 59;
  private int minuteMinValue;
  private NumberPicker minuteNumberPicker;
  
  public TimePickerView(@NonNull Context paramContext)
  {
    super(paramContext, R.style.Theme_Light_NoTitle_Dialog);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_dialog_date_picker, null);
    setContentView(paramContext);
    Object localObject = getWindow();
    if (localObject != null)
    {
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      ((Window)localObject).setAttributes(localLayoutParams);
      ((Window)localObject).setGravity(80);
    }
    localObject = (FrameLayout)paramContext.findViewById(R.id.picker_container);
    this.mTimePicker = new TimePicker(new ContextThemeWrapper(getContext(), 16973934));
    ((FrameLayout)localObject).addView(this.mTimePicker);
    this.mCancelTextView = ((TextView)paramContext.findViewById(R.id.tv_cancel));
    this.mCancelTextView.setOnClickListener(this);
    this.mConfirmTextView = ((TextView)paramContext.findViewById(R.id.tv_confirm));
    this.mConfirmTextView.setOnClickListener(this);
    int i = Resources.getSystem().getIdentifier("hour", "id", "android");
    int j = Resources.getSystem().getIdentifier("minute", "id", "android");
    int k = Resources.getSystem().getIdentifier("amPm", "id", "android");
    this.hourNumberPicker = ((NumberPicker)this.mTimePicker.findViewById(i));
    this.minuteNumberPicker = ((NumberPicker)this.mTimePicker.findViewById(j));
    paramContext = (NumberPicker)this.mTimePicker.findViewById(k);
    setNumberPickerDividerColor(this.hourNumberPicker);
    setNumberPickerDividerColor(this.minuteNumberPicker);
    setNumberPickerDividerColor(paramContext);
    setOnCancelListener(this);
  }
  
  private void setNumberPickerDividerColor(NumberPicker paramNumberPicker)
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
  
  public void init(int paramInt1, int paramInt2, TimePickerView.OnConfirmListener paramOnConfirmListener)
  {
    this.mTimePicker.setCurrentHour(Integer.valueOf(paramInt1));
    this.mTimePicker.setCurrentMinute(Integer.valueOf(paramInt2));
    this.mTimePicker.setOnTimeChangedListener(new TimePickerView.1(this));
    this.mOnConfirmListener = paramOnConfirmListener;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.mOnConfirmListener;
    if (paramDialogInterface != null) {
      paramDialogInterface.onTimeCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (paramView.getId() == R.id.tv_cancel)
    {
      localObject1 = this.mOnConfirmListener;
      if (localObject1 != null) {
        ((TimePickerView.OnConfirmListener)localObject1).onTimeCancel();
      }
      dismissDlg();
    }
    else if (paramView.getId() == R.id.tv_confirm)
    {
      if (this.mOnConfirmListener != null)
      {
        Object localObject2 = String.valueOf(this.hour);
        localObject1 = localObject2;
        if (this.hour < 10)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("0");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        String str = String.valueOf(this.minute);
        localObject2 = str;
        if (this.minute < 10)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("0");
          ((StringBuilder)localObject2).append(str);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        this.mOnConfirmListener.onTimeConfirm((String)localObject1, (String)localObject2);
      }
      dismissDlg();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setHourMaxValue(int paramInt)
  {
    this.hourNumberPicker.setMaxValue(paramInt);
  }
  
  public void setHourMinValue(int paramInt)
  {
    this.hourNumberPicker.setMinValue(paramInt);
  }
  
  public void setIs24HourView(boolean paramBoolean)
  {
    this.mTimePicker.setIs24HourView(Boolean.valueOf(paramBoolean));
  }
  
  public void setMinuteMaxValue(int paramInt)
  {
    this.minuteMaxValue = paramInt;
  }
  
  public void setMinuteMinValue(int paramInt)
  {
    this.minuteMinValue = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.TimePickerView
 * JD-Core Version:    0.7.0.1
 */