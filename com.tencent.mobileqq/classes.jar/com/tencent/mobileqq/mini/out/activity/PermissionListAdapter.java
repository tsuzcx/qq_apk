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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    AuthorizeCenter.AuthorizeInfo localAuthorizeInfo = getItem(paramInt);
    FormSwitchItem localFormSwitchItem;
    boolean bool;
    label50:
    String str;
    if (localAuthorizeInfo != null) {
      if ((paramView instanceof FormSwitchItem))
      {
        localFormSwitchItem = (FormSwitchItem)paramView;
        localFormSwitchItem.a().setTag(localAuthorizeInfo.scopeName);
        if (localAuthorizeInfo.authFlag != 2) {
          break label127;
        }
        bool = true;
        localFormSwitchItem.setChecked(bool);
        str = (String)AuthorizeCenter.settingScopeTitleMap.get(localAuthorizeInfo.scopeName);
        if (str == null) {
          break label133;
        }
        label78:
        localFormSwitchItem.setText(str);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localFormSwitchItem;
      localFormSwitchItem = new FormSwitchItem(this.context);
      localFormSwitchItem.setOnCheckedChangeListener(this.checkedChangeListener);
      break;
      label127:
      bool = false;
      break label50;
      label133:
      str = localAuthorizeInfo.scopeName;
      break label78;
      localFormSwitchItem = null;
    }
  }
  
  public void setScopeList(List<AuthorizeCenter.AuthorizeInfo> paramList)
  {
    this.scopeList.clear();
    int i;
    if (paramList != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramList.size())
      {
        AuthorizeCenter.AuthorizeInfo localAuthorizeInfo = (AuthorizeCenter.AuthorizeInfo)paramList.get(i);
        if ("setting.appMsgSubscribed".equals(localAuthorizeInfo.scopeName)) {
          paramList.remove(localAuthorizeInfo);
        }
      }
      else
      {
        this.scopeList.addAll(paramList);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionListAdapter
 * JD-Core Version:    0.7.0.1
 */