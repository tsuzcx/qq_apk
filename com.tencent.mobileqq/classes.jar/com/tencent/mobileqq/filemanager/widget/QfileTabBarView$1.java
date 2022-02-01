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
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.a.b(paramInt2) == null) {
      return;
    }
    this.a.f.setSelected(true);
    this.a.c(paramInt2);
    if (this.a.d) {}
    try
    {
      SharedPreferences.Editor localEditor = this.a.i.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_view", ((Integer)this.a.m.get(Integer.valueOf(paramInt2))).intValue());
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView.1
 * JD-Core Version:    0.7.0.1
 */