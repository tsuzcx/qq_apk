package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GroupPadTemplateAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public static int a = 1;
  public static int b = 2;
  Context jdField_a_of_type_AndroidContentContext;
  protected View.OnClickListener a;
  final List<GroupPadTemplateInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private Set<String> b;
  
  public GroupPadTemplateAdapter(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(AsyncImageView paramAsyncImageView, GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    if (paramGroupPadTemplateInfo != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840307);
      if (!URLUtil.a(paramGroupPadTemplateInfo.mobThumbUrl))
      {
        paramAsyncImageView.setImageDrawable(localDrawable);
        return;
      }
      String str = paramGroupPadTemplateInfo.mobThumbUrl;
      paramGroupPadTemplateInfo = URLDrawable.URLDrawableOptions.obtain();
      paramGroupPadTemplateInfo.mLoadingDrawable = localDrawable;
      paramGroupPadTemplateInfo.mFailedDrawable = localDrawable;
      Object localObject = null;
      try
      {
        paramGroupPadTemplateInfo = URLDrawable.getDrawable(str, paramGroupPadTemplateInfo);
      }
      catch (Exception localException)
      {
        paramGroupPadTemplateInfo = localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("GroupPadTemplateAdapter", 2, localException, new Object[] { "loadThumbImage failed" });
          paramGroupPadTemplateInfo = localObject;
        }
      }
      if (paramGroupPadTemplateInfo != null)
      {
        if ((paramGroupPadTemplateInfo.getStatus() == 2) && (this.jdField_b_of_type_JavaUtilSet.remove(str))) {
          paramGroupPadTemplateInfo.restartDownload();
        }
        paramGroupPadTemplateInfo.setDownloadListener(new GroupPadTemplateAdapter.1(this, str));
        paramAsyncImageView.setImageDrawable(paramGroupPadTemplateInfo);
        if (QLog.isColorLevel())
        {
          paramAsyncImageView = new StringBuilder();
          paramAsyncImageView.append("loadThumbImage is ok. url: ");
          paramAsyncImageView.append(str);
          QLog.d("GroupPadTemplateAdapter", 2, paramAsyncImageView.toString());
        }
      }
      else
      {
        paramAsyncImageView.setImageDrawable(localDrawable);
      }
    }
    else
    {
      paramAsyncImageView.setImageResource(2130840307);
    }
  }
  
  public GroupPadTemplateInfo a()
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = new GroupPadTemplateInfo();
    localGroupPadTemplateInfo.docOrSheetType = 1;
    localGroupPadTemplateInfo.templateName = this.jdField_a_of_type_AndroidContentContext.getString(2131693078);
    return localGroupPadTemplateInfo;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(List<GroupPadTemplateInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)paramList.next();
        if ((localGroupPadTemplateInfo != null) && (localGroupPadTemplateInfo.templateID >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localGroupPadTemplateInfo);
        }
      }
      paramList = a();
      this.jdField_a_of_type_JavaUtilList.add(paramList);
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
    GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)getItem(paramInt);
    if (localGroupPadTemplateInfo != null) {
      return localGroupPadTemplateInfo.templateID;
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)getItem(paramInt);
    GroupPadTemplateAdapter.GroupPadTemplateItemHolder localGroupPadTemplateItemHolder;
    if (getCount() == paramInt + 1)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559210, null);
      localGroupPadTemplateItemHolder = new GroupPadTemplateAdapter.GroupPadTemplateItemHolder(this);
      localGroupPadTemplateItemHolder.jdField_a_of_type_Int = jdField_b_of_type_Int;
      localGroupPadTemplateItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367866));
      localGroupPadTemplateItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367862));
      localGroupPadTemplateItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367860));
      localGroupPadTemplateItemHolder.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo = localGroupPadTemplateInfo;
      paramView.setTag(localGroupPadTemplateItemHolder);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559209, null);
      localGroupPadTemplateItemHolder = new GroupPadTemplateAdapter.GroupPadTemplateItemHolder(this);
      localGroupPadTemplateItemHolder.jdField_a_of_type_Int = jdField_a_of_type_Int;
      localGroupPadTemplateItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367865));
      localGroupPadTemplateItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367864));
      localGroupPadTemplateItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367859));
      localGroupPadTemplateItemHolder.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo = localGroupPadTemplateInfo;
      paramView.setTag(localGroupPadTemplateItemHolder);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    if (localGroupPadTemplateItemHolder.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo != null)
    {
      if (localGroupPadTemplateItemHolder.jdField_a_of_type_Int == jdField_a_of_type_Int) {
        a(localGroupPadTemplateItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localGroupPadTemplateInfo);
      } else if (localGroupPadTemplateItemHolder.jdField_a_of_type_Int == jdField_b_of_type_Int) {
        localGroupPadTemplateItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130840309);
      }
      localGroupPadTemplateItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localGroupPadTemplateInfo.templateName);
    }
    else
    {
      localGroupPadTemplateItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130840307);
      localGroupPadTemplateItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    if (AppSetting.d) {
      if (localGroupPadTemplateInfo != null) {
        paramView.setContentDescription(localGroupPadTemplateInfo.templateName);
      } else {
        paramView.setContentDescription("");
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */