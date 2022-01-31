package com.tencent.mobileqq.mini.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.mobileqq.mini.util.ColorUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MutiPickerView
  extends Dialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private TextView mCancelTextView;
  private TextView mConfirmTextView;
  private LinearLayout mMutiPickerContainer;
  private ArrayList<NumberPicker> mNumberPicker = new ArrayList();
  private MutiPickerView.OnConfirmListener mOnConfirmListener;
  private int[] mResult;
  private String[][] mValues;
  
  public MutiPickerView(@NonNull Context paramContext)
  {
    super(paramContext, 2131755367);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559370, null);
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
    this.mMutiPickerContainer = ((LinearLayout)paramContext.findViewById(2131370922));
    this.mCancelTextView = ((TextView)paramContext.findViewById(2131370923));
    this.mCancelTextView.setOnClickListener(this);
    this.mConfirmTextView = ((TextView)paramContext.findViewById(2131370924));
    this.mConfirmTextView.setOnClickListener(this);
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
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.mOnConfirmListener != null) {
      this.mOnConfirmListener.onValCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370923)
    {
      if (this.mOnConfirmListener != null) {
        this.mOnConfirmListener.onValCancel();
      }
      dismissDlg();
    }
    while (paramView.getId() != 2131370924) {
      return;
    }
    if (this.mOnConfirmListener != null) {
      this.mOnConfirmListener.onValConfirm(this.mResult);
    }
    dismissDlg();
  }
  
  public void setCurrentIndex(int[] paramArrayOfInt)
  {
    if ((this.mNumberPicker == null) || (this.mNumberPicker.size() == 0)) {}
    for (;;)
    {
      return;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length == this.mNumberPicker.size()))
      {
        this.mResult = paramArrayOfInt;
        int i = 0;
        while (i < this.mNumberPicker.size())
        {
          ((NumberPicker)this.mNumberPicker.get(i)).setValue(paramArrayOfInt[i]);
          i += 1;
        }
      }
    }
  }
  
  public void setDisplayedValues(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      do
      {
        return;
      } while ((this.mNumberPicker == null) || (paramInt1 >= this.mNumberPicker.size()));
      NumberPicker localNumberPicker = (NumberPicker)this.mNumberPicker.get(paramInt1);
      localNumberPicker.setDisplayedValues(null);
      localNumberPicker.setMaxValue(paramArrayOfString.length - 1);
      localNumberPicker.setDisplayedValues(paramArrayOfString);
      localNumberPicker.setValue(paramInt2);
    } while ((paramInt1 >= this.mResult.length) || (paramInt1 < 0));
    this.mResult[paramInt1] = paramInt2;
  }
  
  public void setDisplayedValues(String[][] paramArrayOfString)
  {
    this.mValues = paramArrayOfString;
    this.mNumberPicker.clear();
    if (this.mMutiPickerContainer.getChildCount() > 0) {
      this.mMutiPickerContainer.removeAllViews();
    }
    this.mResult = null;
    if (paramArrayOfString != null)
    {
      this.mResult = new int[paramArrayOfString.length];
      int i = 0;
      if (i < paramArrayOfString.length)
      {
        if (Build.VERSION.SDK_INT >= 16) {}
        for (Object localObject = new MiniNumberPicker(getContext());; localObject = new NumberPicker(getContext()))
        {
          if (paramArrayOfString[i].length > 0)
          {
            ((NumberPicker)localObject).setDisplayedValues(paramArrayOfString[i]);
            ((NumberPicker)localObject).setMinValue(0);
            ((NumberPicker)localObject).setMaxValue(paramArrayOfString[i].length - 1);
          }
          ((NumberPicker)localObject).setOnValueChangedListener(new MutiPickerView.MutiOnValueChangeListener(this, i));
          setNumpickerDiverColor((NumberPicker)localObject);
          this.mNumberPicker.add(localObject);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
          localLayoutParams.weight = 1.0F;
          localLayoutParams.setMargins(10, 10, 10, 10);
          this.mMutiPickerContainer.addView((View)localObject, localLayoutParams);
          i += 1;
          break;
        }
      }
    }
  }
  
  public void setOnConfirmListener(MutiPickerView.OnConfirmListener paramOnConfirmListener)
  {
    this.mOnConfirmListener = paramOnConfirmListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MutiPickerView
 * JD-Core Version:    0.7.0.1
 */