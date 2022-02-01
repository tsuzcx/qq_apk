package com.tencent.widget;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionSheetAdapter
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<ActionSheetAdapter.ShareChanelInfo> jdField_a_of_type_JavaUtilList;
  
  public ActionSheetAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static ActionSheet a(Context paramContext, ActionSheetAdapter paramActionSheetAdapter, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, ActionSheet.OnButtonClickListener paramOnButtonClickListener, boolean paramBoolean)
  {
    ActionSheet localActionSheet = null;
    if (paramContext != null)
    {
      if (paramActionSheetAdapter == null) {
        return null;
      }
      localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131563001, null);
      paramContext.setBackgroundResource(2130837675);
      paramContext.setAdapter(paramActionSheetAdapter);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localActionSheet.addView(paramContext);
      localActionSheet.addCancelButton(2131690728);
      if (paramBoolean) {
        localActionSheet.setOnDismissListener(new ActionSheetAdapter.CustomDismissListener(paramOnDismissListener));
      } else {
        localActionSheet.setOnDismissListener(paramOnDismissListener);
      }
      localActionSheet.setOnButtonClickListener(paramOnButtonClickListener);
    }
    return localActionSheet;
  }
  
  public static ActionSheetAdapter.ShareChanelInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 7))
    {
      ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = new ActionSheetAdapter.ShareChanelInfo();
      switch (paramInt)
      {
      default: 
        return localShareChanelInfo;
      case 7: 
        localShareChanelInfo.a = 7;
        localShareChanelInfo.c = 2130839064;
        localShareChanelInfo.b = 2131719008;
        localShareChanelInfo.d = 2131719462;
        return localShareChanelInfo;
      case 6: 
        localShareChanelInfo.a = 4;
        localShareChanelInfo.c = 2130839063;
        localShareChanelInfo.b = 2131719018;
        localShareChanelInfo.d = 2131719465;
        return localShareChanelInfo;
      case 5: 
        localShareChanelInfo.a = 5;
        localShareChanelInfo.b = 2131716658;
        localShareChanelInfo.c = 2130842548;
        localShareChanelInfo.d = 2131692105;
        return localShareChanelInfo;
      case 4: 
        localShareChanelInfo.a = 4;
        localShareChanelInfo.c = 2130839063;
        localShareChanelInfo.b = 2131719020;
        localShareChanelInfo.d = 2131719459;
        return localShareChanelInfo;
      case 3: 
        localShareChanelInfo.a = 3;
        localShareChanelInfo.b = 2131719032;
        localShareChanelInfo.c = 2130839065;
        localShareChanelInfo.d = 2131719466;
        return localShareChanelInfo;
      case 2: 
        localShareChanelInfo.a = 2;
        localShareChanelInfo.b = 2131719041;
        localShareChanelInfo.c = 2130839071;
        localShareChanelInfo.d = 2131719484;
        return localShareChanelInfo;
      case 1: 
        localShareChanelInfo.a = 1;
        localShareChanelInfo.b = 2131719036;
        localShareChanelInfo.c = 2130839068;
        localShareChanelInfo.d = 2131719477;
        return localShareChanelInfo;
      }
      localShareChanelInfo.a = 0;
      localShareChanelInfo.b = 2131692663;
      localShareChanelInfo.c = 2130839067;
      localShareChanelInfo.d = 2131719476;
      return localShareChanelInfo;
    }
    return null;
  }
  
  public void a(List<ActionSheetAdapter.ShareChanelInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)paramList.next();
        if ((localShareChanelInfo != null) && (localShareChanelInfo.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localShareChanelInfo);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)getItem(paramInt);
    if (localShareChanelInfo != null) {
      return localShareChanelInfo.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)getItem(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562964, null);
    }
    paramView = (ImageView)localView.findViewById(2131362839);
    TextView localTextView = (TextView)localView.findViewById(2131362851);
    if (localShareChanelInfo != null)
    {
      paramView.setImageResource(localShareChanelInfo.c);
      localTextView.setText(localShareChanelInfo.b);
    }
    else
    {
      paramView.setImageResource(2130848460);
      localTextView.setText("");
    }
    if (AppSetting.d) {
      if (localShareChanelInfo != null) {
        localView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localShareChanelInfo.d));
      } else {
        localView.setContentDescription("");
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */