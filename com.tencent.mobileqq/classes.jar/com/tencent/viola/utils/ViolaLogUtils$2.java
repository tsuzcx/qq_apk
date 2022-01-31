package com.tencent.viola.utils;

import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

final class ViolaLogUtils$2
  implements Runnable
{
  ViolaLogUtils$2(String paramString) {}
  
  public void run()
  {
    if ((ViolaLogUtils.access$200() != null) && (ViolaLogUtils.access$000() != null) && (ViolaLogUtils.access$100() != null))
    {
      if (ViolaLogUtils.access$300() != null) {
        break label77;
      }
      ViolaLogUtils.access$302(new StringBuilder().append(this.val$text));
    }
    for (;;)
    {
      ViolaLogUtils.access$000().setVisibility(0);
      ViolaLogUtils.access$100().setVisibility(0);
      ViolaLogUtils.access$200().setText(ViolaLogUtils.access$300().toString());
      ViolaLogUtils.access$100().setText("点击隐藏详细log");
      return;
      label77:
      ViolaLogUtils.access$300().append("\n").append(this.val$text);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.utils.ViolaLogUtils.2
 * JD-Core Version:    0.7.0.1
 */