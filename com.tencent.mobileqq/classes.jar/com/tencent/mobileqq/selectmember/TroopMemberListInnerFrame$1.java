package com.tencent.mobileqq.selectmember;

import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class TroopMemberListInnerFrame$1
  extends Handler
{
  TroopMemberListInnerFrame$1(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2))
    {
      Object localObject;
      if (i != 3)
      {
        if (i != 4) {
          return;
        }
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Double += TroopMemberListInnerFrame.jdField_b_of_type_Double;
        if ((this.a.jdField_a_of_type_Double < 90.0D) && (this.a.jdField_a_of_type_Int > 0))
        {
          if (this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
            this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          }
          this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)this.a.jdField_a_of_type_Double);
          paramMessage = this.a.d;
          localObject = HardCodeUtil.a(2131715392);
          double d1 = this.a.jdField_a_of_type_Int;
          double d2 = this.a.jdField_a_of_type_Double;
          Double.isNaN(d1);
          paramMessage.setText(String.format((String)localObject, new Object[] { Integer.valueOf(Math.min((int)(d1 * d2 / 100.0D), this.a.jdField_a_of_type_Int)), Integer.valueOf(this.a.jdField_a_of_type_Int) }));
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4), 800L);
        }
      }
      else
      {
        TroopMemberListInnerFrame.a(this.a, paramMessage.arg1);
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
        if ((paramMessage.obj instanceof Object[]))
        {
          Object[] arrayOfObject = (Object[])paramMessage.obj;
          if (arrayOfObject.length > 0)
          {
            localObject = (String)arrayOfObject[1];
            if (!((String)localObject).equals(this.a.jdField_b_of_type_JavaLangString))
            {
              if (!QLog.isColorLevel()) {
                return;
              }
              paramMessage = new StringBuilder();
              paramMessage.append("handleMessage, troopUin != mTroopUin, break:");
              paramMessage.append((String)localObject);
              paramMessage.append(",");
              paramMessage.append(this.a.jdField_b_of_type_JavaLangString);
              QLog.d("TroopMemberListInnerFrame.thread", 2, paramMessage.toString());
              return;
            }
            this.a.jdField_a_of_type_JavaUtilMap = ((Map)arrayOfObject[0]);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleMessage, mIndexedFriends.size=");
          ((StringBuilder)localObject).append(this.a.jdField_a_of_type_JavaUtilMap.size());
          QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject).toString());
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 1) || (this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 5))
        {
          localObject = this.a;
          i = TroopMemberListInnerFrame.a((TroopMemberListInnerFrame)localObject, ((TroopMemberListInnerFrame)localObject).jdField_a_of_type_JavaUtilMap);
          this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.afterMemberFilter(i);
        }
        paramMessage.obj = TroopMemberListInnerFrame.a(this.a);
        TroopMemberListInnerFrame.a(this.a, paramMessage);
        if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mIsSelectAllMembers))
        {
          paramMessage = this.a;
          paramMessage.jdField_a_of_type_Boolean = true;
          paramMessage.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.a.jdField_a_of_type_AndroidWidgetCheckBox.isChecked() ^ true);
          paramMessage = this.a;
          paramMessage.onCheckedChanged(paramMessage.jdField_a_of_type_AndroidWidgetCheckBox, this.a.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
        }
      }
    }
    else
    {
      TroopMemberListInnerFrame.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.1
 * JD-Core Version:    0.7.0.1
 */