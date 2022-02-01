package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.auth.AuthStateItem;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.FormSwitchItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PermissionListAdapter
  extends BaseAdapter
{
  CompoundButton.OnCheckedChangeListener checkedChangeListener;
  Context context;
  protected LayoutInflater mInflater;
  List<AuthStateItem> scopeList;
  
  public PermissionListAdapter(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.context = paramContext;
    this.checkedChangeListener = paramOnCheckedChangeListener;
    this.mInflater = LayoutInflater.from(paramContext);
    this.scopeList = new ArrayList();
  }
  
  public void changeChecked(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.scopeList.iterator();
    while (localIterator.hasNext())
    {
      AuthStateItem localAuthStateItem = (AuthStateItem)localIterator.next();
      if (paramString.equals(localAuthStateItem.scopeName))
      {
        int i;
        if (paramBoolean) {
          i = 2;
        } else {
          i = 4;
        }
        localAuthStateItem.authFlag = i;
      }
    }
  }
  
  public int getCount()
  {
    return this.scopeList.size();
  }
  
  public AuthStateItem getItem(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.scopeList.size())) {
      return (AuthStateItem)this.scopeList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FormSwitchItem localFormSwitchItem;
    if (paramView != null)
    {
      localFormSwitchItem = (FormSwitchItem)paramView;
    }
    else
    {
      localFormSwitchItem = new FormSwitchItem(this.context);
      localFormSwitchItem.setOnCheckedChangeListener(this.checkedChangeListener);
    }
    Object localObject = getItem(paramInt);
    if (localObject != null)
    {
      boolean bool2 = QUAUtil.isQQApp();
      boolean bool1 = false;
      if ((!bool2) && (!QUAUtil.isDemoApp()) && ("scope.appMsgSubscribed".equals(((AuthStateItem)localObject).scopeName)))
      {
        localFormSwitchItem.setEnabled(false);
        localFormSwitchItem.setChecked(false);
      }
      if (((AuthStateItem)localObject).authFlag == 2) {
        bool1 = true;
      }
      localFormSwitchItem.setChecked(bool1);
      localFormSwitchItem.getSwitch().setTag(((AuthStateItem)localObject).scopeName);
      PermissionInfo localPermissionInfo = PermissionManager.g().getScopePermission(((AuthStateItem)localObject).scopeName);
      if (localPermissionInfo != null) {
        localObject = localPermissionInfo.name;
      } else {
        localObject = ((AuthStateItem)localObject).scopeName;
      }
      localFormSwitchItem.setText((CharSequence)localObject);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localFormSwitchItem;
  }
  
  public void setScopeList(List<AuthStateItem> paramList)
  {
    this.scopeList.clear();
    if (paramList != null) {
      this.scopeList.addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PermissionListAdapter
 * JD-Core Version:    0.7.0.1
 */