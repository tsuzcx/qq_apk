package com.tencent.mobileqq.troop.homework.entry.ui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class HomeWorkTroopSelectorFragment$1
  implements View.OnClickListener
{
  HomeWorkTroopSelectorFragment$1(HomeWorkTroopSelectorFragment paramHomeWorkTroopSelectorFragment) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (HomeWorkTroopSelectorFragment.a(this.a) != null)
    {
      int j = HomeWorkTroopSelectorFragment.a(this.a).getCount();
      int i = 0;
      while (i < j)
      {
        localObject = (HomeWorkTroopSelectorFragment.MyPair)HomeWorkTroopSelectorFragment.a(this.a).getItem(i);
        if ((((Boolean)((HomeWorkTroopSelectorFragment.MyPair)localObject).b).booleanValue()) && (!HomeWorkTroopSelectorFragment.a(this.a).equals(((TroopInfo)((HomeWorkTroopSelectorFragment.MyPair)localObject).a).troopuin)))
        {
          localArrayList1.add(((TroopInfo)((HomeWorkTroopSelectorFragment.MyPair)localObject).a).troopname);
          localArrayList2.add(((TroopInfo)((HomeWorkTroopSelectorFragment.MyPair)localObject).a).troopuin);
        }
        i += 1;
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).putStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key", localArrayList2);
    ((Intent)localObject).putStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key", localArrayList1);
    this.a.getActivity().setResult(262, (Intent)localObject);
    this.a.getActivity().doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.1
 * JD-Core Version:    0.7.0.1
 */