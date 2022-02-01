package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.miniapp.R.id;
import com.tencent.qqmini.miniapp.R.layout;
import com.tencent.qqmini.miniapp.R.style;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.lang.reflect.Field;

public class DatePickerView
  extends ReportDialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private int dayOfMonth;
  private TextView mCancelTextView;
  private TextView mConfirmTextView;
  private DatePicker mDatePicker;
  private DatePickerView.OnConfirmListener mOnConfirmListener;
  private int monthOfYear;
  private int year;
  
  public DatePickerView(Context paramContext)
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
    this.mDatePicker = new DatePicker(new ContextThemeWrapper(getContext(), 16973934));
    this.mDatePicker.setCalendarViewShown(false);
    ((FrameLayout)localObject).addView(this.mDatePicker);
    this.mCancelTextView = ((TextView)paramContext.findViewById(R.id.tv_cancel));
    this.mCancelTextView.setOnClickListener(this);
    this.mConfirmTextView = ((TextView)paramContext.findViewById(R.id.tv_confirm));
    this.mConfirmTextView.setOnClickListener(this);
    setDatePickerDividerColor(this.mDatePicker);
    setOnCancelListener(this);
  }
  
  private void setDatePickerDividerColor(DatePicker paramDatePicker)
  {
    paramDatePicker = (LinearLayout)((LinearLayout)paramDatePicker.getChildAt(0)).getChildAt(0);
    int i = 0;
    while (i < paramDatePicker.getChildCount())
    {
      NumberPicker localNumberPicker = (NumberPicker)paramDatePicker.getChildAt(i);
      Field[] arrayOfField = NumberPicker.class.getDeclaredFields();
      int k = arrayOfField.length;
      int j = 0;
      while (j < k)
      {
        Field localField = arrayOfField[j];
        if (localField.getName().equals("mSelectionDivider"))
        {
          localField.setAccessible(true);
          try
          {
            localField.set(localNumberPicker, new ColorDrawable(ColorUtils.parseColor("#3CB371")));
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
          }
          catch (Resources.NotFoundException localNotFoundException)
          {
            localNotFoundException.printStackTrace();
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
          }
        }
        j += 1;
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
  
  public void init(int paramInt1, int paramInt2, int paramInt3, DatePickerView.OnConfirmListener paramOnConfirmListener)
  {
    this.mDatePicker.init(paramInt1, paramInt2, paramInt3, new DatePickerView.1(this));
    this.mOnConfirmListener = paramOnConfirmListener;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.mOnConfirmListener;
    if (paramDialogInterface != null) {
      paramDialogInterface.onDateCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (paramView.getId() == R.id.tv_cancel)
    {
      localObject1 = this.mOnConfirmListener;
      if (localObject1 != null) {
        ((DatePickerView.OnConfirmListener)localObject1).onDateCancel();
      }
      dismissDlg();
    }
    else if (paramView.getId() == R.id.tv_confirm)
    {
      if (this.mOnConfirmListener != null)
      {
        int i = this.monthOfYear + 1;
        if (i < 10)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("0");
          ((StringBuilder)localObject1).append(i);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = String.valueOf(i);
        }
        i = this.dayOfMonth;
        Object localObject2;
        if (i < 10)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("0");
          ((StringBuilder)localObject2).append(i);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = String.valueOf(i);
        }
        this.mOnConfirmListener.onDateConfirm(String.valueOf(this.year), (String)localObject1, (String)localObject2);
      }
      dismissDlg();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setDayOfMonthVisible(int paramInt)
  {
    DatePicker localDatePicker = this.mDatePicker;
    if (localDatePicker != null) {
      ((ViewGroup)((ViewGroup)localDatePicker.getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(paramInt);
    }
  }
  
  public void setMaxDate(long paramLong)
  {
    this.mDatePicker.setMaxDate(paramLong);
  }
  
  public void setMinDate(long paramLong)
  {
    this.mDatePicker.setMinDate(paramLong);
  }
  
  public void setMonthOfYearVisible(int paramInt)
  {
    DatePicker localDatePicker = this.mDatePicker;
    if (localDatePicker != null) {
      ((ViewGroup)((ViewGroup)localDatePicker.getChildAt(0)).getChildAt(0)).getChildAt(1).setVisibility(paramInt);
    }
  }
  
  public void setYearVisible(int paramInt)
  {
    DatePicker localDatePicker = this.mDatePicker;
    if (localDatePicker != null) {
      ((ViewGroup)((ViewGroup)localDatePicker.getChildAt(0)).getChildAt(0)).getChildAt(0).setVisibility(paramInt);
    }
  }
  
  public void updateDate(int paramInt1, int paramInt2, int paramInt3)
  {
    this.year = paramInt1;
    this.monthOfYear = paramInt2;
    this.dayOfMonth = paramInt3;
    this.mDatePicker.updateDate(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.DatePickerView
 * JD-Core Version:    0.7.0.1
 */