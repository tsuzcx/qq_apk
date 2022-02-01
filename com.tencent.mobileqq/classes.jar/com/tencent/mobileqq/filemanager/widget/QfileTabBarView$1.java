package com.tencent.mobileqq.filemanager.widget;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.mobileqq.widget.TabBarView2;
import java.util.HashMap;

class QfileTabBarView$1
  implements TabBarView.OnTabChangeListener
{
  QfileTabBarView$1(QfileTabBarView paramQfileTabBarView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.a(paramInt2) == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setSelected(true);
      this.a.b(paramInt2);
    } while (!this.a.jdField_a_of_type_Boolean);
    try
    {
      SharedPreferences.Editor localEditor = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_view", ((Integer)this.a.c.get(Integer.valueOf(paramInt2))).intValue());
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView.1
 * JD-Core Version:    0.7.0.1
 */