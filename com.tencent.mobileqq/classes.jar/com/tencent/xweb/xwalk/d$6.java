package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.xwalk.core.XWalkInitializer;

class d$6
  implements View.OnClickListener
{
  d$6(d paramd) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)d.d(this.a).findViewById(2131448908);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.a(true));
    localStringBuilder.append("\n");
    localStringBuilder.append(XWalkInitializer.getXWalkInitializeLog());
    localTextView.setText(localStringBuilder.toString());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.6
 * JD-Core Version:    0.7.0.1
 */