package com.tencent.mobileqq.troop.homework.entry.ui.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.widget.ActionSheet;

public class HwkTimePicker
{
  private ActionSheet a;
  private IphonePickerView b;
  private Context c;
  private int d;
  private int e;
  private int f;
  private IphonePickerView.PickerViewAdapter g;
  private HwkTimePicker.OnConfirmBtnClickListener h;
  private HwkTimePicker.OnDismissListener i;
  private HwkTimePicker.OnItemSelectedListener j;
  private HwkTimePicker.OnItemSelectedListener k;
  
  public HwkTimePicker(Context paramContext, IphonePickerView.PickerViewAdapter paramPickerViewAdapter)
  {
    this.c = paramContext;
    this.g = paramPickerViewAdapter;
  }
  
  public IphonePickerView.PickerViewAdapter a()
  {
    return this.g;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          this.f = paramInt2;
        }
      }
      else {
        this.e = paramInt2;
      }
    }
    else {
      this.d = paramInt2;
    }
    IphonePickerView localIphonePickerView = this.b;
    if (localIphonePickerView != null) {
      localIphonePickerView.setSelection(paramInt1, paramInt2);
    }
  }
  
  public void a(HwkTimePicker.OnConfirmBtnClickListener paramOnConfirmBtnClickListener)
  {
    this.h = paramOnConfirmBtnClickListener;
  }
  
  public void a(HwkTimePicker.OnDismissListener paramOnDismissListener)
  {
    this.i = paramOnDismissListener;
  }
  
  public void b()
  {
    if (this.a == null)
    {
      this.b = ((IphonePickerView)LayoutInflater.from(this.c).inflate(2131627482, null));
      this.b.a(this.g);
      this.a = ActionSheet.createMenuSheet(this.c);
      this.a.setCloseAutoRead(true);
      this.a.setActionContentView(this.b, null);
      Object localObject = (DispatchActionMoveScrollView)this.a.findViewById(2131427560);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.a.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.b.setPickListener(new HwkTimePicker.1(this));
      this.a.registerWatchDisMissActionListener(new HwkTimePicker.2(this));
    }
    if (!this.a.isShowing())
    {
      this.b.setSelection(0, this.d);
      this.b.setSelection(1, this.e);
      this.b.setSelection(2, this.f);
    }
    try
    {
      this.a.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c()
  {
    ActionSheet localActionSheet = this.a;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker
 * JD-Core Version:    0.7.0.1
 */