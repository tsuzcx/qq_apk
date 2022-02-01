package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class TroopAppShortcutContainer$AppsListViewAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LinkedHashMap<Integer, ArrayList<AppsBaseBuilder>> jdField_a_of_type_JavaUtilLinkedHashMap = new TroopAppShortcutContainer.AppsListViewAdapter.1(this);
  
  public TroopAppShortcutContainer$AppsListViewAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public AppsBaseBuilder a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int j = i + ((ArrayList)localEntry.getValue()).size();
      i = j;
      if (paramInt < j)
      {
        int k = paramInt - (j - ((ArrayList)localEntry.getValue()).size());
        i = j;
        if (k >= 0)
        {
          i = j;
          if (k < ((ArrayList)localEntry.getValue()).size()) {
            return (AppsBaseBuilder)((ArrayList)localEntry.getValue()).get(k);
          }
        }
      }
    }
    return null;
  }
  
  public void a(int paramInt, AppsBaseBuilder paramAppsBaseBuilder)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      ((ArrayList)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt))).clear();
      ((ArrayList)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt))).add(paramAppsBaseBuilder);
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List<AppsBaseBuilder> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      ((ArrayList)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt))).clear();
      ((ArrayList)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt))).addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((ArrayList)((Map.Entry)localIterator.next()).getValue()).size();
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    AppsBaseBuilder localAppsBaseBuilder = a(paramInt);
    if (localAppsBaseBuilder != null) {
      return localAppsBaseBuilder.a();
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    if (localObject != null) {
      localObject = ((AppsBaseBuilder)localObject).a(paramInt, paramView, paramViewGroup);
    } else {
      localObject = null;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.AppsListViewAdapter
 * JD-Core Version:    0.7.0.1
 */