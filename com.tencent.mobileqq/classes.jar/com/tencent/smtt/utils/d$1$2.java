package com.tencent.smtt.utils;

import android.widget.TextView;

class d$1$2
  implements Runnable
{
  d$1$2(d.1 param1, int paramInt) {}
  
  public void run()
  {
    TextView localTextView = this.b.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("已下载");
    localStringBuilder.append(this.a);
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.d.1.2
 * JD-Core Version:    0.7.0.1
 */