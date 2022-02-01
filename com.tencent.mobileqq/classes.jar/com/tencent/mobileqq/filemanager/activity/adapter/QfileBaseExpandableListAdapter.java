package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
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
  protected QfileBaseExpandableListAdapter.IQfileViewBinder a;
  private ExpandableListView jdField_a_of_type_ComTencentWidgetExpandableListView;
  Object jdField_a_of_type_JavaLangObject;
  LinkedHashMap<String, List<Object>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  protected Context b;
  
  public QfileBaseExpandableListAdapter(Context paramContext, Object paramObject)
  {
    if (paramObject != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    }
    this.b = paramContext;
  }
  
  String a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (i == paramInt) {
        return str;
      }
      i += 1;
    }
    String str = null;
    return str;
  }
  
  protected List<Object> a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != paramInt) {
        i += 1;
      } else {
        return (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
      }
    }
    return null;
  }
  
  public void a(QfileBaseExpandableListAdapter.IQfileViewBinder paramIQfileViewBinder)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder = paramIQfileViewBinder;
  }
  
  public void a(ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    QfileBaseExpandableListAdapter.QfileGroupTag localQfileGroupTag = (QfileBaseExpandableListAdapter.QfileGroupTag)paramView.getTag();
    if (localQfileGroupTag == null)
    {
      localQfileGroupTag = new QfileBaseExpandableListAdapter.QfileGroupTag();
      localQfileGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131368102));
      paramView.findViewById(2131365230).setVisibility(8);
      paramView.findViewById(2131369760).setVisibility(8);
      localQfileGroupTag.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369653));
      paramView.setTag(localQfileGroupTag);
    }
    for (;;)
    {
      paramView.setOnClickListener(new QfileBaseExpandableListAdapter.3(this, paramInt));
      localQfileGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
      paramView = (String)getGroup(paramInt);
      localQfileGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
      localQfileGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      return;
    }
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
    return a(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (QfileBaseExpandableListAdapter.QfileGroupTag)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(new QfileBaseExpandableListAdapter.1(this, paramInt));
      if (AppSetting.d) {
        paramViewGroup.setAccessibilityDelegate(new CustomAccessibilityDelegate(paramViewGroup, new QfileBaseExpandableListAdapter.2(this, paramInt)));
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
      localObject = (String)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.b).inflate(2131559024, paramViewGroup, false);
      paramView = new QfileBaseExpandableListAdapter.QfileGroupTag();
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131368102));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131369653));
      paramViewGroup.findViewById(2131365230).setVisibility(8);
      paramViewGroup.findViewById(2131369760).setVisibility(8);
      paramViewGroup.setTag(paramView);
    }
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131559024;
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
    if (AppSetting.d)
    {
      String str = (String)getGroup(paramInt);
      QQAppInterface.speak(str + HardCodeUtil.a(2131709580));
    }
  }
  
  public void onGroupExpanded(int paramInt)
  {
    super.onGroupExpanded(paramInt);
    if (AppSetting.d)
    {
      String str = (String)getGroup(paramInt);
      QQAppInterface.speak(str + HardCodeUtil.a(2131709600));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */