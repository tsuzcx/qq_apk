package com.tencent.mobileqq.mini.out.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.app.AuthorizeCenter.AuthorizeInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PermissionListAdapter
  extends BaseAdapter
{
  CompoundButton.OnCheckedChangeListener checkedChangeListener;
  Context context;
  protected LayoutInflater mInflater;
  List<AuthorizeCenter.AuthorizeInfo> scopeList;
  
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
      AuthorizeCenter.AuthorizeInfo localAuthorizeInfo = (AuthorizeCenter.AuthorizeInfo)localIterator.next();
      if (paramString.equals(localAuthorizeInfo.scopeName))
      {
        if (paramBoolean) {}
        for (int i = 2;; i = 4)
        {
          localAuthorizeInfo.authFlag = i;
          break;
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.scopeList.size();
  }
  
  public AuthorizeCenter.AuthorizeInfo getItem(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.scopeList.size())) {
      return (AuthorizeCenter.AuthorizeInfo)this.scopeList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AuthorizeCenter.AuthorizeInfo localAuthorizeInfo;
    boolean bool;
    if (paramView != null)
    {
      paramView = (FormSwitchItem)paramView;
      localAuthorizeInfo = getItem(paramInt);
      if (localAuthorizeInfo != null)
      {
        if (localAuthorizeInfo.authFlag != 2) {
          break label100;
        }
        bool = true;
        label33:
        paramView.setChecked(bool);
        paramView.a().setTag(localAuthorizeInfo.scopeName);
        paramViewGroup = (String)AuthorizeCenter.settingScopeTitleMap.get(localAuthorizeInfo.scopeName);
        if (paramViewGroup == null) {
          break label106;
        }
      }
    }
    for (;;)
    {
      paramView.setText(paramViewGroup);
      return paramView;
      paramView = new FormSwitchItem(this.context);
      paramView.setOnCheckedChangeListener(this.checkedChangeListener);
      break;
      label100:
      bool = false;
      break label33;
      label106:
      paramViewGroup = localAuthorizeInfo.scopeName;
    }
  }
  
  public void setScopeList(List<AuthorizeCenter.AuthorizeInfo> paramList)
  {
    this.scopeList.clear();
    if (paramList != null) {
      this.scopeList.addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionListAdapter
 * JD-Core Version:    0.7.0.1
 */