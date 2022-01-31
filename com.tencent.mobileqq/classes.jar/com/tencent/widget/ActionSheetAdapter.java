package com.tencent.widget;

import amhw;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionSheetAdapter
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List jdField_a_of_type_JavaUtilList;
  
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
      paramContext = (GridView)View.inflate(paramContext, 2130971721, null);
      paramContext.setBackgroundResource(2130837540);
      paramContext.setAdapter(paramActionSheetAdapter);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localActionSheet.a(paramContext);
      localActionSheet.c(2131433029);
      if (paramBoolean) {
        localActionSheet.setOnDismissListener(new amhw(paramOnDismissListener));
      }
      for (;;)
      {
        localActionSheet.a(paramOnButtonClickListener);
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
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131435314;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838339;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131435345;
      return localObject1;
    case 2: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 2;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131435315;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838345;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131435346;
      return localObject1;
    case 0: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 0;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131433351;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838341;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131435347;
      return localObject1;
    case 1: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 1;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131435324;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838342;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131435348;
      return localObject1;
    case 5: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 5;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131430001;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130840523;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131429970;
      return localObject1;
    case 4: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 4;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838337;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131435325;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131435349;
      return localObject1;
    case 6: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 4;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838337;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131435326;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131435350;
      return localObject1;
    }
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 7;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838338;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131435327;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131435351;
    return localObject1;
  }
  
  public void a(List paramList)
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
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971697, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131366749);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131364341);
    if (localShareChanelInfo != null)
    {
      paramView.setImageResource(localShareChanelInfo.c);
      localTextView.setText(localShareChanelInfo.b);
    }
    for (;;)
    {
      if (AppSetting.b)
      {
        if (localShareChanelInfo == null) {
          break;
        }
        paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localShareChanelInfo.d));
      }
      return paramViewGroup;
      paramView.setImageResource(2130844804);
      localTextView.setText("");
    }
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */