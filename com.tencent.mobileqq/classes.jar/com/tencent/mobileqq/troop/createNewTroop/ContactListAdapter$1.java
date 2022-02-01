package com.tencent.mobileqq.troop.createNewTroop;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactListAdapter$1
  implements View.OnClickListener
{
  ContactListAdapter$1(ContactListAdapter paramContactListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)ContactListAdapter.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.1
 * JD-Core Version:    0.7.0.1
 */