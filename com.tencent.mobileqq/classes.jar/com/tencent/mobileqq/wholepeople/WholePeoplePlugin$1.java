package com.tencent.mobileqq.wholepeople;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WholePeoplePlugin$1
  implements View.OnClickListener
{
  WholePeoplePlugin$1(WholePeoplePlugin paramWholePeoplePlugin, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("WholePeoplePlugin", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWholepeopleWholePeoplePlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wholepeople.WholePeoplePlugin.1
 * JD-Core Version:    0.7.0.1
 */