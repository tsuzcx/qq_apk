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
    if (paramContext != null)
    {
      if (paramActionSheetAdapter == null) {
        return null;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131563177, null);
      paramContext.setBackgroundResource(2130837588);
      paramContext.setAdapter(paramActionSheetAdapter);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localActionSheet.addView(paramContext);
      localActionSheet.addCancelButton(2131690800);
      if (paramBoolean) {
        localActionSheet.setOnDismissListener(new ActionSheetAdapter.CustomDismissListener(paramOnDismissListener));
      }
      for (;;)
      {
        localActionSheet.setOnButtonClickListener(paramOnButtonClickListener);
        return localActionSheet;
        localActionSheet.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static ActionSheetAdapter.ShareChanelInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new ActionSheetAdapter.ShareChanelInfo();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 3;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131719314;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130839212;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131719742;
      return localObject1;
    case 2: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 2;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131719323;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130839218;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131719760;
      return localObject1;
    case 0: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 0;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131692706;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130839214;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131719752;
      return localObject1;
    case 1: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 1;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131719318;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130839215;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131719753;
      return localObject1;
    case 5: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 5;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131717005;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130842649;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131692179;
      return localObject1;
    case 4: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 4;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130839210;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131719302;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131719735;
      return localObject1;
    case 6: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 4;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130839210;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131719300;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131719741;
      return localObject1;
    }
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 7;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130839211;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131719290;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131719738;
    return localObject1;
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
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563141, null);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131362887);
      TextView localTextView = (TextView)paramView.findViewById(2131362899);
      if (localShareChanelInfo != null)
      {
        localImageView.setImageResource(localShareChanelInfo.c);
        localTextView.setText(localShareChanelInfo.b);
        if (AppSetting.d)
        {
          if (localShareChanelInfo == null) {
            break label135;
          }
          paramView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localShareChanelInfo.d));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localImageView.setImageResource(2130848581);
        localTextView.setText("");
        break;
        label135:
        paramView.setContentDescription("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */