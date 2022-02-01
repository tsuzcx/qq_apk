package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PresetWordsListAdapter$ViewHolder
  implements View.OnClickListener
{
  int a;
  TextView b;
  TextView c;
  
  public PresetWordsListAdapter$ViewHolder(PresetWordsListAdapter paramPresetWordsListAdapter) {}
  
  public void onClick(View paramView)
  {
    if (this.d.c != null) {
      this.d.c.a(paramView, this.a, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PresetWordsListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */