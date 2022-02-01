package com.tencent.mobileqq.selectmember;

import android.text.Layout;
import android.text.TextPaint;
import android.widget.TextView;
import java.util.ArrayList;

class BlessSelectMemberActivity$4
  implements Runnable
{
  BlessSelectMemberActivity$4(BlessSelectMemberActivity paramBlessSelectMemberActivity, TextView paramTextView, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView.getLineCount() >= 4)
    {
      int j = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getLineEnd(3);
      if (j < this.jdField_a_of_type_JavaLangStringBuilder.length())
      {
        String str = this.this$0.getString(2131690671);
        int i = 0;
        str = String.format(str, new Object[] { "...", Integer.valueOf(this.this$0.a.size()) });
        float f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(str);
        Object localObject;
        while (i < this.jdField_a_of_type_JavaLangStringBuilder.length())
        {
          localObject = this.jdField_a_of_type_JavaLangStringBuilder;
          int k = j - i;
          localObject = ((StringBuilder)localObject).substring(k, j);
          if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText((String)localObject) >= f)
          {
            this.jdField_a_of_type_JavaLangStringBuilder.setLength(k);
            break;
          }
          i += 1;
        }
        BlessSelectMemberActivity.a(this.this$0, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        if (BlessSelectMemberActivity.b(this.this$0).endsWith("、 "))
        {
          localObject = this.jdField_a_of_type_JavaLangStringBuilder;
          ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        }
        else if (BlessSelectMemberActivity.b(this.this$0).endsWith("、"))
        {
          localObject = this.jdField_a_of_type_JavaLangStringBuilder;
          ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 1);
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append(str);
        BlessSelectMemberActivity.a(this.this$0, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(null);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(BlessSelectMemberActivity.b(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.4
 * JD-Core Version:    0.7.0.1
 */