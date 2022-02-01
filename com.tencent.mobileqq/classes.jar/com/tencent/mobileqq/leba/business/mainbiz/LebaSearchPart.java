package com.tencent.mobileqq.leba.business.mainbiz;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.business.BaseLebaMainBiz;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LebaSearchPart
  extends BaseLebaMainBiz
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = a();
    if (localAppRuntime != null) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(View paramView)
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369913));
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369916);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366333));
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetEditText, localQBaseActivity.getString(2131691169));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363868));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      p();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new LebaSearchPart.MyFocusChangeListener(localQQAppInterface, localQBaseActivity));
      if (AppSetting.d) {
        AccessibilityUtil.b(paramView);
      }
      return;
    }
    QLog.i("LebaQCirclePartImpl", 1, "initLebaQQCircleView app == null || activity == null");
  }
  
  public void a(boolean paramBoolean)
  {
    p();
  }
  
  public void i()
  {
    p();
  }
  
  public void o()
  {
    p();
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      boolean bool = SearchConfigUtils.a();
      Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      int j = 0;
      int i;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      ((RelativeLayout)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        if (!bool) {
          i = j;
        } else {
          i = 8;
        }
        ((View)localObject).setVisibility(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaSearchPart
 * JD-Core Version:    0.7.0.1
 */