package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.IWeiYunImageEvent;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileWeiYunImageExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private float jdField_a_of_type_Float = 0.0F;
  public final int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private QfileCloudFileTabView.IWeiYunImageEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent;
  public final int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap<String, List<WeiYunFileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int jdField_c_of_type_Int = 50;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private int jdField_d_of_type_Int = 0;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener;
  
  public QfileWeiYunImageExpandableListAdapter(QfileCloudFileTabView.IWeiYunImageEvent paramIWeiYunImageEvent, BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener4)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_AndroidContentContext = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener3;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = paramOnClickListener4;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = paramIWeiYunImageEvent;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = ((int)(this.jdField_a_of_type_Float * 2.0F));
    this.jdField_c_of_type_Int = b();
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    QfileWeiYunImageExpandableListAdapter.GridGroupHolder localGridGroupHolder = (QfileWeiYunImageExpandableListAdapter.GridGroupHolder)paramView.getTag();
    int i = 0;
    while (i < 4)
    {
      View localView = b(paramInt1, paramInt2 * 4 + i, paramBoolean, localGridGroupHolder.a[i], paramViewGroup);
      if (localView == null) {
        return paramView;
      }
      localGridGroupHolder.a[i] = localView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        j = this.jdField_c_of_type_Int;
        localObject = new LinearLayout.LayoutParams(j, j);
      }
      int j = this.jdField_c_of_type_Int;
      ((LinearLayout.LayoutParams)localObject).width = j;
      ((LinearLayout.LayoutParams)localObject).height = j;
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = this.jdField_d_of_type_Int;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = this.jdField_d_of_type_Int;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.addView(localView);
      i += 1;
    }
    return paramView;
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new QfileWeiYunImageExpandableListAdapter.GridGroupHolder(null));
    return paramViewGroup;
  }
  
  private int b()
  {
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * 6.0F) / 4;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    Object localObject1;
    if (paramViewGroup != null) {
      localObject1 = (WeiYunFileInfo)paramViewGroup;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      if (a(paramInt1, paramInt2) == 1) {
        return null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.c()) {
        return null;
      }
      if (QLog.isDevelopLevel())
      {
        paramView = new StringBuilder();
        paramView.append("groupPosition[");
        paramView.append(paramInt1);
        paramView.append("],position[");
        paramView.append(paramInt2);
        paramView.append("] add getMoreButton");
        QLog.d("@#@#@#", 4, paramView.toString());
      }
      paramView = new ImageHolder();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560784, null);
      paramViewGroup.setClickable(true);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131380895));
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131376345));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131370354));
      paramView.jdField_a_of_type_Boolean = true;
      paramView.jdField_b_of_type_Int = paramInt1;
      paramView.jdField_a_of_type_Int = paramInt2;
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.a(paramView.jdField_a_of_type_AndroidWidgetTextView));
      paramViewGroup.setTag(paramView);
      if ((this.jdField_b_of_type_JavaUtilLinkedHashMap.size() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.a())) {
        paramViewGroup.setVisibility(8);
      } else {
        paramViewGroup.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.b())
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramView.c.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131692602);
        return paramViewGroup;
      }
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramView.c.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131692369);
      return paramViewGroup;
    }
    if (paramView == null) {
      paramViewGroup = paramView;
    }
    for (;;)
    {
      try
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560794, null);
        paramViewGroup = paramView;
        ImageHolder localImageHolder = new ImageHolder();
        paramViewGroup = paramView;
        localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368461));
        paramViewGroup = paramView;
        localImageHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368480));
        paramViewGroup = paramView;
        localImageHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368477));
        paramViewGroup = paramView;
        localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        paramViewGroup = paramView;
        localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        paramViewGroup = paramView;
        localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localImageHolder);
        paramViewGroup = paramView;
        localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(localImageHolder);
        paramViewGroup = paramView;
        localImageHolder.jdField_a_of_type_Boolean = false;
        paramViewGroup = paramView;
        paramView.setTag(localImageHolder);
        continue;
        paramViewGroup = paramView;
        localImageHolder = (ImageHolder)paramView.getTag();
        paramViewGroup = paramView;
        if (localImageHolder.jdField_a_of_type_Boolean)
        {
          paramViewGroup = paramView;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560794, null);
          paramViewGroup = paramView;
          localImageHolder = new ImageHolder();
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368461));
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368480));
          paramViewGroup = paramView;
          localImageHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368477));
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localImageHolder);
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(localImageHolder);
          paramViewGroup = paramView;
          paramView.setTag(localImageHolder);
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_JavaLangObject = localObject1;
          paramViewGroup = paramView;
          localImageHolder.jdField_b_of_type_Int = paramInt1;
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_Int = paramInt2;
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130848074);
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_Boolean = false;
          paramViewGroup = paramView;
          if (((WeiYunFileInfo)localObject1).h != null)
          {
            paramViewGroup = paramView;
            if (((WeiYunFileInfo)localObject1).h.length() > 0)
            {
              paramViewGroup = paramView;
              if (FileUtils.fileExistsAndNotEmpty(((WeiYunFileInfo)localObject1).h))
              {
                paramViewGroup = paramView;
                localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(((WeiYunFileInfo)localObject1).h);
              }
            }
          }
          paramViewGroup = paramView;
          Object localObject2 = new StringBuilder();
          paramViewGroup = paramView;
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692371));
          paramViewGroup = paramView;
          ((StringBuilder)localObject2).append(((WeiYunFileInfo)localObject1).c);
          paramViewGroup = paramView;
          localObject2 = ((StringBuilder)localObject2).toString();
          paramViewGroup = paramView;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
          {
            paramViewGroup = paramView;
            localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup = paramView;
            if (FMDataCache.a((WeiYunFileInfo)localObject1))
            {
              paramViewGroup = paramView;
              localObject1 = new StringBuilder();
              paramViewGroup = paramView;
              ((StringBuilder)localObject1).append((String)localObject2);
              paramViewGroup = paramView;
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692372));
              paramViewGroup = paramView;
              localObject1 = ((StringBuilder)localObject1).toString();
              paramViewGroup = paramView;
              localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840575);
              paramViewGroup = paramView;
              paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167394));
              paramViewGroup = paramView;
              paramView.setOnLongClickListener(null);
            }
            else
            {
              paramViewGroup = paramView;
              localObject1 = new StringBuilder();
              paramViewGroup = paramView;
              ((StringBuilder)localObject1).append((String)localObject2);
              paramViewGroup = paramView;
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131692373));
              paramViewGroup = paramView;
              localObject1 = ((StringBuilder)localObject1).toString();
              paramViewGroup = paramView;
              localImageHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
              paramViewGroup = paramView;
              localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845862);
              paramViewGroup = paramView;
              paramView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            }
          }
          else
          {
            paramViewGroup = paramView;
            localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            paramViewGroup = paramView;
            localImageHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            localObject1 = localObject2;
          }
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
          paramViewGroup = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject1);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        QLog.e("#######", 1, paramView.toString());
        return paramViewGroup;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int + this.jdField_d_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 + 1 < this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size()) {
      return 1;
    }
    List localList = (List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(getGroup(paramInt1));
    if (((localList == null) && (paramInt2 == 0)) || ((localList != null) && (paramInt2 == localList.size()))) {
      return 2;
    }
    return 1;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i == paramInt1)
      {
        localObject = (List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str);
        if (paramInt2 >= ((List)localObject).size()) {
          return null;
        }
        return ((List)localObject).get(paramInt2);
      }
      i += 1;
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
  }
  
  public int getChildrenCount(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt)
      {
        paramInt = ((List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str)).size();
        if (paramInt < 4) {
          return 1;
        }
        return paramInt / 4 + 1;
      }
      i += 1;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.c()) {
      return 1;
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public int getGroupCount()
  {
    if (this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size() > 0) {
      return this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.c()) {
      return 1;
    }
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */