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
      StringBuilder localStringBuilder;
      if (ViolaLogUtils.access$300() == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.val$text);
        ViolaLogUtils.access$302(localStringBuilder);
      }
      else
      {
        localStringBuilder = ViolaLogUtils.access$300();
        localStringBuilder.append("\n");
        localStringBuilder.append(this.val$text);
      }
      ViolaLogUtils.access$000().setVisibility(0);
      ViolaLogUtils.access$100().setVisibility(0);
      ViolaLogUtils.access$200().setText(ViolaLogUtils.access$300().toString());
      ViolaLogUtils.access$100().setText("点击隐藏详细log");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.utils.ViolaLogUtils.2
 * JD-Core Version:    0.7.0.1
 */