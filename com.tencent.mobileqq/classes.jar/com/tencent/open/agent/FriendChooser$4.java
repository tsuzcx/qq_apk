package com.tencent.open.agent;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import com.tencent.qphone.base.util.QLog;

class FriendChooser$4
  extends Handler
{
  FriendChooser$4(FriendChooser paramFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      this.a.jdField_a_of_type_AndroidWidgetHorizontalScrollView.scrollTo(this.a.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width, 0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width);
        QLog.e("qqBaseActivity", 2, localStringBuilder.toString());
      }
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.4
 * JD-Core Version:    0.7.0.1
 */