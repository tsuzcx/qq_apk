package com.tencent.mobileqq.newnearby.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;

public class PickBirthdayHelper
{
  private static int a;
  private static int b;
  private static int c;
  private static int d;
  private static int e;
  private static int f;
  
  public static void a(Promise paramPromise, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = QBaseActivity.sTopActivity;
    ActionSheet localActionSheet = ActionSheet.createMenuSheet((Context)localObject1);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(System.currentTimeMillis());
    a = ((Calendar)localObject2).get(1);
    b = paramInt1;
    c = ((Calendar)localObject2).get(2) + 1;
    d = paramInt2;
    e = ((Calendar)localObject2).get(5);
    f = paramInt3;
    localObject2 = (DispatchActionMoveScrollView)localActionSheet.findViewById(2131427560);
    ((DispatchActionMoveScrollView)localObject2).a = true;
    ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
    localObject1 = (IphonePickerView)LayoutInflater.from((Context)localObject1).inflate(2131627482, null);
    ((IphonePickerView)localObject1).a(f());
    ((IphonePickerView)localObject1).setPickListener(new PickBirthdayHelper.1(localActionSheet, paramPromise));
    ((IphonePickerView)localObject1).setSelection(0, b - 1896);
    ((IphonePickerView)localObject1).setSelection(1, d - 1);
    ((IphonePickerView)localObject1).setSelection(2, f - 1);
    localActionSheet.setOnDismissListener(new PickBirthdayHelper.2());
    localActionSheet.setActionContentView((View)localObject1, null);
    localActionSheet.show();
  }
  
  private static IphonePickerView.PickerViewAdapter f()
  {
    return new PickBirthdayHelper.3();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.PickBirthdayHelper
 * JD-Core Version:    0.7.0.1
 */