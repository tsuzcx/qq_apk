package com.tencent.open.applist;

import android.widget.TextView;

class QZoneAppListActivity$2
  implements Runnable
{
  QZoneAppListActivity$2(QZoneAppListActivity paramQZoneAppListActivity, int paramInt) {}
  
  public void run()
  {
    TextView localTextView = QZoneAppListActivity.a(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.applist.QZoneAppListActivity.2
 * JD-Core Version:    0.7.0.1
 */