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
    if ((localQQAppInterface == null) || (localQBaseActivity == null)) {
      QLog.i("LebaQCirclePartImpl", 1, "initLebaQQCircleView app == null || activity == null");
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370245));
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370248);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366452));
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetEditText, localQBaseActivity.getString(2131691248));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363942));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      p();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new LebaSearchPart.MyFocusChangeListener(localQQAppInterface, localQBaseActivity));
    } while (!AppSetting.d);
    AccessibilityUtil.b(paramView);
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
    int j = 0;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      boolean bool = SearchConfigUtils.a();
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (!bool) {
        break label57;
      }
      i = 0;
      ((RelativeLayout)localObject).setVisibility(i);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (bool) {
          break label63;
        }
      }
    }
    label57:
    label63:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaSearchPart
 * JD-Core Version:    0.7.0.1
 */