package com.tencent.mobileqq.matchchat;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

class MatchChatMsgListFragment$9
  implements Handler.Callback
{
  MatchChatMsgListFragment$9(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      if ((!this.a.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.a.jdField_b_of_type_JavaUtilList);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(21);
        this.a.b();
        if ((this.a.c) || (this.a.jdField_b_of_type_JavaUtilList.size() == 0)) {
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        while (!this.a.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "init ui cost time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) }));
          return false;
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
      this.a.jdField_b_of_type_Boolean = true;
      return false;
    }
    MatchChatMsgListFragment.a(this.a, MatchChatMsgListFragment.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.9
 * JD-Core Version:    0.7.0.1
 */