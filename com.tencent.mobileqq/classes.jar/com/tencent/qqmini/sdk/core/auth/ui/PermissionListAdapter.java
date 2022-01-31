package com.tencent.qqmini.sdk.core.auth.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.tencent.qqmini.sdk.core.auth.AuthStateItem;
import com.tencent.qqmini.sdk.core.auth.PermissionInfo;
import com.tencent.qqmini.sdk.core.auth.PermissionManager;
import com.tencent.qqmini.sdk.core.widget.FormSwitchItem;
import com.tencent.qqmini.sdk.utils.QUAUtil;
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
    boolean bool = false;
    PermissionInfo localPermissionInfo;
    if (paramView != null)
    {
      paramView = (FormSwitchItem)paramView;
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup != null)
      {
        if ((!QUAUtil.isQQApp()) && (!QUAUtil.isDemoApp()) && ("scope.appMsgSubscribed".equals(paramViewGroup.scopeName)))
        {
          paramView.setEnabled(false);
          paramView.setChecked(false);
        }
        if (paramViewGroup.authFlag == 2) {
          bool = true;
        }
        paramView.setChecked(bool);
        paramView.a().setTag(paramViewGroup.scopeName);
        localPermissionInfo = PermissionManager.g().getScopePermission(paramViewGroup.scopeName);
        if (localPermissionInfo == null) {
          break label137;
        }
      }
    }
    label137:
    for (paramViewGroup = localPermissionInfo.name;; paramViewGroup = paramViewGroup.scopeName)
    {
      paramView.setText(paramViewGroup);
      return paramView;
      paramView = new FormSwitchItem(this.context);
      paramView.setOnCheckedChangeListener(this.checkedChangeListener);
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.auth.ui.PermissionListAdapter
 * JD-Core Version:    0.7.0.1
 */