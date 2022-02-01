package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.widget.ActionSheet;

public class ActionSheetCustom
  extends ActionSheet
{
  private ActionSheetCustom.OnBackPressedListener a;
  
  protected ActionSheetCustom(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramBoolean1, paramBoolean2);
  }
  
  public static ActionSheetCustom a(Context paramContext)
  {
    paramContext = new ActionSheetCustom(paramContext, true, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131951622);
    }
    return paramContext;
  }
  
  public void a(ActionSheetCustom.OnBackPressedListener paramOnBackPressedListener)
  {
    this.a = paramOnBackPressedListener;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    ActionSheetCustom.OnBackPressedListener localOnBackPressedListener = this.a;
    if (localOnBackPressedListener != null) {
      localOnBackPressedListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ActionSheetCustom
 * JD-Core Version:    0.7.0.1
 */