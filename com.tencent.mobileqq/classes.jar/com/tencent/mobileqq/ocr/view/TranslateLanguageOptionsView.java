package com.tencent.mobileqq.ocr.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class TranslateLanguageOptionsView
  extends PopupWindow
  implements RadioGroup.OnCheckedChangeListener
{
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private TranslateLanguageOptionsView.OnOptionSelectedListener jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView$OnOptionSelectedListener;
  
  private TranslateLanguageOptionsView(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131365203));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
  }
  
  public static TranslateLanguageOptionsView a(Activity paramActivity, List<TranslateLanguageOptionsView.OptionItem> paramList, int paramInt, TranslateLanguageOptionsView.OnOptionSelectedListener paramOnOptionSelectedListener)
  {
    if ((paramActivity != null) && (paramList != null) && (paramList.size() > 0))
    {
      paramActivity.getResources();
      int m = DisplayUtil.a(paramActivity, 36.0F);
      int k = DisplayUtil.a(paramActivity, 150.0F);
      View localView = LayoutInflater.from(paramActivity).inflate(2131561263, null);
      BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131364121);
      RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131365203);
      Object localObject = null;
      int j = 0;
      int i = 78;
      while (j < paramList.size())
      {
        TranslateLanguageOptionsView.OptionItem localOptionItem = (TranslateLanguageOptionsView.OptionItem)paramList.get(j);
        RadioButton localRadioButton = (RadioButton)LayoutInflater.from(paramActivity).inflate(2131561262, null);
        localRadioButton.setText(localOptionItem.a);
        localRadioButton.setTag(localOptionItem);
        localRadioButton.setId(j);
        if (j == paramInt)
        {
          localRadioButton.setChecked(true);
          localObject = localRadioButton;
        }
        localRadioGroup.addView(localRadioButton, j, new LinearLayout.LayoutParams(-1, -2));
        i += m;
        j += 1;
      }
      paramInt = i;
      if (i > DisplayUtil.a(paramActivity, 300.0F)) {
        paramInt = DisplayUtil.a(paramActivity, 300.0F);
      }
      if (localObject != null) {
        localBounceScrollView.post(new TranslateLanguageOptionsView.1(localObject, localBounceScrollView));
      }
      paramActivity = new TranslateLanguageOptionsView(paramActivity, localView, k, paramInt);
      paramActivity.setAnimationStyle(2131755035);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setFocusable(true);
      paramActivity.setOutsideTouchable(true);
      paramActivity.a(paramOnOptionSelectedListener);
      return paramActivity;
    }
    return null;
  }
  
  public void a(TranslateLanguageOptionsView.OnOptionSelectedListener paramOnOptionSelectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView$OnOptionSelectedListener = paramOnOptionSelectedListener;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    try
    {
      TranslateLanguageOptionsView.OptionItem localOptionItem = (TranslateLanguageOptionsView.OptionItem)((RadioButton)paramRadioGroup.getChildAt(paramInt)).getTag();
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView$OnOptionSelectedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView$OnOptionSelectedListener.a(paramInt, localOptionItem);
      }
      dismiss();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView
 * JD-Core Version:    0.7.0.1
 */