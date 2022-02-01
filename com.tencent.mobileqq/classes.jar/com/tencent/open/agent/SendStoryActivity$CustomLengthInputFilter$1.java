package com.tencent.open.agent;

import android.text.Editable;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

class SendStoryActivity$CustomLengthInputFilter$1
  implements Comparator<Friend>
{
  SendStoryActivity$CustomLengthInputFilter$1(SendStoryActivity.CustomLengthInputFilter paramCustomLengthInputFilter, Editable paramEditable) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend2) - this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.SendStoryActivity.CustomLengthInputFilter.1
 * JD-Core Version:    0.7.0.1
 */