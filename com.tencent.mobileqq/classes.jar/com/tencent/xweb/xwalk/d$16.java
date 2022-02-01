package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class d$16
  implements AdapterView.OnItemSelectedListener
{
  d$16(d paramd) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.b().getResources().getStringArray(2130968656);
    d.a(this.a, paramAdapterView[paramInt]);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.16
 * JD-Core Version:    0.7.0.1
 */