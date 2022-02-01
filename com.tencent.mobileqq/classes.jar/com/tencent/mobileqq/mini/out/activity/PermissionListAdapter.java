package com.tencent.mobileqq.mini.out.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anvx;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.app.AuthorizeCenter.AuthorizeInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
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
  public static final int VIEW_TYPE_COUNT = 2;
  public static final int VIEW_TYPE_FORM_SIMPLE_ITEM = 1;
  public static final int VIEW_TYPE_FORM_SWITCH_ITEM = 0;
  CompoundButton.OnCheckedChangeListener checkedChangeListener;
  Context context;
  protected LayoutInflater mInflater;
  List<AuthorizeCenter.AuthorizeInfo> scopeList;
  View.OnClickListener subMsgPermissionClickListener;
  
  public PermissionListAdapter(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, View.OnClickListener paramOnClickListener)
  {
    this.context = paramContext;
    this.checkedChangeListener = paramOnCheckedChangeListener;
    this.subMsgPermissionClickListener = paramOnClickListener;
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
  
  public int getItemViewType(int paramInt)
  {
    AuthorizeCenter.AuthorizeInfo localAuthorizeInfo = getItem(paramInt);
    if ((localAuthorizeInfo != null) && ("setting.appMsgSubscribed".equals(localAuthorizeInfo.scopeName))) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AuthorizeCenter.AuthorizeInfo localAuthorizeInfo = getItem(paramInt);
    Object localObject;
    if (localAuthorizeInfo != null) {
      if ("setting.appMsgSubscribed".equals(localAuthorizeInfo.scopeName))
      {
        localObject = new FormSimpleItem(this.context);
        ((FormSimpleItem)localObject).a(true);
        ((FormSimpleItem)localObject).setLeftText(anvx.a(2131693982));
        ((FormSimpleItem)localObject).setOnClickListener(this.subMsgPermissionClickListener);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      label93:
      boolean bool;
      label118:
      String str;
      if ((paramView instanceof FormSwitchItem))
      {
        localObject = (FormSwitchItem)paramView;
        ((FormSwitchItem)localObject).a().setTag(localAuthorizeInfo.scopeName);
        if (localAuthorizeInfo.authFlag != 2) {
          break label181;
        }
        bool = true;
        ((FormSwitchItem)localObject).setChecked(bool);
        ((FormSwitchItem)localObject).setOnCheckedChangeListener(this.checkedChangeListener);
        str = (String)AuthorizeCenter.settingScopeTitleMap.get(localAuthorizeInfo.scopeName);
        if (str == null) {
          break label187;
        }
      }
      for (;;)
      {
        ((FormSwitchItem)localObject).setText(str);
        break;
        localObject = new FormSwitchItem(this.context);
        break label93;
        label181:
        bool = false;
        break label118;
        label187:
        str = localAuthorizeInfo.scopeName;
      }
      localObject = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setScopeList(List<AuthorizeCenter.AuthorizeInfo> paramList)
  {
    this.scopeList.clear();
    if (paramList != null) {
      this.scopeList.addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionListAdapter
 * JD-Core Version:    0.7.0.1
 */