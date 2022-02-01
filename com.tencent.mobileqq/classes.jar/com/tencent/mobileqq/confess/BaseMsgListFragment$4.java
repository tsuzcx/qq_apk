package com.tencent.mobileqq.confess;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

class BaseMsgListFragment$4
  implements Handler.Callback
{
  BaseMsgListFragment$4(BaseMsgListFragment paramBaseMsgListFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label196:
    for (;;)
    {
      return false;
      if ((this.a.a()) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.a.jdField_c_of_type_JavaUtilList);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(17);
      this.a.c();
      if ((this.a.jdField_c_of_type_Boolean) || (this.a.jdField_c_of_type_JavaUtilList.size() == 0)) {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Boolean) {
          break label196;
        }
        this.a.jdField_a_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "init ui cost time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) }));
        return false;
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    this.a.b = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.BaseMsgListFragment.4
 * JD-Core Version:    0.7.0.1
 */