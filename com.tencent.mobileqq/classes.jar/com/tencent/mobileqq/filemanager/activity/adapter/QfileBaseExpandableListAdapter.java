package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.QQTextToSpeechHelper;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.SingleLineTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public abstract class QfileBaseExpandableListAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
{
  private ExpandableListView a;
  protected Context e;
  protected QfileBaseExpandableListAdapter.IQfileViewBinder f;
  Object g;
  LinkedHashMap<String, List<Object>> h = new LinkedHashMap();
  
  public QfileBaseExpandableListAdapter(Context paramContext, Object paramObject)
  {
    if (paramObject != null) {
      this.h = ((LinkedHashMap)paramObject);
    }
    this.e = paramContext;
  }
  
  protected List<Object> a(int paramInt)
  {
    Iterator localIterator = this.h.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != paramInt) {
        i += 1;
      } else {
        return (List)this.h.get(str);
      }
    }
    return null;
  }
  
  public void a(QfileBaseExpandableListAdapter.IQfileViewBinder paramIQfileViewBinder)
  {
    this.f = paramIQfileViewBinder;
  }
  
  public void a(ExpandableListView paramExpandableListView)
  {
    this.a = paramExpandableListView;
  }
  
  public void a(Object paramObject)
  {
    this.g = paramObject;
  }
  
  String b(int paramInt)
  {
    Iterator localIterator = this.h.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != paramInt) {
        i += 1;
      } else {
        return str;
      }
    }
    return null;
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    QfileBaseExpandableListAdapter.QfileGroupTag localQfileGroupTag2 = (QfileBaseExpandableListAdapter.QfileGroupTag)paramView.getTag();
    QfileBaseExpandableListAdapter.QfileGroupTag localQfileGroupTag1 = localQfileGroupTag2;
    if (localQfileGroupTag2 == null)
    {
      localQfileGroupTag1 = new QfileBaseExpandableListAdapter.QfileGroupTag();
      localQfileGroupTag1.b = ((SingleLineTextView)paramView.findViewById(2131434435));
      paramView.findViewById(2131431254).setVisibility(8);
      paramView.findViewById(2131436506).setVisibility(8);
      localQfileGroupTag1.c = ((CheckBox)paramView.findViewById(2131436369));
      paramView.setTag(localQfileGroupTag1);
    }
    paramView.setOnClickListener(new QfileBaseExpandableListAdapter.3(this, paramInt));
    localQfileGroupTag1.c.setChecked(this.a.isGroupExpanded(paramInt));
    paramView = (String)getGroup(paramInt);
    localQfileGroupTag1.b.setText(paramView);
    localQfileGroupTag1.c.setVisibility(0);
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    List localList = a(paramInt1);
    if ((localList != null) && (localList.size() > 0) && (paramInt2 < localList.size())) {
      return localList.get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = a(paramInt);
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return b(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.h.keySet().size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = (QfileBaseExpandableListAdapter.QfileGroupTag)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.e).inflate(2131627075, paramViewGroup, false);
      paramViewGroup = new QfileBaseExpandableListAdapter.QfileGroupTag();
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131434435));
      paramViewGroup.c = ((CheckBox)paramView.findViewById(2131436369));
      paramView.findViewById(2131431254).setVisibility(8);
      paramView.findViewById(2131436506).setVisibility(8);
      paramView.setTag(paramViewGroup);
    }
    paramView.setOnClickListener(new QfileBaseExpandableListAdapter.1(this, paramInt));
    if (AppSetting.e) {
      paramView.setAccessibilityDelegate(new CustomAccessibilityDelegate(paramView, new QfileBaseExpandableListAdapter.2(this, paramInt)));
    }
    paramViewGroup.c.setVisibility(0);
    paramViewGroup.c.setChecked(paramBoolean);
    paramViewGroup.c.setClickable(false);
    String str = (String)getGroup(paramInt);
    paramViewGroup.a = paramInt;
    paramViewGroup.b.setText(str);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131627075;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onGroupCollapsed(int paramInt)
  {
    super.onGroupCollapsed(paramInt);
    if (AppSetting.e)
    {
      String str = (String)getGroup(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131896104));
      QQTextToSpeechHelper.a(localStringBuilder.toString());
    }
  }
  
  public void onGroupExpanded(int paramInt)
  {
    super.onGroupExpanded(paramInt);
    if (AppSetting.e)
    {
      String str = (String)getGroup(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131896105));
      QQTextToSpeechHelper.a(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */