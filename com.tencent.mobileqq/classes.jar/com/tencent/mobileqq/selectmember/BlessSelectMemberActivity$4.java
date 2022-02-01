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
    if (this.a.getLineCount() >= 4)
    {
      int j = this.a.getLayout().getLineEnd(3);
      if (j < this.b.length())
      {
        String str = this.this$0.getString(2131887586);
        int i = 0;
        str = String.format(str, new Object[] { "...", Integer.valueOf(this.this$0.d.size()) });
        float f = this.a.getPaint().measureText(str);
        Object localObject;
        while (i < this.b.length())
        {
          localObject = this.b;
          int k = j - i;
          localObject = ((StringBuilder)localObject).substring(k, j);
          if (this.a.getPaint().measureText((String)localObject) >= f)
          {
            this.b.setLength(k);
            break;
          }
          i += 1;
        }
        BlessSelectMemberActivity.b(this.this$0, this.b.toString());
        if (BlessSelectMemberActivity.e(this.this$0).endsWith("、 "))
        {
          localObject = this.b;
          ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        }
        else if (BlessSelectMemberActivity.e(this.this$0).endsWith("、"))
        {
          localObject = this.b;
          ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 1);
        }
        this.b.append(str);
        BlessSelectMemberActivity.b(this.this$0, this.b.toString());
        this.a.setEllipsize(null);
        this.a.setText(BlessSelectMemberActivity.e(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.4
 * JD-Core Version:    0.7.0.1
 */