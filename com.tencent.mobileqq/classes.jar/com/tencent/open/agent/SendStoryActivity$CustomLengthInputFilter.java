package com.tencent.open.agent;

import android.text.Editable;
import android.text.Spanned;
import android.widget.EditText;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.LengthInputFilter;
import com.tencent.open.base.StringAddition;
import java.util.Arrays;

public class SendStoryActivity$CustomLengthInputFilter
  extends LengthInputFilter
{
  public SendStoryActivity$CustomLengthInputFilter(SendStoryActivity paramSendStoryActivity, EditText paramEditText, int paramInt)
  {
    super(paramEditText, paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramSpanned = this.b.getEditableText();
    StringBuilder localStringBuilder = new StringBuilder(paramSpanned.toString());
    paramInt4 = paramSpanned.length();
    paramInt3 = 0;
    Friend[] arrayOfFriend = (Friend[])paramSpanned.getSpans(0, paramInt4, Friend.class);
    Arrays.sort(arrayOfFriend, new SendStoryActivity.CustomLengthInputFilter.1(this, paramSpanned));
    paramInt4 = arrayOfFriend.length;
    while (paramInt3 < paramInt4)
    {
      Friend localFriend = arrayOfFriend[paramInt3];
      localStringBuilder.delete(paramSpanned.getSpanStart(localFriend), paramSpanned.getSpanEnd(localFriend));
      paramInt3 += 1;
    }
    paramInt4 = this.c - StringAddition.c(localStringBuilder.toString());
    paramInt3 = StringAddition.c(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
    if (paramInt4 <= 0) {
      return "";
    }
    if (paramInt4 >= paramInt3) {
      return null;
    }
    paramInt3 = paramInt1;
    while (paramInt3 < paramInt2)
    {
      int j;
      int i;
      if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3)))
      {
        j = StringAddition.c(paramCharSequence.subSequence(paramInt3, paramInt3 + 2).toString());
        i = 2;
      }
      else
      {
        j = StringAddition.c(String.valueOf(paramCharSequence.charAt(paramInt3)));
        i = 1;
      }
      paramInt4 -= j;
      if (paramInt4 < 0) {
        break;
      }
      paramInt3 += i;
    }
    if (paramInt3 == paramInt1) {
      return "";
    }
    return paramCharSequence.subSequence(paramInt1, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.SendStoryActivity.CustomLengthInputFilter
 * JD-Core Version:    0.7.0.1
 */