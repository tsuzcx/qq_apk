package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.f.b;

class d$27
  implements View.OnClickListener
{
  d$27(d paramd, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    d.a(this.b, this.a.getText().toString(), f.b.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.27
 * JD-Core Version:    0.7.0.1
 */