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
        if (paramBoolean) {}
        for (int i = 2;; i = 4)
        {
          localAuthStateItem.authFlag = i;
          break;
        }
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
    boolean bool;
    label71:
    PermissionInfo localPermissionInfo;
    if (paramView != null)
    {
      localFormSwitchItem = (FormSwitchItem)paramView;
      localObject = getItem(paramInt);
      if (localObject != null)
      {
        if ((!QUAUtil.isQQApp()) && (!QUAUtil.isDemoApp()) && ("scope.appMsgSubscribed".equals(((AuthStateItem)localObject).scopeName)))
        {
          localFormSwitchItem.setEnabled(false);
          localFormSwitchItem.setChecked(false);
        }
        if (((AuthStateItem)localObject).authFlag != 2) {
          break label165;
        }
        bool = true;
        localFormSwitchItem.setChecked(bool);
        localFormSwitchItem.getSwitch().setTag(((AuthStateItem)localObject).scopeName);
        localPermissionInfo = PermissionManager.g().getScopePermission(((AuthStateItem)localObject).scopeName);
        if (localPermissionInfo == null) {
          break label171;
        }
      }
    }
    label165:
    label171:
    for (Object localObject = localPermissionInfo.name;; localObject = ((AuthStateItem)localObject).scopeName)
    {
      localFormSwitchItem.setText((CharSequence)localObject);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localFormSwitchItem;
      localFormSwitchItem = new FormSwitchItem(this.context);
      localFormSwitchItem.setOnCheckedChangeListener(this.checkedChangeListener);
      break;
      bool = false;
      break label71;
    }
  }
  
  public void setScopeList(List<AuthStateItem> paramList)
  {
    this.scopeList.clear();
    if (paramList != null) {
      this.scopeList.addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PermissionListAdapter
 * JD-Core Version:    0.7.0.1
 */