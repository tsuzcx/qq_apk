package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;

public class TroopPickerViewHelper
{
  private int a = 15;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  private long e;
  private ActionSheet f;
  private WheelPickerLayout g;
  private TroopPickerViewHelper.DateAdapter h;
  private Calendar i;
  
  public TroopPickerViewHelper(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramLong;
  }
  
  public void a(Activity paramActivity, TroopPickerViewHelper.OnConfirmListener paramOnConfirmListener)
  {
    if (this.f == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131626725, null);
      this.f = ActionSheet.createMenuSheet(paramActivity);
      this.f.setCloseAutoRead(true);
      this.f.setActionContentView(localView, null);
      this.g = ((WheelPickerLayout)localView.findViewById(2131447874));
      WheelPickerLayout.ViewStyle localViewStyle = new WheelPickerLayout.ViewStyle();
      paramActivity = paramActivity.getResources();
      localViewStyle.a = 33;
      localViewStyle.b = 23;
      localViewStyle.c = paramActivity.getColor(2131168132);
      localViewStyle.d = 17;
      localViewStyle.e = 23;
      localViewStyle.f = paramActivity.getColor(2131167993);
      this.h = new TroopPickerViewHelper.DateAdapter(this, this.g);
      this.g.a(this.h, localViewStyle);
      this.g.setPickListener(new TroopPickerViewHelper.1(this));
      paramActivity = localView.findViewById(2131429844);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new TroopPickerViewHelper.2(this, paramOnConfirmListener));
      }
    }
    if (!this.f.isShowing())
    {
      paramActivity = this.h.a(this.e);
      int j = 0;
      while (j < paramActivity.length)
      {
        this.g.setSelection(j, paramActivity[j]);
        this.g.a(j);
        j += 1;
      }
      this.i = this.h.a(paramActivity);
    }
    try
    {
      this.f.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopPickerViewHelper
 * JD-Core Version:    0.7.0.1
 */