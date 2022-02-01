package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

class ShengpiziHbFragment$2
  implements Runnable
{
  ShengpiziHbFragment$2(ShengpiziHbFragment paramShengpiziHbFragment) {}
  
  public void run()
  {
    if ((ShengpiziHbFragment.b(this.this$0) != null) && (ShengpiziHbFragment.b(this.this$0).size() > 0) && (ShengpiziHbFragment.c(this.this$0) != null))
    {
      ShengpiziHbFragment.c(this.this$0).removeAllViews();
      int i = 0;
      while (i < ShengpiziHbFragment.b(this.this$0).size())
      {
        TextView localTextView = new TextView(this.this$0.f);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = DisplayUtil.a(this.this$0.f, 19.0F);
        ShengpiziHbFragment.c(this.this$0).addView(localTextView, localLayoutParams);
        localTextView.setText((CharSequence)ShengpiziHbFragment.b(this.this$0).get(i));
        localTextView.setTextColor(Color.parseColor("#898D9B"));
        localTextView.setTextSize(15.0F);
        localTextView.setTag(Integer.valueOf(i));
        localTextView.setOnClickListener(new ShengpiziHbFragment.2.1(this, localTextView));
        if (i == 0)
        {
          ShengpiziHbFragment.a(this.this$0, localTextView);
          ShengpiziHbFragment.b(this.this$0, localTextView);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ShengpiziHbFragment.2
 * JD-Core Version:    0.7.0.1
 */