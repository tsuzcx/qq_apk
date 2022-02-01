package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.writetogether.WriteTogetherOidbObserver;
import java.util.Arrays;

class ForwardBaseOption$4
  extends WriteTogetherOidbObserver
{
  ForwardBaseOption$4(ForwardBaseOption paramForwardBaseOption, boolean[] paramArrayOfBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt, int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    super.a(paramInt, paramBoolean, paramArrayOfObject);
    ForwardBaseOption.e(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSentMessage() called with: type = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], result = [");
      localStringBuilder.append(paramArrayOfObject[1]);
      localStringBuilder.append("], isExpiredMessage: ");
      localStringBuilder.append(Arrays.toString(ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption)));
      localStringBuilder.append(" padId: ");
      localStringBuilder.append(Arrays.toString((Object[])paramArrayOfObject[0]));
      Log.d("onSentMessage", localStringBuilder.toString());
      if (((Integer)paramArrayOfObject[1]).intValue() == 505)
      {
        paramArrayOfObject = (String[])paramArrayOfObject[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_ArrayOfBoolean.length)
        {
          if ((this.jdField_a_of_type_ArrayOfJavaLangString[paramInt].equals(paramArrayOfObject[0])) && (this.b[paramInt].equals(paramArrayOfObject[1])) && (this.jdField_a_of_type_ArrayOfInt[paramInt] == Integer.parseInt(paramArrayOfObject[2]))) {
            ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption)[paramInt] = 1;
          }
          paramInt += 1;
        }
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidAppActivity, "发送失败，请稍后重试。", 0).a();
      paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
      paramArrayOfObject.d = 0;
      paramArrayOfObject.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidAppActivity.setResult(15);
    paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
    paramInt = paramArrayOfObject.d + 1;
    paramArrayOfObject.d = paramInt;
    if (paramInt == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidOsBundle.putBooleanArray("forward_write_together_is_expired", ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption));
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.j())
      {
        ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.4
 * JD-Core Version:    0.7.0.1
 */