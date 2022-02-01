package com.tencent.xweb.xwalk;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.v;

class d$45
  implements CompoundButton.OnCheckedChangeListener
{
  d$45(d paramd) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    v.a().e(paramBoolean);
    if (paramBoolean)
    {
      d.e(this.a);
      this.a.c.setVisibility(0);
    }
    else if (this.a.c != null)
    {
      this.a.c.setVisibility(8);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.45
 * JD-Core Version:    0.7.0.1
 */