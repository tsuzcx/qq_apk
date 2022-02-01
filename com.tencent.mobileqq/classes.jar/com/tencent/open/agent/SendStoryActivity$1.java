package com.tencent.open.agent;

import android.text.Editable;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

class SendStoryActivity$1
  implements Comparator<Friend>
{
  SendStoryActivity$1(SendStoryActivity paramSendStoryActivity, Editable paramEditable) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return this.a.getSpanStart(paramFriend1) - this.a.getSpanStart(paramFriend2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.SendStoryActivity.1
 * JD-Core Version:    0.7.0.1
 */