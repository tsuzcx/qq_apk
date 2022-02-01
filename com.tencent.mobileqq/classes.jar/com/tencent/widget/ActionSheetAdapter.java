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
  Context a;
  final List<ActionSheetAdapter.ShareChanelInfo> b;
  
  public ActionSheetAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
  }
  
  public static ActionSheet a(Context paramContext, ActionSheetAdapter paramActionSheetAdapter, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, ActionSheet.OnButtonClickListener paramOnButtonClickListener, boolean paramBoolean)
  {
    ActionSheet localActionSheet = null;
    if (paramContext != null)
    {
      if (paramActionSheetAdapter == null) {
        return null;
      }
      localActionSheet = (ActionSheet)ActionSheetHelper.b(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131629609, null);
      paramContext.setBackgroundResource(2130837699);
      paramContext.setAdapter(paramActionSheetAdapter);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localActionSheet.addView(paramContext);
      localActionSheet.addCancelButton(2131887648);
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
        localShareChanelInfo.c = 2130839218;
        localShareChanelInfo.b = 2131916543;
        localShareChanelInfo.d = 2131917024;
        return localShareChanelInfo;
      case 6: 
        localShareChanelInfo.a = 4;
        localShareChanelInfo.c = 2130839217;
        localShareChanelInfo.b = 2131916553;
        localShareChanelInfo.d = 2131917027;
        return localShareChanelInfo;
      case 5: 
        localShareChanelInfo.a = 5;
        localShareChanelInfo.b = 2131914121;
        localShareChanelInfo.c = 2130843501;
        localShareChanelInfo.d = 2131889086;
        return localShareChanelInfo;
      case 4: 
        localShareChanelInfo.a = 4;
        localShareChanelInfo.c = 2130839217;
        localShareChanelInfo.b = 2131916556;
        localShareChanelInfo.d = 2131917020;
        return localShareChanelInfo;
      case 3: 
        localShareChanelInfo.a = 3;
        localShareChanelInfo.b = 2131916568;
        localShareChanelInfo.c = 2130839219;
        localShareChanelInfo.d = 2131917028;
        return localShareChanelInfo;
      case 2: 
        localShareChanelInfo.a = 2;
        localShareChanelInfo.b = 2131916577;
        localShareChanelInfo.c = 2130839225;
        localShareChanelInfo.d = 2131917047;
        return localShareChanelInfo;
      case 1: 
        localShareChanelInfo.a = 1;
        localShareChanelInfo.b = 2131916572;
        localShareChanelInfo.c = 2130839222;
        localShareChanelInfo.d = 2131917040;
        return localShareChanelInfo;
      }
      localShareChanelInfo.a = 0;
      localShareChanelInfo.b = 2131889688;
      localShareChanelInfo.c = 2130839221;
      localShareChanelInfo.d = 2131917039;
      return localShareChanelInfo;
    }
    return null;
  }
  
  public void a(List<ActionSheetAdapter.ShareChanelInfo> paramList)
  {
    this.b.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)paramList.next();
        if ((localShareChanelInfo != null) && (localShareChanelInfo.a >= 0)) {
          this.b.add(localShareChanelInfo);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
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
      localView = LayoutInflater.from(this.a).inflate(2131629572, null);
    }
    paramView = (ImageView)localView.findViewById(2131428619);
    TextView localTextView = (TextView)localView.findViewById(2131428632);
    if (localShareChanelInfo != null)
    {
      paramView.setImageResource(localShareChanelInfo.c);
      localTextView.setText(localShareChanelInfo.b);
    }
    else
    {
      paramView.setImageResource(2130850126);
      localTextView.setText("");
    }
    if (AppSetting.e) {
      if (localShareChanelInfo != null) {
        localView.setContentDescription(this.a.getString(localShareChanelInfo.d));
      } else {
        localView.setContentDescription("");
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */